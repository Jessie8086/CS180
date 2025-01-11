import java.io.File;
import java.util.Scanner;

/**
 * Class StockGame
 *
 * <p>Purdue University -- CS18000 -- Spring 2024</p>
 *
 * @author Jiauxn Li
 * @version March 26, 2024
 */

public class StockGame extends Thread {
    // shared resources
    private static double stockPrice;
    private static int availableShares;
    private static int tradeCount = 0;

    // lock for the shared resources
    private static final Object LOCK = new Object();

    // instance variables for each trader
    private String name;
    private int numShares;
    private String fileName;

    /**
     * A constructor
     *
     * <p>Purdue University -- CS18000 -- Spring 2024</p>
     *
     * @author Jiauxn Li
     * @version March 26, 2024
     */
    public StockGame(String name, String fileName) {
        this.name = name;
        this.fileName = fileName;
        this.numShares = 0;

        // reset stock price and available shares for the first trader
        if (tradeCount == 0) {
            stockPrice = 100.0;
            availableShares = 100;
        }
    }

    /**
     * Read the trading moves from the file and process them.
     */
    public void run() {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                // invalid input
                if (parts.length != 2) {
                    System.out.println("Error, invalid input!");
                    continue;
                }
                String action = parts[0].toLowerCase();
                int shares = Integer.parseInt(parts[1]);
                if (shares < 0 || (!action.equals("buy") && !action.equals("sell"))) {
                    System.out.println("Error, invalid input!");
                    continue;
                }

                // valid input, use lock to access shared resources
                synchronized (LOCK) {
                    processTrader(action, shares);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * A helper method to process the trader's action.
     *
     * <p>Purdue University -- CS18000 -- Spring 2024</p>
     *
     * @author Jiauxn Li
     * @version March 26, 2024
     */
    private void processTrader(String action, int shares) {
        System.out.println("----------");
        System.out.println("Stock Price: " + stockPrice);
        System.out.println("Available Shares: " + availableShares);
        System.out.println("Trade number: " + (tradeCount + 1));
        System.out.println("Name: " + name);

        switch (action) {
            case "buy":
                if (shares > availableShares) {
                    System.out.println("Insufficient shares available, cancelling order...");
                    return;
                } else {
                    numShares += shares;
                    availableShares -= shares;
                    System.out.println("Purchasing " + shares + " shares at " + stockPrice + "...");
                    stockPrice += 1.5 * shares;
                }
                break;
            case "sell":
                if (shares > numShares) {
                    System.out.println("Insufficient owned shares, cancelling order...");
                    return;
                } else {
                    numShares -= shares;
                    availableShares += shares;
                    System.out.println("Selling " + shares + " shares at " + stockPrice + "...");
                    stockPrice -= 2.0 * shares;
                }
                break;
        }
        tradeCount++;
    }

    /**
     * Main method.
     *
     * <p>Purdue University -- CS18000 -- Spring 2024</p>
     *
     * @author Jiauxn Li
     * @version March 26, 2024
     */
    public static void main(String[] args) {
        try {
            StockGame[] stockTraders = {new StockGame("Xander", "TraderOneMoves.txt"),
                    new StockGame("Afua", "TraderTwoMoves.txt")};
            for (int i = 0; i < stockTraders.length; i++) {
                stockTraders[i].start();
            }
            for (int i = 0; i < stockTraders.length; i++) {
                stockTraders[i].join();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }
}
