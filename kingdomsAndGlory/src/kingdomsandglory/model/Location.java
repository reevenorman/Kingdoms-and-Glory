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
public class Location implements Serializable {
    public int row;
    public int column;
    public Boolean visited;
    public Scene locationScene;
    
    
    public Location() {
        this.row = row;
        this.column = column;
        this.visited = visited;
        this.locationScene = locationScene;

    }

    public Location(int row, int column, Boolean visited, Scene scene) {
        this.row = row;
        this.column = column;
        this.visited = visited;
        this.locationScene = scene;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public Scene getLocationScene() {
        return locationScene;
    }

    public void setLocationScene(Scene scene) {
        this.locationScene = scene;
    }

    @Override
    public String toString() {
        return "Location{" + "row=" + row + ", column=" + column + ", visited=" + visited + ", scene=" + locationScene + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.row;
        hash = 13 * hash + this.column;
        hash = 13 * hash + Objects.hashCode(this.visited);
        hash = 13 * hash + Objects.hashCode(this.locationScene);
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
        final Location other = (Location) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        if (!Objects.equals(this.locationScene, other.locationScene)) {
            return false;
        }
        return true;
    }

    
}

    