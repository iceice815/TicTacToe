
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/*ProjectC
 *@author:Bing Xie
 *Student ID:741012
 *Date:5/26/2016
 */
public class PlayerManager {
	public static final int PlayerNumSet = 100;//create 100 player objects
	public Player player[]=new HumanPlayer[ PlayerNumSet];//create 100 player objects
	public  boolean exist1 =false;//returned judge whether exist first user
	public  boolean exist2 =false;//returned judge whether exist second user
	public  boolean AIexist1 =false;//returned judge whether exist first user
	public  boolean AIexist2 =false;//returned judge whether exist first user
	public  String givenNameForGame1;//returned as a givenName to playgame
	public  String givenNameForGame2;//returned as a givenName to playgame
	public  String[] inputForRead;
	/*Constructor*/
	public PlayerManager(){
		for (int i = 0; i < PlayerNumSet; i++) {
			player[i]=new HumanPlayer("H");
		}
		
	}
/*addplayer method*/
	public void addPlayer(String userN, String familyN, String givenN) {
		boolean exist = false;
		for (int i = 0; i < PlayerNumSet; i++) {
			if (player[i].getUsername().equals(userN)) {
				System.out.println("The username has been used already.");
				exist = true;
				break;
			}
		}//deal with exsited username
		if (exist == false) {
			for (int i = 0; i < PlayerNumSet; i++) {
				if (player[i].getUsername().equals("")) {
					player[i].setUsername(userN);
					player[i].setFamilyName(familyN);
					player[i].setGivenName(givenN);
					break;
				}
			}
		}//store the user information to object player
	}
	/*addaiplayer method*/	
	public void addAIPlayer(String userN, String familyN, String givenN) {
		boolean exist = false;
		for (int i = 0; i < PlayerNumSet; i++) {
			if (player[i].getUsername().equals(userN)) {
				System.out.println("The username has been used already.");
				exist = true;
				break;
			}
		}//deal with exsited username
		if (exist == false) {
			for (int i = 0; i < PlayerNumSet; i++) {
				if (player[i].getUsername().equals("")) {
					player[i].setUsername(userN);
					player[i].setFamilyName(familyN);
					player[i].setGivenName(givenN);
					player[i].setPlayerType("AI");//set the type from H to AI
					break;
				}
			}
		}//store the user information to object player
	}
	
	

	/*removeplayer method for one player*/
	public void removePlayer(String userN) {
		boolean existForRemove = false;//used to juage whether exsit the player
		for (int i = 0; i < PlayerNumSet; i++) {
			if (userN.equals(player[i].getUsername())) {
				player[i].setUsername("");
				player[i].setFamilyName("");
				player[i].setGivenName("");
				existForRemove = true;
				break;
			}
		}//remove the user information from one object player
		if (existForRemove== false) {
			System.out.println("The player does not exist.");
		}
	}//deal with the unexist user
	
	/*removeplayer method for all players*/
	public void removePlayer() {
		System.out.println("Are you sure you want to remove all players? (y/n)");
		TicTacToe.input = (TicTacToe.in.nextLine()).split("\\ |,|,");
		if (TicTacToe.input[0].equals("y")) {
			for (int i = 0; i < PlayerNumSet; i++) {
				player[i].setUsername("");
				player[i].setFamilyName("");
				player[i].setGivenName("");
			}
		}//remove user information from all objects player
	}
		
	/*editplayer method*/
	public void editPlayer(String userN, String familyN, String givenN) {
		boolean existForEdit = false;//used to juage whether exsit the player
		for (int i = 0; i < PlayerNumSet; i++) {
			if (userN.equals(player[i].getUsername())) {
				player[i].setFamilyName(familyN);
				player[i].setGivenName(givenN);
				existForEdit = true;
			}
		}//edit one user information
		if (existForEdit == false) {
			System.out.println("The player does not exist.");
		}
	}//deal with unexist user
					
	/*resetplayer method for one user*/
	public void resetStats(String userN) {
		boolean existForReset = false;
		for (int i = 0; i < PlayerNumSet; i++) {
			if (userN.equals(player[i].getUsername())) {
				player[i].setGame(0);
				player[i].setWin(0);
				player[i].setDraw(0);
				existForReset = true;
			}
		}//reset one user information
		if (existForReset == false) {
			System.out.println("The player does not exist.");
		}
	}

	/*resetplayer method for all users*/
	public void resetStats() {
		System.out.println("Are you sure you want to reset all player statistics? (y/n)");
		TicTacToe.input = (TicTacToe.in.nextLine()).split("\\ |,|,");
		if (TicTacToe.input[0].equals("y")) {
			for (int i = 0; i < PlayerNumSet; i++) {
				player[i].setGame(0);
				player[i].setWin(0);
				player[i].setDraw(0);
			}
		}
	}//reset all users informations

	/*displayer method for one user*/
	public void displayPlayer(String userN) {
		boolean existForDisplay = false;
		for (int i = 0; i < PlayerNumSet; i++) {
			if (userN.equals(player[i].getUsername())) {
				System.out.println(player[i].getUsername() + "," + player[i].getFamilyName()
					+ ","+ player[i].getGivenName() + "," + (int)player[i].getGame() 
					+ " games," + (int)player[i].getWin()+ " wins," 
					+ (int)player[i].getDraw() + " draws");

				existForDisplay = true;
			}
		}//display one user
		if (existForDisplay == false) {
			System.out.println("The player does not exist.");
		}

	}
	
	/*displayer method for all users*/
	public void displayPlayer() {
		double[] winNum = new double[PlayerNumSet];
		double[] drawNum = new double[PlayerNumSet];
		double[] gameNum = new double[PlayerNumSet];
		String[] usernameDis = new String[PlayerNumSet];
		String[] familyNameDis = new String[PlayerNumSet];
		String[] givenNameDis = new String[PlayerNumSet];
		double temp1, temp2, temp3;//used to as a medium for change value
		String temp4,temp5,temp6;
		for (int i = 0; i < PlayerNumSet; i++) {
				winNum[i] = player[i].getWin();
				drawNum[i] = player[i].getDraw();
				gameNum[i] = player[i].getGame();
				usernameDis[i] = player[i].getUsername();
				familyNameDis[i] = player[i].getFamilyName();
				givenNameDis[i] = player[i].getGivenName();
		}//duplicate the information stored in player object for sorting
		
		for (int i = 0; i < PlayerNumSet; i++) {
			for (int j = i + 1; j < PlayerNumSet; j++) {
				if( (usernameDis[i].compareTo(usernameDis[j]) > 0) 
		                && (!usernameDis[i].equals(" "))
						&& (!usernameDis[j].equals(" "))) {
					temp1 = winNum[i];
					winNum[i] = winNum[j];
					winNum[j] = temp1;

					temp2 = drawNum[i];
					drawNum[i] = drawNum[j];
					drawNum[j] = temp2;

					temp3 = gameNum[i];
					gameNum[i] = gameNum[j];
					gameNum[j] = temp3;

					temp4 = usernameDis[i];
					usernameDis[i] = usernameDis[j];
					usernameDis[j] = temp4;
					
					temp5 = familyNameDis[i];
					familyNameDis[i] = familyNameDis[j];
					familyNameDis[j] = temp5;
					
					temp6 = givenNameDis[i];
					givenNameDis[i] = givenNameDis[j];
					givenNameDis[j] = temp6;
				}
			}
		}
		for (int i = 0; i < PlayerNumSet; i++) {
			if (!usernameDis[i].equals("")) {
				System.out.println(usernameDis[i] + "," + familyNameDis[i] + ","
				  +givenNameDis[i] + "," +(int)gameNum[i]+ " games," + (int)winNum[i] 
				  + " wins," + (int)drawNum[i] + " draws");
			}
		}
	}
				
	/*ranking method */
	public void displayRanking() {
		double[] winRatio = new double[PlayerNumSet];
		double[] drawRatio = new double[PlayerNumSet];
		double[] gameInRank = new double[PlayerNumSet];
		String[] userInRank = new String[PlayerNumSet];
		double temp1, temp2, temp3;//used to as a medium for change value
		String temp4;
		for (int i = 0; i < PlayerNumSet; i++) {
			if (player[i].getGame() == 0) {
				winRatio[i] = 0;
				drawRatio[i] = 0;
				gameInRank[i] = 0;
				userInRank[i] = player[i].getUsername();
			} else {
				winRatio[i] = player[i].getWin() / player[i].getGame()* 100 ;
				drawRatio[i] = player[i].getDraw() / player[i].getGame()* 100 ;
				gameInRank[i] = player[i].getGame();
				userInRank[i] = player[i].getUsername();
			}
		}//duplicate the information stored in player object for sorting
		
//Bubble sorting algorithms applied to  array
		for (int i = 0; i < PlayerNumSet; i++) {
			for (int j = i + 1; j < PlayerNumSet; j++) {
				if (winRatio[i] < winRatio[j]) {
					temp1 = winRatio[i];
					winRatio[i] = winRatio[j];
					winRatio[j] = temp1;

					temp2 = drawRatio[i];
					drawRatio[i] = drawRatio[j];
					drawRatio[j] = temp2;

					temp3 = gameInRank[i];
					gameInRank[i] = gameInRank[j];
					gameInRank[j] = temp3;

					temp4 = userInRank[i];
					userInRank[i] = userInRank[j];
					userInRank[j] = temp4;
				}
			}
		}//Bubble sorting according  to  Win ratio value
		
		for (int i = 0; i < PlayerNumSet; i++) {
			for (int j = i + 1; j < PlayerNumSet; j++) {
				if ((winRatio[i] == winRatio[j]) && (drawRatio[i] < drawRatio[j])) {
					temp1 = winRatio[i];
					winRatio[i] = winRatio[j];
					winRatio[j] = temp1;

					temp2 = drawRatio[i];
					drawRatio[i] = drawRatio[j];
					drawRatio[j] = temp2;

					temp3 = gameInRank[i];
					gameInRank[i] = gameInRank[j];
					gameInRank[j] = temp3;

					temp4 = userInRank[i];
					userInRank[i] = userInRank[j];
					userInRank[j] = temp4;
				}
			}
		}//Bubble sorting based on equal Win ratio value and according to draw ratio
		
		for (int i = 0; i < PlayerNumSet; i++) {
			for (int j = i + 1; j < PlayerNumSet; j++) {
				if (winRatio[i] == winRatio[j] && (drawRatio[i] == drawRatio[j])
						&& (userInRank[i].compareTo(userInRank[j]) > 0) 
						&& (!userInRank[i].equals(" "))
						&& (!userInRank[j].equals(" "))) {
					temp1 = winRatio[i];
					winRatio[i] = winRatio[j];
					winRatio[j] = temp1;

					temp2 = drawRatio[i];
					drawRatio[i] = drawRatio[j];
					drawRatio[j] = temp2;

					temp3 = gameInRank[i];
					gameInRank[i] = gameInRank[j];
					gameInRank[j] = temp3;

					temp4 = userInRank[i];
					userInRank[i] = userInRank[j];
					userInRank[j] = temp4;
				}
			}
		}//Bubble sorting based on equal Win ratio value, draw ratio according to alphabetical order
		System.out.println(" WIN  | DRAW | GAME | USERNAME");
		int cnt = 0;
		for (int i = 0; i < PlayerNumSet; i++) {
			if (!userInRank[i].equals("")) {
				System.out.printf(" %3.0f%% | %3.0f%% | %2.0f   | %s\n", 
						winRatio[i], drawRatio[i], gameInRank[i],userInRank[i]);
				cnt++;
				if (cnt == 10) {
					return;
				}
			}
		}//pint out the sorting list
	}
					        
    /*search player theod*/			
	public void searchPlayer(String userN1, String userN2) {
		exist1 = false;//set initial value
		exist2 = false;
		for (int i = 0; i < PlayerNumSet; i++) {
			if (player[i].getUsername().equals(userN1)) {
				exist1 = true;
				givenNameForGame1=player[i].getGivenName();
			}
		}
		for (int j = 0; j < PlayerNumSet; j++) {
			if (player[j].getUsername().equals(userN2)) {
				exist2 = true;
				givenNameForGame2 =player[j].getGivenName();
			}
		}
	}
	
	public void searchAIPlayer(String userN1,String userN2) {
		AIexist1 = false;//set initial value
		AIexist2 = false;
	for (int i = 0; i < PlayerNumSet; i++) {
			if (player[i].getUsername().equals(userN1)
					&&player[i].getPlayerType().equals("AI")) {
				AIexist1 = true;
				//givenNameForGame1=player[i].getGivenName();
			}
		}
	for (int j = 0; j < PlayerNumSet; j++) {
		if (player[j].getUsername().equals(userN2)
				&&player[j].getPlayerType().equals("AI")) {
			AIexist2 = true;
			//givenNameForGame1=player[i].getGivenName();
		}
	}
	}

	
	
	/*PlayWin method used to update the play statistics*/
	public void playerWin(String userN1, String userN2) {
		for (int i = 0; i < PlayerNumSet; i++) {
			if (userN1.equals(player[i].getUsername())) {
				player[i].setGame(1);
				player[i].setWin(1);
			}
		}
		for (int j = 0; j < PlayerNumSet; j++) {
			if (userN2.equals(player[j].getUsername())) {
				player[j].setGame(1);
			}
		}

	}
	
	/* playerDraw method used to update the play statistics */
	public void playerDraw(String userN1, String userN2) {
		for (int i = 0; i < PlayerNumSet; i++) {
			if (player[i].getUsername().equals(userN1)) {
				player[i].setGame(1);
				player[i].setDraw(1);
			}
		}
		for (int j = 0; j < PlayerNumSet; j++) {
			if (player[j].getUsername().equals(userN2)) {
				player[j].setGame(1);
				player[j].setDraw(1);
			}

		}
	}
	
	/*readFileByLines method used to read the file*/
	public void readFileByLines() {
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream("players.dat"));
		} catch (FileNotFoundException e) {
			return;
		}

		while (inputStream.hasNextLine()) {
			inputForRead = (inputStream.nextLine()).split("\\ ");

			for (int i = 0; i < PlayerNumSet; i++) {
				if (player[i].getUsername().equals("")) {
					player[i].setUsername(inputForRead[0]);
					player[i].setFamilyName(inputForRead[1]);
					player[i].setGivenName(inputForRead[2]);
					player[i].setGame(Double.parseDouble(inputForRead[3]));
					player[i].setWin(Double.parseDouble(inputForRead[4]));
					player[i].setDraw(Double.parseDouble(inputForRead[5]));
					player[i].setPlayerType(inputForRead[6]);;
					break;
				}
				
			}
		}
		inputStream.close();
	}
	/*WritefileByLines method used to write the file*/
	public void WritefileByLines(String fileName) {
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileOutputStream(fileName));
		} catch (FileNotFoundException e) {
			System.exit(0);
		}
		for (int i = 0; i < PlayerNumSet; i++) {
			if (!player[i].getUsername().equals("")) {

				outputStream.println(
						player[i].getUsername() + " " + player[i].getFamilyName() 
						+ " " + player[i].getGivenName() + " "+ player[i].getGame() 
						+ " " + player[i].getWin() + " " + player[i].getDraw()
						+" " +player[i].getPlayerType());
			}
		}
		outputStream.close();
	}
}
