package ie.atu;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {

        int count = 0;
        int studentAmount;

        ArrayList<Student> students = new ArrayList<>();        //store objects type student
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the file name (e.g, students.txt): ");
        String fileName = sc.nextLine().trim();

        while(true) {
            System.out.println("How many students do you want to enter: ");
            String text = sc.nextLine().trim();
            try {
                studentAmount = Integer.parseInt(text);
                break;
            }
            catch(NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        }

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

            try(PrintWriter out = new PrintWriter(new FileWriter(fileName, true))) {
                out.println(name);
                out.println(email);
                out.println(course);
                System.out.println("Saved to " + fileName);
            }
            catch(IOException ex){
                System.out.println("Could not write to file: " + ex.getMessage());
            }
            count++;

        }
        for(Student student : students) {       //print list of students
            System.out.println("Name: " + student.getName() + " Email: " + student.getEmail() + " Course: " + student.getCourse());
        }
    }
}