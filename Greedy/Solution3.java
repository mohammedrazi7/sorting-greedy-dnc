import java.util.Scanner;

public class Solution3 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += gas[i] - cost[i];

            // If currentGas is negative, reset the start index to the next station
            if (currentGas < 0) {
                startIndex = i + 1;
                currentGas = 0;
            }
        }

        // If total gas is less than total cost, return -1
        if (totalGas < totalCost) {
            return -1;
        }

        return startIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of stations
        System.out.print("Enter the number of stations: ");
        int n = scanner.nextInt();

        int[] gas = new int[n];
        int[] cost = new int[n];

        // Read the gas array
        System.out.println("Enter the gas amounts for each station:");
        for (int i = 0; i < n; i++) {
            gas[i] = scanner.nextInt();
        }

        // Read the cost array
        System.out.println("Enter the cost amounts for each station:");
        for (int i = 0; i < n; i++) {
            cost[i] = scanner.nextInt();
        }

        // Create an instance of the GasStation class and call the method
        Solution3 solution = new Solution3();
        int result = solution.canCompleteCircuit(gas, cost);

        // Output the result
        if (result == -1) {
            System.out.println("It is not possible to complete the circuit.");
        } else {
            System.out.println("Starting index: " + result);
        }

        scanner.close();
    }
}
