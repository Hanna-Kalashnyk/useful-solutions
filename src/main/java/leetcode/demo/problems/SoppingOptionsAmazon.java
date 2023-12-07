package leetcode.demo.problems;

public class SoppingOptionsAmazon {
    public int optionNumberCounter(int[][] prices, int budjet) {
        int item = prices.length;
        int option = prices[0].length;
        int count = 0;

        options(prices, budjet, count, item, option, 0);

        return count;
    }

    public void options(int[][] prices, int budjet, int count, int item, int option, int i) {
        if (i == item && budjet >= 0) count++;
        if (i == item)return;


        for (int j = 0; j < option; j++) {
            options(prices, budjet - prices[i][j], count, item, option, i + 1);
        }
    }
}
