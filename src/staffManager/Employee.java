
package staffManager;

import java.util.ArrayList;
import java.util.Scanner; 

public abstract class Employee {
    static int idBank=1;
    private int id;
    private String name;
    String department;
    private double salary;
    protected final double employeeBonusBase;

  
 

    public Employee(String name,String department, double salary) {
        this.id=idBank;
        idBank++;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.employeeBonusBase=3000;   
    }
    
    abstract public double bonus();
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary;
    }
    
}  

  
    

