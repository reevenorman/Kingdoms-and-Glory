/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.view;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import kingdomsandglory.control.MapControl;
import kingdomsandglory.exceptions.MapControlException;
import kingdomsandglory.model.Actor;
import static kingdomsandglory.model.Player.getActor;

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

        MoveOnMapMenuDisplay = " W - Up \n"
                + " S - Down \n"
                + " D - Right \n"
                + " A - Left \n"
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
        try {
            char moveDirection;
            int direction;
            Actor actor = new Actor();
            actor = getActor();
            moveDirection = inputs[0].toUpperCase().charAt(0);
            FortuneOutcomeView fortuneOutcomeView = new FortuneOutcomeView();
            switch (moveDirection) {
                case 'W':
                    direction = 1;
                    MapControl.moveActor(actor, direction);
                    fortuneOutcomeView.display();
                    break;
                case 'S':
                    direction = 2;
                    MapControl.moveActor(actor, direction);
                    fortuneOutcomeView.display();
                    break;
                case 'D':
                    direction = 3;
                    MapControl.moveActor(actor, direction);
                    fortuneOutcomeView.display();
                    break;
                case 'A':
                    direction = 4;
                    MapControl.moveActor(actor, direction);
                    fortuneOutcomeView.display();
                    break;
                case 'B':
                    return true;
                default:
                    System.out.println("Invalid Input");
            }

        } catch (MapControlException ex) {
            System.out.println("MapControlException");
        }
        return false;
    }
}
