/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author reeve
 */
public class ActorTrait implements Serializable{
    private String playerTrait;
    private String question;

    public ActorTrait(String playerTrait, String question) {
        this.playerTrait = playerTrait;
        this.question = question;
    }

    public String getPlayerTrait() {
        return playerTrait;
    }

    public String getQuestion() {
        return question;
    }

    public void setPlayerTrait(String playerTrait) {
        this.playerTrait = playerTrait;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "ActorTrait{" + "playerTrait=" + playerTrait + ", question=" + question + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.playerTrait);
        hash = 97 * hash + Objects.hashCode(this.question);
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
        final ActorTrait other = (ActorTrait) obj;
        if (!Objects.equals(this.playerTrait, other.playerTrait)) {
            return false;
        }
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        return true;
    }

    
    
}
