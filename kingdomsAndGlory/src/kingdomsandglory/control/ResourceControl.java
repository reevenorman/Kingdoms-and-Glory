/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.control;

import kingdomsandglory.exceptions.ResourceControlException;
import kingdomsandglory.model.Game;
import kingdomsandglory.model.Resource;
import kingdomsandglory.model.ResourceEnum;

/**
 *
 * @author piano
 */
public class ResourceControl {
    public static Resource[] createItems() {
        Resource[] resourceType = new Resource[6];

        Resource cloth = new Resource();
        cloth.resourceQty = 0;
        cloth.resourceDiscription = "Cloth";
        resourceType[ResourceEnum.cloth.ordinal()] = cloth;

        Resource wood = new Resource();
        wood.resourceQty = 0;
        wood.resourceDiscription = "Wood";
        resourceType[ResourceEnum.wood.ordinal()] = wood;

        Resource stone = new Resource();
        stone.resourceQty = 0;
        stone.resourceDiscription = "Stone";
        resourceType[ResourceEnum.stone.ordinal()] = stone;

        Resource metal = new Resource();
        metal.resourceQty = 0;
        metal.resourceDiscription = "Metal";
        resourceType[ResourceEnum.metal.ordinal()] = metal;

        Resource gold = new Resource();
        gold.resourceQty = 0;
        gold.resourceDiscription = "Gold";
        resourceType[ResourceEnum.gold.ordinal()] = gold;
        
        Resource army = new Resource();
        army.resourceQty = 50;
        army.resourceDiscription = "Army";
        resourceType[ResourceEnum.army.ordinal()] = army;
        
        

        return resourceType;
    }
    
    public static String makeTransaction(int[] inputs) throws ResourceControlException {
        String cannot;
        Game game = kingdomsandglory.kingdomsandglory.getCurrentGame();
        int minQty = game.resourceType[(inputs[1])].getResourceQty();
        int gold = game.resourceType[4].resourceQty;
        int sellQty = inputs[2];
        String min = game.resourceType[(inputs[1])].getResourceDiscription();
        int subtotalSell = minQty - sellQty;
        int sellPrice = checkSellPrice(inputs);
        int buyPrice = checkBuyPrice(inputs);
        int transaction;
        int total;
        int newGold;
        int subtotalBuy = sellQty * buyPrice;
        

        /*Resource - Buying Price/Selling Price       
        Cloth    -  2 / 1                               
        Wood     -  3 / 2                              
        Stone    -  3 / 2               
        Metal    -  5 / 3                               
        Amry Men -  7 / 1                                 
        input 1 = 1 - sell
                  0 - buy
        input 2 = 0 - cloth
                  2 - wood, stone, metal, gold, army
        input 3 = how many*/
        
        if (inputs[0] == 1) {
            if (minQty < 1 || subtotalSell < 0){
                cannot = ("You do not have enough " + min + " to sell. Please choose something else or a different amount.\n");
                return cannot;
            } else {
                transaction = sellPrice * sellQty;
                newGold = gold + transaction;
                total = minQty - sellQty;
                game.resourceType[(inputs[1])].setResourceQty(total);
                game.resourceType[4].setResourceQty(newGold);
                String succes = ("You have successfully sold " + minQty + " " + min + " for " + transaction + " Gold.\n");
                return succes;
            }
        } else {
            if (gold < 1 || subtotalBuy > gold){
                cannot = ("You do not have enough gold to buy that much. Please choose something else.\n");
                return cannot;
            } else {
                transaction = buyPrice * sellQty;
                newGold = gold - transaction;
                total = minQty + sellQty;
                game.resourceType[(inputs[1])].setResourceQty(total);
                game.resourceType[4].setResourceQty(newGold);
                String succes = ("You have successfully bought " + minQty + " " + min + " for " + transaction + " Gold.\n");
                return succes;
            }
        }
    }

    private static int checkSellPrice(int[] inputs) {
        int sell = 0;
        switch (inputs[1]) {
            case 0:
                sell = 1;
                break;
            case 1:
                sell = 2;
                break;
            case 2:
                sell = 2;
                break;
            case 3:
                sell = 3;
                break;
            case 5:
                sell = 1;
                break;
        }
        return sell;
    }

    private static int checkBuyPrice(int[] inputs) {
        int buy = 0;
        switch (inputs[1]) {
            case 0:
                buy = 2;
                break;
            case 1:
                buy = 3;
                break;
            case 2:
                buy = 3;
                break;
            case 3:
                buy = 5;
                break;
            case 5:
                buy = 7;
                break;
        }
        return buy;
    }
    
    public static int totalResources(int[] resource) throws ResourceControlException {
        if (resource == null) {
            throw new ResourceControlException("Invalid Input");
        }
        int total = 0;
        int item;
        int i = 0;
        for (int value : resource) {
            item = resource[i];
            total = total + item;
            i++;
        }
        return total;
    }
            
    
}
