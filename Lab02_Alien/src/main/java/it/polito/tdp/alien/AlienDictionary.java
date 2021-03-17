package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlienDictionary {
	
	List<Word> words;
	Map<String, Word> wordsMap;
	
	
	public AlienDictionary() {
		this.words = new ArrayList<>();
		this.wordsMap = new HashMap<>();
	}

	public void addWord(String alienWord, String translation) {
		
		String alien = alienWord.toLowerCase();
		if(alien.matches(".*[a-zA-Z].*")) {

			Word parola = new Word(alien, translation);
			
			if(this.wordsMap.containsKey(alien)) {
				//aggiornare
				this.aggiornaParola(alien, translation);
				
			}
			
			this.wordsMap.put(alien, parola);
			this.words.add(parola);	
		}
		
	}
	
	private void aggiornaParola(String alienWord, String translation) {
		this.wordsMap.get(alienWord).setTranslation(translation);
		this.wordsMap.get(alienWord).setAlien(alienWord);
		for(Word w : this.words) {
			if(w.getAlien().equals(alienWord)) {
				w.setTranslation(translation);
				w.setAlien(alienWord);
				break;
			}
		}
		
	}
	
	public String translateWord(String alienWord) {
		
		String alien = alienWord.toLowerCase(); 
		String res = "";
		if(this.wordsMap.containsKey(alien))		
			res = this.wordsMap.get(alien).getTranslation();
		
		return res;
	}

	@Override
	public String toString() {
		String res = "";
		for(Word wi : this.words) {
			res += wi.toString() + "\n";
		}
		return res;
	}

	public void togliTut() {

		this.words.clear();
		this.wordsMap.clear();
		
	}
	
}
