package com.bbva.cgto;

import com.bbva.cgto.dto.response.EntradaDTO;
import com.bbva.cgto.dto.response.ResponseDTO;
import com.bbva.cgto.lib.r001.CGTOR001;
import com.bbva.elara.domain.transaction.Severity;

/**
 * 'Response
 *
 */
public class CGTOT00101COTransaction extends AbstractCGTOT00101COTransaction {

	/**
	 * The execute method...
	 */
	@Override
	public void execute() {
		CGTOR001 cgtoR001 = this.getServiceLibrary(CGTOR001.class);

		EntradaDTO entrada = getEntrada();
		ResponseDTO respuesta = cgtoR001.executeEncolar(entrada);

		if(!getAdviceList().isEmpty()){
			this.setSeverity(Severity.ENR);
		} else {
			setRespuesta(respuesta);
		}
	}

}
