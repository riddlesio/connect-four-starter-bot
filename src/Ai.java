// Copyright 2015 theaigames.com (developers@theaigames.com)

//    Licensed under the Apache License, Version 2.0 (the "License");
//    you may not use this file except in compliance with the License.
//    You may obtain a copy of the License at

//        http://www.apache.org/licenses/LICENSE-2.0

//    Unless required by applicable law or agreed to in writing, software
//    distributed under the License is distributed on an "AS IS" BASIS,
//    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//    See the License for the specific language governing permissions and
//    limitations under the License.
//	
//    For the full copyright and license information, please view the LICENSE
//    file that was distributed with this source code.

import java.util.Random;

/**
 * Ai class
 * 
 * Magic happens here.
 * 
 * @author Jim van Eeden <jim@starapple.nl>
 */

public class Ai {	
     Field field;

     /**
      * Constructor.
      *
      * @param Field field, int player
      */
     public Ai(Field field, int player) {
         this.field = field;
     }

     /**
      * Makes a turn.
      *
      * @return The column where the turn was made.
      */
     public int makeTurn() {
         int move = new Random().nextInt(7);     
         return move;
     }
 }
