/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.vidanec.zavrsnirad.utility;

import com.github.javafaker.Faker;
import hr.vidanec.zavrsnirad.controller.ObradaOperater;
import hr.vidanec.zavrsnirad.model.Knjiga;
import hr.vidanec.zavrsnirad.model.Operater;
import hr.vidanec.zavrsnirad.model.Osoba;
import hr.vidanec.zavrsnirad.model.PosudbaKnjige;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Ivan
 */
public class PocetniInsert {
    
    public static void izvedi() {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Operater operater = new Operater();
        operater.setIme("Ivan");
        operater.setPrezime("Vidanec");
        operater.setEmail("ivid@gmail.com");
        operater.setOib("25983140218");
        operater.setLozinka(BCrypt.hashpw("i", BCrypt.gensalt()));
        
        ObradaOperater oo = new ObradaOperater();
        oo.setEntitet(operater);
        try {
            oo.create();
        } catch (ZavrsniRadException e) {
            e.printStackTrace();
        }
        
        session.beginTransaction();
        Faker faker = new Faker();
        
        String[] oibi = {"90072875564","94185081086","78356615700","95617290491","39595407954","58398328753","59759169850","84219875379","25428070761","25856748748"};
        String[] telefoni = {"+38598576666","0956855666","6655555555555","3859665255665","+3853343333433","09145855555","092555555555","3859685655266","955555566883","3857968665555"};
        Osoba o=null;
        
       
        for(int i=0;i<10;i++) {
            o = new Osoba();
            o.setIme(faker.name().firstName());
            o.setPrezime(faker.name().lastName());
            o.setBroj_tel(telefoni[i]);
            o.setOib(oibi[i]);
            session.save(o);
         
        }
        
        Knjiga knjiga;
        List<Knjiga> knjige = new ArrayList<>();
        for(int i=0;i<10;i++){
            knjiga = new Knjiga();
            knjiga.setNaziv(faker.book().title());
            knjiga.setAutor(faker.book().author());
            knjiga.setGodina(faker.backToTheFuture().date());
            session.save(knjiga);
           
            knjige.add(knjiga);
            
        }
        session.getTransaction().commit();
        
//        session.beginTransaction();
//        
//        PosudbaKnjige pk = new PosudbaKnjige();
//        pk.setDatum_posudbe(new Date());
//        pk.setDatum_povratka(new Date());
//        pk.setKnjige(knjige);
//        pk.setOsoba(o);
//       
//        session.save(pk);
//        
//        session.getTransaction().commit();
//        
      
    }
    
    
}
