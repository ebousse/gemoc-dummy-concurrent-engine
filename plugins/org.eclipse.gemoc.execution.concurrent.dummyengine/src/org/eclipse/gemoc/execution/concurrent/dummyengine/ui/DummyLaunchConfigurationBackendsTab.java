/*******************************************************************************
 * Copyright (c) 2017 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     INRIA - initial API and implementation
 *     I3S Laboratory - API update and bug fix
 *******************************************************************************/
package org.eclipse.gemoc.execution.concurrent.dummyengine.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.gemoc.xdsmlframework.api.extensions.engine_addon.EngineAddonSpecificationExtension;
import org.eclipse.gemoc.xdsmlframework.api.extensions.engine_addon.EngineAddonSpecificationExtensionPoint;
import org.eclipse.gemoc.xdsmlframework.api.extensions.engine_addon_group.EngineAddonGroupSpecificationExtension;
import org.eclipse.gemoc.xdsmlframework.api.extensions.engine_addon_group.EngineAddonGroupSpecificationExtensionPoint;

public class DummyLaunchConfigurationBackendsTab extends DummyLaunchConfigurationDataProcessingTab 
{

	@Override
	public String getName() 
	{
		return "Engine Addons";
	}
	
	@Override
	protected Collection<EngineAddonSpecificationExtension> getExtensionSpecifications() 
	{
		ArrayList<EngineAddonSpecificationExtension> result = new ArrayList<EngineAddonSpecificationExtension>();		
		result.addAll(EngineAddonSpecificationExtensionPoint.getSpecifications());
		return result;
	}
	
	@Override
	protected Collection<EngineAddonGroupSpecificationExtension> getGroupExtensionSpecifications() 
	{
		HashMap<String,EngineAddonGroupSpecificationExtension> result = new HashMap<String,EngineAddonGroupSpecificationExtension>();
		// ensures to get only one group for a given id
		for (Iterator<EngineAddonGroupSpecificationExtension> iterator = EngineAddonGroupSpecificationExtensionPoint.getSpecifications().iterator(); iterator.hasNext();) {
			EngineAddonGroupSpecificationExtension engineAddonGroupSpecificationExtension =  iterator.next();
			result.put(engineAddonGroupSpecificationExtension.getId(), engineAddonGroupSpecificationExtension);
		}
		return result.values();
	}
		
}
