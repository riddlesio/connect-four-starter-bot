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

import java.util.Scanner;

/**
 * MyBot class
 * 
 * Main class that will keep reading output from the engine.
 * Will either update the bot state or get actions.
 * 
 * @author Jim van Eeden <jim@starapple.nl>, Joost de Meij <joost@starapple.nl>
 */

public class BotParser {
    
    private Scanner scan = new Scanner(System.in);
    private int mColumns = 7, mRows = 6;
    private Field mField;
    public static int mBotId = 0;

    public void run() {
        mField = new Field(mColumns, mRows);
        while(scan.hasNextLine()) {
            String line = scan.nextLine();

            if(line.length() == 0) {
                continue;
            }

            String[] parts = line.split(" ");
            
            if(parts[0].equals("settings")) {
                if (parts[1].equals("field_columns")) {
                    mColumns = Integer.parseInt(parts[2]);
                }
                if (parts[1].equals("field_rows")) {
                    mRows = Integer.parseInt(parts[2]);
                }
                if (parts[1].equals("your_botid")) {
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
        BotStarter a = new BotStarter(mField, mBotId);
        int move = a.makeTurn();
        return move;
    }

    public static void main(String[] args) {
        (new BotParser()).run();
    }
}