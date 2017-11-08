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
public class GameMenuView {
        public void displayGameMenuView() {
        boolean endView = false;
        do {
            String[] inputs = getInputs();
            if (inputs.length == 0 || inputs[0].toUpperCase().equals("Q")) {
                return;
            }
            endView = doAction(inputs);

        } while (!endView);
    }

    private String[] getInputs() {
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

        while (!valid) {
            System.out.println("Please choose a game menu Item");
            Scanner inputName;
            inputName = new Scanner(System.in);
            input[0] = inputName.nextLine();
            input[0] = input[0].trim();

            if (input[0].length() == 0) {
                System.out.print("You must enter a valid game menu item!\n");
            } else {
                valid = true;
            }
        }
        return input;
    }

    private boolean doAction(String[] inputs) {
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
                helpMenuView.displayHelpMenuView();
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
