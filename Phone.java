import java.util.HashMap;

class Phone{
    public static void main(String args[])
    {
        HashMap<Integer, String> brand = new HashMap<>();

        brand.put(1001,"Oppo");
        brand.put(1002,"i phone");
        brand.put(1003,"one plus");
        brand.put(1004,"Vivo");
        brand.put(1005, "Samsung");
        brand.put(1006,"Poco");
        brand.put(1007, "Redmi");


        System.out.println(brand);
        System.out.println(brand.get(1001));
    }
}