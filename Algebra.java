
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
		
	    // System.out.println(plus(2,3));   // 2 + 3
	    // System.out.println(minus(7,2));  // 7 - 2
   		// System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(-5,-5));  // 3 * 4
   		// System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		// System.out.println(pow(5,3));      // 5^3
   		// System.out.println(pow(3,5));      // 3^5
   		// System.out.println(div(12,3));   // 12 / 3    
   		// System.out.println(div(5,5));    // 5 / 5  
   		// System.out.println(div(25,7));   // 25 / 7
   		// System.out.println(mod(25,7));   // 25 % 7
   		// System.out.println(mod(120,6));  // 120 % 6    
   		// System.out.println(sqrt(36));
		// System.out.println(sqrt(263169));
   		// System.out.println(sqrt(76123));
	}  


	// Returns x1 + x2 x1=-4 x2=-2
	public static int plus(int x1, int x2) {
		int result = x1;
		if (x2 >= 0) 
		    for (int i = 0; i < x2; i++) 
		    {result++;}
		if (x2 < 0)  
		    for (int i = 0; i > x2; i--) 
		    {result--;}
		return result;
		}
		

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int absX2 = x2;
		if (absX2 < 0)
		{
			absX2 = -absX2; 
			for( int i = absX2; i > 0; i-- )
		    {
			x1++;
		    }
		} 
		else{
		for( int i = absX2; i > 0; i-- )
		{
			x1--;
		}
	    }
		if (x2 < 0 ) return (-x1);
		else return (x1);
	}



	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int temp = x1;

		if (x2 == 0) return 0;

		if (x2 < 0) return times(x1, -x2);

		if (x2 > 0 ){
			for (int i = 0; i < x2 - 1; i++) {
				x1 = plus(x1, temp);
			}
		} 

		return x1;
	}


	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int resultX = 1;
		if (n == 0) 
		{
			resultX = 1;
		}
		if (n > 0)
		{
		for (int i = 0; i < n ; i++ )
		    {
			resultX = times(resultX, x);
		    }	
		}
			
		return resultX;
    }



	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) 
	{
		int count = 0;
		int absx1 = x1;
		int absx2 = x2;
		int countx2 = absx2;
		if (x1 < 0 && x2 > 0 )
		{
			absx1 = times(-1, x1);
		}
		if ( x1 > 0 && x2 < 0) 
		{
			absx2 = times(-1,x2) ;
		}
		while (countx2 <= absx1)
			{
			count++;
			countx2 = plus (countx2 , absx2) ;
			}
	
		if ((x1 < 0 && x2 > 0 ) || ( x1 > 0 && x2 < 0)) 
		    count = times(-1, count) ;
		return (count);
    
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int result = minus(x1, times(div(x1, x2),x2));
		
		return result;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int integer = 0 ;
		while (pow(integer,2) <= x) {
			integer++;
		} 
		return (minus(integer , 1));
	 }
		  	  
}