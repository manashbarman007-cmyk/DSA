package strings;

public class Strings_In_Java_Lec_48 {
    public static void main(String[] args) {
        String name1="cat";
        String name2="cat";
        System.out.println(name2);
        String name3=new String("cat");
        System.out.println("Is name1==name2: "+ (name1==name2));
        System.out.println("Is name1==name3: "+ (name1==name3));
        System.out.println("Are the contents of name1 and name3 same? Ans: "+(name1.equals(name3)));
    }
}
