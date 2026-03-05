package bit_manipulation;

public class Is_Num_Power_Of_2 {
    public static void main(String[] args) {
     toFind(65);

    }
    static void toFind(int num){
        boolean isNumPowerOf2=true;
        int newNum=num-1,counter=0,copy=num;
       while(num>0){
           num=num/2;
           counter++;
       }
        for(int i=0;i<counter-1;i++){
            if((newNum&(1<<i))==0 ){
                isNumPowerOf2=false;
                break; //we come out of the for loop
            }
        }
        if(isNumPowerOf2==false){
            System.out.println(copy+" is not a power of 2");
        }
        else{
            System.out.println(copy+" is a power of 2");
        }
    }
}

