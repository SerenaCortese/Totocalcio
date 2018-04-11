package it.polito.tdp.toto;

import java.util.ArrayList;
import java.util.List;

public class Schedina {
	//è un elenco di risultati ( il risultato è 1 op X op 2 )
	//ogni schedina sarà una singola colonna
	
	private int N;

	private List<Risultato> colonna;

	public Schedina(int N) {
		this.N = N;
		this.colonna = new ArrayList<Risultato>();
	}

	// clone constructor: copia i campi della vecchia schedina(other) in una nuova(nuovo oggetto)
	public Schedina(Schedina other) {
		this.N = other.N ;
		this.colonna = new ArrayList<>(other.colonna) ;
	//OCCHIO!this.colonna = other.colonna copia il riferimento e non i valori!!
	}
	
	public void add(Risultato valore) {
		if (colonna.size() < N) {
			colonna.add(valore);
		} else {
			throw new IllegalStateException("Too many elements in Schedina") ;
		}
	}
	
	public Risultato get(int partita) {
		return colonna.get(partita);
	}
	/**
	 * Rimuove l'ultimo risultato aggiunto.
	 */
	public void removeLast() {
		colonna.remove(colonna.size()-1); 
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Risultato r : colonna) {
			sb.append(r.toString());
			sb.append("-") ;
		}
		sb.deleteCharAt(sb.length()-1) ;
		return sb.toString();
	}

}
