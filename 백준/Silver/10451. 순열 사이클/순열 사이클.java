import java.util.*;
public class Main {
    static ArrayList<Integer>[] arr=new ArrayList[1001];
    static boolean[] check;
    
    static int dfs(int v){
        if(check[v]) return -1;
        check[v]=true;
        dfs(arr[v].get(0));
        return v;
    }
    public static void main(String args[]) {
        Scanner s=new Scanner(System.in);
        for(int i=0;i<arr.length;i++) arr[i]=new ArrayList();
        int t=s.nextInt();
        while(t-->0){
            for(int i=0;i<arr.length;i++) arr[i].clear();
            check=new boolean[1001];
            int n=s.nextInt();
            for(int i=1;i<=n;i++) arr[i].add(s.nextInt());
            
            int count=0;
            for(int i=1;i<=n;i++){
                if(i==dfs(i)) count++;
            }
            System.out.println(count);
        }
    }
}