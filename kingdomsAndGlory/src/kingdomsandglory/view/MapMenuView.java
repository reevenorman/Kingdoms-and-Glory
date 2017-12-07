/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.view;

import java.util.Scanner;
import kingdomsandglory.kingdomsandglory;
import kingdomsandglory.model.Game;
import kingdomsandglory.model.Location;

/**
 *
 * @author piano
 */
public class MapMenuView extends View{

     @Override
    public String[] getInputs() {
        String[] input = new String[1];
        String userInput;
        Boolean valid = false;

        String MapMenuDisplay;

        MapMenuDisplay = " V - View A Map \n"
                + " M - Move On Map \n"
                + " B - Go Back \n";

        System.out.println(MapMenuDisplay);
           
        String value = this.getInput("Please Choose a Map Menu Item");
        String[] inputs = new String[1];
        inputs[0] = value;
        return inputs;   

    }


    @Override
    public boolean doAction(String[] inputs) {
        char menuItem;
        menuItem = inputs[0].toUpperCase().charAt(0);

        switch (menuItem) {
            case 'V':
                this.displayViewTerritoryView();
                break;
            case 'M':
                MoveOnMapMenuView moveOnMapView = new MoveOnMapMenuView();
                moveOnMapView.displayMoveOnMapView();
                break;
            case 'B':
                return true;
            default:
                System.out.println("Invalid Input");
        }
        return false;
    }
    
    public void displayViewTerritoryView() {
        String nameLocation;
        Game game = kingdomsandglory.getCurrentGame();
            
        Location[][] locations = game.map.locations;

        
        
        System.out.println("          The Kingdom of Zenobia            ");
        System.out.println("      0       1       2       3       4     ");
        System.out.print("------------------------------------------\n");
        int i = 0;
        int j = 0;
        
        
        
        for (Location[] row : locations) {
                System.out.print(i);
                j = 0;
                for (Location[] column : locations) {
                        nameLocation = null;
                        nameLocation = locations[i][j].locationScene.mapSignal;
                        if (locations[i][j] == game.player.actor.location) {
                            nameLocation = ("<" + nameLocation + ">");
                        }
                        else {
                            nameLocation = (" " + nameLocation + " ");
                        }
                        System.out.print(" | " + nameLocation);
                        j++;    
                } 
            i++;
            System.out.print("\n------------------------------------------\n");
        }
    }
}


