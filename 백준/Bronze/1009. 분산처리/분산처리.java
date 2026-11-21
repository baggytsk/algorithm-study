import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = 1;
            int base = a % 10;
            int exp = b % 4 == 0 ? 4 : b % 4;

            for (int j = 0; j < exp; j++) {
                result = (result * base) % 10;
            }

            sb.append(result == 0 ? 10 : result).append('\n');
        }

        System.out.print(sb);
    }
}