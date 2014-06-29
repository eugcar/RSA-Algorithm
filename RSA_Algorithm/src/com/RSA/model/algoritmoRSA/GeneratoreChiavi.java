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
 * Classe con il compito di generare le chiavi per i client. Genera dunque per ogni client che ne 
 * fa richiesta la chiave pubblica, con la chiave privata associata.
 * 
 * @author Eugenio
 */
public class GeneratoreChiavi {
	/**
	 * Probabilità che i numeri primi generati siano effettivamente primi, con probabilità pari ad (1/4)^_accuracy.
	 */
	private static int _accuracy = 10;

	/**
	 * Metodo per generare la chiave pubblica e privata di un client (Alice, Bob).
	 */
	public static void generaChiavi(Client client, Boolean sicuro) {
		// Elementi della chiave
		BigInteger p=null, q=null, d=null, e=null, n=null; 
		// Prendo il timestamp e lo moltiplico per 1000.
		long time = Calendar.getInstance().getTime().getTime();
		BigInteger timestamp = new BigDecimal(time).toBigInteger().multiply(new BigInteger("1000"));
		// Il punto di partenza è dato da 10^100 + timestamp*1000.
		BigInteger numberStart_p = new BigInteger("10").pow(100).add(timestamp);
		// Calcolo p e p-1
		p = getFirstPrimeNumberAfterNumber(numberStart_p, _accuracy);
		BigInteger p_meno_1 = p.subtract(BigInteger.ONE);
		// Calcolo q e q-1
		q = getFirstPrimeNumberAfterNumber(p.add(numberStart_p), _accuracy);
		BigInteger q_meno_1 = q.subtract(BigInteger.ONE);
		// Calcolo fi_n = (p-1)*(q-1)
		BigInteger fi_n = p_meno_1.multiply(q_meno_1);
		// Calcolo n
		n = p.multiply(q);
		// Controllo che si vogliano usare esponenti di cifratura sicuri
		if (sicuro == true) {
			/* 
			 * Calcolo d, in modo tale che sia : d > 1/3 * n^(1/4) , in modo da non poter 
			 * subire l'attacco di Wiener, con espoenente basso.
			 */
			double n_double = new BigInteger(n.toString()).doubleValue();
			// Eseguo n^(1/4) e successivamente divido per 3
			double n_raise_to_1_diviso_4 = Math.pow(n_double, 0.25);
			double lowerBound_d_double = n_raise_to_1_diviso_4 / 3;
			// Converto il double in bigInteger
			BigInteger numberStart_d = new BigDecimal(lowerBound_d_double).toBigInteger();
			// Calcolo d
			d = getFirstPrimeNumberAfterNumber(numberStart_d, _accuracy);
			/*
			 * Calcolo e, in modo tale che e*d = 1 (mod fi_n) 
			 */
			e = d.modInverse(fi_n);
		} else {
			// Calcolo d.
			BigInteger numberStart_d = new BigInteger("10").pow(2);
			d = getFirstPrimeNumberAfterNumber(numberStart_d, _accuracy);
			/*
			 * Calcolo e, in modo tale che e*d = 1 (mod fi_n) 
			 */
			e = d.modInverse(fi_n);
		}
				
		// Creo la chiave privata e pubblica del client
		PrivateKey privateKeyClient = new PrivateKey(p, q, d);
		PublicKey publicKeyClient = new PublicKey(n, e);
		// Setto le chiavi al client
		client.set_privateKey(privateKeyClient);
		client.set_publicKey(publicKeyClient);
		
		
//		BigInteger de = d.multiply(e).mod(fi_n);
//		System.out.println("P: " + p.toString());
//		System.out.println("Q: " + q.toString());
//		System.out.println("N: " + n.toString());
//		System.out.println("D: " + d.toString());
//		System.out.println("E: " + e.toString());
//		System.out.println("D*E (mod fi_n): " + de.toString());
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
				/* Se non trovo il numero primo, chiedo a Java di fornirmene uno probabilmente primo,
				 * la probabilità che offre Java è di 2^(-100), con l'algoritmo sviluppato attraverso il test
				 * di Miller-Rabin, si può ottenere una probabilità pari a 4^(-_accuracy), quindi l'utilizzatore
				 * può scegliere con che probabilità vuole effettuare il test.
				 */
				number = number.nextProbablePrime();
			}
		}
		
		return primeNumber;
	}
}
