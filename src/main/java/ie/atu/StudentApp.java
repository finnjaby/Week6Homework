package ie.atu;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {

        int count =0;
        ArrayList<Student> students = new ArrayList<>();        //store objects type student
        Scanner sc = new Scanner(System.in);

        System.out.print("How many students do you want to enter? ");
        int studentAmount = sc.nextInt();
        sc.nextLine();

        while(count<studentAmount) {        //prompt for student information
            System.out.print("Please enter students name: ");
            String name = sc.nextLine();

            String email;
            do {                    //prompts for email until unique
                System.out.print("Please enter student's email: ");
                email = sc.nextLine();
                if (!Student.uniqueEmail(email, students)) {
                    System.out.println("This email has already been used, please try again. ");
                }
            } while (!Student.uniqueEmail(email, students));

            System.out.print("Please enter students course: ");
            String course = sc.nextLine();

            Student studentTemp = new Student();    //create default student
            studentTemp.setName(name);
            studentTemp.setEmail(email);
            studentTemp.setCourse(course);
            students.add(studentTemp);
            count++;

        }
        for(Student student : students) {       //print list of students
            System.out.println("Name: " + student.getName() + " Email: " + student.getEmail() + " Course: " + student.getCourse());
        }
    }
}