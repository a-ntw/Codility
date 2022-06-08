/** 220416
 * Codility Lesson 2 Arrays.
 * OddOccurrencesInArray
 * Find value that occurs in odd number of elements.
 */
package easy;

import java.time.Duration;
import java.time.Instant;
import data.TestData;

/**
 *
 * @author antw
 */
public class OddOccurrencesInArray {

    /**
     * .
     * A non-empty array A consisting of N integers is given. The array contains
     * an odd number of elements, and each element of the array can be paired
     * with another element that has the same value, except for one element that
     * is left unpaired.
     *
     * N is an odd integer within the range [1..1,000,000]; each element of
     * array A is an integer within the range [1..1,000,000,000]; all but one of
     * the values in A occur an even number of times.
     *
     * @param A array A consisting of N integers fulfilling the above conditions
     * @return the value of the unpaired element.
     */
    public int solution(int[] A) {
        int lgth = A.length, max;
        short[] count;

        // Return result if N = 1 or N = 2
        if (lgth == 1) {
            return A[0];
        }

        if (lgth % 2 == 0) {
            System.out.println("Error. N should be odd int.");
            System.exit(0);
        }

        // check for maximun value
        max = 0;
        for (int i = 0; i < lgth; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }

        // init count array to 0
        count = new short[max + 1];
        for (int c = 0; c <= max; c++) {
            count[c] = 0;
        }

        // increase 1 for value found at count[value], 
        for (int i = 0; i < lgth; i++) {
            count[A[i]] += 1;
        }

        // scan thru array Count for odd's count
        for (int c = 0; c < max; c++) {
            if (count[c] % 2 != 0) {
                return c;
            }
        }
        return max; // not use
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        OddOccurrencesInArray C = new OddOccurrencesInArray();
        TestData S = new TestData();

        int[] a = {9, 3, 9, 3, 9, 7, 9};
        S.printArray(a);
        System.out.println("a Returned value: " + C.solution(a));
        int[] b = {9};
        System.out.println("b Returned value: " + C.solution(b));
        int[] c = {9, 3, 9, 3, 1000000000, 999999999, 1000000000};
        System.out.println("a Returned value: " + C.solution(c));

        int[] x = S.evenOdd(999999);
        Instant start = Instant.now();
        System.out.println("Data size:" + x.length + " Returned value: " + C.solution(x));
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: " + timeElapsed.toMillis() + " ms");
    }
}

/* Sample Dialogue
run:
 9  3  9  3  9  7  9 
a Returned value: 7
b Returned value: 9
a Returned value: 999999999
Data size:999999 Returned value: 500000
Time taken: 8 ms
BUILD SUCCESSFUL (total time: 2 seconds)
 */

 /* CodeCheck Report: 88% 
Analysis
Detected time complexity:
O(N) or O(N*log(N))
expand allExample tests
▶example1
example test✔OK
expand allCorrectness tests
▶simple1
simple test n=5✔OK
▶simple2
simple test n=11✔OK
▶extreme_single_item
[42]✔OK
▶small1
small random test n=201✔OK
▶small2
small random test n=601✔OK
collapse allPerformance tests
▶medium1
medium random test n=2,001✔OK
1.0.008 sOK
▶medium2
medium random test n=100,003✔OK
1.0.312 sOK
▶big1
big random test n=999,999, multiple repetitions✔OK
1.2.044 sOK
▶big2
big random test n=999,999✘RUNTIME ERROR
tested program terminated with exit code 1
1.3.320 sRUNTIME ERROR, tested program terminated with exit code 1
stderr:
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at Solution.solution(Solution.java:56(was31))
	at Exec.run(exec.java:111(was48))
	at Exec.main(exec.java: 59(was34))
 */

 /* 
maximum value before Error on Java heap space, on https://app.codility.com/ 
using short[] count;
Your test case: [52428000, 3, 9, 3, 9, 9, 52428000]
Returned value: 9

using byte[] count;
Your test case: [104855000, 3, 9, 3, 9, 9, 104855000]
Returned value: 9
 */
