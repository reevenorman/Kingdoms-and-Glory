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
public class MapView {

    static void displayMapView() {
        boolean endView = false;
        do {
            String[] inputs = getInputs();
            if (inputs.length == 0 || inputs[0].toUpperCase().equals("Q")) {
                return;
            }
            endView = doAction(inputs);

        } while (!endView);
    }

    private static String[] getInputs() {
        String[] input = new String[1];
        String userInput;
        Boolean valid = false;

        String GameMenuDisplay;

        GameMenuDisplay = " V - View A Territory \n"
                + " M - Move On Map \n"
                + " B - Go Back \n";

        System.out.println(GameMenuDisplay);

        while (!valid) {
            System.out.println("Please choose a Map Menu Item");
            Scanner inputName;
            inputName = new Scanner(System.in);
            input[0] = inputName.nextLine();
            input[0] = input[0].trim();

            if (input[0].length() == 0) {
                System.out.print("You must enter a valid Map Menu item!\n");
            } else {
                valid = true;
            }
        }
        return input;
    }

    private static boolean doAction(String[] inputs) {
        char menuItem;
        menuItem = inputs[0].toUpperCase().charAt(0);

        switch (menuItem) {
            case 'V':
                ViewTerritoryView.displayViewTerritoryView();
                break;
            case 'M':
                MoveOnMapView.displayMoveOnMapView();
                break;
            case 'B':
                return true;
            default:
                System.out.println("Invalid Input");
        }
        return false;
    }

    private static void saveGame() {
        System.out.println("*** Class GameMenuView - saveGame() Called***");
    }
}
