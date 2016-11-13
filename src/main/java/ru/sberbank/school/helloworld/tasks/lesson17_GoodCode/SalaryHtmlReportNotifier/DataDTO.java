package ru.sberbank.school.helloworld.tasks.lesson17_GoodCode.SalaryHtmlReportNotifier;

public class DataDTO {

    private Integer id;

    private String emp_name;

    private Double salary;


    public DataDTO(Integer id, String emp_name, Double salary) {
        this.id = id;
        this.emp_name = emp_name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
