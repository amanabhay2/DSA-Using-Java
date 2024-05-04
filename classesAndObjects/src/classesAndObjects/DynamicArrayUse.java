package classesAndObjects;

public class DynamicArrayUse {

	public static void main(String[] args) {
		DynamicArray d=new DynamicArray();
		
		System.out.println(d.isEmpty());
		for(int i=0;i<100;i++)
		{
			d.add(i+7);
		}
		d.set(7,19191);
		d.removeLast();d.removeLast();d.removeLast();d.removeLast();d.removeLast();
		//d.print();
		
		System.out.println(d.isEmpty());
		
		while(!d.isEmpty())
		{
			d.removeLast();
		}
		System.out.println(d.isEmpty());
		
	}

}
