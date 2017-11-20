/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.model;

import java.io.Serializable;

/**
 *
 * @author reeve
 */
public class FortuneScene extends Scene implements Serializable {
    private long fortuneValue;
    private long misfortuneValue;

    public FortuneScene(long fortuneValue, long misfortuneValue) {
        this.fortuneValue = fortuneValue;
        this.misfortuneValue = misfortuneValue;
    }

    public long getFortuneValue() {
        return fortuneValue;
    }

    public long getMisfortuneValue() {
        return misfortuneValue;
    }

    public void setFortuneValue(long fortuneValue) {
        this.fortuneValue = fortuneValue;
    }

    public void setMisfortuneValue(long misfortuneValue) {
        this.misfortuneValue = misfortuneValue;
    }

    @Override
    public String toString() {
        return "FortuneScene{" + "fortuneValue=" + fortuneValue + ", misfortuneValue=" + misfortuneValue + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (int) (this.fortuneValue ^ (this.fortuneValue >>> 32));
        hash = 53 * hash + (int) (this.misfortuneValue ^ (this.misfortuneValue >>> 32));
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
        final FortuneScene other = (FortuneScene) obj;
        if (this.fortuneValue != other.fortuneValue) {
            return false;
        }
        if (this.misfortuneValue != other.misfortuneValue) {
            return false;
        }
        return true;
    }
    
    
    
}
