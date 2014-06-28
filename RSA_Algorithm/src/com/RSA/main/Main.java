/**
 * 
 */
package com.RSA.main;

import java.math.BigInteger;

import com.RSA.model.algoritmoRSA.Client;
import com.RSA.model.algoritmoRSA.GeneratoreChiavi;
import com.RSA.model.algoritmoRSA.MessaggioChiaro;
import com.RSA.model.algoritmoRSA.MessaggioCifrato;
import com.RSA.model.algoritmoTestPrimalita.AlgoritmoTestPrimalitaMillerRabinStrategy;
import com.RSA.model.algoritmoTestPrimalita.IAlgoritmoTestPrimalitaStrategy;
import com.RSA.view.VHome;

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
//		
//		IAlgoritmoTestPrimalitaStrategy algoritmoTestPrimalita = new AlgoritmoTestPrimalitaMillerRabinStrategy();
//		boolean esito=algoritmoTestPrimalita.testaPrimalitaIntero(new BigInteger("66666666666666666666666666666666666666666666666666666666666666666666666666666666666685385908489083983333333333333333333333333333333333333333333333333333333333333333333334647370887356349269146535184543"), 10000);
//		// Controllo l'esito della prova.
//		if (esito == true) {
//			System.out.println("PRIMO");
//		} else {
//			System.out.println("NON PRIMO");
//		}
		
		VHome home = VHome.getInstance();
		
//		System.out.println("BOB: \n");
//		Client Bob = new Client();
//		System.out.println("ALICE: \n");
//		Client Alice = new Client();
//		
//		// Creo il nuovo messaggio in chiaro da Bob per Alice
//		MessaggioChiaro messaggioChiaroDaBob = new MessaggioChiaro(Bob, Alice, "Ciao Alice");
//		// Invio il messaggio da Bob ad Alice
//		Bob.inviaMessaggioToClient(messaggioChiaroDaBob);
//		// Prendo il messaggio ricevuto da Alice cifrato
//		MessaggioCifrato messaggioCifratoDaBob = Alice.get_messaggiRicevuti().get(Alice.get_messaggiRicevuti().size()-1);
//		// Stampo il messaggio cifrato
//		System.out.println("Cifrato: " + messaggioCifratoDaBob.get_messaggioCifrato());		
//		// Prendo il messaggio ricevuto da Alice.
//		MessaggioChiaro messaggioChiaroAdAlice = Alice.getUltimoMessaggioRicevutoInChiaro();
//		// Stampo il contenuto del messaggio
//		System.out.println("Chiaro: " + messaggioChiaroAdAlice.get_messaggioChiaro());
		
		
//		BigInteger integer = Bob.toBigInteger("Oh mio dio ma è bellissimo!_:;,.");
//		System.out.println(integer.toString());
//		
//		String string = Bob.fromBigInteger(integer);
//		System.out.println(string);
		
		
	}
}
