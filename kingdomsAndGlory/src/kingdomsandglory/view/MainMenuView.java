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
                + " H - Get Help on How to Play the Game \n"
                + " Q - Quit \n";
        
        System.out.println(mainMenuDisplay);
        
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
                System.out.println("Invalid Input");
        }
        return false;
            
        }


    private void startNewGame() {
        int returnValue = kingdomsandglory.control.GameControl.createNewGame(kingdomsandglory.kingdomsandglory.getPlayer());
        if (returnValue < 0) {
            System.out.println("ERROR - Failed to create new game");
        }
        ActorTraitView actorTraitView = new ActorTraitView();
        actorTraitView.display();
        
    }

    private void loadGame() {
        System.out.println("*** MainMenuView - loadGame() Called ***");
    }

    private void backgroundStory() {
        System.out.println("*** MainMenuView - backgroundStory() Called ***");
    }

    private void helpMenu() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

       
    }
    
    

