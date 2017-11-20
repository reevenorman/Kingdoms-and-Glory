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
    
    
    
    Visum ("Visum", "A bright and Beatiful town. Once the original City of the king.", new Point(1, 2)),
    Genus ("Genus", "A bright and Beatiful town. Once the original City of the king.", new Point(1, 4)),
    Pacem ("Pacem", "A bright and Beatiful town. Once the original City of the king.", new Point(3, 1)),
    Felicitatem ("Felicitatem", "A bright and Beatiful town. Once the original City of the king.", new Point(3, 3)),
    Pulchram ("Pulchram", "A bright and Beatiful town. Once the original City of the king.", new Point(3, 5)),
    Zenobia ("Zenobia", "The Capital of the Kingdom and Starting point.", new Point(5, 3)),
    ForestA ("Forest", "A thick wooded area with possibility of wood but may contain misfortunes", new Point(1, 1)),
    ForestB ("Forest", "A thick wooded area with possiblity of wood but may contain misfortunes", new Point(5, 1)),
    ForestC ("Forest", "A thick wooded area with possiblity of wood but may contain misfortunes", new Point(2, 3)),
    ForestD ("Forest", "A thick wooded area with possiblity of wood but may contain misfortunes", new Point(4, 4)),
    ForestF ("Forest", "A thick wooded area with possiblity of wood but may contain misfortunes", new Point(4, 5)),
    ForestE ("Forest", "A thick wooded area with possiblity of wood but may contain misfortunes", new Point(4, 3)),
    MillA ("Mill", "You've stumbled across a cotton mill, you have the chance of getting cotton", new Point(2, 1)),
    MillB ("Mill", "You've stumbled across a cotton mill, you have the chance of getting cotton", new Point(4, 2)),
    MillC ("Mill", "You've stumbled across a cotton mill, you have the chance of getting cotton", new Point(3, 4)),
    MillD ("Mill", "You've stumbled across a cotton mill, you have the chance of getting cotton", new Point(5, 5)),
    MillE ("Mill", "You've stumbled across a cotton mill, you have the chance of getting cotton", new Point(1, 5)),
    MountainA ("Mountain", "You're hiking a Mountain Range! There may be some Stone around you.", new Point(5, 1)),
    MountainB ("Mountain", "You're hiking a Mountain Range! There may be some Stone around you.", new Point(3, 2)),
    MountainC ("Mountain", "You're hiking a Mountain Range! There may be some Stone around you.", new Point(1, 3)),
    MountainD ("Mountain", "You're hiking a Mountain Range! There may be some Stone around you.", new Point(2, 4)),
    MineA ("Mine", "You've fallen into a Mine! Oh No! But, while you are down here look for Metal.", new Point(4, 1)),
    MineB ("Mine", "You've fallen into a Mine! Oh No! But, while you are down here look for Metal.", new Point(2, 2)),
    MineC ("Mine", "You've fallen into a Mine! Oh No! But, while you are down here look for Metal.", new Point(5, 4)),
    MineD ("Mine", "You've fallen into a Mine! Oh No! But, while you are down here look for Metal.", new Point(2, 5));
    
    String name;
    String description;
    Point cooridnates = null;
    
 CoordinateMapEnum(String name, String description, Point cooridnates) {
        this.name = name;
        this.description = description;
        this.cooridnates = cooridnates;
    }
    

    public static CoordinateMapEnum getVisum() {
        return Visum;
    }

    public static CoordinateMapEnum getGenus() {
        return Genus;
    }

    public static CoordinateMapEnum getPacem() {
        return Pacem;
    }

    public static CoordinateMapEnum getFelicitatem() {
        return Felicitatem;
    }

    public static CoordinateMapEnum getPulchram() {
        return Pulchram;
    }

    public static CoordinateMapEnum getZenobia() {
        return Zenobia;
    }

    public static CoordinateMapEnum getForestA() {
        return ForestA;
    }

    public static CoordinateMapEnum getForestB() {
        return ForestB;
    }

    public static CoordinateMapEnum getForestC() {
        return ForestC;
    }

    public static CoordinateMapEnum getForestD() {
        return ForestD;
    }

    public static CoordinateMapEnum getForestF() {
        return ForestF;
    }

    public static CoordinateMapEnum getForestE() {
        return ForestE;
    }

    public static CoordinateMapEnum getMillA() {
        return MillA;
    }

    public static CoordinateMapEnum getMillB() {
        return MillB;
    }

    public static CoordinateMapEnum getMillC() {
        return MillC;
    }

    public static CoordinateMapEnum getMillD() {
        return MillD;
    }

    public static CoordinateMapEnum getMillE() {
        return MillE;
    }

    public static CoordinateMapEnum getMountainA() {
        return MountainA;
    }

    public static CoordinateMapEnum getMountainB() {
        return MountainB;
    }

    public static CoordinateMapEnum getMountainC() {
        return MountainC;
    }

    public static CoordinateMapEnum getMountainD() {
        return MountainD;
    }

    public static CoordinateMapEnum getMineA() {
        return MineA;
    }

    public static CoordinateMapEnum getMineB() {
        return MineB;
    }

    public static CoordinateMapEnum getMineC() {
        return MineC;
    }

    public static CoordinateMapEnum getMineD() {
        return MineD;
    }
    
    

    
}
