/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.view;

import java.util.Scanner;

/**
 *
 * @author piano
 */
public class GameMenuView extends View {


    @Override
    public String[] getInputs() {
        String[] input = new String[1];
        String userInput;
        Boolean valid = false;

        String GameMenuDisplay;

        GameMenuDisplay = 
                  " R - Manage Resources and Army \n"
                + " M - View Map Menu \n"
                + " H - View Help Menu \n"
                + " S - Save Game \n"
                + " P - Print Resources \n"
                + " L - Print Locations \n"
                + " B - Go Back to Main Menu \n"
                + " X - Quit \n";

        this.console.println(GameMenuDisplay);
           
        String value = this.getInput("Please Choose a Game Menu Item");
        String[] inputs = new String[1];
        inputs[0] = value;
        return inputs;   

    }

    @Override
    public boolean doAction(String[] inputs) {
        char menuItem;
        menuItem = inputs[0].toUpperCase().charAt(0);

        switch (menuItem) {
            case 'R':
                ManageResourceView manageResourceView = new ManageResourceView();
                manageResourceView.display();
                break;
            case 'M':
                MapMenuView mapMenuView = new MapMenuView();
                mapMenuView.display();
                break;
            case 'H':
                HelpMenuView helpMenuView = new HelpMenuView();
                helpMenuView.display();
                break;
            case 'S':
                SaveGameView saveGameView = new SaveGameView();
                saveGameView.display();
            case 'P':
                PrintLogView printLogView = new printLogView();
                printLogView.display();
            case 'L':
                PrintLogView printLogView = new printLogView();
                printLogView.display();
            case 'B':
                MainMenuView mainMenuView = new MainMenuView();
                mainMenuView.display();
            case 'X':
                System.exit(0);
            default:
                ErrorView.display(this.getClass().getName(), "Invalid Input");
        }
        return false;
    }
    
}
