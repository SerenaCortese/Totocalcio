package it.polito.tdp.toto;

import java.util.ArrayList;
import java.util.List;

public class Schedina {
	//� un elenco di risultati ( il risultato � 1 op X op 2 )
	//ogni schedina sar� una singola colonna
	
	private int N;

	private List<Risultato> colonna;

	public Schedina(int N) {
		this.N = N;
		this.colonna = new ArrayList<Risultato>();
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
