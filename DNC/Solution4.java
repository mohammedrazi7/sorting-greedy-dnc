import java.util.*;

class Solution4 {
    // Check whether any permutation exists which satisfies the condition.
    static boolean isPossible(Integer a[], int b[], int n, int k) {
        // Sort the array a[] in decreasing order.
        Arrays.sort(a, Collections.reverseOrder());

        // Sort the array b[] in increasing order.
        Arrays.sort(b);

        // Checking the condition on each index.
        for (int i = 0; i < n; i++)
            if (a[i] + b[i] < k)
                return false;

        return true;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the value of k
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        // Input the size of arrays
        System.out.print("Enter the number of elements in the arrays: ");
        int n = scanner.nextInt();

        // Input the elements of array a
        Integer[] a = new Integer[n];
        System.out.println("Enter the elements of array a:");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // Input the elements of array b
        int[] b = new int[n];
        System.out.println("Enter the elements of array b:");
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        // Check if the condition is satisfied
        if (isPossible(a, b, n, k))
            System.out.println("Yes");
        else
            System.out.println("No");

        // Close the scanner
        scanner.close();
    }
}
