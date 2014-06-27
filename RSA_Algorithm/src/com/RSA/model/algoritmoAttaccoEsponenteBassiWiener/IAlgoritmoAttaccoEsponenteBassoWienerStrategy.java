/**
 * 
 */
package com.RSA.model.algoritmoAttaccoEsponenteBassiWiener;

import java.math.BigInteger;

/**
 * Questa interfaccia contiene l'algoritmo per l'attacco all'algoritmo RSA, quando vengono scelti esponenti di cifratura bassi. - Design Pattern Strategy
 * 
 * @author Eugenio
 */
public interface IAlgoritmoAttaccoEsponenteBassoWienerStrategy {
	/**
	 * Metodo per calcolare i fattori primi di n.
	 * @param e Esponente di cifratura dell'algoritmo RSA.
	 * @param n Numero prodotto dei fattori primi p e q.
	 * @return Array di BigInter, fattori primi di n. Null altrimenti.
	 */
	public BigInteger[] calcolaFattori_n(BigInteger e, BigInteger n);
}
