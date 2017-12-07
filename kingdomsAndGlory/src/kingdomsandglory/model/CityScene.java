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
 * @author piano
 */
public class CityScene extends Scene implements Serializable {
    
    public String name;
    public int ownership;
    public int riskArmyFactor;
    public int riskFactor;
    public String mineralTypetoAttack;

    public String getMineralTypetoAttack() {
        return mineralTypetoAttack;
    }

    public void setMineralTypetoAttack(String mineralTypetoAttack) {
        this.mineralTypetoAttack = mineralTypetoAttack;
    }

    public int getRiskArmyFactor() {
        return riskArmyFactor;
    }

    public void setRiskArmyFactor(int riskArmyFactor) {
        this.riskArmyFactor = riskArmyFactor;
    }
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public CityScene() {
    }

    public int getOwnership() {
        return ownership;
    }

    public int getRiskFactor() {
        return riskFactor;
    }

    public void setOwnership(int ownership) {
        this.ownership = ownership;
    }

    public void setRiskFactor(int riskFactor) {
        this.riskFactor = riskFactor;
    }

    @Override
    public String toString() {
        return "CityScene{" + "ownership=" + ownership + ", riskFactor=" + riskFactor + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.ownership);
        hash = 41 * hash + Objects.hashCode(this.riskFactor);
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
        final CityScene other = (CityScene) obj;
        if (!Objects.equals(this.ownership, other.ownership)) {
            return false;
        }
        if (!Objects.equals(this.riskFactor, other.riskFactor)) {
            return false;
        }
        return true;
    }
    
    
}
