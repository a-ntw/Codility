/** 220417
 * Codility Lesson 3 Time Complexity.
 * PermMissingElem
 * Find the missing element in a given permutation.
 */
package easy;

/**
 *
 * @author antw
 */
public class PermMissingElem {

    /**
     * . An array A consisting of N different integers is given. The array
     * contains integers in the range [1..(N + 1)], which means that exactly one
     * element is missing.
     *
     * Your goal is to find that missing element.
     *
     * Given an array A, returns the value of the missing element.
     *
     * @param A
     * @return
     */
    public int solution(int[] A) {

        if (A.length < 1) {
            return 1;
        }

        int lgth = A.length;
        int Blgth = lgth + 2;
        byte[] B = new byte[Blgth];

        for (int i = 0; i < lgth; i++) {
            B[A[i]] = 1;
        }

        for (int i = 1; i <= Blgth; i++) {
            if (B[i] == 0) {
                return i;
            }
        }

        return 0;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        PermMissingElem c = new PermMissingElem();
        int[] A = {2, 3, 1, 5};
        System.out.println("solution A: " + c.solution(A));
        int[] D = {2};          // single digit
        System.out.println("solution D: " + c.solution(D));
        int[] E = {};          // single digit
        System.out.println("solution E: " + c.solution(E));
    }
}
/* sample Dialogue
run:
solution A: 4
solution D: 1
solution E: 1
BUILD SUCCESSFUL (total time: 0 seconds)

 */
 /* CodeCheck Report: 100% 
nalysis
Detected time complexity:
O(N) or O(N * log(N))
expand allExample tests
▶example
example test✔OK
expand allCorrectness tests
▶empty_and_single
empty list and single element✔OK
▶missing_first_or_last
the first or the last element is missing✔OK
▶single
single element✔OK
▶double
two elements✔OK
▶simple
simple test✔OK
collapse allPerformance tests
▶medium1
medium test, length = ~10,000✔OK
1.0.024 sOK
▶medium2
medium test, length = ~10,000✔OK
1.0.028 sOK
▶large_range
range sequence, length = ~100,000✔OK
1.0.244 sOK
2.0.124 sOK
3.0.124 sOK
▶large1
large test, length = ~100,000✔OK
1.0.244 sOK
▶large2
large test, length = ~100,000✔OK
1.0.148 sOK
 */
