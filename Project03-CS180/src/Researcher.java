import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * A Researcher class
 *
 * <p>Purdue University -- CS18000 -- Spring 2024</p>
 *
 * @author Jiauxn Li
 * @version March 26, 2024
 */
public class Researcher {
    private String name;
    private int idNumber;
    private int clearance;
    private char classification;
    private boolean active;
    boolean label = false;

    public Researcher(String data) throws BadDataException {
        //if the string is not separated by the comma, the length of parts is 1.
        String[] elementsOfResearcher = data.split(",");
        //if there's a empty String, an exception will be thrown.
        if (elementsOfResearcher.length != 5) {
            throw new BadDataException("Bad Researcher Data");
        } else {
            for (String part : elementsOfResearcher) {
                if (part.isEmpty()) {
                    throw new BadDataException("Bad Researcher Data");
                }
            }
        }
        try {
            this.name = elementsOfResearcher[0];
            this.idNumber = Integer.parseInt(elementsOfResearcher[1]);
            this.active = Boolean.parseBoolean(elementsOfResearcher[4]);
            String classificationStr = elementsOfResearcher[3];
            //check if clearance is an integer from 1 to 5
            List<Integer> clearanceScales = Arrays.asList(1, 2, 3, 4, 5);
            if (clearanceScales.contains(Integer.parseInt(elementsOfResearcher[2]))) {
                this.clearance = Integer.parseInt(elementsOfResearcher[2]);
            } else {
                throw new BadDataException("Bad Researcher Data");
            }

            if (classificationStr.length() != 1 || !Character.isLetter(classificationStr.charAt(0))
                    || (classificationStr.charAt(0)) < 'A' || (classificationStr.charAt(0)) > 'Z') {
                throw new BadDataException("Bad Researcher Data");
            } else {
                this.classification = classificationStr.charAt(0);
                if (classificationStr.equals("E") && active) {
                    throw new BadDataException("Bad Researcher Data");
                }
            }
        } catch (Exception e) {
            throw new BadDataException("Bad Researcher Data");
        }
    }

    public Researcher(BadDataException e) {
        this.name = e.getMessage();
        this.idNumber = 0;
        this.clearance = 0;
        this.classification = '\0';
        this.active = false;
        this.label = true;
    }

    public boolean compatible(SCP scp) {
        if (this.label || scp.label) {
            return false;
        } else if (this.clearance < scp.getClearanceLevel()) {
            return false;
        } else if (this.classification == 'E' || (!this.active)) {
            return false;
        } else if (this.classification == 'A') {
            return !scp.isContact();
        } else return this.classification != 'B' || !scp.isContact() || scp.getObjectClass().equals("SAFE");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public void setClearance(int clearance) {
        this.clearance = clearance;
    }

    public void setClassification(char classification) {
        this.classification = classification;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public int getClearance() {
        return clearance;
    }

    public char getClassification() {
        return classification;
    }

    public boolean isActive() {
        return active;
    }


    public String toString() {
        return name + "," + idNumber + "," + clearance + "," + classification + "," + active;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Researcher)) {
            return false;
        }
        Researcher rs = (Researcher) o;
        if (this.label || rs.label) {
            return false;
        }
        return Objects.equals(this.name, rs.name) && this.idNumber == rs.idNumber && this.clearance == rs.clearance;
    }

}
