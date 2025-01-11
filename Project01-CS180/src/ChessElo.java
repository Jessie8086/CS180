import java.util.Scanner;
import java.util.Arrays;
import java.util.regex.*;

/**
 * A program that calculates Chess Elo
 * <p>
 * Purdue University -- CS18000 -- Spring 2024 -- Project 01
 *
 * @author Jiaxun Li
 * @version February 2024
 */

public class ChessElo {

    public static final String WELCOME_MESSAGE = "Welcome to the Chess Elo Calculator!";
    public static final String MAIN_MENU = "Please Select an Operation\n" + "1 - Single Match\n" +
            "2 - Tournament Results\n" + "3 - Field Prediction\n" + "4 - Exit";

    public static final String SINGLE_MATCH = "Please Enter Player 1's Elo followed by a hyphen '-' " +
            "then the Outcome followed by Player 2's Elo.";
    public static final String TOURNAMENT_RESULTS = "Please Enter the Tournament String to be Calculated.";
    public static final String FIELD_PREDICTION = "Please Enter a String of Elo Ratings.";
    public static final String MATCH_OUTCOME = "The Result of the Single Match is ";
    public static final String TOURNAMENT_OUTCOME = "The Final Tournament Results are ";
    public static final String PREDICTION_OUTCOME = "The Chess Elo Calculator Predicts ";
    public static final String CONFIRMATION = "Are You Sure You Want to Exit?";
    public static final String INVALID_INPUT = "Invalid Input! Try again";
    public static final String THANK_YOU = "Thank You For Using the Chess Elo Calculator!";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(WELCOME_MESSAGE);

        String option = null;
        String lowercase = null;

        do {
            boolean x;

            do {
                System.out.println(MAIN_MENU);
                option = scanner.nextLine();

                if (option.equals("1") || option.equals("2") || option.equals("3") || option.equals("4")) {
                    x = false;
                } else {
                    x = true;
                    System.out.println(INVALID_INPUT);
                }
            } while (x);

            if (option.equals("1")) {
                System.out.println(SINGLE_MATCH);
                String singleMatch = scanner.nextLine();

                int i = singleMatch.indexOf("-");
                double p1Elo = Integer.parseInt(singleMatch.substring(0, i));
                double p2Elo = Integer.parseInt(singleMatch.substring(i + 2));
                double r1 = Math.pow(10, p1Elo / 400);
                double r2 = Math.pow(10, p2Elo / 400);
                double ep1 = r1 / (r1 + r2);
                double ep2 = r2 / (r1 + r2);
                int newEloP1;
                int newEloP2;

                if (singleMatch.charAt(i + 1) == 'W') {
                    newEloP1 = (int) (p1Elo + 25 * (1 - ep1));
                    newEloP2 = (int) (p2Elo + 25 * (0 - ep2));

                } else {
                    newEloP1 = (int) (p1Elo + 25 * (0 - ep1));
                    newEloP2 = (int) (p2Elo + 25 * (1 - ep2));
                }

                System.out.printf(MATCH_OUTCOME + "%d-%d\n", newEloP1, newEloP2);
                lowercase = "no";

            } else if (option.equals("2")) {
                System.out.println(TOURNAMENT_RESULTS);
                String tournament = scanner.nextLine();

                int index = tournament.indexOf("-");
                String oppoEloSeries = "";  // for storing each opponent's new Elo
                double compElo = Integer.parseInt(tournament.substring(0, index));
                double oppoElo;  // opponents' Elo

                double compR = 0.0;   // competitor's R value
                double oppoR;   // opponents' R value
                double compE;   // competitor's expected score
                double oppoE;   // opponents' expected score
                String tournament2 = tournament + "-";

                for (index = tournament.indexOf("-"); index != -1; index = tournament.indexOf("-", index + 1)) {

                    compR = Math.pow(10, compElo / 400); // calculate competitor's R value
                    oppoElo = Integer.parseInt(tournament2.substring(index + 2,
                            tournament2.indexOf("-", index + 1)));
                    oppoR = Math.pow(10, oppoElo / 400); // calculate each opponent's R value
                    compE = compR / (compR + oppoR); // calculate the competitor's E value
                    oppoE = oppoR / (compR + oppoR); // calculate each opponent's E value

                    // if the competitor wins...
                    if (tournament.charAt(index + 1) == 'W') {
                        compElo = (int) (compElo + 25 * (1 - compE));
                        oppoElo = (int) (oppoElo + 25 * (0 - oppoE)); // calculate the opponent's new Elo
                        oppoEloSeries = oppoEloSeries + "-" + (int) oppoElo;  // put each opponent's Elo into a string

                        // if the competitor loses...
                    } else {
                        compElo = (int) (compElo + 25 * (0 - compE));
                        oppoElo = (int) (oppoElo + 25 * (1 - oppoE));
                        oppoEloSeries = oppoEloSeries + "-" + (int) oppoElo;
                    }
                }

                System.out.printf(TOURNAMENT_OUTCOME + "%d%s\n", (int) compElo, oppoEloSeries);
                lowercase = "no";

            } else if (option.equals("3")) {
                System.out.println(FIELD_PREDICTION);
                String multiElo = scanner.nextLine();

                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(multiElo);

                int count = 0;
                while (matcher.find()) {
                    count++;
                }

                String[] elos = new String[count];

                matcher.reset();

                int index = 0;
                while (matcher.find() && index < count) {
                    elos[index] = matcher.group();
                    index++;
                }

                int[] numbers = new int[elos.length];
                for (int i = 0; i < elos.length; i++) {
                    numbers[i] = Integer.parseInt(elos[i]);
                }

                Arrays.sort(numbers);
                int[] result = {numbers[0], numbers[1], numbers[numbers.length - 2], numbers[numbers.length - 1]};
                Arrays.sort(result);

                double elo1 = result[0];
                double elo2 = result[1];
                double elo3 = result[2];
                double elo4 = result[3];

                double r1 = Math.pow(10, elo1 / 400);
                double r2 = Math.pow(10, elo2 / 400);
                double r3 = Math.pow(10, elo3 / 400);
                double r4 = Math.pow(10, elo4 / 400);
                double lowWinE = r1 / (r1 + r4);
                double lowLoseE = r1 / (r1 + r2);
                double highWinE = r4 / (r4 + r3);
                double highLoseE = r4 / (r4 + r1);

                int lowGain = (int) (elo1 + 25 * (1 - lowWinE));
                int lowLost = (int) (elo1 + 25 * (0 - lowLoseE));
                int highGain = (int) (elo4 + 25 * (1 - highWinE));
                int highLost = (int) (elo4 + 25 * (0 - highLoseE));

                int lowPlus = (int) (lowGain - elo1);
                int lowMinus = (int) (lowLost - elo1);
                int highPlus = (int) (highGain - elo4);
                int highMinus = (int) (highLost - elo4);

                System.out.printf(PREDICTION_OUTCOME +
                        "%d (+%d/%d) %d (+%d/%d)\n", (int) elo1, lowPlus, lowMinus, (int) elo4, highPlus, highMinus);
                lowercase = "no";

            } else {
                boolean b = false;
                do {
                    System.out.println(CONFIRMATION);
                    String confirm = scanner.nextLine();
                    lowercase = confirm.toLowerCase();

                    if (lowercase.equals("yes") || lowercase.equals("y")) {
                        b = false;
                        System.out.println(THANK_YOU);
                    } else if (lowercase.equals("no") || lowercase.equals("n")) {
                        b = false;
                    } else {
                        b = true;
                        System.out.println(INVALID_INPUT);
                    }
                } while (b);
            }
        } while (lowercase.equals("no") || lowercase.equals("n"));
    } // End main
} // End class


