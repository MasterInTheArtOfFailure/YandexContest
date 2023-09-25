import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Task1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.valueOf(Long.parseLong(br.readLine()));//ports
        long m = Long.valueOf(Long.parseLong(br.readLine()));
        long c2 = Long.valueOf(Long.parseLong(br.readLine()));
        long c5 = Long.valueOf(Long.parseLong(br.readLine()));
        long minCost = 0;

        if (m <= n ) {

        } else {
            long diff = m - n;
            if (c2 * 4 < c5) {
                minCost = diff * c2;
            } else if (c2 * (diff % 4) < c5) {
                minCost = (diff / 4) * c5 + (diff % 4) * c2;
            } else {
                minCost = (diff / 4) * c5 + c5;
            }
        }
        System.out.println(minCost);
    }
}
