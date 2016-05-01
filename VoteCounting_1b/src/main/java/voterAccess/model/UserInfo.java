package voterAccess.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class UserInfo {
	
	private static final Logger log = LoggerFactory.getLogger(UserInfo.class);

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String login;
    private String password;
    private String name;
    private String nif;
    private Integer pollingStationCode;

    public UserInfo(){
    	
    }
    
    public UserInfo(String email, String pass, String name, String nif, Integer pollingStationCode) {
    	log.info("Creating user " + email + ". pass: " + pass);
        this.login= email;
        this.password = pass;
        this.name=name;
        this.nif=nif;
        this.pollingStationCode=pollingStationCode;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
    
    public static Logger getLog() {
		return log;
	}

	public String getName() {
		return name;
	}

	public String getNif() {
		return nif;
	}

	public Integer getPollingStationCode() {
		return pollingStationCode;
	}

	public void changePassword(String pass){
    	this.password=pass;
    }

	@Override
	public String toString() {
		return "UserInfo [login=" + login + ", pass=" + password + ", name=" + name + ", nif=" + nif
				+ ", pollingStationCode=" + pollingStationCode + "]";
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nif == null) ? 0 : nif.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((pollingStationCode == null) ? 0 : pollingStationCode.hashCode());
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
		UserInfo other = (UserInfo) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nif == null) {
			if (other.nif != null)
				return false;
		} else if (!nif.equals(other.nif))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (pollingStationCode == null) {
			if (other.pollingStationCode != null)
				return false;
		} else if (!pollingStationCode.equals(other.pollingStationCode))
			return false;
		return true;
	}
	
	
}