package session;

import entities.Companies;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;

@Stateless
public class CompanySessionBean implements CompanySessionBeanLocal {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("JobWeb-ejbPU");
    private EntityManager em = factory.createEntityManager();

    @Override
    public void insert(Companies company) {
        em.getTransaction().begin();
        em.persist(company);
        em.getTransaction().commit();
    } 

    @Override
    public List<Companies> findAll() {
        Query q = em.createQuery("SELECT c FROM Companies c", Companies.class);
        return q.getResultList();
    }

    @Override
    public void update(Companies company) {
        em.getTransaction().begin();
        Companies companyFind = em.find(Companies.class, company.getId());
        if (companyFind != null) {
            companyFind.setName(company.getName());
            companyFind.setAddress(company.getAddress());
            companyFind.setDescription(company.getDescription());
            em.merge(companyFind);
        }
        em.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        em.getTransaction().begin();
        Companies company = em.find(Companies.class, id);
        if (company != null) {
            em.remove(company);
        }
        em.getTransaction().commit();
    }

    @Override
    public Companies findById(Integer id) {
        return em.find(Companies.class, id);  // Tìm công ty theo ID trong cơ sở dữ liệu
    }
}
