package stacks_lectures;

import java.util.Stack;

public class Maximal_Rectangle_Leetcode_85 {
    public static void main(String[] args) {
        Maximal_Rectangle_Leetcode_85 obj=new Maximal_Rectangle_Leetcode_85();
       char[][] ex1={{'1','0','1','0','0'},
                       {'1','0','1','1','1'},
                       {'1','1','1','1','1'},
                       {'1','0','0','1','0'}
                      };
        System.out.println(obj.maximalRectangle(ex1));

    }
    public int maximalRectangle(char[][] matrix) {
      int[] arr= new int[matrix[0].length];
      int largest=0;
      for(int i=0;i<matrix.length;i++){
          for(int j=0;j<matrix[i].length;j++){
              int val=matrix[i][j]-'0'; //integer equivalent to the character
              if(val==0) arr[j]=0;
              else arr[j]+=val;
          }
          int maxRectangle= largestRectangleArea(arr);
          if(largest<maxRectangle) largest=maxRectangle;
      }
     return largest;
    }
    public int largestRectangleArea(int[] heights) {
        int n=heights.length, maxArea=0,top=-1;
//        Stack<Integer> stack=new Stack<>();
        int[] stack=new int[n+1]; //creating a custom stack of size 'n+1' as we push a '0' at the end
        for(int i=0;i<=n;i++){
            int element=(i==n)?0:heights[i];
            while(top!=-1 && heights[stack[top]]>=element){
                int height=heights[stack[top--]];
                int pse=(top==-1)?-1:stack[top];
                int nse=(i==n)?n:i;
                int breadth=nse-pse-1;
                maxArea= Math.max(height*breadth,maxArea);
            }

            if(top==-1){
                stack[++top]=i;
            }
            stack[++top]=i; //will get pushed if element>heights[stack.peek()]
        }
        return maxArea;
    }
}
