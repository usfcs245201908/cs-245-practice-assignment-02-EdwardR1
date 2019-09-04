public class NQueens {

	int n;
	int[][] board;

	public NQueens(int n) {
		this.n = n;
		this.board = new int[n][n];
	}

	public NQueens() {
		this(8);
	}

	public boolean placeNQueens() throws Exception {
		if (n <= 0) {
			throw new Exception("n is less than 0!");
		}
		return placeNQueens(0);
	}

	private boolean placeNQueens(int row) {
		if (row == n) {
			return true;
		}
		for (int col = 0; col < n; col++) {
			if (!isAttacked(row, col)) {
				board[row][col] = 1;
				if (placeNQueens(row + 1)) {
					return true;
				} else {
					board[row][col] = 0;
				}
			}
		}
		return false;
	}

	private boolean isAttacked(int row, int col) {
		for (int i = 0; i < n; i++) {
			if (board[row][i] == 1 || board[i][col] == 1) {
				return true;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((i + j) == (row + col) || (i - j) == (row - col)) {
					if (board[i][j] == 1) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public void printToConsole() {
		try {
			placeNQueens();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == 0) {
						System.out.print("_ ");
					} else if (board[i][j] == 1) {
						System.out.print("Q ");
					}
				}
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args){
		NQueens q = new NQueens();
		q.printToConsole();
	}

}
