package es.uniovi.asw.dbupdate;

import java.util.ArrayList;
import java.util.List;

public class Observer {
	List<Subscriber> lista;
	
	
	public Observer(){
		lista=new ArrayList<Subscriber>();
	}
	
	public void addObserver(Subscriber b){
		lista.add(b);
	}
	
	public void notificar(){
		for(Subscriber b: lista)
			b.cambiosBD();
	}
	
}
