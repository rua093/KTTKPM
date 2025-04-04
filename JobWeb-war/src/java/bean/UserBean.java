package bean;

import entities.Users;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import session.UserSessionBeanLocal;

@Named("userBean")
@SessionScoped
public class UserBean implements Serializable {

    @EJB
    private UserSessionBeanLocal userSessionBean;

    private Users user;

    public UserBean() {
        this.user = new Users();
    }

    // Lấy danh sách tất cả người dùng
    public List<Users> getUserList() {
        return userSessionBean.getAllUsers();
    }

    // Thêm người dùng mới
    public void addUser() {
        System.out.println("user hehe: " + user);
        userSessionBean.addUser(user);
        // Reset lại đối tượng user sau khi thêm
        user = new Users();
    }

    // Chỉnh sửa người dùng
    public String editUser(Integer id) {
        user = userSessionBean.findUserById(id);
        return "edit_user";  // Chuyển hướng đến trang chỉnh sửa user
    }

    // Cập nhật người dùng
    public void updateUser() {
        userSessionBean.updateUser(user);
        // Reset lại đối tượng user sau khi cập nhật
        user = new Users();
    }

    // Xóa người dùng
    public void deleteUser(Integer id) {
        userSessionBean.deleteUser(id);
    }

    // Getter và Setter cho user
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
