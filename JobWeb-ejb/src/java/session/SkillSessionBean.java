package session;

import entities.Skills;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;

@Stateless
public class SkillSessionBean implements SkillSessionBeanLocal {

    // Khởi tạo EntityManagerFactory và EntityManager thủ công
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("JobWeb-ejbPU");
    private EntityManager em = factory.createEntityManager();

    // Thêm kỹ năng mới
    @Override
    public void addSkill(Skills skill) {
        em.getTransaction().begin(); // Bắt đầu giao dịch
        em.persist(skill); // Lưu kỹ năng vào cơ sở dữ liệu
        em.getTransaction().commit(); // Kết thúc giao dịch
    }

    // Cập nhật thông tin kỹ năng
    @Override
    public void updateSkill(Skills skill) {
        em.getTransaction().begin(); // Bắt đầu giao dịch
        em.merge(skill); // Cập nhật thông tin kỹ năng
        em.getTransaction().commit(); // Kết thúc giao dịch
    }

    // Xóa kỹ năng theo ID
    @Override
    public void deleteSkill(Integer id) {
        Skills skill = em.find(Skills.class, id); // Tìm kỹ năng theo ID
        if (skill != null) {
            em.getTransaction().begin(); // Bắt đầu giao dịch
            em.remove(skill); // Xóa kỹ năng
            em.getTransaction().commit(); // Kết thúc giao dịch
        }
    }

    // Tìm kỹ năng theo ID
    @Override
    public Skills findSkillById(Integer id) {
        return em.find(Skills.class, id); // Trả về kỹ năng theo ID
    }

    // Lấy tất cả kỹ năng
    @Override
    public List<Skills> getAllSkills() {
        Query query = em.createQuery("SELECT s FROM Skills s");
        return query.getResultList(); // Trả về danh sách tất cả kỹ năng
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
