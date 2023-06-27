import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static List<List<Integer>> findCombinations(int[] arr, int target) {
        Map<Integer, Integer> complementMap = new HashMap<>();
        List<List<Integer>> firstCombinations = new ArrayList<>();

        // Finding the first combination
        for (int num : arr) {
            int complement = target - num;
            if (complementMap.containsKey(complement)) {
                firstCombinations.add(Arrays.asList(num, complement));
            } else {
                complementMap.put(num, complement);
            }
        }

        Arrays.sort(arr);
        int[] mergedArray = arr.clone();
        int doubledTarget = target * 2;
        List<List<Integer>> secondCombinations = new ArrayList<>();

        // Finding the second combination
        for (int num : mergedArray) {
            int complement = doubledTarget - num;
            if (complementMap.containsKey(complement)) {
                secondCombinations.add(Arrays.asList(num, complement));
            }
        }

        return secondCombinations;
    }

    public static void main(String[] args) {
        int[] inputArray = {1, 3, 2, 2, -4, -6, -2, 8};
        int targetValue = 4;

        List<List<Integer>> firstComb = findCombinations(inputArray, targetValue);

        System.out.println("First Combination For " + targetValue + ": " + firstComb);

        int[] mergedArray = Arrays.copyOf(inputArray, inputArray.length);
        Arrays.sort(mergedArray);
        System.out.println("Merge Into a single Array: " + Arrays.toString(mergedArray));

        int doubledTarget = targetValue * 2;
        List<List<Integer>> secondComb = findCombinations(mergedArray, doubledTarget);
        System.out.println("Second Combination For " + doubledTarget + ": " + secondComb);
    }
}
