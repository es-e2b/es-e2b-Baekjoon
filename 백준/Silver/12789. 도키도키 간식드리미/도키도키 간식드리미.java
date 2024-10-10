import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack2 = new Stack<>();
        int x = Integer.parseInt(bf.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st  = new StringTokenizer(bf.readLine() ," ");
        for (int i = 0; i < x; i++) {
            queue.add( Integer.parseInt(st.nextToken()));
        }
        int index = 1;
        while (!queue.isEmpty()) {
            if(queue.peek() == index){
                queue.poll();
                index ++;
            }
            else if(!stack2.isEmpty()){
                if(stack2.peek()==index){
                    stack2.pop();
                    index++;
                }
                else{
                    stack2.push(queue.poll());
                }
            }
            else{
                stack2.push(queue.poll());
            }
        }

        while (!stack2.isEmpty()) {
            if(index == stack2.peek()){
                stack2.pop();
                index++;
            }
            else{
                break;
            }
        }
        if(stack2.isEmpty() ){
            System.out.println("Nice");
        } 
        else{
            System.out.println("Sad");
        }
        
    }
}