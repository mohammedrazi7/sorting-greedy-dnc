import java.util.Scanner;

class Solution2 {

    // Prints a maximum set of activities that can be done
    // by a single person, one at a time.
    public static void printMaxActivities(int s[], int f[], int n) {
        int i, j;

        System.out.println("Following activities are selected:");

        // The first activity always gets selected
        i = 0;
        System.out.print(i + " ");

        // Consider rest of the activities
        for (j = 1; j < n; j++) {
            // If this activity has start time greater than
            // or equal to the finish time of previously
            // selected activity, then select it
            if (s[j] >= f[i]) {
                System.out.print(j + " ");
                i = j;
            }
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of activities
        System.out.print("Enter the number of activities: ");
        int n = scanner.nextInt();

        int[] s = new int[n]; // Start times
        int[] f = new int[n]; // Finish times

        // Read start times
        System.out.println("Enter the start times of the activities:");
        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextInt();
        }

        // Read finish times
        System.out.println("Enter the finish times of the activities:");
        for (int i = 0; i < n; i++) {
            f[i] = scanner.nextInt();
        }

        // Function call
        printMaxActivities(s, f, n);

        scanner.close();
    }
}
