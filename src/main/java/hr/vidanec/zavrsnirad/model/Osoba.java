/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.vidanec.zavrsnirad.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


/**
 *
 * @author Ivan
 */
@Entity
public class Osoba extends Entitet{
    private String ime;
    private String prezime;
    @Column(name="brojTelefona")
    private String broj_tel;
    private String oib;
    
    @OneToMany(mappedBy = "osoba")
    private List<PosudbaKnjige> posudbaKnjige = new ArrayList<>();

    public List<PosudbaKnjige> getPosudbaKnjige() {
        return posudbaKnjige;
    }

    public void setPosudbaKnjige(List<PosudbaKnjige> posudbaKnjige) {
        this.posudbaKnjige = posudbaKnjige;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBroj_tel() {
        return broj_tel;
    }

    public void setBroj_tel(String broj_tel) {
        this.broj_tel = broj_tel;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    @Override
    public String toString() {
        return getIme() +" "+ getPrezime();
    }
    
    public String getImePrezime(){
        return getIme() + " " + getPrezime();
    }
}
