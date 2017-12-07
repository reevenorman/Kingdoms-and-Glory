/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author reeve
 */
public class Actor implements Serializable {
        public Trait trait;
        public Location location;
        
    public Actor() {
        this.trait = trait;
        this.location = location;
    }

    public Actor(Trait trait, Location location) {
        this.trait = trait;
        this.location = location;
    }

    public Trait getTraits() {
        return trait;
    }

    public void setTraits(Trait traits) {
        this.trait = trait;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Actor{" + "traits=" + trait + ", location=" + location + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.trait);
        hash = 53 * hash + Objects.hashCode(this.location);
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
        if (!Objects.equals(this.trait, other.trait)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        return true;
    }


 
}
