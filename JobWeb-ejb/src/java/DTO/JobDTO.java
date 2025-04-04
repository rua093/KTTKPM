package DTO;

import entities.Skills;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

/**
 * DTO class for Job entity
 * This class contains all attributes of a job, including companyId.
 */
public class JobDTO implements Serializable{
    private static final long serialVersionUID = 1L; 
    private Integer id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private String level;
    private String location;
    private int quantity;
    private BigDecimal salary;
    private Integer companyId;
    private Collection<Integer> skillsIdCollection;

    public JobDTO(String name, String description, Date startDate, Date endDate, String level, String location, int quantity, BigDecimal salary, Integer companyId, Collection<Integer> skillsIdCollection) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.level = level;
        this.location = location;
        this.quantity = quantity;
        this.salary = salary;
        this.companyId = companyId;
        this.skillsIdCollection = skillsIdCollection;
    }
    
    

    // Constructor
    public JobDTO(String name, String description, Date startDate, Date endDate, 
                  String level, String location, int quantity, BigDecimal salary, Integer companyId) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.level = level;
        this.location = location;
        this.quantity = quantity;
        this.salary = salary;
        this.companyId = companyId;
    }

    public JobDTO() {
    }

    public JobDTO(Integer id, String name, String description, Date startDate, Date endDate, String level, String location, int quantity, BigDecimal salary, Integer companyId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.level = level;
        this.location = location;
        this.quantity = quantity;
        this.salary = salary;
        this.companyId = companyId;
    }

    public Collection<Integer> getSkillsIdCollection() {
        return skillsIdCollection;
    }

    public void setSkillsIdCollection(Collection<Integer> skillsIdCollection) {
        this.skillsIdCollection = skillsIdCollection;
    }

    
    
    

    public Integer getId() {
        return id;
    }

    // Getters and setters for each attribute
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
