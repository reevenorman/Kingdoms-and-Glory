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
    public int displayActorTraitViewFive() {
        boolean endView = false;
        int questionAnswer = 0;
        
        do {
            String[] inputs = getInputs();
            if (inputs.length == 0 || inputs[0].toUpperCase().equals("Q")) {
                return -1;
            }
            questionAnswer = doAction(inputs);
            return questionAnswer;
            
        } while (!endView);
    }


    private String[] getInputs() {
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

    private int doAction(String[] inputs) {
        char menuItem;
        int questionAnswer = 0;
        menuItem = inputs[0].toUpperCase().charAt(0);

        switch (menuItem) {
            case 'A':
                questionAnswer = 1;
                break;
            case 'B':
                questionAnswer = 2;
                break;
            case 'C':
                questionAnswer = 3;
                break;
            default:
                System.out.println("Invalid Input");
                questionAnswer = displayActorTraitViewFive();
        }
        return questionAnswer;
    }
}
