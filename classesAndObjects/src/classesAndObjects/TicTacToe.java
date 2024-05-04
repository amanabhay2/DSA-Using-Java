package classesAndObjects;
import java.util.Scanner;
public class TicTacToe {

	public static boolean checkWin(char[][] game)
	{
		for(int i=0;i<game.length;i++)
		{
			if(game[i][0]=='0')
				continue;
			if(game[i][0]==game[i][1])
			{
				if(game[i][0]==game[i][2])
				{
					return true;
				}
			}
		}
		for(int i=0;i<game.length;i++)
		{
			if(game[0][i]=='0')
				continue;
			if(game[0][i]==game[1][i])
			{
				if(game[0][i]==game[2][i])
				{
					return true;
				}
			}
			
		}
		//Diagonal i==j
		if(game[0][0]==game[1][1]&&game[0][0]==game[2][2])
		{
			if(game[0][0]!='0'&&game[1][1]!='0'&&game[2][2]!='0')
			{
				return true;
			}
		}
		//Diagonal sum=2
		if(game[0][2]==game[1][1]&&game[0][2]==game[2][0])
		{
			if(game[0][2]!='0'&&game[1][1]!='0'&&game[2][0]!='0')
			{
				return true;
			}
		}return false;
	}
	public static int[] play(char[][] game)
	{
		Scanner s=new Scanner(System.in);
		int[] ans=new int[2];
		int i=s.nextInt();					int j=s.nextInt();
		if(game[i][j]=='0')
		{
			ans[0]=i;ans[1]=j;
			return ans;
		}
		
		s.close();
		return play(game);
	}
	public static void print(char[][] game)
	{
		for(int i=0;i<game.length;i++)
		{
			for(int j=0;j<game[0].length;j++)
			{
				System.out.print("   "+game[i][j]);
			}
			System.out.println();
		}
	}
	public static String changePlayer(String player,String person1,String person2)
	{
		if(player==person1)
			return person2;
		else 
			return person1;		
	}
	public static char charForPlayer(String player,String person1,char symbol1,char symbol2)
	{
		if(player==person1)
			return symbol1;
		else 
			return symbol2;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("WELCOME TO TIC-TAC-TOE WORLD");
		System.out.println();
		//Person 1
		System.out.println("Enter player 1 name");
		String person1=s.nextLine();
		System.out.println("Symbol for"+person1);
		char symbol1=s.nextLine().charAt(0);
		//Person 2
		System.out.println("Enter player 2 name");
		String person2=s.nextLine();
		char symbol2=symbol1;
		while(symbol2==symbol1)
		{
			System.out.println("Symbol for"+person2+"(Must be different from)"+symbol1);
			symbol2=s.next().charAt(0);
		}
		
		int chances=9;
		String player=person2;
		char game[][]= {{'0','0','0'},{'0','0','0'},{'0','0','0'}};
		while(chances!=0)
		{
			player=changePlayer(player,person1,person2);
			System.out.println(player+"'s chance");
			
			//Play
			int[] indices=play(game);
			game[indices[0]][indices[1]]=charForPlayer(player,person1,symbol1,symbol2);
			//Print
			System.out.println();
			print(game);
			System.out.println();
			
			//Win
			boolean win=checkWin(game);
			if(win)
			{
				System.out.println();
				System.out.println();
				System.out.println(player+" WINS");
				return;
			}
			//next chance
			chances--;
		}
		if(chances==0)
		{
			System.out.println();
			System.out.println();
			System.out.println(" MATCH DRAW");
		}		
		s.close();
	}

}
