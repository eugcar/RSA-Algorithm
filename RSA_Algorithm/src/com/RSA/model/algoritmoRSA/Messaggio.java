/**
 * 
 */
package com.RSA.model.algoritmoRSA;

/**
 * Questa classe rappresenta l'astrazione più alta per un messaggio.
 * 
 * @author Home
 */
public abstract class Messaggio {

	/**
	 * Mittente del messaggio.
	 */
	private Client _mittente;
	/**
	 * Destinatario del messaggio.
	 */
	private Client _destinatario;
	/**
	 * Costruttore.
	 * 
	 * @param _mittente Mittente del messaggio.
	 * @param _destinatario Destinatario del messaggio.
	 */
	public Messaggio(Client _mittente, Client _destinatario) {
		this._mittente = _mittente;
		this._destinatario = _destinatario;
	}
	/**
	 * @return the _mittente
	 */
	public Client get_mittente() {
		return _mittente;
	}
	/**
	 * @param _mittente the _mittente to set
	 */
	public void set_mittente(Client _mittente) {
		this._mittente = _mittente;
	}
	/**
	 * @return the _destinatario
	 */
	public Client get_destinatario() {
		return _destinatario;
	}
	/**
	 * @param _destinatario the _destinatario to set
	 */
	public void set_destinatario(Client _destinatario) {
		this._destinatario = _destinatario;
	}
	
	
}
