/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.model;

import java.io.Serializable;

/**
 *
 * @author piano
 */
public class Army implements Serializable {
    
    private long totalArmy;
    private long totalFootman;
    private long totalArcher;
    private long totalCalvary;

    public Army(long totalArmy, long totalFootman, long totalArcher, long totalCalvary) {
        this.totalArmy = totalArmy;
        this.totalFootman = totalFootman;
        this.totalArcher = totalArcher;
        this.totalCalvary = totalCalvary;
    }

    public long getTotalArmy() {
        return totalArmy;
    }

    public long getTotalFootman() {
        return totalFootman;
    }

    public long getTotalArcher() {
        return totalArcher;
    }

    public long getTotalCalvary() {
        return totalCalvary;
    }

    public void setTotalArmy(long totalArmy) {
        this.totalArmy = totalArmy;
    }

    public void setTotalFootman(long totalFootman) {
        this.totalFootman = totalFootman;
    }

    public void setTotalArcher(long totalArcher) {
        this.totalArcher = totalArcher;
    }

    public void setTotalCalvary(long totalCalvary) {
        this.totalCalvary = totalCalvary;
    }

    @Override
    public String toString() {
        return "Army{" + "totalArmy=" + totalArmy + ", totalFootman=" + totalFootman + ", totalArcher=" + totalArcher + ", totalCalvary=" + totalCalvary + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.totalArmy ^ (this.totalArmy >>> 32));
        hash = 97 * hash + (int) (this.totalFootman ^ (this.totalFootman >>> 32));
        hash = 97 * hash + (int) (this.totalArcher ^ (this.totalArcher >>> 32));
        hash = 97 * hash + (int) (this.totalCalvary ^ (this.totalCalvary >>> 32));
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
        final Army other = (Army) obj;
        if (this.totalArmy != other.totalArmy) {
            return false;
        }
        if (this.totalFootman != other.totalFootman) {
            return false;
        }
        if (this.totalArcher != other.totalArcher) {
            return false;
        }
        if (this.totalCalvary != other.totalCalvary) {
            return false;
        }
        return true;
    }
    
    
    
}
