package ie.atu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Student {
    String name;
    String email;
    String course;

    //default constructor
    Student(){
        name = "not set";
        email = "not set";
        course = "not set";
    }

    //setters
    void setName(String name){
        this.name = name;
    }
    void setEmail(String email){
        this.email = email;
    }
    void setCourse(String course){
        this.course = course;
    }

    //getters
    String getName(){
        return name;
    }
    String getEmail(){
        return email;
    }
    String getCourse(){
        return course;
    }

    //check for unique email
    static boolean uniqueEmail(String email, ArrayList<Student> students) {
        for (Student s : students) {
            if (s.getEmail().equalsIgnoreCase(email)) {
                return false;
            }
        }
        return true;
    }
    //print file with student information
    static void showFile(){
        BufferedReader br = null;
        try{
            FileReader neverUsed = new FileReader("students.txt");
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
