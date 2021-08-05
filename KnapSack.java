public class KnapSack {
    public static void main(String[] args) {

        int[] w = { 7, 4, 4 };
        int[] p = { 15, 8, 8 };
        int n = w.length;
        int capacity = 10;
        System.out.println("Max profit is: " + getMaxProfit(w, p, n, capacity));

    }

    /*
     * private static int getMaxProfit(int[] w, int[] p, int n, int capacity) {
     * 
     * if (n == 0) return 0; int include = 0; if (w[n - 1] <= capacity) include =
     * p[n - 1] + getMaxProfit(w, p, n - 1, capacity - w[n - 1]); int exclude =
     * getMaxProfit(w, p, n - 1, capacity); int ans = Math.max(include, exclude);
     * 
     * return ans;
     * 
     * }
     */

    private static int getMaxProfit(int[] w, int[] p, int n, int capacity) {

        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                dp[i][j] = -1;
            }
        }

        if (n == 0)
            return 0;

        if (dp[n - 1][capacity - 1] != -1)
            return dp[n - 1][capacity - 1];

        int include = 0;
        if (w[n - 1] <= capacity)
            include = p[n - 1] + getMaxProfit(w, p, n - 1, capacity - w[n - 1]);
        int exclude = getMaxProfit(w, p, n - 1, capacity);
        dp[n - 1][capacity - 1] = Math.max(include, exclude);

        return dp[n - 1][capacity - 1];

    }

}