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
        
        String value = this.getInput("Please Type C to Continue.");
        String[] inputs = new String[1];
        inputs[0] = value;    
    
    
    return inputs;
    }
    
    @Override
    public boolean doAction(String[] inputs) {
        char menuItem;
        menuItem = inputs[0].toUpperCase().charAt(0);
        
        switch (menuItem){
            case 'C' : GameMenuView();
                break;
            default : 
                System.out.println("Invalid Input");
        }
        return false;
            
        }
    private void GameMenuView() {
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display();
    }
}