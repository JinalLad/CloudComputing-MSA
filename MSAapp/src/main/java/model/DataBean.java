/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package model;

import entity.Book;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jinal
 */
@Stateless
public class DataBean {

    @PersistenceContext(unitName="ictpu")
    EntityManager em;
    
    
    public Collection<Book>getAllbook(){
    return em.createNamedQuery("book.findAll").getResultList();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
