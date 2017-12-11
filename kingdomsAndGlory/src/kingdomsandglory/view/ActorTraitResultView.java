/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.view;

import kingdomsandglory.control.PlayerControl;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static kingdomsandglory.control.PlayerControl.addSumToGold;
import static kingdomsandglory.control.PlayerControl.assignActorTrait;
import kingdomsandglory.model.Game;
import static kingdomsandglory.control.PlayerControl.sumOfActorTrait;
import kingdomsandglory.exceptions.PlayerControlException;
import kingdomsandglory.view.StartProgramView;

/**
 *
 * @author piano
 */
public class ActorTraitResultView extends View {

    @Override
    public String[] getInputs() {
        String[] inputs = new String[5];
        Boolean valid = false;
        String questionAnswer = "";
        String actorTraitDisplay;

        actorTraitDisplay = "******************************************************************\n"
                + " Question 1: When negotiating with a foreign empire, are you more likley to... \n"
                + " A - Meet formally, and discuss matters of concern through proper channels? \n"
                + " B - Meet formally, and have a carefully crafted plan of what you want to accomplish? \n"
                + " C - Meet informally, entertain your guest and convince them of your desires? \n"
                + "******************************************************************\n";

        questionAnswer = this.checkInput(actorTraitDisplay);
        inputs[0] = questionAnswer;

        actorTraitDisplay = "******************************************************************\n"
                + "Question 2: While playing chess do you... \n"
                + " A - Play in a way that makes the game fair and beneficial to both parties? \n"
                + " B - Plan out each move in advance for the greatest chance of winning?\n"
                + " C - Make your moves based on the current moment? \n"
                + "******************************************************************\n";

        questionAnswer = this.checkInput(actorTraitDisplay);
        inputs[1] = questionAnswer;

        actorTraitDisplay = "******************************************************************\n"
                + " Question 3: When you want something from someone else, do you... \n"
                + " A - Kindly ask them for it, promising mutual benefit? \n"
                + " B - Pre-meditate the most effective way to get what you want without losing anything? \n"
                + " C - Charm them into giving you what you want? \n"
                + "******************************************************************\n";

        questionAnswer = this.checkInput(actorTraitDisplay);
        inputs[2] = questionAnswer;

        actorTraitDisplay = "******************************************************************\n"
                + "Question 4: Your treasurer has been taking gold from your vault. Will you... \n"
                + " A - Bring him to justice in the juducial courts of the kingdom? \n"
                + " B - Set a trap to convict him? \n"
                + " C - Slay him in the thralls of your anger? \n"
                + "******************************************************************\n";

        questionAnswer = this.checkInput(actorTraitDisplay);
        inputs[3] = questionAnswer;

        actorTraitDisplay = "******************************************************************\n"
                + " Question 5: When you gain a victory, do you... \n"
                + " A - Have a modest gathering, to acknowledge the victory? \n"
                + " B - Begin plotting for your next impending victory? \n"
                + " C - Celebrate all night long? \n"
                + "******************************************************************\n";

        questionAnswer = this.checkInput(actorTraitDisplay);
        inputs[4] = questionAnswer;

        return inputs;

    }
    
    private String checkInput(String actorTraitDisplay) {
        boolean valid = false;
        while (!valid) {
            this.console.println(actorTraitDisplay);

            String question1 = this.getInput("Please Selection an Option");

            char question = question1.toUpperCase().charAt(0);

            switch (question) {
                case 'A':
                    return "1";

                case 'B':
                    return "2";

                case 'C':
                    return "3";

                default:
                    ErrorView.display(this.getClass().getName(), "Invalid Input");
                    break;
            }
        }
        return null;

    }

    @Override
    public boolean doAction(String[] inputs) {
        int[] sendInputs = new int[5];
        sendInputs = this.convertInput(inputs);

        
        int traitresult;
        try {
        traitresult = assignActorTrait(sendInputs[0], sendInputs[1], sendInputs[2], sendInputs[3], sendInputs[4]);
        } catch (PlayerControlException ex){
            ErrorView.display(this.getClass().getName(), "Trait result is null");
                    return false;
        }
        
        
        int sumOfTraitQuestions = 0;
        try {
            sumOfTraitQuestions = sumOfActorTrait(sendInputs);
        } catch (PlayerControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
            return false;
        }

        String actorTraitName = "unknown";

        switch (traitresult) {
            case 1:
                actorTraitName = "Diplomatic";

                break;
            case 2:
                actorTraitName = "Strategic";
                break;
            case 3:
                actorTraitName = "Charismatic";
                break;
            default:
                actorTraitName = "Invalid Input";
        }

        try {
            int gold = PlayerControl.addSumToGold(actorTraitName, sumOfTraitQuestions);
        } catch (PlayerControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
            return false;
        }
        
        PlayerControl.setPlayerTrait(actorTraitName);

        String playerName = "Unknown";

        Game game = kingdomsandglory.kingdomsandglory.getCurrentGame();

        playerName = game.player.getPlayerName();

        this.console.println("========================================\n"
                + "Congratulations, " + playerName + "!\n"
                + "You have received the trait of " + actorTraitName + "!\n"
                + "You will be known as " + playerName + " the " + actorTraitName + "!\n"
                + "Each attribute you receive gives you a unique starting advantage in your resources. \n"
                + "The sum total of your questionaire was " + sumOfTraitQuestions + "! This will be added to your Gold as a bonus. \n"
                + "View your resources to see what advantages you have received! \n"
                + "========================================\n");

        return true;
    }

    private int[] convertInput(String[] inputs) {
        int[] numberInputs = new int[5];
        char change;
        int i = 0;
        for (int j : numberInputs) {

            change = inputs[i].toUpperCase().charAt(0);
            switch (change) {
                case '1':
                    numberInputs[i] = 1;
                    break;
                case '2':
                    numberInputs[i] = 2;
                    break;
                case '3':
                    numberInputs[i] = 3;
                    break;
            }
            i++;
        }
        return numberInputs;

    }

}
