import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Task5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        long n = Long.parseLong(line1[0]);//students
        long k = Long.parseLong(line1[1]);//programs

        String[] line2 = br.readLine().split(" ");
        int[] remains = new int[(int) k];
        for (int i = 0; i < k; i++) {
            remains[i] = Integer.parseInt(line2[i]);
        }
        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] currLine = br.readLine().split(" ");
            int rating = Integer.parseInt(currLine[0]);
            int s = Integer.parseInt(currLine[1]);
            ArrayList<Integer> programs = new ArrayList<>();
            for (int j = 0; j < s; j++) {
                programs.add(Integer.valueOf(currLine[j + 2]));
            }
            students.add(new Student(rating, s, programs, i));
        }

        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.rating - s2.rating;
            }
        });

        for (int i = 0; i < students.size(); i++) {
            Student currStud = students.get(i);
            for (int j = 0; j < currStud.programs.size(); j++) {
                if (remains[currStud.programs.get(j) - 1] != 0) {
                    currStud.resProgram = currStud.programs.get(j);
                    remains[currStud.programs.get(j) - 1]--;
                    break;
                }
            }
        }

        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.order - s2.order;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Student student: students) {
            sb.append(student.resProgram);
            sb.append(" ");
        }
        sb.trimToSize();
        System.out.println(sb);
    }

    public static class Student {
        int rating;
        int s;
        ArrayList<Integer> programs;
        int order;
        int resProgram;

        public Student(int rating, int s, ArrayList<Integer> programs, int order) {
            this.rating = rating;
            this.s = s;
            this.programs = programs;
            this.order = order;
            this.resProgram = -1;
        }
    }
}
