/**
 * 
 */
package com.RSA.model.algoritmoEuclideo;

import java.math.BigInteger;
import java.util.List;

/**
 * Questa interfaccia contiene il metodo per il calcolo dell'MCD tra due numeri interi. - Design Pattern Strategy
 * 
 * @author Eugenio
 */
public interface IAlgoritmoEuclideoStrategy {
	/**
	 * Metodo per calcolare il Massimo Comune Divisore tra due numeri interi.
	 * 
	 * @param num1 Primo numero per il quale si vuole effettuare il calcolo dell'MCD.
	 * @param num2 Secondo numero per il quale si vuole effettuare il calcolo dell'MCD.
	 * @return Lista dei risultati ottenuti alla generica iterazione dell'algoritmo.
	 */
	public List<RisultatoIterazioneAlgoritmoEuclideo> calcolaMCD(BigInteger num1, BigInteger num2);
}
