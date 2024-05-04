package recursions;

import java.util.Scanner;

public class GeometricSum {

	public static float power(float a,float b)
	{
		if(b==0)
			return 1;
		if(b==1)
			return a;
		
		return a*power(a,b-1);
	}
	public static float getGeometricSum(float x)
	{
		if(x==0)
			return 1;
		return (1/power(2,x)+getGeometricSum(x-1));
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		float k=s.nextFloat();
		
		float GeometricSum=getGeometricSum(k);
		System.out.println(GeometricSum);
		s.close();
	}

}
