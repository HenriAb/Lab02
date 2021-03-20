package it.polito.tdp.alien.model;

import java.util.LinkedList;
import java.util.List;

public class WordEnchanced {

	private String alienWord;
	private String translation;
	
	public WordEnchanced(String alienWord, String translation) {
		super();
		this.alienWord = alienWord;
		this.translation = translation;
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}
	
	@Override
	public String toString() {
		return "Parola immessa nel dizionario.\nHai inserito: " +  this.alienWord +  ". Traduzione: " + this.translation;
	}
	
}
