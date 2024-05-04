package linkedlist;

import java.util.Scanner;

public class Search {

	public static int search(Node<Integer> head,int x,int index)
	{
		if(head==null)
			return -1;
		if(head.data==x)
			return index;
		
		return search(head.next,x,++index); 			
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++)
		{
			int data=s.nextInt();
			Node<Integer> head=null,tail=null;
			while(data!=-1)
			{
				Node<Integer> newNode=new Node<Integer>(data);
				if(head==null)
					head=tail=newNode;
				else
				{
					tail.next=newNode;
					tail=newNode;
				}
				data=s.nextInt();
			}
			int x=s.nextInt();
			int index=search(head,x,0);
			System.out.println(index);
		}		
		s.close();

	}

}
