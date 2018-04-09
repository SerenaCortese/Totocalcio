package it.polito.tdp.toto;

import java.util.List;

public class TestPronostico {

	public static void main(String[] args) {
		Pronostico p = new Pronostico(3) ; //dimensione della schedina
		
		//previsione risultato (due) della prima partita
		p.add(new Previsione(Risultato.DUE));
		
		//previsione seconda partita
		p.add(new Previsione(Risultato.UNO, Risultato.ICS)) ;
		
		//previsione terza partita
		p.add(new Previsione(Risultato.UNO, Risultato.ICS, Risultato.DUE));
		
		System.out.println(p) ; //ottengo 2-1X-1X2
		
		//voglio una procedura che preso il pronostico generi una lista di schedine
		//nelle quali tutte le alternative vengono espanse in tutti i modi possibili
		//voglio: 2-1-1, 2-1-X, 2-1-2, 2-X-1, 2-X-X e 2-X-2
		Expander ex = new Expander();
		List<Schedina> risultato = ex.expand(p);

	}

}
