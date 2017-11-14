/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.view;

import java.util.Random;
import kingdomsandglory.control.MapControl;

/**
 *
 * @author reeve
 */
public class FortuneOutcomeView extends View {


    @Override
    public String[] getInputs() {
        String[] input = new String[1];
        String userInput;

        String MoveMenuDisplay;

        MoveMenuDisplay = ("================================================================\n"
                    + "You have stumbled upon a pile of resources. 20% of these you can\n"
                    + "certainly take. But, you might have to gamble for the other 80% \n"
                    + "Would you like to game for the other 80%?\n"
                    + "Y - Yes\n"
                    + "N - No\n"
                    + "================================================================");

        System.out.println(MoveMenuDisplay);

        String value = this.getInput("Please Type an Answer.");
        String[] inputs = new String[1];
        inputs[0] = value;
        return inputs;   
    }

    @Override
    public boolean doAction(String[] inputs) {
        char gambleOption;
        int userGambleOption;
        String message;
        gambleOption = inputs[0].toUpperCase().charAt(0);
        
        Random rand = new Random();
        int randResourceAmt = rand.nextInt(101) + 1;
        int randResourceObj = rand.nextInt(3) + 0;
        int randChanceAmt = rand.nextInt(7) + 1;

        switch (gambleOption) {
            case 'Y':
                userGambleOption = 1;
                message = MapControl.fortuneOutcome(userGambleOption, randResourceAmt, randResourceObj, randChanceAmt);
                System.out.println(message);
                return true;
            case 'N':
                userGambleOption = 0;
                message = MapControl.fortuneOutcome(userGambleOption, randResourceAmt, randResourceObj, randChanceAmt);
                System.out.println(message);
                return true;

            default:
                System.out.println("Invalid Input");
        }
        return false;
    }
}
