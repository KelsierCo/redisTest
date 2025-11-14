package com.bbva.cgto.lib.r001.impl;

import com.bbva.cgto.dto.response.EntradaDTO;
import com.bbva.cgto.dto.response.RequestDTO;
import com.bbva.cgto.dto.response.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

/**
 * The CGTOR001Impl class...
 */
public class CGTOR001Impl extends CGTOR001Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(CGTOR001Impl.class);
	private static final Double WEIGHT_X = 0.6;
	private static final Double WEIGHT_Y = 0.15;
	private static final Double WEIGHT_Z = 0.25;

	/**
	 * The execute method...
	 */
	@Override
	public ResponseDTO executeEncolar(EntradaDTO entrada) {
		RequestDTO request = new RequestDTO();
		LOGGER.info("request generado");

		Double p = generatePonderado(entrada.getTipoAtencion(),entrada.getPrioridadServicio(),entrada.getPrioridadSegmento());

		LOGGER.info("request poderado obtenido");
		request.setPonderado(p);
		request.setIdentificadorFila(entrada.getIdentificadorOficina());
		request.setIdentificadorTurno(entrada.getIdentificadorTurno());

		LOGGER.info("request llenado");

		return addRedis(request);
	}

	protected Jedis getJedis(){
		return new Jedis("localhost", 6379);
	}

	private ResponseDTO addRedis(RequestDTO requestDTO){
		ResponseDTO response = new ResponseDTO();

		LOGGER.info("Conectando a Redis");

		Jedis jedis = getJedis();
		long res = jedis.zadd(requestDTO.getIdentificadorFila(), requestDTO.getPonderado(), requestDTO.getIdentificadorTurno());

		if(res > 0){
			response.setResponse("ok");
		} else {
			response.setResponse("error");
			addAdvice("Err_Con");
		}


		LOGGER.info("finalizado");
		return response;
	}

	private Double generatePonderado(int x, int y, int z){

		Double normalX = normalizado(x, 1, 2);
		Double normalY = normalizado(y, 1, 15);
		Double normalZ = normalizado(z, 1, 15);

		return normalX * WEIGHT_X + normalY * WEIGHT_Y + normalZ * WEIGHT_Z;
	}

	private Double normalizado(int x, int minX,int maxX){
		return (double) (x-minX)/(maxX-minX);
	}
}
