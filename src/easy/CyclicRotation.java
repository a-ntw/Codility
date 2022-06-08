/** 220415
 * Codility Lesson 2 Arrays.
 * CyclicRotation
 * Rotate an array to the right by a given number of steps.
 * https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 */
package easy;

/**
 *
 * @author antw
 */
public class CyclicRotation {

    /**
     * . An array A consisting of N integers is given. Rotation of the array
     * means that each element is shifted right by one index, and the last
     * element of the array is moved to the first place. For example, the
     * rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are
     * shifted right by one index and 6 is moved to the first place).
     *
     * The goal is to rotate array A K times; that is, each element of A will be
     * shifted to the right K times.
     *
     * Given an array A consisting of N integers and an integer K, returns the
     * array A rotated K times.
     *
     * @param A
     * @param K
     * @return
     */
    public int[] solution(int[] A, int K) {

        int lgth = A.length;

        // if single or empty just return A
        if (lgth <= 1) {
            return A;
        }

        // if K > lgth, then use the remainder
        K = K % lgth;

        int[] buffer = new int[K];

        // store upper index to buffer
        for (int i = 0; i < K; i++) {
            buffer[i] = A[lgth - K + i];
        }

        // copy lower int to rotated int
        int index = lgth - K - 1;
        for (int j = index; j >= 0; j--) {
            A[j + K] = A[j];
        }

        // copy buffer to next index
        for (int z = 0; z < K; z++) {
            A[z] = buffer[z];
        }

        return A;
    }

    public void pritnArray(int[] rotated) {
        for (int a : rotated) {
            System.out.print(" " + a + " ");
        }
        System.out.println("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        CyclicRotation c = new CyclicRotation();
        int[] rotated;

        int[] A = {3, 8, 9, 7, 6};
        c.pritnArray(A);
        rotated = c.solution(A, 3);
        c.pritnArray(rotated);

        int[] B = {1, 2, 3, 4};
        c.pritnArray(B);
        rotated = c.solution(B, 4);
        c.pritnArray(rotated);

        int[] C = {0, 0, 0};
        c.pritnArray(c.solution(C, 1));
        int[] D = {};
        c.pritnArray(c.solution(D, 1));
        int[] E = {1};
        c.pritnArray(c.solution(E, 1));
        int[] F = {1, 2, 3, 4, 5, 6, 7};
        c.pritnArray(c.solution(F, 2));
        int[] G = {-4, 4, 6, 0, 0, -2, 10, -4};
        c.pritnArray(c.solution(G, 1));
        int[] H = {1, 1, 2, 3, 5};
        c.pritnArray(c.solution(H, 42));
    }
}

/* Sample Dialogue
run:
 3  8  9  7  6 
 9  7  6  3  8 
 1  2  3  4 
 1  2  3  4 
 0  0  0 

 1 
 6  7  1  2  3  4  5 
 -4  -4  4  6  0  0  -2  10 
 3  5  1  1  2 
BUILD SUCCESSFUL (total time: 0 seconds)
 */

 /* CodeCheck Report: 100% 
Analysis
expand allExample tests
▶example
first example test✔OK
▶example2
second example test✔OK
▶example3
third example test✔OK
expand allCorrectness tests
▶extreme_empty
empty array✔OK
▶single
one element, 0 <= K <= 5✔OK
▶double
two elements, K <= N✔OK
▶small1
small functional tests, K < N✔OK
▶small2
small functional tests, K >= N✔OK
▶small_random_all_rotations
small random sequence, all rotations, N = 15✔OK
▶medium_random
medium random sequence, N = 100✔OK
▶maximal
maximal N and K✔OK
1.0.008 sOK
2.0.012 sOK
3.0.012 sOK
4.0.012 sOK

ref:  https://app.codility.com/programmers/
 */
