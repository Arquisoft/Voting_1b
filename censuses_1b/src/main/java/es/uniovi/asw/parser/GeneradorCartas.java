package es.uniovi.asw.parser;

import java.io.FileNotFoundException;

import com.itextpdf.text.DocumentException;

import es.uniovi.asw.DBUpdate.Votante;

public interface GeneradorCartas {

	void generarCarta(Votante v) throws FileNotFoundException, DocumentException;

}
