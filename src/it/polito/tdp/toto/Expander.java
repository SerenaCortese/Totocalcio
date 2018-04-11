package it.polito.tdp.toto;

import java.util.ArrayList;
import java.util.List;

public class Expander {
	
	private List<Schedina> soluzione;
	
	/**
	 * Funzione usata (prepara le variabili) per chiamare funzione ricorsiva cerca(). 
	 * @param p pronostico grazie al quale chiamo la funzione ricorsiva
	 * @return soluzione finale e completa
	 */
	public List<Schedina> expand(Pronostico p){
		soluzione = new ArrayList<Schedina>() ;
		
		cerca(new Schedina(p.getN()), p, 0) ;
		
		return soluzione;
	}
	

	/*Problema parziale : Schedina 1-X, livello 2
	Devo guardare il pronostico p(2). Supponiamo sia X2
	Allora genererò le nuove soluzioni parziali 1-X-X, 1-X-2
	Le provo con la ricorsione: prima una, poi torno indietro e poi provo l'altra.
	*/
	
	/**
	 * Metodo RICORSIVO: prende schedina parzialmente compilata e aggiunge un elemento in più. Costruisce la soluzione una partita alla volta e ad ogni partita prova tutti i risultati possibili compatibili col pronostico fatto dall'utente.
	 * Es. Ho schedina con le prime due righe già fatte (livello=2), quindi provo le terze righe: creo schedine parziali nuove a cui aggiungo un terzo elemento preso tra i risultati possibili che il pronostico dà a livello 3. 
	 * @param parziale schedina parziale (soluzione fino a quel momento, stato della ricerca)
	 * @param p pronostico usato per capire come andare avanti, che azioni svolgere
	 * @param livello per sapere quante righe mancano alla soluzione finale
	 */
	private void cerca(Schedina parziale, Pronostico p, int livello){ 

		if(livello==p.getN()) {
			// caso terminale => ho una soluzione completa
			soluzione.add(new Schedina(parziale)) ;
			return ;
		}
		
		
		//PRENDO LE MOSSE POSSIBILI (è un set)
		Previsione mosse = p.get(livello); //livello=0, mi dà prima partita perché lista parte da 0
		
		//Faccio tentativo per ogni elemento del set
		for(Risultato mossa : mosse.getValori()) { //mosse.getValori() mi dà il set [X,2] del mio esempio
			
			//AGGIUNGO UNA MOSSA ALLA SOLUZIONE(schedina)PARZIALE E LA PROVO
			parziale.add(mossa); 
			
			//RICORSIONE sul livello successivo:avrà soluzione più lunga
			//ma spazio di ricerca minore perché ad ogni livello
			//esamino un elemento in più del pronostico
			cerca(parziale,p,livello+1);
			
			//BACKTRACK: ripulisco soluzione parziale di partenza da mossa provata
			parziale.removeLast();
			
		}
	}

}
