/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.model;

import java.util.Objects;

/**
 *
 * @author piano
 */
public class Trait {
    
    public Trait[] trait;
    public String traitName;
    public int army;
    public int cloth;
    public int wood;
    public int stone;
    public int metal;
    public int gold;

    public Trait(String traitName, int army, int cloth, int wood, int stone, int metal, int gold) {
    this.traitName = traitName;
    this.army = army;
    this.cloth = cloth;
    this.wood = wood;
    this.stone = stone;
    this.metal = metal;
    this.gold = gold;
    }

    public Trait() {
        this.traitName = "";
        this.army = 0;
        this.cloth = 0;
        this.wood = 0;
        this.stone = 0;
        this.metal = 0;
        this.gold = 0;
    }

    public Trait[] getTrait() {
        return trait;
    }

    public void setTrait(Trait[] trait) {
        this.trait = trait;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    
    
    public String getTraitName() {
        return traitName;
    }

    public void setTraitName(String traitName) {
        this.traitName = traitName;
    }

    public int getArmy() {
        return army;
    }

    public void setArmy(int army) {
        this.army = army;
    }

    public int getWood() {
        return wood;
    }

    public void setWood(int wood) {
        this.wood = wood;
    }

    public int getMetal() {
        return metal;
    }

    public void setMetal(int metal) {
        this.metal = metal;
    }

    public int getStone() {
        return stone;
    }

    public void setStone(int stone) {
        this.stone = stone;
    }

    public int getCloth() {
        return cloth;
    }

    public void setCloth(int cloth) {
        this.cloth = cloth;
    }

    @Override
    public String toString() {
        return "Trait{" + "traitName=" + traitName + ", army=" + army + ", wood=" + wood + ", metal=" + metal + ", stone=" + stone + ", cloth=" + cloth + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.traitName);
        hash = 97 * hash + this.army;
        hash = 97 * hash + this.wood;
        hash = 97 * hash + this.metal;
        hash = 97 * hash + this.stone;
        hash = 97 * hash + this.cloth;
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
        final Trait other = (Trait) obj;
        if (this.army != other.army) {
            return false;
        }
        if (this.wood != other.wood) {
            return false;
        }
        if (this.metal != other.metal) {
            return false;
        }
        if (this.stone != other.stone) {
            return false;
        }
        if (this.cloth != other.cloth) {
            return false;
        }
        if (!Objects.equals(this.traitName, other.traitName)) {
            return false;
        }
        return true;
    }

    
    
}
