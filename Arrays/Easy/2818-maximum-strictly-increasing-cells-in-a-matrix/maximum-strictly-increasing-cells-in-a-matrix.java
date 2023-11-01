class Solution {
    public class Cell {
        int row;
        int col;
        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int maxIncreasingCells(int[][] mat) {
        TreeMap<Integer, List<Cell>> map = new TreeMap<>();
        int m = mat.length;
        int n = mat[0].length;

        int [] max_rows = new int[m];
        int [] max_cols = new int[n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                Cell cell = new Cell(i,j);
                List<Cell> cells = map.getOrDefault(mat[i][j], new ArrayList<>());
                cells.add(cell);
                map.put(mat[i][j], cells);
            }
        }

        int result = 1;



        for(Integer val: map.keySet()) {
            int [] curr_max_rows = new int[m];
            int [] curr_max_cols = new int[n];
            

            for(Cell cell: map.get(val)) {
                int row = cell.row;
                int col = cell.col;
                int value =  Math.max(max_rows[row], max_cols[col]) + 1;
                result = Math.max(result, value);
                curr_max_rows[row] = Math.max(curr_max_rows[row], value);
                curr_max_cols[col] = Math.max(curr_max_cols[col], value);
            }

            for(Cell cell: map.get(val)) {
                int row = cell.row;
                int col = cell.col;
                max_rows[row] = Math.max(max_rows[row], curr_max_rows[row]);
                max_cols[col] = Math.max(max_cols[col], curr_max_cols[col]);
            }
        }
        return result;
    }
}