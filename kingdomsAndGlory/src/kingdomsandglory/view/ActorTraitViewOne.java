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
public class ActorTraitViewOne {
    static void displayActorTraitViewOne() {
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

        String ActorTraitOneDisplay;

        ActorTraitOneDisplay = " Question 1: When negotiating with a foreign empire, are you more likley to... \n"
                + " A - Meet formally, and discuss matters of concern through proper channels? \n"
                + " B - Meet formally, and have a carefully crafted plan of what you want to accomplish? \n"
                + " C - Meet informally, entertain your guest and convince them of your desires? \n";

        System.out.println(ActorTraitOneDisplay);

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
                PlayerControl.assignActorTrait();
                break;
            case 'B':
                PlayerControl.assignActorTrait();
                break;
            case 'C':
                PlayerControl.assignActorTrait();
                break;
            default:
                System.out.println("Invalid Input");
        }
        return false;
    }
}
