/*ProjectC
 *@author:Bing Xie
 *Student ID:741012
 *Date:5/26/2016
 */
public class AIPlayer extends Player {

	/* Constructors */
	public AIPlayer(String playerType) {
		super(playerType);
	}

	@Override
		public Move makeMove(String[][] chessboard) {
		int row=0,column=0;
		//Move mv=new Move();	
		for(row=0;row<chessboard.length;row++){
				for(column=0;column<chessboard[row].length;column++){
					if (chessboard[row][column].equals(" ")){
						mv.setRow(row);
						mv.setColumn(column);
						return mv;  
					   
					}
					
				}
				
			}
			return mv ;
	}
}
