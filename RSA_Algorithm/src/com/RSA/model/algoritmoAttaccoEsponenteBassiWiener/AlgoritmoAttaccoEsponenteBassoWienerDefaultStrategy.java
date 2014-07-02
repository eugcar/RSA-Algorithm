/**
 * 
 */
package com.RSA.model.algoritmoAttaccoEsponenteBassiWiener;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

import com.RSA.model.Frazione;
import com.RSA.model.Utility;
import com.RSA.model.algoritmoFrazioneContinua.AlgoritmoFrazioneContinuaDefaultStrategy;
import com.RSA.model.algoritmoFrazioneContinua.IAlgoritmoFrazioneContinuaStrategy;
import com.RSA.model.algoritmoFrazioneContinua.RisultatoIterazioneCalcoloFrazioneContinua;
import com.RSA.model.algoritmoRSA.PrivateKey;
import com.RSA.model.algoritmoRSA.PublicKey;

/**
 * Questa classe rappresenta l'implementazione di default per l'attacco dell'algoritmo RSA, quando vengono
 * scelti degli esponenenti di cifratura / decifratura bassi. - Design Pattern Strategy
 * 
 * @author Eugenio
 */
public class AlgoritmoAttaccoEsponenteBassoWienerDefaultStrategy implements IAlgoritmoAttaccoEsponenteBassoWienerStrategy {
	
	/* (non-Javadoc)
	 * @see com.RSA.model.algoritmoAttaccoEsponenteBassiWiener.IAlgoritmoAttaccoEsponenteBassoWienerStrategy#calcolaFattori_n(java.math.BigInteger, java.math.BigInteger)
	 */
	public PrivateKey calcolaPrivateKeyClient(PublicKey publicKeyClient) {
		
		// Variabili
		BigInteger A, B, C, e_B_meno_1, Zero_order, FirstOrder, P, Q;
		BigInteger[] fattori_polinomio = null;
		PrivateKey privateKeyClient = null;
		// Prendo e, n dalla chiave pubblica
		BigInteger e = publicKeyClient.get_e();
		BigInteger n = publicKeyClient.get_n();
		// Prendo la lista delle frazioni continue di e/n
		Frazione frazione_e_n = new Frazione(e, n);
		IAlgoritmoFrazioneContinuaStrategy algoritmoFrazioniContinue = new AlgoritmoFrazioneContinuaDefaultStrategy();
		List<RisultatoIterazioneCalcoloFrazioneContinua> listaRisultatiFrazioniContinue = algoritmoFrazioniContinue.calcolaFrazioneContinua(frazione_e_n);
		// Ciclo su tutti gli elementi delle frazioni continue
		for (Iterator<RisultatoIterazioneCalcoloFrazioneContinua> iterator = listaRisultatiFrazioniContinue.iterator(); iterator.hasNext();) {
			// Generico risultato dell'iterazione del calcolo delle frazioni continue.
			RisultatoIterazioneCalcoloFrazioneContinua risultatoIterazioneCalcoloFrazioneContinua = (RisultatoIterazioneCalcoloFrazioneContinua) iterator.next();
			// Prendo i valori del risultato della generica iterazione del calcolo delle frazioni continue.
			A = risultatoIterazioneCalcoloFrazioneContinua.get_frazione().get_numeratore();   // A = k
			B = risultatoIterazioneCalcoloFrazioneContinua.get_frazione().get_denominatore(); // B = d
			// Verifico che (k/d) - (e/n) > 0
			Frazione frazione_k_d = new Frazione(A, B);
			Frazione frazione_k_d_meno_e_n = frazione_k_d.sottrai(frazione_e_n);
			// Controllo che B = d, sia dispari e che (k/d) - (e/n) > 0		
			if(!Utility.isPari(B) && frazione_k_d_meno_e_n.isPositiva()) {				
				// Calcolo C
				e_B_meno_1 = e.multiply(B).subtract(BigInteger.ONE);
				// Controllo che C sia un intero. Ovvero che e*B - 1 / A abbia resto nullo.
				if (Utility.A_divide_B(e_B_meno_1, A)) {
					C = e_B_meno_1.divide(A);
					// Calcolo radici del polinomio:  x^2 - x*(n - fi_n + 1) + n
					Zero_order = n;
					FirstOrder = Zero_order.subtract(C).add(BigInteger.ONE).negate();
					FirstOrder = FirstOrder.negate();
					// Calcolo le radici del polinomio di secondo grado.
					fattori_polinomio = this.calcolaRadiciPolinomio(BigInteger.ONE, FirstOrder, Zero_order);
					// Controllo di avere ottenuto un risultato non nullo.
					if (fattori_polinomio!= null) {
						P = fattori_polinomio[0];
						Q = fattori_polinomio[1];
						// Controllo se ho fattorizzato n correttamente, ovvero se P*Q = n
						if (P.multiply(Q).compareTo(n) == 0) {
							privateKeyClient = new PrivateKey(P, Q, B);
//							System.out.println("P: " + P);
//							System.out.println("Q: " + Q);
//							System.out.println("n=P*Q=" + P.multiply(Q).toString());
						}
					}
				}
			}
		}
		return privateKeyClient;
	}
	/**
	 * Metodo per ottenere le radici di un polinomio di secondo grado nella forma a*x^2 + b*x + c = 0.
	 * 
	 * @param a_integer Termine di secondo grado.
	 * @param b_integer Termine di primo grado.
	 * @param c_integer Termine noto.
	 * @return Radici del polinomio. Null altrimenti.
	 */
	private BigInteger[] calcolaRadiciPolinomio(BigInteger a_integer, BigInteger b_integer, BigInteger c_integer) {

		// Array dove si inseriranno i risultati.
		BigInteger[] radiciPolinomio = null;
		// Trasformazione da BigInteger -> double
		double a = a_integer.doubleValue();
		double b = b_integer.doubleValue();
		double c = c_integer.doubleValue();
		// Calcolo il discriminante
		double discriminante = Math.sqrt((b*b) - (4*a*c)); 
		// Controllo se si ottengono due soluzioni distinte.
		if (discriminante > 0) {
			double r1 = (b + discriminante) / 2;
			double r2 = (b - discriminante) / 2;
			// Controllo che le variabili siano intere
			if (Utility.isIntero(r1) && Utility.isIntero(r2)) {
				// Inizializzo l'array
				radiciPolinomio = new BigInteger[2];
				// Aggiungo le radici all'array
				radiciPolinomio[0] = new BigDecimal(r1).toBigInteger();
				radiciPolinomio[1] = new BigDecimal(r2).toBigInteger();
			}
		}
		
		return radiciPolinomio;
	}

}
