/**
 * 
 */
package com.RSA.model;

import java.math.BigInteger;

/**
 * Questa classe rappresenta una frazione.
 * 
 * @author Eugenio
 */
public class Frazione {
	
	/**
	 * Numeratore della frazione.
	 */
	private BigInteger _numeratore;
	/**
	 * Denominatore della frazione.
	 */
	private BigInteger _denominatore;
	
	
	/**
	 * Costruttore.
	 * 
	 * @param _numeratore
	 * @param _denominatore
	 */
	public Frazione(BigInteger _numeratore, BigInteger _denominatore) {
		this._numeratore = _numeratore;
		this._denominatore = _denominatore;
	}
	/**
	 * ToString dell'oggetto.
	 */
	public String toString() {
		return "Numeratore: " + _numeratore.toString() + " \n" + "Denominatore: " + _denominatore.toString();
	}
	/**
	 * @return the _numeratore
	 */
	public BigInteger get_numeratore() {
		return _numeratore;
	}
	/**
	 * @param _numeratore the _numeratore to set
	 */
	public void set_numeratore(BigInteger _numeratore) {
		this._numeratore = _numeratore;
	}
	/**
	 * @return the _denominatore
	 */
	public BigInteger get_denominatore() {
		return _denominatore;
	}
	/**
	 * @param _denominatore the _denominatore to set
	 */
	public void set_denominatore(BigInteger _denominatore) {
		this._denominatore = _denominatore;
	}
	
	
}
