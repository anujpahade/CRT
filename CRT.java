import java.util.*;
public class CRT {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int size;	

		System.out.println("Enter the no. of equations: ");
		size = input.nextInt();

		int[] rem = new int[size];
		int[] num = new int[size];

		print("Enter "+size+"remainders");
		for(int i=0; i<size; i++){
			rem[i] = input.nextInt();
		}

		print("Enter "+size+"remainders");

		for(int i=0; i<size; i++){
			num[i] = input.nextInt();
		}

		print("Numbers: "+Arrays.toString(num)+'\n');
		print("Remainders: "+Arrays.toString(rem)+'\n');

		print("The smallest value of X for following problem is: "+computeMinX(rem,num));
		// print("sum = "+sum+"\n");
	}

	public static int computeMinX(int[] rem, int[] num){
		//STEP 1
		int product = 1;
		for (int i=0; i<num.length; i++ ) {
			product *= num[i];
		}

		print("Product of all numbers is: "+product);

		int partialProduct[] = new int[num.length];
		int inverse[] = new int[num.length];
		int sum = 0;

		for (int i=0; i<num.length; i++) {
			partialProduct[i] = product/num[i];//floor division
			inverse[i] = computeInverse(partialProduct[i],num[i]);
			sum += partialProduct[i] * inverse[i] * rem[i];
		}

		print("Partial product array is: "+Arrays.toString(partialProduct)+"\n");
		print("Multiplicative inverse modulo of partial product: "+Arrays.toString(inverse)+"\n");
		print("Sum = "+sum+"\n");

		return sum % product;

	}

	public static int computeInverse(int a, int b) 
    { 
        int m = b, t, q; 
        int x = 0, y = 1; 
      
        if (b == 1) 
        return 0; 
      
        // Apply extended Euclid Algorithm 
        while (a > 1) 
        { 
            // q is quotient 
            q = a / b; 
            t = b; 
      
            // m is remainder now, process 
            // same as euclid's algo 
            b = a % b;a = t; 
      
            t = x; 
      
            x = y - q * x; 
      
            y = t; 
        } 
      
        // Make x1 positive 
        if (y < 0) 
        	y += m; 
      
        return y; 
    } 
	public static void print(String arg){
    	System.out.println(arg);
	}

}