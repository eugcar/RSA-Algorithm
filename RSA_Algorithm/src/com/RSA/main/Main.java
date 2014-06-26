/**
 * 
 */
package com.RSA.main;

import java.math.BigInteger;

import com.RSA.model.Frazione;
import com.RSA.model.calcolaFrazioneContinua.AlgoritmoFrazioneContinuaDefaultStrategy;
import com.RSA.model.calcolaFrazioneContinua.IAlgoritmoFrazioneContinuaStrategy;

/**
 * @author Eugenio
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IAlgoritmoFrazioneContinuaStrategy calcoloFrazioneContinuaStrategy = new AlgoritmoFrazioneContinuaDefaultStrategy();
		// Creo la frazione.
		Frazione frazione = new Frazione(new BigInteger("3238151174542919"), new BigInteger("1966981193543797"));
		// Calcolo la frazione continua.
		calcoloFrazioneContinuaStrategy.calcolaFrazioneContinua(frazione);
		
//		IAlgoritmoEuclideoStrategy algoritmoEuclideo = new AlgoritmoEuclideoDefaultStrategy();
//		algoritmoEuclideo.calcolaMCD(new BigInteger("11111"), new BigInteger("12345"));

	}

}
