/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Singleton;
import javax.ejb.LocalBean;

/**
 *
 * @author viter
 */
@Singleton
@LocalBean
public class ContaCoversionsBean {
    
    int contagem;

    public ContaCoversionsBean(){
        contagem = 0;        
    }
    
    public void incContagem() {
        contagem++;
    }
    
    public int getContagem() {
        return contagem;
    }
}
