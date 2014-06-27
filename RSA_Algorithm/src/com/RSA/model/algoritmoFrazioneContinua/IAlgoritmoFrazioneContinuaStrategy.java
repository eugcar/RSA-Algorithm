/**
 * 
 */
package com.RSA.model.algoritmoFrazioneContinua;

import java.util.List;

import com.RSA.model.Frazione;

/**
 * Questa intefaccia contiene il metodo per calcolare le frazioni continue. - Design Pattern Strategy
 * 
 * @author Eugenio
 */
public interface IAlgoritmoFrazioneContinuaStrategy {
	/**
	 * Metodo per calcolare le frazioni continue della frazione data.
	 * 
	 * @param frazione Frazione per la quale calcolare le frazioni continue.
	 * @return Lista dei risultati alla generica iterazione dell'algoritmo. 
	 */
	public List<RisultatoIterazioneCalcoloFrazioneContinua> calcolaFrazioneContinua(Frazione frazione);
}
