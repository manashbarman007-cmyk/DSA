package bit_manipulation;

public class Unique_Array_Element {
    public static void main(String[] args) {
        toFindOneUniqueElement();
        toFindTwoUniqueElements();

    }

    //one unique element and other elements repeat twice
    static void toFindOneUniqueElement(){
        int[] arr={2,4,2,6,3,3,1,1,6};
        int res=0;
        for(int i=0;i<arr.length;i++){
            res=res^arr[i]; //simple logic
        }
        System.out.println(res);
    }

    //two unique elements and other elements repeat twice
    static void toFindTwoUniqueElements(){
        int[] arr={2,6,6,7,2,4,3,3,1,1};
        int res=0;
        int setBit=0, bit=0;

        //Step1: take the XOR of all array elements
        for(int i=0;i<arr.length;i++){  //taking the XOR of all the array elements
            res=res^arr[i];
        }

        //Step2: check which bit of "res" is set
        while(res!=0){
            if(((res>>bit)&1)!=0){ //that is to check which bit is set
                                   //** imp Note: Here, the "res" is right shifted by bit++ but not stored anywhere.
                                   // So, ultimately "res" will remain same after coming out of while loop as it is not saved anywhere
                setBit=bit;
                break;
            }
            bit++; //else bit++
        }
        int res1=0;

        //Step3: take XOR of the new array of which the setBit is set
        for(int i=0;i<arr.length;i++){
            if(((arr[i]>>setBit)&1)!=0){
                res1=res1^arr[i];
            }
        }

        //res1 is one of the unique number
        System.out.println("num1 = "+res1);

        //res1^res is the other unique number
        System.out.println("num2 = "+(res1^res));
    }
}
