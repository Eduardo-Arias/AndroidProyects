package mx.edu.utng.orders.model;

/**
 * Created by eduardo on 23/02/2017.
 */

public class Salary {
    private String idSalary;
    private int empNo;
    private int salary;
    private String fromDate;

    public Salary(String idSalary, int empNo, int salary, String fromDate) {
        this.idSalary = idSalary;
        this.empNo = empNo;
        this.salary = salary;
        this.fromDate = fromDate;
    }

    public Salary() {
        this("",0,0,"");
    }

    public String getIdSalary() {
        return idSalary;
    }

    public void setIdSalary(String idSalary) {
        this.idSalary = idSalary;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    @Override
    public String toString() {
        return "Salaries{" +
                "idSalary='" + idSalary + '\'' +
                ", empNo=" + empNo +
                ", salary=" + salary +
                ", fromDate='" + fromDate + '\'' +
                '}';
    }
}
