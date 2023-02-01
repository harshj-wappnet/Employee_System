import java.util.Random;
import java.util.Scanner;


// Employee System is a Basic Employee management system which manage shows employee details
// This Program Implements a concept OOP Concept : Abstraction

//abstract class employee which defines 2 abstract method and 1 non-abstract method
abstract class Employee {

    String emp_name; //name of employee
    int emp_id; //id  of employee
    int emp_salary; //salary of employee
    String emp_position; //role  of employee
    String achievement; //achievement of employee


    //constructor
    public Employee(String emp_name, int emp_id, int emp_salary, String emp_position, String achievement) {
        this.emp_name = emp_name;
        this.emp_id = emp_id;
        this.emp_salary = emp_salary;
        this.emp_position = emp_position;
        this.achievement = achievement;
    }


    /*abstarct method which is used to
    dispaly latest achievement and return
    a string
    */
    public abstract String show_achievement();

    /*abstract method calculate_pf is used to
    calculate the PF of employee using employee's
    salary this function returns pf intger value
    * */
    abstract int calculate_pf();


    /* non-abstract method which is used to display all
    profile details of the employee it returns void and use
    4 paramater from constructor name , id, role and salary
    * */
    public void show_employee_details() {
        System.out.println("Your Name is : " + emp_name);
        System.out.println("Your Employee Id is :" + emp_id);
        System.out.println("Your Role is : " + emp_position);
        System.out.println("Your Salary is : " + emp_salary);
    }


}

/*child class of Employee which implement all
abstract methods defined in parent employee class
 */
class Emp1 extends Employee {


    //super constructor which sends and update values in patent class Employee
    public Emp1(String emp_name, int emp_id, int emp_salary, String emp_position, String achievement) {
        super(emp_name, emp_id, emp_salary, emp_position, achievement);
    }

    //implementation of show_achievement abstract method
    @Override
    public String show_achievement() {
        System.out.println();
        return "Your Recent achievement is : " + achievement;
    }

    //implementation of calculate_pf abstract method
    @Override
    int calculate_pf() {
        return emp_salary / 30;
    }
}


public class Main {
    public static void main(String[] args) {

        //scanner class for user inputs
        Scanner scanner = new Scanner(System.in);

        System.out.println("-: Welcome to H Employee System :-");

        System.out.println(" --Authentication--   ");

        //take email and password from user for authentication
        System.out.print("Enter Email : ");
        String emp_email = scanner.next();

        System.out.print("Enter Password : ");
        String emp_pass = scanner.next();

        //defines authenticate class for authentication functionality
        Authenticate authenticate = new Authenticate();

        /*checkpassword method is used for verifying employee email and password
        it take two parameter email and password and return sucess or fail
        means email and password is wrong
        */
        authenticate.checkpassword(emp_email, emp_pass);


        //here we take all information from user and also generate some
        System.out.print("   Registration   ");

        System.out.print("Enter Name : ");
        String emp_name = scanner.next();

        //id is generated randomlly
        Random random = new Random();
        int emp_id = random.nextInt(200);

        System.out.print("Enter Your Role : ");
        String emp_position = scanner.next();

        int emp_salary = 0;

        //salary is assigned according to the role enterd by employee
        if (emp_position.equalsIgnoreCase("DEVELOPER")) {
            emp_salary = 60000;
        } else if (emp_position.equalsIgnoreCase("DESIGNER")) {
            emp_salary = 40000;
        } else if (emp_position.equalsIgnoreCase("BDE")) {
            emp_salary = 50000;
        } else if (emp_position.equalsIgnoreCase("HR")) {
            emp_salary = 50000;
        } else if (emp_position.equalsIgnoreCase("TESTER")) {
            emp_salary = 60000;
        } else {
            emp_salary = 50000;
        }


        String emp_achievement = "BEST EMPLOYEE OF THE YEAR";
        Emp1 emp1 = new Emp1(emp_name, emp_id, emp_salary, emp_position, emp_achievement);


        //here we prove 3 operations options to user to perform operation according to need
        while (true) {
            System.out.println();
            System.out.println("Select Operation You Want to perform");
            System.out.println("1. View Profile Details ");
            System.out.println("2. Calculate PF and View PF ");
            System.out.println("3. View Latest achievement ");
            System.out.println("4. Exit ");

            int choice = 0;
            System.out.println("Enter Your Choice : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    emp1.show_employee_details();
                    break;
                case 2:
                    System.out.println("Your PF is :" + emp1.calculate_pf());
                    break;
                case 3:
                    System.out.println(emp1.show_achievement());
                    break;
                case 4:
                    System.exit(0);
                    break;

            }

        }

    }
}