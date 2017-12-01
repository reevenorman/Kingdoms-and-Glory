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

/**
 *
 * @author piano
 */
public class MapControl {

    public static long battleOutcome(long armyValue, long resourceList, long cityArmyValue, long cityResourceList) {

        if (armyValue > 1000000000) {
            return -1;
        }
        if (armyValue < 0) {
            return -5;
        }
        if (cityArmyValue > 1000000000) {
            return -3;
        }
        if (cityArmyValue < 0) {
            return -7;
        }
        if (resourceList > 1000000000) {
            return -2;
        }
        if (resourceList < 0) {
            return -6;
        }
        if (cityResourceList > 1000000000) {
            return -4;
        }
        if (cityResourceList < 0) {
            return -8;
        }
        if (resourceList == 0 && cityResourceList == 0 && armyValue == 0 && cityArmyValue == 0) {
            return -9;
        }
        double resourceBonus = 1.0;
        double cityResourceBonus = 1.0;
        if (resourceList > cityResourceList) {
            resourceBonus = 1.5;
        }
        if (resourceList < cityResourceList) {
            cityResourceBonus = 1.5;
        }
        double attackValue = armyValue + (resourceList * resourceBonus);
        double cityDefenseValue = cityArmyValue + (cityResourceList * cityResourceBonus);

        if (attackValue >= cityDefenseValue) {
            return 1;
        }
        return 0;
    }

    public static String fortuneOutcome(int userGambleOption, int randResourceAmt, int randResourceObj, int randChanceAmt) {
        Game game = new Game();
        game = kingdomsandglory.kingdomsandglory.getCurrentGame();

        Resource resource = new Resource();

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
        if (randResourceObj >= 5) {
            return "-5";
        }
        if (randResourceObj < -1) {
            return "-6";
        }
        if (randChanceAmt >= 7) {
            return "-7";
        }
        if (randChanceAmt <= 0) {
            return "-8";
        }

        if (userGambleOption == 0) {
            outcome = randResourceAmt * 0.2;
            game.resourceType[randResourceObj].resourceQty = game.resourceType[randResourceObj].resourceQty + (int) outcome;
            resultOutcome = ("You gained " + outcome + " pieces of " + randResourceObj + ".");
            return resultOutcome;
        }
        if (userGambleOption == 1) {
            double guarenteedOutcome = randResourceAmt * 0.2;
            if (randChanceAmt >= 3) {
                outcome = randResourceAmt * 0.8;
                game.resourceType[randResourceObj].resourceQty = game.resourceType[randResourceObj].resourceQty + (int) outcome + (int) guarenteedOutcome;
                resultOutcome = ("You gained " + randResourceAmt + " pieces of " + randResourceObj + ".");
            } else {
                outcome = randResourceAmt * 0.8;
                game.resourceType[randResourceObj].resourceQty = game.resourceType[randResourceObj].resourceQty - (int) outcome + (int) guarenteedOutcome;
                resultOutcome = ("You gained " + randResourceAmt + " pieces of " + randResourceObj + "."
                        + "But, You were attacked by bandits! And lost, " + outcome + " pieces of " + randResourceObj + ".");
            }
        }
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
        //scene = MapControl.createResourceScene(scene);

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

        CityScene visum = new CityScene();
        visum.rowCount = CoordinateMapEnum.Visum.getcRow();
        visum.columnCount = CoordinateMapEnum.Visum.getcColumn();
        visum.mapSignal = "Vis";
        visum.ownership = false;
        visum.riskFactor = 0;
        sceneArray[CoordinateMapEnum.Visum.ordinal()] = visum;

        CityScene genus = new CityScene();
        genus.rowCount = CoordinateMapEnum.Genus.getcRow();
        genus.columnCount = CoordinateMapEnum.Genus.getcColumn();
        genus.mapSignal = "Gen";
        genus.ownership = false;
        genus.riskFactor = 0;
        sceneArray[CoordinateMapEnum.Genus.ordinal()] = genus;

        CityScene pacem = new CityScene();
        pacem.rowCount = CoordinateMapEnum.Pacem.getcRow();
        pacem.columnCount = CoordinateMapEnum.Pacem.getcColumn();
        pacem.mapSignal = "Pac";
        pacem.ownership = false;
        pacem.riskFactor = 0;
        sceneArray[CoordinateMapEnum.Pacem.ordinal()] = pacem;

        CityScene felicitatem = new CityScene();
        felicitatem.rowCount = CoordinateMapEnum.Felicitatem.getcRow();
        felicitatem.columnCount = CoordinateMapEnum.Felicitatem.getcColumn();
        felicitatem.mapSignal = "Fel";
        felicitatem.ownership = false;
        felicitatem.riskFactor = 0;
        sceneArray[CoordinateMapEnum.Felicitatem.ordinal()] = felicitatem;

        CityScene pulchram = new CityScene();
        pulchram.rowCount = CoordinateMapEnum.Pulchram.getcRow();
        pulchram.columnCount = CoordinateMapEnum.Pulchram.getcColumn();
        pulchram.mapSignal = "Pul";
        pulchram.ownership = false;
        pulchram.riskFactor = 0;
        sceneArray[CoordinateMapEnum.Pulchram.ordinal()] = pulchram;

        CityScene zenobia = new CityScene();
        zenobia.rowCount = CoordinateMapEnum.Zenobia.getcRow();
        zenobia.columnCount = CoordinateMapEnum.Zenobia.getcColumn();
        zenobia.mapSignal = "Zen";
        zenobia.ownership = true;
        zenobia.riskFactor = 0;
        sceneArray[CoordinateMapEnum.Zenobia.ordinal()] = zenobia;

        ResourceScene forestA = new ResourceScene();
        forestA.rowCount = CoordinateMapEnum.ForestA.getcRow();
        forestA.columnCount = CoordinateMapEnum.ForestA.getcColumn();
        forestA.mapSignal = "???";
        sceneArray[CoordinateMapEnum.ForestA.ordinal()] = forestA;

        ResourceScene forestB = new ResourceScene();
        forestB.rowCount = CoordinateMapEnum.ForestB.getcRow();
        forestB.columnCount = CoordinateMapEnum.ForestB.getcColumn();
        forestB.mapSignal = "???";
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
        Player player = new Player();
        player = getPlayer();
        if (player == null) {
            throw new MapControlException("Player Cannot Be Null");
        }
        Game game = new Game();
        setPlayer(player);
        kingdomsandglory.setCurrentGame(game);
        int currentRow = actor.actorLocationRow;
        int currentColumn = actor.actorLocationColumn;

        switch (direction) {
            case 1:
                currentColumn = currentColumn - 1;
                break;
            case 2:
                currentColumn = currentColumn + 1;
                break;
            case 3:
                currentRow = currentRow - 1;
                break;
            case 4:
                currentRow = currentRow + 1;
                break;
            default:
                System.out.println("invalid Input");
        }

        return null;
    }
}
