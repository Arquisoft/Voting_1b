package es.uniovi.asw.reportWriter;

import java.io.IOException;

import es.uniovi.asw.DBUpdate.Votante;

public interface WriteReport {

	
	
	public void writeReport(Votante v,String ficheroExcelProcedencia, String razon) throws IOException;
	public void writeReport(String ficheroExcelProcedencia,String razon) throws IOException;
	public void writeReport(String razon) throws IOException;
}
