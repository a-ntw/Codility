/** 220419
 * Codility Lesson 3 Time Complexity. 
 * PermCheck
 * Check whether array A is a permutation.
 */
package easy;

/**
 *
 * @author antw
 */
public class PermCheck {

    /**
     * . A non-empty array A consisting of N integers is given.
     *
     * A permutation is a sequence containing each element from 1 to N once, and
     * only once. The goal is to check whether array A is a permutation.
     *
     * Given an array A, returns 1 if array A is a permutation and 0 if it is
     * not.
     *
     * @param A
     * @return
     */
    public int solution(int[] A) {
        int lgth = A.length, iLowStore = 0, p = 1, iHighStore = lgth;
        //int count = 0;

        doWhile:
        while (true) {

            for (int i = iLowStore; i < iHighStore; i++) {
                //count++;
                if (p == A[i]) {
                    if (p == A[iLowStore]) {
                        iLowStore++;
                    } else if (p == A[iHighStore - 1]) {
                        iHighStore--;
                    }

                    if (p >= lgth) {
                        //System.out.print (" count:" + count + " >> ");
                        return 1;
                    }

                    p++;
                    continue doWhile;
                }
            }

            //System.out.print(" count:" + count + " >> ");
            return 0;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        PermCheck c = new PermCheck();
        int[] A = {4, 1, 3, 2}; //  result: 1
        System.out.println("A result: " + c.solution(A));
        int[] B = {4, 1, 3};  // result: 0
        System.out.println("B result: " + c.solution(B));
        int[] G = {2, 2, 2};  // result: 0
        System.out.println("G result: " + c.solution(G));
        int[] C = {3};  // 
        System.out.println("C result: " + c.solution(C));
        int[] D = {3, 3};
        System.out.println("D result: " + c.solution(D));
        int[] E = {2, 3, 4};
        System.out.println("E result: " + c.solution(E));
        int[] F = {9, 8, 7, 6, 5, 1, 2, 3, 4};
        System.out.println("F result: " + c.solution(F));
        int[] H = {1, 2, 2, 2, 3, 7, 4, 6, 5};
        System.out.println("H result: " + c.solution(H));
    }
}

/* Sample Dialogue
run:
A result: 1
B result: 0
G result: 0
C result: 0
D result: 0
E result: 0
F result: 1
H result: 1
BUILD SUCCESSFUL (total time: 0 seconds)
 */

 /* CodeCheck Report: 75% 
medium_permutation 
permutation + few elements occur twice, N = ~10,000
1. 0.660 s TIMEOUT ERROR,  running time: 0.660 sec., time limit: 0.112 sec.
2. 0.660 s TIMEOUT ERROR,  running time: 0.660 sec., time limit: 0.112 sec.

large_not_permutation 
permutation + one element occurs three times, N = ~100,000

1. 6.000 s TIMEOUT ERROR,  Killed. Hard limit reached: 6.000 sec.
2. 6.000 s TIMEOUT ERROR,  Killed. Hard limit reached: 6.000 sec.

various_permutations 
all sequences are permutations
1. 0.004 s OK
2. 0.004 s OK
3. 0.660 s TIMEOUT ERROR,  running time: 0.660 sec., time limit: 0.112 sec.
4. 0.252 s OK
5. 6.000 s TIMEOUT ERROR,  Killed. Hard limit reached: 6.000 sec.
 */
