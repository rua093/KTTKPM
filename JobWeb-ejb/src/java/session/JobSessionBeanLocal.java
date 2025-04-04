/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package session;

import entities.Jobs;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author ACER
 */
@Local
public interface JobSessionBeanLocal {
    List<Jobs> findAll();
    void insert(Jobs job);  // Cập nhật tham số
    void delete(Integer id);
    void update(Jobs job);
    Jobs findById(Integer id);
}

