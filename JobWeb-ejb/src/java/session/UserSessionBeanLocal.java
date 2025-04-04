package session;

import entities.Users;
import java.util.List;
import jakarta.ejb.Local;

@Local
public interface UserSessionBeanLocal {
     // Xác thực người dùng
    void addUser(Users user);  // Thêm người dùng
    void updateUser(Users user);  // Cập nhật người dùng
    void deleteUser(Integer id);  // Xóa người dùng
    Users findUserById(Integer id);  // Tìm người dùng theo username
    List<Users> getAllUsers();  // Lấy tất cả người dùng
}
