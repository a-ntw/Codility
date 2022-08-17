
/* 220503 {@code Codility} Lesson 6 Sorting */
package easy;

/**
 * Write a function
 * <blockquote>{@code
 *      class Solution { public int solution(int[] A); }
 * }</blockquote>
 * that, given an array A consisting of N integers, returns the number of
 * distinct values in array A.
 * <p>
 * For example, given array A consisting of six elements such that:
 * <blockquote>{@code
 *      A[0] = 2    A[1] = 1    A[2] = 1
 *      A[3] = 2    A[4] = 3    A[5] = 1
 * }</blockquote>
 * the function should return 3, because there are 3 distinct values appearing
 * in array A, namely 1, 2 and 3.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * <ul><li>N is an integer within the range {@code [0..100,000]};
 * <li>each element of array A is an integer within the range
 * {@code [−1,000,000..1,000,000]} .</ul>
 *
 * @author antw
 */
public class Distinct {

    /**
     * To returns the number of distinct values in array A.
     *
     * @param A Array A
     * @return numbers of distinct.
     */
    public int solution(int[] A) {

        int lgth = A.length, numDistinct = 0, min, max, arrayBLgth;

        // if A array is either 1 ot zero
        if (lgth < 2) {
            return lgth;
        }

        // search for max and min of A
        min = A[0];
        max = A[0];
        for (int i = 0; i < lgth; i++) {
            if (A[i] < min) {
                min = A[i];
            }
            if (A[i] > max) {
                max = A[i];
            }
        }

        arrayBLgth = max - min + 1;
        byte[] B = new byte[arrayBLgth];

        // sorting A to B array. 1 for present of A value
        for (int i = 0; i < lgth; i++) {
            B[A[i] - min] = 1;
        }

        // count no of distincts
        for (int b = 0; b < arrayBLgth; b++) {
            if (B[b] == 1) {
                numDistinct++;
            }
        }

        return numDistinct;
    }

    /**
     * main.
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        Distinct c = new Distinct();
        data.TestData d = new data.TestData();

        int[] A = {2, 1, 1, -10000000, 3, 10000000};
        System.out.println("Solution A: " + c.solution(A));
        int[] B = {2, 1};
        System.out.println("Solution B: " + c.solution(B));
        int[] C = d.endPairOdd(999999);
        System.out.println("Solution C: " + c.solution(C));
        int[] D = d.evenOdd(999999);
        System.out.println("Solution D: " + c.solution(D));
        int[] E = {-1, -2, -3, -1, -2};
        System.out.println("Solution E: " + c.solution(E));
    }
}
/* Sample dialogue
run:
Solution A: 5
Solution B: 2
Solution C: 500000
Solution D: 500000
Solution E: 3
BUILD SUCCESSFUL (total time: 0 seconds)
 */
 /* CodeCheck Report: 100% 
Analysis
Detected time complexity:
O(N*log(N)) or O(N)
expand allExample tests
▶ example1 
example test, positive answer ✔OK
expand allCorrectness tests
▶ extreme_empty 
empty sequence ✔OK
▶ extreme_single 
sequence of one element ✔OK
▶ extreme_two_elems 
sequence of three distinct elements ✔OK
▶ extreme_one_value 
sequence of 10 equal elements ✔OK
▶ extreme_negative 
sequence of negative elements, length=5 ✔OK
▶ extreme_big_values 
sequence with big values, length=5 ✔OK
▶ medium1 
chaotic sequence of value sfrom [0..1K], length=100 ✔OK
▶ medium2 
chaotic sequence of value sfrom [0..1K], length=200 ✔OK
▶ medium3 
chaotic sequence of values from [0..10], length=200 ✔OK
collapse allPerformance tests
▶ large1 
chaotic sequence of values from [0..100K], length=10K ✔OK
1. 0.028 s OK
▶ large_random1 
chaotic sequence of values from [-1M..1M], length=100K ✔OK
1. 0.296 s OK
▶ large_random2 
another chaotic sequence of values from [-1M..1M], length=100K ✔OK
1. 0.300 s OK
 */