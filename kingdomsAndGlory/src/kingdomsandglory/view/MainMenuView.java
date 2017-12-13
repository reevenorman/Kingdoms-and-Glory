/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.view;

import java.util.Scanner;
import kingdomsandglory.exceptions.GameControlException;


/**
 *
 * @author piano
 */
public class MainMenuView extends View {

    @Override
    public String[] getInputs() {
        
        String[] input = new String[1];
        String userInput;
        Boolean valid = false;
        
        String mainMenuDisplay;
        
        mainMenuDisplay = " G - Start New Game \n"
                + " L - Load Saved Game \n"
                + " B - Background Story \n"
                + " H - Help Menu \n"
                + " Q - Quit \n";
        
        this.console.println(mainMenuDisplay);
        
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
            case 'G' : startNewGame();
                break;
            case 'L' : loadGame();
                break;
            case 'B' : backgroundStory();
                break;
            case 'H' : helpMenu();
                break;
            case 'Q' : return true;
            default : 
                ErrorView.display(this.getClass().getName(),"Invalid Input");
        }
        return false;
            
        }


    private void startNewGame() {
        try {
            kingdomsandglory.control.GameControl.createNewGame(kingdomsandglory.kingdomsandglory.getPlayer());
        } catch (GameControlException mce) {
            ErrorView.display(this.getClass().getName(), mce.getMessage());
            return;
        }
        ActorTraitView actorTraitView = new ActorTraitView();
        actorTraitView.display();
        
    }

    private void loadGame() {
        LoadGameView loadGameView = new LoadGameView();
        loadGameView.display();
    }

    private void backgroundStory() {
        BackGroundStoryView backGroundStoryView = new BackGroundStoryView();
        backGroundStoryView.display();
    }

    private void helpMenu() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

       
    }
    
    

