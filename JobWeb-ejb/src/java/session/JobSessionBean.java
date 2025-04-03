/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package session;

import entities.Jobs;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author ACER
 */
@Stateless
public class JobSessionBean implements JobSessionBeanLocal {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("JobWeb-ejbPU");
    private EntityManager em = factory.createEntityManager();
    
    @Override
    public void insert(Jobs job) {
        em.getTransaction().begin();  // Bắt đầu giao dịch
        em.persist(job);              // Lưu job vào DB
        em.getTransaction().commit(); // Commit giao dịch
//        System.out.println("lay may day");      
    }



    @Override
    public List<Jobs> findAll() {
        Query q = em.createNamedQuery("Jobs.findAll", Jobs.class);
        return q.getResultList();
    }

    @Override
    public void delete(Integer id) {
        em.getTransaction().begin();
        Jobs job = em.find(Jobs.class, id);
        if (job != null) {
            em.remove(job);
        }
        em.getTransaction().commit();
    }

    @Override
    public void update(Jobs job) {
        em.getTransaction().begin();
        Jobs jobFind = em.find(Jobs.class, job.getId());
        if (jobFind != null) {
            jobFind.setName(job.getName());
            jobFind.setDescription(job.getDescription());
            jobFind.setStartDate(job.getStartDate());
            jobFind.setEndDate(job.getEndDate());
            jobFind.setLevel(job.getLevel());
            jobFind.setLocation(job.getLocation());
            jobFind.setQuantity(job.getQuantity());
            jobFind.setSalary(job.getSalary());
            jobFind.setCompanyId(job.getCompanyId());
            em.merge(jobFind);
        }
        em.getTransaction().commit();
    }

}
