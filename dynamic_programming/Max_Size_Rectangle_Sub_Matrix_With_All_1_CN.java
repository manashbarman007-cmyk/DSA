package dynamic_programming;

public class Max_Size_Rectangle_Sub_Matrix_With_All_1_CN {
    public static void main(String[] args) {
      int[][] mat = {{1, 0, 1, 1},
                     {1, 0, 1, 1},
                     {0, 1, 0, 1},
                     {1, 1, 1, 1,},
                     {0, 0, 0, 1}};
        System.out.println(maximalAreaOfSubMatrixOfAll1(mat, 5, 4));
    }

    public static int maximalAreaOfSubMatrixOfAll1(int[][] mat, int n, int m) {
        int[] arr = new int[mat[0].length];
        int largest = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0;j < mat[i].length; j++) {
                int val = mat[i][j]; //integer equivalent to the character
                if (val == 0) arr[j] = 0;
                else arr[j] += val;
            }
            int maxRectangle = largestRectangleArea(arr);
            if (largest < maxRectangle) largest = maxRectangle;
        }
        return largest;
    }
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length, maxArea = 0,top = -1;
//        Stack<Integer> stack=new Stack<>();
        int[] stack = new int[n + 1]; // creating a custom stack of size 'n + 1' as we push a '0' at the end
        for( int i = 0; i <= n; i++) {
            int element = (i == n) ? 0 : heights[i];
            while (top != -1 && heights[stack[top]] >= element){
                int height = heights[stack[top--]];
                int pse = (top == -1) ? -1 : stack[top];
                int nse = (i == n) ? n : i;
                int breadth = nse - pse - 1;
                maxArea = Math.max(height * breadth, maxArea);
            }

            if (top == -1) {
                stack[++top] = i;
            }
            stack[++top] = i; //will get pushed if element > heights[stack.peek()]
        }
        return maxArea;

    }
}
