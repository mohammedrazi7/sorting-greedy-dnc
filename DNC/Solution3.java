import java.util.Scanner;

class Solution3 {

    // Function to rotate subarray from index l to r
    static int[] rotateSubArray(int[] arr, int l, int r) {
        int temp = arr[r];
        for (int j = r; j > l - 1; j--) {
            arr[j] = arr[j - 1];
        }
        arr[l] = temp;

        return arr;
    }

    // Function to move negative numbers to the left while maintaining the order
    static int[] moveNegative(int[] arr) {
        int last_negative_index = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                last_negative_index += 1;
                int temp = arr[i];
                arr[i] = arr[last_negative_index];
                arr[last_negative_index] = temp;

                // Done to manage order too
                if (i - last_negative_index >= 2)
                    rotateSubArray(arr, last_negative_index + 1, i);
            }
        }

        return arr;
    }

    // Driver Code
    public static void main(String args[]) {
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

        // Move negative numbers and maintain the order
        arr = moveNegative(arr);

        // Print the resulting array
        System.out.println("Array after moving negative numbers:");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        // Close the scanner
        scanner.close();
    }
}
