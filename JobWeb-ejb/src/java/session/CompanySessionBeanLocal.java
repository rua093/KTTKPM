package session;

import entities.Companies;
import java.util.List;
import jakarta.ejb.Local;

@Local
public interface CompanySessionBeanLocal {
    void insert(Companies company);
    List<Companies> findAll();
    void update(Companies company);
    void delete(int id);
    Companies findById(Integer Id);
}
