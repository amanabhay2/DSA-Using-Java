package classesAndObjects;

import java.util.Scanner;

public class TicTacToeAproach2 {

	//Play Method
	public static void play(Player p1,Player p2,Board b)
	{
		
		while(b.count!=9)
		{
			if(b.count%2==0)
			{
				System.out.println(p1.getPlayerName()+"'s chance");
				//Player 1 Plays
				b.editBoard();
				b.print();
				boolean win=b.checkWin();
				if(win)
				{
					System.out.println(p1.getPlayerName()+"'   Wins");
					return;
				}
				
			}
			else
			{
				System.out.println(p2.getPlayerName()+"'s chance");
				//Player 2 Plays
				b.editBoard();
				b.print();
				boolean win=b.checkWin();
				if(win)
				{
					System.out.println(p2.getPlayerName()+"'   Wins");
					return;
				}
				
			}
			
		}
		if(b.count==9)
		{
			System.out.println();
			System.out.println();
			System.out.println(" MATCH DRAW");
		}		
	}
	
	//Main method
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		//Player 1
		System.out.println("Enter Details for Player 1");
		String name1=s.nextLine();	
		char ch1=s.nextLine().charAt(0);
		Player p1=new Player(name1,ch1);
		//Player 2
		System.out.println("Enter Details for Player 2");		
		String name2=s.nextLine();
		char ch2=s.nextLine().charAt(0);
		Player p2=new Player(name2,ch2);
		//Board
		Board b=new Board(3,p1.getSymbol(),p2.getSymbol());
		
		//Play method
		play(p1,p2,b);	
		
		s.close();
	}

}
