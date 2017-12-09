/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.control;

import kingdomsandglory.exceptions.PlayerControlException;
import kingdomsandglory.model.Game;
import static kingdomsandglory.model.TraitEnum.charismatic;
import static kingdomsandglory.model.TraitEnum.diplomatic;
import static kingdomsandglory.model.TraitEnum.strategic;
import kingdomsandglory.view.ActorTraitResultView;

/**
 *
 * @author piano
 */
public class PlayerControl {

    public static int assignActorTrait(int questionOne, int questionTwo, int questionThree, int questionFour, int questionFive) throws PlayerControlException {

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

    public static int addSumToGold(String actorTraitName, int sumOfTraitQuestions) throws PlayerControlException {
        Game game = kingdomsandglory.kingdomsandglory.getCurrentGame();
        if (actorTraitName == null) {
            throw new PlayerControlException("actorTraitName() is null");
        }
        
        if (actorTraitName == "Diplomatic") {
            int gold = game.trait.trait[0].getGold();
            gold = gold + sumOfTraitQuestions;
            game.trait.trait[0].setGold(gold);
            return gold;
        }
        if (actorTraitName == "Strategic") {
            int gold = game.trait.trait[1].getGold();
            gold = gold + sumOfTraitQuestions;
            game.trait.trait[1].setGold(gold);
            return gold;
        }
        if (actorTraitName == "Charismatic") {
            int gold = game.trait.trait[2].getGold();
            gold = gold + sumOfTraitQuestions;
            game.trait.trait[2].setGold(gold);
            return gold;
        } else {
        return -1;
        }
    }
    
    public static void setPlayerTrait(String traitName) {
        Game game = kingdomsandglory.kingdomsandglory.getCurrentGame();
        String listOfTraitName;
        
        int i = -1;
        do {
            i++;
            listOfTraitName = game.trait.trait[i].traitName;
        } while (listOfTraitName != traitName);
        
        game.resourceType[0].setResourceQty(game.trait.trait[i].getCloth());
        game.resourceType[1].setResourceQty(game.trait.trait[i].getWood());
        game.resourceType[2].setResourceQty(game.trait.trait[i].getStone());
        game.resourceType[3].setResourceQty(game.trait.trait[i].getMetal());
        game.resourceType[4].setResourceQty(game.trait.trait[i].getGold());
        game.resourceType[5].setResourceQty(game.trait.trait[i].getArmy());
        
        
    }
}                   
            