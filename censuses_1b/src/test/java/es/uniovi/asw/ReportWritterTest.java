package es.uniovi.asw;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.DBUpdate.Votante;
import es.uniovi.asw.reportWriter.impl.WReportP;

public class ReportWritterTest {

	@Before
	public void setUp() throws Exception {
		//limpiar el fichero .log antes de cada test
		Writer output;
		output = new BufferedWriter(new FileWriter("report.log"));
		output.write("");
		output.close();
	}

	
	
	@Test(expected = IllegalArgumentException.class) 
	public void testVotanteNull() throws Exception {
		//comprobar que no se puede pasar info incorrecta
		WReportP r = new WReportP();
		Votante v=null;
		r.writeReport(v, "noExiste", "SinRazon");
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testFicheroExcelNull() throws Exception {
		//comprobar que no se puede pasar info incorrecta
		WReportP r = new WReportP();
		Votante v=new Votante("NombreFalso", "MailFalso", "dniFalso", "CodigoFalso");
		r.writeReport(v, null, "");
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testRazonNull() throws Exception {
		//comprobar que no se puede pasar info incorrecta
		WReportP r = new WReportP();
		Votante v=new Votante("NombreFalso", "MailFalso", "dniFalso", "CodigoFalso");
		r.writeReport(v, "noExiste", null);
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testRazonVacia() throws Exception {
		//comprobar que no se puede pasar info incorrecta
		WReportP r = new WReportP();
		Votante v=new Votante("NombreFalso", "MailFalso", "dniFalso", "CodigoFalso");
		r.writeReport(v, "noExiste", "");
	}
	@Test(expected = IllegalArgumentException.class) 
	public void testFicheroVacio() throws Exception {
		//comprobar que no se puede pasar info incorrecta
		WReportP r = new WReportP();
		Votante v=new Votante("NombreFalso", "MailFalso", "dniFalso", "CodigoFalso");
		r.writeReport(v, "", "Razon falsa");
	}

	
	@Test(expected = IllegalArgumentException.class) 
	public void testFicheroExcelNullSinVotante() throws Exception {
		//comprobar que no se puede pasar info incorrecta
		WReportP r = new WReportP();
		r.writeReport(null, "razon falsa");
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testRazonNullSinVotante() throws Exception {
		//comprobar que no se puede pasar info incorrecta
		WReportP r = new WReportP();
		r.writeReport("noExiste", null);
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testRazonVaciaSinVotante() throws Exception {
		//comprobar que no se puede pasar info incorrecta
		WReportP r = new WReportP();
		r.writeReport("noExiste", "");
	}
	@Test(expected = IllegalArgumentException.class) 
	public void testFicheroVacioSinVotante() throws Exception {
		//comprobar que no se puede pasar info incorrecta
		WReportP r = new WReportP();
		r.writeReport("", "Razon falsa");
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testRazonVaciaSinVotanteNiFichero() throws Exception {
		//comprobar que no se puede pasar info incorrecta
		WReportP r = new WReportP();
		r.writeReport("");
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testRazonNullSinVotanteNiFichero() throws Exception {
		//comprobar que no se puede pasar info incorrecta
		WReportP r = new WReportP();
		r.writeReport(null);
	}
	
	@Test
	public void testGuardaUnaLineaEnElFichero() throws Exception {
		
		//comprobar que guarda una linea con la informacion correcta
		WReportP r = new WReportP();
		r.writeReport("origen", "RazonFalsa");
		
		BufferedReader lector= new BufferedReader(new FileReader("report.log"));
		String linea= lector.readLine();
		assertTrue(linea.contains("RazonFalsa"));
		assertTrue(linea.contains("origen"));
		lector.close();
		
	}
	
	@Test
	public void testGuardaDosLineaEnElFichero() throws Exception {
		//comprobar que guarda varios reportes en lineas diferentes con la informacion correcta
		WReportP r = new WReportP();
		r.writeReport("origen", "RazonFalsa");
		r.writeReport("origenDiferente", "Razon2");
		BufferedReader lector= new BufferedReader(new FileReader("report.log"));
		String linea= lector.readLine();
		assertTrue(linea.contains("RazonFalsa"));
		assertTrue(linea.contains("origen"));
		linea= lector.readLine();
		assertTrue(linea.contains("Razon2"));
		assertTrue(linea.contains("origenDiferente"));
		lector.close();
	}
	
	@Test
	public void testLlamandoALosDosMetodosRepetidasVeces() throws Exception {
		//comprobar que se pueden llamar a ambos metodos 
		WReportP r = new WReportP();
		r.writeReport("origen", "RazonFalsa");
		r.writeReport("origenDiferente", "Razon2");
		Votante v=new Votante("NombreFalso", "MailFalso", "dniFalso", "CodigoFalso");
		r.writeReport(v, "ahoraConVotante", "3 lineas");
		BufferedReader lector= new BufferedReader(new FileReader("report.log"));
		String linea= lector.readLine();
		assertTrue(linea.contains("RazonFalsa"));
		assertTrue(linea.contains("origen"));
		linea= lector.readLine();
		assertTrue(linea.contains("Razon2"));
		assertTrue(linea.contains("origenDiferente"));
		linea= lector.readLine();
		assertTrue(linea.contains("dniFalso"));
		assertTrue(linea.contains("ahoraConVotante"));
		assertTrue(linea.contains("3 lineas"));
		lector.close();	
		
	}

}
