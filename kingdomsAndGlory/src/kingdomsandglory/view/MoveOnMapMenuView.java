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
        int owned = 0;
        int plyRow = game.player.actor.location.locationScene.getRowCount();
        int plyCol = game.player.actor.location.locationScene.getColumnCount();

        validMove = game.map.locations[plyRow][plyCol].locationScene.getMapSignal();
        
        owned = game.map.locations[plyRow][plyCol].locationScene.getOwnership();
        
        switch (validMove) {
                case "Mill":
                    fortuneOutcomeView.display();
                    return;
                case "Frst":
                    fortuneOutcomeView.display();
                    return;
                case "Mine":
                    fortuneOutcomeView.display();
                    return;
                case "Mtn ":
                    fortuneOutcomeView.display();
                    return;
                case "Visu":
                    if (owned == 1) {
                        attackCityView.display();
                        fortuneOutcomeView.display();
                    } else {
                        System.out.println("You already own this city! But, You might be able to get some resources here");
                        fortuneOutcomeView.display();
                    }
                    return;
                case "Genu":
                    if (owned == 1) {
                        attackCityView.display();
                        fortuneOutcomeView.display();
                    } else {
                        System.out.println("You already own this city! But, You might be able to get some resources here");
                        fortuneOutcomeView.display();
                    }
                    return;
                case "Pace":
                    if (owned == 1) {
                        attackCityView.display();
                        fortuneOutcomeView.display();
                    } else {
                        System.out.println("You already own this city! But, You might be able to get some resources here");
                        fortuneOutcomeView.display();
                    }
                    return;
                case "Feli":
                    if (owned == 1) {
                        attackCityView.display();
                        fortuneOutcomeView.display();
                    } else {
                        System.out.println("You already own this city! But, You might be able to get some resources here");
                        fortuneOutcomeView.display();
                    }
                    return;
                case "Pulc":
                    if (owned == 1) {
                        attackCityView.display();
                        fortuneOutcomeView.display();
                    } else {
                        System.out.println("You already own this city! But, You might be able to get some resources here");
                        fortuneOutcomeView.display();
                    }
                    return;
                case "Zeon":
                    if (owned == 1) {
                        attackCityView.display();
                        fortuneOutcomeView.display();
                    } else {
                        System.out.println("You already own this city! But, You might be able to get some resources here");
                        fortuneOutcomeView.display();
                    }
                    return;
        }
    }

}
