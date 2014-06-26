/**
 * 
 */
package com.RSA.model.calcolaFrazioneContinua;

import java.math.BigInteger;

import com.RSA.model.Frazione;

/**
 * Questa classe rappresenta il risultato che si ottiene alla generica iterazione del
 * calcolo della frazione continua di un numero realte.
 * 
 * @author Eugenio
 */
public class RisultatoIterazioneCalcoloFrazioneContinua {
	
	/**
	 * Generico ai, che si ottiene all'i-esima iterazione del calcolo della frazione continua.
	 */
	private BigInteger _ai;
	/**
	 * Frazione che si ottiene alla i-esima iterazione durante il calcolo della frazione continua.
	 */
	private Frazione _frazione;
				
	/**
	 * Costruttore.
	 * 
	 * @param _ai
	 * @param _frazione
	 */
	public RisultatoIterazioneCalcoloFrazioneContinua(BigInteger _ai,
			Frazione _frazione) {
		this._ai = _ai;
		this._frazione = _frazione;
	}
	
	/**
	 * ToString dell'oggetto.
	 */
	public String toString() {
		return "a_i: " + _ai.toString() +" \n" + _frazione.toString();
	}
	
	/**
	 * @return the _ai
	 */
	public BigInteger get_ai() {
		return _ai;
	}
	/**
	 * @param _ai the _ai to set
	 */
	public void set_ai(BigInteger _ai) {
		this._ai = _ai;
	}
	/**
	 * @return the _frazione
	 */
	public Frazione get_frazione() {
		return _frazione;
	}
	/**
	 * @param _frazione the _frazione to set
	 */
	public void set_frazione(Frazione _frazione) {
		this._frazione = _frazione;
	}
	
	
}
