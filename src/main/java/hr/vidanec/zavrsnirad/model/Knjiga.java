/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.vidanec.zavrsnirad.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author Ivan
 */
@Entity
public class Knjiga extends Entitet{
    private String naziv;
    private String autor;
    private String godina;
    
    @ManyToMany(mappedBy = "knjige")
    private List<PosudbaKnjige> posudbaKnjige = new ArrayList<>();

    public List<PosudbaKnjige> getPosudbeKnjiga() {
        return posudbaKnjige;
    }

    public void setPosudbeKnjiga(List<PosudbaKnjige> posudbeKnjiga) {
        this.posudbaKnjige = posudbeKnjiga;
    }

    
    
    

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGodina() {
        return godina;
    }

    public void setGodina(String godina) {
        this.godina = godina;
    }

    @Override
    public String toString() {
        return getNaziv();
    }
    
    
    
}
