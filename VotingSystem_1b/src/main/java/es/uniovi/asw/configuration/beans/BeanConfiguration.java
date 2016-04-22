package es.uniovi.asw.configuration.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import es.uniovi.asw.configuration.business.impl.SimpleConfigService;
import es.uniovi.asw.configuration.business.impl.SimpleVotableOptionService;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.VotableOption;

@Component
public class BeanConfiguration extends ConfigurationElection implements Serializable {
	
	public BeanConfiguration() {
		super();
	}

	@PostConstruct
	public void init() {
		getVotableOptions().add(new VotableOption("","",this));	
		getVotableOptions().add(new VotableOption("","",this));		
	}
	
	private static final long serialVersionUID = 6L;
	private int numOptions = 2;
	private int numOptionsOld = 2;
	private Date hoy = new Date ();
	
	public int getNumOptions() {
		return numOptions;
	}

	public void setNumOptions(int numOptions) {
		this.numOptions = numOptions;
	}

	public String configura() {
		WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		SimpleConfigService serviceConfig = ctx.getBean(SimpleConfigService.class);
		SimpleVotableOptionService serviceVo = ctx.getBean(SimpleVotableOptionService.class);
		FacesContext fc = FacesContext.getCurrentInstance();		
		try {
			ConfigurationElection conf = new ConfigurationElection(getName(), getDescription(), getApplicationStart(),
					getApplicationEnd(), getVotationStart(), getVotationEnd(), getVotableOptions(), getElectoralColleges(),
					isMultipleVoting());
			relacionaOpcionesVotoConf(getVotableOptions(), conf);
			serviceConfig.saveConfiguration(conf);
			serviceVo.saveVotableOption(getVotableOptions());
			fc.addMessage("laInfo", new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Se ha guardado su configuración."));
			} catch (Exception e) {
				fc.addMessage("elError", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al guardar la configuración"));
				return null;
				}
		
		return null;
		}
	
	public String opcionesVoto() {
		if(numOptions > numOptionsOld)
			for(int i = 0; i<(numOptions-numOptionsOld); i++)	
				getVotableOptions().add(new VotableOption("","",this));	
		else
			for(int i = 0; i<(numOptionsOld-numOptions); i++)		
				getVotableOptions().remove(getVotableOptions().size() - 1);
		numOptionsOld = numOptions;
		return null;		
	}
	

	public Date getHoy() {
		return hoy;
	}

	public void setHoy(Date hoy) {
		this.hoy = hoy;
	}
	
	private void relacionaOpcionesVotoConf(List<VotableOption> vo, ConfigurationElection conf) {
		for(VotableOption i:vo)
		{
			i.setConfigurationElection(conf);
		}
	}
}
	