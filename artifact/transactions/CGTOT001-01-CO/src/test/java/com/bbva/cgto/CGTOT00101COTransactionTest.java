package com.bbva.cgto;

import com.bbva.cgto.dto.response.EntradaDTO;
import com.bbva.cgto.lib.r001.CGTOR001;
import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.domain.transaction.Advice;
import com.bbva.elara.domain.transaction.request.header.CommonRequestHeader;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

public class CGTOT00101COTransactionTest {

	private Map<String, Object> parameters;

	private Map<Class<?>, Object> serviceLibraries;

	@Mock
	private ApplicationConfigurationService applicationConfigurationService;

	@Mock
	private CommonRequestHeader commonRequestHeader;

	@Mock
	private CGTOR001 cgtoR001;

	private final CGTOT00101COTransaction transaction = new CGTOT00101COTransaction() {
		@Override
		protected void addParameter(String field, Object obj) {
			if (parameters != null) {
				parameters.put(field, obj);
			}
		}

		@Override
		protected Object getParameter(String field) {
			return parameters.get(field);
		}

		@Override
		protected <T> T getServiceLibrary(Class<T> serviceInterface) {
			return (T) serviceLibraries.get(serviceInterface);
		}

		@Override
		public String getProperty(String keyProperty) {
			return applicationConfigurationService.getProperty(keyProperty);
		}

		@Override
		protected CommonRequestHeader getRequestHeader() {
		 	return commonRequestHeader;
		}
	};

	private void setParameterToTransaction(String parameter, Object value) {
		parameters.put(parameter, value);
	}

	@Test
	public void executeTest() {

		setParameterToTransaction("entrada", new EntradaDTO());

		transaction.execute();
		Assert.assertEquals(0, transaction.getAdviceList().size());

		transaction.getAdviceList().add(new Advice());
		transaction.execute();

		Assert.assertEquals(1, transaction.getAdviceList().size());
	}
}
