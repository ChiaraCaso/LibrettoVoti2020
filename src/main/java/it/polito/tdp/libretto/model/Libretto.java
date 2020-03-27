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
	 * @return {@code true} se ha inserito il voto, 
	 * {@code false} se non l'ha inseito perchè è in conflitto o duplicato
	 */
	
	public boolean Add(Voto v) {
		if(this.isCoonflittoVoto(v) || this.isDuplicato(v)) {
			//non inserire il voto
			return false;
		} else {
			// inserisci il voto perchè non è in conflitto nè duplicato
			this.voti.add(v);
			return true;
		}
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
	
	/**
	 * Dato il nome di un corso, ricerca se quell'esame esiste nel libretto
	 * in caso affermativo restituisce l'oggetto {@link Voto} corrispondente
	 * Se l'esame non esiste restituisce {@ null}
	 * 
	 * @param nomeCorso nome esame da cercare
	 * @return {@link Voto} corrispondente oppure {@code null} (se non esiste)
	 */
	
	public Voto cercaNomeCorso(String nomeCorso) {
/*		for (Voto v : this.voti) {
			if(nomeCorso.equals(v.getCorso()))
				return v;
		}
		return null;
*/		
		int pos = this.voti.indexOf(new Voto(nomeCorso, 0, null));
		if(pos != -1) {
			return this.voti.get(pos);
		} else 
			return null;
	}
	
	/**
	 * Ritorna {@code true} se il corso specificato da {@code v}
	 * esiste nel libretto con la stessa valutazione.
	 * Se non esiste o se la valutazione è diversa ritorna {@code false}. 
	 * @param v il {@link Voto} da ricercare
	 * @return l'esistenza di un duplicato
	 */
	
	public boolean isDuplicato (Voto v) {
		Voto esiste = this.cercaNomeCorso(v.getCorso());
		if(esiste == null)
			return false;
		
//		if(esiste.getVoto() == v.getVoto())
//			return true;
//		else 
			
		return (esiste.getVoto() == v.getVoto());
	}
	
	/**
	 * Determina se esiste un voto con lo stesso nome corso ma valutazione
	 * diversa  
	 * @param v
	 * @return
	 */
	public boolean isCoonflittoVoto (Voto v) {
		Voto esiste = this.cercaNomeCorso(v.getCorso());
		if(esiste == null)
			return false;
		
		return (esiste.getVoto() != v.getVoto());
	}
}
