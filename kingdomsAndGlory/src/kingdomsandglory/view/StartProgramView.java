/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.view;

import java.util.Scanner;
import kingdomsandglory.model.Player;
import kingdomsandglory.KingdomsAndGlory;

/**
 *
 * @author piano
 */
public class StartProgramView extends View {

        @Override
        public String[] getInputs() {
            String welcomeBanner;
            welcomeBanner = ("************************************************************************************\n" 
                        + "*                           Welcome to Kindoms and Glory!                          *\n"
                        + "* Kingdoms and Glory is a text based role playing game. In this game you take on   *\n"
                        + "* the role of King, and you decide what kind of king you’ll be. Your kingdom,      *\n"
                        + "* known as ZENOBIA, is under threat. An enemy kingdom known as the RUFFIANS has    *\n"
                        + "* invaded your land and stolen many of your cities. Due to the loss of these       *\n"
                        + "* cities and their land, your resources are now limited. You have one mission and  *\n"
                        + "* one mission only: take back your lost cities. As the king of these lost cities,  *\n"
                        + "* you know their strong points as well as their weaknesses. You must gather        *\n"
                        + "* resources from the land that you have left in order to exploit the weaknesses of *\n"
                        + "* the cities and take them back from your enemies.                                 *\n"
/*                        + "*                                                                                  *\n" 
                        + "* The kingdom of Zenobia has been a place of peace and prosperity for over 100     *\n"
                        + "* years, thanks to you and your fathers before you. Within the kingdom there are   *\n"
                        + "* many cities, each with distinguishing characteristics. In the last several       *\n"
                        + "* months, tensions between your kingdom and the Ruffians has been growing. The     *\n"
                        + "* Ruffians, known for stealing from others for their own gain, have been pillaging *\n"
                        + "* and plundering the outskirt cities. Foolishly believing that they had a small    *\n"
                        + "* force, you only fortified those cities with a small amount of men.               *\n"
                        + "*                                                                                  *\n"
                        + "* In one fateful night, the unthinkable happened. The Ruffians decided to attack   *\n"
                        + "* Zenobia with their full force. Zenobia, being a peaceful land with few           *\n"
                        + "* fortifications, was not prepared for such an attack. As a result, the Ruffians   *\n"
                        + "* overtook five cities: Pacem, Felicitatem, Genus, Pulchram and Visum. Their       *\n"
                        + "* resources have been seized and the occupants have been taken as prisoners of     *\n"
                        + "* war. You may not have been prepared for the attack, but you have several         *\n"
                        + "* advantages to aid you in taking back your lost cities. First, you know your      *\n"
                        + "* land. You know the strengths and weaknesses of each city. Second, you still have *\n"
                        + "* resources from your remaining cities. They won’t be enough to take them all, but *\n"
                        + "* by searching the rest of your land and collecting resources, you should be able  *\n"
                        + "* to take back all of your cities and free your captive citizens. How you move,    *\n"
                        + "* attack and build your resources is up to you, King of Zenobia.                   *\n"
 */                     + "************************************************************************************");
                  
            System.out.println(welcomeBanner);
        
            String value = this.getInput("Please Enter Your Name");
            String[] inputs = new String[1];
            inputs[0] = value;
            return inputs; 

    }

    @Override
    public boolean doAction(String[] inputs) {
        String playersName = inputs[0];
        Player player = new Player();
        
        player.setPlayerName(playersName);
        
        KingdomsAndGlory.setPlayer(player);

        
        if (player == null){
            System.out.println("Could not create the player. \n"
                    + "Enter a different name.");
            return false;
        }
        System.out.println("========================================\n"
                        + "Welcome to the game, " + playersName + "!\n"
                        + "We hope you have a lot of fun!\n"
                        + "========================================\n");
        
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.display();
        
    
                
        
        System.out.println("**** doActionCalled() called ***");
        System.out.println("**** \tinputs = " + inputs[0] + "    ***");
        
        return true;
    }
}
