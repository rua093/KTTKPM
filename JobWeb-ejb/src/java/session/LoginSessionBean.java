/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package session;

import entities.Users;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

/**
 *
 * @author ACER
 */
@Stateless
public class LoginSessionBean implements LoginSessionBeanLocal {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("JobWeb-ejbPU");
    private EntityManager em = factory.createEntityManager();
    
    @Override
    public boolean authenticate(String email, String password) {
        // Truy vấn để tìm người dùng với email và password
        Query query = em.createQuery("SELECT u FROM Users u WHERE u.email = :email AND u.password = :password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        
        // Kiểm tra nếu tồn tại người dùng phù hợp
        try {
            Users user = (Users) query.getSingleResult();
            return user != null; // Nếu tìm thấy người dùng, trả về true
        } catch (Exception e) {
            return false; // Không tìm thấy người dùng hoặc có lỗi, trả về false
        }
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
