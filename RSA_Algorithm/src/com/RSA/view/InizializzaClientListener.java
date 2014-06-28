/**
 * 
 */
package com.RSA.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.RSA.model.algoritmoRSA.Client;

/**
 * @author Home
 *
 */
public class InizializzaClientListener extends MouseAdapter {
	/**
	 * Nome del client da inizializzare.
	 */
	private String _nomeClient;

	/**
	 * Costruttore
	 * @param nomeClient Nome del client da inizializzare.
	 */
	public InizializzaClientListener(String nomeClient) {
		this._nomeClient = nomeClient;
	}
	
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone per inizializzare un client.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Individuo quale client sto inizializzando.
		switch (_nomeClient) {
		case "Bob":
			Client Bob = new Client();
			VHome.getInstance().creaPanelInizializzatoBob(Bob);
			break;
		case "Alice":
			Client Alice = new Client();
			VHome.getInstance().creaPanelInizializzatoAlice(Alice);
			break;

		default:
			break;
		}
				
	}

}
