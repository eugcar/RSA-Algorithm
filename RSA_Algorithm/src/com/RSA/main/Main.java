/**
 * 
 */
package com.RSA.main;

import java.math.BigInteger;

import com.RSA.model.Frazione;
import com.RSA.model.algoritmoAttaccoEsponenteBassiWiener.AlgoritmoAttaccoEsponenteBassoWienerDefaultStrategy;
import com.RSA.model.algoritmoAttaccoEsponenteBassiWiener.IAlgoritmoAttaccoEsponenteBassoWienerStrategy;
import com.RSA.model.algoritmoEuclideo.AlgoritmoEuclideoDefaultStrategy;
import com.RSA.model.algoritmoEuclideo.IAlgoritmoEuclideoStrategy;
import com.RSA.model.algoritmoFrazioneContinua.AlgoritmoFrazioneContinuaDefaultStrategy;
import com.RSA.model.algoritmoFrazioneContinua.IAlgoritmoFrazioneContinuaStrategy;

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
		
		IAlgoritmoAttaccoEsponenteBassoWienerStrategy algoritmoWiener = new AlgoritmoAttaccoEsponenteBassoWienerDefaultStrategy();
		algoritmoWiener.calcolaFattori_n(new BigInteger("3235119"), new BigInteger("1966981193543797"));

	}

}
