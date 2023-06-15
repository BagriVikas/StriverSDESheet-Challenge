import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Triplet{

    int start;
    int end;
    int index;

    public Triplet(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

}

class MyComparator implements Comparator<Triplet> {


    @Override
    public int compare(Triplet o1, Triplet o2) {
        return o1.end - o2.end;
    }
}

public class Solution {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int start[] = new int[n];
        int end[] = new int[n];
        for(int i = 0; i < n; i++) {
            start[i] = scanner.nextInt();
        }
        for(int i = 0; i < n; i++) {
            end[i] = scanner.nextInt();
        }
        List<Integer> ans = maximumMeetings(start, end);
        ans.forEach(meeting -> System.out.print(meeting + " "));

    }

    public static List<Integer> maximumMeetings(int start[], int end[]) {

        // Step 1: Create a list of triplets [start, end, index]
        List<Triplet> list = new ArrayList<>();

        for(int i = 0; i < start.length; i++) {
            list.add(new Triplet(start[i], end[i], i + 1));
        }

        // Step 2: Sort the list according the end time
        Collections.sort(list, new MyComparator());

        // Step 3: Schedule the meetings with the less time first
        //         without colliding with the previous meeting
        int prevTime = -1;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {

            int startTime = list.get(i).start;
            if(startTime > prevTime) {
                // schedule meeting
                ans.add(list.get(i).index);
                prevTime = list.get(i).end;
            }

        }

        return ans;

    }

}
