/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.control;
import kingdomsandglory.model.Resource;

import java.util.Random;

/**
 *
 * @author piano
 */
public class MapControl {

    public static long battleOutcome(long armyValue, long resourceList, long cityArmyValue, long cityResourceList) {

        if (armyValue > 1000000000) {
            return -1;
        }
        if (armyValue < 0) {
            return -5;
        }
        if (cityArmyValue > 1000000000) {
            return -3;
        }
        if (cityArmyValue < 0) {
            return -7;
        }
        if (resourceList > 1000000000) {
            return -2;
        }
        if (resourceList < 0) {
            return -6;
        }
        if (cityResourceList > 1000000000) {
            return -4;
        }
        if (cityResourceList < 0) {
            return -8;
        }
        if (resourceList == 0 && cityResourceList == 0 && armyValue == 0 && cityArmyValue == 0) {
            return -9;
        }
        double resourceBonus = 1.0;
        double cityResourceBonus = 1.0;
        if (resourceList > cityResourceList) {
            resourceBonus = 1.5;
        }
        if (resourceList < cityResourceList) {
            cityResourceBonus = 1.5;
        }
        double attackValue = armyValue + (resourceList * resourceBonus);
        double cityDefenseValue = cityArmyValue + (cityResourceList * cityResourceBonus);

        if (attackValue >= cityDefenseValue) {
            return 1;
        }
        return 0;
    }
    
    
    
        public static long fortuneOutcome(long armyValue, long resourceList, long cityArmyValue, long cityResourceList) {

        if (armyValue > 1000000000) {
            return -1;
        }
        if (armyValue < 0) {
            return -5;
        }
        if (cityArmyValue > 1000000000) {
            return -3;
        }
        if (cityArmyValue < 0) {
            return -7;
        }
        if (resourceList > 1000000000) {
            return -2;
        }
        if (resourceList < 0) {
            return -6;
        }
        if (cityResourceList > 1000000000) {
            return -4;
        }
        if (cityResourceList < 0) {
            return -8;
        }
        if (resourceList == 0 && cityResourceList == 0 && armyValue == 0 && cityArmyValue == 0) {
            return -9;
        }
        double resourceBonus = 1.0;
        double cityResourceBonus = 1.0;
        if (resourceList > cityResourceList) {
            resourceBonus = 1.5;
        }
        if (resourceList < cityResourceList) {
            cityResourceBonus = 1.5;
        }
        double attackValue = armyValue + (resourceList * resourceBonus);
        double cityDefenseValue = cityArmyValue + (cityResourceList * cityResourceBonus);

        if (attackValue >= cityDefenseValue) {
            return 1;
        }
        return 0;
    }
    
    public static String moveOutcome(int userGambleOption) {
        Resource resource = new Resource();
        double outcome;
        String resultOutcome = "error";
        
                
        if (userGambleOption < 0) {
            return "-1";     
        }
        if (userGambleOption > 1) {
            return "-2";      
        }
        Random rand = new Random();
        int randResourceAmt = rand.nextInt(101) + 1;
        int randResourceObj = rand.nextInt(3) + 0;
        int randChanceAmt = rand.nextInt(7) + 1;
        
        if (userGambleOption == 0) {    
            outcome = randResourceAmt * 0.2;
            resource.resourceType[randResourceObj] = resource.resourceType[randResourceObj] + (int)outcome;
            resultOutcome = ("You gained " + outcome + " pieces of " + randResourceObj + ".");
            return resultOutcome;
        }
        if (userGambleOption == 1) {
            double guarenteedOutcome = randResourceAmt * 0.2;
            if (randChanceAmt >= 3) {
                outcome = randResourceAmt * 0.8;
                resource.resourceType[randResourceObj] = resource.resourceType[randResourceObj] + (int)outcome + (int)guarenteedOutcome;
                resultOutcome = ("You gained " + randResourceAmt + " pieces of " + randResourceObj + ".");
            }
            else {
                outcome = randResourceAmt * 0.8;
                resource.resourceType[randResourceObj] = resource.resourceType[randResourceObj] - (int)outcome + (int)guarenteedOutcome;
                resultOutcome = ("You gained " + randResourceAmt + " pieces of " + randResourceObj + "." 
                    + "But, You were attacked by bandits! And lost, " + outcome + " pieces of " + randResourceObj + ".");
            }
            
        }  
        return resultOutcome;
    }
}
