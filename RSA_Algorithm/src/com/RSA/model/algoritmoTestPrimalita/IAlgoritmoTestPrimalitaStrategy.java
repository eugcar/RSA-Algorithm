/**
 * 
 */
package com.RSA.model.algoritmoTestPrimalita;

import java.math.BigInteger;

/**
 * Questa interfaccia contiene l'algoritmo per verificare la primalit� di un numero primo - Design Pattern Strategy
 * 
 * @author Eugenio
 */
public interface IAlgoritmoTestPrimalitaStrategy {
	/**
	 * Testa la primalit� del numero intero dispari n, per diverse volte.
	 * 
	 * @param n Numero intero da testare.
	 * @param times Numero di volte in cui effettuare il test.
	 * @return True se il numero � probabilmente primo. False se � composto. 
	 */
	public boolean testaPrimalitaIntero(BigInteger n, int times);
}
