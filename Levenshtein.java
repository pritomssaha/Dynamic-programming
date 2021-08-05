public class Levenshtein {

    public static void main(String[] args) {
        String s1 = "Tuesday";
        String s2 = "Thursday";
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(LD(s1, s2, n, m, dp));
    }

    /*
     * private static int LD(String s1, String s2, int n, int m) { if (n == 0 || m
     * == 0) return Math.max(n, m); if (s1.charAt(n - 1) == s2.charAt(m - 1)) return
     * LD(s1, s2, n - 1, m - 1); int ch1 = LD(s1, s2, n - 1, m); int ch2 = LD(s1,
     * s2, n, m - 1); int ch3 = LD(s1, s2, n - 1, m - 1); return 1 + Math.min(ch1,
     * Math.min(ch2, ch3));
     * 
     * }
     */

    private static int LD(String s1, String s2, int n, int m, int[][] dp) {

        if (n == 0 || m == 0)
            return Math.max(n, m);

        if (dp[n - 1][m - 1] >= 0)
            return dp[n - 1][m - 1];
        int include = Integer.MAX_VALUE;

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            include = LD(s1, s2, n - 1, m - 1, dp);
        }
        int ch1 = LD(s1, s2, n - 1, m, dp);
        int ch2 = LD(s1, s2, n, m - 1, dp);
        int ch3 = LD(s1, s2, n - 1, m - 1, dp);
        int exclude = 1 + Math.min(ch1, Math.min(ch2, ch3));
        dp[n - 1][m - 1] = Math.min(include, exclude);
        return dp[n - 1][m - 1];

    }

}
