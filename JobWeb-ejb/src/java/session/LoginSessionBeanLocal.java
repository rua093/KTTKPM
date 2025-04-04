/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package session;

import jakarta.ejb.Local;

/**
 *
 * @author ACER
 */
@Local
public interface LoginSessionBeanLocal {
     boolean authenticate(String email, String password);
}
