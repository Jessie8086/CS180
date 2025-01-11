import java.util.Objects;

/**
 * A SCP class
 *
 * <p>Purdue University -- CS18000 -- Spring 2024</p>
 *
 * @author Jiauxn Li
 * @version March 26, 2024
 */
public class SCP {
    private int itemNumber;
    private String objectName;
    private String objectClass;
    private int clearanceLevel;
    private Researcher[] researchers;
    boolean contact;
    boolean label = false;

    public SCP(String data) throws BadDataException {
        String prefix = "SCP-";
        String remainingSCP = data.substring(prefix.length());
        String[] elementsOfSCP = remainingSCP.split(",");
        String[] classificationsSCP = {"SAFE", "EUCLID", "KETER", "THAUMIEL",
                "NEUTRALIZED", "DECOMMISSIONED", "APOLLYON", "ARCHON"};
        String itemString;
        boolean b = true;

        int number = Integer.parseInt(elementsOfSCP[0]);
        if (number < 100) {
            itemString = String.format("%03d", number);
        } else {
            itemString = String.valueOf(number);
        }

        if (elementsOfSCP.length != 5) {
            throw new BadDataException("SCP-" + itemString + ": Bad SCP Data");
        } else {
            for (String part : elementsOfSCP) {
                if (part.isEmpty()) {
                    throw new BadDataException("SCP-" + itemString + ": Bad SCP Data");
                }
            }
        }

        for (String classificationSCP : classificationsSCP) {
            if (classificationSCP.equals(elementsOfSCP[2])) {
                this.objectClass = elementsOfSCP[2];
                b = false;
                break;
            }
        }
        if (b) {
            throw new BadDataException("SCP-" + itemString + ": Bad SCP Data");
        }

        try {
            this.itemNumber = number;
            this.objectName = elementsOfSCP[1];
            this.clearanceLevel = Integer.parseInt(elementsOfSCP[3]);
            this.contact = Boolean.parseBoolean(elementsOfSCP[4]);
        } catch (Exception e) {
            throw new BadDataException("SCP-" + itemString + ": Bad SCP Data");
        }
    }

    public SCP(BadDataException e) {
        int dashIndex = e.getMessage().indexOf("-");
        int colonIndex = e.getMessage().indexOf(":");
        this.itemNumber = Integer.parseInt(e.getMessage().substring(dashIndex + 1, colonIndex));
        this.objectName = "Bad SCP Data";
        this.objectClass = null;
        this.clearanceLevel = 0;
        this.contact = false;
        this.label = true;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SCP)) {
            return false;
        }
        SCP scp = (SCP) o;
        if (this.label || scp.label) {
            return false;
        }
        return this.itemNumber == scp.itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public void setObjectClass(String objectClass) {
        this.objectClass = objectClass;
    }

    public void setClearanceLevel(int clearanceLevel) {
        this.clearanceLevel = clearanceLevel;
    }

    public void setResearchers(Researcher[] researchers) {
        this.researchers = researchers;
    }

    public Researcher[] getResearchers() {
        return researchers;
    }

    public void setContact(boolean contact) {
        this.contact = contact;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getObjectClass() {
        return objectClass;
    }

    public int getClearanceLevel() {
        return clearanceLevel;
    }

    public boolean isContact() {
        return contact;
    }

    public String toString() {
        String itemString;
        if (this.itemNumber < 100) {
            itemString = String.format("%03d", this.itemNumber);
        } else {
            itemString = String.valueOf(this.itemNumber);
        }
        return "SCP-" + itemString + "," + this.objectName + "," +
                this.objectClass + "," + this.clearanceLevel + "," + this.contact;
    }

}
