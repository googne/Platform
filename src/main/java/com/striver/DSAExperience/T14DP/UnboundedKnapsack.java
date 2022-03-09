package com.striver.DSAExperience.T14DP;

import com.common.Out;

import java.util.Arrays;

public class UnboundedKnapsack {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        return calcMaxWeight(weight, profit, n - 1, w, dp);
    }

    private static int calcMaxWeight(int[] weight, int[] profit, int i, int w, int[][] dp) {
        if (i == 0) return profit[0] * (int) (w / weight[0]);
        if (dp[i][w] != -1) return dp[i][w];

        int notTaken = calcMaxWeight(weight, profit, i - 1, w, dp);
        int taken = Integer.MIN_VALUE;
        if (weight[i] <= w)
            taken = profit[i] + calcMaxWeight(weight, profit, i, w - weight[i], dp);

        return dp[i][w] = Math.max(notTaken, taken);
    }

    public static int unboundedKnapsack2(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w + 1];

        for (int i = weight[0]; i <= w; i++)
            dp[0][i] = profit[0] * (int) (i / weight[0]);

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= w; t++) {
                int notTaken = dp[i - 1][t];

                int taken = Integer.MIN_VALUE;
                if (weight[i] <= t)
                    taken = profit[i] + dp[i][t - weight[i]];

                dp[i][t] = Math.max(notTaken, taken);
            }
        }
        return dp[n - 1][w];
    }

    public static int unboundedKnapsack3(int n, int w, int[] profit, int[] weight) {
        int[] prev = new int[w + 1];

        for (int i = weight[0]; i <= w; i++)
            prev[i] = profit[0] * (int) (i / weight[0]);

        for (int i = 1; i < n; i++) {
            int[] curr = new int[w + 1];
            for (int t = 0; t <= w; t++) {
                int notTaken = prev[t];

                int taken = Integer.MIN_VALUE;
                if (weight[i] <= t)
                    taken = profit[i] + curr[t - weight[i]];

                curr[t] = Math.max(notTaken, taken);
            }
            prev = curr;
        }
        return prev[w];
    }

    public static void main(String[] args) {
        int n = 0;
        int w = 10;
        int[] profit = {5, 11, 13};
        int[] weight = {2, 4, 6};
        Out.print(unboundedKnapsack(weight.length, w, profit, weight));
        Out.print(unboundedKnapsack2(weight.length, w, profit, weight));
        Out.print(unboundedKnapsack(weight.length, w, profit, weight));
    }
}
