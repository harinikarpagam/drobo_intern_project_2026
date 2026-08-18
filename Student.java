import java.util.*;
class Student{
    static ArrayList<String> getPassMark(HashMap<Integer,String> student, HashMap<Integer,Integer> marks){
        ArrayList<String> passStudents = new ArrayList<>();
        for(Integer id:student.keySet()){
            int mark = marks.get(id);

            if(mark>=60){
                passStudents.add(student.get(id));
            }
            
        }
        Collections.sort(passStudents);
        return passStudents;
    }
    public static void main(String[] args) {
        HashMap<Integer, String> student = new HashMap<>();
        student.put(1001, "Harini");
        student.put(1002,"Bala");
        student.put(1003,"Keerthini");
        student.put(1004,"Monisha");
        student.put(1005,"Sriram");
        student.put(1006,"Priya Dharshini");
        student.put(1007,"Pradeepa");
        student.put(1008,"Yukesh");

        HashMap<Integer,Integer> marks = new HashMap<>();
        marks.put(1001, 96);
        marks.put(1002,87);
        marks.put(1003, 89);
        marks.put(1004,80);
        marks.put(1005, 100);
        marks.put(1006,76);
        marks.put(1007, 86);
        marks.put(1008,79);

        ArrayList<String> result = getPassMark(student, marks);
        System.out.println("The students who got passsed in the exam are given in the list:"+result);
        
    }
}