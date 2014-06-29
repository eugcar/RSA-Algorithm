/**
 * 
 */
package com.RSA.view.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import com.RSA.model.algoritmoRSA.Client;
import com.RSA.model.algoritmoRSA.MessaggioChiaro;
import com.RSA.view.VHome;

/**
 * @author Eugenio
 *
 */
public class InviaMessaggioListener extends MouseAdapter {

	/**
	 * Nome del client da inizializzare.
	 */
	private String _nomeClient;
	/**
	 * Costruttore
	 * 
	 * @param nomeClient Nome del client da inizializzare.
	 */
	public InviaMessaggioListener(String nomeClient) {
		this._nomeClient = nomeClient;
	}
	
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone per inviare un messaggio ad un client.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Recupero il frame
		VHome home = VHome.getInstance();
		// Recupero i client
		Client Bob = home.get_Bob();
		Client Alice = home.get_Alice();
		// Chiedo all'utente il contenuto del messaggio in chiaro.
		String contenutoChiaro = JOptionPane.showInputDialog(home, "Inserisci il testo del messaggio","Invio Messaggio", JOptionPane.QUESTION_MESSAGE);
		// Individuo quale client sto inizializzando.
		switch (_nomeClient) {
		case "Bob":
			// Creo un nuovo messaggio in chiaro
			MessaggioChiaro messaggioChiaroDaBob = new MessaggioChiaro(Bob, Alice, contenutoChiaro);
			// Controllo che Alice sia stata inizializzata.
			if (Alice != null) {
				// Invio il messaggio da Bob ad Alice
				Bob.inviaMessaggioToClient(messaggioChiaroDaBob);
			} else {
				// Comunico a Bob che Alice non è stata inizializzata
				JOptionPane.showMessageDialog(home, "Alice non è stata inizializzata!", "Attenzione", JOptionPane.WARNING_MESSAGE);
			}
			
			break;
		case "Alice":
			// Creo un nuovo messaggio in chiaro
			MessaggioChiaro messaggioChiaroDaAlice = new MessaggioChiaro(Alice, Bob, contenutoChiaro);
			// Controllo che Bob sia stato inizializzata.
			if (Bob != null) {
				// Invio il messaggio da Alice a Bob
				Alice.inviaMessaggioToClient(messaggioChiaroDaAlice);
			} else {
				// Comunico a Alice che Bob non è stata inizializzata
				JOptionPane.showMessageDialog(home, "Bob non è stata inizializzato!", "Attenzione", JOptionPane.WARNING_MESSAGE);
			}
			break;

		default:
			break;
		}		
	}
}
