import java.io.IOException;

public class Field {
	
	private String[][] mBoard;
	private int mCols = 0, mRows = 0;

	public Field(int columns, int rows) {
		mBoard = new String[columns][rows];
		mCols = columns;
		mRows = rows;
		clearBoard();
	}
	
	public void clearBoard() {
		for (int x = 0; x < mCols; x++) {
			for (int y = 0; y < mRows; y++) {
				mBoard[x][y] = null;
			}
		}
	}
	
	public void dumpBoard() {
		for (int x = 0; x < mCols; x++) {
			System.out.print("##");
		}
		System.out.print("\n");
		for (int y = 0; y < mRows; y++) {
			for (int x = 0; x < mCols; x++) {
				System.out.print(padRight(mBoard[x][y], 8));
				if (x < mCols-1) {
					System.out.print(",");
				}
			}
			System.out.print("\n");
		}
	}
	
	public static String padRight(String s, int n) {
	     return String.format("%1$-" + n + "s", s);  
	}
		
	/**
	 * Checks whether the field is full
	 * @param args : 
	 * @return : Returns true when field is full, otherwise returns false.
	 */
	public boolean isFull() {
		for (int x = 0; x < mCols; x++)
		  for (int y = 0; y < mRows; y++)
		    if (mBoard[x][y] == null)
		      return false; // At least one cell is not filled

		// All cells are filled
		return true;
	}
	
	public void fillBoard(String s) {
        String[] parts = s.split(",");
        int counter = 0;
		for (int y = 0; y < mRows; y++) {
			for (int x = 0; x < mCols; x++) {
				mBoard[x][y] = parts[counter];
				counter++;
			}
		}
	}
	
	public String getCell(int x, int y) {
		return mBoard[x][y];
	}
}