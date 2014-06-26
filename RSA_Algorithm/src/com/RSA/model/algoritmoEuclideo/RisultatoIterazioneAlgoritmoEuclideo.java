/**
 * 
 */
package com.RSA.model.algoritmoEuclideo;

import java.math.BigInteger;

/**
 * Questa classe rappresenta il risultato che si ottiene dalla generica iterazione dell'algoritmo euclideo per il calcolo
 * del Massimo Comune Divisore tra due numeri interi.
 * 
 * @author Eugenio
 */
public class RisultatoIterazioneAlgoritmoEuclideo {

	/**
	 * Dividendo.
	 */
	private BigInteger _dividendo;
	/**
	 * Divisore.
	 */
	private BigInteger _divisore;
	/**
	 * Quoziente
	 */
	private BigInteger _quoziente;
	/**
	 * Resto.
	 */
	private BigInteger _resto;
	
	/**
	 * Costruttore.
	 * 
	 * @param _dividendo
	 * @param _divisore
	 * @param _quoziente
	 * @param _resto
	 */
	public RisultatoIterazioneAlgoritmoEuclideo(BigInteger _dividendo,
			BigInteger _divisore, BigInteger _quoziente, BigInteger _resto) {
		this._dividendo = _dividendo;
		this._divisore = _divisore;
		this._quoziente = _quoziente;
		this._resto = _resto;
	}
	/**
	 * ToString dell'oggetto.
	 */
	public String toString() {
		return "Dividendo: " + _dividendo + "\n " +
			   "Divisore: " + _divisore + "\n " +
			   "Quoziente: " + _quoziente + "\n " +
			   "Resto: " + _resto;
	}
	
	/**
	 * @return the _dividendo
	 */
	public BigInteger get_dividendo() {
		return _dividendo;
	}
	/**
	 * @param _dividendo the _dividendo to set
	 */
	public void set_dividendo(BigInteger _dividendo) {
		this._dividendo = _dividendo;
	}
	/**
	 * @return the _divisore
	 */
	public BigInteger get_divisore() {
		return _divisore;
	}
	/**
	 * @param _divisore the _divisore to set
	 */
	public void set_divisore(BigInteger _divisore) {
		this._divisore = _divisore;
	}
	/**
	 * @return the _quoziente
	 */
	public BigInteger get_quoziente() {
		return _quoziente;
	}
	/**
	 * @param _quoziente the _quoziente to set
	 */
	public void set_quoziente(BigInteger _quoziente) {
		this._quoziente = _quoziente;
	}
	/**
	 * @return the _resto
	 */
	public BigInteger get_resto() {
		return _resto;
	}
	/**
	 * @param _resto the _resto to set
	 */
	public void set_resto(BigInteger _resto) {
		this._resto = _resto;
	}	
}
