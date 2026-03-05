package stacks_lectures;

import java.util.Arrays;
import java.util.Stack;

public class Asteroid_Collision_Leetcode_735 {
    public static void main(String[] args) {
        Asteroid_Collision_Leetcode_735 obj = new Asteroid_Collision_Leetcode_735();
        int[] ex1 = {5, 10, -5};
        int[] ex2 = {8, -8};
        int[] ex3 = {10, 2, -5};
        System.out.println(Arrays.toString(obj.asteroidCollision(ex1)));
        System.out.println(Arrays.toString(obj.asteroidCollision(ex2)));
        System.out.println(Arrays.toString(obj.asteroidCollision(ex3)));

    }

    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            int element=asteroids[i];
            //if stack is empty or the element is positive then perform blind insertion
            if(stack.isEmpty() || element>0){
                stack.push(element);
            }
            else {
                while (!stack.isEmpty()) {
                    int top = stack.peek(), modTop = Math.abs(top), modElement = Math.abs(element);
                    if (top < 0) {
                        stack.push(element);
                        break; //exit the while loop
                    } else if (top > 0) {
                        if (modElement == modTop) {  //in this case pop the stack
                            stack.pop();
                            break;// exit the while loop
                        } else if (modElement < modTop) { //in this case nothing happens
                            break;
                        } else {  //when modElement>modTop, the top element is destroyed
                            stack.pop();
                            if (stack.isEmpty()) {
                                stack.push(element);
                                break;
                            }
                        }
                    }
                }
            }

        }

        int[] resArray=new int[stack.size()];

        //inserting elements in the array
        for(int i=stack.size()-1;i>=0;i--){
            resArray[i]=stack.pop();
        }


        return resArray;
    }
}
