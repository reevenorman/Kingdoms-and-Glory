/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.control;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.dateTime;
import java.awt.Point;
import kingdomsandglory.control.MapControl;
import kingdomsandglory.exceptions.GameControlException;
import kingdomsandglory.model.Player;
import kingdomsandglory.kingdomsandglory;
import static kingdomsandglory.kingdomsandglory.setPlayer;
import kingdomsandglory.model.Actor;
import kingdomsandglory.model.CityScene;
import kingdomsandglory.model.CoordinateMapEnum;
import kingdomsandglory.model.Game;
import kingdomsandglory.model.Location;
import kingdomsandglory.model.Map;
import kingdomsandglory.model.Resource;
import kingdomsandglory.model.ResourceEnum;
import kingdomsandglory.model.ResourceScene;
import kingdomsandglory.model.Scene;
import kingdomsandglory.model.Trait;
import kingdomsandglory.model.TraitEnum;
import kingdomsandglory.view.StartExistingGameView;

/**
 *
 * @author reeve
 */
public class GameControl {

    public static Player savePlayer(Player player) throws GameControlException {
        if (player == null) {
            throw new GameControlException("Player Cannot Be Null");
        }
        kingdomsandglory.setPlayer(player);

        return player;
    }

    public static void createNewGame(Player player) throws GameControlException {

        if (player == null) {
            throw new GameControlException("Player Cannot Be Null");
        }
        Game game = new Game();
        setPlayer(player);
        kingdomsandglory.setCurrentGame(game);

        Trait[] traits = new Trait[3];
        traits = createTraits();
        Point startingPoint = new Point();
        Actor actor = new Actor(traits, startingPoint);

        Resource[] resources = new Resource[5];
        resources = ResourceControl.createItems();
        
        game.resourceType = resources;
        
        //Call Map
        Map map = new Map(5, 5, null);
        int rowCount = 5;
        int columnCount = 5;
        map = MapControl.createMap(rowCount, columnCount);

        if (map == null) {
            throw new GameControlException("Map Cannot Be Null");
        }
        
        game.map = map;
        
        return;
    }

    public static void restartGame() {
        StartExistingGameView savedGame = new StartExistingGameView();
        savedGame.displayStartExistingGameView();
    }

    private static void createActors() {
        System.out.println("***GameControl() -- createActor() called***");
    }

    public static Trait[] createTraits() {
       
        Trait[] traitType = new Trait[3];

        Trait diplomatic = new Trait();
        diplomatic.traitName = "Diplomatic";
        diplomatic.army = 0;
        diplomatic.cloth = 0;
        diplomatic.wood = 0;
        diplomatic.stone = 0;
        diplomatic.metal = 0;
        diplomatic.gold = 0;
        traitType[TraitEnum.diplomatic.ordinal()] = diplomatic;

        
        Trait strategic = new Trait();
        strategic.traitName = "Strategic";
        strategic.army = 0;
        strategic.cloth = 0;
        strategic.wood = 0;
        strategic.stone = 0;
        strategic.metal = 0;
        strategic.gold = 0;
        traitType[TraitEnum.strategic.ordinal()] = strategic;

        Trait charismatic = new Trait();
        charismatic.traitName = "Charismatic";
        charismatic.army = 0;
        charismatic.cloth = 0;
        charismatic.wood = 0;
        charismatic.stone = 0;
        charismatic.metal = 0;
        charismatic.gold = 0;
        traitType[TraitEnum.charismatic.ordinal()] = charismatic;

        return traitType;
    }

    public GameControl(String name) {
        System.out.println("*** savePlayer() called ***");
    }

}
