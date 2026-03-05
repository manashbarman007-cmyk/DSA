package strings;

public class Print_All_Substrings {
    public static void main(String[] args) {
        String name1 = "abc";
        String name2 = "kane";
        Print_All_Substrings obj=new Print_All_Substrings();
        obj.printMySubstrings(name1);
//        obj.printMySubstrings(name2);
    }

    public void printMySubstrings(String enterRef) {
        int n = enterRef.length(), index = 0;
        while (index < n) {
            for(int i=n;i>index;i--){
                System.out.print(enterRef.substring(index,i)+"  ");
            }
            index++;
        }
    }
}
