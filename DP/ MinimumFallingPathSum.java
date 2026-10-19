class Solution {

    public int helper(int row, int col, int m, int n, int[][] matrix, int[][] dp){
        if(col < 0 || col >= n) return Integer.MAX_VALUE;
        if(row == m ) return 0;

        if(dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

        int down = helper(row + 1, col, m, n, matrix, dp);
        int leftDiagonal = helper(row + 1, col - 1, m, n, matrix, dp);
        int rightDiagonal = helper(row + 1, col + 1, m, n, matrix, dp);

        return dp[row][col] = matrix[row][col] + Math.min(down, Math.min(leftDiagonal, rightDiagonal));

    }
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for(int[] row : dp){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            ans = Math.min(helper(0, j, m, n, matrix, dp), ans);
        }

        return ans;
    }
}