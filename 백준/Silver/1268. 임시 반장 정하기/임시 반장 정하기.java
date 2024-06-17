import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.HashSet;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int i, j, k, max = 0, lea = 1;
        int[][] hak = new int[num][5];
        for(i = 0; i < num; i++){  
            String[] st = br.readLine().split(" ");
            for(j = 0; j < 5; j++){
                hak[i][j] = Integer.parseInt(st[j]); 
            }
        }
        for(i = 0; i < num; i++){
            Set<Integer> set = new HashSet<>();
            for(j = 0; j < 5; j++){
                for(k = 0; k < num; k++){
                    if(i == k)
                        continue;
                    if(hak[i][j] == hak[k][j])
                        set.add(k);
                }
            }
            if(max < set.size()){
                max = set.size();
                lea = i+1;
            }
        }
        System.out.println(lea);       
    }
}