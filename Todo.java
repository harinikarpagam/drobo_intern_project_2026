import java.util.*;
class Todo{
    public static void main(String args[]){
        ArrayList <String> tasks = new ArrayList<>();
        tasks.add("Drink 3 litres of water");
        tasks.add("Practice java");
        tasks.add("Practice DSA");
        tasks.add("Take healthy food");
        tasks.add("Seeds");
        tasks.add("Do college assignments");

        for(String task:tasks){
            System.out.println(task);
        }
        System.out.println("Sorted task:");
        tasks.stream().sorted().forEach(task->System.out.println(task));

        System.out.println("High Priority:");
        tasks.stream().filter(task -> task.contains("Practice")).forEach(task -> System.out.println("Priority:" +task));

        long count = tasks.stream().count();

        System.out.println("Total tasks:"+count);
    }
}