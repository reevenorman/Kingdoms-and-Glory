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
import kingdomsandglory.model.Map;
import kingdomsandglory.model.Resource;
import kingdomsandglory.model.Trait;
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

    public static int createNewGame(Player player) {
        
        if (player == null) {
            return -1;
        }
        Game game = new Game();
        setPlayer(player);
        kingdomsandglory.setCurrentGame(game);
        
 //     Trait[] traits = new Trait[3];
 //     Trait trait = new Trait(strategic, 0, 0, 0, 0, 0);
 //     traits[0] = trait;
 
        Trait[] traits = new Trait[1];
        Point startingPoint = new Point();
        Actor actor = new Actor(traits, startingPoint);
        
        Resource[] resources = new Resource[5];
        resources = createItems();
        Map map = new Map(5,5);
        long rowCount = 5;
        long columnCount = 5;
        map = createMap(rowCount, columnCount);
       
        
        if (map == null) {
            return -1;
        }
        
        return 1;
    }
    
    public static void restartGame() {
        StartExistingGameView savedGame = new StartExistingGameView();
        savedGame.displayStartExistingGameView();
    }
    private static void createActors() {
        System.out.println("***GameControl() -- createActor() called***");
    }

    public static Resource[] createItems() {
        System.out.println("***GameControl() -- createItems() called***");
        Resource[] resourceType = new Resource[5];
        return resourceType;
    }
    
    public static Map createMap(long rowCount, long columnCount) {
        System.out.println("***GameControl() -- createMap() called***");
        Map map = new Map(rowCount,columnCount);
        return map;
    }

    public GameControl(String name) {
        System.out.println("*** savePlayer() called ***");
    }
}
