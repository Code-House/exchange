/*
 * Copyright (C) 2013 Code-House, Lukasz Dywicki.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.code_house.exchange.api.message.property;

import java.util.Set;

import org.code_house.exchange.api.exception.ConversionFailedException;
import org.code_house.exchange.api.exception.MissingPropertyException;

/**
 * Element which have properties attached.
 */
public interface PropertiesHolder {

    /**
     * Return all properties.
     * 
     * @return Available properties.
     */
    <T, X> Set<Property<T, X>> getProperties();

    /**
     * Returns property names.
     * 
     * @return Property names.
     */
    Set<String> getPropertyNames();

    /**
     * Checks if property is available.
     * 
     * @param name Property name.
     * @param labels Property labels.
     * @return True if property is accessible.
     */
    boolean hasProperty(String name, String ... labels);

    /**
     * Checks if property is available.
     * 
     * @param selector Property selector.
     * @return True if property is present and may be selected by selector.
     */
    <T> boolean hasProperty(PropertySelector<T> selector);

    /**
     * Get property by name.
     * 
     * @param name Property name.
     * @param labels Property labels.
     * @return Property value.
     * @throws MissingPropertyException when property with given name is not found.
     */
    Object getProperty(String name, String labels) throws MissingPropertyException;

    /**
     * Get property by name and cast it to given type.
     * 
     * @param name Property name.
     * @param type Expected property type.
     * @param labels Property labels.
     * @return Property value.
     * @throws MissingPropertyException when property with given name is not found.
     * @throws ConversionFailedException when property is found but conversion to given type fails.
     * @param <T> Type of property.
     */
    <T> T getProperty(String name, Class<T> type, String ... labels) throws MissingPropertyException, ConversionFailedException;

    /**
     * Specify property with given name and properties.
     * 
     * @param name Name of the property.
     * @param value Value of property.
     * @param labels Property labels (if any)
     */
    void setProperty(String name, Object value, String ... labels);

    /**
     * Choose property with given strategy.
     * 
     * @param selector Property selector.
     * @return Property value.
     */
    <T> T getProperty(PropertySelector<T> selector);

}
