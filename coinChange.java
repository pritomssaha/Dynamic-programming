
public class coinChange {

    public static void main(String[] args) {
        int[] coins = { 1, 2, 3 };
        int total = 4;
        int n = coins.length;
        int ans = getMaxProfit(coins, n, total);
        System.out.println(ans);
    }

    /*
     * private static int count(int[] coins, int total) {
     * 
     * if (total == 0) return 1; if (total < 0) return 0; int result = 0; for (int i
     * = 0; i < coins.length; i++) { result += count(coins, total - coins[i]); }
     * return result;
     * 
     * }
     */
    private static int Mincount(int[] coins, int total, int n) {
        if (n == 0)
            return 0;
        int include = 0, exclude = 0;
        if (total >= coins[n - 1])
            include = 1 + Mincount(coins, total - coins[n - 1], n - 1);
        else
            exclude = Mincount(coins, total, n - 1);
        int ans = Math.max(include, exclude);
        return ans;
    }

    private static int optimizedMincount(int[] coins, int total) {
        int[] dp = new int[total + 1];
        dp[0] = 0;
        for (int i = 1; i <= total; i++) {
            dp[i] = Integer.MAX_VALUE;
            int result = Integer.MAX_VALUE;
            for (int c : coins) {
                if (i - c >= 0)
                    result = dp[i - c];
                if (result != Integer.MAX_VALUE) {
                    dp[i] = Integer.min(dp[i], result + 1);
                }
            }

        }
        return dp[total];
    }


}
