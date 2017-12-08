/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.view;

import java.io.PrintWriter;
import kingdomsandglory.kingdomsandglory;

/**
 *
 * @author reeve
 */
public class ErrorView {
    private static final PrintWriter errorFile = kingdomsandglory.getOutFile();
    private static final PrintWriter logFile = kingdomsandglory.getLogFile();
    
    public static void display(String className, String errorMessage) {
        errorFile.println(
                "--------------------------------------------"
              + " \n - ERROR - " + errorMessage +
              "\n--------------------------------------------");
        
        logFile.println(className + " - " + errorMessage);
    }
}
