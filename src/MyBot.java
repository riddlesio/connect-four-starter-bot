import java.util.Random;
import java.util.Scanner;

public class MyBot {
	/* Starter bot for ConnectFour
	 * Stores the field it receives, returns a random column to add a token.
	 */

    private Scanner scan = new Scanner(System.in);
    private int mColumns = 0;
    private int mRows = 0;
    
    private Field mField;

    public void run() {
    	while(scan.hasNextLine()) {
            String line = scan.nextLine();

            if(line.length() == 0) {
                continue;
            }

            String[] parts = line.split(" ");

            if (parts[0].equals("pick_starting_region")) {
            } else if(parts[0].equals("settings")) {
            	if (parts[1].equals("field_columns")) {
            		mColumns = Integer.parseInt(parts[2]);
            		mField = new Field(mColumns, mRows);
            	} else if (parts[1].equals("field_rows")) {
            		mRows = Integer.parseInt(parts[2]);
            		mField = new Field(mColumns, mRows);
            	}
            } else if(parts[0].equals("update")) {
            	if (parts[1].equals("field")) { /* new board data */
            		mField.fillBoard(parts[3]);
            		//mField.dumpBoard();
            	}
            } else if(parts[0].equals("action")) {
            	if (parts[1].equals("move")) { /* move requested */
            		int column = calculateMove();
            		System.out.println("place_disc " + column);
            	}
            }
            else { 
            	System.out.println("unknown command");
            }
        }
    }
    
    private int calculateMove() {
    	return new Random().nextInt(mColumns+2); /* Returns random column */
    }

    public static void main(String[] args) {
        (new MyBot()).run();
    }
}