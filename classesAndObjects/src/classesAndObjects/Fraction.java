package classesAndObjects;
import java.lang.Math;
public class Fraction {
	private int numerator;
	private int denominator;
	
	public Fraction(int numerator,int denominator)
	{
		System.out.println("inside Fraction Constructor");
		this.numerator=numerator;
		this.denominator=denominator;
		simplify();
	}
	
	public void print()
	{
		System.out.println(numerator+" : "+denominator);
	}

	public void add(Fraction f2)
	{
		this.numerator=this.numerator*f2.denominator+f2.numerator*this.denominator;
		this.denominator=this.denominator*f2.denominator;
		simplify();
	}

	private void simplify()
	{
		int hcm=1;
		int x=Math.min(numerator, denominator);
		for(int i=1;i<=x;i++)
		{
			if(numerator%i==0&&denominator%i==0)
			{
				hcm=i;
			}
		}
		numerator=numerator/hcm;
		denominator=denominator/hcm;
	}
	
	public static Fraction add(Fraction f1,Fraction f2)
	{
		Fraction f3=new Fraction(f1.numerator*f2.denominator+f2.numerator*f1.denominator,f1.denominator*f2.denominator);
		return f3;
	}
	
	
}
