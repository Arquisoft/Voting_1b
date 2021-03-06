package es.uniovi.asw.parser.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import es.uniovi.asw.DBUpdate.Votante;

public class RCensus extends InsertR {

	public RCensus(String ruta) {
		super(ruta);
	}
	
	public RCensus(String ruta, GeneradorCartas generadorCartas) {
		super(ruta, generadorCartas);
	}

	@Override
	protected List<Votante> parserArchivo(File archivo) throws IOException {
		
		List<Votante> votantes = new ArrayList<Votante>(); 
		
		Workbook wb;
		try {
			
			wb = WorkbookFactory.create(archivo);
			
			org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();
			
			//Quitamos la primera fila que contiene los nombres de las columnas
			if(rows.hasNext()) rows.next(); 
			int fila = 2;
			
			
			//Procesamos el documento
			while(rows.hasNext()){
				
				Row row = (Row) rows.next();
				Iterator<Cell> cells = row.cellIterator();
				List<String> datosVotante = new ArrayList<String>();
				
				
				while(cells.hasNext()){
					Cell cell = (Cell) cells.next();
					datosVotante.add(cell.toString());
				}
				//magia autowiured
				if(datosVotante.size() == 4){
					Votante v = new Votante(datosVotante.get(0),
							datosVotante.get(1),
							datosVotante.get(2),
							datosVotante.get(3) != "" ? Double.valueOf(datosVotante.get(3)).longValue() +"" : "");
										
					votantes.add(v);
				}
				else{
					rW.writeReport(ruta, "[Fila " + fila + "] Faltan datos del usuario.");
				}
					
				fila++;
				
			}
			
		} catch (EncryptedDocumentException | InvalidFormatException e) {
			rW.writeReport(ruta, "Ha ocurrido un problema al leer el fichero excel.");
		} 
		
		return votantes;
	}

}
