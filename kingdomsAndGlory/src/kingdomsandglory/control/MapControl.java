/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.control;

import kingdomsandglory.model.Resource;

import java.util.Random;
import kingdomsandglory.exceptions.GameControlException;
import kingdomsandglory.exceptions.MapControlException;
import kingdomsandglory.kingdomsandglory;
import static kingdomsandglory.kingdomsandglory.getPlayer;
import static kingdomsandglory.kingdomsandglory.setPlayer;
import kingdomsandglory.model.Actor;
import kingdomsandglory.model.CityScene;
import kingdomsandglory.model.CoordinateMapEnum;
import kingdomsandglory.model.Location;
import kingdomsandglory.model.Map;
import kingdomsandglory.model.ResourceEnum;
import kingdomsandglory.model.ResourceScene;
import kingdomsandglory.model.Scene;
import kingdomsandglory.model.Game;
import kingdomsandglory.model.Player;
import kingdomsandglory.view.ErrorView;

/**
 *
 * @author piano
 */
public class MapControl {

    

    public static String fortuneOutcome(int userGambleOption, int randResourceAmt, int ResourceObj, int randChanceAmt) throws MapControlException {
        Game game = new Game();
        game = kingdomsandglory.getCurrentGame();

        double outcome;
        String resultOutcome = "error";

        if (userGambleOption < 0) {
            return "-1";
        }
        if (userGambleOption > 1) {
            return "-2";
        }
        if (randResourceAmt > 100) {
            return "-3";
        }
        if (randResourceAmt < 0) {
            return "-4";
        }
        if (ResourceObj >= 5) {
            return "-5";
        }
        if (ResourceObj < -1) {
            return "-6";
        }
        if (randChanceAmt >= 7) {
            return "-7";
        }
        if (randChanceAmt <= 0) {
            return "-8";
        }
        int resourceQty;
        if (userGambleOption == 0) {
            outcome = randResourceAmt * 0.2;
            resourceQty = game.resourceType[ResourceObj].getResourceQty();
            resourceQty = resourceQty + (int) outcome;
            game.resourceType[ResourceObj].setResourceQty(resourceQty);
            String mineral = game.resourceType[ResourceObj].getResourceDiscription();
            resultOutcome = ("You gained " + outcome + " pieces of " + mineral + ".");
            return resultOutcome;
        }
        if (userGambleOption == 1) {
            double guarenteedOutcome = randResourceAmt * 0.2;
            if (randChanceAmt >= 3) {
                outcome = randResourceAmt * 0.8;
                resourceQty = game.resourceType[ResourceObj].getResourceQty();
                resourceQty = resourceQty + (int) outcome + (int) guarenteedOutcome;
                game.resourceType[ResourceObj].setResourceQty(resourceQty);
                String mineral = game.resourceType[ResourceObj].getResourceDiscription();
                resultOutcome = ("You gained " + randResourceAmt + " pieces of " + mineral + ".");
            } else {
                outcome = randResourceAmt * 0.8;
                resourceQty = game.resourceType[ResourceObj].getResourceQty();
                resourceQty = resourceQty - (int) outcome + (int) guarenteedOutcome;
                game.resourceType[ResourceObj].setResourceQty(resourceQty);
                String mineral = game.resourceType[ResourceObj].getResourceDiscription();
                resultOutcome = ("You gained " + randResourceAmt + " pieces of " + mineral + "."
                        + "But, You were attacked by bandits! And lost, " + outcome + " pieces of " + mineral + ".");
            }
        }
        resultOutcome = resultOutcome + "\n================================================================";
        
        return resultOutcome;

    }

    public static Map createMap(int rowCount, int columnCount) {
        if (rowCount < 0 || columnCount < 0) {
           return null;
        }

        Map map = new Map(rowCount, columnCount, null);
        map.setColumnCount(columnCount);
        map.setRowCount(rowCount);

        Location[][] location = MapControl.createLocations(rowCount, columnCount);
        map.setLocations(location);

        Scene[] scene = new Scene[25];
        scene = MapControl.createCityScene(scene);

        assignScenesToLocations(map, scene);

        return map;
    }

    private static void assignScenesToLocations(Map map, Scene[] scene) {
        Location[][] locations = map.getLocations();

        locations[0][0].setLocationScene(scene[CoordinateMapEnum.ForestA.ordinal()]);
        locations[0][1].setLocationScene(scene[CoordinateMapEnum.Visum.ordinal()]);
        locations[0][2].setLocationScene(scene[CoordinateMapEnum.MountainA.ordinal()]);
        locations[0][3].setLocationScene(scene[CoordinateMapEnum.Genus.ordinal()]);
        locations[0][4].setLocationScene(scene[CoordinateMapEnum.MillA.ordinal()]);
        locations[1][0].setLocationScene(scene[CoordinateMapEnum.MillB.ordinal()]);
        locations[1][1].setLocationScene(scene[CoordinateMapEnum.MineA.ordinal()]);
        locations[1][2].setLocationScene(scene[CoordinateMapEnum.ForestB.ordinal()]);
        locations[1][3].setLocationScene(scene[CoordinateMapEnum.MountainB.ordinal()]);
        locations[1][4].setLocationScene(scene[CoordinateMapEnum.MineB.ordinal()]);
        locations[2][0].setLocationScene(scene[CoordinateMapEnum.Pacem.ordinal()]);
        locations[2][1].setLocationScene(scene[CoordinateMapEnum.MountainC.ordinal()]);
        locations[2][2].setLocationScene(scene[CoordinateMapEnum.Felicitatem.ordinal()]);
        locations[2][3].setLocationScene(scene[CoordinateMapEnum.MillC.ordinal()]);
        locations[2][4].setLocationScene(scene[CoordinateMapEnum.Pulchram.ordinal()]);
        locations[3][0].setLocationScene(scene[CoordinateMapEnum.MineC.ordinal()]);
        locations[3][1].setLocationScene(scene[CoordinateMapEnum.MillD.ordinal()]);
        locations[3][2].setLocationScene(scene[CoordinateMapEnum.ForestC.ordinal()]);
        locations[3][3].setLocationScene(scene[CoordinateMapEnum.ForestD.ordinal()]);
        locations[3][4].setLocationScene(scene[CoordinateMapEnum.ForestE.ordinal()]);
        locations[4][0].setLocationScene(scene[CoordinateMapEnum.MountainD.ordinal()]);
        locations[4][1].setLocationScene(scene[CoordinateMapEnum.ForestF.ordinal()]);
        locations[4][2].setLocationScene(scene[CoordinateMapEnum.Zenobia.ordinal()]);
        locations[4][3].setLocationScene(scene[CoordinateMapEnum.MineD.ordinal()]);
        locations[4][4].setLocationScene(scene[CoordinateMapEnum.MillE.ordinal()]);
    }

    public static Location[][] createLocations(int rowCount, int columnCount) {
        if (rowCount < 1 || columnCount < 1) {
            return null;

        }
        int i = 0;
        int j = 0;
        Location[][] allLocations = new Location[rowCount][columnCount];
        for (Location[] row : allLocations) {
            j = 0;
            for (Location aLocation : row) {
                aLocation = new Location(i, j, false, null);
                allLocations[i][j] = aLocation;
                j++;
            }
            i++;
        }
        
        return allLocations;
    }

    public static Scene[] createCityScene(Scene[] scene) {
        Scene[] sceneArray = new Scene[25];
        Game game = kingdomsandglory.getCurrentGame();

        CityScene visum = new CityScene();
        visum.rowCount = CoordinateMapEnum.Visum.getcRow();
        visum.columnCount = CoordinateMapEnum.Visum.getcColumn();
        visum.name = "Visum";
        visum.mapSignal = "Visu";
        visum.ownership = 1;
        visum.riskFactor = 800;
        visum.riskArmyFactor = 10;
        visum.actor = null;
        visum.mineralTypetoAttack = "metal";
        visum.mineralTypeThere = "metal";
        sceneArray[CoordinateMapEnum.Visum.ordinal()] = visum;

        CityScene genus = new CityScene();
        genus.rowCount = CoordinateMapEnum.Genus.getcRow();
        genus.columnCount = CoordinateMapEnum.Genus.getcColumn();
        genus.name = "Genus";
        genus.mapSignal = "Genu";
        genus.ownership = 1;
        genus.riskFactor = 300;
        genus.riskArmyFactor = 10;
        genus.actor = null;
        genus.mineralTypetoAttack = "Cloth";
        genus.mineralTypeThere = "Cloth";
        sceneArray[CoordinateMapEnum.Genus.ordinal()] = genus;

        CityScene pacem = new CityScene();
        pacem.rowCount = CoordinateMapEnum.Pacem.getcRow();
        pacem.columnCount = CoordinateMapEnum.Pacem.getcColumn();
        pacem.name = "Pacem";
        pacem.mapSignal = "Pace";
        pacem.ownership = 1;
        pacem.riskFactor = 500;
        pacem.riskArmyFactor = 10;
        pacem.actor = null;
        pacem.mineralTypetoAttack = "Stone";
        pacem.mineralTypeThere = "Stone";
        sceneArray[CoordinateMapEnum.Pacem.ordinal()] = pacem;

        CityScene felicitatem = new CityScene();
        felicitatem.rowCount = CoordinateMapEnum.Felicitatem.getcRow();
        felicitatem.columnCount = CoordinateMapEnum.Felicitatem.getcColumn();
        felicitatem.name = "Felicitatem";
        felicitatem.mapSignal = "Feli";
        felicitatem.ownership = 1;
        felicitatem.riskFactor = 400;
        felicitatem.riskArmyFactor = 10;
        felicitatem.actor = null;
        felicitatem.mineralTypetoAttack = "Wood";
        felicitatem.mineralTypeThere = "Wood";
        sceneArray[CoordinateMapEnum.Felicitatem.ordinal()] = felicitatem;

        CityScene pulchram = new CityScene();
        pulchram.rowCount = CoordinateMapEnum.Pulchram.getcRow();
        pulchram.columnCount = CoordinateMapEnum.Pulchram.getcColumn();
        pulchram.name = "Pulchram";
        pulchram.mapSignal = "Pulc";
        pulchram.ownership = 1;
        pulchram.riskFactor = 450;
        pulchram.riskArmyFactor = 10;
        pulchram.actor = null;
        pulchram.mineralTypetoAttack = "Wood";
        pulchram.mineralTypeThere = "Wood";
        sceneArray[CoordinateMapEnum.Pulchram.ordinal()] = pulchram;

        CityScene zenobia = new CityScene();
        zenobia.rowCount = CoordinateMapEnum.Zenobia.getcRow();
        zenobia.columnCount = CoordinateMapEnum.Zenobia.getcColumn();
        zenobia.mapSignal = "Zeno";
        zenobia.ownership = 0;
        zenobia.riskFactor = 0;
        zenobia.actor = game.player.actor;
        zenobia.mineralTypeThere = "Gold";
        sceneArray[CoordinateMapEnum.Zenobia.ordinal()] = zenobia;

        ResourceScene forestA = new ResourceScene();
        forestA.rowCount = CoordinateMapEnum.ForestA.getcRow();
        forestA.columnCount = CoordinateMapEnum.ForestA.getcColumn();
        forestA.name = "Forest";
        forestA.mapSignal = "Frst";
        forestA.actor = null;
        forestA.mineralTypeThere = "Wood";
        sceneArray[CoordinateMapEnum.ForestA.ordinal()] = forestA;

        ResourceScene forestB = new ResourceScene();
        forestB.rowCount = CoordinateMapEnum.ForestB.getcRow();
        forestB.columnCount = CoordinateMapEnum.ForestB.getcColumn();
        forestB.name = "Forest";
        forestB.mapSignal = "Frst";
        forestB.actor = null;
        forestB.mineralTypeThere = "Wood";
        sceneArray[CoordinateMapEnum.ForestB.ordinal()] = forestB;

        ResourceScene forestC = new ResourceScene();
        forestC.rowCount = CoordinateMapEnum.ForestC.getcRow();
        forestC.columnCount = CoordinateMapEnum.ForestC.getcColumn();
        forestC.name = "Forest";
        forestC.mapSignal = "Frst";
        forestC.actor = null;
        forestC.mineralTypeThere = "Wood";
        sceneArray[CoordinateMapEnum.ForestC.ordinal()] = forestC;

        ResourceScene forestD = new ResourceScene();
        forestD.rowCount = CoordinateMapEnum.ForestD.getcRow();
        forestD.columnCount = CoordinateMapEnum.ForestD.getcColumn();
        forestD.name = "Forest";
        forestD.mapSignal = "Frst";
        forestD.actor = null;
        forestD.mineralTypeThere = "Wood";
        sceneArray[CoordinateMapEnum.ForestD.ordinal()] = forestD;

        ResourceScene forestE = new ResourceScene();
        forestE.rowCount = CoordinateMapEnum.ForestE.getcRow();
        forestE.columnCount = CoordinateMapEnum.ForestE.getcColumn();
        forestE.name = "Forest";
        forestE.mapSignal = "Frst";
        forestE.actor = null;
        forestE.mineralTypeThere = "Wood";
        sceneArray[CoordinateMapEnum.ForestE.ordinal()] = forestE;

        ResourceScene forestF = new ResourceScene();
        forestF.rowCount = CoordinateMapEnum.ForestF.getcRow();
        forestF.columnCount = CoordinateMapEnum.ForestF.getcColumn();
        forestF.name = "Forest";
        forestF.mapSignal = "Frst";
        forestF.actor = null;
        forestF.mineralTypeThere = "Wood";
        sceneArray[CoordinateMapEnum.ForestF.ordinal()] = forestF;

        ResourceScene millA = new ResourceScene();
        millA.rowCount = CoordinateMapEnum.MillA.getcRow();
        millA.columnCount = CoordinateMapEnum.MillA.getcColumn();
        millA.name = "Mill";
        millA.mapSignal = "Mill";
        millA.actor = null;
        millA.mineralTypeThere = "Cloth";
        sceneArray[CoordinateMapEnum.MillA.ordinal()] = millA;

        ResourceScene millB = new ResourceScene();
        millB.rowCount = CoordinateMapEnum.MillB.getcRow();
        millB.columnCount = CoordinateMapEnum.MillB.getcColumn();
        millB.name = "Mill";
        millB.mapSignal = "Mill";
        millB.actor = null;
        millB.mineralTypeThere = "Cloth";
        sceneArray[CoordinateMapEnum.MillB.ordinal()] = millB;

        ResourceScene millC = new ResourceScene();
        millC.rowCount = CoordinateMapEnum.MillC.getcRow();
        millC.columnCount = CoordinateMapEnum.MillC.getcColumn();
        millC.name = "Mill";
        millC.mapSignal = "Mill";
        millC.actor = null;
        millC.mineralTypeThere = "Cloth";
        sceneArray[CoordinateMapEnum.MillC.ordinal()] = millC;

        ResourceScene millD = new ResourceScene();
        millD.rowCount = CoordinateMapEnum.MillD.getcRow();
        millD.columnCount = CoordinateMapEnum.MillD.getcColumn();
        millD.name = "Mill";
        millD.mapSignal = "Mill";
        millD.actor = null;
        millD.mineralTypeThere = "Cloth";
        sceneArray[CoordinateMapEnum.MillD.ordinal()] = millD;

        ResourceScene millE = new ResourceScene();
        millE.rowCount = CoordinateMapEnum.MillE.getcRow();
        millE.columnCount = CoordinateMapEnum.MillE.getcColumn();
        millE.name = "Mill";
        millE.mapSignal = "Mill";
        millE.actor = null;
        millE.mineralTypeThere = "Cloth";
        sceneArray[CoordinateMapEnum.MillE.ordinal()] = millE;

        ResourceScene mountainA = new ResourceScene();
        mountainA.rowCount = CoordinateMapEnum.MountainA.getcRow();
        mountainA.columnCount = CoordinateMapEnum.MountainA.getcColumn();
        mountainA.name = "Mountain";
        mountainA.mapSignal = "Mtn ";
        mountainA.actor = null;
        mountainA.mineralTypeThere = "Stone";
        sceneArray[CoordinateMapEnum.MountainA.ordinal()] = mountainA;

        ResourceScene mountainB = new ResourceScene();
        mountainB.rowCount = CoordinateMapEnum.MountainB.getcRow();
        mountainB.columnCount = CoordinateMapEnum.MountainB.getcColumn();
        mountainB.name = "Mountain";
        mountainB.mapSignal = "Mtn ";
        mountainB.actor = null;
        mountainB.mineralTypeThere = "Stone";
        sceneArray[CoordinateMapEnum.MountainB.ordinal()] = mountainB;

        ResourceScene mountainC = new ResourceScene();
        mountainC.rowCount = CoordinateMapEnum.MountainC.getcRow();
        mountainC.columnCount = CoordinateMapEnum.MountainC.getcColumn();
        mountainC.name = "Mountain";
        mountainC.mapSignal = "Mtn ";
        mountainC.actor = null;
        mountainC.mineralTypeThere = "Stone";
        sceneArray[CoordinateMapEnum.MountainC.ordinal()] = mountainC;

        ResourceScene mountainD = new ResourceScene();
        mountainD.rowCount = CoordinateMapEnum.MountainD.getcRow();
        mountainD.columnCount = CoordinateMapEnum.MountainD.getcColumn();
        mountainD.name = "Mountain";
        mountainD.mapSignal = "Mtn ";
        mountainD.actor = null;
        mountainD.mineralTypeThere = "Stone";
        sceneArray[CoordinateMapEnum.MountainD.ordinal()] = mountainD;

        ResourceScene mineA = new ResourceScene();
        mineA.rowCount = CoordinateMapEnum.MineA.getcRow();
        mineA.columnCount = CoordinateMapEnum.MineA.getcColumn();
        mineA.name = "Mine";
        mineA.mapSignal = "Mine";
        mineA.actor = null;
        mineA.mineralTypeThere = "Metal";
        sceneArray[CoordinateMapEnum.MineA.ordinal()] = mineA;

        ResourceScene mineB = new ResourceScene();
        mineB.rowCount = CoordinateMapEnum.MineB.getcRow();
        mineB.columnCount = CoordinateMapEnum.MineB.getcColumn();
        mineB.name = "Mine";
        mineB.mapSignal = "Mine";
        mineB.actor = null;
        mineB.mineralTypeThere = "Metal";
        sceneArray[CoordinateMapEnum.MineB.ordinal()] = mineB;

        ResourceScene mineC = new ResourceScene();
        mineC.rowCount = CoordinateMapEnum.MineC.getcRow();
        mineC.columnCount = CoordinateMapEnum.MineC.getcColumn();
        mineC.name = "Mine";
        mineC.mapSignal = "Mine";
        mineC.actor = null;
        mineC.mineralTypeThere = "Metal";
        sceneArray[CoordinateMapEnum.MineC.ordinal()] = mineC;

        ResourceScene mineD = new ResourceScene();
        mineD.rowCount = CoordinateMapEnum.MineD.getcRow();
        mineD.columnCount = CoordinateMapEnum.MineD.getcColumn();
        mineD.name = "Mine";
        mineD.mapSignal = "Mine";
        mineD.actor = null;
        mineD.mineralTypeThere = "Metal";
        sceneArray[CoordinateMapEnum.MineD.ordinal()] = mineD;

        scene = sceneArray;

        return scene;
    }

    public static Scene[] createResourceScene(Scene[] scene) {
        Scene[] sceneArray = new Scene[25];

        ResourceScene forestA = new ResourceScene();
        forestA.rowCount = CoordinateMapEnum.ForestA.getcRow();
        forestA.columnCount = CoordinateMapEnum.ForestA.getcColumn();
        forestA.mapSignal = "???";
        sceneArray[CoordinateMapEnum.ForestA.ordinal()] = forestA;

        ResourceScene forestB = new ResourceScene();
        forestA.rowCount = CoordinateMapEnum.ForestB.getcRow();
        forestA.columnCount = CoordinateMapEnum.ForestB.getcColumn();
        forestA.mapSignal = "???";
        sceneArray[CoordinateMapEnum.ForestB.ordinal()] = forestB;

        ResourceScene forestC = new ResourceScene();
        forestC.rowCount = CoordinateMapEnum.ForestC.getcRow();
        forestC.columnCount = CoordinateMapEnum.ForestC.getcColumn();
        forestC.mapSignal = "???";
        sceneArray[CoordinateMapEnum.ForestC.ordinal()] = forestC;

        ResourceScene forestD = new ResourceScene();
        forestD.rowCount = CoordinateMapEnum.ForestD.getcRow();
        forestD.columnCount = CoordinateMapEnum.ForestD.getcColumn();
        forestD.mapSignal = "???";
        sceneArray[CoordinateMapEnum.ForestD.ordinal()] = forestD;

        ResourceScene forestE = new ResourceScene();
        forestE.rowCount = CoordinateMapEnum.ForestE.getcRow();
        forestE.columnCount = CoordinateMapEnum.ForestE.getcColumn();
        forestE.mapSignal = "???";
        sceneArray[CoordinateMapEnum.ForestE.ordinal()] = forestE;

        ResourceScene forestF = new ResourceScene();
        forestF.rowCount = CoordinateMapEnum.ForestF.getcRow();
        forestF.columnCount = CoordinateMapEnum.ForestF.getcColumn();
        forestF.mapSignal = "???";
        sceneArray[CoordinateMapEnum.ForestF.ordinal()] = forestF;

        ResourceScene millA = new ResourceScene();
        millA.rowCount = CoordinateMapEnum.MillA.getcRow();
        millA.columnCount = CoordinateMapEnum.MillA.getcColumn();
        millA.mapSignal = "???";
        sceneArray[CoordinateMapEnum.MillA.ordinal()] = millA;

        ResourceScene millB = new ResourceScene();
        millB.rowCount = CoordinateMapEnum.MillB.getcRow();
        millB.columnCount = CoordinateMapEnum.MillB.getcColumn();
        millB.mapSignal = "???";
        sceneArray[CoordinateMapEnum.MillB.ordinal()] = millB;

        ResourceScene millC = new ResourceScene();
        millC.rowCount = CoordinateMapEnum.MillC.getcRow();
        millC.columnCount = CoordinateMapEnum.MillC.getcColumn();
        millC.mapSignal = "???";
        sceneArray[CoordinateMapEnum.MillC.ordinal()] = millC;

        ResourceScene millD = new ResourceScene();
        millD.rowCount = CoordinateMapEnum.MillD.getcRow();
        millD.columnCount = CoordinateMapEnum.MillD.getcColumn();
        millD.mapSignal = "???";
        sceneArray[CoordinateMapEnum.MillD.ordinal()] = millD;

        ResourceScene millE = new ResourceScene();
        millE.rowCount = CoordinateMapEnum.MillE.getcRow();
        millE.columnCount = CoordinateMapEnum.MillE.getcColumn();
        millE.mapSignal = "???";
        sceneArray[CoordinateMapEnum.MillE.ordinal()] = millE;

        ResourceScene mountainA = new ResourceScene();
        mountainA.rowCount = CoordinateMapEnum.MountainA.getcRow();
        mountainA.columnCount = CoordinateMapEnum.MountainA.getcColumn();
        mountainA.mapSignal = "???";
        sceneArray[CoordinateMapEnum.MountainA.ordinal()] = mountainA;

        ResourceScene mountainB = new ResourceScene();
        mountainB.rowCount = CoordinateMapEnum.MountainB.getcRow();
        mountainB.columnCount = CoordinateMapEnum.MountainB.getcColumn();
        mountainB.mapSignal = "???";
        sceneArray[CoordinateMapEnum.MountainB.ordinal()] = mountainB;

        ResourceScene mountainC = new ResourceScene();
        mountainC.rowCount = CoordinateMapEnum.MountainC.getcRow();
        mountainC.columnCount = CoordinateMapEnum.MountainC.getcColumn();
        mountainC.mapSignal = "???";
        sceneArray[CoordinateMapEnum.MountainC.ordinal()] = mountainC;

        ResourceScene mountainD = new ResourceScene();
        mountainD.rowCount = CoordinateMapEnum.MountainD.getcRow();
        mountainD.columnCount = CoordinateMapEnum.MountainD.getcColumn();
        mountainD.mapSignal = "???";
        sceneArray[CoordinateMapEnum.MountainD.ordinal()] = mountainD;

        ResourceScene mineA = new ResourceScene();
        mineA.rowCount = CoordinateMapEnum.MineA.getcRow();
        mineA.columnCount = CoordinateMapEnum.MineA.getcColumn();
        mineA.mapSignal = "???";
        sceneArray[CoordinateMapEnum.MineA.ordinal()] = mineA;

        ResourceScene mineB = new ResourceScene();
        mineB.rowCount = CoordinateMapEnum.MineB.getcRow();
        mineB.columnCount = CoordinateMapEnum.MineB.getcColumn();
        mineB.mapSignal = "???";
        sceneArray[CoordinateMapEnum.MineB.ordinal()] = mineB;

        ResourceScene mineC = new ResourceScene();
        mineC.rowCount = CoordinateMapEnum.MineC.getcRow();
        mineC.columnCount = CoordinateMapEnum.MineC.getcColumn();
        mineC.mapSignal = "???";
        sceneArray[CoordinateMapEnum.MineC.ordinal()] = mineC;

        ResourceScene mineD = new ResourceScene();
        mineD.rowCount = CoordinateMapEnum.MineD.getcRow();
        mineD.columnCount = CoordinateMapEnum.MineD.getcColumn();
        mineD.mapSignal = "???";
        sceneArray[CoordinateMapEnum.MineD.ordinal()] = mineD;

        scene = sceneArray;

        return scene;
    }

    public static Location moveActor(Actor actor, int direction) throws MapControlException {
        boolean ifcity;
        Game game = kingdomsandglory.getCurrentGame();
        if (actor == null) {
            throw new MapControlException("Player Cannot Be Null");
        }

        int currentRow = game.player.actor.location.locationScene.getRowCount();
        int currentColumn = actor.location.locationScene.getColumnCount();
        int justincaseRow = currentRow;
        int justincaseCol = currentColumn;
        
        game.map.locations[currentRow][currentColumn].locationScene.actor = null;

            switch (direction) {
                case 1:
                    currentRow = currentRow - 1;
                    break;
                case 2:
                    currentRow = currentRow + 1;
                    break;
                case 3:
                    currentColumn = currentColumn + 1;
                    break;
                case 4:
                    currentColumn = currentColumn - 1;
                    break;
                default:
                    throw new MapControlException ("Invalid Selection");
            }
            
        if (currentRow < 0 || currentRow > 4) {
            System.out.println("You cannot move off the map.");
            game.map.locations[justincaseRow][justincaseCol].locationScene.actor = actor;
            return null;
        }
        if (currentColumn < 0 || currentColumn > 4) {
            System.out.println("You cannot move off the map.");
            game.map.locations[justincaseRow][justincaseCol].locationScene.actor = actor;
            return null;
        }
        
        actor.location = game.map.locations[currentRow][currentColumn];
        
        game.map.locations[currentRow][currentColumn].locationScene.actor = actor;
        
        

        return null;
    }


}
