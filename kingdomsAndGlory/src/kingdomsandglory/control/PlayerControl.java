/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.control;


import kingdomsandglory.exceptions.PlayerControlException;
import 

/**
 *
 * @author piano
 */
public class PlayerControl {

    public static int assignActorTrait(int questionOne, int questionTwo, int questionThree, int questionFour, int questionFive) {

        if (questionOne > 3) {
            return -6;
        }
        if (questionOne < 1) {
            return -1;
        }
        if (questionTwo > 3) {
            return -7;
        }
        if (questionTwo < 1) {
            return -2;
        }
        if (questionThree > 3) {
            return -8;
        }
        if (questionThree < 1) {
            return -3;
        }
        if (questionFour > 3) {
            return -9;
        }
        if (questionFour < 1) {
            return -4;
        }
        if (questionFive > 3) {
            return -10;
        }
        if (questionFive < 1) {
            return -5;
        }
        double actorTraitEquation = ((questionOne + questionTwo + questionThree + questionFour + questionFive) / 5.0);
        int actorTrait = (int) ((actorTraitEquation + 0.5) / 1);
        return actorTrait;
    }

    public static int sumOfActorTrait(int[] sendInputs) throws PlayerControlException {
        if (sendInputs == null) {
            throw new PlayerControlException("Invalid Input"); 
        }
        int total = 0;
        int j = 0;
        for (int value : sendInputs) {
            total = total + value;
        }
        return total;
    }
   
    /*
    public static int addSumToGold(String actorTraitName) throws PlayerControlException {
        if (actorTraitName == "Diplomatic") {
            diplomatic.gold = diplomatic.gold + sumOfActorTrait;
        }
        if (actorTraitName == "Strategic") {
            strategic.gold = strategic.gold + sumOfActorTrait;
        }
        if (actorTraitName == "Charismatic") {
            charismatic.gold = charismatic.gold + sumOfActorTrait;
        }
*/
    }
