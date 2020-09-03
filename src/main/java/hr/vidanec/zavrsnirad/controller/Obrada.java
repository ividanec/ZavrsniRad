/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.vidanec.zavrsnirad.controller;

import hr.vidanec.zavrsnirad.utility.HibernateUtil;
import hr.vidanec.zavrsnirad.utility.ZavrsniRadException;
import org.hibernate.Session;

/**
 *
 * @author Ivan
 */
public abstract class Obrada<T> {
    
    protected T entitet;
    protected Session session;
    
    protected abstract void kontrolaCreate() throws ZavrsniRadException;
    protected abstract void kontrolaUpdate() throws ZavrsniRadException;
    protected abstract void kontrolaDelete() throws ZavrsniRadException;

    
    
    
    public Obrada(T entitet) {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    public T create() throws ZavrsniRadException {
        kontrolaCreate();
        save();
        return entitet;
    }
    
    public T update() throws ZavrsniRadException {
        kontrolaUpdate();
        save();
        return entitet;
    }
    
    public boolean delete() throws ZavrsniRadException {
        kontrolaDelete();
        session.beginTransaction();
        session.delete(entitet);
        session.getTransaction();
        return true;
    }

    private void save() {
        session.beginTransaction();
        session.save(entitet);
        session.getTransaction().commit();
    }
    
}