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
public class MoveOnMapView {

       public void displayMoveOnMapView() {
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

        String MoveMenuDisplay;

        MoveMenuDisplay = " E - Move North \n"
                + " D - Move South \n"
                + " F - Move East \n"
                + " S - Move West \n"
                + " B - Go Back \n";

        System.out.println(MoveMenuDisplay);

        while (!valid) {
            System.out.println("Please Choose a Direction to Move on the Map");
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

    private boolean doAction(String[] inputs) {
        char moveDirection;
        moveDirection = inputs[0].toUpperCase().charAt(0);
        MoveOutcomeView moveOutcomeView = new MoveOutcomeView();
        switch (moveDirection) {
            case 'E':
                moveNorth();
                moveOutcomeView.display();
                break;
            case 'D':
                moveSouth();
                moveOutcomeView.display();
                break;
            case 'F':
                moveEast();
                moveOutcomeView.display();
                break;
            case 'S':
                moveWest();
                moveOutcomeView.display();
                break;
            case 'B':
                return true;
            default:
                System.out.println("Invalid Input");
        }
        return false;
    }

    private void moveNorth() {
        System.out.println("*** Class MoveOnMap - moveNorth() Called***");
    }

    private void moveSouth() {
        System.out.println("*** Class MoveOnMap - moveSouth() Called***");
    }

    private void moveEast() {
        System.out.println("*** Class MoveOnMap - moveEast() Called***");
    }

    private void moveWest() {
        System.out.println("*** Class MoveOnMap - moveWest() Called***");
    }
}
