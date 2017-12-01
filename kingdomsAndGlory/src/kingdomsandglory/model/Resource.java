/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author piano
 */
public class Resource implements Serializable {
    
    public String resourceDiscription;
    public Double resourceQty;

    
    public Resource() {
        this.resourceDiscription = "";
        this.resourceQty = 0.0;
    }

    
    public Resource(int[] resourceType, Double resourceQty, Double moneyQty) {
        this.resourceQty = resourceQty;
        this.resourceDiscription = resourceDiscription;
    }
    
    public String getResourceDiscription() {
        return resourceDiscription;
    }

    public void setResourceDiscription(String resourceDiscription) {
        this.resourceDiscription = resourceDiscription;
    }
    


    public Double getResourceQty() {
        return resourceQty;
    }



    public void setResourceQty(Double resourceQty) {
        this.resourceQty = resourceQty;
    }

    @Override
    public String toString() {
        return "Resource{" + ", resourceDiscription=" + resourceDiscription + ", resourceQty=" + resourceQty + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.resourceDiscription);
        hash = 19 * hash + Objects.hashCode(this.resourceQty);
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
        if (!Objects.equals(this.resourceDiscription, other.resourceDiscription)) {
            return false;
        }
        if (!Objects.equals(this.resourceQty, other.resourceQty)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
