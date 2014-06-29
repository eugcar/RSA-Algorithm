/**
 * 
 */
package com.RSA.model.algoritmoRSA;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Eugenio
 *
 */
public class Client {

	/**
	 * Nome univoco nel dominio dei client.
	 */
	private String _nomeClient;
	/**
	 * Chiave private del client.
	 */
	private PrivateKey _privateKey;
	/**
	 * Chiave pubblica del client.
	 */
	private PublicKey _publicKey;
	/**
	 * Macchina RSA utilizzata dal Client.
	 */
	private MacchinaRSA _macchinaRSA;
	/**
	 * Lista dei messaggi cifrati ricevuti.
	 */
	private List<MessaggioCifrato> _messaggiRicevuti;

	/**
	 * Costruttore
	 * 
	 * @param nomeClient Nome del client.
	 */
	public Client(String nomeClient, Boolean sicuro) {
		// Genero la chiave del client
		GeneratoreChiavi.generaChiavi(this, sicuro);
		// Inizializzo tutti gli attributi
		this._nomeClient = nomeClient;
		this._macchinaRSA = new MacchinaRSA();
		this._messaggiRicevuti = new LinkedList<MessaggioCifrato>();
		// Aggiungo la chiave all'archivio
		ArchivioChiaviPubbliche.getInstance().aggiungiClient(this._nomeClient, this._publicKey);
		
	}
	/**
	 * Metodo per inviare un messaggio cifrato ad un client.
	 * 
	 * @param messaggio Messaggio in chiaro da inviare ad un client.
	 */
	public void inviaMessaggioToClient(MessaggioChiaro messaggioChiaro) {
		// Si ottiene il messaggio cifrato attraverso la macchinaRSA.
		MessaggioCifrato messaggioCifrato = _macchinaRSA.fromMessaggioChiaroToMessaggioCifrato(messaggioChiaro);
		// Si aggiunge l'intero cifrato alla lista dei messaggi ricevuti dell'altro client.
		messaggioChiaro.get_destinatario().get_messaggiRicevuti().add(messaggioCifrato);
	}
	/**
	 * Metodo per ottenere e rimuovere l'ultimo messaggio ricevuto, decifrato per averlo in chiaro.
	 * 
	 * @return Messaggio in chiaro, se il client ha almeno un messaggio nella sua lista. Null altrimenti.
	 */
	public MessaggioChiaro getAndRemoveUltimoMessaggioRicevutoInChiaro() {
		// Messaggio da restituire.
		MessaggioChiaro messaggioChiaro = null;
		// Lunghezza lista di messaggi
		int indexLastMessage = this._messaggiRicevuti.size() - 1;
		// Controllo che ci sia almeno un messaggio nella lista.
		if (indexLastMessage >= 0) {
			// Rimuovo dalla lista dei messaggi l'ultimo messaggio ricevuto.
			MessaggioCifrato messaggioCifrato = this._messaggiRicevuti.remove(indexLastMessage);
			// Ricavo il messaggio in chiaro dal messaggio cifrato.
			messaggioChiaro = this._macchinaRSA.fromMessaggioCifratoToMessaggioChiaro(messaggioCifrato);
		}
		
		return messaggioChiaro;
	}
	/**
	 * Metodo per ottenere l'utlimo messaggio ricevuto, cifrato.
	 * 
	 * @return Messaggio cifrato, se il client ha almeno un messaggio nella sua lista. Null altrimenti.
	 */
	public MessaggioCifrato getUltimoMessaggioRicevutoCifrato() {
		// Messaggio da restituire.
		MessaggioCifrato messaggioCifrato = null;
		// Lunghezza lista di messaggi
		int indexLastMessage = this._messaggiRicevuti.size() - 1;
		// Controllo che ci sia almeno un messaggio nella lista.
		if (indexLastMessage >= 0) {
			// Rimuovo dalla lista dei messaggi l'ultimo messaggio ricevuto.
			messaggioCifrato = this._messaggiRicevuti.get(indexLastMessage);
		}
		
		return messaggioCifrato;
	}
	
	
	/**
	 * @return the _nomeClient
	 */
	public String get_nomeClient() {
		return _nomeClient;
	}
	/**
	 * @param _nomeClient the _nomeClient to set
	 */
	public void set_nomeClient(String _nomeClient) {
		this._nomeClient = _nomeClient;
	}
	/**
	 * @return the _privateKey
	 */
	public PrivateKey get_privateKey() {
		return _privateKey;
	}
	/**
	 * @param _privateKey the _privateKey to set
	 */
	public void set_privateKey(PrivateKey _privateKey) {
		this._privateKey = _privateKey;
	}
	/**
	 * @return the _publicKey
	 */
	public PublicKey get_publicKey() {
		return _publicKey;
	}
	/**
	 * @param _publicKey the _publicKey to set
	 */
	public void set_publicKey(PublicKey _publicKey) {
		this._publicKey = _publicKey;
	}
	/**
	 * @return the _macchinaRSA
	 */
	public MacchinaRSA get_macchinaRSA() {
		return _macchinaRSA;
	}
	/**
	 * @param _macchinaRSA the _macchinaRSA to set
	 */
	public void set_macchinaRSA(MacchinaRSA _macchinaRSA) {
		this._macchinaRSA = _macchinaRSA;
	}
	/**
	 * @return the _messaggiRicevuti
	 */
	public List<MessaggioCifrato> get_messaggiRicevuti() {
		return _messaggiRicevuti;
	}
	/**
	 * @param _messaggiRicevuti the _messaggiRicevuti to set
	 */
	public void set_messaggiRicevuti(List<MessaggioCifrato> _messaggiRicevuti) {
		this._messaggiRicevuti = _messaggiRicevuti;
	}
	
}
