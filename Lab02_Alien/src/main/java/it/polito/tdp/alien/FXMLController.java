package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	AlienDictionary dizionario;
	//ha senso??
    public FXMLController() {
		super();
		this.dizionario = new AlienDictionary();
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;

    @FXML
    private TextArea txtResult;

    @FXML
    void doReset(ActionEvent event) {

    	this.dizionario.togliTut();
    	this.txtResult.clear();
    	this.txtInput.clear();
    }

    @FXML
    void doTransalte(ActionEvent event) {
    	
    	String in = this.txtInput.getText();
    	String parole[] = in.split(" ");
    	String alien = "";
		String traduzione = "";
    	if(parole.length < 3) {
    		//voglio che in contenga solo lettere a-zA-Z
    		if(in.matches("[0-9]") || (!in.matches("[a-zA-Z].+"))) {
    			this.txtResult.setText("ERRORE: Devi inserire solo lettere a-zA-Z");
    			this.ripulisci();
    			return;
    		}
    		
    		if(parole.length == 2) {
    			// inserire parola nel dizionario
    			alien = parole[0].toLowerCase();
    			traduzione = parole[1].toLowerCase();
    			this.dizionario.addWord(alien, traduzione);
        		this.txtResult.setText(dizionario.toString()); 
        		this.ripulisci();
        		return;
    		}
    		
    		if(parole.length == 1) {
    			// traduco la parola alienword
    			alien = parole[0].toLowerCase();
    			if(this.dizionario.translateWord(alien).equals("")) {
    				this.txtResult.setText("null\nParola non presente nel dizionario!");
    				this.ripulisci();
    				return;
    			}
    			else {
    				this.txtResult.setText("Traduzione: " + this.dizionario.translateWord(alien));
    				this.ripulisci();
    				return;
    			}
    		}
    		
    	}
    	else {
    		this.txtResult.setText("ERRORE! Inserisci due parole separate da spazio per inserirla nel dizionario\n"
    				+ "oppure solo una per ottenere la traduzione");
    			this.ripulisci();
    			return;
    	}
    	/*String in = this.txtInput.getText();
    	if(in.matches(".*[0-9].*") && (!in.matches(".*[a-zA-Z].*"))){
    		this.txtResult.setText("ERRORE: Inserire solo caratteri numerici.");
    		this.txtInput.clear();
    		return;
    	}
    	String parole[] = this.txtInput.getText().split(" ");
    	String alien = parole[0].toLowerCase();
		String traduzione = null;
    	if(parole.length == 2) {
    		// sto inserendo nel dizionario
    		traduzione = parole[1].toLowerCase();
    		this.dizionario.addWord(alien, traduzione);
    		this.txtResult.setText(dizionario.toString()); 
    		this.ripulisci();
    		return;
    	}
    	else {
    		if(parole.length == 1) {
    			// traduco la parola alienword
    		
    			if(this.dizionario.translateWord(alien).equals("")) {
    				this.txtResult.setText("Parola non presente nel dizionario!");
    				this.ripulisci();
    				return;
    			}

    			this.txtResult.setText("Traduzione: " + this.dizionario.translateWord(alien));
 
    		}
    		else {
    			this.txtResult.setText("ERRORE! Inserisci due parole separate da spazio o solo una per ottenere la traduzione");
    			this.ripulisci();
    			return;
    		}
    	}
    	//this.ripulisci(); */
    }

    private void ripulisci() {
    	this.txtInput.clear();
    	//this.txtResult.clear();
    }
    
    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
