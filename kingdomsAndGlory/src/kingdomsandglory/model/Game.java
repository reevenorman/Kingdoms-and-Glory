/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author reeve
 */
public class Game implements Serializable{
       private Player player;
       private InventoryItem[] inventory;
       private Map map;
       private Date dateTime;
       private String gameSave;

    public Game(Date dateTime, String gameSave) {
        this.dateTime = dateTime;
        this.gameSave = gameSave;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public String getGameSave() {
        return gameSave;
    }

    public void setDateTime(Date dataTime) {
        this.dateTime = dataTime;
    }

    public void setGameSave(String gameSave) {
        this.gameSave = gameSave;
    }

    @Override
    public String toString() {
        return "Game{" + "dateTime=" + dateTime + ", gameSave=" + gameSave + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.dateTime);
        hash = 89 * hash + Objects.hashCode(this.gameSave);
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
        if (!Objects.equals(this.gameSave, other.gameSave)) {
            return false;
        }
        if (!Objects.equals(this.dateTime, other.dateTime)) {
            return false;
        }
        return true;
    }
       
       
}

