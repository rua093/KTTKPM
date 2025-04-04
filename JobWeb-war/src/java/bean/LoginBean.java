package bean;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.application.FacesMessage;
import jakarta.servlet.http.HttpSession;
import java.io.Serializable;
import session.LoginSessionBeanLocal;

@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String email;
    private String password;
    
    @EJB
    private LoginSessionBeanLocal loginSessionBean;

    // Phương thức đăng nhập
    public String login() {
        boolean isAuthenticated = loginSessionBean.authenticate(email, password);
        System.out.println("in: "+ email + password);
        
        if (isAuthenticated) {
            // Lưu thông tin người dùng vào session (nếu cần)
//            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//            session.setAttribute("email", email);

            return "job_list"; // Chuyển hướng đến trang welcome sau khi đăng nhập thành công
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Invalid email or password"));
            return null; // Ở lại trang đăng nhập nếu thông tin không hợp lệ
        }
    }

    // Các getter và setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
