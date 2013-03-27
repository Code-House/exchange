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
package org.code_house.exchange.api;

import javax.security.auth.Subject;

import org.code_house.exchange.api.message.Message;
import org.code_house.exchange.api.message.property.PropertiesHolder;

/**
 * Exchange represents and interaction between:
 * - endpoints
 * - receiver and endpoint
 * - endpoint and publisher
 * 
 * Exchange have only one message. There is no concept of IN and OUT messages. If exchange pattern is IN/OUT then latest message will be used
 * as reply sent to the client.
 */
public interface Exchange extends PropertiesHolder, Identifiable<String> {

    /**
     * Return message for this exchange.
     * 
     * @return Message.
     * @param <T> Type of message body.
     */
    <T> Message<T> getMessage();

    /**
     * Returns exception, if any, which caused exchange to fail.
     * 
     * @return Exchange exception.
     */
    Exception getException();

    /**
     * Returns authentication initiator of exchange.
     * 
     * @return Exchange subject, may be null.
     */
    Subject getSubject();

    /**
     * Specify message.
     * 
     * @param message
     */
    <T> void setMessage(Message<T> message);

}
