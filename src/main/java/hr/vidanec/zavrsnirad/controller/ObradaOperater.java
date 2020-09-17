/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.vidanec.zavrsnirad.controller;

import hr.vidanec.zavrsnirad.model.Operater;
import hr.vidanec.zavrsnirad.utility.Oib;
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
      kontrolaIme();
      kontrolaPrezime();
      kontrolaOib();
      
    }

    @Override
    protected void kontrolaUpdate() throws ZavrsniRadException {
    
    }

    @Override
    protected void kontrolaDelete() throws ZavrsniRadException {
    
    }

    private void kontrolaIme() throws ZavrsniRadException {
        if(entitet.getIme()==null || entitet.getIme().isEmpty()) {
            throw new ZavrsniRadException("Ime je obavezno");
        }
        
        // Provjera da nije broj
         if(!entitet.getIme().matches("[a-zA-Z]+")){
            throw new ZavrsniRadException("Ime ne moze biti broj");
        }
         
          // Provjera broja znakova
        if(entitet.getIme().length()>30) {
            throw new ZavrsniRadException("Broj znakova ne moze biti veci od 30");
        }
    }

    private void kontrolaPrezime() throws ZavrsniRadException {
          if(entitet.getPrezime()==null || entitet.getPrezime().isEmpty()) {
            throw new ZavrsniRadException("Prezime je obavezno");
        }
        
        // Provjera da nije broj
         if(!entitet.getPrezime().matches("[a-zA-Z]+")){
            throw new ZavrsniRadException("Prezime ne moze biti broj");
        }
         
          // Provjera broja znakova
        if(entitet.getPrezime().length()>30) {
            throw new ZavrsniRadException("Broj znakova ne moze biti veci od 30");
        }
    }

    private void kontrolaOib() throws ZavrsniRadException {
        if(entitet.getOib()==null || entitet.getOib().isEmpty()) {
            throw new ZavrsniRadException("Prezime je obavezno");
        }
        
        if(!Oib.isValjan(entitet.getOib())) {
            throw new ZavrsniRadException("OIB nije valjan");
        }
    }

    
    
}
