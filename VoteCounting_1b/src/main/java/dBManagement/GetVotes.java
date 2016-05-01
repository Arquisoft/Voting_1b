package dBManagement;

import java.util.List;

public interface GetVotes {

	List<Object[]> countAllVotes();
	List<Object[]> findAllPollingStations();
	List<Object[]> findVotersByPollingStationAndParty();
	List<Object[]> findVotesByPollingStationAndParty(Integer sc);
	List<Object[]> findStationCodes();
	List<String> findPartidos();
	List<Object[]> findVotespartido(String sc);
	
}
