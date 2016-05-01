package recountAccess.persistence;

import java.util.List;

public interface VoteDao {

	List<Object[]> countAllVotes();
	List<Object[]> findAllPollingStations();
	List<Object[]> findVotersByPollingStationAndParty();
	List<Object[]> findVotesByPollingStationAndParty(Integer sc);
	List<Object[]> findStationCodes();
	List<String> findPartidos();
	List<Object[]> findVotespartido(String sc);
	
}
