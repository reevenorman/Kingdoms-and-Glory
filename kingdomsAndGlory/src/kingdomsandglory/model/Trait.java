/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.model;

/**
 *
 * @author piano
 */
public class Trait {
    
    private String diplomatic;
    private String strategic;
    private String charismatic;
    private int army = 0;
    private int wood = 0;
    private int metal = 0;
    private int stone = 0;
    private int cloth = 0;

   public Trait(String strategic, int army, int wood, int metal, int stone, int cloth) {
       this.strategic = strategic;
       this.army = army;
       this.wood = wood;
       this.metal = metal;
       this.stone = stone;
       this.cloth = cloth;
    }
   
      public Trait(String diplomatic, int army, int wood, int metal, int stone, int cloth) {
       this.diplomatic = diplomatic;
       this.army = army;
       this.wood = wood;
       this.metal = metal;
       this.stone = stone;
       this.cloth = cloth;
    }
      
       public Trait(String charismatic, int army, int wood, int metal, int stone, int cloth) {
       this.diplomatic = diplomatic;
       this.army = army;
       this.wood = wood;
       this.metal = metal;
       this.stone = stone;
       this.cloth = cloth;
    }
    
    public String getStrategic() {
        return strategic;
    }

    public void setStrategic(String strategic) {
        this.strategic = strategic;
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
    
    
    
}
