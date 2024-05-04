package classesAndObjects;

public class ComplexNumbers {
	private int real;
	private int imaginary;
	
	public ComplexNumbers(int real,int imaginary)
	{
		this.real=real;
		this.imaginary=imaginary;
	}
	//--------------------------------------------------------
	public int getReal() {
		return real;
	}

	public void setReal(int real) {
		this.real = real;
	}

	public int getImaginary() {
		return imaginary;
	}

	public void setImaginary(int imaginary) {
		this.imaginary = imaginary;
	}
	//-----------------------------------------

	public void print()
	{
		System.out.println(real+" +i"+imaginary);
	}
	public void printConjugate()
	{
		System.out.println(real+" -i"+imaginary);
	}
	
	public void add(ComplexNumbers c2)
	{
		real=real+c2.real;
		imaginary=imaginary+c2.imaginary;
	}
	
	public static ComplexNumbers add(ComplexNumbers c1,ComplexNumbers c2)
	{
		ComplexNumbers c3=new ComplexNumbers(c1.real+c2.real,c1.imaginary+c2.imaginary);
		return c3;
	}
	
	
	
	
}
