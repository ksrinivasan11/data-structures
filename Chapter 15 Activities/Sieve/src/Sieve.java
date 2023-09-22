import java.util.Scanner;
import java.util.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();
        
        Set<Integer> set = new HashSet<>();
        Set<Integer> primes = new HashSet<>();


        for (int i = 2; i <= n; i++){
            set.add(i);
        }
        int count = 0;
        for (Integer setNum1: set) {
            for (Integer setNum2: set){
                
                if (setNum1 % setNum2 != 0){
                    count++;
                    //System.out.println(setNum1 + "/" + setNum2 + ": " + count);
                }
            }
            if (count == set.size()-1){
                primes.add(setNum1);
                
            }
            count = 0;
        }
        System.out.println(primes);
    






    }
}
