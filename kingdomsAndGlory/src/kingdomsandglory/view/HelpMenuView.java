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
public class HelpMenuView {

    static void displayHelpMenuView() {
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

        String mainMenuDisplay;

        mainMenuDisplay = " A - Learn About Army \n"
                + " R - Learn About Resources \n"
                + " M - Learn About Map and Movement \n"
                + " C - Learn About Waging War and Conquering Cities \n"
                + " B - Go Back \n";

        System.out.println(mainMenuDisplay);

        while (!valid) {
            System.out.println("Please choose a help menu Item");
            Scanner inputName;
            inputName = new Scanner(System.in);
            input[0] = inputName.nextLine();
            input[0] = input[0].trim();

            if (input[0].length() == 0) {
                System.out.print("You must enter a valid help menu item!\n");
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
            case 'A':
                armyInfoView();
                break;
            case 'R':
                resourceInfoView();
                break;
            case 'M':
                mapAndMovementInfoView();
                break;
            case 'C':
                conquerCitiesInfoView();
                break;
            case 'B':
                MainMenuView.displayMainMenuView();
                break;
            case 'Q':
                return true;
            default:
                System.out.println("Invalid Input");
        }
        return false;
    }

    private static void armyInfoView() {
        System.out.println("*** The following menu will be displayed:\n"
                + "\n"
                + "G - Gain Recruits\n"
                + "S - Sell Army\n"
                + "B - Go Back\n"
                + "\n"
                + "Also displayed with this menu will be a list of the different types of troops/soldiers \n"
                + "currently in the user’s army and the amount of money that is available as \n"
                + "a resource. Displayed with the menu is a cost of recruits. The player enters \n"
                + "the letter representing the command they would like to give the computer. If an \n"
                + "invalid key is attempted, the end user is requested to enter a valid command and \n"
                + "the menu is redisplayed. If the user enters a valid command, depending on the command, \n"
                + "the program will show the following for the user. If the user requests more army, the \n"
                + "program will then ask how many of which type of soldier. The user then enters the amount \n"
                + "thus decreasing money and increasing that aspect of the army. If the user types an invalid \n"
                + "amount in due to the fact that there is not enough money, the message displayed will say, \n"
                + "“Not enough money.” After the appropriate message is displayed to the user the program then \n"
                + "reruns the Manage Army Menu. Under the command to sell recruits, the user will be asked how \n"
                + "many men they would like to sell of which type. Once the sale is final, the adjusted numbers \n"
                + "will be shown in the list of army numbers and money numbers. ***");
    }

    private static void resourceInfoView() {
        System.out.println("*** HelpMenuView - resourceInfoView() Called ***");
    }

    private static void mapAndMovementInfoView() {
        System.out.println("*** HelpMenuView - mapAndMovementInfoView() Called ***");
    }

    private static void conquerCitiesInfoView() {
        System.out.println("*** HelpMenuView - conquerCitiesInfoView() Called ***");
    }

}
