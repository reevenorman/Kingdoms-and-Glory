/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author piano
 */
public class MapControlTest {
    
    public MapControlTest() {
    }

    /**
     * Test of battleOutcome method, of class MapControl.
     */
    @Test
    public void testBattleOutcome() {
        System.out.println("battleOutcome");
        
        System.out.println("test case 1");
        
        long armyValue = 100;
        long resourceList = 100;
        long cityArmyValue = 95;
        long cityResourceList = 95;
        long expResult = 1;
        long result = MapControl.battleOutcome(armyValue, resourceList, cityArmyValue, cityResourceList);
        assertEquals(expResult, result);
        
        System.out.println("test case 2");
        
        armyValue = 1000000001;
        resourceList = 100;
        cityArmyValue = 100;
        cityResourceList = 100;
        expResult = -1;
        result = MapControl.battleOutcome(armyValue, resourceList, cityArmyValue, cityResourceList);
        assertEquals(expResult, result);
        
        System.out.println("test case 3");
        
        armyValue = 100;
        resourceList = 1000000001;
        cityArmyValue = 100;
        cityResourceList = 100;
        expResult = -2;
        result = MapControl.battleOutcome(armyValue, resourceList, cityArmyValue, cityResourceList);
        assertEquals(expResult, result);
        
        System.out.println("test case 4");
        
        armyValue = 100;
        resourceList = 100;
        cityArmyValue = 1000000001;
        cityResourceList = 100;
        expResult = -3;
        result = MapControl.battleOutcome(armyValue, resourceList, cityArmyValue, cityResourceList);
        assertEquals(expResult, result);
        
        System.out.println("test case 5");
        
        armyValue = 100;
        resourceList = 100;
        cityArmyValue = 100;
        cityResourceList = 1000000001;
        expResult = -4;
        result = MapControl.battleOutcome(armyValue, resourceList, cityArmyValue, cityResourceList);
        assertEquals(expResult, result);
        
        System.out.println("test case 6");
        
        armyValue = -1;
        resourceList = 100;
        cityArmyValue = 100;
        cityResourceList = 100;
        expResult = -5;
        result = MapControl.battleOutcome(armyValue, resourceList, cityArmyValue, cityResourceList);
        assertEquals(expResult, result);
        
        System.out.println("test case 7");
        
        armyValue = 100;
        resourceList = -1;
        cityArmyValue = 100;
        cityResourceList = 100;
        expResult = -6;
        result = MapControl.battleOutcome(armyValue, resourceList, cityArmyValue, cityResourceList);
        assertEquals(expResult, result);
        
        System.out.println("test case 8");
        
        armyValue = 100;
        resourceList = 100;
        cityArmyValue = -1;
        cityResourceList = 100;
        expResult = -7;
        result = MapControl.battleOutcome(armyValue, resourceList, cityArmyValue, cityResourceList);
        assertEquals(expResult, result);
        
        System.out.println("test case 9");
        
        armyValue = 100;
        resourceList = 100;
        cityArmyValue = 100;
        cityResourceList = -1;
        expResult = -8;
        result = MapControl.battleOutcome(armyValue, resourceList, cityArmyValue, cityResourceList);
        assertEquals(expResult, result);
        
        System.out.println("test case 10");
        
        armyValue = 0;
        resourceList = 0;
        cityArmyValue = 0;
        cityResourceList = 0;
        expResult = -9;
        result = MapControl.battleOutcome(armyValue, resourceList, cityArmyValue, cityResourceList);
        assertEquals(expResult, result);
        
        System.out.println("test case boundary 1");
        
        armyValue = 1;
        resourceList = 1;
        cityArmyValue = 1;
        cityResourceList = 1;
        expResult = 1;
        result = MapControl.battleOutcome(armyValue, resourceList, cityArmyValue, cityResourceList);
        assertEquals(expResult, result);
        
        System.out.println("test case boundary 2");
        
        armyValue = 1000000000;
        resourceList = 1000000000;
        cityArmyValue = 1000000000;
        cityResourceList = 1000000000;
        expResult = 1;
        result = MapControl.battleOutcome(armyValue, resourceList, cityArmyValue, cityResourceList);
        assertEquals(expResult, result);
    }
    
}
