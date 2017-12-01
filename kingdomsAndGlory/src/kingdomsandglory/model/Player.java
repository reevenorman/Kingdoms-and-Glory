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
public class Player implements Serializable{
    public static String playerName;
    public static Actor actor;

    public Player() {
    }

    public static String getPlayerName() {
        return playerName;
    }

    public static void setPlayerName(String playerName) {
        Player.playerName = playerName;
    }

    public static Actor getActor() {
        return actor;
    }

    public static void setActor(Actor actor) {
        Player.actor = actor;
    }

    @Override
    public String toString() {
        return "Player{" + '}';
    
    
    }
   
}
