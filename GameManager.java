/*ProjectC
 *@author:Bing Xie
 *Student ID:741012
 *Date:5/26/2016
 */
public class GameManager {
	public  int row, column; // used as input position
	public static final int SIZE = 3; // size of TicTacToe
	public  String[][] chessboard = new String[SIZE][SIZE]; //2-dimensional array as chessbord
	public  String whoWin; // used to judge the winner
	public boolean Owin;//returned to konw player O win
	public boolean Xwin;//returned to know player X win
	public Player HumanPlayer=new HumanPlayer("H");
	public Player AIPlayer=new AIPlayer("AI");
	public void playGame(String userN1, String userN2) {
		Owin = false;
		Xwin = false;
		whoWin = null;
		String blankChess = " ";
		// initialize the state of game
		String nameO = userN1;
		String nameX = userN2;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				chessboard[i][j] = blankChess;
			}
		} // initialize the chessboard

		printGrid();// show the blank chessboard

		for (int moveNum = 0; moveNum < SIZE * SIZE;) {
			if (moveNum % 2 == 0) // even movenum for playerO
			{
				System.out.println(nameO + "'s move:");
				
				if(TicTacToe.AIexist1==false){
					HumanPlayer.makeMove(chessboard);
		            
					row=HumanPlayer.mv.getRow();
		            column=HumanPlayer.mv.getColumn();
					}
					else{
						AIPlayer.makeMove(chessboard);
			            row=AIPlayer.mv.getRow();
			            column=AIPlayer.mv.getColumn();
					}
				while (row >= SIZE || row < 0 || column >= SIZE || column < 0 || chessboard[row][column].equals("X")
						|| chessboard[row][column].equals("O")) {
					while (row >= SIZE || row < 0 || column >= SIZE || column < 0) {
						System.out.println("Invalid move. You must place at a cell within {0,1,2} {0,1,2}.\n"
								+ nameO + "'s move:");			
						if(TicTacToe.AIexist1==false){
							HumanPlayer.makeMove(chessboard);
				            
							row=HumanPlayer.mv.getRow();
				            column=HumanPlayer.mv.getColumn();
							}
							else{
								AIPlayer.makeMove(chessboard);
					            row=AIPlayer.mv.getRow();
					            column=AIPlayer.mv.getColumn();
							}
					} // dealing with out of range
					while (chessboard[row][column].equals("X") || chessboard[row][column].equals("O")) {
						System.out.println("Invalid move. The cell has been occupied.\n" + nameO + "'s move:");
						if(TicTacToe.AIexist1==false){
							HumanPlayer.makeMove(chessboard);
				            
							row=HumanPlayer.mv.getRow();
				            column=HumanPlayer.mv.getColumn();
							}
							else{
								AIPlayer.makeMove(chessboard);
					            row=AIPlayer.mv.getRow();
					            column=AIPlayer.mv.getColumn();
							}
						break;
					} // dealing with and occupied input

				} // dealing with out of range or occupied input

				chessboard[row][column] = "O";// record playerO' input
				moveNum++;// record the total move numbers
			} else // odd movenum for playerX
			{
				System.out.println(nameX + "'s move:");
				if(TicTacToe.AIexist2==false){
					HumanPlayer.makeMove(chessboard);
		            
					row=HumanPlayer.mv.getRow();
		            column=HumanPlayer.mv.getColumn();
					}
					else{
						AIPlayer.makeMove(chessboard);
			            row=AIPlayer.mv.getRow();
			            column=AIPlayer.mv.getColumn();
					}
				while (row >= SIZE || row < 0 || column >= SIZE || column < 0 || chessboard[row][column].equals("X")
						|| chessboard[row][column].equals("O")) {
					while (row >= SIZE || row < 0 || column >= SIZE || column < 0) {
						System.out.println(
								"Invalid move. You must place at a cell within {0,1,2} {0,1,2}.\n" + nameX + "'s move:");
						if(TicTacToe.AIexist2==false){
							HumanPlayer.makeMove(chessboard);
				            
							row=HumanPlayer.mv.getRow();
				            column=HumanPlayer.mv.getColumn();
							}
							else{
								AIPlayer.makeMove(chessboard);
					            row=AIPlayer.mv.getRow();
					            column=AIPlayer.mv.getColumn();
							}
					} // dealing with and occupied input
					while (chessboard[row][column].equals("X") || chessboard[row][column].equals("O")) {
						System.out.println("Invalid move. The cell has been occupied.\n" + nameX + "'s move:");
						if(TicTacToe.AIexist2==false){
							HumanPlayer.makeMove(chessboard);
				            
							row=HumanPlayer.mv.getRow();
				            column=HumanPlayer.mv.getColumn();
							}
							else{
								AIPlayer.makeMove(chessboard);
					            row=AIPlayer.mv.getRow();
					            column=AIPlayer.mv.getColumn();
							}
						break;
					} // dealing with and occupied input
				} // dealing with out of range or occupied input
				chessboard[row][column] = "X";// record playerX' input as'X'
				moveNum++;
			}
			printGrid(); // show the chessboard

			getGameState();// get current gamestate

			if (whoWin == "PlayerX") {
				System.out.println("Game over. " + nameX + " won!");
				Xwin = true;//return the winner
				return;
			} else if (whoWin == "PlayerO") {
				System.out.println("Game over. " + nameO + " won!");
				Owin = true;//return the winner
				return;
			}

		} // print out the winner and exit the game

		System.out.println("Game over.It was a draw!");


	} // print out "it is a draw" if no value got from getGameState()

	public void getGameState() {
		String XwinCondition = "XXX", OwinCondition = "OOO";// XXX or OOO is win
															// state
		for (int i = 0; i < SIZE; i++) {
			if ((chessboard[i][0] + chessboard[i][1] + chessboard[i][2]).equals(XwinCondition)) {
				whoWin = "PlayerX";
			} else if ((chessboard[i][0] + chessboard[i][1] + chessboard[i][2]).equals(OwinCondition)) {
				whoWin = "PlayerO";
			} // judge row
			else if ((chessboard[0][i] + chessboard[1][i] + chessboard[2][i]).equals(XwinCondition)) {
				whoWin = "PlayerX";
			} else if ((chessboard[0][i] + chessboard[1][i] + chessboard[2][i]).equals(OwinCondition)) {
				whoWin = "PlayerO";
			} // judge column
		}
		if ((chessboard[0][0] + chessboard[1][1] + chessboard[2][2]).equals(XwinCondition)) {
			whoWin = "PlayerX";
		} else if ((chessboard[0][0] + chessboard[1][1] + chessboard[2][2]).equals(OwinCondition)) {
			whoWin = "PlayerO";
		} // judge diagonal
		else if ((chessboard[2][0] + chessboard[1][1] + chessboard[0][2]).equals(XwinCondition)) {
			whoWin = "PlayerX";
		} else if ((chessboard[2][0] + chessboard[1][1] + chessboard[0][2]).equals(OwinCondition)) {
			whoWin = "PlayerO";
		} // judge antidiagonal
	}

	public void printGrid() {

		int gridRow;// used as counter for print ever row of grid
		final int gridRowNum = 5;
		int i = 0;
		for (gridRow = 0; gridRow < gridRowNum; gridRow++) {
			if (gridRow % 2 == 0) {
				System.out.print(chessboard[i][0] + "|" + chessboard[i][1] + "|" + chessboard[i][2] + "\n");
				i++;
			} // printout the content of odd row
			else if (gridRow % 2 == 1) {
				System.out.print("-----\n");
			} // printout the content of even row
		}
	}
	
}
