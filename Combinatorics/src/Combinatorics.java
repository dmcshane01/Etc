/*
 * Static class to perform combinatoric and Permutation functions
 * Daniel DelyMcShane
 * 06/17/2016
 */

import java.math.BigInteger;

public class Combinatorics {
	
	 /*============================Factorial================================*/

	 /*
	  * factorial takes an integer as a paramter and returns n!
	  * We use BigInteger because these will be large numbers in most cases
	  * And return strings to use further with BigInteger
	  * @param n number to find factorial of
	  * @return n!
	  */
	public static String factorial(int n)
	{
		BigInteger fact = new BigInteger("1");
		
		for(int i = n; i > 1; i--)
		{
			fact = fact.multiply(new BigInteger(String.valueOf(i)));
		}
		
		return fact.toString();
	}
	
	/*============================Permutations================================*/
	
	/*
	 * permutationRep takes parameters n,r, where n is the number of choices (|n|)
	 * and r is the quantity. Repetitions are allowed in this scenario
	 * @param n = total items being selected
	 * @param r = size of set of selections
	 * @return n^r
	 */
	public static String permutationRep(int n, int r)
	{
		BigInteger perm = new BigInteger("1"); 
		
		for(int i = r; i >= 1; i-- )
		{
			perm = perm.multiply(new BigInteger(String.valueOf(n)));
		}
		
		return perm.toString();
	}
	

	/*
	 * permutationNoRep performs permutation on n,r where no repetition is permitted
	 * @param n = total items being selected
	 * @param r = size of set of selections
	 * @return n! / (n-r)!
	 * 
	 */
	public static String permutationNoRep(int n, int r)
	{
		String factorialNumerator = factorial(n);
		String factorialDivisor = factorial(n-r);
		
		BigInteger bigFactN = new BigInteger(factorialNumerator);
		BigInteger bigFactDivisor = new BigInteger(factorialDivisor);
		
		bigFactN = bigFactN.divide(bigFactDivisor);
		
		return bigFactN.toString();
	}
	
	
	/*============================Combinatorics================================*/

   /*
    * combinatorics with repetition
    * formula is (n+r-1)! / (r!)*(n-1)!
    * @param n = total items being selected
    * @param r = size of set of selections
    * @return (n+r-1)! / (r!)*(n-1)!
    * 
    */
	public static String combinatoricRep(int n, int r)
	{
		//initialize Strings for BigInteger arguments
		String factorialNumerator = factorial(n+r-1);  //create string of factorial of (n+r-1)
		String factorialR = factorial(r); //create string of r!
		String factorialN = factorial(n-1); //create string of n-1!
		
		BigInteger numerator = new BigInteger(factorialNumerator);
		BigInteger rFact = new BigInteger(factorialR);
		BigInteger nFact = new BigInteger(factorialN);
		
		numerator = numerator.divide(rFact.multiply(nFact)); //divides numerator by (rFact * nFact)
		
		return numerator.toString();
	}
	
	 /*
	    * combinatorics with no repetition
	    * formula is n! / (n-r)!(r!)
	    * @param n = total items being selected
	    * @param r = size of set of selections
	    * @return n! / (n-r)!(r!)
	    * 
	    */
	public static String combinatoricNoRep(int n, int r)
	{
		String factorialNumerator = factorial(n);
		String factorialDenominator1 = factorial(n-r);
		String factorialDenominator2 = factorial(r);
		
		BigInteger numerator = new BigInteger(factorialNumerator); // n!
		BigInteger denominator1 = new BigInteger(factorialDenominator1); // (n-r)!
		BigInteger denominator2 = new BigInteger(factorialDenominator2); //r!
		
		denominator1 = denominator1.multiply(denominator2); //(n-r)! * r!
		
		
		numerator = numerator.divide(denominator1);
		
		return numerator.toString();
		
	}
	
	
	
	

}
