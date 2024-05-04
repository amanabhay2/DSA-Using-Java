package recursions;

public class PrintNbumbers {

	public static void print(int x)
	{
		if(x==0) return;
		print(x-1);
		System.out.println(x);
		//print(x-1);
	}
	public static int noOfDigits(int x)
	{
		if(x==0) return 0;
		int count=noOfDigits(x/10);
		return count+1;
	}
	public static int fibnocci(int x)
	{
		if(x==0||x==1) return x;
		
		return fibnocci(x-1)+fibnocci(x-2);
	}
	public static void main(String[] args) {
		//print(5);
		int x=fibnocci(6);
		System.out.print(x);
	}

}
