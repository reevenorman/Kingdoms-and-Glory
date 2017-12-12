/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author reeve
 */
public enum CoordinateMapEnum implements Serializable {
    
    
    
    Visum ("Visum", "A bright and Beatiful town. Once the original City of the king.", 0, 1),
    Genus ("Genus", "A bright and Beatiful town. Once the original City of the king.", 0, 3),
    Pacem ("Pacem", "A bright and Beatiful town. Once the original City of the king.", 2, 0),
    Felicitatem ("Felicitatem", "A bright and Beatiful town. Once the original City of the king.", 2, 2),
    Pulchram ("Pulchram", "A bright and Beatiful town. Once the original City of the king.", 2, 4),
    Zenobia ("Zenobia", "The Capital of the Kingdom and Starting point.", 4, 2),
    ForestA ("Forest", "A thick wooded area with possibility of wood but may contain misfortunes", 0, 0),
    ForestB ("Forest", "A thick wooded area with possiblity of wood but may contain misfortunes", 1, 2),
    ForestC ("Forest", "A thick wooded area with possiblity of wood but may contain misfortunes", 3, 2),
    ForestD ("Forest", "A thick wooded area with possiblity of wood but may contain misfortunes", 3, 3),
    ForestE ("Forest", "A thick wooded area with possiblity of wood but may contain misfortunes", 3, 4),
    ForestF ("Forest", "A thick wooded area with possiblity of wood but may contain misfortunes", 4, 1),
    MillA ("Mill", "You've stumbled across a cotton mill, you have the chance of getting cotton", 0, 4),
    MillB ("Mill", "You've stumbled across a cotton mill, you have the chance of getting cotton", 1, 0),
    MillC ("Mill", "You've stumbled across a cotton mill, you have the chance of getting cotton", 2, 3),
    MillD ("Mill", "You've stumbled across a cotton mill, you have the chance of getting cotton", 3, 1),
    MillE ("Mill", "You've stumbled across a cotton mill, you have the chance of getting cotton", 4, 4),
    MountainA ("Mountain", "You're hiking a Mountain Range! There may be some Stone around you.", 0, 2),
    MountainB ("Mountain", "You're hiking a Mountain Range! There may be some Stone around you.", 1, 3),
    MountainC ("Mountain", "You're hiking a Mountain Range! There may be some Stone around you.", 2, 1),
    MountainD ("Mountain", "You're hiking a Mountain Range! There may be some Stone around you.", 4, 0),
    MineA ("Mine", "You've fallen into a Mine! Oh No! But, while you are down here look for Metal.", 1, 1),
    MineB ("Mine", "You've fallen into a Mine! Oh No! But, while you are down here look for Metal.", 1, 4),
    MineC ("Mine", "You've fallen into a Mine! Oh No! But, while you are down here look for Metal.", 3, 0),
    MineD ("Mine", "You've fallen into a Mine! Oh No! But, while you are down here look for Metal.", 4, 3);
    
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

    