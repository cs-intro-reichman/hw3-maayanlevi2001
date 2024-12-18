
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		//120000, Interest Rate 3.5%, and Periods 60
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) {	
		// Replace the following statement with your code
		double sum = loan;
	
           for (int i = 0; i<=n-1; i++) 
		   {
			sum = (sum - payment ) * (1 + rate/100);
		   }
		return sum;
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		
		double periodicalPayment = loan/n;
		iterationCounter = 0;
		while (endBalance(loan, rate, n, periodicalPayment) > epsilon ) //if the test failed myabe we need to try with >=0
		{
			periodicalPayment = periodicalPayment + epsilon;
			iterationCounter++;
		}
			
			
		return periodicalPayment;
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
        // Replace the following statement with your code
		double paymentHigh = loan;
		double paymentLow = loan/n;
		double paymentGuess = (paymentHigh + paymentLow) / 2;
		iterationCounter = 0;
		while( (paymentHigh - paymentLow) >= epsilon)
		{
			if (endBalance(loan, rate, n, paymentGuess) * endBalance(loan, rate, n, paymentLow) > 0)
			{
				paymentLow = paymentGuess;
			}
			else 
			{
				paymentHigh = paymentGuess;
			}
			iterationCounter++;
			paymentGuess = (paymentLow + paymentHigh)/2;
			//System.out.println("correct intial in the loop is  " + initialGuess);
			//System.out.println("correct endbalance is " + endBalance(loan, rate, n, initialGuess));
		}
    	return paymentGuess;
		}
	}

