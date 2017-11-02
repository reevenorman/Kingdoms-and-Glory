/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory;

import kingdomsandglory.model.Game;
import kingdomsandglory.model.Player;
import kingdomsandglory.view.StartProgramView;
/**
 *
 * @author piano
 */
public class KingdomsAndGlory {

    private static Player player;
    private static Game currentGame;

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        KingdomsAndGlory.player = player;
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        KingdomsAndGlory.currentGame = currentGame;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.displayStartProgramView();
    }
    
}
