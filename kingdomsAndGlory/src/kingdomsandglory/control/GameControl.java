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
        game.setPlayer(kingdomsandglory.getPlayer());
        kingdomsandglory.setCurrentGame(game);
        
        Trait[] traits = new Trait[3];
        traits = createTraits();
        
        
        Actor actor = new Actor();
        game.player.actor = actor;
       
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
        
        game.player.actor.location = game.map.locations[4][2];

        
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
        diplomatic.army = 200;
        diplomatic.cloth = 200;
        diplomatic.wood = 200;
        diplomatic.stone = 200;
        diplomatic.metal = 200;
        diplomatic.gold = 250;
        traitType[TraitEnum.diplomatic.ordinal()] = diplomatic;

        
        Trait strategic = new Trait();
        strategic.traitName = "Strategic";
        strategic.army = 300;
        strategic.cloth = 100;
        strategic.wood = 100;
        strategic.stone = 100;
        strategic.metal = 200;
        strategic.gold = 250;
        traitType[TraitEnum.strategic.ordinal()] = strategic;

        Trait charismatic = new Trait();
        charismatic.traitName = "Charismatic";
        charismatic.army = 500;
        charismatic.cloth = 100;
        charismatic.wood = 100;
        charismatic.stone = 100;
        charismatic.metal = 100;
        charismatic.gold = 300;
        traitType[TraitEnum.charismatic.ordinal()] = charismatic;

        return traitType;
    }

    public GameControl(String name) {
        System.out.println("*** savePlayer() called ***");
    }

}