import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A FoundationDatabase class
 *
 * <p>Purdue University -- CS18000 -- Spring 2024</p>
 *
 * @author Jiauxn Li
 * @version March 26, 2024
 */
public class FoundationDatabase {
    private SCP[] scp;
    private Researcher[] researcher;
    private String scpIn;  //The source file used to generate the SCP array.
    private String researcherIn; //The source file used to generate the Researcher array.
    private String databaseOutput; //The destination file that the database should be written to.

    public FoundationDatabase(String scpIn, String researcherIn, String databaseOutput) {
        this.scpIn = scpIn;
        this.researcherIn = researcherIn;
        this.databaseOutput = databaseOutput;
        this.scp = null;
        this.researcher = null;
    }

    public boolean readSCP() {
        List<SCP> scpList = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(this.scpIn));
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    scpList.add(new SCP(line));
                } catch (BadDataException e1) {
                    scpList.add(new SCP(e1));
                }
            }
            this.scp = new SCP[scpList.size()]; //read the file into an array
            for (int i = 0; i < this.scp.length; i++) {
                this.scp[i] = scpList.get(i);
            }
            return true;
        } catch (IOException e1) {
            return false;
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean readResearcher() {
        List<Researcher> researcherList = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(this.researcherIn));
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    researcherList.add(new Researcher(line));
                } catch (BadDataException e1) {
                    researcherList.add(new Researcher(e1));
                }
            }
            this.researcher = new Researcher[researcherList.size()];
            for (int i = 0; i < this.researcher.length; i++) {
                this.researcher[i] = researcherList.get(i);
            }
            br.close();
            return true;
        } catch (IOException e1) {
            return false;
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean autoAssignResearcher() {
        //convert the array into a List
        try {
            List<Researcher> researcherList = new ArrayList<>(Arrays.asList(this.researcher));
            boolean c = true;
            for (SCP scpObject : this.scp) {
                if (!scpObject.label) {
                    boolean b = true;
                    for (int j = 0; j < researcherList.size(); j++) {
                        if (researcherList.get(j).compatible(scpObject)
                                && scpObject.getClearanceLevel() == researcherList.get(j).getClearance()) {
                            scpObject.setResearchers(new Researcher[]{researcherList.get(j)});
                            researcherList.remove(researcherList.get(j));
                            b = false;
                            break;
                        }
                    }

                    if (b) {
                        for (int j = 0; j < researcherList.size(); j++) {
                            if (researcherList.get(j).compatible(scpObject)) {
                                scpObject.setResearchers(new Researcher[]{researcherList.get(j)});
                                researcherList.remove(researcherList.get(j));
                                b = false;
                                break;
                            }
                        }
                        if (b) {
                            c = false;
                        }
                    }
                }
            }
            return c;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean modifyResearcher(String oldData, String newData) {
        Researcher oldResearcher;
        Researcher newResearcher;
        boolean b = false;

        try {
            oldResearcher = new Researcher(oldData);
        } catch (BadDataException e) {
            oldResearcher = new Researcher(e);
        }

        try {
            newResearcher = new Researcher(newData);
        } catch (BadDataException e) {
            newResearcher = new Researcher(e);
        }

        for (Researcher rsObject : this.researcher) {
            if (rsObject.equals(oldResearcher) && !newResearcher.label) {
                rsObject.setIdNumber(newResearcher.getIdNumber());
                rsObject.setName(newResearcher.getName());
                rsObject.setClearance(newResearcher.getClearance());
                rsObject.setClassification(newResearcher.getClassification());
                rsObject.setActive(newResearcher.isActive());
                b = true;
            }
        }
        if (b) {
            this.autoAssignResearcher();
            return true;
        } else {
            return false;
        }
    }

    public boolean modifySCP(String oldData, String newData) {
        SCP oldSCP;
        SCP newSCP;
        boolean b = false;
        try {
            oldSCP = new SCP(oldData);
        } catch (BadDataException e) {
            oldSCP = new SCP(e);
        }

        try {
            newSCP = new SCP(newData);
        } catch (BadDataException e) {
            newSCP = new SCP(e);
        }

        for (SCP scpObject : this.scp) {
            if (scpObject.equals(oldSCP) && !newSCP.label) {
                scpObject.setItemNumber(newSCP.getItemNumber());
                scpObject.setObjectClass(newSCP.getObjectClass());
                scpObject.setObjectName(newSCP.getObjectName());
                scpObject.setContact(newSCP.isContact());
                scpObject.setClearanceLevel(newSCP.getClearanceLevel());
                b = true;
            }
        }
        if (b) {
            this.autoAssignResearcher();
            return true;
        } else {
            return false;
        }
    }

    public boolean addResearcher(int itemNumber, String data) {
        Researcher addedResearcher;
        boolean b = false;
        boolean found = false;
        int index = 0;
        try {
            addedResearcher = new Researcher(data);
        } catch (BadDataException e) {
            addedResearcher = new Researcher(e);
        }

        try {
            for (int i = 0; i < this.scp.length; i++) {
                if (scp[i].getItemNumber() == itemNumber) {
                    index = i;
                    b = true;
                    break;
                }
            }
            for (Researcher value : this.researcher) {
                if (value.equals(addedResearcher)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                Researcher[] oldResearcherArray = this.researcher;
                Researcher[] newResearcherArray;
                newResearcherArray = new Researcher[this.researcher.length + 1];
                newResearcherArray[newResearcherArray.length - 1] = addedResearcher;
                System.arraycopy(oldResearcherArray, 0, newResearcherArray,
                        0, oldResearcherArray.length);
                this.researcher = newResearcherArray;
            }

            if (b) {
                if (addedResearcher.compatible(scp[index])) {
                    Researcher[] oldResearcherArray = scp[index].getResearchers();
                    Researcher[] newResearcherArray;
                    if (oldResearcherArray == null || oldResearcherArray.length == 0) {
                        scp[index].setResearchers(new Researcher[]{addedResearcher});
                    } else {
                        for (Researcher rsObject : oldResearcherArray) {
                            if (rsObject.equals(addedResearcher)) {
                                return false;
                            }
                        }
                        newResearcherArray = new Researcher[scp[index].getResearchers().length + 1];
                        newResearcherArray[newResearcherArray.length - 1] = addedResearcher;
                        System.arraycopy(oldResearcherArray, 0, newResearcherArray,
                                0, oldResearcherArray.length);
                        scp[index].setResearchers(newResearcherArray);
                    }
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean outputDatabase() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(databaseOutput));
            for (int i = 0; i < this.scp.length; i++) {
                if (scp[i].getResearchers() == null || scp[i].getResearchers().length == 0) {
                    bw.write(scp[i].toString() + ",VACANT");
                    if (i < this.scp.length - 1) {
                        bw.newLine();
                    }
                } else {
                    bw.write(scp[i].toString());
                    for (int j = 0; j < this.scp[i].getResearchers().length; j++) {
                        bw.write("," + scp[i].getResearchers()[j].toString());
                    }
                    if (i < this.scp.length - 1) {
                        bw.newLine();
                    }
                }
            }
            bw.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
