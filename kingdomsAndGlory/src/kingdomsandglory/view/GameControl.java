/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.view;

import kingdomsandglory.model.Player;



/**
 *
 * @author reeve
 */
public class GameControl {

    public static Player savePlayer(String playersName) {
        System.out.println("*** savePlayer() called ***");
        return new Player();
    }
    
    
    public GameControl(String name) {
        System.out.println("*** savePlayer() called ***");
    }

}
