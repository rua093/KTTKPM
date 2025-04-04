package bean;

import entities.Skills;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import session.SkillSessionBeanLocal;
import java.util.List;

@Named("skillBean")
@RequestScoped
public class SkillBean {

    @EJB
    private SkillSessionBeanLocal skillSessionBean;

    private Skills skill; // Đối tượng skill mà người dùng sẽ thao tác
    private List<Skills> skills; // Danh sách các kỹ năng

    // Constructor
    public SkillBean() {
        this.skill = new Skills(); // Khởi tạo đối tượng kỹ năng mới
    }

    // Thêm kỹ năng mới
    public void addSkill() {
        skillSessionBean.addSkill(skill);
        skill = new Skills(); // Tạo đối tượng mới sau khi thêm
    }

    // Cập nhật kỹ năng
    public void updateSkill() {
        skillSessionBean.updateSkill(skill);
    }

    // Xóa kỹ năng
    public void deleteSkill(Integer id) {
        skillSessionBean.deleteSkill(id);
    }

    // Chỉnh sửa kỹ năng
    public void editSkill(Skills skill) {
        this.skill = skill; // Đặt đối tượng skill hiện tại để chỉnh sửa
    }

    // Lấy tất cả kỹ năng
    public List<Skills> getSkills() {
        if (skills == null) {
            skills = skillSessionBean.getAllSkills();
        }
        return skills;
    }

    public Skills getSkill() {
        return skill;
    }

    public void setSkill(Skills skill) {
        this.skill = skill;
    }
}
