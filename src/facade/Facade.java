package facade;

import entity.Customer;
import entity.Employee;
import entity.Orders;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author martamiszczyk
 */
public class Facade
{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    public Facade(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

//    public Employee createEmployee()
//    {
//        Employee e1 = new Employee();
//        e1.setFirstName("Marta");
//        e1.setLastName("Miszczyk");
//        em.persist(e1);
//        
//        return e1;
//
//    }
    public Customer updateCustomer(Customer cust)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            cust = (Customer) em.createNamedQuery("select e from Employee e where e.fistName= :firstName").setParameter("firstName", "Marta").getSingleResult();
            em.getTransaction().commit();
            return cust;
        } finally
        {
            em.close();
        }

    }

    public long getEmployeCount()
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            long query = (long) em.createQuery("select count (e) from Employee e").getSingleResult();
            em.getTransaction().commit();
            return query;
        } finally
        {
            em.close();
        }

    }

    public String getCustomerInCity(String city)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            city = (String) em.createNamedQuery("Customer.findByCity").setParameter("city", city).getSingleResult();
            em.getTransaction().commit();
            return city;
        } finally
        {
            em.close();
        }

    }

    public List getEmployeMaxCustomers()
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            List<Employee> emp = em.createQuery("SELECT e FROM Employee e WHERE(size(e.customerCollection)) = SELECT MAX(size(ee.customerCollection)) FROM Employee ee").getResultList();
            em.getTransaction().commit();
            return emp;
        } finally
        {
            em.close();
        }

    }

    public List<String> getOrdersOnHold()
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            List<String> o = em.createNamedQuery("Orders.findByStatus").setParameter("status", "On Hold").getResultList();
            em.getTransaction().commit();
            return o;
        } finally
        {
            em.close();
        }

    }

    public String getOrdersOnHold(int customerNumber)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            String o = (String) em.createNamedQuery("select o from Orders o where o.customerNumber= :customerNumber").setParameter("customerNumber", "144").getSingleResult();
            em.getTransaction().commit();
            return o;
        } finally
        {
            em.close();
        }

    }
}
