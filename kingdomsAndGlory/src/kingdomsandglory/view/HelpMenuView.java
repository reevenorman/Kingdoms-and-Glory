/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.view;

import java.util.Scanner;

/**
 *
 * @author piano
 */
public class HelpMenuView extends View{

    @Override
    public String[] getInputs() {
        String[] input = new String[1];
        String userInput;
        Boolean valid = false;

        String helpMenuDisplay;

        helpMenuDisplay = " A - Learn About Army \n"
                + " R - Learn About Resources \n"
                + " M - Learn About Map and Movement \n"
                + " C - Learn About Waging War and Conquering Cities \n"
                + " B - Go Back \n";

        this.console.println(helpMenuDisplay);

        String value = this.getInput("Please choose a menu Item");
        String[] inputs = new String[1];
        inputs[0] = value;
        return inputs;   

    }

    @Override
    public boolean doAction(String[] inputs) {
        char menuItem;
        menuItem = inputs[0].toUpperCase().charAt(0);

        switch (menuItem) {
            case 'A':
                armyInfoView();
                break;
            case 'R':
                resourceInfoView();
                break;
            case 'M':
                mapAndMovementInfoView();
                break;
            case 'C':
                conquerCitiesInfoView();
                break;
            case 'B':
                return true;

            case 'Q':
                return false;
            default:
                ErrorView.display(this.getClass().getName(),"Invalid Input");
        }
        return true;
    }

    private void armyInfoView() {
        this.console.println("***********************************************************************************************"
                + "* Manage Army                                                                                 *\n"
                + "* The following menu will be displayed:                                                       *\n"
                + "*                                                                                             *\n"
                + "* G - Gain Recruits                                                                           *\n"
                + "* S - Sell Army                                                                               *\n"
                + "* B - Go Back                                                                                 *\n"
                + "*                                                                                             *\n"
                + "*Also displayed with this menu will be a list of the different types of troops/soldiers       *\n"
                + "*currently in the user’s army and the amount of money that is available as                    *\n"
                + "*a resource. Displayed with the menu is a cost of recruits. The player enters                 *\n"
                + "*the letter representing the command they would like to give the computer. If an              *\n"
                + "*invalid key is attempted, the end user is requested to enter a valid command and             *\n"
                + "*the menu is redisplayed. If the user enters a valid command, depending on the command,       *\n"
                + "*the program will show the following for the user. If the user requests more army, the        *\n"
                + "*program will then ask how many of which type of soldier. The user then enters the amount     *\n"
                + "*thus decreasing money and increasing that aspect of the army. If the user types an invalid   *\n"
                + "*amount in due to the fact that there is not enough money, the message displayed will say,    *\n"
                + "*Not enough money.” After the appropriate message is displayed to the user the program then   *\n"
                + "*reruns the Manage Army Menu. Under the command to sell recruits, the user will be asked how  *\n"
                + "*many men they would like to sell of which type. Once the sale is final, the adjusted numbers *\n"
                + "*will be shown in the list of army numbers and money numbers.                                 *\n"
                 +"***********************************************************************************************");
    }

    private void resourceInfoView() {
        this.console.println("*********************************************************************************************"
                + "* Manage Resources                                                                          *\n"
                + "* The following menu will be displayed:                                                     *\n"
                + "*                                                                                           *\n"
                + "* B - Buy resource                                                                          *\n"
                + "* S - Sell resource                                                                         *\n"
                + "* A - Go Back                                                                               *\n"
                + "*                                                                                           *\n"
                + "* On the manage resource menu there will be an option to buy and sell your resources. You   *\n"
                + "* Will also be able to see a list of resources and how many of each you have. The resources *\n"
                + "* that you will be able to obtain in this game will be Wood, Stone, Metal, and Cloth. Your  *\n"
                + "* money will also be displayed here. If you choose B and buy a resource you will be able to *\n"
                + "* use your money to buy as much as you can afford of whatever resource you choose. If you   *\n"
                + "* choose S and decide to sell your resources you will lose as much of whatever resource you *\n"
                + "* decide to sell but will gain money. You can use this menu to gain more money through      *\n"
                + "* selling your resources or you can use this menu to gain more resources by spending your   *\n"
                + "* money. If you enter an incorrect character, the game will tell you that is an invalid     *\n"
                + "* character and will be asked to try again.                                                 *\n"
                + "*********************************************************************************************");
    }

    private void mapAndMovementInfoView() {
        this.console.println("*********************************************************************************************"
                + "* View Map Menu                                                                                           *\n"
                + "* The following menu will be displayed:                                                                   *\n"
                + "*                                                                                                         *\n"
                + "* V - View Territory                                                                                      *\n"
                + "* C - Attack Territory                                                                                    *\n"
                + "* X - Move                                                                                                *\n"
                + "* B - Go Back                                                                                             *\n"
                + "*                                                                                                         *\n"
                + "* The player enters the letter representing the command they would like to give the computer.             *\n"
                + "*If an invalid key is attempted, the end user is requested to enter a valid command the and the           *\n"
                + "*menu is redisplayed. If the user enters a valid command, depending on the command, the program will      *\n"
                + "*then redirect the user to the next menu. Displayed with this menu will be a map of the surrounding area. *\n"
                + "*Cities owned by opposing force will be marked with an ‘X’. Cities that are under your control will be    *\n"
                + "*marked with an ’Z’. other parts of the map will be a ‘?’ to show that we don’t know what is within that  *\n"
                + "*specific area. It will then give you the option B to go Back to the Main Menu.                           *\n"
                + "*********************************************************************************************");
    }

    private void conquerCitiesInfoView() {
        this.console.println("*********************************************************************************************"
                + "* Manage Army                                                                               *\n" 
                + "* The following menu will be displayed:                                                     *\n" 
                + "*                                                                                           *\n" 
                + "* G - Gain Recruits                                                                         *\n"
                + "* S - Sell Army                                                                             *\n" 
                + "* B - Go Back                                                                               *\n" 
                + "*                                                                                           *\n" 
                + "* Also displayed with this menu will be a list of the different types of troops/soldiers    *\n"
                + "* currently in the user’s army and the amount of money that is available as a resource.     *\n"
                + "* Displayed with the menu is a cost of recruits. The player enters the letter representing  *\n"
                + "* the command they would like to give the computer. If an invalid key is attempted, the end *\n"
                + "* user is requested to enter a valid command and the menu is redisplayed. If the user enters*\n"
                + "* a valid command, depending on the command, the program will show the following for the    *\n"
                + "* user. If the user requests more army, the program will then ask how many of which type of *\n"
                + "* soldier. The user then enters the amount thus decreasing money and increasing that aspect *\n"
                + "* of the army. If the user types an invalid amount in due to the fact that there is not     *\n"
                + "* enough money, the message displayed will say, “Not enough money.” After the appropriate   *\n"
                + "* message is displayed to the user the program then reruns the Manage Army Menu. Under the  *\n"
                + "* command to sell recruits, the user will be asked how many men they would like to sell of  *\n"
                + "* which type. Once the sale is final, the adjusted numbers will be shown in the list of army*\n"
                + "* numbers and money numbers.                                                                *\n");
    }

}
