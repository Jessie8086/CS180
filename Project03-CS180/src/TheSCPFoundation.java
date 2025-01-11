import java.io.*;
import java.util.ArrayList;

/**
 * A TheSCPFoundation class
 *
 * <p>Purdue University -- CS18000 -- Spring 2024</p>
 *
 * @author Jiauxn Li
 * @version March 26, 2024
 */

public class TheSCPFoundation {
    public TheSCPFoundation() {
    }

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String fileLine = br.readLine();
            String[] files = fileLine.split(" ");
            String scpInFile = files[0];
            String researcherInFile = files[1];
            String databaseOutputFile = files[2];
            String mainOutputFile = files[3];

            BufferedWriter bw = new BufferedWriter(new FileWriter(mainOutputFile));
            FoundationDatabase fd = new FoundationDatabase(scpInFile, researcherInFile, databaseOutputFile);
            bw.write("Foundation Database Started");
            bw.newLine();
            String line;
            ArrayList<String> commands = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                commands.add(line);
            }

            for (int i = 0; i < commands.size(); ) {
                try {
                    switch (commands.get(i)) {
                        case "1":
                            boolean b1 = fd.readSCP();
                            if (b1) {
                                bw.write("1 Success");
                                if (i < commands.size() - 1) {
                                    bw.newLine();
                                }
                            } else {
                                bw.write("1 Failure");
                                if (i < commands.size() - 1) {
                                    bw.newLine();
                                }
                            }
                            i++;
                            break;
                        case "2":
                            boolean b2 = fd.readResearcher();
                            if (b2) {
                                bw.write("2 Success");
                                if (i < commands.size() - 1) {
                                    bw.newLine();
                                }
                            } else {
                                bw.write("2 Failure");
                                if (i < commands.size() - 1) {
                                    bw.newLine();
                                }
                            }
                            i++;
                            break;
                        case "3":
                            boolean b3 = fd.autoAssignResearcher();
                            if (b3) {
                                bw.write("3 Success");
                                if (i < commands.size() - 1) {
                                    bw.newLine();
                                }
                            } else {
                                bw.write("3 Failure");
                                if (i < commands.size() - 1) {
                                    bw.newLine();
                                }
                            }
                            i++;
                            break;
                        case "4":
                            boolean b4 = fd.modifySCP(commands.get(i + 1), commands.get(i + 2));
                            if (b4) {
                                bw.write("4 Success");
                                if (i < commands.size() - 1) {
                                    bw.newLine();
                                }
                            } else {
                                bw.write("4 Failure");
                                if (i < commands.size() - 1) {
                                    bw.newLine();
                                }
                            }
                            i = i + 3;
                            break;
                        case "5":
                            boolean b5 = fd.modifyResearcher(commands.get(i + 1), commands.get(i + 2));
                            if (b5) {
                                bw.write("5 Success");
                                if (i < commands.size() - 1) {
                                    bw.newLine();
                                }
                            } else {
                                bw.write("5 Failure");
                                if (i < commands.size() - 1) {
                                    bw.newLine();
                                }
                            }
                            i = i + 3;
                            break;
                        case "6":
                            boolean b6 = fd.addResearcher(Integer.parseInt(commands.get(i + 1)), commands.get(i + 2));
                            if (b6) {
                                bw.write("6 Success");
                                if (i < commands.size() - 1) {
                                    bw.newLine();
                                }
                            } else {
                                bw.write("6 Failure");
                                if (i < commands.size() - 1) {
                                    bw.newLine();
                                }
                            }
                            i = i + 3;
                            break;
                        case "7":
                            boolean b7 = fd.outputDatabase();
                            if (b7) {
                                bw.write("7 Success");
                                if (i < commands.size() - 1) {
                                    bw.newLine();
                                }
                            } else {
                                bw.write("7 Failure");
                                if (i < commands.size() - 1) {
                                    bw.newLine();
                                }
                            }
                            i++;
                            break;
                        default:
                            throw new NumberFormatException();
                    }
                } catch (NumberFormatException e1) {
                    bw.write("Command Failure");
                    if (i < commands.size() - 1) {
                        bw.newLine();
                    }
                    if (commands.get(i).equals("4") || commands.get(i).equals("5") || commands.get(i).equals("6")) {
                        i = i + 3;
                    } else {
                        i++;
                    }
                }
            }
            bw.close();
        } catch (IOException e2) {
            try {
                BufferedReader br = new BufferedReader(new FileReader("input.txt"));
                String fileLine = br.readLine();
                String[] files = fileLine.split(" ");
                String mainOutputFile = files[3];
                BufferedWriter bw = new BufferedWriter(new FileWriter(mainOutputFile));
                bw.write("IO Read Failure");
                bw.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }
}
