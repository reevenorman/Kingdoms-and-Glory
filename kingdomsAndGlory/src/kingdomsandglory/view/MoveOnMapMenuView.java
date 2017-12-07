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
import kingdomsandglory.model.CoordinateMapEnum;
import kingdomsandglory.model.Game;

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
        //try {
        char moveDirection;
        int direction = 0;

        Game game = kingdomsandglory.kingdomsandglory.getCurrentGame();

        Actor actor = game.player.getActor();

        moveDirection = inputs[0].toUpperCase().charAt(0);
        FortuneOutcomeView fortuneOutcomeView = new FortuneOutcomeView();
        AttackCityView attackCityView = new AttackCityView();

        String citysignal = "";

        int validcity;
        boolean setvalid = true;

        try {
            switch (moveDirection) {
                case 'W':
                    direction = 1;
                    MapControl.moveActor(actor, direction);
                    this.attackOption();
                    return true;
                case 'S':
                    direction = 2;
                    MapControl.moveActor(actor, direction);
                    this.attackOption();
                    return true;
                case 'D':
                    direction = 3;
                    MapControl.moveActor(actor, direction);
                    this.attackOption();
                    return true;
                case 'A':
                    direction = 4;
                    MapControl.moveActor(actor, direction);
                    this.attackOption();
                    return true;
                case 'B':
                    return true;
                default:
                    System.out.println("Invalid Input");
            }
        } catch (MapControlException ex) {
            System.out.println(ex);
        }

        //} catch (MapControlException ex) {
        //    System.out.println("MapControlException");
        //}
        return false;
    } 
    
    public void attackOption() {
        char moveDirection;
        int direction = 0;

        Game game = kingdomsandglory.kingdomsandglory.getCurrentGame();

        Actor actor = game.player.getActor();

        FortuneOutcomeView fortuneOutcomeView = new FortuneOutcomeView();
        AttackCityView attackCityView = new AttackCityView();

        String citysignal = "";

        String validMove;
        boolean setvalid = true;
        int plyRow = game.player.actor.location.locationScene.getRowCount();
        int plyCol = game.player.actor.location.locationScene.getColumnCount();

        validMove = game.map.locations[plyRow][plyCol].locationScene.cityscene.getMapSignal();
        
        switch (validMove) {
                case "Mill":
                    fortuneOutcomeView.display();
                    return true;
                case "Frst":
                    direction = 2;
                    MapControl.moveActor(actor, direction);
                    this.attackOption();
                    return true;
                case "Mine":
                    direction = 3;
                    MapControl.moveActor(actor, direction);
                    this.attackOption();
                    return true;
                case "Mtn ":
                    direction = 4;
                    MapControl.moveActor(actor, direction);
                    this.attackOption();
                    return true;
                case 'B':
                    return true;
                default:
                    System.out.println("Invalid Input");
        if (citysignal != "???") {
            if (validcity ) {
                attackCityView.display();
            } else {
                fortuneOutcomeView.display();
            }
        } else {
            fortuneOutcomeView.display();
        }
    }
}
