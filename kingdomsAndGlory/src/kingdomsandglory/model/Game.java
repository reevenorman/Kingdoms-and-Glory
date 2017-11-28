/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author reeve
 */

public class Game implements Serializable {
       public Player player;
       public Resource[] resourceType;
       public Map map;
       public long dateTime;

    public Game(Player player, Resource[] resourceType, Map map, long dateTime) {
        this.player = player;
        this.resourceType = resourceType;
        this.map = map;
        this.dateTime = dateTime;
    }  
       
    public Game() {
        this.dateTime = System.currentTimeMillis();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Resource[] getResourceType() {
        return resourceType;
    }

    public void setResourceType(Resource[] resourceType) {
        this.resourceType = resourceType;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Game{" + "player=" + player + ", resourceType=" + resourceType + ", map=" + map + ", dateTime=" + dateTime + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.player);
        hash = 37 * hash + Arrays.deepHashCode(this.resourceType);
        hash = 37 * hash + Objects.hashCode(this.map);
        hash = 37 * hash + (int) (this.dateTime ^ (this.dateTime >>> 32));
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
        final Game other = (Game) obj;
        if (this.dateTime != other.dateTime) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Arrays.deepEquals(this.resourceType, other.resourceType)) {
            return false;
        }
        if (!Objects.equals(this.map, other.map)) {
            return false;
        }
        return true;
    }
    
    
       
}

