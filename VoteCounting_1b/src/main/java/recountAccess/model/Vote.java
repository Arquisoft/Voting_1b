package recountAccess.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vote {

	@Id
	@GeneratedValue
	private Long id;
	private String party;
    private Integer pollingStationCode;
	
	public Vote() {}
	
	public Vote(String party, Integer pollingStationCode) {
		super();
		this.party = party;
		this.pollingStationCode = pollingStationCode;
	}



	public void setPollingStationCode(Integer pollingStationCode) {
		this.pollingStationCode = pollingStationCode;
	}

	public Integer getPollingStationCode() {
		return pollingStationCode;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	
}
