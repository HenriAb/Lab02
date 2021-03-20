package it.polito.tdp.alien.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class AlienDictionaryEn {

	private Map<String, LinkedList<String>> dizionario; // associo ad ogni alienWord una lista di traduzioni

	public AlienDictionaryEn() {
		super();
		this.dizionario = new HashMap<>();
	}
	
	public void addWord(String alienWord, String translation) {
		
		String alien = alienWord.toLowerCase();
		String trans = translation.toLowerCase();
		
		if(!this.dizionario.containsKey(alien)) {
			this.dizionario.put(alien, new LinkedList<String>());
		}
		this.dizionario.get(alien).add(trans);
	
	}
	
	public Map<String, LinkedList<String>> getDizionario() {
		return dizionario;
	}

	public String translateWord(String alienString) {
		String alien = alienString.toLowerCase();
		//return this.toString(alien);
		if(this.toString(alien) == null) {
			return null;
		}
		return this.toString(alien);
		
	}
	
	/**
	 * Stampa tutto il dizionario
	 */
	public String toString() {
		String res = "";
		for(String s : this.dizionario.keySet()) {
			for(String si : this.dizionario.get(s) ) {
				res += si.toString() + "\n";
			}
			res += "\n";
		}
		return res;
	}
	
	/**
	 * Dato il nome della parola aliena mi da una stringa contenente tutti le traduzioni associate a tale AlienWord
	 * @param aw
	 * @return
	 */
	public String toString(String aw) {
		String res = "Hai inserito " + aw + " . Traduzione/i:\n";
		if(this.dizionario.containsKey(aw.toLowerCase())) {
			for(String si : this.dizionario.get(aw.toLowerCase())) {
				res += si + "\n";
			}
		}
		else res = null;
		
		return res;
	}
	
	public void togliTut() {
		this.dizionario.clear();
	}
}
