package es.uniovi.asw.parser.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.DocumentException;

import es.uniovi.asw.DBUpdate.Votante;
import es.uniovi.asw.parser.ReadCensus;
import es.uniovi.asw.reportWriter.impl.Comprobaciones;
import es.uniovi.asw.reportWriter.impl.WReportP;

public abstract class AbstractReadCensus implements ReadCensus{
	
	protected String ruta;
	protected GeneradorCartas generadorCartas;
	protected GeneradorContrasenas generadorContraseñas = new HashedGenerator();
	protected WReportP rW = new WReportP();

	public AbstractReadCensus(String ruta) {

		this(ruta, new GeneradorCartasTXT());

	}
	
	public AbstractReadCensus(String ruta, GeneradorCartas generadorCartas) {
		
		this.ruta = ruta;
		this.generadorCartas = generadorCartas;
		
	}
	
	protected abstract List<Votante> parserArchivo(File archivo) throws IOException;
	
	public List<Votante> loadCenso() throws DocumentException, IOException{
		
		File archivo = new File(ruta);
		
		if(archivo.exists()){
			
			List<Votante> votantesLeidos = parserArchivo(archivo);
			List<Votante> votantes = new ArrayList<Votante>();
			for(Votante votante : votantesLeidos){
				votante.setContrasena(generadorContraseñas.generar(votante));
				if(Comprobaciones.isVotanteCorreto(votante)){
					generadorCartas.generarCarta(votante);
					votantes.add(votante);
				}
			}
			return votantes;
			
		}
		else{
			rW.writeReport(ruta, "no se encuentra el archivo");
			return null;
		}
		
		
	}

}
