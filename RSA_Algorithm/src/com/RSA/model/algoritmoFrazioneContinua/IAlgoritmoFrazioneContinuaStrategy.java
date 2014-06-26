/**
 * 
 */
package com.RSA.model.algoritmoFrazioneContinua;

import java.util.List;

import com.RSA.model.Frazione;

/**
 * @author Eugenio
 *
 */
public interface IAlgoritmoFrazioneContinuaStrategy {

	public List<RisultatoIterazioneCalcoloFrazioneContinua> calcolaFrazioneContinua(double d);
	public List<RisultatoIterazioneCalcoloFrazioneContinua> calcolaFrazioneContinua(Frazione frazione);
}
