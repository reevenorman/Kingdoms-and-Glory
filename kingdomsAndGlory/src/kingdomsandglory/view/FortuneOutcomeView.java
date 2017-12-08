/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.view;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import kingdomsandglory.control.MapControl;
import kingdomsandglory.exceptions.MapControlException;
import kingdomsandglory.model.Game;
import kingdomsandglory.model.Resource;

/**
 *
 * @author reeve
 */
public class FortuneOutcomeView extends View {


    @Override
    public String[] getInputs() {
        String[] input = new String[1];
        String userInput;
        Game game = kingdomsandglory.kingdomsandglory.getCurrentGame();
        String place = game.player.actor.location.locationScene.getName();
        String mineral = game.player.actor.location.locationScene.getMineralTypeThere();
        String MoveMenuDisplay;

        MoveMenuDisplay = ("================================================================\n"
                    + "You have stumbled upon a " + place + ". There is some resources of \n"
                    + " " + mineral + ".  20% of these you can\n"
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
        
        Game game = kingdomsandglory.kingdomsandglory.getCurrentGame();
        
        Resource[] resource = game.getResourceType();
        String mineralChoice;
        String mineral = game.player.actor.location.locationScene.getMineralTypeThere();
        int i = -1;
        do {
            i++;
            mineralChoice = resource[i].getResourceDiscription();
        } while (mineralChoice == mineral);
        
        Random rand = new Random();
        int randResourceAmt = rand.nextInt(100) + 1;
        int ResourceObj = i; 
        int randChanceAmt = rand.nextInt(6) + 1;
        
        
        switch (gambleOption) {
            case 'Y':
                userGambleOption = 1;
        {
            try {
                message = MapControl.fortuneOutcome(userGambleOption, randResourceAmt, ResourceObj, randChanceAmt);
            } catch (MapControlException ex) {
                System.out.println(ex.getMessage());
                return false;
            }
        }
                System.out.println(message);
                return true;
            case 'N':
                userGambleOption = 0;
        {
            try {
                message = MapControl.fortuneOutcome(userGambleOption, randResourceAmt, ResourceObj, randChanceAmt);
            } catch (MapControlException ex) {
                System.out.println(ex.getMessage());
                return false;
            }
        }
                System.out.println(message);
                return true;

            default:
                System.out.println("Invalid Input");
        }
        return false;
    }
}
