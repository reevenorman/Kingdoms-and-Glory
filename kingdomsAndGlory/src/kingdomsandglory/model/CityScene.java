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
public class CityScene implements Serializable {
    
    private Boolean ownership;
    private Long riskFactor;

    public CityScene(Boolean ownership, Long riskFactor) {
        this.ownership = ownership;
        this.riskFactor = riskFactor;
    }

    public Boolean getOwnership() {
        return ownership;
    }

    public Long getRiskFactor() {
        return riskFactor;
    }

    public void setOwnership(Boolean ownership) {
        this.ownership = ownership;
    }

    public void setRiskFactor(Long riskFactor) {
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
