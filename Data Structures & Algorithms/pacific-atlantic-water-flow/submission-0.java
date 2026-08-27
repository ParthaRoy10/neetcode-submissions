class Solution {

    private final int[][] directions = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        Set<String> pacific = new HashSet<>();
        Set<String> atlantic = new HashSet<>();

        // Pacific Ocean borders
        for (int col = 0; col < cols; col++) {
            pacific.add(0 + "," + col);
        }

        for (int row = 0; row < rows; row++) {
            pacific.add(row + "," + 0);
        }

        // Atlantic Ocean borders
        for (int col = 0; col < cols; col++) {
            atlantic.add((rows - 1) + "," + col);
        }

        for (int row = 0; row < rows; row++) {
            atlantic.add(row + "," + (cols - 1));
        }

        for (int col = 0; col < cols; col++) {
            dfs(0, col, heights, pacific);
            dfs(rows - 1, col, heights, atlantic);
        }

        for (int row = 0; row < rows; row++) {
            dfs(row, 0, heights, pacific);
            dfs(row, cols - 1, heights, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                String cell = row + "," + col;

                if (pacific.contains(cell) && atlantic.contains(cell)) {
                    ans.add(Arrays.asList(row, col));
                }
            }
        }

        return ans;
    }

    private void dfs(
        int row,
        int col,
        int[][] heights,
        Set<String> visited
    ) {

        for (int[] dir : directions) {

            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow < 0 || newRow >= heights.length ||
                newCol < 0 || newCol >= heights[0].length) {
                continue;
            }

            String nextCell = newRow + "," + newCol;

            if (visited.contains(nextCell)) {
                continue;
            }

            if (heights[newRow][newCol] < heights[row][col]) {
                continue;
            }

            visited.add(nextCell);

            dfs(newRow, newCol, heights, visited);
        }
    }
}