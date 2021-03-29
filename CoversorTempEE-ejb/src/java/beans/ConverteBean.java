/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Timestamp;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author viter
 */
@Stateless
@LocalBean
public class ConverteBean {
    
    public ConverteBean() {
    }
    
    public double cToF(double tempIn) {
        
        double tempOut = (9.0/5.0)*tempIn + 32.0;
                
    	return tempOut;
    }

}
