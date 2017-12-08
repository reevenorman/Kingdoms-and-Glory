/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import kingdomsandglory.model.Game;
import kingdomsandglory.model.Player;
import kingdomsandglory.view.StartProgramView;

/**
 *
 * @author piano
 */
public class kingdomsandglory {

    public static void main(String[] args) {
        /*        try {
        
        } catch (Throwable te) {
        System.out.println(te.getMessage());
        te.printStackTrace();
        return;
        }*/
        
        try { 
            kingdomsandglory.inFile = 
                    new BufferedReader(new InputStreamReader(System.in));
            
            kingdomsandglory.outFile = new PrintWriter(System.out, true);
            
            String filePath = "log.text";
            kingdomsandglory.logFile = new PrintWriter(filePath);
            
            
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.display();
            
        } catch (Throwable e) {
            
            System.out.println("Exception: " + e.toString() +
                                "\nCause: " + e.getCause() +
                                "\nMessage: " + e.getMessage());
            
            e.printStackTrace();;
        } finally {
            try {
                if (kingdomsandglory.inFile != null)
                kingdomsandglory.inFile.close();
                if (kingdomsandglory.outFile != null)
                kingdomsandglory.outFile.close();
                if (kingdomsandglory.logFile != null)
                    kingdomsandglory.logFile.close();
                
            } catch (IOException ex) {
                System.out.println("Error Closing Files...");
                return;
            }
            
        }
        
    }
    private static Player player = null;
    private static Game currentGame = null;
    
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    
    private static PrintWriter logFile = null;
    

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        kingdomsandglory.logFile = logFile;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        kingdomsandglory.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        kingdomsandglory.inFile = inFile;
    }
    
    

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        kingdomsandglory.player = player;
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        kingdomsandglory.currentGame = currentGame;
    }

}
