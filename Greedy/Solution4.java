import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution4 {

    public static int minRemovals(List<int[]> ranges) {
        int size = ranges.size(), rem = 0;

        if (size <= 1)
            return 0;

        // Sort by minimum starting point
        Collections.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int end = ranges.get(0)[1];
        for (int i = 1; i < ranges.size(); i++) {
            // If the current starting point is less than
            // the previous interval's ending point (i.e., there is an overlap)
            if (ranges.get(i)[0] < end) {
                // Increase removals count
                rem++;
                // Remove the interval with the higher ending point
                end = Math.min(ranges.get(i)[1], end);
            } else {
                end = ranges.get(i)[1];
            }
        }

        return rem;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of intervals
        System.out.print("Enter the number of intervals: ");
        int n = scanner.nextInt();

        List<int[]> input = new ArrayList<>();

        // Read intervals
        System.out.println("Enter the intervals (start end) for each interval:");
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            input.add(new int[] { start, end });
        }

        // Compute and print the result
        System.out.println("Minimum number of removals: " + minRemovals(input));

        scanner.close();
    }
}
