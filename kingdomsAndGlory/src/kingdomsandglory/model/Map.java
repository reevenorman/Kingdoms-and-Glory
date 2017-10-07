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
public class Map implements Serializable {
    private long rowCount;
    private long columnCount;

    public Map(long rowCount, long columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
    }

    public long getRowCount() {
        return rowCount;
    }

    public long getColumnCount() {
        return columnCount;
    }

    public void setRowCount(long rowCount) {
        this.rowCount = rowCount;
    }

    public void setColumnCount(long columnCount) {
        this.columnCount = columnCount;
    }

    @Override
    public String toString() {
        return "Map{" + "rowCount=" + rowCount + ", columnCount=" + columnCount + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (int) (this.rowCount ^ (this.rowCount >>> 32));
        hash = 89 * hash + (int) (this.columnCount ^ (this.columnCount >>> 32));
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
        final Map other = (Map) obj;
        if (this.rowCount != other.rowCount) {
            return false;
        }
        if (this.columnCount != other.columnCount) {
            return false;
        }
        return true;
    }
    
    
}
