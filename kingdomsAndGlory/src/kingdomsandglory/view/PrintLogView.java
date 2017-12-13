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
public class PrintLogView extends View {

    @Override
    public String[] getInputs() {
        String[] input = new String[1];
        String userInput;
        Boolean valid = false;

        String[] inputs = new String[2];

        String printLogDisplay;

        printLogDisplay = "Would you like to print: \n"
                + " P - Resources \n"
                + " L - Locations\n"
                + " R - Read previous print file";

        String value = this.getInput(printLogDisplay);
        inputs[0] = value;

        printLogDisplay = "To export the print file, please Enter a valid file path";

        value = this.getInput(printLogDisplay);

        inputs[1] = value;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        String filePath = inputs[1];
        char menuItem;
        menuItem = inputs[0].toUpperCase().charAt(0);
        Game game = kingdomsandglory.kingdomsandglory.getCurrentGame();
        String message = "";

        switch (menuItem) {
            case 'P':
                try {
                    GameControl.printResources(game, filePath);
                } catch (GameControlException ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());
                    return false;
                } catch (IOException ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());
                    return false;
                }
                this.console.println("\n"
                        + "Your file was successfully saved to " + filePath + "\n");
                break;

            case 'L':
                try {
                    GameControl.printLocations(game, filePath);
                } catch (GameControlException ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());
                    return false;
                } catch (IOException ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());
                    return false;
                }
                this.console.println("\n"
                        + "Your file was successfully saved to " + filePath + "\n");
                break;  
                
            case 'R':
                 try {
                    message = GameControl.LoadDocument(filePath);
                } catch (GameControlException ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());
                    return false;
                } catch (IOException ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());
                    return false;
                } catch (ClassNotFoundException ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());
                    return false;
                }
                this.console.println(message);
                break;
        }
        return true;
    }
}
