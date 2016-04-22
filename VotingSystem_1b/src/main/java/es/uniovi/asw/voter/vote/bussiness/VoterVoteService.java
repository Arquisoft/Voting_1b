package es.uniovi.asw.voter.vote.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.TelematicVoter;
import es.uniovi.asw.dbupdate.model.User;
import es.uniovi.asw.dbupdate.model.VotableOption;
import es.uniovi.asw.dbupdate.model.Vote;
import es.uniovi.asw.dbupdate.repositories.TelematicVoterDAO;
import es.uniovi.asw.dbupdate.repositories.UserDAO;
import es.uniovi.asw.dbupdate.repositories.VotableOptionDAO;
import es.uniovi.asw.dbupdate.repositories.VoteDAO;
import es.uniovi.asw.voter.application.exception.InvalidUserException;
import es.uniovi.asw.voter.vote.exception.AlredyVotedException;
import es.uniovi.asw.voter.vote.exception.BusinessException;

@Component
public class VoterVoteService {
	
	@Autowired
	VotableOptionDAO vd;
	
	@Autowired(required=true)
	private UserDAO ud;
	@Autowired(required=true)
	private TelematicVoterDAO td;
	@Autowired(required=true)
	private VoteDAO votoDao;
	
	public List<VotableOption> getVotableOptions(ConfigurationElection configurationElection){
		List<VotableOption> votableOptions = vd.findByConfigurationElection(configurationElection);
		
		return votableOptions;
	}
	
	public void voteOnElection(ConfigurationElection c, Vote v, String email, String password) throws InvalidUserException, BusinessException, AlredyVotedException {
	
		User user = ud.findByMailAndContrasena(email, password);

		if(user == null){
			throw new InvalidUserException("Usuario incorrecto.");
		}
		
		TelematicVoter miVotoTelematico=td.findByUserAndConfigurationElection(user, c);
		v.setColegio(user.getCodigoColegio());
		
		if(miVotoTelematico == null){
			throw new BusinessException("No habias pedido voto telematico.");
		}
		
		if(miVotoTelematico.isVoted()){
			throw new AlredyVotedException("Ya has votado en esta votacion.");
		}
		
		miVotoTelematico.setVoted(true);
		td.save(miVotoTelematico);
		
		votoDao.save(v);
		
	}


}
