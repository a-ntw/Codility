/** 220415
 * Codility Lesson 1 Iterations.
 * BinaryGap
 * Find longest sequence of zeros in binary representation of an integer.
 * https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
 */
package easy;

/**
 *
 * @author antw
 */
public class BinaryGap {

    /**
     * . A binary gap within a positive integer N is any maximal sequence of
     * consecutive zeros that is surrounded by ones at both ends in the binary
     * representation of N.
     *
     * Given a positive integer N, returns the length of its longest binary gap.
     * The function return 0 if N doesn't contain a binary gap.
     *
     * N is an integer within the range [1..2,147,483,647].
     *
     * @param N
     * @return
     */
    public int solution(int N) {

        String binaryString = Integer.toBinaryString(N);

        int lgth = binaryString.length();

        int longestBinaryGap = 0, binaryLength = 0, gapTimes = 0;
        for (int i = 0; i < lgth - 1; i++) {

            char a = binaryString.charAt(i);
            char b = binaryString.charAt(i + 1);

            if ((a == '1') && (b == '0')) {
                binaryLength = 1;
            } else if ((a == '0') && (b == '0')) {
                binaryLength++;
            } else if ((a == '0') && (b == '1')) {

                gapTimes++;
                if (longestBinaryGap < binaryLength) {
                    longestBinaryGap = binaryLength;
                }
            }

        }

        return longestBinaryGap;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        BinaryGap b = new BinaryGap();
        int n;

        System.out.println(" Max binary gaps for " + (n = 9) + " is " + b.solution(n));
        System.out.println(" Max binary gaps for " + (n = 32) + " is " + b.solution(n));
        System.out.println(" Max binary gaps for " + (n = 529) + " is " + b.solution(n));
        System.out.println(" Max binary gaps for " + (n = 1041) + " is " + b.solution(n));

    }
}

/* Sample Dialogue
run:
 Max binary gaps for 9 is 2
 Max binary gaps for 32 is 0
 Max binary gaps for 529 is 4
 Max binary gaps for 1041 is 5
BUILD SUCCESSFUL (total time: 0 seconds)
 */

 /* CodeCheck Report: 100% 
Analysis:
expand allExample tests
▶ example1 
example test n=1041=10000010001_2 ✔OK
▶ example2 
example test n=15=1111_2 ✔OK
▶ example3 
example test n=32=100000_2 ✔OK
expand allCorrectness tests
▶ extremes 
n=1, n=5=101_2 and n=2147483647=2**31-1 ✔OK
▶ trailing_zeroes 
n=6=110_2 and n=328=101001000_2 ✔OK
▶ power_of_2 
n=5=101_2, n=16=2**4 and n=1024=2**10 ✔OK
▶ simple1 
n=9=1001_2 and n=11=1011_2 ✔OK
▶ simple2 
n=19=10011 and n=42=101010_2 ✔OK
▶ simple3 
n=1162=10010001010_2 and n=5=101_2 ✔OK
▶ medium1 
n=51712=110010100000000_2 and n=20=10100_2 ✔OK
▶ medium2 
n=561892=10001001001011100100_2 and n=9=1001_2 ✔OK
▶ medium3 
n=66561=10000010000000001_2 ✔OK
▶ large1 
n=6291457=11000000000000000000001_2 ✔OK
▶ large2 
n=74901729=100011101101110100011100001 ✔OK
▶ large3 
n=805306373=110000000000000000000000000101_2 ✔OK
▶ large4 
n=1376796946=1010010000100000100000100010010_2 ✔OK
▶ large5 
n=1073741825=1000000000000000000000000000001_2 ✔OK
▶ large6 
n=1610612737=1100000000000000000000000000001_2

ref:  https://app.codility.com/programmers/
 */
