package hello;

import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.NotEmpty;

public class CambiarClave {

	@NotEmpty
	private String claveAnterior;
	@NotEmpty
	private String claveNueva;
	@NotEmpty
	private String confirmacionClave;
	
	@AssertTrue(message = "Las claves no coinciden")
	public boolean isClavesCoinciden() {
		if (claveNueva != null && confirmacionClave != null) {
			return claveNueva.equals(confirmacionClave);
		}
		return false;
	}
	
	
	public String getClaveAnterior() {
		return claveAnterior;
	}
	public void setClaveAnterior(String claveAnterior) {
		this.claveAnterior = claveAnterior;
	}
	public String getClaveNueva() {
		return claveNueva;
	}
	public void setClaveNueva(String claveNueva) {
		this.claveNueva = claveNueva;
	}
	public String getConfirmacionClave() {
		return confirmacionClave;
	}
	public void setConfirmacionClave(String confirmacionClave) {
		this.confirmacionClave = confirmacionClave;
	}

}
