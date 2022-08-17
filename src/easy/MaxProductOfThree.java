
/* 220816 {@code Codility} Lesson 6 Sorting */
package easy;

/**
 * A non-empty array A consisting of N integers is given. The product of triplet
 * (P, Q, R) equates to {@code A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N) }.
 *
 * For example, array A such that:
 * <pre>
 * A[0] = -3
 * A[1] = 1
 * A[2] = 2
 * A[3] = -2
 * A[4] = 5
 * A[5] = 6
 * contains the following example triplets:
 *
 * (0, 1, 2), product is −3 * 1 * 2 = −6
 * (1, 2, 4), product is 1 * 2 * 5 = 10
 * (2, 4, 5), product is 2 * 5 * 6 = 60
 * Your goal is to find the maximal product of any triplet.
 * </pre>
 *
 * Write a function:
 * <pre>(@code
 * class Solution { public int solution(int[] A); }
 * }
 * </pre> that, given a non-empty array A, returns the value of the maximal
 * product of any triplet.
 *
 * For example, given array A such that:
 * <pre>
 * A[0] = -3
 * A[1] = 1
 * A[2] = 2
 * A[3] = -2
 * A[4] = 5
 * A[5] = 6
 * the function should return 60, as the product of triplet (2, 4, 5) is maximal.
 * </pre>
 *
 * Write an <b>efficient</b> algorithm for the following assumptions:
 * <li>N is an integer within the range [3..100,000];
 * <li>each element of array A is an integer within the range [−1,000..1,000].
 *
 * @author antw
 */
public class MaxProductOfThree {

    // to get 3 normal highest value;
    // to get 2 lowest values (highest negatives)
    // sort element of A to normal highest, and 2 lowest
    // evaluate the maximum positive value from the 2 negatives with 3 normals
    public int solution(int[] A) {

        int buffer, count = 0, lgth = A.length, low0, low1, maxi;

        // just return if onyl 3 integers.
        if (lgth == 3) {
            return A[0] * A[1] * A[2];
        }

        // init with sorted 1st, 2 and 3rd elements
        int[] nor = new int[3];
        for (int i = 0; i < nor.length; i++) {
            nor[i] = A[i];
        }

        sort(nor);

        // init with lowest 1st & 2nd from nor
        low0 = nor[2]; // eg -3
        low1 = nor[1]; // eg -1

        // determine the highest and lowest elements from A
        for (int j = 3; j < lgth; j++) {

            // sorted to nor
            if (A[j] > nor[2]) {
                nor[2] = A[j];
            }

            // also sorted to low0, low1
            if (A[j] < low0) {
                low1 = low0;
                low0 = A[j];
            } else if (A[j] < low1) {
                low1 = A[j];
            }

            sort(nor);
        }

        maxi = nor[0] * nor[1] * nor[2];
        if (maxi < nor[0] * low0 * low1) {
            maxi = nor[0] * low0 * low1;
        }

        return maxi;
    }

    // sort in decending, highest at nor[0]
    public void sort(int[] nor) {
        int count, buffer;
        do {
            count = 0;
            for (int i = 1; i < nor.length; i++) {
                if (nor[i - 1] < nor[i]) {
                    buffer = nor[i - 1];
                    nor[i - 1] = nor[i];
                    nor[i] = buffer;
                    count++;
                }
            }
        } while (count != 0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        MaxProductOfThree m = new MaxProductOfThree();

        data.TestData d = new data.TestData();

        int[] A = {-3, 1, 2, -2, 5, 6};  // 60
        System.out.println("Solution A: " + m.solution(A));
        int[] B = {-5, 5, -5, 4};  // 125
        System.out.println("Solution B: " + m.solution(B));
        int[] C = {1, 2, 3};
        System.out.println("Solution C: " + m.solution(C));
        int[] D = d.evenOdd(999999);
        System.out.println("Solution D: " + m.solution(D));
        int[] E = {-2, -3, -5, -6, 0};  // 0
        System.out.println("Solution E: " + m.solution(E));
        int[] F = {2, 100, 3, -1000};  // 600
        System.out.println("Solution F: " + m.solution(F));
        int[] G = {-5, -6, -4, -7, -10}; // -120
        System.out.println("Solution G: " + m.solution(G));
    }
}
/* Sample dialogue
run-single:
Solution A: 60
Solution B: 125
Solution C: 6
Solution D: 178362656
Solution E: 0
Solution F: 600
Solution G: -120
BUILD SUCCESSFUL (total time: 2 seconds)
 */

 /* CodeCheck Report: 100% 
Analysis summary
The solution obtained perfect score.

Analysis
Detected time complexity:
O(N * log(N))
expand allExample tests
▶example
example test✔OK
expand allCorrectness tests
▶one_triple
three elements✔OK
▶simple1
simple tests✔OK
▶simple2
simple tests✔OK
▶small_random
random small, length = 100✔OK
expand allPerformance tests
▶medium_range
-1000, -999, ... 1000, length = ~1,000✔OK
▶medium_random
random medium, length = ~10,000✔OK
▶large_random
random large, length = ~100,000✔OK
▶large_range
2000 * (-10..10) + [-1000, 500, -1]✔OK
▶extreme_large
(-2, .., -2, 1, .., 1) and (MAX_INT)..(MAX_INT), length = ~100,000✔OK
 */
