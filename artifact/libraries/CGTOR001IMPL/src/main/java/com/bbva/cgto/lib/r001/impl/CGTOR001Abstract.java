package com.bbva.cgto.lib.r001.impl;

import com.bbva.cgto.lib.r001.CGTOR001;
import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.library.AbstractLibrary;

/**
 * This class automatically defines the libraries and utilities that it will use.
 */
public abstract class CGTOR001Abstract extends AbstractLibrary implements CGTOR001 {

	protected ApplicationConfigurationService applicationConfigurationService;


	/**
	* @param applicationConfigurationService the this.applicationConfigurationService to set
	*/
	public void setApplicationConfigurationService(ApplicationConfigurationService applicationConfigurationService) {
		this.applicationConfigurationService = applicationConfigurationService;
	}

}