/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;


import DTO.JobDTO;
import entities.Companies;
import entities.Jobs;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import session.CompanySessionBeanLocal;
import session.JobSessionBeanLocal;

/**
 *
 * @author ACER
 */
@Named("jobBean")
@SessionScoped
public class JobBean implements Serializable{
    @EJB
    private JobSessionBeanLocal jobSessionBean;
    @EJB
    private CompanySessionBeanLocal companySessionBean;

    private final Jobs job;
    
    private final JobDTO jobDto;
    
    public JobBean (){
        this.job = new Jobs();
        this.jobDto = new JobDTO();
    }
    
    public List<Jobs> getJobList() {
        List<Jobs> jobs = jobSessionBean.findAll();
        System.out.println("Danh sách jobs: " + jobs);
        return jobs;
    }
    
    public void delete (Integer id){
        jobSessionBean.delete(id);
    }
    
    public Jobs getJob(){
        return job;
    }
    
    public JobDTO getJobDto(){
        return jobDto;
    }
    
    public List<Companies> getCompanyList() {
        return companySessionBean.findAll(); // Lấy danh sách công ty
    }
    
    
   public void insert() {
        job.setName(jobDto.getName());
        job.setDescription(jobDto.getDescription());
        job.setStartDate(jobDto.getStartDate());
        job.setEndDate(jobDto.getEndDate());
        job.setLevel(jobDto.getLevel());
        job.setLocation(jobDto.getLocation());
        job.setQuantity(jobDto.getQuantity());
        job.setSalary(jobDto.getSalary());

        // Lấy companyId từ jobDTO và tìm công ty tương ứng
        Companies company = companySessionBean.findById(jobDto.getCompanyId());

        // Set công ty vào đối tượng job
        job.setCompanyId(company);

        // Lưu đối tượng job vào cơ sở dữ liệu
        jobSessionBean.insert(job);
        System.out.println("oke: " + job);
    }

}
