package com.bbva.cgto.lib.r001.impl;

import com.bbva.cgto.dto.response.EntradaDTO;
import com.bbva.elara.domain.transaction.Advice;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import redis.clients.jedis.Jedis;

import java.util.List;

import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class CGTOR001ImplTest {

	@Mock
	private Jedis jedis;

	@InjectMocks
	private CGTOR001Impl cgtoR001 = new CGTOR001Impl(){

		@Override
		protected Jedis getJedis(){
			return jedis;
		}
	};

	@Test
	public void executeTest(){

		EntradaDTO entrada = new EntradaDTO();

		entrada.setIdentificadorOficina("office1");
		entrada.setIdentificadorTurno("001");
		entrada.setConceptoTurno("C");
		entrada.setTipoAtencion(2);
		entrada.setPrioridadServicio(7);
		entrada.setPrioridadSegmento(2);

		cgtoR001.executeEncolar(entrada);
		List<Advice> advices = cgtoR001.getAdviceList();

		Assert.assertEquals(1, advices.size());

		cgtoR001.getAdviceList().clear();
		when(jedis.zadd(anyString(), anyDouble(), anyString())).thenReturn(0L);

		cgtoR001.executeEncolar(entrada);
		advices = cgtoR001.getAdviceList();
		Assert.assertEquals(1, advices.size());

		cgtoR001.getAdviceList().clear();
		when(jedis.zadd(anyString(), anyDouble(), anyString())).thenReturn(1L);

		cgtoR001.executeEncolar(entrada);
		advices = cgtoR001.getAdviceList();
		Assert.assertEquals(0, advices.size());
	}

	@Test
	public void executeJedisConect(){
		Jedis jedisConect = cgtoR001.getJedis();
		Assert.assertNotNull(jedisConect);
		jedisConect.close();
	}
}
