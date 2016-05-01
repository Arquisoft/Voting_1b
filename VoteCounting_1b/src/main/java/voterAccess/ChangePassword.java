package voterAccess;

public interface ChangePassword {
	public boolean isClavesCoinciden();
	
	
	public String getClaveAnterior();
	public void setClaveAnterior(String claveAnterior);
	public String getClaveNueva();
	public void setClaveNueva(String claveNueva);
	public String getConfirmacionClave();
	public void setConfirmacionClave(String confirmacionClave);
}
