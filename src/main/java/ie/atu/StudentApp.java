package ie.atu;
import java.io.*;
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

        while(true) {       //check that amount entered is an integer
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

            try(PrintWriter out = new PrintWriter(new FileWriter(fileName, true))) {    //saves info to separate file
                out.println(name);
                out.println(email);
                out.println(course);
                System.out.println("Saved to " + fileName);
            }
            catch(IOException ex){
                System.out.println("Could not write to file: " + ex.getMessage());
            }
            count++;
            showFile(fileName);
        }
    }
    //print file with student information
    static void showFile(String fileName){
        BufferedReader br = null;
        try{
            FileReader neverUsed = new FileReader(fileName);
            br = new BufferedReader(neverUsed);
            System.out.println("Contents of students.txt: ");
            String line;
            while((line = br.readLine())!=null){
                System.out.println(" - " + line);
            }
        }
        catch(IOException ex){
            System.out.println("Could not read file: " + ex.getMessage());
        }
        finally{
            if(br != null){
                try{
                    br.close();
                }
                catch(IOException closeEx){
                    System.out.println("Could not close file: " + closeEx.getMessage());
                }
            }
        }
    }

}