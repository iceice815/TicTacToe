/*ProjectC
 *@author:Bing Xie
 *Student ID:741012
 *Date:5/26/2016
 */


import java.util.Scanner;

public class TicTacToe {
	public static Scanner in = new Scanner(System.in);//input
	public PlayerManager PM = new PlayerManager();
	public GameManager GM = new GameManager();
	public BadInputException BadInput = new BadInputException();
	public static String[] input;//define string type to split "in" and stored into array input
	public static boolean AIexist1=false;
	public static boolean AIexist2=false;
	public void run()  {

		System.out.println("Welcome to Tic Tac Toe!");// start the game
		  PM.readFileByLines();
		do{
			try
			{
			System.out.println("");
			System.out.print(">");
			input = (in.nextLine()).split("\\ |,|,");
			if((input[0].equals("exit"))||(input[0].equals("addplayer"))||
					(input[0].equals("removeplayer"))||(input[0].equals("editplayer"))||
					(input[0].equals("resetstats"))||(input[0].equals("rankings"))||
					(input[0].equals("displayplayer"))||(input[0].equals("playgame"))||
					(input[0].equals("addaiplayer"))){
			}
			else{
						throw new BadInputException(input[0]);
						}
			if (input[0].equals("addplayer")) {
				try
				{
				if(input.length!=4){
					throw new BadInputException();
				}
				PM.addPlayer(input[1], input[2], input[3]);
					}
				catch(BadInputException e)
				{
					System.out.println("Incorrect number of arguments supplied to command.");

					}
			} // add player
			
			else if (input[0].equals("addaiplayer")) {
				try
				{
				if(input.length!=4){
					throw new BadInputException();
				}
				PM.addAIPlayer(input[1], input[2], input[3]);
					}
				catch(BadInputException e)
				{
					System.out.println("Incorrect number of arguments supplied to command.");

					}
			} // add player
			
			

			else if (input[0].equals("removeplayer")) {
				if (input.length == 1) {
					PM.removePlayer();
				} else {
					try
					{
						if(input.length!=2)
						{
							throw new BadInputException();
						}
					PM.removePlayer(input[1]);
				}
					catch(BadInputException e)
					{
						System.out.println("Incorrect number of arguments supplied to command.");
					}
				}
			} // remove all players
			
			else if (input[0].equals("editplayer")) {
				try{
					if(input.length!=4)
					{
						throw new BadInputException();
					}
				PM.editPlayer(input[1], input[2], input[3]);
				}
				catch(BadInputException e)
				{
					System.out.println("Incorrect number of arguments supplied to command.");
				}
				} // edit one player
			
			else if (input[0].equals("resetstats")) {
				if (input.length == 1) {
					PM.resetStats();
				} else {
					try{
						if(input.length!=2){
							throw new BadInputException();	
						}
					PM.resetStats(input[1]);
					}
					catch(BadInputException e)
					{
						System.out.println("Incorrect number of arguments supplied to command.");
					}
				}
			}//reset all player information

			else if (input[0].equals("displayplayer")) {
				if (input.length == 1) {
					PM.displayPlayer();
				} else {
					try{
						if(input.length!=2){
							throw new BadInputException();	
						}
					PM.displayPlayer(input[1]);
				}
					catch(BadInputException e)
					{
						System.out.println("Incorrect number of arguments supplied to command.");
					}
				}
			} // display

			else if (input[0].equals("rankings")) {
				try{
					if(input.length!=1){
						throw new BadInputException();	
					}
				PM.displayRanking();
				}
				catch(BadInputException e)
				{
					System.out.println("Incorrect number of arguments supplied to command.");
				}
			} // ranking

			else if (input[0].equals("playgame")) {
				try{
					if(input.length!=3){
						throw new BadInputException();	
					}
				PM.searchPlayer(input[1], input[2]);
				if (PM.exist1 == false || PM.exist2 == false) {
					System.out.println("Player does not exist.");
				}//deal with unexist player 
				if (PM.exist1 ==true && PM.exist2 == true ){
					PM.searchAIPlayer(input[1],input[2]);
					AIexist1=PM.AIexist1;
					AIexist2=PM.AIexist2;
				GM.playGame(PM.givenNameForGame1, PM.givenNameForGame2);
				if (GM.Owin == true) {
					PM.playerWin(input[1], input[2]);
				} else if (GM.Xwin == true) {
					PM.playerWin(input[2], input[1]);
				} else {
					PM.playerDraw(input[1], input[2]);
				}
				}//start the TicTocToe game and update player statistics
			} 
				catch(BadInputException e)
				{
					System.out.println("Incorrect number of arguments supplied to command.");
				}
			}
			
			}	
			
			catch(BadInputException e)
			{
			  System.out.println("'"+ e.getBadCommand()+"' is not a valid command.");

			}   
			
		}
		
		while (!input[0].equals("exit"));//exit
				
		PM.WritefileByLines("players.dat");
		//in.close();
		System.out.println();
		System.exit(0);
		
	}
	

	public static void main(String[] args)  {
		TicTacToe gameSystem = new TicTacToe();
		gameSystem.run();
	}
}
