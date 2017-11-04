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
public class ActorTraitViewTwo {
    static void displayActorTraitViewTwo() {
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

        String ActorTraitTwoDisplay;

        ActorTraitTwoDisplay = " Question 2: While playiing chess do you... \n"
                + " A - Play in a way that makes the game fair and beneficial to both parties? \n"
                + " B - Plan out each move in advance for the greatest chance of winning?\n"
                + " C - Make your moves based on the current moment? \n";

        System.out.println(ActorTraitTwoDisplay);

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
                long questionTwo = 1;
                ActorTraitViewThree.displayActorTraitViewThree();
                break;
            case 'B':
                questionTwo = 2;
                ActorTraitViewThree.displayActorTraitViewThree();
                break;
            case 'C':
                questionTwo = 3;
                ActorTraitViewThree.displayActorTraitViewThree();
                break;
            default:
                System.out.println("Invalid Input");
        }
        return false;
    }
}