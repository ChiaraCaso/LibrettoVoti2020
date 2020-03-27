package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Memorizza e gestisce un insieme di voti superati.
 * @author Caso
 *
 */
public class Libretto {

	private List <Voto> voti = new ArrayList<>();
	
	//Delega l'operazione di aggiunta all'array list
	/**
	 * Aggiunge un nuovo voto al libretto
	 * 
	 * @param v voto da aggiungere
	 */
	
	public void Add(Voto v) {
		this.voti.add(v);
	}
	/**
	 * dato un libretto restituisce una stringa nella quale
	 * vi sono solamente i voti pari al valore specificato 
	 * @param voto valore specificato
	 * @return stringa formattata per visualizzare il sotto-libretto
	 */
	public String stampaVotiUguali (int voto) {
		String s ="";
		for(Voto v : this.voti) {
			if(v.getVoto() == voto)
				s += v.toString()+"\n";
		}
		return s;
	}
	
	/**
	 * Genera un nuovo libretto a partire da quello esistente
	 * che conterrà esclusivamente i voti con votazione pari a quella specificata.
	 * @param voto votazione specificata
	 * @return libretto "ridotto" 
	 */
	//meglio questo, è più utile, la stringa è fine solo a se stessa
	//può solo essere stampata ma perdo il riferimento all'oggetto.
	public Libretto estraiVotiUguali (int voto) {
		Libretto nuovo = new Libretto();
		for(Voto v: this.voti) {
			if(v.getVoto()==voto)
				nuovo.Add(v);
		}
		return nuovo;
	}
	
	public String toString() {
		String s ="";
		for(Voto v : this.voti) {
			s += v.toString()+"\n";
		}
		return s;
	}
	
	
}
