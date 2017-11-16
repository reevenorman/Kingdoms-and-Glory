/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author reeve
 */
public class Actor implements Serializable {
        private Trait[] traits;
        private Point playerLocation;

    public Actor(Trait[] traits, Point playerLocation) {
        this.traits = traits;

        this.playerLocation = playerLocation;
    }

    public Trait[] getTraits() {
        return traits;
    }

    public void setTraits(Trait[] traits) {
        this.traits = traits;
    }

    public Point getPlayerLocation() {
        return playerLocation;
    }

    public void setPlayerLocation(Point playerLocation) {
        this.playerLocation = playerLocation;
    }    
}
