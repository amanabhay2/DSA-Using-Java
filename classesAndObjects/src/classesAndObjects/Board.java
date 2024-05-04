package classesAndObjects;

import java.util.Scanner;

public class Board {
	private int boardSize;
	char[][] board;
	char symbol1,symbol2;
	int count;
	//Constructor
	public Board(int boardSize,char symbol1,char symbol2)
	{
		this.count=0;
		this.boardSize=boardSize;
		this.symbol1=symbol1;
		this.symbol2=symbol2;
		board=new char[boardSize][boardSize];
		for(int i=0;i<boardSize;i++)
		{
			for(int j=0;j<boardSize;j++)
			{
				board[i][j]=' ';
			}
		}
	}
	//Print Board
	public void print()
	{
		for(int i=0;i<boardSize;i++)
		{
			for(int j=0;j<boardSize;j++)
			{
				System.out.print("   "+board[i][j]);
			}
			System.out.println();
		}
	}
	//Edit Board
	public void editBoard()
	{
		Scanner s=new Scanner(System.in);
		int i=s.nextInt();
		int j=s.nextInt();
		
		if(board[i][j]==' ')
		{
			if(count%2==0)
				board[i][j]=symbol1;
			else
				board[i][j]=symbol2;
			count++;
			return;
		}
		s.close();
		editBoard();
	}
	//Check win
	public boolean checkWin()
	{
		for(int i=0;i<board.length;i++)
		{
			if(board[i][0]==' ')
				continue;
			if(board[i][0]==board[i][1])
			{
				if(board[i][0]==board[i][2])
				{
					return true;
				}
			}
		}
		for(int i=0;i<board.length;i++)
		{
			if(board[0][i]==' ')
				continue;
			if(board[0][i]==board[1][i])
			{
				if(board[0][i]==board[2][i])
				{
					return true;
				}
			}
			
		}
		//Diagonal i==j
		if(board[0][0]==board[1][1]&&board[0][0]==board[2][2])
		{
			if(board[0][0]!=' '&&board[1][1]!=' '&&board[2][2]!=' ')
			{
				return true;
			}
		}
		//Diagonal sum=2
		if(board[0][2]==board[1][1]&&board[0][2]==board[2][0])
		{
			if(board[0][2]!=' '&&board[1][1]!=' '&&board[2][0]!=' ')
			{
				return true;
			}
		}return false;
	}
	
}
