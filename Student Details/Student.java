import java.util.*;

public class Student{
   
   //private attributes
   private String name;
   private String major;
   private double gpa;
   private int studentId;
   
   //constructor
   public Student(int _studentId, String _name, String _major, double _gpa){
   
      name      = _name;
      major     = _major;
      gpa       = _gpa;
      studentId = _studentId;
   }
   
   //accessors for each attribute
   String getName(){
      return name;
   }
   String getMajor(){
      return major;
   }
   double getGpa(){
      return gpa;
   }
   int getStudentId(){
      return studentId;
   }
   
   //mutator for major
   void setMajor(String _major){
      major = _major;
   }
   
   //mutator for gpa
   void setGpa(double _gpa){
      gpa = _gpa;
   }
   
   public String toString(){
      
      System.out.printf("Student details>>\n ID: "+studentId+", Student name: "+name+", major: "+major+", gpa: %3.2f\n",gpa);
      return "<<<End of Task>>>";
   }
   
   public static void main(String [] args){
   
    //  Student std = new Student(330008888, "Annu", "IST", 3.2);
     // System.out.println(std.toString());
   }
   
}//end of class