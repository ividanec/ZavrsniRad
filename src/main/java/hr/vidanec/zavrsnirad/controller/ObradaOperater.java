/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.vidanec.zavrsnirad.controller;

import hr.vidanec.zavrsnirad.model.Operater;
import hr.vidanec.zavrsnirad.utility.ZavrsniRadException;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Ivan
 */
public class ObradaOperater extends Obrada<Operater>{

    public Operater autoriziraj(String email, char[] lozinka){
        Operater operater = (Operater) session.createQuery(
                " from Operater o where o.email=:email")
                .setParameter("email", email).getSingleResult();
        
        if(operater==null){
            return null;
        }
        
        return BCrypt.checkpw(new String(lozinka), operater.getLozinka()) 
                ? operater : null;
    }
    
     
    @Override
    public List<Operater> getPodaci() {
        return session.createQuery("from Operater").list();
    }
    
    @Override
    protected void kontrolaCreate() throws ZavrsniRadException {
      
    }

    @Override
    protected void kontrolaUpdate() throws ZavrsniRadException {
    
    }

    @Override
    protected void kontrolaDelete() throws ZavrsniRadException {
    
    }
    
}
