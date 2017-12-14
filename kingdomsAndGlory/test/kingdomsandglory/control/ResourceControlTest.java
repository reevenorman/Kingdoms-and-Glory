/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.control;

import kingdomsandglory.exceptions.ResourceControlException;
import kingdomsandglory.model.Game;
import kingdomsandglory.model.Resource;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author reeve
 */
public class ResourceControlTest {
    
    public ResourceControlTest() {
    }

    /**
     * Test of totalResources method, of class ResourceControl.
     */
    @Test
    public void testTotalResources() throws ResourceControlException {
        System.out.println("totalResources test 1");
        int[] addition = {1,2,3,4,5,6};
        int expResult = 21;
        int result;
        try {
            result = ResourceControl.totalResources(addition);
            assertEquals(expResult, result);
        } catch (ResourceControlException ex) {
            fail("The test case is a prototype.");
        }
        
        System.out.println("totalResources test 2");
        addition = null;
        expResult = 0;
        try {
            result = ResourceControl.totalResources(addition);
            fail("test 2 failed");
        } catch (ResourceControlException ex) {
            assertTrue(true);
        }
        
    }
    
}
