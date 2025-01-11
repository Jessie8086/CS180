import javax.swing.JOptionPane;
import java.io.*;
import java.net.*;

/**
 * Class SearchClient
 *
 * <p>Purdue University -- CS18000 -- Spring 2024</p>
 *
 * @author Jiauxn Li
 * @version April 2, 2024
 */
public class SearchClient {
    public void run() {
        // 0. display a welcome message
        JOptionPane.showMessageDialog(null, "Welcome to the Search Client!",
                "Welcome", JOptionPane.INFORMATION_MESSAGE);

        // 1. ask for host and port use JOptionPane
        String host = "localhost"; // default host, user can change
        int port = 12345; // default port, user can change
        while (true) {
            String hOST = JOptionPane.showInputDialog("Enter host:", host);
            if (hOST == null) {
                // this means the user clicked the cancel button, exit the program
                return;
            } else if (hOST.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Host cannot be empty.");
            } else {
                break;
            }
        }
        while (true) {
            String pORT = JOptionPane.showInputDialog("Enter port:", String.valueOf(port));
            if (pORT == null) {
                return;
            } else if (pORT.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Port cannot be empty.");
                continue;
            }
            try {
                port = Integer.parseInt(pORT);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid port number.");
                continue;
            }
            break;
        }

        // 2. create a socket and connect to the server
        try {
            Socket socket = new Socket(host, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 3. display a message to indicate the connection is established
            JOptionPane.showMessageDialog(null, "Connection established to "
                    + host + " on port " + port);

            // 4. repeatedly ask for search text, send to server, and display the result until the user cancels
            while (true) {
                // 4.1 ask for search text
                String searchText;
                while (true) {
                    searchText = JOptionPane.showInputDialog("Enter search text:");
                    if (searchText == null) {
                        return;
                    } else if (searchText.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Search text cannot be empty.");
                        continue;
                    } else {
                        break;
                    }
                }

                // 4.2 send search text to server and retrieve the search results
                out.println(searchText);
                int size = Integer.parseInt(in.readLine());
                if (size != 0) {
                    String[] titles = new String[size];
                    for (int i = 0; i < size; i++) {
                        titles[i] = in.readLine();
                    }
                    // display a dropdown list to show the titles and let the user select one
                    int selectedIndex = -1;
                    while (true) {
                        String selectedTitle = (String) JOptionPane.showInputDialog(null,
                                "Select a title", "Search Results",
                                JOptionPane.QUESTION_MESSAGE, null, titles, titles[0]);
                        if (selectedTitle == null) {
                            return;
                        }
                        selectedIndex = Integer.parseInt(selectedTitle.split(";")[0]);
                        break;
                    }
                    out.println(selectedIndex);
                    JOptionPane.showMessageDialog(null, in.readLine());
                } else {
                    JOptionPane.showMessageDialog(null, "No results found.");
                }

                // 4.3 ask if the user wants to search again
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Would you like to search again?", "Continue", JOptionPane.YES_NO_OPTION);
                if (confirm != JOptionPane.YES_OPTION) {
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "Goodbye!");

            // 5. clear resources and exit
            out.close();
            in.close();
            socket.close();
            return;
        } catch (UnknownHostException e) {
            return;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Couldn't get I/O for the connection to " +
                    host);
            return;
        }
    }

    public static void main(String[] args) {
        SearchClient client = new SearchClient();
        client.run();
    }
}