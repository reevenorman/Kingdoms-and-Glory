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
public class ResourceControlException extends Exception {

    public ResourceControlException() {
    }

    public ResourceControlException(String string) {
        super(string);
    }

    public ResourceControlException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ResourceControlException(Throwable thrwbl) {
        super(thrwbl);
    }

    public ResourceControlException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
