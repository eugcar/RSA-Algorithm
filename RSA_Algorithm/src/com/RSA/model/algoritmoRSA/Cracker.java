/**
 * 
 */
package com.RSA.model.algoritmoRSA;

import com.RSA.model.algoritmoAttaccoEsponenteBassiWiener.AlgoritmoAttaccoEsponenteBassoWienerDefaultStrategy;
import com.RSA.model.algoritmoAttaccoEsponenteBassiWiener.IAlgoritmoAttaccoEsponenteBassoWienerStrategy;

/**
 * Questa classe rappresenta un generico cracker (Eve) che vuole cercare di ottenere la chiave privata 
 * di un client (Bob, Alice).
 * 
 * @author Eugenio
 */
public class Cracker {
	/**
	 * Metodo per cercare di ottenere la chiave privata di un client a partire dalla sua chiave pubblica.
	 * @param publicKey Chiave pubblica del client, del quale si vuole conoscere la privata.
	 * @return Chiave privata se esito positivo. Null altrimenti.
	 */
	public PrivateKey ottieniChiavePrivataDaChiavePubblica(PublicKey publicKey) {

		// Scelgo l'algoritmo di attacco.
		IAlgoritmoAttaccoEsponenteBassoWienerStrategy algoritmoAttaccoEsponenteBassoWienerStrategy = new AlgoritmoAttaccoEsponenteBassoWienerDefaultStrategy();
		// Provo ad ottenere la chiave
		PrivateKey privateKeyClient = algoritmoAttaccoEsponenteBassoWienerStrategy.calcolaPrivateKeyClient(publicKey);
		
		return privateKeyClient;
	}
}
