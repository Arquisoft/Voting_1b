package recountAccess.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import recountAccess.model.Vote;

public interface VoteRepository extends CrudRepository<Vote, Long> {

	@Query("SELECT v.party, COUNT(v.id) FROM Vote v GROUP BY v.party")
	List<Object[]> countAllVotes();

	//@Query("SELECT DISTINCT v.pollingStationCode FROM Vote v GROUP BY v.party")
	@Query("SELECT DISTINCT v.pollingStationCode, COUNT(v.id) FROM Vote v GROUP By v.pollingStationCode")
	List<Object[]> findAllPollingStations();
	
	//Obtención de los votos por partido y colegio
	@Query("SELECT  v.pollingStationCode, v.party, COUNT(v.id) FROM Vote v GROUP By v.pollingStationCode,v.party ORDER BY v.pollingStationCode")
	List<Object[]> findVotersByPollingStationAndParty();
	
	//Obtención de los votos por partido y colegio
	@Query("SELECT  v.party, COUNT(v.id) FROM Vote v  WHERE v.pollingStationCode=? GROUP By v.party")
	List<Object[]> findVotesByPollingStationAndParty(Integer sc);
	
	
	//Obtención de los colegios
	@Query("SELECT DISTINCT v.pollingStationCode FROM Vote v")
	List<Object[]> findStationCodes();
	
	//Obtención de los colegios
	@Query("SELECT DISTINCT v.party FROM Vote v")
	List<Object[]> findPartidos();
	
	//Obtención de los votos dado partido y colegio
	@Query("SELECT  v.pollingStationCode, COUNT(v.id) FROM Vote v  WHERE v.party=? GROUP By v.pollingStationCode")
	List<Object[]> findVotespartido(String sc);
	
}
