class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        int N = m * n - 1;
        int left = 0;
        int right = N;
        
        while(left<=right) {
            int mid = (right+left)/2;

            int i = mid/n;
            int j = mid%n;

            if(matrix[i][j]==target) {
                return true;
            } else if (matrix[i][j]<target) {
                left = mid+1;
            } else if(matrix[i][j]>target){
                right = mid - 1;
            }
        }

        return false;

    }
}