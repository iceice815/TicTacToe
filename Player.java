/*ProjectC
 *@author:Bing Xie
 *Student ID:741012
 *Date:5/26/2016
 */
public abstract class Player {
	private String username;
	private String familyName;
	private String givenName;
	private double game ;
	private double win ;
	private double draw;
	private String playerType;
	public Move mv=new Move();
	/* Constructors */
	public Player(String playerType) {
			username="";
			familyName="";
			givenName="";
			game=0;
			win=0;
			draw=0;
			this.playerType=playerType;
			
	} 
	
	public abstract Move makeMove(String [][]chessboard );
	{
		
	}
	/* Accessors */
	public String getUsername() {
		return username;
	}
	
	public String getPlayerType() {
		return playerType;
	}

	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}

	public String getFamilyName() {
		return familyName;
	}
	
	public String getGivenName() {
		return givenName;
	}
	
	public double getWin() {
		return win;
	}
	
	public double getGame() {
		return game;
		
	}
	
	public double getDraw() {
		return draw;
	}
	/* Mutators */
	public void setUsername(String username) {
		this.username = username;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}


	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}



	public void setGame(double game) {
		if(game==0){
			this.game=0;
		}
		else{
		this.game = this.game+game;
		}
	}


	public void setWin(double win) {
		if(win==0){
			this.win=0;
		}
		else{
		this.win =this.win+ win;
		}
	}


	public void setDraw(double draw) {
		if(draw==0){
			this.draw=0;
		}
		else{
		this.draw = this.draw+draw;
		}
	}

}


