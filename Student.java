import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
class Student{
    static ArrayList <String> getstudent(HashMap<Integer,String> student){
        ArrayList<String> arr = new ArrayList<>();
        for(String name: student.values()){
            arr.add(name);
        }
          return arr;
    }
    public static void main(String args[]){
        HashMap<Integer, String> student = new HashMap<>();
        student.put(1001,"Harini");
        student.put(1002,"Karpagam");
        student.put(1003,"Theertha");
        student.put(1004,"Keerthini");

        ArrayList result = getstudent(student);
        System.out.println("Names of the students" +result);
    }
    
}