import java.util.Arrays;
import java.util.Scanner;

public class SieveofEratosthenes {

    public static void main(String[]  args){
        SieveofEratosthenes soe = new SieveofEratosthenes();
        System.out.println("Please enter a positive number: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        soe.countNumberOfPrimesUpTo(num);
    }

    void countNumberOfPrimesUpTo(int num){
        boolean[] list = new boolean[num+1];   // To find primes up to num, a list of num+1 is created.
        Arrays.fill(list, true);           // all elements of the list are true.
        list[0] = false; list[1] = false;      // 0 and 1 are not prime numbers.

        int upperBound = (int) (Math.sqrt(num)+1);  // for optimization.

        for (int i=2; i<=upperBound ;i++) {
            if( list[i] )
                for (int j = 2; i * j <= num; j++)
                    list[i * j] = false;
        }

        int number0fPrimes = 0;
        for( boolean flag : list) {
            if (flag)
                number0fPrimes++;
        }
        System.out.println("There are " + number0fPrimes + " prime numbers to " + num);
    }
}
