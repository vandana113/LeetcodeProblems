class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<=(n-1)/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }
}