package strings;

import java.util.Arrays;

public class Strings_In_Java_Lec_49 {
    public static void main(String[] args) {
//        String name1="Manash";
//        String name2="ManashBarman";
//        System.out.println(name1.compareTo(name2));
//        String locations="Mumbai, Guwahati, Shillong, Jamshedpur, Delhi";
//        String[] locationsArray=locations.split(","); //The "," will act as the separator
//        System.out.println(Arrays.toString(locationsArray));
        String myEmail = "manashbarman007@gmail.com";
        String[] myEmailArr = myEmail.split("@");
        System.out.println(Arrays.toString(myEmailArr));
        int indexOf = myEmailArr[1].indexOf('.');
        System.out.println(indexOf);
        String companyName=myEmailArr[1].substring(0,indexOf);
        System.out.println(companyName);
        StringBuilder name=new StringBuilder("Manash");
        StringBuffer nameNew=new StringBuffer("Manash");

    }
}
