/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;

/**
 *
 * @author viter
 */
@Stateful
@LocalBean
public class ListaConversoesBean {
    
    List arrayConvs;

    
    public ListaConversoesBean(){
        
        arrayConvs = new ArrayList();        
       
    }
    
    public List<String> getConvs(){
        return arrayConvs;
    }
    
    public void saveConv(String conv) {
        arrayConvs.add(conv);
    }

}
