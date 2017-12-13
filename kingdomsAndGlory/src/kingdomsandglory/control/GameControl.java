/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.control;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.dateTime;
import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import kingdomsandglory.control.MapControl;
import kingdomsandglory.exceptions.GameControlException;
import kingdomsandglory.exceptions.MapControlException;
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

        Trait trait = new Trait();
        game.trait = trait;

        Trait[] traits = new Trait[3];
        traits = createTraits();

        game.trait.trait = traits;

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

    public static void saveGame(Game game, String filePath) throws GameControlException, IOException {
        if (game == null || filePath == null) {
            throw new GameControlException("Game Cannot Be Null");
        }

        try (ObjectOutputStream out
                = new ObjectOutputStream(new FileOutputStream(filePath))) {

            out.writeObject(game);

        } catch (IOException ex) {
            throw new IOException("Your File Path Was Invalid " + ex.getMessage());
        }

        return;
    }

    public static void LoadGame(String filePath) throws GameControlException, IOException, ClassNotFoundException {
        if (filePath == null) {
            throw new GameControlException("Game Cannot Be Null");
        }

        try (ObjectInputStream in
                = new ObjectInputStream(new FileInputStream(filePath))) {

            Game game = new Game();
            Player player = new Player();
            game = (Game) in.readObject();

            kingdomsandglory.setCurrentGame(game);

            player = game.getPlayer();

            kingdomsandglory.setPlayer(player);

        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("Your File Path Was Invalid, Please Try Again" + ex.getMessage());
        }

        return;
    }

    public static int checkWin(Game game) {
        int[] winner = new int[5];
        winner[0] = game.map.locations[0][1].locationScene.getOwnership();
        winner[1] = game.map.locations[0][3].locationScene.getOwnership();
        winner[2] = game.map.locations[2][0].locationScene.getOwnership();
        winner[3] = game.map.locations[2][2].locationScene.getOwnership();
        winner[4] = game.map.locations[2][4].locationScene.getOwnership();

        int total = 0;

        for (int value : winner) {
            total = total + value;
        }
        return total;
    }

    public static void printLocations(Game game, String filePath) throws GameControlException, IOException {
        if (game == null || filePath == null) {
            throw new GameControlException("Game Cannot Be Null");
        }
        
        String message;
        Location[][] locations = game.map.getLocations();
        int i = 0;
        int j = 0;
        String locationName = "";
        int locationRow = 0;
        int locationColumn = 0;
        String coordinates = "";

        try (PrintWriter out
                = new PrintWriter(new FileOutputStream(filePath))) {
            out.println("             The Kingdom of Zenobia               \n");
            out.printf("%n%-20s%30s%n", "Location Name", "Location Coordinates");
            out.println("--------------------------------------------------");

            for (Location[] row : locations) {
                j = 0;
                for (Location[] column : locations) {
                    locationName = locations[i][j].locationScene.getName();
                    locationRow = locations[i][j].locationScene.getRowCount();
                    locationColumn = locations[i][j].locationScene.getColumnCount();
                    coordinates = locationRow + ", " + locationColumn;
                    out.printf("%n%-20s%30s", locationName, coordinates);

                    j++;
                }
                i++;
            }

        } catch (IOException ex) {
            throw new IOException("Your File Path Was Invalid " + ex.getMessage());
        }
    }

    public static void printResources(Game game, String filePath) throws GameControlException, IOException {
        String message;
        Resource[] resource = game.getResourceType();
        String place = "";
        int i = 0;
        String resourceName;
        int resourceQty;

        try (PrintWriter out
                = new PrintWriter(new FileOutputStream(filePath))) {
            out.println("     The Kingdom of Zenobia        \n");
            out.printf("%n%-20s%10s%n", "Resource Name", "Resource Qty");
            out.println("---------------------------------");

            for (Resource row : resource) {
                place = null;
                resourceName = resource[i].getResourceDiscription();
                resourceQty = resource[i].getResourceQty();
                out.printf("%n%-20s%10s", resourceName, resourceQty);
                i++;
            }

        } catch (IOException ex) {
            throw new IOException("Your File Path Was Invalid " + ex.getMessage());
        }
    }

    public static String LoadDocument(String filePath) throws GameControlException, IOException, ClassNotFoundException {
        if (filePath == null) {
            throw new GameControlException("Game Cannot Be Null");
        }

        String message = "";

        try (Scanner in
                = new Scanner(new FileReader(filePath))) {

            while (in.hasNextLine()) {
                message = message + in.next();
            }
        } catch (IOException ex) {
            throw new IOException("Your File Path Was Invalid, Please Try Again" + ex.getMessage());
        }

        return message;
    }
}
