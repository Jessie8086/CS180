import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * Class SearchServer
 *
 * <p>Purdue University -- CS18000 -- Spring 2024</p>
 *
 * @author Jiauxn Li
 * @version April 2, 2024
 */
public class SearchServer extends Thread {
    private static final int PORT = 12345;
    private static final String DB_FILE = "searchDatabase.txt";
    private final Map<Integer, String[]> db;

    public SearchServer() {
        this.db = new HashMap<>();
        loadDatabase();
    }

    public static void main(String[] args) {
        SearchServer server = new SearchServer();
        server.run();
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);
            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new java.io.InputStreamReader(clientSocket.getInputStream()));
                    System.out.println("Client connected");

                    // handle the client request
                    String query;
                    while ((query = in.readLine()) != null) {
                        System.out.println("Received query: " + query);
                        if (query.equals("exit")) {
                            break;
                        }
                        List<String> results = searchDatabase(query);
                        // send the results back to the client
                        out.println(results.size());
                        if (!results.isEmpty()) {
                            for (String result : results) {
                                out.println(result);
                            }
                            // wait the page index
                            int pageIndex = Integer.parseInt(in.readLine());
                            out.println(db.get(pageIndex)[1]);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error handling client request");
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error starting server");
            System.out.println(e.getMessage());
        }
    }

    private List<String> searchDatabase(String query) {
        List<String> results = new ArrayList<>();
        // results: [key, title, description]
        for (int key : db.keySet()) {
            String[] data = db.get(key);
            if (data[0].toLowerCase().contains(query.toLowerCase())
                    || data[1].toLowerCase().contains(query.toLowerCase())) {
                results.add(key + ";" + data[0]);
            }
        }
        return results;
    }


    private void loadDatabase() {
        // Load the database from the file
        try {
            Scanner scanner = new Scanner(new File(DB_FILE));
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(";");
                int id = Integer.parseInt(parts[0]);
                String[] data = Arrays.copyOfRange(parts, 1, parts.length);
                db.put(id, data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Database file not found");
        } catch (Exception e) {
            System.out.println("Error loading database");
        }
    }
}