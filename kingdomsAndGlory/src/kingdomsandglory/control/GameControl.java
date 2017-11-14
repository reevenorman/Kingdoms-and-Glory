/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.control;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.dateTime;
import java.awt.Point;
import kingdomsandglory.model.Player;
import kingdomsandglory.kingdomsandglory;
import static kingdomsandglory.kingdomsandglory.setPlayer;
import kingdomsandglory.model.Actor;
import kingdomsandglory.model.Game;
import kingdomsandglory.view.StartExistingGameView;

/**
 *
 * @author reeve
 */
public class GameControl {

    public static Player savePlayer(Player player) {
        if (player == null) {
            return null;
        }
        kingdomsandglory.setPlayer(player);
      
        return player;
    }

    private static void createActors() {
        System.out.println("***GameControl() -- createActor() called***");
    }

    private static void createItems() {
        System.out.println("***GameControl() -- createItems() called***");
    }
    
    private static void createMap() {
        System.out.println("***GameControl() -- createMap() called***");
    }

    public GameControl(String name) {
        System.out.println("*** savePlayer() called ***");
    }

    public static int createNewGame(Player player) {
        if (player == null) {
            return -1;
        }
        Game game = new Game(dateTime, gameSave);
        setPlayer(player);
        setGameSave(gameSave);
        Actor[] = createActors();
        items[] = createItems();
        map = createMap();
        
        if (map == null) {
            return -1;
        }
        
        
        
        return 1;
    }
    
    public static void restartGame() {
        StartExistingGameView savedGame = new StartExistingGameView();
        savedGame.displayStartExistingGameView();
    }
}