package misc_CS401_Programs;

public class Recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(func(-2,2));
		
		double[] a;
		a = new double[10];
		for (int i = 0; i <10; i++){
			a[i] = i;
		}
		
		
		System.out.println(sumArray(a, 0, a.length));

	}
	
	public static int func(int a, int b){
		int r;
		if (b ==0)
			r = 0;
		else if (b>0)
			r = a + func(a,b-1);
		else
			r = func(-a,-b);
		return r;
	}
	
	public static double sumArray(double[] a, int i, int j){
		
		if (i == j)
			return a[i];
		else
			return a[i] + sumArray(a, i+1, j-1);
	}
	
	
	//recursive method of adding 
	public static int recursiveSum (int i, int sum){
		if (i >=10){
			return sum;
		}
		else{
			sum +=i;
			return recursiveSum(i+1, sum);
		}
			
	}

}
