/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.vidanec.zavrsnirad.controller;

import hr.vidanec.zavrsnirad.model.Osoba;
import hr.vidanec.zavrsnirad.utility.Oib;
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

    public ObradaOsoba() {
       super();
    }
    
    @Override
    public List<Osoba> getPodaci() {
        return session.createQuery("from Osoba").list();
    }
    
    public List<Osoba> getPodaci(String uvjet) {
        return session.createQuery("from Osoba o "
                + " where concat(o.ime, ' ', o.prezime, ' ', o.oib) "
                + " like :uvjet ")
                .setParameter("uvjet", "%"+uvjet+"%")
                .list();
    }

    @Override
    protected void kontrolaCreate() throws ZavrsniRadException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaOibBaza();
        kontrolaOib();
        kontrolaBrojaTelefona();
    }

    @Override
    protected void kontrolaUpdate() throws ZavrsniRadException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaOib();
        kontrolaOibBazaPromjeni();
        kontrolaBrojaTelefona();
    }

    @Override
    protected void kontrolaDelete() throws ZavrsniRadException {
        if(entitet.getPosudbaKnjige().size()>0){
            throw new ZavrsniRadException("Osoba se ne moze obrisati, ima jednu ili vise posudbi knjiga");
        }
    }

    protected void kontrolaIme() throws ZavrsniRadException {
        kontrolaNull(entitet.getIme(), "Ime nije definirano");
        
        // Provjera da nije prazan
        if(entitet.getIme().trim().isEmpty()) {
            throw new ZavrsniRadException("Ime nije uneseno!");
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
    
    protected void kontrolaPrezime() throws ZavrsniRadException {
        kontrolaNull(entitet.getPrezime(), "Prezime nije definirano");
           // Provjera da nije prazan
        if(entitet.getPrezime().trim().isEmpty()) {
            throw new ZavrsniRadException("Prezime nije uneseno!");
        }
        // Provjera da nije broj
         if(!entitet.getPrezime().matches("[a-zA-Z]+")){
            throw new ZavrsniRadException("Prezime ne moze biti broj");
        }
        
        // Provjera broja znakova
        if(entitet.getPrezime().length()>50) {
            throw new ZavrsniRadException("Broj znakova ne moze biti veci od 50");
        }
    }
    
    protected void kontrolaBrojaTelefona() throws ZavrsniRadException {
        if(entitet.getBroj_tel()==null || entitet.getBroj_tel().isEmpty()) {
            throw new ZavrsniRadException("Broj telefona je obavezan");
        }
    }

    protected void kontrolaOib() throws ZavrsniRadException {
        kontrolaNull(entitet.getOib(), "Oib nije definiran");
           // Provjera da nije prazan
        if(entitet.getOib().isEmpty()) {
            throw new ZavrsniRadException("Oib nije unesen!");
        }
        
        if(!Oib.isValjan(entitet.getOib())) {
            throw new ZavrsniRadException("OIB nije valjan");
        }
    }
    
    protected void kontrolaNull(Object o, String poruka) throws ZavrsniRadException{
        if(o==null) {
            throw new ZavrsniRadException(poruka);
        }
    }

    private void kontrolaOibBaza() throws ZavrsniRadException {
        List<Osoba> lista = session.createQuery(""
            + " from Osoba o "
            + " where o.oib=:oib "
            )
            .setParameter("oib", entitet.getOib())
            .list();
        if(lista.size()>0){
            throw new ZavrsniRadException("Oib je vec dodijeljen osobi " + lista.get(0).getImePrezime());
        }
    }

    private void kontrolaOibBazaPromjeni() throws ZavrsniRadException {
         List<Osoba> lista = session.createQuery(""
            + " from Osoba o "
            + " where o.oib=:oib and o.id!=:id"
            )
            .setParameter("oib", entitet.getOib())
            .setParameter("id", entitet.getId())
            .list();
        if(lista.size()>0){
            throw new ZavrsniRadException("Oib je vec dodijeljen osobi " + lista.get(0).getImePrezime());
        }
    }
    
    
    
}
