package it.polito.tdp.toto;

import java.util.HashSet;
import java.util.Set;

public class Previsione { 
	//previsioni che fa l'utente sono un set di risultati,
	//non una lista perché gli elementi non sono mai ripetuti
	//è una riga 1-X-2 mentre il risultato è 1 op X op 2
	
	private Set<Risultato> valori ;
	
	public Previsione() {
		valori = new HashSet<>() ;
	}
	
	public Previsione(Risultato r1) {
		this() ;
		valori.add(r1) ;
	}

	public Previsione(Risultato r1, Risultato r2) {
		this() ;
		valori.add(r1) ;
		valori.add(r2) ;
	}

	public Previsione(Risultato r1, Risultato r2, Risultato r3) {
		this() ;
		valori.add(r1) ;
		valori.add(r2) ;
		valori.add(r3) ;
	}

	public void add(Risultato r) {
		valori.add(r) ;
	}
	
	public Set<Risultato> getValori() {
		return valori ;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder() ;
		for(Risultato r: valori) {
			sb.append(r.toString()) ;
		}
		return sb.toString() ;		
	}
}
