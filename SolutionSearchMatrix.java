/**
 * Starting from bottom-left point or top-right point.
 */
public class SolutionSearchMatrix {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        int count = 0;
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return count;

        int x = matrix.length-1;
        int y = 0;
        while(x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length) {
            if(matrix[x][y] == target) {
                count++;
                x--;
            } else if(matrix[x][y] < target)
                y++;
            else if(matrix[x][y] > target)
                x--;
        }
        return count;
    }
}
