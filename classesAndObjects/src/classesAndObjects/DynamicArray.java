package classesAndObjects;

public class DynamicArray {
	private int[] data;
	private int nextIndex;
	
	public DynamicArray()
	{
		data=new int[5];
		nextIndex=0;
	}
	public void add(int x)
	{
		if(nextIndex==data.length)
		{
			int[] temp=new int[2*data.length];
			for(int i=0;i<data.length;i++)
			{
				temp[i]=data[i];
			}
			data=temp;
		}
		data[nextIndex]=x;
		nextIndex++;
	}
	public void print()
	{
		for(int i=0;i<nextIndex;i++)
		{
			System.out.println(data[i]+" at index"+i);
		}
	}
	
	public void set(int in,int x)
	{
		if(nextIndex<in)
			return;
		else if(nextIndex>in)
			data[in]=x;
		else
			add(x);
	}
	
	public void removeLast()
	{
		if(nextIndex==0)
			return;
		nextIndex--;
		data[nextIndex]=0;
	}
	
	public boolean isEmpty()
	{
		if(nextIndex==0)
			return true;
		return false;
	}

	
	
	
}