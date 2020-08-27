/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.vidanec.zavrsnirad.model;

import javax.persistence.Entity;


/**
 *
 * @author Ivan
 */
@Entity
public class Osoba extends Entitet{
    private String ime;
    private String prezime;
    private String broj_tel;
    private String oib;

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
    
    
}
