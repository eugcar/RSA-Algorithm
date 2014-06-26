/**
 * 
 */
package com.RSA.model.algoritmoEuclideo;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

/**
 * Questo classe rappresenta l'implementazione di default dell'algoritmo euclideo per il calcolo del MCD tra due numeri interi.
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
		// Se num1 è minore di num2, scambio i ruoli in modo da far diventare num1 maggiore di num2
		if(num1.compareTo(num2) < 0) {
			// Tmp = Num2
			BigInteger tmp = new BigInteger(num2.toString());
			// Setto Num2 = Num1
			num2 = new BigInteger(num1.toString());
			// Setto Num1 = Tmp
			num1 = new BigInteger(tmp.toString());
		} 	
		// Prima iterazione
		dividendo = num1;
		divisore = num2;
		risultato = num1.divideAndRemainder(num2);
		quoziente = risultato[0];
		resto = risultato[1];
		// Creo l'oggetto risultato dell'iterazione
		risultatoIterazione = new RisultatoIterazioneAlgoritmoEuclideo(dividendo, divisore, quoziente, resto);
		// Aggiungo l'oggetto risultato alla lista dei risultati
		listaRisultati.add(risultatoIterazione);
		// Ciclo finchè non ottengo resto nullo.
		while(resto.compareTo(new BigInteger("0")) != 0) {
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
//		
//		for (Iterator<RisultatoIterazioneAlgoritmoEuclideo> iterator = listaRisultati.iterator(); iterator.hasNext();) {
//			RisultatoIterazioneAlgoritmoEuclideo risultatoIterazioneAlgoritmoEuclideo = (RisultatoIterazioneAlgoritmoEuclideo) iterator.next();
//			
//			System.out.println(risultatoIterazioneAlgoritmoEuclideo.toString());
//			
//		}
		
		return listaRisultati;
	}

}
