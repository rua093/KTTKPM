package bean;

import entities.Companies;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import session.CompanySessionBeanLocal;

@Named("companyBean")
@SessionScoped
public class CompanyBean implements Serializable {

    @EJB
    private CompanySessionBeanLocal companySessionBean;

    private Companies company;

    public CompanyBean() {
        this.company = new Companies();
    }

    // Lấy danh sách các công ty
    public List<Companies> getCompanyList() {
        return companySessionBean.findAll();
    }

    // Thêm công ty mới
    public void insert() {
        companySessionBean.insert(company);
        // Reset lại đối tượng company sau khi thêm
        company = new Companies();
    }

    // Chỉnh sửa công ty
    public String edit(Integer id) {
        company = companySessionBean.findById(id);
        return "edit_company";  // Đưa về trang chỉnh sửa công ty
    }

    // Cập nhật công ty
    public void update() {
        companySessionBean.update(company);
        // Reset lại đối tượng company sau khi cập nhật
        company = new Companies();
    }

    // Xóa công ty
    public void delete(Integer id) {
        companySessionBean.delete(id);
    }

    // Getter và setter cho company
    public Companies getCompany() {
        return company;
    }

    public void setCompany(Companies company) {
        this.company = company;
    }
}
