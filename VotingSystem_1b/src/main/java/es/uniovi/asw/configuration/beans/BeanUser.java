package es.uniovi.asw.configuration.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.Vote;

@ManagedBean(name = "votante")
@SessionScoped
public class BeanUser implements Serializable{

	//faltan las etiquetas de managed property
	
	private Long idUser;
	private String nombre;
	private String mail;
	private String nif;
	private String codigoColegio;
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getCodigoColegio() {
		return codigoColegio;
	}
	public void setCodigoColegio(String codigoColegio) {
		this.codigoColegio = codigoColegio;
	}
	
	
	
	
	public String votar(ConfigurationElection el, Vote susOpciones){
		
		//llamar a dbupdate para votar ^
		return "exito";
	}
	
	
}