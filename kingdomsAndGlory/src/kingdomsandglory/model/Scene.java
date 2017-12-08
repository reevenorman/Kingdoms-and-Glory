/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.model;

import java.util.Objects;

/**
 *
 * @author reeve
 */
public abstract class Scene {
    
    public String mapSignal;
    public int rowCount;
    public int columnCount;
    public Actor actor;
    public ResourceScene resourceScene;
    public CityScene cityscene;
    public String name;
    public int riskArmyFactor;
    public int riskFactor;
    public String mineralTypetoAttack;
    public int ownership;
    public String mineralTypeThere;

    public String getMineralTypeThere() {
        return mineralTypeThere;
    }

    public void setMineralTypeThere(String mineralTypeThere) {
        this.mineralTypeThere = mineralTypeThere;
    }
    
    public int getOwnership() {
        return ownership;
    }

    public void setOwnership(int ownership) {
        this.ownership = ownership;
    }
    
    public int getRiskArmyFactor() {
        return riskArmyFactor;
    }

    public void setRiskArmyFactor(int riskArmyFactor) {
        this.riskArmyFactor = riskArmyFactor;
    }

    public int getRiskFactor() {
        return riskFactor;
    }

    public void setRiskFactor(int riskFactor) {
        this.riskFactor = riskFactor;
    }

    public String getMineralTypetoAttack() {
        return mineralTypetoAttack;
    }

    public void setMineralTypetoAttack(String mineralTypetoAttack) {
        this.mineralTypetoAttack = mineralTypetoAttack;
    }

    
    
    public ResourceScene getResourceScene() {
        return resourceScene;
    }

    public CityScene getCityscene() {
        return cityscene;
    }

    public String getName() {
        return name;
    }
    

    public Scene() {
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
    
    
    
    public String getMapSignal() {
        return mapSignal;
    }

    public void setMapSignal(String mapSignal) {
        this.mapSignal = mapSignal;
    }

    @Override
    public String toString() {
        return "Scene{" + "mapSignal=" + mapSignal + ", rowCount=" + rowCount + ", columnCount=" + columnCount + ", actor=" + actor + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.mapSignal);
        hash = 89 * hash + this.rowCount;
        hash = 89 * hash + this.columnCount;
        hash = 89 * hash + Objects.hashCode(this.actor);
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
        final Scene other = (Scene) obj;
        if (this.rowCount != other.rowCount) {
            return false;
        }
        if (this.columnCount != other.columnCount) {
            return false;
        }
        if (!Objects.equals(this.mapSignal, other.mapSignal)) {
            return false;
        }
        if (!Objects.equals(this.actor, other.actor)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
