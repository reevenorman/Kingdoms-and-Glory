/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.view;
import kingdomsandglory.control.PlayerControl;

import java.util.Scanner;
import kingdomsandglory.view.StartProgramView;
/**
 *
 * @author piano
 */
public class ActorTraitResultView {
    static void displayActorTraitResultView() {
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
        int actorTrait;
        String actorTraitName;
        Boolean valid = false;
        
        actorTrait = kingdomsandglory.control.PlayerControl.collectData();
        switch (actorTrait) {
            case 1:
                actorTraitName = "Diplomatic";
                break;
            case 2:
                actorTraitName = "Strategic";
                break;
            case 3:
                actorTraitName = "Charismatic";
                break; 
            default:
                actorTraitName = "Invalid Input";
        }

        System.out.println("========================================\n"
                        + "Congratulations, " + "(savePlayerName) accessed" + "!\n"
                        + "You have received the trait of " + actorTraitName + "!\n"
                        + "You will be known as " + "(savePlayerName) accessed" + " the " +  actorTraitName + "!\n"
                        + "Each attribute you receive gives you a unique starting advantage in your resources. \n"
                        + "View your resources to see what advantages you have received! \n"
                        + "\n"
                        + "C - Continue \n"
                        + "========================================\n");

        while (!valid) {
            System.out.println("Please enter 'C' to continue" );
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
            case 'C':
                GameMenuView.displayGameMenuView();
                break;
            default:
                System.out.println("Invalid Input");
        }
        return false;
    }
}
