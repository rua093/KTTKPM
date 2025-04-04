package session;

import entities.Skills;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface SkillSessionBeanLocal {
    // Thêm một kỹ năng mới
    void addSkill(Skills skill);

    // Lấy tất cả các kỹ năng
    List<Skills> getAllSkills();

    // Lấy kỹ năng theo id
    Skills findSkillById(Integer id);

    // Cập nhật kỹ năng
    void updateSkill(Skills skill);

    // Xóa kỹ năng theo id
    void deleteSkill(Integer id);
}
