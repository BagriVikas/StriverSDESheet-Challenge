import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }

        ArrayList<Integer> ans = majorityElementII(arr);
        ans.forEach(ele -> System.out.print(ele + " "));
    }

    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) {

        ArrayList<Integer> ans = new ArrayList<>();
        int min = arr.size() / 3;

        // to keep track of the frequency of each element
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.size(); i++) {

            if(map.containsKey(arr.get(i)) && map.get(arr.get(i)) == -1) {
                continue;
            }
            map.put(arr.get(i), map.getOrDefault(arr.get(i), 0) + 1);
            if(map.get(arr.get(i)) > min) {
                ans.add(arr.get(i));
                map.put(arr.get(i), -1);
            }

        }

        return ans;

    }

}
