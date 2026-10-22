class Solution {

    public boolean helper(int i, int[] nums, int sum, int[][] dp){
        if(i == nums.length){
            if(sum == 0) return true;
            else return false;
        }
        if(dp[i][sum] != -1) return (dp[i][sum] == 1);
        boolean ans = false;
        boolean skip = helper(i + 1, nums, sum, dp);
        if(nums[i] > sum) ans = skip;
        else{
            boolean pick = helper(i + 1, nums, sum - nums[i], dp);
            ans = pick || skip;
        }
        dp[i][sum] = ans ? 1: 0;
        return ans;
    }
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int x : nums){
            totalSum += x;
        }
        if(totalSum % 2 == 1) return false;

        int[][] dp = new int[nums.length][totalSum / 2 + 1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return helper(0, nums, totalSum / 2, dp);
    }
}