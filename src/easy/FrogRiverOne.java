/** 220419
 * Codility Lesson 3 Time Complexity. 
 * FrogRiverOne
 * Find the earliest time when a frog can jump to the other side of a river.
 *
 */
package easy;

/**
 *
 * @author antw
 */
public class FrogRiverOne {

    /**
     * . A small frog wants to get to the other side of a river. The frog is
     * initially located on one bank of the river (position 0) and wants to get
     * to the opposite bank (position X+1). Leaves fall from a tree onto the
     * surface of the river.
     *
     * You are given an array A consisting of N integers representing the
     * falling leaves. A[K] represents the position where one leaf falls at time
     * K, measured in seconds. The goal is to find the earliest time when the
     * frog can jump to the other side of the river. The frog can cross only
     * when leaves appear at every position across the river from 1 to X (that
     * is, we want to find the earliest moment when all the positions from < 1 to X
     * > are covered by leaves). You may assume that the speed of the current in
     * the river is negligibly small, i.e. the leaves do not change their
     * positions once they fall in the river.
     *
     * Given a non-empty array A consisting of N integers and integer X, returns
     * the earliest time when the frog can jump to the other side of the river.
     *
     * If the frog is never able to jump to the other side of the river, the
     * function should return −1.
     *
     * @param X
     * @param A
     * @return
     */
    public int solution(int X, int[] A) {

        int result = -1, indexStart = 0, lgth = A.length;

        for (int k = 1; k <= X; k++) {
            int i = indexStart;
            while (true) {

                if (i >= lgth) {
                    if (k <= X) {
                        return -1;
                    } else {
                        return result;
                    }
                } else if (A[i] == k) {
                    if (A[indexStart] == k) {
                        indexStart++;
                    }

                    if (result < i) {
                        result = i;
                    }

                    break;
                }

                i++;
            }

        }

        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        FrogRiverOne c = new FrogRiverOne();

        int x = 5;
        int[] A = {1, 3, 1, 4, 2, 3, 5, 4}; // result 6
        System.out.println("A result: " + c.solution(x, A));
        x = 6;
        System.out.println("A result: " + c.solution(x, A));
        x = 5;
        int[] B = {};
        System.out.println("B result: " + c.solution(x, B));
        x = 5;
        int[] C = {5};
        System.out.println("C result: " + c.solution(x, C));
        x = 3;
        int[] D = {1, 3, 1, 3, 2, 1, 3}; // result 4
        System.out.println("D result: " + c.solution(x, D));
        x = 2;
        int[] E = {2, 2, 2, 2, 2, 2}; // result -1
        System.out.println("E result: " + c.solution(x, E));
        x = 5;
        int[] F = {1, 2, 3, 5, 3, 1}; //  result -1
        System.out.println("F result: " + c.solution(x, F));

    }
}
/* Sample Dialogue
run:
A result: 6
A result: -1
B result: -1
C result: -1
D result: 4
E result: -1
F result: -1
BUILD SUCCESSFUL (total time: 0 seconds)
 */

 /* CodeCheck Report: 63%
medium_random 
6 and 2 random permutations, X = ~5,000
1. 0.140 s OK
2. 0.244 s TIMEOUT ERROR,  running time: 0.244 sec., time limit: 0.112 sec.

medium_range 
arithmetic sequences, X = 5,000
1. 0.080 s OK

large_random 
10 and 100 random permutation, X = ~10,000
1. 1.416 s was TIMEOUT ERROR,  running time: 1.416 sec., time limit: 0.896 sec.
2. 0.212 s OK

large_permutation 
permutation tests
1. 6.000 s TIMEOUT ERROR,  Killed. Hard limit reached: 6.000 sec.
2. 0.248 s OK

large_range 
arithmetic sequences, X = 30,000
1. 0.912 s TIMEOUT ERROR,  running time: 0.912 sec., time limit: 0.400 sec.
 */
