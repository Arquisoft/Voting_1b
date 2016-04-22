package es.uniovi.asw.dbupdate.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.dbupdate.model.Vote;

@Repository
public interface VoteDAO  extends CrudRepository<Vote, Long> { 

	  
}
