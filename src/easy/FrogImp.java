/** 220417
 * Codility Lesson 3 Time Complexity. 
 * FrogImp
 * Count minimal number of jumps from position X to Y.FrogImp
 * https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
 */
package easy;

/**
 *
 * @author antw
 */
public class FrogImp {

    /**
     * . A small frog wants to get to the other side of the road. The frog is
     * currently located at position X and wants to get to a position greater
     * than or equal to Y. The small frog always jumps a fixed distance, D.
     *
     * Count the minimal number of jumps that the small frog must perform to
     * reach its target.
     *
     * Given three integers X, Y and D, returns the minimal number of jumps from
     * position X to a position equal to or greater than Y.
     *
     * @param X
     * @param Y
     * @param D
     * @return
     */
    public int solution(int X, int Y, int D) {
        double jumpsLgth = X, noOfJumps = 0;

        int dist = Y - X;
        noOfJumps = (double) dist / D;
        
        // test for remainder
        if (noOfJumps > (dist / D)) {
            noOfJumps++;
        }

        return (int) noOfJumps;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        FrogImp c = new FrogImp();
        System.out.println("no of jumps: " + c.solution(10, 85, 30));
        System.out.println("no of jumps: " + c.solution(10, 39, 30));
        System.out.println("no of jumps: " + c.solution(1, 5, 2));
        System.out.println("no of jumps: " + c.solution(3, 999111321, 7));
    }
}

/* Sample Dialogue
run:
no of jumps: 3
no of jumps: 1
no of jumps: 2
no of jumps: 142730189
BUILD SUCCESSFUL (total time: 0 seconds)
 */

 /* CodeCheck Report: 100%
Analysis
Detected time complexity:
O(1)
expand allExample tests
▶ example 
example test ✔OK
expand allCorrectness tests
▶ simple1 
simple test ✔OK
▶ simple2 ✔OK
▶ extreme_position 
no jump needed ✔OK
▶ small_extreme_jump 
one big jump ✔OK
collapse allPerformance tests
▶ many_jump1 
many jumps, D = 2 ✔OK
1. 0.004 s OK
▶ many_jump2 
many jumps, D = 99 ✔OK
1. 0.004 s OK
▶ many_jump3 
many jumps, D = 1283 ✔OK
1. 0.008 s OK
▶ big_extreme_jump 
maximal number of jumps ✔OK
1. 0.008 s OK
▶ small_jumps 
many small jumps ✔OK
1. 0.008 s OK

ref:  https://app.codility.com/programmers/
*/
