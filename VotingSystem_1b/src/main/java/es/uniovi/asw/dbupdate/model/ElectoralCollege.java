package es.uniovi.asw.dbupdate.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ElectoralCollege {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String codigo;
	@OneToMany(mappedBy="codigoColegio")
	private List<User> usuarios;
	@ManyToOne
	private ConfigurationElection configurationElection;
	@OneToMany(mappedBy="colegio")
	private Set<Vote> votos;

	ElectoralCollege() { }
	
	public ElectoralCollege(String codigo,
			ConfigurationElection configurationElection) {
		super();
		this.codigo = codigo;
		this.configurationElection = configurationElection;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public ConfigurationElection getConfigurationElection() {
		return configurationElection;
	}

	public void setConfigurationElection(ConfigurationElection configurationElection) {
		this.configurationElection = configurationElection;
	}

	public String getCodigoColegio() {
		return codigo;
	}
	public List<User> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<User> usuarios) {
		this.usuarios = usuarios;
	}
	public Set<Vote> getVotos() {
		return votos;
	}

	public void setVotos(Set<Vote> votos) {
		this.votos = votos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		ElectoralCollege other = (ElectoralCollege) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
