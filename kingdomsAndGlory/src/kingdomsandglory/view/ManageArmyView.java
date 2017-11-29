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
public class ManageArmyView extends View {
    
    @Override
    public String[] getInputs() {
        
        String[] input = new String[1];
        String userInput;
        Boolean valid = false;
        
        String manageArmyDisplay;
        
        manageArmyDisplay = " A - Buy More Army \n"
                + " S - Sell Army \n"
                + " B - Go Back \n";
        
        System.out.println(manageArmyDisplay);
        
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
            case 'A' : buyMenu();
                break;
            case 'S' : sellMenu();
                break;
            case 'B' : return true;
            default : 
                System.out.println("Invalid Input");
        }
        return false;
            
        }
    }

