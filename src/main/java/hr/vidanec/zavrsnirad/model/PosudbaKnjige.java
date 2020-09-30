/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.vidanec.zavrsnirad.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


/**
 *
 * @author Ivan
 */
@Entity
public class PosudbaKnjige extends Entitet{
    @Column(name="datumPosudbe")
    private Date datum_posudbe;
    
   @Column(name="datumPovratka")
    private Date datum_povratka;
    
    @ManyToOne
    @JoinColumn(name="osoba")
    private Osoba osoba;
    
    @ManyToMany
    @JoinTable(name="posudba",joinColumns=@JoinColumn(name="posudbaKnjige"),inverseJoinColumns=@JoinColumn(name="knjiga") )
    private List<Knjiga> knjige = new ArrayList<>();

    public List<Knjiga> getKnjige() {
        return knjige;
    }

    public void setKnjige(List<Knjiga> knjige) {
        this.knjige = knjige;
    }
            
    public Date getDatum_posudbe() {
        return datum_posudbe;
    }

    public void setDatum_posudbe(Date datum_posudbe) {
        this.datum_posudbe = datum_posudbe;
    }

    public Date getDatum_povratka() {
        return datum_povratka;
    }

    public void setDatum_povratka(Date datum_povratka) {
        this.datum_povratka = datum_povratka;
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }

    @Override
    public String toString() {
        return getOsoba().getImePrezime();
    }

    
}
