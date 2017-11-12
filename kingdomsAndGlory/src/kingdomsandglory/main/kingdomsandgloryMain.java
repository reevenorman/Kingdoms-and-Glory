/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.main;

import kingdomsandglory.model.Game;
import kingdomsandglory.model.Player;
import kingdomsandglory.view.StartProgramView;

/**
 *
 * @author piano
 */
public class kingdomsandgloryMain {
    
    public void Main(String[] args) {
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.display();
        
    }
   

    private static Player player = null;
    private static Game currentGame = null;

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        kingdomsandgloryMain.player = player;
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        kingdomsandgloryMain.currentGame = currentGame;
    }


    
}
