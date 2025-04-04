/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;


import DTO.JobDTO;
import entities.Companies;
import entities.Jobs;
import entities.Skills;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import session.CompanySessionBeanLocal;
import session.JobSessionBeanLocal;
import session.SkillSessionBeanLocal;

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
    @EJB
    private SkillSessionBeanLocal skillSessionBean;
    

    private Jobs job;
    
    private JobDTO jobDto;
    
    public JobBean (){
        resetJob();
    }
    
    private void resetJob() {
        this.job = new Jobs();
        this.jobDto = new JobDTO();
    }
    
    public String getSkillNames(Jobs job) {
    return job.getSkillsCollection().stream()
              .map(Skills::getName)
              .collect(Collectors.joining(", "));
}
    
    public List<Jobs> getJobList() {
        List<Jobs> jobs = jobSessionBean.findAll();
        for (Jobs job : jobs) {
        job.getSkillsCollection().size();
    }
        System.out.println("Danh sách jobs: " + jobs);
        return jobs;
    }
    
    public void delete (Integer id){
        jobSessionBean.delete(id);
    }
    public List<Skills> getSkillList(){
        return skillSessionBean.getAllSkills();
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

        // Lấy công ty từ jobDto
        Companies company = companySessionBean.findById(jobDto.getCompanyId());
        job.setCompanyId(company);

        // Chuyển đổi từ danh sách skillsId sang danh sách Skills
        Collection<Skills> selectedSkills = new ArrayList<>();
        for (Integer skillId : jobDto.getSkillsIdCollection()) {
            Skills skill = skillSessionBean.findSkillById(skillId);
            if (skill != null) {
                selectedSkills.add(skill);
            }
        }

        // Gán danh sách kỹ năng vào job
        job.setSkillsCollection(selectedSkills);

        // Lưu job vào database
        jobSessionBean.insert(job);
        System.out.println("oke: " + job);

        resetJob();
    }

   
   public String edit(Integer id) {
        job = jobSessionBean.findById(id);
        jobDto.setId(job.getId());
        jobDto.setName(job.getName());
        jobDto.setDescription(job.getDescription());
        jobDto.setStartDate(job.getStartDate());
        jobDto.setEndDate(job.getEndDate());
        jobDto.setLevel(job.getLevel());
        jobDto.setLocation(job.getLocation());
        jobDto.setQuantity(job.getQuantity());
        jobDto.setSalary(job.getSalary());
        System.out.println("hehe");
        return "edit_job";
    }
   
   public void update() {
        job.setId(jobDto.getId());
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
        jobSessionBean.update(job);
        System.out.println("okeedit: " + job);
        resetJob();
    }

}
