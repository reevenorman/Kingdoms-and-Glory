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
public class MainMenuView {
    public void displayMainMenuView() {
        boolean endView = false;
        do {
            String[] inputs = getInputs();
            if (inputs.length == 0 || inputs[0].toUpperCase().equals("Q")) {
                return;
            }
            endView = doAction(inputs);

        } while (!endView);
    }

    private String[] getInputs() {
        
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
        
        while (!valid){
            System.out.println("Please choose a menu Item");
            Scanner inputName;
            inputName = new Scanner(System.in);
            input[0] = inputName.nextLine();
            input[0] = input[0].trim().toUpperCase();
            
            
            
            if (input[0].length() < 2){
                System.out.print("You must enter a valid menu item!\n");
                continue;
            }
            else {
                valid = true;
            }            
        }   
        
        
        return new String[0];
    }

    private boolean doAction(String[] inputs) {
        String menuItem = inputs[0];
        menuItem = menuItem.toUpperCase();
        
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
                break;
            default : 
                System.out.println("Invalid Input");
        }
            
        }
        
        System.out.println("*** MainMenuView - doAction() Called ***");

    private void startNewGame() {
        System.out.println("*** MainMenu - startNewGame() Called ***");
    }

    private void loadGame() {
        System.out.println("*** MainMenu - loadGame() Called ***");
    }

    private void backgroundStory() {
        System.out.println("*** MainMenu - bakcgroundStory() Called ***");
    }

    private void helpMenu() {
        System.out.println("*** MainMenu - helpMenu() Called ***");
    }
        
        return false;
    }
    
    
}
