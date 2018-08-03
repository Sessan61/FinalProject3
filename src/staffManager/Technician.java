package staffManager;



public class Technician extends Employee{
    static int numbersOfServerCraches;
    double bounus;
   
    public Technician(String name,String department, double salary){
        super(name,department, salary);
      
        
    }
    public double bonus(){
        double bonus = employeeBonusBase - numbersOfServerCraches;
        return bonus;   
}
    public static void anotherServerCrash(){
      
        numbersOfServerCraches +=1;
      
}

    @Override
    public String toString() {
        return super.toString() + "numbersOfServerCraches=" + numbersOfServerCraches + ", employeeBonusBase=" + employeeBonusBase;
    }
    
}
