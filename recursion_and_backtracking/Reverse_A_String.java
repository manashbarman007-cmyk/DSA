package recursion_and_backtracking;

public class Reverse_A_String {
    public static void main(String[] args) {
        StringBuilder obj1=new StringBuilder("Manash Barman");
        StringBuilder obj2=new StringBuilder("12345");
        revString(obj1,0,obj1.length()-1);
        System.out.println(obj1);
        revString(obj2,0,obj2.length()-1);
        System.out.println(obj2);


    }

    static void revString(StringBuilder str,int start,int end){
        if(start>end){  //base case
            return;
        }
            //this part runs if start<=end
            char temp= str.charAt(start);
            str.setCharAt(start, str.charAt(end));
            str.setCharAt(end,temp);

        revString(str,start+1,end-1);
    }
}
