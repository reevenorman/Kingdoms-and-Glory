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
    private Long row;
    private Long column;
    private Boolean visited;

    public Location(Long row, Long column, Boolean visited) {
        this.row = row;
        this.column = column;
        this.visited = visited;
    }

    public Long getRow() {
        return row;
    }

    public Long getColumn() {
        return column;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setRow(Long row) {
        this.row = row;
    }

    public void setColumn(Long column) {
        this.column = column;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Location{" + "row=" + row + ", column=" + column + ", visited=" + visited + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.row);
        hash = 67 * hash + Objects.hashCode(this.column);
        hash = 67 * hash + Objects.hashCode(this.visited);
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
        if (!Objects.equals(this.row, other.row)) {
            return false;
        }
        if (!Objects.equals(this.column, other.column)) {
            return false;
        }
        if (!Objects.equals(this.visited, other.visited)) {
            return false;
        }
        return true;
    }
    
    
}
