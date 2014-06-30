/**
 * 
 */
package com.RSA.model.algoritmoRSA;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;

import com.RSA.model.Utility;
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
	private static int _accuracy = 100;
	/**
	 * Numero di bit della chiave.
	 */
	private static int _numeroBitChiave = 512;
	/**
	 * Limite superiore alla ricerca dei numeri primi che non sono divisori di un certo numero intero.
	 */
	private static BigInteger _upperBoundRicercaPrimi = new BigInteger("256");

	/**
	 * Metodo per generare la chiave pubblica e privata di un client (Alice, Bob).
	 */
	public static void generaChiavi(Client client, Boolean sicuro) {
		// Elementi della chiave
		BigInteger p=null, q=null, d=null, e=null, n=null; 
		// Oggetto responsabile della creazione del numero randomico
		SecureRandom secureRandom = new SecureRandom();
		// Il punto di partenza è un numero intero compreso tra 0 e 2^(_numBit-1).
		BigInteger numberStart_p = new BigInteger(_numeroBitChiave, secureRandom);
		// Calcolo p e p-1
		p = getFirstPrimeNumberAfterNumber(numberStart_p, _accuracy);
		BigInteger p_meno_1 = p.subtract(BigInteger.ONE);
		// Il punto di partenza è un numero intero compreso tra 0 e 2^(_numBit-1).
		BigInteger numberStart_q = new BigInteger(_numeroBitChiave, secureRandom);
		// Calcolo q e q-1
		q = getFirstPrimeNumberAfterNumber(numberStart_q, _accuracy);
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
	public static BigInteger getFirstPrimeNumberAfterNumber(BigInteger number, int accuracy) {
		// Numero primo da restituire
		BigInteger primeNumber = null;
		// Booleano che rappresenta la condizione di uscita.
		boolean trovato = false;
		// Strategia
		IAlgoritmoTestPrimalitaStrategy algoritmoTestPrimalitaStrategy = new AlgoritmoTestPrimalitaMillerRabinStrategy();
//		System.out.println("Numero di partenza: " + number);
		
		// Carico la lista dei numeri primi precedenti a number.
		List<BigInteger> listaNumeriPrimiPrecedentiNumber = Utility.getListaPrimiPrecedentiNumer(_upperBoundRicercaPrimi, _accuracy);
		// Ciclo finchè non trovo il numero primo.
		while(!trovato) {
			// Effettuo il test
			trovato = algoritmoTestPrimalitaStrategy.testaPrimalitaIntero(number, accuracy);					
			// Se l'esito del test è positivo assegno il valore di number a primeNumber.
			if (trovato == true) {		
				primeNumber = number;
			} else {			
				/* 
				 * Ricavo il numero intero, successivo a number, buon candidato ad essere un numero primo.
				 */
				number = GeneratoreChiavi.nextIntegerNotDivisibleBySeveralPrime(number, listaNumeriPrimiPrecedentiNumber);
			}
		}
//		System.out.println("Prime number: " + primeNumber);
	
		return primeNumber;
	}
	/**
	 * Metodo per ottenere un numero intero successivo a quello dato, non divisibile dalla lista
	 * dei numeri primi precedenti all'attributo _upperBoundRicercaPrimi
	 * 
	 * @param number Numero dal quale si parte per effettuare il test.
	 * @param listaPrimi Lista dei primi sulla quale effettuare il test.
	 * 
	 * @return Numero intero non divisibile dalla lista dei numeri primi precedenti di _upperBoundRicercaPrimi
	 */
	private static BigInteger nextIntegerNotDivisibleBySeveralPrime(BigInteger number, List<BigInteger> listaPrimi) {
		// BigInteger da restituire
		BigInteger integerNotDivisibleBySeveralPrime = null;
		// Condizione di uscita dal ciclo
		boolean trovato = false;		
		// Incremento number di 1, per passare ad effettuare il testing dal primo numero successivo a quello dato.
		number = number.add(BigInteger.ONE);
		// Ciclo finche non trovo un buon numero
		while(!trovato) {
			/* 
			 * Condizione per verificare se il numero da testare in questa iterazione del 
			 * ciclo è o meno multiplo della lista dei primi.
			 */	
			boolean multiplo = false;
			// Ciclo per verificare che il numero nell'iterazione corrente non sia multiplo di un numero primo.
			for (Iterator<BigInteger> iterator = listaPrimi.iterator(); iterator.hasNext();) {
				// Generico elemento della lista
				BigInteger primeNumber = (BigInteger) iterator.next();			
				// Verifico che number non sia multiplo di primeNumber
				if (Utility.A_multiplo_B(number, primeNumber) == true) {
					multiplo = true;
				}
			}
			/* 
			 * Se il numero appena testato è un multiplo di uno dei primi, incremento 
			 * di uno e al prossimo ciclo testo nuovamente.
			 */
			if (multiplo == true) {
				number = number.add(BigInteger.ONE);
			} else {
				/*
				 * Se il numero appena testato non era multiplo di nessuno dei primi allora 
				 * è un buon candidato e usciamo dal ciclo.
				 */
				trovato = true;
				// Assegno il valore del numero trovato alla variabile da fornire in output.
				integerNotDivisibleBySeveralPrime = new BigInteger(number.toString());
			}
		}
		return integerNotDivisibleBySeveralPrime;	
	}
}
