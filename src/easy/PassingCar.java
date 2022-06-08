/** 220509
 * Codility Lesson 5 Prefix Sums.
 * PassingCar
 */
package easy;

/**
 *
 * @author antw
 */
public class PassingCar {

    /**
     * . A non-empty array A consisting of N integers is given. The consecutive
     * elements of array A represent consecutive cars on a road.
     *
     * Array A contains only 0s and/or 1s: * 0 represents a car traveling east,
     * *1 represents a car traveling west. The goal is to count passing cars. We
     * say that a pair of cars (P, Q), where 0 ≤ P < Q < N,>, is passing when P
     * is traveling to the east and Q is traveling to the west.
     *
     * @param A given a non-empty array A of N integers. N is an integer within
     * the range [1..100,000]; each element of array A is an integer that can
     * have one of the following values: 0, 1.
     * @return the number of pairs of passing cars.
     */
    public int solution(int[] A) {

        int lgth = A.length, west = 0, pair = 0;

        if (lgth < 2) {
            return 0;
        }

        if (lgth == 2) {
            if ((A[0] == 0) && (A[1] == 1)) {
                return 1;
            } else {
                return 0;
            }
        }

        for (int i = lgth - 1; i >= 0; i--) {
            if (A[i] == 1) {
                west++;
            } else if (A[i] == 0) {
                pair += west;
            }

            if (pair > 1000000000) {
                return -1;
            }
        }

        return pair;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        PassingCar c = new PassingCar();

        int[] B = {0};
        System.out.println("B: " + c.solution(B));
        int[] C = {0, 1};
        System.out.println("C: " + c.solution(C));
        int[] A = {0, 1, 0, 1, 1};
        System.out.println("A: " + c.solution(A));
    }
}

/** Sample Dialogue
run:
B: 0
C: 1
A: 5
BUILD SUCCESSFUL (total time: 0 seconds)
 */

/* CodeCheck Report: 90%
Analysis
Detected time complexity:
O(N)
expand allExample tests
▶example
example test✔OK
expand allCorrectness tests
▶single
single element✔OK
▶double
two elements✔OK
▶simple
simple test✔OK
▶small_random
random, length = 100✔OK
▶small_random2
random, length = 1000✔OK
collapse allPerformance tests
▶medium_random
random, length = ~10,000✔OK
1.0.024 sOK
▶large_random
random, length = ~100,000✔OK
1.0.152 sOK
▶large_big_answer
0..01..1, length = ~100,000✔OK
1.0.156 sOK
2.0.112 sOK
▶large_alternate
0101..01, length = ~100,000✔OK
1.0.156 sOK
2.0.144 sOK
▶large_extreme
large test with all 1s/0s, length = ~100,000✔OK
1.0.156 sOK
2.0.152 sOK
3.0.156 sOK

ref:  https://app.codility.com/programmers/
 */
