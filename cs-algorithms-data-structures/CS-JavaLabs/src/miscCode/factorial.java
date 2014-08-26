package miscCode;

public class factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int test = new factorial().fact(-1);
		System.out.println(test);
		
	}
	
	
	
	int fact(int num){
		int f;
		if (num==0)
			return 1;
		f = fact(num-1)*num;
		return (f);
	}

}
