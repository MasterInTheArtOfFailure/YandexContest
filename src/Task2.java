import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int k = Integer.parseInt(line1[1]);

        String[] line2 = br.readLine().split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < line2.length; i++) {
            list.add(Integer.parseInt(line2[i]));
        }
        Collections.sort(list);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            int rightIndex = n - k + i - 1;
            int currDiff = list.get(rightIndex) - list.get(i);
            if (currDiff < minDiff) {
                minDiff = currDiff;
            }
        }
        System.out.println(minDiff);
    }
}