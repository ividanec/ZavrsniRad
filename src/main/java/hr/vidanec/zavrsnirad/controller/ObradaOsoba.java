/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.vidanec.zavrsnirad.controller;

import hr.vidanec.zavrsnirad.model.Osoba;
import hr.vidanec.zavrsnirad.utility.ZavrsniRadException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Ivan
 */
public class ObradaOsoba extends Obrada<Osoba>{

    public ObradaOsoba(Osoba osoba) {
        super(osoba);
    }

    //public ObradaOsoba() {
    //    super();
    //}
    
    public List<Osoba> getPodaci() {
        return session.createQuery("from Osoba").list();
    }

    @Override
    protected void kontrolaCreate() throws ZavrsniRadException {
        kontrolaIme();
    }

    @Override
    protected void kontrolaUpdate() throws ZavrsniRadException {
    
    }

    @Override
    protected void kontrolaDelete() throws ZavrsniRadException {
    
    }

    private void kontrolaIme() throws ZavrsniRadException {
        kontrolaNull(entitet.getIme(), "Ime nije definirano");
        
        // Provjera da nije prazan
        if(entitet.getIme().isEmpty()) {
            throw new ZavrsniRadException("Naziv nije unesen!");
        }
        // Provjera da nije broj
        boolean broj=false;
        try {
            new BigDecimal(entitet.getIme());
            broj=true;
        } catch (Exception e) {
        }
        if(broj) {
            throw new ZavrsniRadException("Naziv ne moze biti broj");
        }
        
        // Provjera broja znakova
        if(entitet.getIme().length()>30) {
            throw new ZavrsniRadException("Broj znakova ne moze biti veci od 30");
        }
    }
    
    private void kontrolaPrezime() throws ZavrsniRadException {
        kontrolaNull(entitet.getPrezime(), "Prezime nije definirano");
           // Provjera da nije prazan
        if(entitet.getPrezime().isEmpty()) {
            throw new ZavrsniRadException("Prezime nije uneseno!");
        }
        // Provjera da nije broj
        boolean broj=false;
        try {
            new BigDecimal(entitet.getPrezime());
            broj=true;
        } catch (Exception e) {
        }
        if(broj) {
            throw new ZavrsniRadException("Naziv ne moze biti broj");
        }
        
        // Provjera broja znakova
        if(entitet.getPrezime().length()>50) {
            throw new ZavrsniRadException("Broj znakova ne moze biti veci od 50");
        }
    }
    
    private void kontrolaBrojaTelefona() throws ZavrsniRadException {
        
    }

    private void kontrolaOib() throws ZavrsniRadException {
        kontrolaNull(entitet.getOib(), "Oib nije definiran");
           // Provjera da nije prazan
        if(entitet.getOib().isEmpty()) {
            throw new ZavrsniRadException("Oib nije unesen!");
        }
        
   
        // Provjera broja znakova
        if(entitet.getOib().length()>11 && entitet.getOib().length()<11) {
            throw new ZavrsniRadException("Broj znakova mora biti 11");
        }
    }
    
    private void kontrolaNull(Object o, String poruka) throws ZavrsniRadException{
        if(o==null) {
            throw new ZavrsniRadException(poruka);
        }
    }
    
}
