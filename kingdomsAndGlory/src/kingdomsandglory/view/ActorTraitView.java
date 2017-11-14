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
public class ActorTraitView extends View {
       
    
    @Override
    public String[] getInputs() {
    String[] input = new String[1];
    String userInput;
    Boolean valid = false;
        
        String questionIntroDisplay;
        
        questionIntroDisplay = ("********************************************\n\n"
                + " In order to Determine the Resources you  \n"
                + " begin with, you will be asked a series   \n"
                + " of questions to determine what kind of   \n"
                + " leader that you are.                     \n");
        
        System.out.println(questionIntroDisplay);
        
        ActorTraitResultView actorTraitResultView = new ActorTraitResultView();
        actorTraitResultView.display();
        
        String value = this.getInput("Please Type Any Letter to Continue.");
        String[] inputs = new String[1];
        inputs[0] = value;    
    
    
    return inputs;
    }
    
    @Override
    public boolean doAction(String[] inputs) {
        char menuItem;
        menuItem = inputs[0].toUpperCase().charAt(0);
        GameMenuView gameMenuView = new GameMenuView();
        
        switch (menuItem){
            case 'C' :
                gameMenuView.display();
                break;
            default : 
                gameMenuView.display();
                
        }
        return false;
        }
    }