import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class MyBot {

    private Scanner scan = new Scanner(System.in);
    private int mColumns = 7, mRows = 6;
    private Field mField;
    private int mLast = 0;
    public static int mBotId = 0;

    public void run() {
    	mField = new Field(mColumns, mRows);
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
            	}
            	if (parts[1].equals("field_rows")) {
            		mRows = Integer.parseInt(parts[2]);
            	}
            	if (parts[1].equals("bot_id")) {
            		mBotId = Integer.parseInt(parts[2]);
            	}
            } else if(parts[0].equals("update")) { /* new field data */
            	if (parts[2].equals("field")) {
	            	String data = parts[3];
	            	mField = new Field(mColumns, mRows);
	            	mField.parseFromString(data); /* Parse Field with data */
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
    	Ai a = new Ai(mField, mBotId);
    	int move = a.makeTurn();
    	return move;
    }

    public static void main(String[] args) {
        (new MyBot()).run();
    }
}