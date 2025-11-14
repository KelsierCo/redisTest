package com.bbva.cgto;

import com.bbva.cgto.dto.response.EntradaDTO;
import com.bbva.cgto.dto.response.ResponseDTO;
import com.bbva.elara.transaction.AbstractTransaction;

/**
 * In this class, the input and output data is defined automatically through the setters and getters.
 */
public abstract class AbstractCGTOT00101COTransaction extends AbstractTransaction {

	protected AbstractCGTOT00101COTransaction(){
	}


	/**
	 * Return value for input parameter entrada
	 */
	protected EntradaDTO getEntrada(){
		return (EntradaDTO)this.getParameter("entrada");
	}

	/**
	 * Set value for ResponseDTO output parameter respuesta
	 */
	protected void setRespuesta(final ResponseDTO field){
		this.addParameter("respuesta", field);
	}
}
