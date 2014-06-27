/**
 * 
 */
package com.RSA.main;

import java.math.BigInteger;

import com.RSA.model.algoritmoTestPrimalita.AlgoritmoTestPrimalitaMillerRabinStrategy;
import com.RSA.model.algoritmoTestPrimalita.IAlgoritmoTestPrimalitaStrategy;

/**
 * @author Eugenio
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		IAlgoritmoFrazioneContinuaStrategy calcoloFrazioneContinuaStrategy = new AlgoritmoFrazioneContinuaDefaultStrategy();
//		// Creo la frazione.
//		Frazione frazione = new Frazione(new BigInteger("323815174542919"), new BigInteger("1966981193543797"));
//		// Calcolo la frazione continua.
//		calcoloFrazioneContinuaStrategy.calcolaFrazioneContinua(frazione);
//		
//		IAlgoritmoEuclideoStrategy algoritmoEuclideo = new AlgoritmoEuclideoDefaultStrategy();
//		algoritmoEuclideo.calcolaMCD(new BigInteger("11111"), new BigInteger("12345"));
		
//		IAlgoritmoAttaccoEsponenteBassoWienerStrategy algoritmoWiener = new AlgoritmoAttaccoEsponenteBassoWienerDefaultStrategy();
//		algoritmoWiener.calcolaFattori_n(new BigInteger("323815174542919"), new BigInteger("1966981193543797"));
		
		IAlgoritmoTestPrimalitaStrategy algoritmoTestPrimalita = new AlgoritmoTestPrimalitaMillerRabinStrategy();
		boolean esito=algoritmoTestPrimalita.testaPrimalitaIntero(new BigInteger("941085251"), 10);
		// Controllo l'esito della prova.
		if (esito == true) {
			System.out.println("PRIMO");
		} else {
			System.out.println("NON PRIMO");
		}
	}

}
