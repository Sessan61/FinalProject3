package staffManager;

import java.util.ArrayList;
import java.util.Scanner;
import static staffManager.StaffMgmt.CalculateBonus.averageWage;
import static staffManager.StaffMgmt.CalculateBonus.averageWageofDepartment;

public class StaffMgmt {

    static Scanner s = new Scanner(System.in);
    static ArrayList<Employee> staff = new ArrayList<Employee>();
    static boolean runAgain = true;

    public static void main(String[] args) {
        
        fillDataBase();
        UI ui = new UI();

        do {

            ui.Interface1();
            Developer.anOtherApplication();
            Technician.anotherServerCrash();
            System.out.println("Number of applications"+Developer.numberOfapplications);
            System.out.println("Number of craches"+Technician.numbersOfServerCraches);

            int choice = s.nextInt();
            s.nextLine();

            switchChoice(choice);

        } while (runAgain);
    }

    public static void switchChoice(int choice) {
        
        switch (choice) {
           
            case 1:
                for (Employee e : staff) {
                    System.out.println(e);
                }
                break;

            case 2:
                System.out.print("Give new employee name: ");
                String name = s.nextLine();
                
                System.out.print("Give new employee department: ");
                String department = s.nextLine();
                System.out.print("Give new employee salary: ");
                double salary = s.nextDouble();
                s.nextLine();

                switch (department) {

                    case "developer":

                        Developer d = new Developer(name, department,salary);
                        staff.add(d);
                        for (Employee e : staff) {
                            System.out.println(e);
                        }

                        break;
                    case "technician":
                        Technician t = new Technician(name,department,salary);
                        staff.add(t);
                        for (Employee e : staff) {
                            System.out.println(e);
                        }
                        break;
                    case "secretary":
                        int age = 0;
                        Secretary s = new Secretary(name,department,salary,age);
                        staff.add(s);
                        for (Employee e : staff) {
                            System.out.println(e);
                        }
                        break;

                }
          
                break;

            case 3:
                System.out.println("what information would you like to update. Please select from options 1,2 or 3\n 1. Name\n 2. Department\n 3. Salary ");
                int option = s.nextInt();
                s.nextLine();
                if (option == 1) {
                    System.out.print("What is the id of the person whos information you want to update? ");
                    int userid = s.nextInt();
                    s.nextLine();
                    Employee e = findById(userid);
                    System.out.println("Employee with id " + e.getId() + " has the name " + e.getName());
                    System.out.print("Please provide a new name: ");
                    String n = s.nextLine();
                    s.nextLine();

                    e.setName(n);
                    for (Employee e2 : staff) {
                        System.out.println(e2);
                    }
                    System.out.println("Updated name " + e.getName());
                }
                if (option == 2) {
                    System.out.print("What is the id of the person whos information you want to update? ");
                    int userid = s.nextInt();
                    s.nextLine();
                    Employee e = findById(userid);
                    System.out.println("Employee with id " + e.getId() + " has the occupation " + e.department);
                    System.out.print("Please provide a new department: ");
                    String n = s.nextLine();
                    e.setDepartment(n);
                    for (Employee e2 : staff) {
                        System.out.println(e2);
                    }
                    System.out.println("Updated department " + e.department);
                }
                if (option == 3) {
                    System.out.print("What is the id of the person whos information you want to update? ");
                    int userid = s.nextInt();
                    s.nextLine();
                    Employee e = findById(userid);
                    System.out.println("Employee with id " + e.getId() + " has the salary of " + e.getSalary());
                    System.out.print("Please provide a new salary: ");
                    salary = s.nextDouble();
                    e.setSalary(salary);
                    for (Employee e2 : staff) {
                        System.out.println(e2);
                    }
                    System.out.println("Updated salary" + " id " + e.getSalary());
                }
                break;

            case 4:
                System.out.print("What is the id of the person whos information you want to delete? ");
                int userid = s.nextInt();
                s.nextLine();
                Employee x = findById(userid);
                staff.remove(x);
                for (Employee e : staff) {
                    System.out.println(e);
                }
                break;

            case 5:
                System.out.print("Information about employee? Give employee id ");
                userid = s.nextInt();
                s.nextLine();
                System.out.println("Print information on employee " + findById(userid));
                break;

            case 6:
                double Totalsalary = 0;
                System.out.println("Give id");
                userid = s.nextInt();
                Employee e = findById(userid);
                Totalsalary = e.employeeBonusBase + e.getSalary();
                System.out.println(Totalsalary);
                break;

            case 7:
                System.out.println("==  Calculating BONUS OF EMPLOYEES  ==");
                CalculateBonus.sumBonus(staff);
               
                break;
                
            case 8:
                System.out.print("Calculate Statistics, Please select from options 1, 2, 3. 1. Average Salary, 2. Average Salary for Department");
                int statistic = s.nextInt();
                double y;
                double z;
                s.nextLine();
                if (statistic == 1) {
                    y = averageWage();
                    System.out.println("Test");
                    System.out.println("Print average Wage " + y);
                } else if (statistic == 2) {
                    z = averageWageofDepartment();
                    System.out.println("Test");
                    System.out.println("Print average Wage of Department" + z);
                }
                break;

            case 9:
                runAgain = false;
                break;

            default:
                System.out.println("Wrong input, valid choices are 1-8");
        }
    }

    public static void fillDataBase() {

        staff.add(new Secretary("Carl Cracker","Secretary", 20000,45));
        staff.add(new Technician("Harry Hacker", "Technician", 50000));
        staff.add(new Developer("Mark Stanley", "Developer", 40000));
        staff.add(new Secretary("Jack Joseph", "Secretary", 23000,50));
        staff.add(new Technician("Steve Smith", "Technician", 40000));
        staff.add(new Secretary("Märta Lind", "Secretary", 20000, 45));
        staff.add(new Secretary("Lina Bull", "Secretary", 25000,30));
        staff.add(new Secretary("Boris Vivian", "Secretary", 20000,15));
    }

    public static Employee findById(int userId) {

        for (Employee employee : staff) {

            if (employee.getId() == userId) {
                return employee;
            }
        }
        return null;
    }
    public static class CalculateBonus{
        public static double sumBonus(ArrayList<Employee> staff) {
        double totBonus = 0;
        for (Employee currentEmployee : staff) {
            totBonus += currentEmployee.bonus();
            System.out.println("Bonus for "+currentEmployee.getName() +" is: "+ currentEmployee.bonus());
        }
        System.out.println("Print totBonus " + totBonus);
        return totBonus;
    }
    public static double averageWage() {
        double average = 0;
        double totalSalary = 0;
        int count = 0;
        for (Employee e : staff) {
            count++;
            totalSalary = e.getSalary() + e.bonus() + totalSalary;
        }
        average = totalSalary / count;

        return average;
    }

    public static double averageWageofDepartment() {
        System.out.println("Print department");
        String dep = s.nextLine();

        int number = 1;
        double totalSalary = 0;
        if (dep.equalsIgnoreCase("secretary")) {
            for (Employee e : staff) {
                if (e.department.equalsIgnoreCase("secretary")) {
                    totalSalary = e.getSalary() + e.bonus() + totalSalary;
                    number++;
                }
//               
            }   
        }
        if (dep.equalsIgnoreCase("developer")) {
            for (Employee e : staff) {
                if (e.department.equalsIgnoreCase("developer")) {
                    totalSalary = e.getSalary() + e.bonus() + totalSalary;
                  
                    number++;
                }

            }
        }
        if (dep.equalsIgnoreCase("technician")) {

            for (Employee e : staff) {

                if (e.department.equalsIgnoreCase("technician")) {
                    totalSalary = e.getSalary() + e.bonus() + totalSalary;
                    number++;
                }
//               
            }
        }

        return totalSalary / (number - 1);
    }

  

    }    
}   
