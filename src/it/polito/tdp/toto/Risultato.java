package it.polito.tdp.toto;

public enum Risultato { 
	//è il singolo risultato possibile della singola partita
	//è una enumerazione per non usare i numeri 1,2,3 
	//e dover dire che il 3 vale X=>definisco simboli

	UNO, DUE, ICS;

	public String toString() {
		switch(this) {
		case UNO:
			return "1";
		case DUE:
			return "2";
		case ICS:
			return "X";
		default:
			return null;
		}
	}

}
