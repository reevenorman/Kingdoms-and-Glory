/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.view;

import java.io.IOException;
import kingdomsandglory.control.GameControl;
import kingdomsandglory.exceptions.GameControlException;
import kingdomsandglory.model.Game;

/**
 *
 * @author piano
 */
public class LoadGameView extends View{
        @Override
    public String[] getInputs() {
        String[] input = new String[1];
        String userInput;
        Boolean valid = false;

        String LoadGameDisplay;

        LoadGameDisplay = "To Load Your Game, Please Enter The Valid File Path Where It Was Saved";

        String value = this.getInput(LoadGameDisplay);
        String[] inputs = new String[1];
        inputs[0] = value;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
         String filePath = inputs[0];
         Game game = kingdomsandglory.kingdomsandglory.getCurrentGame();
         
         try {
             GameControl.LoadGame(filePath);
         } catch (GameControlException ex) {
             ErrorView.display(this.getClass().getName(), ex.getMessage());
             return false;
         } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
            return false;
         } catch (ClassNotFoundException ex) {
             ErrorView.display(this.getClass().getName(), ex.getMessage());
         }
         
         GameMenuView gameMenuView = new GameMenuView();
         gameMenuView.display();
         return true;
    }
     
}
