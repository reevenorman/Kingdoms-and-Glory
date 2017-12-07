/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.view;

import kingdomsandglory.control.ArmyControl;
import kingdomsandglory.kingdomsandglory;
import kingdomsandglory.model.Game;
import kingdomsandglory.model.Resource;

/**
 *
 * @author reeve
 */
public class AttackCityView extends View {
    @Override
    public String[] getInputs() {
    String[] input = new String[1];
    String userInput;
    Boolean valid = false;

    Game game = kingdomsandglory.getCurrentGame();
    
    String city = game.player.actor.location.locationScene.getName();
    int risk = game.player.actor.location.locationScene.getRiskFactor();
    String mineral = game.player.actor.location.locationScene.getMineralTypetoAttack();
    
    
        String questionIntroDisplay;
        
        questionIntroDisplay = ("********************************************\n\n"
                + " You are about to enter the city " + city + "that is not\n"
                + " controlled by you. It requires " + risk + " " + mineral + "\n"
                + " Would you like to try and attack this city? \n"
                + " If not you can probably sneak around. But, you will not \n"
                + " gain anything.                           \n"
                + "\n"
                + " Y - Yes \n"
                + " N - No  \n");
        
        System.out.println(questionIntroDisplay);
        
        String value = this.getInput("Please select a Valid Option");
        String[] inputs = new String[1];
        inputs[0] = value;    
    
    
    return inputs;
    }
    
    @Override
    public boolean doAction(String[] inputs) {
        char menuItem;
        menuItem = inputs[0].toUpperCase().charAt(0);
        Game game = kingdomsandglory.getCurrentGame();
        
        switch (menuItem){
            case 'Y' :
                int risk = game.player.actor.location.locationScene.getRiskFactor();
                String mineral = game.player.actor.location.locationScene.getMineralTypetoAttack();
                int userArmy = game.resourceType[5].resourceQty;
                int cityArmy = game.player.actor.location.locationScene.getRiskArmyFactor();
                
                
                Resource[] resource = game.getResourceType();
                int i = 0;
                do {
                    i++;  
                } while (resource[i].resourceDiscription != mineral);
                
                int userResource = resource[i].getResourceQty();
                
                int result = ArmyControl.battleOutcome(userArmy, userResource, cityArmy, risk);
                
                if (result == 0) {
                    double userResult = userArmy * 0.5;
                    game.resourceType[6].setResourceQty(((int) userResult));
                } else {
                    System.out.println("Congratulations You have conguered this City!");
                    game.player.actor.location.locationScene.setOwnership(0);
                }            
                
                break;
            case 'N' :
                break;
            default :
                System.out.println("Invalid Input");
                
        }
        return false;
        }
    }

