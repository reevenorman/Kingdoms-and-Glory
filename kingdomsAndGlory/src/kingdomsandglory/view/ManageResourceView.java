/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.view;

import kingdomsandglory.model.Resource;
import kingdomsandglory.model.Game;
/**
 *
 * @author reeve
 */
public class ManageResourceView extends View {
        
    @Override
    public String[] getInputs() {
        Game game = new Game();
        game = kingdomsandglory.kingdomsandglory.getCurrentGame();
        
        String[] input = new String[1];
        String userInput;
        Boolean valid = false;
        int i = 0;
        
        String manageResourceDisplay;
        
        Resource[] resources = game.resourceType;
        String resourceList = "";
        
        for (Resource eachResource : resources) {
            resourceList = resourceList + (" " + eachResource.resourceDiscription + " - " + eachResource.resourceQty + "\n");
        }
        
        manageResourceDisplay = 
                  "*****************************************************\n"
                + "* In this game you have the opportunity to buy and  *\n"
                + "* sell resources. Here is a list of Resources and   *\n"
                + "* their cost.                                       *\n"
                + "* Resource - Buying Price/Selling Price             *\n"
                + "* Cloth    -  2 / 1                                 *\n"
                + "* Wood     -  3 / 2                                 *\n"
                + "* Stone    -  3 / 2                                 *\n"
                + "* Metal    -  5 / 3                                 *\n"
                + "* Army     -  7 / 1                                 *\n"
                + "*                                                   *\n"
                + "* Also, Here is a list of your current Resources:   *\n" 
                + "-----------------------------------------------------\n"
                + resourceList
                + "-----------------------------------------------------\n"
                + "* Would you like to Buy/Sell resources?             *\n"
                + "* V - Yes                                           *\n"
                + "* B - No                                            *\n"
                + "-----------------------------------------------------\n";
        
                
        this.console.println(manageResourceDisplay);
        
        String value = this.getInput("Please Select an option");
        String[] inputs = new String[1];
        inputs[0] = value;
        return inputs;        
        
    }
    
    @Override
    public boolean doAction(String[] inputs) {
        char menuItem;
        menuItem = inputs[0].toUpperCase().charAt(0);
        
        switch (menuItem){
            case 'V' : BuySellView buySellView = new BuySellView();
                buySellView.display();
                break;
            case 'B' : return true;
            default : 
                ErrorView.display(this.getClass().getName(),"Invalid Input");
        }
        return false;
            
        }
}

