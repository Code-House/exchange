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
package org.code_house.exchange.api.message;

import org.code_house.exchange.api.Identifiable;
import org.code_house.exchange.api.exception.ConversionFailedException;
import org.code_house.exchange.api.message.frame.Frames;
import org.code_house.exchange.api.message.property.PropertiesHolder;

/**
 * Message holds all frames from underlying protocol and offers an API to work on top of it.
 *
 * @param <T> Type of payload.
 */
public interface Message<T> extends Frames<T>, PropertiesHolder, Identifiable<String> {

    /**
     * Returns, but not removes, body of latest frame.
     * 
     * @param type Expected type of body.
     * @throws ConversionFailedException
     */
    <F> F peek(Class<F> type) throws ConversionFailedException;

    /**
     * Returns, but not removes, body of latest frame.
     * 
     * @return Body of frame.
     */
    T peek();

    /**
     * Returns body of latest frame and removes it from stack.
     *
     * @param type Expected type of body.
     * @return Converted body of frame.
     * @throws ConversionFailedException
     */
    <F> F poll(Class<F> type) throws ConversionFailedException;

    /**
     * Returns body of latest frame and removes it from stack.
     * 
     * @return
     */
    T poll();

    void offer(T body);

}
