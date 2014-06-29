/**
 * 
 */
package com.RSA.view.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.RSA.model.algoritmoRSA.Client;
import com.RSA.view.VHome;

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
	 * Metodo di inizializzazione degli esponenti della chiave.
	 */
	private boolean _sicuro;

	/**
	 * Costruttore
	 * @param nomeClient Nome del client da inizializzare.
	 */
	public InizializzaClientListener(String nomeClient, boolean sicuro) {
		this._nomeClient = nomeClient;
		this._sicuro = sicuro;
	}
	
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone per inizializzare un client.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Individuo quale client sto inizializzando.
		switch (_nomeClient) {
		case "Bob":
			Client Bob = new Client("Bob", _sicuro);
			VHome.getInstance().creaPanelInizializzatoBob(Bob);
			break;
		case "Alice":
			Client Alice = new Client("Alice", _sicuro);
			VHome.getInstance().creaPanelInizializzatoAlice(Alice);
			break;

		default:
			break;
		}		
	}

}
