/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.view;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import kingdomsandglory.control.GameControl;
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

        this.console.println(MoveOnMapMenuDisplay);

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
        MapMenuView mapMenuView = new MapMenuView();

        String citysignal = "";

        int validcity;
        boolean setvalid = true;

        try {
            switch (moveDirection) {
                case 'W':
                    direction = 1;
                    MapControl.moveActor(actor, direction);
                    this.attackOption();
                    this.checkForWin();
                    mapMenuView.displayMap();
                    return false;
                case 'S':
                    direction = 2;
                    MapControl.moveActor(actor, direction);
                    this.attackOption();
                    this.checkForWin();
                    mapMenuView.displayMap();
                    return false;
                case 'D':
                    direction = 3;
                    MapControl.moveActor(actor, direction);
                    this.attackOption();
                    this.checkForWin();
                    return false;
                case 'A':
                    direction = 4;
                    MapControl.moveActor(actor, direction);
                    this.attackOption();
                    this.checkForWin();
                    mapMenuView.displayMap();
                    return false;
                case 'B':
                    return true;
                default:
                    ErrorView.display(this.getClass().getName(),"Invalid Input");
            }
        } catch (MapControlException ex) {
            ErrorView.display(this.getClass().getName(), "Moving the actor did not work.");
        }

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
                    } else {
                        this.console.println("You already own this city! But, You might be able to get some resources here");
                        fortuneOutcomeView.display();
                    }
                    return;
                case "Genu":
                    if (owned == 1) {
                        attackCityView.display();
                    } else {
                        this.console.println("You already own this city! But, You might be able to get some resources here");
                        fortuneOutcomeView.display();
                    }
                    return;
                case "Pace":
                    if (owned == 1) {
                        attackCityView.display();
                    } else {
                        this.console.println("You already own this city! But, You might be able to get some resources here");
                        fortuneOutcomeView.display();
                    }
                    return;
                case "Feli":
                    if (owned == 1) {
                        attackCityView.display();
                    } else {
                        this.console.println("You already own this city! But, You might be able to get some resources here");
                        fortuneOutcomeView.display();
                    }
                    return;
                case "Pulc":
                    if (owned == 1) {
                        attackCityView.display();
                    } else {
                        this.console.println("You already own this city! But, You might be able to get some resources here");
                        fortuneOutcomeView.display();
                    }
                    return;
                case "Zeno":
                    if (owned == 1) {
                        attackCityView.display();
                    } else {
                        this.console.println("You already own this city! But, You might be able to get some resources here");
                        fortuneOutcomeView.display();
                    }
                    return;
        }
    }
    
    public void checkForWin() {
        Game game = kingdomsandglory.kingdomsandglory.getCurrentGame();
        
        int win = GameControl.checkWin(game);
        
        if (win == 0) {
            WinView winView = new WinView();
            winView.display();
        } else {
            return;
        }
    }
}
