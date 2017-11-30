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
public class BuySellView extends View{
    
    @Override
    public String[] getInputs() {
        String[] inputs = new String[5];
        Boolean valid = false;
        String questionAnswer = "";
        String BuySellOptionDisplay = "";
        
        BuySellOptionDisplay = "******************************************************************\n"
                + " Question 1: When negotiating with a foreign empire, are you more likley to... \n"
                + " A - Meet formally, and discuss matters of concern through proper channels? \n"
                + " B - Meet formally, and have a carefully crafted plan of what you want to accomplish? \n"
                + " C - Meet informally, entertain your guest and convince them of your desires? \n"
                + "******************************************************************\n";

        questionAnswer = this.checkInput(BuySellOptionDisplay);
        inputs[0] = questionAnswer;
        
        BuySellOptionDisplay = "******************************************************************\n"
                + "Question 2: While playiing chess do you... \n"
                + " A - Play in a way that makes the game fair and beneficial to both parties? \n"
                + " B - Plan out each move in advance for the greatest chance of winning?\n"
                + " C - Make your moves based on the current moment? \n"
                + "******************************************************************\n";

        questionAnswer = this.checkInput(actorTraitDisplay);
        inputs[1] = questionAnswer;
        

        BuySellOptionDisplay = "******************************************************************\n"
                + " Question 3: When you want something from someone else, do you... \n"
                + " A - Kindly ask them for it, promising mutual benefit? \n"
                + " B - Pre-meditate the most effective way to get what you want without losing anything? \n"
                + " C - Charm them into giving you what you want? \n"
                + "******************************************************************\n";

        questionAnswer = this.checkInput(actorTraitDisplay);
        inputs[2] = questionAnswer;

        BuySellOptionDisplay = "******************************************************************\n"
                + "Question 4: Your treasurer has been taking gold from your vault. Will you... \n"
                + " A - Bring him to justice in the juducial courts of the kingdom? \n"
                + " B - Set a trap to convict him? \n"
                + " C - Slay him in the thralls of your anger? \n"
                + "******************************************************************\n";

        questionAnswer = this.checkInput(actorTraitDisplay);
        inputs[3] = questionAnswer;

        BuySellOptionDisplay = "******************************************************************\n"
                + " Question 5: When you gain a victory, do you... \n"
                + " A - Have a modest gathering, to acknowledge the victory? \n"
                + " B - Begin plotting for your next impending victory? \n"
                + " C - Celebrate all night long? \n"
                + "******************************************************************\n";

        questionAnswer = this.checkInput(actorTraitDisplay);
        inputs[4] = questionAnswer;

        return inputs;

    }
}
