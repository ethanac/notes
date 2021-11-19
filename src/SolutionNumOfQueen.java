public class SolutionNumOfQueen {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }

        search(results, new ArrayList<Integer>(), n);
        return results;
    }

    /*
     * results store all of the chessboards
     * cols store the column indices for each row
     */
     private void search(List<List<String>> results, List<Integer> cols, int n) {
         // Index of cols is the row number, value of cols element is the col number.
         if(cols.size() == n) {
             //draw chess board
             results.add(drawChessBoard(cols));
             return;
         }

         for(int colNum = 0; colNum < n; colNum++) {
             if(!isValid(cols, colNum)) continue; //if current pos is invalid, continue.

             cols.add(colNum); //i is the column index;
             search(results, cols, n);
             cols.remove(cols.size()-1); // remove the col added one by one to clear the list.
         }
     }

     /**
      * How to validate:
      * 1. Same row index: no.
      * 2. Row index + col index == current row index + current col index: no.
      * 3. Row index - col index == current row index - current col index: no.
      */
     private boolean isValid(List<Integer> cols, int colNum) {
         int numOfRow = cols.size();
         //numOfRow means current row number
         for(int rowIndex = 0; rowIndex < numOfRow; rowIndex++) {
             if(cols.get(rowIndex) == colNum) return false;
             if(rowIndex + cols.get(rowIndex) == numOfRow + colNum) return false;
             if(rowIndex - cols.get(rowIndex) == numOfRow - colNum) return false;
         }
         return true;
     }

     private List<String> drawChessBoard(List<Integer> cols) {
         List<String> board = new ArrayList<>();
         for(int i = 0; i < cols.size(); i++) {
             StringBuilder row = new StringBuilder();
             for(int j = 0; j < cols.size(); j++) {
                 String s = cols.get(i) == j ? "Q" : ".";
                 row.append(s);
             }
             board.add(row.toString());
         }
         return board;
     }
}
