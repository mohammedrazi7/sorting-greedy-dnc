import java.util.Scanner;

class Solution2{
    // Function to move all negative numbers to the beginning
    // and positive numbers to the end while keeping the order
    static void segregate(int arr[], int n) {
        // Count negative numbers
        int count_negative = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                count_negative++;
            }
        }

        // Run a loop until all negative numbers are moved to the beginning
        int i = 0, j = i + 1;
        while (i != count_negative) {
            // If number is negative, update position of the next positive number
            if (arr[i] < 0) {
                i++;
                j = i + 1;
            }
            // If number is positive, move it to index j and increment j
            else if (arr[i] > 0 && j < n) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                j++;
            }
        }
    }

    // Driver code with dynamic input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of elements
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Read the array elements
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Call the function to segregate the array
        segregate(arr, n);

        // Print the result
        System.out.println("Array after segregation:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Close the scanner
        scanner.close();
    }
}
