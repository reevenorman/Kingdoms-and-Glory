/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import kingdomsandglory.kingdomsandglory;

/**
 *
 * @author piano
 */
public abstract class View implements ViewInterface {
    
    private String message;
    
    protected final BufferedReader keyboard = kingdomsandglory.getInFile();
    protected final PrintWriter console = kingdomsandglory.getOutFile();
    

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
        String inputName = null;
        try {
            inputName = this.keyboard.readLine();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
        System.out.println(promptMessage);

        while (!valid) {
            try {
                selection = this.keyboard.readLine();
            } catch (IOException ex) {
                System.out.println(ex);
            }
            selection = selection.trim();

            if (selection.length() < 1) {
                System.out.print("Invalid Input");
                continue;
            }
            break;

        }
        return selection;
    }
}
