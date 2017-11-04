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
public class ActorTraitViewFive {
    static void displayActorTraitViewFive() {
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

        String ActorTraitFiveDisplay;

        ActorTraitFiveDisplay = " Question 5: When you gain a victory, do you... \n"
                + " A - Have a modest gathering, to acknowledge the victory? \n"
                + " B - Begin plotting for your next impending victory? \n"
                + " C - Celebrate all night long? \n";

        System.out.println(ActorTraitFiveDisplay);

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
                long questionFive = 1;
                ActorTraitResultView.displayActorTraitResultView();
                break;
            case 'B':
                questionFive = 2;
                ActorTraitResultView.displayActorTraitResultView();
                break;
            case 'C':
                questionFive = 3;
                ActorTraitResultView.displayActorTraitResultView();
                break;
            default:
                System.out.println("Invalid Input");
        }
        return false;
    }
}
