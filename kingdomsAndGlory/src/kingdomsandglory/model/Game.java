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
       private Date dataTime;
       private String gameSave;

    public Game(Date dataTime, String gameSave) {
        this.dataTime = dataTime;
        this.gameSave = gameSave;
    }

    public Date getDataTime() {
        return dataTime;
    }

    public String getGameSave() {
        return gameSave;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    public void setGameSave(String gameSave) {
        this.gameSave = gameSave;
    }

    @Override
    public String toString() {
        return "Game{" + "dataTime=" + dataTime + ", gameSave=" + gameSave + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.dataTime);
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
        if (!Objects.equals(this.dataTime, other.dataTime)) {
            return false;
        }
        return true;
    }
       
       
}

