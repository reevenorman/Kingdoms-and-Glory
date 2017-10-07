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
        private String nameAddOn;
        private String playerCharacteristics;
        private Point playerLocation;

    public Actor(String nameAddOn, String playerCharacteristics, Point playerLocation) {
        this.nameAddOn = nameAddOn;
        this.playerCharacteristics = playerCharacteristics;
        this.playerLocation = playerLocation;
    }

    public String getNameAddOn() {
        return nameAddOn;
    }

    public String getPlayerCharacteristics() {
        return playerCharacteristics;
    }

    public Point getPlayerLocation() {
        return playerLocation;
    }

    public void setNameAddOn(String nameAddOn) {
        this.nameAddOn = nameAddOn;
    }

    public void setPlayerCharacteristics(String playerCharacteristics) {
        this.playerCharacteristics = playerCharacteristics;
    }

    public void setPlayerLocation(Point playerLocation) {
        this.playerLocation = playerLocation;
    }

    @Override
    public String toString() {
        return "Character{" + "nameAddOn=" + nameAddOn + ", playerCharacteristics=" + playerCharacteristics + ", playerLocation=" + playerLocation + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.nameAddOn);
        hash = 61 * hash + Objects.hashCode(this.playerCharacteristics);
        hash = 61 * hash + Objects.hashCode(this.playerLocation);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Actor other = (Actor) obj;
        if (!Objects.equals(this.nameAddOn, other.nameAddOn)) {
            return false;
        }
        if (!Objects.equals(this.playerCharacteristics, other.playerCharacteristics)) {
            return false;
        }
        if (!Objects.equals(this.playerLocation, other.playerLocation)) {
            return false;
        }
        return true;
    }
        
        
}
