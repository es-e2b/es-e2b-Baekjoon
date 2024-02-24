import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alphabetCountArr = new int[26];

        // 입력된 알파벳 만큼 배열 카운터 증가
        br.readLine().chars().filter(i->(i>='a'&&i<='z')).forEach(i -> alphabetCountArr[(char) i - 'a']++);

        // 문자열빌더 선언
        StringBuilder stringBuilder = new StringBuilder();

        // 문자열빌더에 입력된 카운터와 " " 추가
        Arrays.stream(alphabetCountArr).forEach(counter -> stringBuilder.append(counter).append(" "));

        // 마지막 값 " " 제거
        stringBuilder.setLength(stringBuilder.length() - 1);

        // 출력
        System.out.print(stringBuilder);
    }
}