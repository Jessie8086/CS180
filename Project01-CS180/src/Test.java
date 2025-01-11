import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {


    public static void main(String[] args) {
//        double a = 1000;
//        double c = a/4;
//        String d = "2345";
//        double e = Double.parseDouble(d);
//        System.out.println(e);
//
//        int g = (int) (18.9/9.0);
//        System.out.println(g);

//        String a = "caaaaaaa";
//        int b = a.indexOf("a");
//        System.out.println(b);

//
//        String tournament = "1350-L1500-W1200-L1480-W1415-L1520";
//
//        int index = tournament.indexOf("-");
//        String oppoEloSeries = "";  // for storing each opponent's new Elo
//        double compElo = Integer.parseInt(tournament.substring(0, index));
//        double oppoElo; // opponents' Elo
//        int oppoEloInt;
//        double compR = 0;   // competitor's R value
//        double oppoR;   // opponents' R value
//        double compE;   // competitor's expected score
//        double oppoE;   // opponents' expected score
//        String tournament2 = tournament + "-";
//
//        for (index = tournament.indexOf("-"); index != -1; index = tournament.indexOf("-", index + 1)) {
//
//            compR = Math.pow(10, compElo / 400); // calculate competitor's R value
//            oppoElo = Integer.parseInt(tournament2.substring(index + 2, tournament2.indexOf("-", index + 1))); // grab each opponent's Elo
//            oppoR = Math.pow(10, oppoElo / 400); // calculate each opponent's R value
//            compE = compR / (compR + oppoR); // calculate the competitor's E value
//            oppoE = oppoR / (compR + oppoR); // calculate each opponent's E value
//
//            // if the competitor wins...
//            if (tournament.charAt(index + 1) == 'W') {
//                compElo = (int)(compElo + 25 * (1 - compE)); // transfer the new value into the competitor's Elo after each calculation
//                oppoElo = (int) (oppoElo + 25 * (0 - oppoE)); // calculate the opponent's new Elo
//                oppoEloInt = (int) oppoElo;
//                oppoEloSeries = oppoEloSeries + "-" + oppoEloInt; // put each opponent's Elo into a string
//
//            // if the competitor loses...
//            } else {
//                compElo = (int) (compElo + 25 * (0 - compE));
//                oppoElo = (int) (oppoElo + 25 * (1 - oppoE));
//                oppoEloInt = (int) oppoElo;
//                oppoEloSeries = oppoEloSeries + "-" + oppoEloInt;
//            }
//
//        }
//        System.out.printf(compElo + oppoEloSeries);

        String multiElo = "600-1200-400-800-1350";

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(multiElo);

        int count = 0; // 计算匹配到的数字个数
        while (matcher.find()) {
            count++;
        }
        // 创建String数组，长度为匹配到的数字个数
        String[] elos = new String[count];

        // 重置Matcher对象，从头开始查找
        matcher.reset();

        int index = 0; // 记录当前位置
        while (matcher.find() && index < count) {
            elos[index] = matcher.group();
            index++;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(elos[i]);
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

        double r_1 = Math.pow(10, elo1 / 400);
        double r_2 = Math.pow(10, elo2 / 400);
        double r_3 = Math.pow(10, elo3 / 400);
        double r_4 = Math.pow(10, elo4 / 400);
        double lowWinE = r_1 / (r_1 + r_4);
        double lowLoseE = r_1 / (r_1 + r_2);
        double highWinE = r_4 / (r_4 + r_3);
        double highLoseE = r_4 / (r_4 + r_1);

        int lowGain = (int) (elo1 + 25 * (1 - lowWinE));
        int lowLost = (int) (elo1 + 25 * (0 - lowLoseE));
        int highGain = (int) (elo4 + 25 * (1 - highWinE));
        int highLost = (int) (elo4 + 25 * (0 - highLoseE));

        int lowPlus = (int)(lowGain - elo1);
        int lowMinus = (int)(lowLost - elo1);
        int highPlus = (int)(highGain - elo4);
        int highMinus = (int)(highLost - elo4);

        System.out.printf("%d %d %d %d", lowPlus, lowMinus, highPlus, highMinus);

    }
}