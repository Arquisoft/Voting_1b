package es.uniovi.asw.dbupdate.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USUARIOS")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="name")
	private String nombre;
	@Column(name="ename", unique=true)
	private String mail;
	@Column(unique=true)
	private String nif;
	@ManyToOne
	private ElectoralCollege codigoColegio;
	@Column(name="pass")
	private String contrasena;
	@OneToMany(mappedBy="user")
	private List<TelematicVoter> telematicVote;
	@Column(name="admin")
	private boolean admin;
	
	

	public boolean isAdmin() {
		return admin;
	}

	User(){
		admin=false;
	}

	public User(String nombre, String mail, String nif, ElectoralCollege codigoColegio){
		super();
		this.nombre=nombre;
		this.mail=mail;
		this.nif=nif;
		this.codigoColegio=codigoColegio;			
		this.admin=false;
	}

	public String getNombre() {
		return nombre;
	}

	public String getMail() {
		return mail;
	}

	public String getNif() {
		return nif;
	}
	public String getUser() {
		return mail;
	}

	public ElectoralCollege getCodigoColegio() {
		return codigoColegio;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena=contrasena;
	}
	public List<TelematicVoter> getTelematicVote() {
			return telematicVote;
		}
		public void setTelematicVote(List<TelematicVoter> telematicVote) {
			this.telematicVote = telematicVote;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nif == null) ? 0 : nif.hashCode());
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nif == null) {
			if (other.nif != null)
				return false;
		} else if (!nif.equals(other.nif))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}


}
