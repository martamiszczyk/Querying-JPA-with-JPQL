/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import facade.Facade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author martamiszczyk
 */
public class Tester
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    EntityManager em = emf.createEntityManager();
        Facade facade = new Facade (emf);
        
//        System.out.println(facade.createEmployee());
        System.out.println(facade.getEmployeCount());
        System.out.println(facade.getOrdersOnHold().toString());
        
        
    }
    
}
