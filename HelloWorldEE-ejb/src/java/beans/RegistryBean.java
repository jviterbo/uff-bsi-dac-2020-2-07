/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;

/**
 *
 * @author viter
 */
@Singleton
@LocalBean
public class RegistryBean {
    
    List arrayConvs;
    
    public RegistryBean(){
        
        arrayConvs = new ArrayList();        
       
    }
    
    public List<String> getMsgs(){
        
        return arrayConvs;
    }
    
    public void saveMsgs(String msg) {
        arrayConvs.add(msg);
    }

}
