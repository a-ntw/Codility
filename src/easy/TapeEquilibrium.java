/** 220420
 * Codility Lesson 3 Time Complexity.
 * TapeEquilibrium
 * Minimize the value |(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|.
 * https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 */
package easy;

/**
 *
 * @author antw
 */
public class TapeEquilibrium {

    public int abs(int m) {
        if (m < 0) {
            m = m * -1;
        }
        return m;
    }

    /**
     * . A non-empty array A consisting of N integers is given. Array A
     * represents numbers on a tape. Any integer P, such that 0 < P < N, >>
     * splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and
     * A[P], A[P + 1], ..., A[N − 1]. The difference between the two parts is
     * the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... +
     * A[N − 1])|
     *
     * In other words, it is the absolute difference between the sum of the
     * first part and the sum of the second part. Write a function: class
     * Solution { public int solution(int[] A); } that, given a non-empty array
     * A of N integers, returns the minimal difference that can be achieved.
     *
     * Given a non-empty array A of N integers, returns the minimal difference
     * that can be achieved.
     *
     * @param A
     * @return
     */
    public int solution(int[] A) {
        int minimum;
        int lgth = A.length;
        int diff, sumDiff = 0, middleSum = 0, sumFirst, sumSecond;
        int lowPos = 0, halfPos = lgth / 2 - 1, topPos = lgth - 1, splitPos;

        // only for length 1 or 2
        if (lgth == 2) {
            return abs(A[0] - A[1]);
        }
        if (lgth == 1) {
            return abs(A[0]);
        }

        // sum of diff from index 0 & upper index to splitPos       
        splitPos = halfPos;
        for (int i = lowPos; i <= splitPos; i++) {
            diff = A[i] - A[topPos - i];
            sumDiff += diff;
        }
        
        // sum for lower splitPos to upper splitPos 
        splitPos += 1;
        for (int i = splitPos; i <= (topPos - splitPos); i++) {
            middleSum += A[i];
        }

        sumFirst = abs(sumDiff + middleSum);
        sumSecond = abs(sumDiff - middleSum);
        minimum = sumFirst;
        if (minimum > sumSecond) {
            minimum = sumSecond;
        }

        //  at individual index row, convert diff with sum
        for (int j = halfPos; j > 0; j--) {
            diff = A[j] - A[topPos - j];
            int dSum = A[j] + A[topPos - j];

            sumDiff = sumDiff - diff;
            middleSum = middleSum + dSum;
            
            sumFirst = abs(sumDiff + middleSum);
            sumSecond = abs(sumDiff - middleSum);
            if (minimum > sumFirst) {
                minimum = sumFirst;
            }
            if (minimum > sumSecond) {
                minimum = sumSecond;
            }
        }

        return minimum;
    }

    public static void main(String args[]) {
        TapeEquilibrium c = new TapeEquilibrium();

        int[] A = {3, 1, 2, 4, 3, 3};
        System.out.println("Minimum difference for A: " + c.solution(A));
        int[] B = {3};
        System.out.println("Minimum difference for B: " + c.solution(B));
        int[] C = {-1002, 1002};
        System.out.println("Minimum difference for C: " + c.solution(C));
        int[] D = {333, 331, 332, 334, 333, 333};
        System.out.println("Minimum difference for D: " + c.solution(D));
        int[] E = {-3, -1, -2, -4, -3,};
        System.out.println("Minimum difference for E: " + c.solution(E));
        int[] F = {-3, 2 - 1, -1, 2, -3,};
        System.out.println("Minimum difference for F: " + c.solution(F));
        int[] G = {-10, -20, -30, -40, 100};
        System.out.println("Minimum difference for G: " + c.solution(G));
    }
}
/* Sample Dislogue
run:
Minimum difference for A: 4
Minimum difference for B: 3
Minimum difference for C: 2004
Minimum difference for D: 4
Minimum difference for E: 1
Minimum difference for F: 0
Minimum difference for G: 20
BUILD SUCCESSFUL (total time: 0 seconds)
 */

 /* CodeCheck Report: 100% 
Analysis
Detected time complexity:
O(N)
expand allExample tests
▶ example 
example test ✔OK
expand allCorrectness tests
▶ double 
two elements ✔OK
▶ simple_positive 
simple test with positive numbers, length = 5 ✔OK
▶ simple_negative 
simple test with negative numbers, length = 5 ✔OK
▶ simple_boundary 
only one element on one of the sides ✔OK
▶ small_random 
random small, length = 100 ✔OK
▶ small_range 
range sequence, length = ~1,000 ✔OK
▶ small 
small elements ✔OK
expand allPerformance tests
▶ medium_random1 
random medium, numbers from 0 to 100, length = ~10,000 ✔OK
▶ medium_random2 
random medium, numbers from -1,000 to 50, length = ~10,000 ✔OK
▶ large_ones 
large sequence, numbers from -1 to 1, length = ~100,000 ✔OK
▶ large_random 
random large, length = ~100,000 ✔OK
▶ large_sequence 
large sequence, length = ~100,000 ✔OK
▶ large_extreme 
large test with maximal and minimal values, length = ~100,000 ✔OK
1. 0.232 s OK
2. 0.240 s OK
3. 0.192 s OK

ref:  https://app.codility.com/programmers/
 */
