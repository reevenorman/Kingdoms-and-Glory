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
import kingdomsandglory.model.CityScene;
import kingdomsandglory.model.Game;
import kingdomsandglory.model.GridScene;
import kingdomsandglory.model.Location;
import kingdomsandglory.model.Map;
import kingdomsandglory.model.Resource;
import kingdomsandglory.model.ResourceEnum;
import kingdomsandglory.model.Trait;
import kingdomsandglory.model.TraitEnum;
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

        Trait[] traits = new Trait[3];
        traits = createTraits();
        Point startingPoint = new Point();
        Actor actor = new Actor(traits, startingPoint);

        Resource[] resources = new Resource[5];
        resources = createItems();
        
        //Call Map
        Map map;
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

    public static Resource[] createItems() {
        Resource[] resourceType = new Resource[5];

        Resource cloth = new Resource();
        cloth.resourceQty = 0.0;
        cloth.resourceDiscription = "cloth";
        resourceType[ResourceEnum.cloth.ordinal()] = cloth;

        Resource wood = new Resource();
        wood.resourceQty = 0.0;
        wood.resourceDiscription = "wood";
        resourceType[ResourceEnum.wood.ordinal()] = wood;

        Resource stone = new Resource();
        stone.resourceQty = 0.0;
        stone.resourceDiscription = "stone";
        resourceType[ResourceEnum.stone.ordinal()] = stone;

        Resource metal = new Resource();
        metal.resourceQty = 0.0;
        metal.resourceDiscription = "metal";
        resourceType[ResourceEnum.metal.ordinal()] = metal;

        Resource gold = new Resource();
        gold.resourceQty = 0.0;
        gold.resourceDiscription = "gold";
        resourceType[ResourceEnum.gold.ordinal()] = gold;

        return resourceType;
    }

    public static Map createMap(long rowCount, long columnCount) {
        System.out.println("***GameControl() -- createMap() called***");
        if (rowCount < 0 || columnCount < 0) {
            return null;
        }

        Map map = new Map(rowCount, columnCount);
        map.setColumnCount(columnCount);
        map.setRowCount(rowCount);

        Location[][] location = createLocations(rowCount, columnCount);
        
        GridScene gridScene = new GridScene();
        gridScene = createGridScene();
        
        CityScene cityScene = new CityScene();
        cityScene = createCityScene();
        
 
        return map;
    }

    private static GridScene createGridScene() {
        System.out.println("*** createGridScene() called ***");
        return null;
    }

    private static CityScene createCityScene() {
        System.out.println("*** createCityScene() called ***");
        return null;
    }

    public GameControl(String name) {
        System.out.println("*** savePlayer() called ***");
    }

    public static Location[][] createLocations(long rowCount, long columnCount) {
        System.out.println("*** createLocations() called ***");
        return null;
    }
}
