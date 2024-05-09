    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] arr = new int[5];
            for(int i=0; i<5; i++){
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);
            int result = 0;
            for(int a : arr){
                result += a;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(result/5).append('\n');
            sb.append(arr[2]);
            System.out.println(sb);
        }

    }