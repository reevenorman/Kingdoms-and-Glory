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

        GameMenuDisplay = " A - Manage Army \n"
                + " R - Manage Resources \n"
                + " M - View Map \n"
                + " H - View Help Menu \n"
                + " S - Save Game \n"
                + " B - Go Back \n";

        System.out.println(GameMenuDisplay);
           
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
            case 'A':
                ManageArmyView manageArmyView = new ManageArmyView();
                manageArmyView.displayManageArmyView();
                break;
            case 'R':
                ManageResourceView manageResourceView = new ManageResourceView();
                manageResourceView.displayManageResourceView();
                break;
            case 'M':
                MapView mapView = new MapView();
                mapView.displayMapView();
                break;
            case 'H':
                HelpMenuView helpMenuView = new HelpMenuView();
                helpMenuView.display();
                break;
            case 'S':
                saveGame();
            case 'B':
                return true;
            default:
                System.out.println("Invalid Input");
        }
        return false;
    }

    private void saveGame() {
        System.out.println("*** Class GameMenuView - saveGame() Called***");
    }
    
}
