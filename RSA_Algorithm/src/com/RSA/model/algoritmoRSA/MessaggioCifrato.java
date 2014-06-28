/**
 * 
 */
package com.RSA.model.algoritmoRSA;

import java.math.BigInteger;

/**
 * Questa classe rappresenta il generico messaggio cifrato.
 * 
 * @author Eugenio
 */
public class MessaggioCifrato extends Messaggio {
	
	/**
	 * Contenuto del messaggio cifrato.
	 */
	private BigInteger _messaggioCifrato;

	/**
	 * Costruttore.
	 * 
	 * @param _mittente
	 * @param _destinatario
	 * @param _messaggioCifrato
	 */
	public MessaggioCifrato(Client _mittente, Client _destinatario, BigInteger _messaggioCifrato) {
		super(_mittente, _destinatario);
		this._messaggioCifrato = _messaggioCifrato;
	}

	/**
	 * @return the _messaggioCifrato
	 */
	public BigInteger get_messaggioCifrato() {
		return _messaggioCifrato;
	}

	/**
	 * @param _messaggioCifrato the _messaggioCifrato to set
	 */
	public void set_messaggioCifrato(BigInteger _messaggioCifrato) {
		this._messaggioCifrato = _messaggioCifrato;
	}

}
