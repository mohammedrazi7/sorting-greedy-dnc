import java.io.*;
import java.util.*;

class Solution5 {

    // An interval has start time and end time
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // Function to check if any two intervals overlap
    static boolean isIntersect(Interval arr[], int n) {
        // Sort intervals in increasing order of start time
        Arrays.sort(arr, (i1, i2) -> i1.start - i2.start);

        // In the sorted array, if start time of an interval
        // is less than end of previous interval, then there
        // is an overlap
        for(int i = 1; i < n; i++) {
            if (arr[i - 1].end > arr[i].start)
                return true;
        }

        // If we reach here, then no overlap
        return false;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of intervals: ");
        int n = scanner.nextInt();

        Interval[] intervals = new Interval[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the start and end time of interval " + (i + 1) + ": ");
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            intervals[i] = new Interval(start, end);
        }

        if (isIntersect(intervals, n))
            System.out.print("Yes\n");
        else
            System.out.print("No\n");

        scanner.close();
    }
}
