package recursions;

import java.util.Scanner;

public class ArraySubSets {

	public static int[][] getSubsets(int[] arr)
	{
		if(arr.length==0)
		{
			int[][] a=new int[1][];
			a[0]=arr;
			return a;
		}
		int[] shortArr=new int[arr.length-1];
		for(int i=0;i<shortArr.length;i++)
		{
			shortArr[i]=arr[i+1];
		}
		int[][] temp=getSubsets(shortArr);
		int [][] ans=new int[2*temp.length][];
		int k=0;
		for(int i=0;i<temp.length;i++)
		{
			ans[k]=temp[i];
			k++;
		}
		for(int i=0;i<temp.length;i++)
		{
			int[] temp2=new int[temp[i].length+1];
			temp2[0]=arr[0];
			for(int j=1;j<=temp[i].length;j++)
			{
				temp2[j]=temp[i][j-1];
			}
			ans[k]=temp2;
			k++;
		}
		
		
		return ans;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int size=s.nextInt();
		int[] arr=new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=s.nextInt();
		}
		int[][] subsets=getSubsets(arr);
		for(int i=0;i<subsets.length;i++)
		{
			for(int j=0;j<subsets[i].length;j++)
			{
				System.out.print(subsets[i][j]+" ");
			}
			System.out.println();
		}
		s.close();
	}

}
