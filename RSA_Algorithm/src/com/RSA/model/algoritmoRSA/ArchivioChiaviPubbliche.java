/**
 * 
 */
package com.RSA.model.algoritmoRSA;

import java.util.HashMap;
import java.util.Map;

/**
 * Questa classe rappresenta l'archivio delle chiavi pubbliche dei client.
 * 
 * @author Eugenio
 */
public class ArchivioChiaviPubbliche {
	/**
	 * Mappa contenente tutte le chiavi pubbliche dei client.
	 */
	private Map<String, PublicKey> _chiaviPubblicheClient;
	/**
	 * Istanza unica della classe - Pattern Singleton
	 */
	private static ArchivioChiaviPubbliche _instance = null;
	/**
	 * Costruttore.
	 */
	private ArchivioChiaviPubbliche() {
		_chiaviPubblicheClient = new HashMap<String, PublicKey>();
	}
	/**
	 * Metodo per ottenere l'istanza unica della classe - Pattern Singleton
	 */
	public static ArchivioChiaviPubbliche getInstance() {
		if (_instance == null) {
			_instance = new ArchivioChiaviPubbliche();
		}
		return _instance;
	}
	/**
	 * Metodo per aggiungere un client all'archivio.
	 * 
	 * @param nomeClient Nome del client.
	 * @param publicKeyClient Chiave pubblica del client.
	 */
	public void aggiungiClient(String nomeClient, PublicKey publicKeyClient) {
		_chiaviPubblicheClient.put(nomeClient, publicKeyClient);
	}
	/**
	 * Metodo per aggiornare la chiave di un client.
	 * 
	 * @param nomeClient Nome del client.
	 * @param publicKeyClient Chiave pubblica del client.
	 */
	public void aggiornaChiaveClient(String nomeClient, PublicKey publicKeyClient) {
		_chiaviPubblicheClient.replace(nomeClient, publicKeyClient);
	}
	/**
	 * Metodo per ottenere la chiave pubblica di un client.
	 * 
	 * @param nomeClient Nome del client per il quale si vuole ottenere la chiave.
	 */
	public PublicKey ottieniChiaveClient(String nomeClient) {
		return _chiaviPubblicheClient.get(nomeClient);
	}
}
