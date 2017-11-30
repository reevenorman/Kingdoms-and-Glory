/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.view;

/**
 *
 * @author piano
 */
public class ManageResourceView extends View{

@Override
    public String[] getInputs() {
        
        String[] input = new String[1];
        String userInput;
        Boolean valid = false;
        
        String manageResourceDisplay;
        
        manageResourceDisplay = " A - Buy More of a Resource \n"
                + " S - Sell Resource \n"
                + " B - Go Back \n";
        
        System.out.println(manageResourceDisplay);
        
        String value = this.getInput("Please choose a menu Item");
        String[] inputs = new String[1];
        inputs[0] = value;
        return inputs;        
        
    }
    
    @Override
    public boolean doAction(String[] inputs) {
        char menuItem;
        menuItem = inputs[0].toUpperCase().charAt(0);
        
        switch (menuItem){
            case 'A' :
                BuySellArmyView buySellArmyView = new BuySellArmyView();
                buySellArmyView.display();
                break;
            case 'S' : sellResourceMenu();
                break;
            case 'B' : return true;
            default : 
                System.out.println("Invalid Input");
        }
        return false;
            
        }
    }
}
