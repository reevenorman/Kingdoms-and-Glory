/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.control;

import kingdomsandglory.exceptions.MapControlException;
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
     * Test of fortuneOutcome method, of class MapControl.
     */
    @Test
    public void testfortuneOutcome() throws MapControlException{
        System.out.println("fortuneOutcome");
        
        System.out.println("test case 1");
        
        int userGambleOption = 1;
        int randResourceAmt = 72;
        int randResourceObj = 2;
        int randChanceAmt = 4;
        String expResult = ("You gained " + randResourceAmt + " pieces of " + randResourceObj + ".");
        String result = MapControl.fortuneOutcome(userGambleOption, randResourceAmt, randResourceObj, randChanceAmt);
        assertEquals(expResult, result);
        
        System.out.println("test case 2");
        
        userGambleOption = -1;
        randResourceAmt = 75;
        randResourceObj = 2;
        randChanceAmt = 4;
        expResult = ("-1");
        result = MapControl.fortuneOutcome(userGambleOption, randResourceAmt, randResourceObj, randChanceAmt);
        assertEquals(expResult, result);
        
        System.out.println("test case 3");
        
        userGambleOption = 2;
        randResourceAmt = 75;
        randResourceObj = 2;
        randChanceAmt = 4;
        expResult = ("-2");
        result = MapControl.fortuneOutcome(userGambleOption, randResourceAmt, randResourceObj, randChanceAmt);
        assertEquals(expResult, result);
        
        System.out.println("test case 4");
        
        userGambleOption = 1;
        randResourceAmt = 101;
        randResourceObj = 2;
        randChanceAmt = 4;
        expResult = ("-3");
        result = MapControl.fortuneOutcome(userGambleOption, randResourceAmt, randResourceObj, randChanceAmt);
        assertEquals(expResult, result);
        
        System.out.println("test case 5");
        
        userGambleOption = 1;
        randResourceAmt = -1;
        randResourceObj = 2;
        randChanceAmt = 4;
        expResult = ("-4");
        result = MapControl.fortuneOutcome(userGambleOption, randResourceAmt, randResourceObj, randChanceAmt);
        assertEquals(expResult, result);
        
        System.out.println("test case 6");
        
        userGambleOption = 1;
        randResourceAmt = 75;
        randResourceObj = 5;
        randChanceAmt = 4;
        expResult = ("-5");
        result = MapControl.fortuneOutcome(userGambleOption, randResourceAmt, randResourceObj, randChanceAmt);
        assertEquals(expResult, result);
        
        System.out.println("test case 7");
        
        userGambleOption = 1;
        randResourceAmt = 75;
        randResourceObj = -1;
        randChanceAmt = 4;
        expResult = ("-6");
        result = MapControl.fortuneOutcome(userGambleOption, randResourceAmt, randResourceObj, randChanceAmt);
        assertEquals(expResult, result);
        
        System.out.println("test case 8");
        
        userGambleOption = 1;
        randResourceAmt = 75;
        randResourceObj = 2;
        randChanceAmt = 7;
        expResult = ("-7");
        result = MapControl.fortuneOutcome(userGambleOption, randResourceAmt, randResourceObj, randChanceAmt);
        assertEquals(expResult, result);
        
        System.out.println("test case 8");
        
        userGambleOption = 1;
        randResourceAmt = 75;
        randResourceObj = 2;
        randChanceAmt = 0;
        expResult = ("-8");
        result = MapControl.fortuneOutcome(userGambleOption, randResourceAmt, randResourceObj, randChanceAmt);
        assertEquals(expResult, result);
        
        System.out.println("test boundary minium");
        
        userGambleOption = 0;
        randResourceAmt = 0;
        randResourceObj = 0;
        randChanceAmt = 1;
        expResult = ("You gained " + (randResourceAmt * .20) + " pieces of " + randResourceObj + ".");
        result = MapControl.fortuneOutcome(userGambleOption, randResourceAmt, randResourceObj, randChanceAmt);
        assertEquals(expResult, result);
        
        System.out.println("test boundary minumum");
        
        userGambleOption = 1;
        randResourceAmt = 100;
        randResourceObj = 4;
        randChanceAmt = 6;
        expResult = ("You gained " + randResourceAmt + " pieces of " + randResourceObj + ".");
        result = MapControl.fortuneOutcome(userGambleOption, randResourceAmt, randResourceObj, randChanceAmt);
        assertEquals(expResult, result);
    }

}
