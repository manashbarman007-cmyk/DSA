package stacks_lectures;

import java.util.Stack;

public class Largest_Rectangle_In_Histogram_Leetcode_84 {
    public static void main(String[] args) {
        Largest_Rectangle_In_Histogram_Leetcode_84 obj=new Largest_Rectangle_In_Histogram_Leetcode_84();
        int[] ex1={2, 1, 5, 6, 2, 3};
        int[] ex2={2, 4};
        System.out.println(obj.largestRectangleArea(ex1));
        System.out.println(obj.largestRectangleArea(ex2));
    }

    //slightly optimal approach
//    public int largestRectangleArea(int[] heights) {
//         int n=heights.length, maxArea=0;
//
//         int[] pse=findPreviousSmallerElement(heights); //previous smaller element
//         int[] nse=findNextSmallerElement(heights); //next smaller element
//
//         for (int i=0;i<n;i++){
//             int breadth=nse[i]-pse[i]-1,height=heights[i];
//             maxArea= Math.max(height*breadth,maxArea);
//         }
//
//         return maxArea;
//
//    }

    //method to find the next smaller element
//    static int[] findNextSmallerElement(int[] arr){
//        int n= arr.length;
//        Stack<Integer> stack=new Stack<>();
//        int[] nse=new int[n];
//        for(int i=n-1;i>=0;i--) {
//            int element = arr[i];
//
//            //while loop to find the pse, the stack should be monotonic increasing
//            while (!stack.isEmpty() && arr[stack.peek()] >= element) {
//                stack.pop();
//            }
//            if (stack.isEmpty()) {
//                nse[i] = n;
//                stack.push(i);
//            } else {
//                nse[i] = stack.peek();
//                stack.push(i);
//            }
//        }
//        return nse;
//    }

    //method to find the previous smaller element
//    static int[] findPreviousSmallerElement(int[] arr){
//        int n= arr.length;
//        Stack<Integer> stack=new Stack<>();
//        int[] pse=new int[n];
//        for(int i=0;i<n;i++) {
//            int element = arr[i];
//
//            //while loop to find the pse, the stack should be monotonic increasing
//            while (!stack.isEmpty() && arr[stack.peek()] >= element) {
//                stack.pop();
//            }
//            if (stack.isEmpty()) {
//                pse[i] = -1;
//                stack.push(i);
//            } else {
//                pse[i] = stack.peek();
//                stack.push(i);
//            }
//        }
//        return pse;
//    }


    //most optimal approach
    public int largestRectangleArea(int[] heights) {
        int n=heights.length, maxArea=0;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<=n;i++){
            int element=(i==n)?0:heights[i];

            while(!stack.isEmpty() && heights[stack.peek()]>=element){
                int height=heights[stack.pop()];
                int pse=(stack.isEmpty())?-1:stack.peek();
                int nse=(i==n)?n:i;
                int breadth=nse-pse-1;
                maxArea= Math.max(height*breadth,maxArea);
            }

            if(stack.isEmpty()){
                stack.push(i);
            }
            stack.push(i); //will get pushed if element>heights[stack.peek()]
        }
        return maxArea;
    }
}
