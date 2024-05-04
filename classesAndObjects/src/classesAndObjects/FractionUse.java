package classesAndObjects;

public class FractionUse {

	public static void main(String[] args) {
		Fraction f1=new Fraction(20,50);
		f1.print();
		
		
		Fraction f2=new Fraction(50,150);
		f2.print();
		
		
		//aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
		
		f1.add(f2);
		f1.print();
		
		//ggggggggggggggggggggggggggggggggggggggggggg
		
		
		Fraction f4=Fraction.add(f1,f2);
		f4.print();
	}

}
