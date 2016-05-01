package recountAccess.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class User{
	
	private static final Logger log = LoggerFactory.getLogger(UserInfo.class);

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String login;
    private String password;
    private String name;
    private String nif;
    private Long pollingStationCode;

    public User(){
    	
    }
    
    public User(String email, String pass, String name, String nif, Long pollingStationCode) {
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

	public long getPollingStationCode() {
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
			if (other.getLogin() != null)
				return false;
		} else if (!login.equals(other.getLogin()))
			return false;
		if (name == null) {
			if (other.getName() != null)
				return false;
		} else if (!name.equals(other.getName()))
			return false;
		if (nif == null) {
			if (other.getNif() != null)
				return false;
		} else if (!nif.equals(other.getNif()))
			return false;
		if (password == null) {
			if (other.getPassword() != null)
				return false;
		} else if (!password.equals(other.getPassword()))
			return false;
		if (pollingStationCode == null) {
			if (other.getPollingStationCode() != null)
				return false;
		} else if (!pollingStationCode.equals(other.getPollingStationCode()))
			return false;
		return true;
	}

	public long getId() {
		return this.id;
	}
	
	
}