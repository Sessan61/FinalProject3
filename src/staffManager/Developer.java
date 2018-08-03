package staffManager;

import java.util.ArrayList;


    
   public class Developer extends Employee {
      static int numberOfapplications; 
      

 
    public Developer(String name,String department,double salary){
       super(name, department, salary);
     
   }    
       public double bonus(){
          int employeeBonusBase = 3000;
       double bonus = employeeBonusBase*numberOfapplications;
       return bonus;
   }    
   public static void anOtherApplication(){
     
       numberOfapplications +=1;
      
   }

    @Override
    public String toString() {
        return  super.toString()+" numberOfapplications=" + numberOfapplications + "BonusBase "+employeeBonusBase;
    }
   }    


   
    
   
  
    

