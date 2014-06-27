/**
 * 
 */
package com.RSA.model.algoritmoRSA;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

import com.RSA.model.algoritmoTestPrimalita.AlgoritmoTestPrimalitaMillerRabinStrategy;
import com.RSA.model.algoritmoTestPrimalita.IAlgoritmoTestPrimalitaStrategy;


/**
 * Classe con il compito di generare le chiavi per i client.
 * 
 * @author Eugenio
 */
public class GeneratoreChiavi {
	/**
	 * Probabilità che i numeri primi generati siano effettivamente primi, con probabilità pari ad (1/4)^_accuracy.
	 */
	private static int _accuracy = 100;

	/**
	 * Metodo per generare la chiave pubblica e privata di un client (Alice, Bob).
	 */
	public static void generaChiavi() {
		// Prendo il timestamp e lo moltiplico per 1000.
		long time = Calendar.getInstance().getTime().getTime();
		BigInteger timestamp = new BigDecimal(time).toBigInteger().multiply(new BigInteger("1000"));
		// Il punto di partenza è dato da 10^100 + timestamp*1000.
		BigInteger numberStart_p = new BigInteger("10").pow(100).add(timestamp);
		// Calcolo p
		BigInteger p = getFirstPrimeNumberAfterNumber(numberStart_p, _accuracy);
		System.out.println("P: " + p.toString());
		// Calcolo q
		BigInteger q = getFirstPrimeNumberAfterNumber(p.add(numberStart_p), _accuracy);
		System.out.println("Q: " + q.toString());
		// Calcolo n
		BigInteger n = p.multiply(q);
		System.out.println("N: " + n.toString());
	}
	/**
	 * Metodo per ottenere il primo 'numero primo' dopo un numero intero dato.
	 * 
	 * @param number Numero dal quale avviare la ricerca.
	 * @param accuracy Precisione nella valutazione di primalità.
	 */
	private static BigInteger getFirstPrimeNumberAfterNumber(BigInteger number, int accuracy) {
		// Numero primo da restituire
		BigInteger primeNumber = null;
		// Booleano che rappresenta la condizione di uscita.
		boolean trovato = false;
		// Prendo la strategia di verifica della primalità
		IAlgoritmoTestPrimalitaStrategy algoritmoTestPrimalitaStrategy = new AlgoritmoTestPrimalitaMillerRabinStrategy();		
		
		// Ciclo finchè non trovo il numero primo.
		while(!trovato) {
			// Testo la primalità del numero
			trovato = algoritmoTestPrimalitaStrategy.testaPrimalitaIntero(number, accuracy);
						
			// Se l'esito del test è positivo assegno il valore di number a primeNumber.
			if (trovato == true) {		
				primeNumber = number;
			} else {
				// Se non trovo il numero primo, chiedo a Java di fornirmene uno probabilmente primo.
				number = number.nextProbablePrime();
			}
		}
		
		return primeNumber;
	}
}
