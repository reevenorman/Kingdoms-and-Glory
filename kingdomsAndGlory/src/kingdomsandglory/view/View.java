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
public abstract class View implements ViewInterface {

    public View() {
    }

    @Override
    public void display() {
        boolean endView = false;
        String[] inputs = null;
        do {
            inputs = this.getInputs();
            if (inputs == null || inputs.length < 1 || inputs[0].toUpperCase().equals("Q")) {
                return;
            }
            endView = this.doAction(inputs);

        } while (!endView);
    }

    @Override
    public String getInput(String promptMessage) {
        boolean valid = false;
        String selection = null;
        Scanner inputName;
        inputName = new Scanner(System.in);

        while (!valid) {
            inputName = new Scanner(System.in);
            selection = inputName.nextLine();
            selection = selection.trim();

            if (selection.length() < 1) {
                System.out.print(promptMessage);
                continue;
            }
            break;

        }
        return selection;
    }
}
