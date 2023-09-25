import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        long k = Long.parseLong(line1[0]);
        long n = Long.parseLong(line1[1]);
        long m = Long.parseLong(line1[2]);

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            String[] curr = br.readLine().split(" ");
            if (map.get(Integer.parseInt(curr[1])) == null) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(Integer.valueOf(curr[0]));
                map.put(Integer.parseInt(curr[1]), list);
            } else {
                map.get(Integer.parseInt(curr[1])).add(Integer.parseInt(curr[0]));
            }
        }

        int sadness = 0;
        while (m != 0) {
            findMax(map);
            m--;
        }

    }

    public static int findMax(HashMap<Integer, ArrayList<Integer>> map) {
        int ans = 0;
        int markedKey = 0;
        for (Integer key: map.keySet()) {
            if (map.get(key).size() == 1) {
                continue;
            }
            for (int i = 0; i < map.get(key).size() - 1; i++) {
                if (map.get(key).get(i + 1) - map.get(key).get(i) > ans) {
                    ans = map.get(key).get(i + 1) - map.get(key).get(i);
                    markedKey = key;
                }
            }
        }
        map.keySet().remove(markedKey);
        return ans;
    }
    public void int findSadness(HashMap<Integer, ArrayList<Integer>> map) {
        int sadness = 0;
        for (Integer key: map.keySet()) {
            
        }
    }
}
