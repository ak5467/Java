import java.util.*;

public class TestStudent{
     
   public static void main(String [] args){
   
        ArrayList<Student> sList= new ArrayList<>();
   
        Student student1 = new Student(1123, "Jay Can", "CS", 4.00);
        Student student2 = new Student(3256, "Ed Holdum", "SE", 3.45);
        Student student3 = new Student(7765, "Mike Floatsman", "IST", 3.53);
        Student student4 = new Student(6789, "Annu Kuriakose", "IST", 4.00);
        
        sList.add(student1);
        sList.add(student2);
        sList.add(student3);
        sList.add(student4);
        
//         student1.gpa = 3.66; //private access - error
        
        for(Student s: sList){
            
            System.out.println(s.toString());
        }
        
        student1.setMajor("IST");
        double oldGpa = student2.getGpa();
        student2.setGpa(oldGpa+0.1);
        
        for(Student s: sList){
            
            System.out.println(s.toString());
        }
        
   }//end of main

}