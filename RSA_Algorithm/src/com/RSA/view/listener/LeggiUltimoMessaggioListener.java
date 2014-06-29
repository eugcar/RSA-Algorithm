/**
 * 
 */
package com.RSA.view.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import com.RSA.model.algoritmoRSA.Client;
import com.RSA.model.algoritmoRSA.MessaggioChiaro;
import com.RSA.model.algoritmoRSA.MessaggioCifrato;
import com.RSA.view.VHome;

/**
 * @author Eugenio
 *
 */
public class LeggiUltimoMessaggioListener extends MouseAdapter {

	/**
	 * Nome del client da inizializzare.
	 */
	private String _nomeClient;
	/**
	 * Costruttore
	 * 
	 * @param nomeClient Nome del client da inizializzare.
	 */
	public LeggiUltimoMessaggioListener(String nomeClient) {
		this._nomeClient = nomeClient;
	}
	
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone per leggere l'ultimo messaggio
	 * ricevuto da un client.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Recupero il frame
		VHome home = VHome.getInstance();
		// Recupero i client
		Client Bob = home.get_Bob();
		Client Alice = home.get_Alice();
		// Individuo quale Client sto trattando.
		switch (_nomeClient) {
		case "Bob":
			// Recupero l'ultimo messaggio ricevuto da Bob.
			MessaggioCifrato messaggioCifratoBob = Bob.getUltimoMessaggioRicevutoCifrato();
			MessaggioChiaro messaggioChiaroBob = Bob.getAndRemoveUltimoMessaggioRicevutoInChiaro();
			// Controllo che Bob abbia ricevuto almeno un messaggio
			if (messaggioChiaroBob!= null) {
				JOptionPane.showMessageDialog(home, messaggioChiaroBob.get_messaggioChiaro() + "\n" + messaggioCifratoBob.get_messaggioCifrato().toString(), "Ultimo messaggio", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(home, "Nessun messaggio presente", "Attenzione", JOptionPane.WARNING_MESSAGE);
			}
			
			break;
		case "Alice":
			// Recupero l'ultimo messaggio ricevuto da Alice.
			MessaggioCifrato messaggioCifratoAlice = Alice.getUltimoMessaggioRicevutoCifrato();
			MessaggioChiaro messaggioChiaroAlice = Alice.getAndRemoveUltimoMessaggioRicevutoInChiaro();
			// Controllo che Alice abbia ricevuto almeno un messaggio
			if (messaggioChiaroAlice!= null) {
				JOptionPane.showMessageDialog(home, messaggioChiaroAlice.get_messaggioChiaro() + "\n" + messaggioCifratoAlice.get_messaggioCifrato(), "Ultimo messaggio", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(home, "Nessun messaggio presente", "Attenzione", JOptionPane.WARNING_MESSAGE);
			}
			break;

		default:
			break;
		}		
	}
}
