/*
 Copyright (c) 2006, 2007, The Cytoscape Consortium (www.cytoscape.org)

 The Cytoscape Consortium is:
 - Institute for Systems Biology
 - University of California San Diego
 - Memorial Sloan-Kettering Cancer Center
 - Institut Pasteur
 - Agilent Technologies

 This library is free software; you can redistribute it and/or modify it
 under the terms of the GNU Lesser General Public License as published
 by the Free Software Foundation; either version 2.1 of the License, or
 any later version.

 This library is distributed in the hope that it will be useful, but
 WITHOUT ANY WARRANTY, WITHOUT EVEN THE IMPLIED WARRANTY OF
 MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE.  The software and
 documentation provided hereunder is on an "as is" basis, and the
 Institute for Systems Biology and the Whitehead Institute
 have no obligations to provide maintenance, support,
 updates, enhancements or modifications.  In no event shall the
 Institute for Systems Biology and the Whitehead Institute
 be liable to any party for direct, indirect, special,
 incidental or consequential damages, including lost profits, arising
 out of the use of this software and its documentation, even if the
 Institute for Systems Biology and the Whitehead Institute
 have been advised of the possibility of such damage.  See
 the GNU Lesser General Public License for more details.

 You should have received a copy of the GNU Lesser General Public License
 along with this library; if not, write to the Free Software Foundation,
 Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.
 */
package org.cytoscape.view.vizmap.gui.editor;

import java.beans.PropertyEditor;

import javax.swing.Icon;
import javax.swing.table.TableCellRenderer;

/**
 * Facade of all editor-related objects for a Visual Property.
 * 
 * If plugin developer adds a custom visual property, they should implement this
 * in the presentation layer.
 * 
 * @param <T>
 *            Type of object managed in the Visual Prop.
 * 
 */
public interface VisualPropertyEditor<T> {

	Class<T> getType();

	/**
	 * Returns continuous mapping editor for the Visual Property. Return value
	 * is null is Continuous Editor does not exist.
	 * 
	 * @param parent
	 * @param type
	 */
	PropertyEditor getContinuousMappingEditor();

	/**
	 * Returns Property Editor object for this data type.
	 * 
	 * @return
	 */
	PropertyEditor getPropertyEditor();

	/**
	 * Display editor and get user input. Note: editor is associated with data
	 * type (String, Number, Color...), so we do not need to provide
	 * VisualProperty as parameter.
	 * 
	 * @param parent
	 *            parent component of this window
	 * @return
	 */
	T showVisualPropertyValueEditor();

	/**
	 * Provide Cell renderer for JTable or JList. Developers can implement
	 * custom cell renderers my using returned component.
	 * 
	 * @param type
	 * @param width
	 *            component width
	 * @param height
	 *            component height
	 * 
	 * @return
	 */
	TableCellRenderer getDiscreteTableCellRenderer();
	
	TableCellRenderer getContinuousTableCellRenderer();

	/**
	 * This is for default view editor.
	 * 
	 * @param vp
	 *            DOCUMENT ME!
	 * @param width
	 *            DOCUMENT ME!
	 * @param height
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	Icon getDefaultIcon(int width, int height);
}