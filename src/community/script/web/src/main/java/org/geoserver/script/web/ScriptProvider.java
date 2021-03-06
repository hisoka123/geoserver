/* (c) 2014 Open Source Geospatial Foundation - all rights reserved
 * (c) 2001 - 2013 OpenPlans
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.script.web;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.model.IModel;
import org.geoserver.web.wicket.GeoServerDataProvider;

public class ScriptProvider extends GeoServerDataProvider<Script> {

    public static Property<Script> NAME = new BeanProperty<Script>("name", "name");

    public static Property<Script> TYPE = new BeanProperty<Script>("type", "type");

    public static Property<Script> EXTENSION = new BeanProperty<Script>("extension", "extension");

    public static Property<Script> FILE = new BeanProperty<Script>("file", "file");

    static List PROPERTIES = Arrays.asList(NAME, TYPE, EXTENSION, FILE);

    public ScriptProvider() {
        setSort(NAME.getName(), true);
    }

    @Override
    protected List<Script> getItems() {
        return new ScriptsModel().getScripts();
    }

    @Override
    protected List<Property<Script>> getProperties() {
        return PROPERTIES;
    }

    public IModel newModel(Object obj) {
        return new ScriptDetachableModel((Script) obj);
    }

}
