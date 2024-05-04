package classesAndObjects;

public class ComplexNumbersUses {

	public static void main(String[] args) {
		ComplexNumbers c1=new ComplexNumbers(2,3);
		c1.print();
		
		ComplexNumbers c2=new ComplexNumbers(5,7);
		c2.print();
		
		
		c1.add(c2);
		c1.print();
		
		ComplexNumbers c3=ComplexNumbers.add(c1,c2);
		c3.print();
	}

}
