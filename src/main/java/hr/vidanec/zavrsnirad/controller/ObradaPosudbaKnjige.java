/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.vidanec.zavrsnirad.controller;

import hr.vidanec.zavrsnirad.model.PosudbaKnjige;
import hr.vidanec.zavrsnirad.utility.ZavrsniRadException;
import java.util.List;

/**
 *
 * @author Ivan
 */
public class ObradaPosudbaKnjige extends Obrada<PosudbaKnjige>{

    public ObradaPosudbaKnjige(PosudbaKnjige posudbaKnjige) {
        super(posudbaKnjige);
    }

    public ObradaPosudbaKnjige() {
        super();
    }

    
    @Override
    public List<PosudbaKnjige> getPodaci() {
      return session.createQuery("from PosudbaKnjige").list();
    }
    
    
    @Override
    protected void kontrolaCreate() throws ZavrsniRadException {
     kontrolaDatumaPosudbe();
    }

    @Override
    protected void kontrolaUpdate() throws ZavrsniRadException {
    
    }

    @Override
    protected void kontrolaDelete() throws ZavrsniRadException {
        if(entitet.getKnjige().size()>0){
            throw new ZavrsniRadException("Posudba knjige se ne moze obrisati,osoba ima jednu ili vise posudbi knjiga");
        }
    }
    
    protected void kontrolaDatumaPosudbe() throws ZavrsniRadException {
        if(entitet.getDatum_posudbe()==null) {
            throw new ZavrsniRadException("Datum nije definiran");
        }
        
    }
    
    protected void kontrolaDatumaPovratka() throws ZavrsniRadException {
        
    }
    
}
