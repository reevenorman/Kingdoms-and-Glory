/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.view;
import kingdomsandglory.control.ResourceControl;
import kingdomsandglory.exceptions.ResourceControlException;

/**
 *
 * @author piano
 */
public class BuySellView extends View{
    
    @Override
    public String[] getInputs() {
        String[] inputs = new String[3];
        Boolean valid = false;
        String questionAnswer = "";
        String buySellOptionDisplay = "";
        int questionNumber;
        String answer1 = "";
        
        buySellOptionDisplay = "********************************************\n"
                + "* Please Select an Option:                 *\n"
                + "* X - Sell from my inventory               *\n"
                + "* Z - Buy more inventory                   *\n"
                + "* B - I messed up, please go back          *\n"
                + "********************************************\n";
        
        questionNumber = 1;
        questionAnswer = this.checkInput(buySellOptionDisplay, questionNumber);
        inputs[0] = questionAnswer;
        if (questionAnswer == "1") {
            answer1 = "sell";
        }
        else {
            answer1 = "buy";
        }
        
        buySellOptionDisplay = "**********************************************\n"
                + "* Which resource would you like to work with? *\n"
                + "* C - Cloth                                   *\n"
                + "* W - Wood                                    *\n"
                + "* S - Stone                                   *\n"
                + "* M - Metal                                   *\n"
                + "* A - Army                                    *\n"
                + "* B - I messed up, please go back             *\n"
                + "***********************************************\n";
        
        questionNumber = 2;
        questionAnswer = this.checkInput(buySellOptionDisplay, questionNumber);
        inputs[1] = questionAnswer;
        

       buySellOptionDisplay = "**********************************************\n"
                + "* How much would you like to " + answer1 + "?            *\n"
                + "* Please Enter a Number Value.               *\n"
                + "**********************************************\n";
       
       questionNumber = 3;
       questionAnswer = this.checkInput(buySellOptionDisplay, questionNumber);
        inputs[2] = questionAnswer;

       return inputs;

    }
        private String checkInput(String actorTraitDisplay, int questionNumber) {
        boolean valid = false;
        while (!valid) {
            this.console.println(actorTraitDisplay);
            
            char question;

            String question1 = this.getInput("Please Type in a Valid Input");
            
            switch (questionNumber) {
                case 1 :
                    
                    question = question1.toUpperCase().charAt(0);

                    switch (question) {
                        case 'X':
                            return "1";

                        case 'Z':
                            return "0";

                        case 'B':
                            break;

                        default:
                            ErrorView.display(this.getClass().getName(),"Invalid Input");
                         break;
                    }
                    
                case 2:
                    question = question1.toUpperCase().charAt(0);

                    switch (question) {
                        case 'C':
                            return "0";

                        case 'W':
                            return "1";

                        case 'S':
                            return "2";
                        
                        case 'M':
                            return "3";

                        case 'A':
                            return "5";

                        case 'B':
                            break;

                        default:
                            ErrorView.display(this.getClass().getName(),"Invalid Input");
                         break;
                    }
                case 3:
                    return question1;
                    
                default:
                    ErrorView.display(this.getClass().getName(),"Invalid Input");
                break;        
            }
        }
        return null;

    }

    @Override
    public boolean doAction(String[] inputs) {
        int[] sendInputs = new int[3];
        sendInputs = this.convertInput(inputs);
        
        String transaction;
                
        try {
        transaction = ResourceControl.makeTransaction(sendInputs);
        } catch (ResourceControlException ex){
            ErrorView.display(this.getClass().getName(), ex.getMessage());
            return false;
        } 
        
        this.console.println("========================================\n"
                        + transaction
                        + "========================================\n");

        return true;
    }
    
        private int[] convertInput (String[] inputs) {
        int[] numberInputs = new int[3];
        int change = 0;
        int i = 0;
        for (int j : numberInputs) {
            try {
            change = Integer.parseInt(inputs[i]);
            }
            catch(NumberFormatException nf) {
                ErrorView.display(this.getClass().getName(), "\n You must enter a valid number");
            }
            numberInputs[i] = change;
            i++;
        }
        return numberInputs;
        
    }
}
