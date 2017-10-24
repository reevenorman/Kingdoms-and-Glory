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
public class PlayerControlTest {
    
    public PlayerControlTest() {
    }

    /**
     * Test of assignActorTrait method, of class PlayerControl.
     */
    @Test
    public void testAssignActorTrait() {
        System.out.println("assignActorTrait");
        
        System.out.println("test case 1");
                
        long questionOne = 1;
        long questionTwo = 2;
        long questionThree = 3;
        long questionFour = 2;
        long questionFive = 1;
        long expResult = 2;
        long result = PlayerControl.assignActorTrait(questionOne, questionTwo, questionThree, questionFour, questionFive);
        assertEquals(expResult, result);
        
        System.out.println("test case 2");
                
        questionOne = 0;
        questionTwo = 1;
        questionThree = 2;
        questionFour = 3;
        questionFive = 2;
        expResult = -1;
        result = PlayerControl.assignActorTrait(questionOne, questionTwo, questionThree, questionFour, questionFive);
        assertEquals(expResult, result);
        
        System.out.println("test case 3");
                
        questionOne = 1;
        questionTwo = 0;
        questionThree = 3;
        questionFour = 2;
        questionFive = 1;
        expResult = -2;
        result = PlayerControl.assignActorTrait(questionOne, questionTwo, questionThree, questionFour, questionFive);
        assertEquals(expResult, result);
        
        System.out.println("test case 4");
                
        questionOne = 1;
        questionTwo = 2;
        questionThree = 0;
        questionFour = 2;
        questionFive = 1;
        expResult = -3;
        result = PlayerControl.assignActorTrait(questionOne, questionTwo, questionThree, questionFour, questionFive);
        assertEquals(expResult, result);
        
        System.out.println("test case 5");
                
        questionOne = 2;
        questionTwo = 1;
        questionThree = 2;
        questionFour = 0;
        questionFive = 3;
        expResult = -4;
        result = PlayerControl.assignActorTrait(questionOne, questionTwo, questionThree, questionFour, questionFive);
        assertEquals(expResult, result);
        
        System.out.println("test case 6");
                
        questionOne = 3;
        questionTwo = 2;
        questionThree = 2;
        questionFour = 1;
        questionFive = 0;
        expResult = -5;
        result = PlayerControl.assignActorTrait(questionOne, questionTwo, questionThree, questionFour, questionFive);
        assertEquals(expResult, result);
        
        System.out.println("test case 7");
                
        questionOne = 4;
        questionTwo = 2;
        questionThree = 3;
        questionFour = 2;
        questionFive = 2;
        expResult = -6;
        result = PlayerControl.assignActorTrait(questionOne, questionTwo, questionThree, questionFour, questionFive);
        assertEquals(expResult, result);
        
        System.out.println("test case 8");
                
        questionOne = 2;
        questionTwo = 4;
        questionThree = 3;
        questionFour = 2;
        questionFive = 1;
        expResult = -7;
        result = PlayerControl.assignActorTrait(questionOne, questionTwo, questionThree, questionFour, questionFive);
        assertEquals(expResult, result);
        
        System.out.println("test case 9");
                
        questionOne = 3;
        questionTwo = 2;
        questionThree = 4;
        questionFour = 1;
        questionFive = 3;
        expResult = -8;
        result = PlayerControl.assignActorTrait(questionOne, questionTwo, questionThree, questionFour, questionFive);
        assertEquals(expResult, result);
        
        System.out.println("test case 10");
                
        questionOne = 3;
        questionTwo = 1;
        questionThree = 2;
        questionFour = 4;
        questionFive = 2;
        expResult = -9;
        result = PlayerControl.assignActorTrait(questionOne, questionTwo, questionThree, questionFour, questionFive);
        assertEquals(expResult, result);
        
        System.out.println("test case 11");
                
        questionOne = 3;
        questionTwo = 2;
        questionThree = 3;
        questionFour = 2;
        questionFive = 4;
        expResult = -10;
        result = PlayerControl.assignActorTrait(questionOne, questionTwo, questionThree, questionFour, questionFive);
        assertEquals(expResult, result);
        
        System.out.println("test case boundary 1");
                
        questionOne = 1;
        questionTwo = 1;
        questionThree = 1;
        questionFour = 1;
        questionFive = 1;
        expResult = 1;
        result = PlayerControl.assignActorTrait(questionOne, questionTwo, questionThree, questionFour, questionFive);
        assertEquals(expResult, result);
        
        System.out.println("test case boundary 2");
                
        questionOne = 3;
        questionTwo = 3;
        questionThree = 3;
        questionFour = 3;
        questionFive = 3;
        expResult = 3;
        result = PlayerControl.assignActorTrait(questionOne, questionTwo, questionThree, questionFour, questionFive);
        assertEquals(expResult, result);
    }
    
}
