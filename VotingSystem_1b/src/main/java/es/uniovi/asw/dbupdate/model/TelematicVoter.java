package es.uniovi.asw.dbupdate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Votantes_Telematicos")
public class TelematicVoter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private User user;
	private boolean voted;
	@ManyToOne
	private ConfigurationElection configurationElection;
	
	TelematicVoter(){ }
	
	public TelematicVoter(User user, boolean voted,
			ConfigurationElection configurationElection) {
		super();
		this.user = user;
		this.voted = voted;
		this.configurationElection = configurationElection;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isVoted() {
		return voted;
	}

	public void setVoted(boolean voted) {
		this.voted = voted;
	}

	public ConfigurationElection getConfigurationElection() {
		return configurationElection;
	}

	public void setConfigurationElection(ConfigurationElection configurationElection) {
		this.configurationElection = configurationElection;
	}
	
	public Long getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TelematicVoter other = (TelematicVoter) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
