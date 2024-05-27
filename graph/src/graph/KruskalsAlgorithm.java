package graph;
import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable <Edge>
{
	int source;
	int desti;
	int weight;
	
	public Edge(int a,int b,int c)
	{
		source=a;
		desti=b;
		weight=c;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.weight-o.weight;
	}
}


public class KruskalsAlgorithm {
	
	public static Edge[] getKruskalsMST(Edge[] input,int v) 
	{
		Arrays.sort(input);
		int[] parent=new int[v];
		for(int i=0;i<v;i++)
		{
			parent[i]=i;
		}
		Edge[] output=new Edge[v-1];
		
		int i=0,count=0;
		while(count!=v-1)
		{
			Edge temp=input[i];
			int sourceP=getParent(temp.source,parent);
			int destiP=getParent(temp.desti,parent);
			
			if(sourceP!=destiP)
			{
				output[count]=temp;
				count++;
				parent[sourceP]=destiP;
			}
			i++;
		}
		return output;
	}

	private static int getParent(int desti, int[] parent) {
		if(parent[desti]==desti)
			return desti;
		return getParent(parent[desti],parent);
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter vertices and edges");
		int v=s.nextInt();   int e=s.nextInt();
		System.out.println("Enter source - Destination - Weights");
		Edge[] input=new Edge[e];
		for(int i=0;i<e;i++)
		{
			int a=s.nextInt();
			int b=s.nextInt();
			int c=s.nextInt();
			input[i]=new Edge(a,b,c);
		}
		
		Edge[] output=getKruskalsMST(input,v);
		System.out.println("source - Destination - Weights");
		for(int i=0;i<output.length;i++)
		{
			System.out.println(output[i].source+"  "+output[i].desti+"  "+output[i].weight);
		}
		
		s.close();
	}

}
