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
public class StartProgramView {

    public void displayStartProgramView() {
        boolean endView = false;
        do {
            String[] inputs = getInputs();
            inputs[0].toUpperCase();
            if (inputs.length == 0 || inputs[0].equals("E")) {
                return;
            }
            endView = doAction(inputs);

        } while (!endView);
    }

    private String[] getInputs() {
        System.out.println("**** getInputs() called ***");
        
        String[] inputs = new String[1];
        inputs[0] = "testinput";
        
        return inputs;
    }

    private boolean doAction(String[] inputs) {
        
        System.out.println("**** doActionCalled() called ***");
        System.out.println("**** \tinputs = " + inputs[0]);
        
        return true;
    }
}
