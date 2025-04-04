package session;

import entities.Users;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;

@Stateless
public class UserSessionBean implements UserSessionBeanLocal {

    // Khởi tạo EntityManagerFactory và EntityManager thủ công
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("JobWeb-ejbPU");
    private EntityManager em = factory.createEntityManager();

    // Xác thực người dùng
    

    // Thêm người dùng mới
    @Override
    public void addUser(Users user) {
        System.out.println("okela");
        em.getTransaction().begin(); // Bắt đầu giao dịch
        em.persist(user); // Lưu người dùng vào cơ sở dữ liệu
        em.getTransaction().commit(); // Kết thúc giao dịch
        System.out.println("akelo");
    }

    // Cập nhật thông tin người dùng
    @Override
    public void updateUser(Users user) {
        em.getTransaction().begin(); // Bắt đầu giao dịch
        em.merge(user); // Cập nhật thông tin người dùng
        em.getTransaction().commit(); // Kết thúc giao dịch
    }

    // Xóa người dùng theo ID
    @Override
    public void deleteUser(Integer id) {
        Users user = em.find(Users.class, id); // Tìm người dùng theo ID
        if (user != null) {
            em.getTransaction().begin(); // Bắt đầu giao dịch
            em.remove(user); // Xóa người dùng
            em.getTransaction().commit(); // Kết thúc giao dịch
        }
    }

    // Tìm người dùng theo ID
    @Override
    public Users findUserById(Integer id) {
        return em.find(Users.class, id); // Trả về người dùng theo ID
    }

    // Lấy tất cả người dùng
    @Override
    public List<Users> getAllUsers() {
        Query query = em.createQuery("SELECT u FROM Users u");
        return query.getResultList(); // Trả về danh sách tất cả người dùng
    }

    // Đảm bảo đóng EntityManager khi không sử dụng nữa
    public void close() {
        if (em != null && em.isOpen()) {
            em.close(); // Đóng EntityManager
        }
        if (factory != null && factory.isOpen()) {
            factory.close(); // Đóng EntityManagerFactory
        }
    }
}
