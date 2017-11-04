/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.view;

import java.util.Scanner;
import kingdomsandglory.control.MapControl;

/**
 *
 * @author reeve
 */
public class MoveOutcomeView {
    static void displayMoveOutcomeView() {
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

        String MoveMenuDisplay;

        MoveMenuDisplay = ("================================================================\n"
                    + "You have stumbled upon a pile of resources. 20% of these you can\n"
                    + "certainly take. But, you might have to gamble for the other 80% \n"
                    + "Would you like to game for the other 80%?\n"
                    + "Y - Yes\n"
                    + "N - No\n"
                    + "================================================================");

        System.out.println(MoveMenuDisplay);

        while (!valid) {
            System.out.println("Please Enter Y or N");
            Scanner inputName;
            inputName = new Scanner(System.in);
            input[0] = inputName.nextLine();
            input[0] = input[0].trim();

            if (input[0].length() == 0) {
                System.out.print("Please Enter a Valid Command \n");
            } else {
                valid = true;
            }
        }
        return input;
    }

    private static boolean doAction(String[] inputs) {
        char gambleOption;
        int userGambleOption;
        String message;
        gambleOption = inputs[0].toUpperCase().charAt(0);

        switch (gambleOption) {
            case 'Y':
                userGambleOption = 1;
                message = MapControl.moveOutcome(userGambleOption);
                System.out.println(message);
                return true;
            case 'N':
                userGambleOption = 0;
                message = MapControl.moveOutcome(userGambleOption);
                System.out.println(message);
                return true;

            default:
                System.out.println("Invalid Input");
        }
        return false;
    }
}
