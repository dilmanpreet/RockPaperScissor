import static org.junit.Assert.assertEquals;
import org.junit.Test;

// javac -cp '.;junit.jar" *.java && java -cp ".;junit.jar" org.junit.runner.JUnitCore RPStest

public class RPStest {
/*
A game of rps between 2 players a and b.
We see who wins and all the possible test cases
*/
	@Test
	public void awins() {
		//Test case for cases where a will win
		//("expected", "actual");
		assertEquals(-1,RPS.round('p','r'));
		assertEquals(-1,RPS.round('s','p'));
		assertEquals(-1,RPS.round('r','s'));

	}

	@Test
	public void bwins(){
		//Test case for cases where b will win

		assertEquals(1,RPS.round('r','p'));
		assertEquals(1,RPS.round('p','s'));
		assertEquals(1,RPS.round('s','r'));

	}
	@Test
	public void tie(){
		//Test case for cases where no one will win

		assertEquals(0,RPS.round('r','r'));
		assertEquals(0,	RPS.round('p','p'));
		assertEquals(0,RPS.round('s','s'));

	}
	@Test
	public void tournamentAwonBefore20(){
		//Test case for tournament where A will win before 20 rounds

		assertEquals(-1,RPS.tournament("pppppppppprrrrrrrrrrrrrrr","rrrrrrrrrrsssssssssssssss"));
		assertEquals(-1,RPS.tournament("prrrrspspssrsrprpprrsssrs","rspsrssrprpsrsssrspssssrs"));
		assertEquals(-1,RPS.tournament("rsssrpsrpprrrpsrsrrrsssrs","rspsrssrprpsrsssrspssssrs"));


	}
	@Test
	public void tournamentBwonBefore20(){
		//Test case for tournament where B will win before 20 rounds

		assertEquals(1,RPS.tournament("pppppppppprrrrrrrrrrsssrs","ssssssssssppppppppppsssrs"));
		assertEquals(1,RPS.tournament("rsssrpsrpprrrpsrsrrrsssrs","srpspsssrsspprrrsrspsssrs"));
		assertEquals(1,RPS.tournament("sssssprpprprrsrrsspsssssrs","srpsspsssrsspprrrsrssssrs"));
	}
	@Test
	public void tournamentTieAt20(){
		//Test case for cases where no one will win upto 20 rounds

		assertEquals(0,RPS.tournament("pppppppppprrrrrrrrrrrssrs","pppppppppprrrrrrrrrrrssrs"));
		assertEquals(0,RPS.tournament("ssssssssssppppppppppsssrs","ssssssssssppppppppppsssrs"));
		assertEquals(0,RPS.tournament("rsssrpsrpprrrpsrsrrrsssrs","rsssrpsrpprrrpsrsrrrsssrs"));

	}
	@Test
	public void tournamentWonByAafter20(){
		//Test case for cases where A wins in death round

		assertEquals(-1,RPS.tournament("rrrrrrrrrrrrrrrrrrrrrrrrr","rrrrrrrrrrrrrrrrrrrrrrsrr"));
		assertEquals(-1,RPS.tournament("sssssssssssssssssssssssss","ssssssssssssssssssssspsss"));
		assertEquals(-1,RPS.tournament("ppppppppppppppppppppppppp","ppppppppppppppppppppppppr"));

	}

	@Test
	public void tournamentWonByBafter20(){
		//Test case for cases where B wins in death round

		assertEquals(1,RPS.tournament("rrrrrrrrrrrrrrrrrrrrrrrrr","rrrrrrrrrrrrrrrrrrrrrrprr"));
		assertEquals(1,RPS.tournament("sssssssssssssssssssssssss","sssssssssssssssssssssrsss"));
		assertEquals(1,RPS.tournament("ppppppppppppppppppppppppp","pppppppppppppppppppppppsp"));

	}


}
