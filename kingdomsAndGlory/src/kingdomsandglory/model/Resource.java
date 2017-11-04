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
public class Resource implements Serializable {
    
    public int[] resourceType;
    public Double resourceQty;
    public Double moneyQty;
    
    public Resource() {
        this.resourceType = new int[3];
        this.moneyQty = 0.0;
        this.resourceQty = 0.0;
    }

    
    public Resource(int[] resourceType, Double resourceQty, Double moneyQty) {
        this.resourceType = resourceType;
        this.resourceQty = resourceQty;
        this.moneyQty = moneyQty;
    }

    public int[] getResourceType() {
        return resourceType;
    }

    public Double getResourceQty() {
        return resourceQty;
    }

    public Double getMoneyQty() {
        return moneyQty;
    }

    public void setResourceType(int[] resourceType) {
        this.resourceType = resourceType;
    }

    public void setResourceQty(Double resourceQty) {
        this.resourceQty = resourceQty;
    }

    public void setMoneyQty(Double moneyQty) {
        this.moneyQty = moneyQty;
    }

    @Override
    public String toString() {
        return "Resource{" + "resourceType=" + resourceType + ", resourceQty=" + resourceQty + ", moneyQty=" + moneyQty + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.resourceType);
        hash = 97 * hash + Objects.hashCode(this.resourceQty);
        hash = 97 * hash + Objects.hashCode(this.moneyQty);
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
        final Resource other = (Resource) obj;
        if (!Objects.equals(this.resourceType, other.resourceType)) {
            return false;
        }
        if (!Objects.equals(this.resourceQty, other.resourceQty)) {
            return false;
        }
        if (!Objects.equals(this.moneyQty, other.moneyQty)) {
            return false;
        }
        return true;
    }
    
    
    
}
