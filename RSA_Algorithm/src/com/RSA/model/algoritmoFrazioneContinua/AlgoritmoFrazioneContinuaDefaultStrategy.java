/**
 * 
 */
package com.RSA.model.algoritmoFrazioneContinua;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.RSA.model.Frazione;
import com.RSA.model.algoritmoEuclideo.AlgoritmoEuclideoDefaultStrategy;
import com.RSA.model.algoritmoEuclideo.IAlgoritmoEuclideoStrategy;
import com.RSA.model.algoritmoEuclideo.RisultatoIterazioneAlgoritmoEuclideo;

/**
 * @author Eugenio
 *
 */
public class AlgoritmoFrazioneContinuaDefaultStrategy implements IAlgoritmoFrazioneContinuaStrategy {

	/* (non-Javadoc)
	 * @see com.RSA.model.ICalcolaFrazioneContinuaStrategy#calcolaFrazioneContinua(double)
	 */
	public List<RisultatoIterazioneCalcoloFrazioneContinua> calcolaFrazioneContinua(double d) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.RSA.model.ICalcolaFrazioneContinuaStrategy#calcolaFrazioneContinua(java.math.BigInteger, java.math.BigInteger)
	 */
	public List<RisultatoIterazioneCalcoloFrazioneContinua> calcolaFrazioneContinua(Frazione frazione) {
		// Variabili e oggetti utilizzati
		RisultatoIterazioneCalcoloFrazioneContinua risultatoIterazioneCalcoloFrazioneContinua;
		BigInteger numeratoreIniziale, denominatoreIniziale, a0, a1, a_n_piu_1;
		Frazione meno_1, meno_2;
		// Lista nella quale si inseriranno i risultati del calcolo delle frazioni continue.
		List<RisultatoIterazioneCalcoloFrazioneContinua> listaRisultatiFrazioniContinue = new ArrayList<RisultatoIterazioneCalcoloFrazioneContinua>();
		
		// Frazioni iniziali
		meno_1 = new Frazione(new BigInteger("1"), new BigInteger("0"));
		meno_2 = new Frazione(new BigInteger("0"), new BigInteger("1"));
		
		// Prendo numeratore e denominatore della frazione
		numeratoreIniziale = frazione.get_numeratore();
		denominatoreIniziale = frazione.get_denominatore();		
		/* 
		*  Calcolo l'MCD tra numeratore e denominatore in modo da poter utilizzare i quozienti 
		*  trovati come gli 'ai' per il calcolo delle frazioni continue.
		*/ 
		IAlgoritmoEuclideoStrategy algoritmoEuclideo = new AlgoritmoEuclideoDefaultStrategy();
		List<RisultatoIterazioneAlgoritmoEuclideo> listaRisultatiAlgoritmoEuclideo = algoritmoEuclideo.calcolaMCD(numeratoreIniziale, denominatoreIniziale);
		// Se il rapporto tra numeratore e denominatore è strettamente minore di 1 devo aggiungere come primo 'ai' uno zero.
		BigInteger numeratore_su_denominatore = numeratoreIniziale.divide(denominatoreIniziale);
		if (numeratore_su_denominatore.compareTo(BigInteger.ONE) < 0) {
			listaRisultatiAlgoritmoEuclideo.add(0, new RisultatoIterazioneAlgoritmoEuclideo(null, null, new BigInteger("0"), null));
		}
		
		/* --------------------------------- Prima Iterazione ------------------------------------------- */
		// Prendo a0 e rimuovo il primo elemento dalla lista dei risultati dell'algoritmo euclideo.
		a0 = listaRisultatiAlgoritmoEuclideo.get(0).get_quoziente();
		listaRisultatiAlgoritmoEuclideo.remove(0);
		// Calcolo la prima frazione.
		risultatoIterazioneCalcoloFrazioneContinua = calcolaNpiu1_esimaFrazione(meno_1, meno_2, a0);
		// Aggiungo il risultato alla lista
		listaRisultatiFrazioniContinue.add(risultatoIterazioneCalcoloFrazioneContinua);
		/* 
		*  Controllo se è presente almeno un elemento nella lista dei risultati dell'algoritmo euclideo. 
		*  Non è necessario effettuare questo controllo nel caso precedente, visto che due numeri hanno sempre
		*  almeno 1, come divisore comune.
		*/
		if (listaRisultatiAlgoritmoEuclideo.size()!= 0) {
			/* --------------------------------- Seconda Iterazione ------------------------------------------- */
			// Prendo a0 e rimuovo il primo elemento dalla lista dei risultati dell'algoritmo euclideo.
			a1 = listaRisultatiAlgoritmoEuclideo.get(0).get_quoziente();
			listaRisultatiAlgoritmoEuclideo.remove(0);
			// Calcolo la seconda frazione.
			risultatoIterazioneCalcoloFrazioneContinua = calcolaNpiu1_esimaFrazione(risultatoIterazioneCalcoloFrazioneContinua.get_frazione(),
					meno_1, a1);
			// Aggiungo il risultato alla lista
			listaRisultatiFrazioniContinue.add(risultatoIterazioneCalcoloFrazioneContinua);
		}
		// Ciclo sui risultati dell'algoritmo euclideo per calcolare le frazioni continue
		for (Iterator<RisultatoIterazioneAlgoritmoEuclideo> iterator = listaRisultatiAlgoritmoEuclideo.iterator(); iterator.hasNext();) {
			RisultatoIterazioneAlgoritmoEuclideo risultatoIterazioneAlgoritmoEuclideo = (RisultatoIterazioneAlgoritmoEuclideo) iterator.next();
			// Prendo il quoziente del generico risultato dell'algoritmo euclideo
			a_n_piu_1 = risultatoIterazioneAlgoritmoEuclideo.get_quoziente();
			// Prendo i risultati precedenti
			RisultatoIterazioneCalcoloFrazioneContinua risultato_n = listaRisultatiFrazioniContinue.get(listaRisultatiFrazioniContinue.size()-1);
			RisultatoIterazioneCalcoloFrazioneContinua risultato_n_meno_1 = listaRisultatiFrazioniContinue.get(listaRisultatiFrazioniContinue.size()-2);;
			// Calcolo la generica frazione continua
			risultatoIterazioneCalcoloFrazioneContinua = calcolaNpiu1_esimaFrazione(risultato_n.get_frazione(), risultato_n_meno_1.get_frazione(), a_n_piu_1);
			// Aggiungo l'oggetto risultato alla lista dei risultati
			listaRisultatiFrazioniContinue.add(risultatoIterazioneCalcoloFrazioneContinua);
		}	
		/* Se il rapporto tra numeratore e denominatore è strettamente minore di 1 devo eliminare il primo elemento 
		 * aggiunto alla lista delle frazioni in quanto è una frazione con il numeratore nullo.
		*/
		if (numeratore_su_denominatore.compareTo(BigInteger.ONE) < 0) {
			listaRisultatiFrazioniContinue.remove(0);
		}
		
//		TESTING
//		
//		System.out.println("\n \n \n");
//		System.out.println("FRAZIONI CONTINUE: \n");
//		for (Iterator<RisultatoIterazioneCalcoloFrazioneContinua> iterator = listaRisultatiFrazioniContinue.iterator(); iterator.hasNext();) {
//			RisultatoIterazioneCalcoloFrazioneContinua FrazioniContinue = (RisultatoIterazioneCalcoloFrazioneContinua) iterator.next();
//			System.out.println(FrazioniContinue.toString());
//		}
		
		return listaRisultatiFrazioniContinue;
	}
	/**
	 * Metodo per il calcolo del risultato per il calcolo della N più 1 - esima frazione continua.
	 * 
	 * @param frazione_n Frazione n - esima.
	 * @param frazione_n_meno_1 Frazione n-1 - esima.
	 * @param a_n_piu_1 Valore di a_n+1.
	 * @return Oggetto contenente il valore della nuova frazione, e il valore di a_n+1.
	 */
	private RisultatoIterazioneCalcoloFrazioneContinua calcolaNpiu1_esimaFrazione(Frazione frazione_n, Frazione frazione_n_meno_1, BigInteger a_n_piu_1) {
		
		// Calcolo p_n_piu_1
		BigInteger a_n_piu_1_multiplicate_to_p_n = a_n_piu_1.multiply(frazione_n.get_numeratore());
		BigInteger p_n_piu_1 = a_n_piu_1_multiplicate_to_p_n.add(frazione_n_meno_1.get_numeratore());
		// Calcolo q_n_piu_1
		BigInteger a_n_piu_1_multiplicate_to_q_n = a_n_piu_1.multiply(frazione_n.get_denominatore());
		BigInteger q_n_piu_1 = a_n_piu_1_multiplicate_to_q_n.add(frazione_n_meno_1.get_denominatore());
		// Creo la frazione contenente il risultato.
		Frazione frazione_n_piu_1 = new Frazione(p_n_piu_1, q_n_piu_1);
		// Creo l'oggetto contenente il risultato dell'iterazione.
		RisultatoIterazioneCalcoloFrazioneContinua risultatoIterazione = new RisultatoIterazioneCalcoloFrazioneContinua(a_n_piu_1, frazione_n_piu_1);
		
		return risultatoIterazione;
		
	}

}
