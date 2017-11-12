/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.control;

import kingdomsandglory.model.Player;
import kingdomsglory.kingdomsandgloryMain;

/**
 *
 * @author reeve
 */
public class GameControl {

    public static Player savePlayer(Player player) {
        if (player == null) {
            return null;
        }
        kingdomsandgloryMain.setPlayer(player);
      
        return player;
    }

    public GameControl(String name) {
        System.out.println("*** savePlayer() called ***");
    }

    public static void createNewGame(Player player) {
        System.out.println("***Game Control - createNewGame() Called***");
    }
    
    public static void restartGame() {
        kingdomsandglory.view.StartExistingGameView savedGame = new kingdomsandglory.view.StartExistingGameView();
        savedGame.displayStartExistingGameView();
    }
}