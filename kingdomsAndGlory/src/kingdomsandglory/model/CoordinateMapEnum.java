/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.model;

import java.awt.Point;
import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author reeve
 */
public enum CoordinateMapEnum {
    
    
    
    Visum ("Visum", "A bright and Beatiful town. Once the original City of the king.", 1, 2),
    Genus ("Genus", "A bright and Beatiful town. Once the original City of the king.", 1, 4),
    Pacem ("Pacem", "A bright and Beatiful town. Once the original City of the king.", 3, 1),
    Felicitatem ("Felicitatem", "A bright and Beatiful town. Once the original City of the king.", 3, 3),
    Pulchram ("Pulchram", "A bright and Beatiful town. Once the original City of the king.", 3, 5),
    Zenobia ("Zenobia", "The Capital of the Kingdom and Starting point.", 5, 3),
    ForestA ("Forest", "A thick wooded area with possibility of wood but may contain misfortunes", 1, 1),
    ForestB ("Forest", "A thick wooded area with possiblity of wood but may contain misfortunes", 5, 1),
    ForestC ("Forest", "A thick wooded area with possiblity of wood but may contain misfortunes", 2, 3),
    ForestD ("Forest", "A thick wooded area with possiblity of wood but may contain misfortunes", 4, 4),
    ForestE ("Forest", "A thick wooded area with possiblity of wood but may contain misfortunes", 4, 5),
    ForestF ("Forest", "A thick wooded area with possiblity of wood but may contain misfortunes", 4, 3),
    MillA ("Mill", "You've stumbled across a cotton mill, you have the chance of getting cotton", 2, 1),
    MillB ("Mill", "You've stumbled across a cotton mill, you have the chance of getting cotton", 4, 2),
    MillC ("Mill", "You've stumbled across a cotton mill, you have the chance of getting cotton", 3, 4),
    MillD ("Mill", "You've stumbled across a cotton mill, you have the chance of getting cotton", 5, 5),
    MillE ("Mill", "You've stumbled across a cotton mill, you have the chance of getting cotton", 1, 5),
    MountainA ("Mountain", "You're hiking a Mountain Range! There may be some Stone around you.", 5, 1),
    MountainB ("Mountain", "You're hiking a Mountain Range! There may be some Stone around you.", 3, 2),
    MountainC ("Mountain", "You're hiking a Mountain Range! There may be some Stone around you.", 1, 3),
    MountainD ("Mountain", "You're hiking a Mountain Range! There may be some Stone around you.", 2, 4),
    MineA ("Mine", "You've fallen into a Mine! Oh No! But, while you are down here look for Metal.", 4, 1),
    MineB ("Mine", "You've fallen into a Mine! Oh No! But, while you are down here look for Metal.", 2, 2),
    MineC ("Mine", "You've fallen into a Mine! Oh No! But, while you are down here look for Metal.", 5, 4),
    MineD ("Mine", "You've fallen into a Mine! Oh No! But, while you are down here look for Metal.", 2, 5);
    
    String name;
    String description;
    int cRow;
    int cColumn;
    
    
 CoordinateMapEnum(String name, String description, int cRow, int cColumn) {
        this.name = name;
        this.description = description;
        this.cRow = cRow;
        this.cColumn = cColumn;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getcRow() {
        return cRow;
    }

    public int getcColumn() {
        return cColumn;
    }

    
    
}

    