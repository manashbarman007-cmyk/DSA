package bit_manipulation;

public class Character_Conversion {
    public static void main(String[] args) {
        toUpperToLower('B');
        toLowerToUpper('b');
    }
    static void toUpperToLower(char ch){
        int x=ch;  //x stores the integer value of ch
        x=x^(1<<5);
        ch=(char)x;  //type casting

        System.out.println(ch);
    }
    static void toLowerToUpper(char ch){
        int x=ch;  //x stores the integer value of ch
        x=x^(1<<5);
        ch=(char)x; //type casting

        System.out.println(ch);
    }
}
