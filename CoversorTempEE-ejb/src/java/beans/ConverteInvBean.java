/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author viter
 */
@Stateless
@LocalBean
public class ConverteInvBean {
    
    public ConverteInvBean() {
    }
    
    public double fToC(double tempIn) {
        
        double tempOut = (5.0/9.0)*(tempIn - 32.0);
                
    	return tempOut;
    }

}
