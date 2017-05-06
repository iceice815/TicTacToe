/*ProjectC
 *@author:Bing Xie
 *Student ID:741012
 *Date:5/26/2016
 */
public class BadInputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String command;

	public BadInputException(){
		
	}

	public BadInputException(String command){
	this.command=command;
		if (command=="addplayer"){	
			return;
		}
		else if (command=="editplayer"){
			return;
		}
		else if (command=="addaiplayer"){
			return;
		}
		else if (command=="removeplayer"){	
			return;
		}
		else if (command=="displayplayer"){
			return;
		}
		else if (command=="resetstats"){
			return;
		}
		else if (command=="rankings"){	
			return;
		}
		else if (command=="playgame"){
			return;
		}
		else if (command=="exit"){	
			return;
		}
		
	}

	public String getBadCommand ()
    {
        return command;
    }
	




}
