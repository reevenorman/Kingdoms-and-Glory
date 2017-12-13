/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.view;

import kingdomsandglory.model.Game;

/**
 *
 * @author piano
 */
public class WinView extends View {
    @Override
    public String[] getInputs() {
        String[] input = new String[1];
        String userInput;
        Boolean valid = false;
        
        Game game = kingdomsandglory.kingdomsandglory.getCurrentGame();
        
        String actorName = game.player.actor.getActorName();

        String backgroundStoryDisplay = ("************************************************************************************\n"
                + "*               Congratulations " + actorName + "!                    *\n"
                + "* You were able to win back all of your cities from the Ruffians!                 *\n"
                + "* You restored peace and prosperity to the Kingdom of Zenobia.                    *\n"
                + "* Thank you for playing our game. Live long and prosper :)                        *\n"
            
                + "************************************************************************************");
        
        this.console.println(backgroundStoryDisplay);
        String value = this.getInput("Please Select on Option \n"
                + "R - Return to Game Menu \n"
                + "X - Quit");
        String[] inputs = new String[1];
        inputs[0] = value;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        char menuItem;
        menuItem = inputs[0].toUpperCase().charAt(0);

        switch (menuItem) {
            case 'R':
                GameMenuView gameMenuView = new GameMenuView();
                gameMenuView.display();
                break;
            case 'X':
                System.exit(0);
            default:
                ErrorView.display(this.getClass().getName(),"Invalid Input");
        }
        return true;
    }
}
