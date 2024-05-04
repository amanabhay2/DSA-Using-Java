package classesAndObjects;

import java.util.Scanner;

public class Othello {
	private static Player p1,p2;
	private static OthelloBoard b;
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		//Player 1
		System.out.println("Enter Player 1 Name and Symbol");
		String name=s.nextLine();
		char ch1=s.nextLine().charAt(0);
		p1=new Player(name,ch1);
		//Player 2
		System.out.println("Enter Player 2 Name and Symbol");
		name=s.nextLine();
		char ch2=s.nextLine().charAt(0);
		p2=new Player(name,ch2);
		//Board
		b=new OthelloBoard(ch1,ch2);
		
		//play();
		int status=0;
		boolean Player1Turn=true;
		while(true)
		{
			
			if(Player1Turn)
			{
				System.out.println(p1.getPlayerName()+"'s Chance");
				int x=s.nextInt();
				int y=s.nextInt();
				b.move(x,y,p1.getSymbol(),p2.getSymbol());
				b.print();
				status=b.checkWin();
				Player1Turn=false;
			}
			else
			{
				System.out.println(p2.getPlayerName()+"'s Chance");
				int x=s.nextInt();
				int y=s.nextInt();
				b.move(x,y,p2.getSymbol(),p1.getSymbol());
				b.print();
				status=b.checkWin();			
				Player1Turn=true;
			}
			if(status==1||status==2)
				break;
		}

		if(status==1)
			System.out.println("Player 1 Wins");
		else 
			System.out.println("Player 2 Wins");

		s.close();
	}

}
