/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.vidanec.zavrsnirad.controller;

import hr.vidanec.zavrsnirad.model.Knjiga;
import hr.vidanec.zavrsnirad.utility.ZavrsniRadException;
import java.util.List;

/**
 *
 * @author Ivan
 */
public class ObradaKnjiga extends Obrada<Knjiga>{

    public ObradaKnjiga(Knjiga knjiga) {
        super(knjiga);
    }

    public ObradaKnjiga() {
        super();
    }
    
    @Override
    public List<Knjiga> getPodaci() {
        return session.createQuery("from Knjiga").list();
    }

    
    
    @Override
    protected void kontrolaCreate() throws ZavrsniRadException {
        kontrolaNaziva();
        kontrolaAutora();
        kontrolaGodine();
    }

    @Override
    protected void kontrolaUpdate() throws ZavrsniRadException {
        kontrolaNaziva();
        kontrolaAutora();
        kontrolaGodine();
    }

    @Override
    protected void kontrolaDelete() throws ZavrsniRadException {
        if(entitet.getPosudbaKnjige().size()>0){
            throw new ZavrsniRadException("Knjiga se ne moze obrisati, ima jednu ili vise posudbi");
        }
    }

    protected void kontrolaNaziva() throws ZavrsniRadException{
        if(entitet.getNaziv()==null || entitet.getNaziv().trim().isEmpty()) {
            throw new ZavrsniRadException("Naziv je obavezan");
        }
        
        // Provjera broja znakova
        if(entitet.getNaziv().length()>100) {
            throw new ZavrsniRadException("Broj znakova ne moze biti veci od 100");
        }
    }
    
    protected void kontrolaAutora() throws ZavrsniRadException{
        if(entitet.getAutor()==null || entitet.getAutor().trim().isEmpty()) {
            throw new ZavrsniRadException("Autor je obavezan");
        }
        
        // Provjera broja znakova
        if(entitet.getAutor().length()>50) {
            throw new ZavrsniRadException("Broj znakova ne moze biti veci od 50");
        }
    }
    
    protected  void kontrolaGodine() throws ZavrsniRadException{
        if(entitet.getGodina()==null || entitet.getGodina().trim().isEmpty()) {
            throw new ZavrsniRadException("Godina je obavezna");
        }
    }
    
}
