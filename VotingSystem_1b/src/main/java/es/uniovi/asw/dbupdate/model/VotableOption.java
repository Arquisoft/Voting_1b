package es.uniovi.asw.dbupdate.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class VotableOption {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String descripcion;
	@ManyToOne
	private ConfigurationElection configurationElection;
	@OneToMany(mappedBy="elementoVotable")
	private List<Vote> votos;

	public List<Vote> getVotos() {
		return votos;
	}

	public void setVotos(List<Vote> votos) {
		this.votos = votos;
	}

	VotableOption() { }
	
	public VotableOption(String nombre, String descripcion,
			ConfigurationElection configurationElection) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.configurationElection = configurationElection;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ConfigurationElection getConfigurationElection() {
		return configurationElection;
	}

	public void setConfigurationElection(ConfigurationElection configurationElection) {
		this.configurationElection = configurationElection;
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
		VotableOption other = (VotableOption) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}
	
}
