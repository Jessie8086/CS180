import java.util.Scanner;

/**
 * A Music Recommendation Program.
 * <p>
 * Purdue University -- CS18000 -- Spring 2024 -- Homework 04 -- Challenge
 *
 * @author Jiaxun Li
 * @version February 2024
 */
public class MusicRecommender {

    public static final String WELCOME_MESSAGE = "Welcome to the Music Recommender!";
    public static final String INITIAL_SONG = "Do you want to listen to a song?";
    public static final String HAPPY = "Are you feeling happy?";
    public static final String CLAP_ALONG = "Do you want to clap along?";
    public static final String SING_OUT = "Do you want to sing out?";
    public static final String DANCE = "Do you want to dance?";
    public static final String SAD = "Are you feeling sad?";
    public static final String LYRICS = "Do you want lyrics?";
    public static final String WORRIED = "Are you feeling worried?";
    public static final String CALM = "Are you feeling calm?";
    public static final String COMPLICATED = "Are your feelings more complicated" +
            " than this program can handle?";
    public static final String CONTINUE_WORRIED = "Do you want to keep " +
            "feeling worried?";
    public static final String GOODBYE_MESSAGE = "Thank you for using" +
            " the Music Recommender!";


    public static final String SONG_ONE = "Play \"Happy\" by Pharrell Williams";
    public static final String SONG_TWO = "Play \"If you want to Sing Out, Sing Out\" by Cat Stevens";
    public static final String SONG_THREE = "Play \"Uptown Funk\" by Mark Ronson featuring Bruno Mars";
    public static final String SONG_FOUR = "Play \"La finta giardiniera, K. 196: Ouverture. Allegro molto\" by Mozart";
    public static final String SONG_FIVE = "Play \"Hurt\" by Trent Reznor, as performed by Johnny Cash";
    public static final String SONG_SIX = "Play Theme from Schindler's List";
    public static final String SONG_SEVEN = "Play \"Aben bog\" by Bremer/McCoy";
    public static final String SONG_EIGHT = "Play \"Complicated\" by Avril Lavigne";
    public static final String SONG_NINE = "Play \"A Witch Stole Sam\" by Mark Korven" +
            " from The Witch Original Soundtrack";
    public static final String SONG_TEN = "Play \"Don't worry. Be Happy\" by Bobby McFerrin";

    // ------------------------- DO NOT MODIFY ABOVE -------------------------

    // IMPLEMENT YOUR SOLUTION HERE
    public static void main(String[] args) {
        System.out.println(WELCOME_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        // listen to a music
        System.out.println(INITIAL_SONG);
        String option1 = scanner.nextLine();

        if (option1.equals("Yes") || option1.equals("yes")) {

            // happy or not
            System.out.println(HAPPY);
            String option2 = scanner.nextLine();

            if (option2.equals("Yes") || option2.equals("yes")) {
                System.out.println(CLAP_ALONG);
                String option3 = scanner.nextLine();

                if (option3.equals("Yes") || option3.equals("yes")) {
                    System.out.println(SONG_ONE);
                } else {
                    System.out.println(SING_OUT);
                    String option4 = scanner.nextLine();

                    if (option4.equals("Yes") || option4.equals("yes")) {
                        System.out.println(SONG_TWO);
                    } else {
                        System.out.println(DANCE);
                        String option5 = scanner.nextLine();

                        if (option5.equals("Yes") || option5.equals("yes")) {
                            System.out.println(SONG_THREE);
                        } else {
                            System.out.println(SONG_FOUR);
                        }
                    }
                }
            } else {
                System.out.println(SAD);
                String option6 = scanner.nextLine();

                if (option6.equals("Yes") || option6.equals("yes")) {
                    System.out.println(LYRICS);
                    String option7 = scanner.nextLine();

                    if (option7.equals("Yes") || option7.equals("yes")) {
                        System.out.println(SONG_FIVE);
                    } else {
                        System.out.println(SONG_SIX);
                    }

                } else {
                    System.out.println(WORRIED);
                    String option8 = scanner.nextLine();

                    if (option8.equals("Yes") || option8.equals("yes")) {
                        System.out.println(CONTINUE_WORRIED);
                        String option9 = scanner.nextLine();

                        if (option9.equals("Yes") || option9.equals("yes")) {
                            System.out.println(SONG_NINE);
                        } else {
                            System.out.println(SONG_TEN);
                        }
                    } else {
                        System.out.println(CALM);
                        String option10 = scanner.nextLine();

                        if (option10.equals("Yes") || option10.equals("yes")) {
                            System.out.println(SONG_SEVEN);
                        } else {
                            System.out.println(COMPLICATED);
                            String option11 = scanner.nextLine();
                            if (option11.equals("Yes") || option11.equals("yes")) {
                                System.out.println(SONG_EIGHT);
                            }

                        }
                    }
                }

            }

            System.out.println(GOODBYE_MESSAGE);

        } else {
            System.out.println(GOODBYE_MESSAGE);
        }

    }

}

