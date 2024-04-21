import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int[] arr = new int[4];

        int n1= sc.nextInt();
        int n2= sc.nextInt();

        arr[0] = n2;

        for(int i = 1; i<4;i++){
            arr[i] = arr[i-1]-sc.nextInt()+sc.nextInt();
        }

        for(int i = 0; i<arr.length;i++){
            for(int j = 0; j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(arr[3]);
    }
}