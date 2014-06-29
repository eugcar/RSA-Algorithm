/**
 * 
 */
package com.RSA.view.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import com.RSA.model.algoritmoAttaccoEsponenteBassiWiener.AlgoritmoAttaccoEsponenteBassoWienerDefaultStrategy;
import com.RSA.model.algoritmoAttaccoEsponenteBassiWiener.IAlgoritmoAttaccoEsponenteBassoWienerStrategy;
import com.RSA.model.algoritmoRSA.ArchivioChiaviPubbliche;
import com.RSA.model.algoritmoRSA.Client;
import com.RSA.model.algoritmoRSA.Cracker;
import com.RSA.model.algoritmoRSA.PrivateKey;
import com.RSA.model.algoritmoRSA.PublicKey;
import com.RSA.view.VHome;

/**
 * @author Eugenio
 *
 */
public class OttieniChiaveClientListener extends MouseAdapter {

	/**
	 * Nome del client da inizializzare.
	 */
	private String _nomeClient;
	/**
	 * Costruttore
	 * 
	 * @param nomeClient Nome del client da inizializzare.
	 */
	public OttieniChiaveClientListener(String nomeClient) {
		this._nomeClient = nomeClient;
	}
	
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone per cercare di ottenere 
	 * la chiave di un Client.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Recupero il frame
		VHome home = VHome.getInstance();
		// Recupero i client e il cracker
		Client Bob = home.get_Bob();
		Client Alice = home.get_Alice();
		Cracker Eve = home.get_Eve();
		// Recupero la strategia da utilizzare per provare a ricavare la chiave privata di Bob.
		IAlgoritmoAttaccoEsponenteBassoWienerStrategy algoritmoWiener = new AlgoritmoAttaccoEsponenteBassoWienerDefaultStrategy();
		// Individuo quale Client sto trattando.
		switch (_nomeClient) {
		case "Bob":
			// Controllo che Bob sia stato inizializzato.
			if (Bob != null) {
				// Recupero la chiave di Bob.
				PublicKey publicKeyBob = ArchivioChiaviPubbliche.getInstance().ottieniChiaveClient("Bob");	
				// Provo a calcolare la chiave privata di Bob.
				PrivateKey privateKeyBob = Eve.ottieniChiavePrivataDaChiavePubblica(publicKeyBob);
				// Controllo se ho ottenuto la chiave
				if (privateKeyBob != null) {
					String messaggio = "P: " + privateKeyBob.get_p().toString() + "\n Q:" + privateKeyBob.get_q().toString() + "\n D: " + privateKeyBob.get_d().toString();
					JOptionPane.showMessageDialog(home, messaggio, "Chiave Privata Bob", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(home, "Chiave non trovata!", "Attenzione", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				// Comunico all'utente che Bob non è stato inizializzato
				JOptionPane.showMessageDialog(home, "Bob non è stato inizializzato!", "Attenzione", JOptionPane.WARNING_MESSAGE);
			}
			break;
		case "Alice":
			// Controllo che Alice sia stata inizializzata.
			if (Alice != null) {
				// Recupero la chiave di Alice.
				PublicKey publicKeyAlice = ArchivioChiaviPubbliche.getInstance().ottieniChiaveClient("Alice");
				// Provo a calcolare la chiave privata di Alice.
				PrivateKey privateKeyAlice = Eve.ottieniChiavePrivataDaChiavePubblica(publicKeyAlice);
				// Controllo se ho ottenuto la chiave
				if (privateKeyAlice != null) {
					String messaggio = "P: " + privateKeyAlice.get_p().toString() + "\n Q:" + privateKeyAlice.get_q().toString() + "\n D: " + privateKeyAlice.get_d().toString();
					JOptionPane.showMessageDialog(home, messaggio, "Chiave Privata Alice", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(home, "Chiave non trovata!", "Attenzione", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				// Comunico all'utente che Alice non è stata inizializzata.
				JOptionPane.showMessageDialog(home, "Alice non è stata inizializzata!", "Attenzione", JOptionPane.WARNING_MESSAGE);
			}
			break;

		default:
			break;
		}		
	}
}
