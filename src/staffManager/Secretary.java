package staffManager;

import java.util.ArrayList;

public class Secretary extends Employee {
   int age;
   double bonus;
   

    public Secretary(String name, String department, double salary,int age) {
        super(name,department,salary);
        this.age = age;
        
       
    }

     
   public double bonus(){
       
       double bonus = employeeBonusBase + (age*30);
       return bonus;
   }    

    @Override
    public String toString() {
        return  super.toString()+ "age=" + age + " employeeBonusBase=" + employeeBonusBase ;
    }
  
    
}

