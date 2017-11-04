/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.view;

import java.util.Scanner;
import kingdomsandglory.control.PlayerControl;

/**
 *
 * @author piano
 */
public class ActorTraitViewFour {
    static void displayActorTraitViewFour() {
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

        String ActorTraitFourDisplay;

        ActorTraitFourDisplay = " Question 4: Your treasurer has been taking gold from your vault. Will you... \n"
                + " A - Bring him to justice in the juducial courts of the kingdom? \n"
                + " B - Set a trap to convict him? \n"
                + " C - Slay him in the thralls of your anger? \n";

        System.out.println(ActorTraitFourDisplay);

        while (!valid) {
            System.out.println("Please answer the question");
            Scanner inputName;
            inputName = new Scanner(System.in);
            input[0] = inputName.nextLine();
            input[0] = input[0].trim();

            if (input[0].length() == 0) {
                System.out.print("You must enter a valid answer!\n");
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
                long questionFour = 1;
                ActorTraitViewFive.displayActorTraitViewFive();
                break;
            case 'B':
                questionFour = 2;
                ActorTraitViewFive.displayActorTraitViewFive();
                break;
            case 'C':
                questionFour = 3;
                ActorTraitViewFive.displayActorTraitViewFive();
                break;
            default:
                System.out.println("Invalid Input");
        }
        return false;
    }
}
