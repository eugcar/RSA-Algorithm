/**
 * 
 */
package com.RSA.model.algoritmoRSA;

import java.math.BigInteger;

/**
 * @author Eugenio
 *
 */
public class Client {

	/**
	 * Id univoco per questo client.
	 */
	private int _id;
	/**
	 * Chiave private del client.
	 */
	private PrivateKey _privateKey;
	/**
	 * Chiave pubblica del client.
	 */
	private PublicKey _publicKey;
	
	/**
	 * Costruttore.
	 * 
	 * @param _id Id univoco del client.
	 * @param _privateKey Chiave privata del client.
	 * @param _publicKey Chiave pubblica del client.
	 */
	public Client(int _id, PrivateKey _privateKey, PublicKey _publicKey) {
		this._id = _id;
		this._privateKey = _privateKey;
		this._publicKey = _publicKey;
	}
	/**
	 * Costruttore
	 */
	public Client() {}

	/**
	 * Metodo per convertire una stringa in un BigInteger.
	 * 
	 * @param stringToConvert Stringa da convertire.
	 * @return BigInteger rappresentate la stringa.
	 */
	public BigInteger toBigInteger(String stringToConvert)
	{
	    return new BigInteger(stringToConvert.getBytes());
	}
	/**
	 * Metodo per convertire un BigInter in una stringa.
	 * 
	 * @param integer Intero da convertire in una stringa.
	 * @return Stringa rappresentante l'intero.
	 */
	public String fromBigInteger(BigInteger integer)
	{
	    return new String(integer.toByteArray());
	}
	
	/**
	 * @return the _id
	 */
	public int get_id() {
		return _id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void set_id(int _id) {
		this._id = _id;
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
	public PublicKey get_publicKey() {
		return _publicKey;
	}
	public void set_publicKey(PublicKey _publicKey) {
		this._publicKey = _publicKey;
	}
	
}
