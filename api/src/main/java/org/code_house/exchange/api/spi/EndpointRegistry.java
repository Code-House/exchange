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
package org.code_house.exchange.api.spi;

import java.util.Enumeration;
import java.util.Map;

import org.code_house.exchange.api.endpoint.Endpoint;
import org.code_house.exchange.api.exception.EndpointNotFoundException;
import org.code_house.exchange.api.exception.RegistrationFailedException;

/**
 * Endpoint registry.
 */
public interface EndpointRegistry {

    <T> Enumeration<Endpoint<T>> findEndpoints(String endpointName, Map<?, ?> properties);

    <T> Endpoint<T> getEndpoint(String endpointId, Map<?, ?> properties) throws EndpointNotFoundException;

    <T> void registerEndpoint(Endpoint<T> endpoint, Map<?, ?> properties) throws RegistrationFailedException;

}
