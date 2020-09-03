/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.vidanec.zavrsnirad;

import hr.vidanec.zavrsnirad.controller.ObradaOsoba;
import hr.vidanec.zavrsnirad.model.Osoba;
import hr.vidanec.zavrsnirad.utility.PocetniInsert;
import hr.vidanec.zavrsnirad.utility.ZavrsniRadException;

/**
 *
 * @author Ivan
 */
public class Start {
    public static void main(String[] args) {
        //PocetniInsert.izvedi();
        
        Osoba o = new Osoba();
        
        ObradaOsoba obradaOsoba = new ObradaOsoba(o);
        o.setIme("Ivann");
        o.setOib("asdasdasd");
        
        try {
            obradaOsoba.create();
        } catch (ZavrsniRadException ex) {
            System.out.println(ex.getPoruka());
        }
    }
}
