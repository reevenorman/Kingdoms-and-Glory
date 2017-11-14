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
public class MapMenuView extends View{

     @Override
    public String[] getInputs() {
        String[] input = new String[1];
        String userInput;
        Boolean valid = false;

        String MapMenuDisplay;

        MapMenuDisplay = " V - View A Territory \n"
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
                ViewTerritoryView.displayViewTerritoryView();
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
}
