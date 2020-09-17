/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.vidanec.zavrsnirad;

import hr.vidanec.zavrsnirad.controller.ObradaKnjiga;
import hr.vidanec.zavrsnirad.controller.ObradaOsoba;
import hr.vidanec.zavrsnirad.controller.ObradaPosudbaKnjige;
import hr.vidanec.zavrsnirad.model.Knjiga;
import hr.vidanec.zavrsnirad.model.Osoba;
import hr.vidanec.zavrsnirad.model.PosudbaKnjige;
import hr.vidanec.zavrsnirad.utility.PocetniInsert;
import hr.vidanec.zavrsnirad.utility.ZavrsniRadException;
import hr.vidanec.zavrsnirad.view.Autorizacija;
import hr.vidanec.zavrsnirad.view.Izbornik;

/**
 *
 * @author Ivan
 */
public class Start {
    public static void main(String[] args) {
        
        new Autorizacija().setVisible(true);
//        new Izbornik().setVisible(true);
        
//        PocetniInsert.izvedi();
        
//       Osoba o = new Osoba();
//        
//        ObradaOsoba obradaOsoba = new ObradaOsoba(o);
//        o.setIme("Lovre");
//        o.setPrezime("Kulen");
//       o.setOib("49147132554");
//       o.setBroj_tel("+38597777777");
//        
//        try {
//            obradaOsoba.create();
//        } catch (ZavrsniRadException ex) {
//            System.out.println(ex.getPoruka());
//        }
        
        
        //Knjiga k = new Knjiga();
        
        //ObradaKnjiga obradaKnjiga = new ObradaKnjiga(k);
        //k.setAutor("Nikola Kojo");
        //k.setGodina("1980");
        //k.setNaziv("Valovi");
        
        //try {
        //    obradaKnjiga.create();
        //} catch (ZavrsniRadException e) {
        //    System.out.println(e.getPoruka());
        //}
    }
}
