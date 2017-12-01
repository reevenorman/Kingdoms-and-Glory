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
public class MoveOnMapMenuView extends View {

    @Override
    public String[] getInputs() {
        String[] input = new String[1];
        String userInput;
        Boolean valid = false;

        String MoveOnMapMenuDisplay;

        MoveOnMapMenuDisplay = " W - UP \n"
                + " S - Move South \n"
                + " D - Move East \n"
                + " A - Move West \n"
                + " B - Go Back \n";

        System.out.println(MoveOnMapMenuDisplay);
           
        String value = this.getInput("Please Choose a Menu Item");
        String[] inputs = new String[1];
        inputs[0] = value;
        return inputs;   
    }
    
    
    
    
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


    @Override
    public boolean doAction(String[] inputs) {
        char moveDirection;
        moveDirection = inputs[0].toUpperCase().charAt(0);
        FortuneOutcomeView fortuneOutcomeView = new FortuneOutcomeView();
        switch (moveDirection) {
            case 'W':
                moveNorth();
                fortuneOutcomeView.display();
                break;
            case 'S':
                moveSouth();
                fortuneOutcomeView.display();
                break;
            case 'D':
                moveEast();
                fortuneOutcomeView.display();
                break;
            case 'A':
                moveWest();
                fortuneOutcomeView.display();
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
