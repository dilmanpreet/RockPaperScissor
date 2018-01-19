/** A rock paper scissors tournament.
	CPSC 1181-003, Langara College, 201810

	@author Jeremy H < jhilliker (at) langara >  edited by Dilmanpreet nandu
	@version 1.0, 2018-01-10
*/
public class RPS {

	private final static int REG_ROUNDS = 20;
	private final static int WIN_LEAD = 3;
	private final static int DEATH_ROUNDS = 5;

	/** Play one round of RPS.
		Choices of 'r', 'p', or 's' shall follow standard RPS rules.
		A choice of 'r', 'p', or 's' shall always beat any other choice that is
		not one of 'r', 'p', or 's'. If both players choose something that is not
		'r', 'p', or 's', then they draw.

		@param a player A's choice
		@param b player B's choice
		@return -1 if player A's choice beat's player B's choice,
			1 if player B's choice beats player A's choice,
			0 otherwise.
	*/
	public static int round(char a, char b) {

		if(a=='p' && b=='r' ||		// cases where A will win`
			a=='s' && b=='p' ||
			a=='r' && b=='s')
				return -1;
		else if(a=='r' && b=='p' ||	// cases where B will WIN
				a=='p' && b=='s' ||
				a=='s' && b=='r')
				return 1;
		else
				return 0;		//tie

	}

	/** Plays a heads-up RPS tournament.
		A player wins the tournament if, at any point, they have won 3 more
		rounds than the other player. If the tournament reaches 20 rounds, then
		the player who has won the most rounds wins the tournament. If there is a
		tie after 20 rounds, then the tournament has 5 more rounds of sudden death
		play. In sudden death, the tournament is won by the first player to win a
		round. If all 25 rounds complete without a winner, then the tournament is
		a draw.

		@param a player A's choices. Must contain 25 choices of [rps]
		@param b player B's choices. Must contain 25 choices of [rps]
		@return -1 if player A wins the tournament,
			1 if player B wins the tournament,
			0 otherwise.
	*/
	public static int tournament(String a, String b) {
		int awon=0, bwon=0, tie=0;//tie not required but for future can be used
		int gameRound=0;		// the round number

		 //REG_ROUNDS = 20;
		 //WIN_LEAD = 3;
		 //DEATH_ROUNDS = 5;

		for(gameRound=0;gameRound<REG_ROUNDS; gameRound++) {
			int roundResult=0;	// the result of round . inital tie

			switch(roundResult=round(a.charAt(gameRound),b.charAt(gameRound))){

			case -1:roundResult=-1;		// not rquired but just a confirmation
					awon++;								// A incremented
					break;
			case 0: roundResult=0;
					tie++;								// not used for future development
					break;
			case 1:roundResult=-1;
					bwon++;					// b win incremented
					break;

			}

				int diff=Math.abs(awon-bwon);		// the difference of win

				if(awon!=bwon && diff>= WIN_LEAD) {		// if win > 2 winnner announcded
				if(awon>=WIN_LEAD)
					return -1;		// tournamentWonByA
				else if(bwon>=WIN_LEAD)
					return 1;	// tournamentWonByB
				}

		//System.out.println(gameRound+"gameR"+roundResult+"Awin"+ awon +"bWin"+ bwon+"dd"+diff);	// for testing



		}
			// continue if no one wins by difference of 3

			// result by more wins if diffence of win is less than 3
		if(awon>bwon)
			return -1;
		else if(bwon>awon)
			return 1;
		else {
			//death round for tie round after 20
			for(gameRound=REG_ROUNDS;gameRound<REG_ROUNDS+DEATH_ROUNDS; gameRound++) {
			int roundResult=0;	//the round just started with no  winner

			switch(roundResult=round(a.charAt(gameRound),b.charAt(gameRound))){

			case -1:roundResult=-1;	//awon
					awon++;
					break;
			case 0: roundResult=0;	//no one wins
					tie++;

					break;
			case 1:roundResult=1;	//bwon
					bwon++;
					break;

			}
			//System.out.println(gameRound+"deathR"+roundResult);	// debugging for death round


			if(roundResult!=0)		// declare winner right away if its not a tie
				return roundResult;


			}

			return 0;//end of 25 rounds no one wins game tie

		}




	}
}
