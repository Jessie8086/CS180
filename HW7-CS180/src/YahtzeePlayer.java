import java.util.Arrays;

/**
 * A program that calculate the score and winner for a modified version of the board game Yahtzee
 * <p>
 * Purdue University -- CS18000 -- Spring 2024 -- HW07 Challenge
 *
 * @author Jiaxun Li
 * @version February 2024
 */
public class YahtzeePlayer {

    private int[][] rollResults;
    private int total;
    private int fourOfAKindTotal;
    private boolean fullHouse;
    private boolean largeStraight;
    private boolean yahtzee;

    public YahtzeePlayer(int[][] rollResults) {
        this.rollResults = rollResults;
        this.total = 0;
        this.fourOfAKindTotal = 0;
        this.fullHouse = false;
        this.largeStraight = false;
        this.yahtzee = false;

    }

    public int getFourOfAKindTotal() {
        return fourOfAKindTotal;
    }

    public boolean hasFullHouse() {
        return fullHouse;
    }

    public boolean hasLargeStraight() {
        return largeStraight;
    }

    public boolean hasYahtzee() {
        return yahtzee;
    }

    public int getTotal() {
        return total;
    }

    public void checkFourOfAKind() {
        for (int i = 0; i < this.rollResults.length; i++) {
            int[] oneRoll = this.rollResults[i];
            int[] sortedArray = Arrays.copyOf(oneRoll, oneRoll.length);
            Arrays.sort(sortedArray);

            if (sortedArray[0] == sortedArray[1]) {
                if (sortedArray[0] == sortedArray[2] && sortedArray[0] == sortedArray[3]
                        && sortedArray[0] != sortedArray[4]) {
                    this.fourOfAKindTotal = sortedArray[0] + sortedArray[1]
                            + sortedArray[2] + sortedArray[3] + sortedArray[4];
                    break;
                }
            } else {
                if (sortedArray[1] == sortedArray[2] && sortedArray[1] == sortedArray[3]
                        && sortedArray[1] == sortedArray[4]) {
                    this.fourOfAKindTotal = sortedArray[0] + sortedArray[1]
                            + sortedArray[2] + sortedArray[3] + sortedArray[4];
                    break;
                }
            }
        }
    }

    public void checkFullHouse() {
        for (int i = 0; i < this.rollResults.length; i++) {
            int[] oneRoll = this.rollResults[i];
            int[] sortedArray = Arrays.copyOf(oneRoll, oneRoll.length);
            Arrays.sort(sortedArray);
            if (sortedArray[1] == sortedArray[2]) {
                if (sortedArray[1] == sortedArray[0] && sortedArray[3] == sortedArray[4]
                        && sortedArray[2] != sortedArray[3]) {
                    this.fullHouse = true;
                    break;
                }
            } else {
                if (sortedArray[0] == sortedArray[1] && sortedArray[2] == sortedArray[3]
                        && sortedArray[2] == sortedArray[4]) {
                    this.fullHouse = true;
                    break;
                }
            }
        }
    }

    public void checkLargeStraight() {
        for (int i = 0; i < this.rollResults.length; i++) {
            int[] oneRoll = this.rollResults[i];
            if (oneRoll[0] + 1 == oneRoll[1] && oneRoll[1] + 1 == oneRoll[2] && oneRoll[2] + 1 == oneRoll[3]
                    && oneRoll[3] + 1 == oneRoll[4]) {
                this.largeStraight = true;
                break;
            }
        }
    }

    public void checkYahtzee() {
        for (int i = 0; i < this.rollResults.length; i++) {
            int[] oneRoll = this.rollResults[i];
            if (oneRoll[0] == oneRoll[1] && oneRoll[0] == oneRoll[2]
                    && oneRoll[0] == oneRoll[3] && oneRoll[0] == oneRoll[4]) {
                this.yahtzee = true;
                break;
            }
        }
    }

    public void calculateTotal() {
        int fullHouseTotal = 0;
        int largeStraightTotal = 0;
        int yahtzeeTotal = 0;

        if (this.fullHouse) {
            fullHouseTotal = 25;
        }
        if (this.largeStraight) {
            largeStraightTotal = 40;
        }
        if (this.yahtzee) {
            yahtzeeTotal = 50;
        }
        this.total = fullHouseTotal + largeStraightTotal + yahtzeeTotal + this.fourOfAKindTotal;

    }
}
