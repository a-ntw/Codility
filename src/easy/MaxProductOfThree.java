
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

    // just return for 3 integers
    // maxi sort array 1 to 4
    // transger to maxi for top 4 maximum value either neg ot pos
    //     change A[i] to posi, and compare to lowest maxi
    // test all results for maximumm value
    public int solution(int[] A) {
        
        int buffer, count = 0, lgth = A.length;

        if (lgth == 3) {
            return A[0] * A[1] * A[2];
        }

        // copy to temp t
        int[] t = new int[4];
        for (int i = 0; i < t.length; i++) {
            t[i] = A[i];
        }

        // sort in decending
        do {
            count = 0;
            for (int i = 1; i < t.length; i++) {
                if (Math.abs(t[i - 1]) < Math.abs(t[i])) {
                    buffer = t[i - 1];
                    t[i - 1] = t[i];
                    t[i] = buffer;
                    count++;
                }
            }
        } while (count != 0);

        // Compare with the rest of array
        for (int j = 4; j < lgth; j++) {
            if (Math.abs(A[j]) > Math.abs(t[3])) {
                t[3] = A[j];
            }

            // do sort ascending for t
            do {
                count = 0;
                for (int i = 1; i < t.length; i++) {
                    if (Math.abs(t[i - 1]) < Math.abs(t[i])) {
                        buffer = t[i - 1];
                        t[i - 1] = t[i];
                        t[i] = buffer;
                        count++;
                    }
                }
            } while (count != 0);
        }

//        // display t
//        for (int a : t) {
//            System.out.print(" " + a);
//        }
//        System.out.println();

        // determine the maximun product from  t
        int maxi = t[0] * t[1] * t[2];
        if (maxi < t[1] * t[2] * t[3]) {
            maxi = t[1] * t[2] * t[3];
        }
        if (maxi < t[0] * t[2] * t[3]) {
            maxi = t[0] * t[2] * t[3];
        }
        if (maxi < t[0] * t[1] * t[3]) {
            maxi = t[0] * t[1] * t[3];
        }
        return maxi;
        
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
        int[] E = {-2, -3, -5, -6, 0};  // 0  <====
        System.out.println("Solution E: " + m.solution(E));
        int[] F = {2, 100, 3, -1000};  // 600
        System.out.println("Solution F: " + m.solution(F));
        
    }
}
/* Sample dialogue
run-single:
Solution A: 60
Solution B: 125
Solution C: 6
Solution D: 178362656
Solution E: -30
Solution F: 600
BUILD SUCCESSFUL (total time: 2 seconds)
*/

/* CodeCheck Report: 66% 
Analysis summary
The following issues have been detected: wrong answers.

For example, for the input [2, 100, 3, -1000] the solution returned a wrong answer 
(got 100000000 expected 600).

For example, for the input [-2, -3, -5, -6, 0] the solution returned a wrong answer 
(got -30 expected 0).

Analysis
expand allExample tests
▶example
example test✔OK
expand allCorrectness tests
▶one_triple
three elements✔OK
▶simple1
simple tests✘WRONG ANSWER
got 84 expected 105
1.0.004 sWRONG ANSWER, got 84 expected 105
2.0.004 sOK
3.0.004 sWRONG ANSWER, got -90 expected 0
4.0.004 sOK
▶simple2
simple tests✘WRONG ANSWER
got -294 expected -120
1.0.004 sOK
2.0.004 sWRONG ANSWER, got -294 expected -120
3.0.008 sWRONG ANSWER, got 100000000 expected 600
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
(-2, .., -2, 1, .., 1) and (MAX_INT)..(MAX_INT), length = ~100,000✘WRONG ANSWER
got -8 expected 4
1.0.220 sWRONG ANSWER, got -8 expected 4
2.0.296 sOK
*/