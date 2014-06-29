/**
 * 
 */
package com.RSA.model.algoritmoEuclideo;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Questo classe rappresenta l'implementazione di default dell'algoritmo euclideo per il calcolo del MCD tra due numeri interi. - Design Pattern Strategy
 * 
 * @author Eugenio
 */
public class AlgoritmoEuclideoDefaultStrategy implements IAlgoritmoEuclideoStrategy {

	/* (non-Javadoc)
	 * @see com.RSA.model.algoritmoEuclideo.IAlgoritmoEuclideoStrategy#calcolaMCD(java.math.BigInteger, java.math.BigInteger)
	 */
	public List<RisultatoIterazioneAlgoritmoEuclideo> calcolaMCD(BigInteger num1, BigInteger num2) {
		// Interi che si utilizzeranno nell'algoritmo
		BigInteger dividendo, divisore, quoziente, resto;
		// Lista di BigInter
		BigInteger[] risultato;
		// Oggetti risultati che si utilizzeranno.
		RisultatoIterazioneAlgoritmoEuclideo ultimaIterazione, risultatoIterazione;
		// Lista nella quale si fornisce l'insieme dei risultati delle iterazioni
		List<RisultatoIterazioneAlgoritmoEuclideo> listaRisultati = new LinkedList<RisultatoIterazioneAlgoritmoEuclideo>();
		
		// Faccio una copia delle variabili ricevute in input.
		BigInteger Numero1 = new BigInteger(num1.toString());
		BigInteger Numero2 = new BigInteger(num2.toString());
		
		// Se num1 è minore di num2, scambio i ruoli in modo da far diventare num1 maggiore di num2
		if(Numero1.compareTo(Numero2) < 0) {
			// Tmp = Num2
			BigInteger tmp = new BigInteger(Numero2.toString());
			// Setto Num2 = Num1
			Numero2 = new BigInteger(Numero1.toString());
			// Setto Num1 = Tmp
			Numero1 = new BigInteger(tmp.toString());
		} 	
		// Prima iterazione
		dividendo = Numero1;
		divisore = Numero2;
		risultato = Numero1.divideAndRemainder(Numero2);
		quoziente = risultato[0];
		resto = risultato[1];
		// Creo l'oggetto risultato dell'iterazione
		risultatoIterazione = new RisultatoIterazioneAlgoritmoEuclideo(dividendo, divisore, quoziente, resto);
		// Aggiungo l'oggetto risultato alla lista dei risultati
		listaRisultati.add(risultatoIterazione);
		// Ciclo finchè non ottengo resto nullo.
		while(resto.compareTo(BigInteger.ZERO) != 0) {
			// Prendo l'ultimo oggetto aggiunto alla lista dei risultati
			ultimaIterazione = listaRisultati.get(listaRisultati.size()-1);
			dividendo = ultimaIterazione.get_divisore();
			divisore = ultimaIterazione.get_resto();
			risultato = dividendo.divideAndRemainder(divisore);
			quoziente = risultato[0];
			resto = risultato[1];
			// Creo l'oggetto risultato dell'iterazione
			risultatoIterazione = new RisultatoIterazioneAlgoritmoEuclideo(dividendo, divisore, quoziente, resto);
			// Aggiungo l'oggetto risultato alla lista dei risultati
			listaRisultati.add(risultatoIterazione);		
		}
		
//		TESTING RISULTATI
		
//		System.out.println("\n \n \n");
//		System.out.println("ALGORITMO EUCLIDEO: \n");
//		for (Iterator<RisultatoIterazioneAlgoritmoEuclideo> iterator = listaRisultati.iterator(); iterator.hasNext();) {
//			RisultatoIterazioneAlgoritmoEuclideo risultatoIterazioneAlgoritmoEuclideo = (RisultatoIterazioneAlgoritmoEuclideo) iterator.next();	
//			System.out.println(risultatoIterazioneAlgoritmoEuclideo.toString());
//			
//		}
		
		return listaRisultati;
	}

}
