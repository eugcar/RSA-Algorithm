/**
 * 
 */
package com.RSA.model.algoritmoRSA;

/**
 * Questa classe rappresenta il generico messaggio in chiaro.
 * 
 * @author Home
 */
public class MessaggioChiaro extends Messaggio {
	
	/**
	 * Contenuto del messaggio in chiaro.
	 */
	private String _messaggioChiaro;

	/**
	 * @param _mittente
	 * @param _destinatario
	 */
	public MessaggioChiaro(Client _mittente, Client _destinatario, String _messaggioChiaro) {
		super(_mittente, _destinatario);
		this._messaggioChiaro = _messaggioChiaro;
	}

	/**
	 * @return the _messaggioChiaro
	 */
	public String get_messaggioChiaro() {
		return _messaggioChiaro;
	}

	/**
	 * @param _messaggioChiaro the _messaggioChiaro to set
	 */
	public void set_messaggioChiaro(String _messaggioChiaro) {
		this._messaggioChiaro = _messaggioChiaro;
	}

}
