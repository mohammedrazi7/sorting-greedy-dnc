import java.util.Scanner;

class Solution1 {

    // This function sorts an array
    // that can be sorted by a single swap
    static void sortByOneSwap(int arr[], int n) {
        // Traverse the given array from rightmost side
        for (int i = n - 1; i > 0; i--) {
            // Check if arr[i] is not in order
            if (arr[i] < arr[i - 1]) {
                // Find the other element to be swapped with arr[i]
                int j = i - 1;
                while (j >= 0 && arr[i] < arr[j])
                    j--;

                // Swap the pair
                int temp = arr[i];
                arr[i] = arr[j + 1];
                arr[j + 1] = temp;

                break;
            }
        }
    }

    // A utility function to print an array of size n
    static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver Code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of elements
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        // Read the array elements
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Given array is:");
        printArray(arr, n);

        sortByOneSwap(arr, n);

        System.out.println("Sorted array is:");
        printArray(arr, n);

        scanner.close();
    }
}
