package classesAndObjects;

public class Polynomial {
	int[] coefficient;
	int maxLength;
	
	public Polynomial()
	{
		coefficient=new int[5];
		maxLength=4;
	}


	public int getCoefficient(int index) {
		return coefficient[index];
	}
	public void setCoefficient(int index,int data) {
		
		coefficient[index] = data;
	}
	
	private void restructure()
	{
		int[] temp=coefficient;
		coefficient=new int[2*temp.length];
		for(int i=0;i<temp.length;i++)
		{
			coefficient[i]=temp[i];
		}
		maxLength=coefficient.length-1;
	}
	
	public void print()
	{
		String ans="";
		for(int i=0;i<coefficient.length;i++)
		{
			if(coefficient[i]!=0)
			{
				ans=ans+coefficient[i]+"x^"+i+" + ";
			}
		}
		System.out.println(ans);
	}
	
	public void add(Polynomial p1)
	{
		for(int i=0;i<Math.min(this.maxLength, p1.maxLength);i++)
		{
			coefficient[i]=coefficient[i]+p1.coefficient[i];
		}
	}
	
	public Polynomial add(Polynomial p1,Polynomial p2)
	{
		Polynomial p3=new Polynomial();
		for(int i=0;i<Math.min(p2.maxLength, p1.maxLength);i++)
		{
			p3.coefficient[i]=coefficient[i]+p1.coefficient[i];
		}
		return p3;
	}
	
	
	

}
