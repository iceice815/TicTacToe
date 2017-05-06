/*ProjectC
 *@author:Bing Xie
 *Student ID:741012
 *Date:5/26/2016
 */
public class HumanPlayer extends Player {
	//Move mv=new Move();
	// Private fields

	/* Constructors */

	public HumanPlayer(String playerType) {
		super(playerType);

	}

	@Override
	public Move makeMove(String[][] chessboard) {
		int row=0,column=0;
		
		row = TicTacToe.in.nextInt();
		column = Integer.parseInt(TicTacToe.in.nextLine().replaceAll(" ", ""));
		mv.setRow(row);
		mv.setColumn(column);
		return mv;
	}

}
