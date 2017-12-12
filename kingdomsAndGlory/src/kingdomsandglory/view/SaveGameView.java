/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kingdomsandglory.control.GameControl;
import kingdomsandglory.exceptions.GameControlException;
import kingdomsandglory.model.Game;

/**
 *
 * @author piano
 */
public class SaveGameView extends View {

    @Override
    public String[] getInputs() {
        String[] input = new String[1];
        String userInput;
        Boolean valid = false;

        String SaveGameDisplay;

        SaveGameDisplay = "To Save Your Game, Please Enter A Valid File Path";

        String value = this.getInput(SaveGameDisplay);
        String[] inputs = new String[1];
        inputs[0] = value;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
         String filePath = inputs[0];
         Game game = kingdomsandglory.kingdomsandglory.getCurrentGame();
         
         try {
             GameControl.saveGame(game, filePath);
         } catch (GameControlException ex) {
             ErrorView.display(this.getClass().getName(), ex.getMessage());
             return false;
         } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
            return false;
        }
         
         this.console.println("Your file was successfully saved in " + filePath);
         return true;
    }
              
}


