import java.util.Random;

public class Ai {
     Field field;

     /**
      * Constructor.
      *
      * @param board
      */
     public Ai(Field field, int player) {
         this.field = field;
     }

     /**
      * This is where the magic happens.
      *
      * @return The column where the turn was made.
      */
     public int makeTurn() {
         int move = 0;
         Random r = new Random();
         move = r.nextInt(field.getNrColumns());
         return move;
     }
 }
