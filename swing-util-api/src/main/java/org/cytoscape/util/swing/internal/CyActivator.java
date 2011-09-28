



package org.cytoscape.util.swing.internal;

import org.cytoscape.property.CyProperty;
import org.cytoscape.util.swing.internal.FileUtilImpl;
import org.cytoscape.util.swing.internal.OpenBrowserImpl;
import org.cytoscape.util.swing.FileUtil;
import org.cytoscape.util.swing.OpenBrowser;
import org.osgi.framework.BundleContext;
import org.cytoscape.service.util.AbstractCyActivator;
import java.util.Properties;


public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {
		CyProperty cytoscapePropertiesServiceRef = getService(bc,CyProperty.class,"(cyPropertyName=cytoscape3.props)");
		
		FileUtilImpl fileUtil = new FileUtilImpl(cytoscapePropertiesServiceRef);
		OpenBrowserImpl openBrowser = new OpenBrowserImpl(cytoscapePropertiesServiceRef);
		
		registerService(bc,fileUtil,FileUtil.class, new Properties());
		registerService(bc,openBrowser,OpenBrowser.class, new Properties());
	}
}
