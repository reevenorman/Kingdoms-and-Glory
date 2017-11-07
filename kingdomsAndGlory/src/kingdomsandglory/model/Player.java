/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author reeve
 */
public class Player implements Serializable{
    public String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public Player() {
        
    }

    public String getPlayerName() {
        return playerName;
    }

    public static void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return "Player{" + "playerName=" + playerName + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.playerName);
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
        final Player other = (Player) obj;
        return true;
    }
    
    
    
}
