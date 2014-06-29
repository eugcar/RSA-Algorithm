/**
 * 
 */
package com.RSA.model.algoritmoRSA;

import java.math.BigInteger;

/**
 * Questa classe rappresenta la macchina RSA, ovvero quella con la responsabilità di cifrare e decifrare messaggi.
 * In particolare può prendere in input un messaggio in chiaro, ovvero un oggetto costituito da un terna (mittente,
 * destinatario, stringa), dove la stringa rappresenta il contenuto del messaggio vero e proprio, dando come 
 * output una terna costituita da (mittente, destinatario, integer), dove integer è la stringa di input 
 * convertita in un numero intero e successivamente cifrata seguendo i passi dell'algoritmo. Ovviamente può effettuare
 * anche l'operazione inversa, prendendo in input una triade con un integer, fornendo in output una triade con una stringa.
 * 
 * @author Home
 */
public class MacchinaRSA {
	/**
	 * Metodo per cifrare un messaggio, ottenendo un messaggio cifrato.
	 * 
	 * @param messaggioChiaro Messaggio da cifrare.
	 * @return Messaggio cifrato.
	 */
	public MessaggioCifrato fromMessaggioChiaroToMessaggioCifrato(MessaggioChiaro messaggioChiaro) {
		// Contenuto del messaggio
		String stringaChiaro = messaggioChiaro.get_messaggioChiaro();
		// Recupero il nome del destinatario del messaggio
		String nomeClientDestinatario = messaggioChiaro.get_destinatario().get_nomeClient();
		// Recupero dall'archivio delle chiavi la chiave del destinatario.
		PublicKey publicKeyDestinatario = ArchivioChiaviPubbliche.getInstance().ottieniChiaveClient(nomeClientDestinatario);
		// Converto la stringa in integer
		BigInteger integerChiaro = this.toBigInteger(stringaChiaro);
		// Cifro l'integer
		BigInteger integerCifrato = integerChiaro.modPow(publicKeyDestinatario.get_e(), publicKeyDestinatario.get_n());
		// Costruisco il messaggioCifrato
		MessaggioCifrato messaggioCifrato = new MessaggioCifrato(messaggioChiaro.get_mittente(), messaggioChiaro.get_destinatario(), integerCifrato);
		
		return messaggioCifrato;
	}
	/**
	 * Metodo per decifrare un messaggio, ottenendo così il messaggio in chiaro.
	 * 
	 * @param messaggioCifrato Messaggio cifrato.
	 * @return Messaggio in chiaro.
	 */
	public MessaggioChiaro fromMessaggioCifratoToMessaggioChiaro(MessaggioCifrato messaggioCifrato) {
		// Recupero il nome del destinatario del messaggio
		String nomeClientDestinatario = messaggioCifrato.get_destinatario().get_nomeClient();
		// Recupero dall'archivio delle chiavi la chiave del destinatario.
		PublicKey publicKeyDestinatario = ArchivioChiaviPubbliche.getInstance().ottieniChiaveClient(nomeClientDestinatario);
		// Recupero la chiave pubblica e privata del Client Destinatario.
		PrivateKey privateKeyDestinatario = messaggioCifrato.get_destinatario().get_privateKey();
		// Contenuto del messaggio
		BigInteger integerCifrato = messaggioCifrato.get_messaggioCifrato();
		// Decifro l'integer
		BigInteger integerChiaro = integerCifrato.modPow(privateKeyDestinatario.get_d(), publicKeyDestinatario.get_n());
		// Converto integer in Stringa
		String stringaChiaro = this.fromBigInteger(integerChiaro);
		// Costruisco il messaggioChiaro
		MessaggioChiaro messaggioChiaro = new MessaggioChiaro(messaggioCifrato.get_mittente(), messaggioCifrato.get_destinatario(), stringaChiaro);
		
		return messaggioChiaro;
	}
	
	/**
	 * Metodo per convertire una stringa in un BigInteger.
	 * 
	 * @param stringToConvert Stringa da convertire.
	 * @return BigInteger rappresentate la stringa.
	 */
	private BigInteger toBigInteger(String stringToConvert)
	{
	    return new BigInteger(stringToConvert.getBytes());
	}
	/**
	 * Metodo per convertire un BigInter in una stringa.
	 * 
	 * @param integer Intero da convertire in una stringa.
	 * @return Stringa rappresentante l'intero.
	 */
	private String fromBigInteger(BigInteger integer)
	{
	    return new String(integer.toByteArray());
	}

}

