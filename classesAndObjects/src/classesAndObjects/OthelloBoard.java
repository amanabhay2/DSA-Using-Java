package classesAndObjects;

public class OthelloBoard {
	private char[][] board;
	private int size;
	private int filled=4;
	private char symbol1,symbol2;
	public final static int PLAYER_1WINS=1;
	public final static int PLAYER_2WINS=2;
	public final static int INVALID_INPUT=3;
	public final static int DRAW=4;
	public final static int INCOMPLETE=5;
	public OthelloBoard(char symbol1,char symbol2)
	{
		size=8;
		board=new char[size][size];
		this.symbol1=symbol1;
		this.symbol2=symbol2;
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				board[i][j]=' ';
			}
		}
		board[3][3]=symbol2;
		board[4][4]=symbol2;
		board[3][4]=symbol1;
		board[4][3]=symbol1;
	}
	public int symbolCounter(char symbol)
	{
		int count =0;
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				if(board[i][j]==symbol)
					count++;
			}
		}
		return count;
	}
	
	public void print()
	{
		System.out.println("________________________________________");
		for(int i=0;i<size;i++)
		{
			System.out.print("|");
			for(int j=0;j<size;j++)
			{
				System.out.print("   "+ board[i][j]+"|");
			}
			System.out.println();
			System.out.println("________________________________________");
		}
		
	}
	
	public void  move(int x,int y,char symbol1,char symbol2)
	{
		boolean change=false;
		int[] xAxis= {0,-1,-1,-1,0,1,1,1};
		int[] yAxis= {-1,-1,0,1,1,1,0,-1};
		for(int i=0;i<xAxis.length;i++)
		{
			int x1=x+xAxis[i];
			int y1=y+yAxis[i];
			
			while(x1>=0&&x1<=7&&y1>=0&&y1<=7)
			{
				if(board[x1][y1]!=symbol2)
					break;
				if(board[x1][y1]==' ')
					break;
				if(board[x1][y1]==symbol1)
					break;				
				x1=x1+xAxis[i];
				y1=y1+yAxis[i];
			}
			if(board[x1][y1]==symbol1)
			{
				int x2=x+xAxis[i];
				int y2=y+yAxis[i];
				while(x1!=x2&&y1!=y2)
				{
					board[x2][y2]=symbol1;					
					x2=x2+xAxis[i];
					y2=y2+yAxis[i];
					change=true;
				}				
			}
		}
		//if(change)
			//return INVALID_INPUT;
		System.out.println(change);
	}
	
	
	public int checkWin()
	{
		int count1=symbolCounter(symbol1);
		int count2=symbolCounter(symbol2);
		if(count1==0)
			return PLAYER_2WINS;
		if(count2==0)
			return PLAYER_1WINS;
		if(filled==64)
		{
			if(count1>count2)
				return PLAYER_1WINS;
			else
				return PLAYER_2WINS;
		}
		
		return INCOMPLETE;
	}
	
}
