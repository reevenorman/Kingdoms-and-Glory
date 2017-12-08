/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.exceptions;

/**
 *
 * @author piano
 */
public class ArmyControlException extends Exception {

    public ArmyControlException() {
    }

    public ArmyControlException(String string) {
        super(string);
    }

    public ArmyControlException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ArmyControlException(Throwable thrwbl) {
        super(thrwbl);
    }

    public ArmyControlException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
