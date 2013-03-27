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

/**
 * Enumeration representing possible ways of communication.
 * 
 * TODO Verify if it's properly ported, ie IN/OUT/FAULT are mapped properly.
 */
public enum ExchangePattern {

    InOnly (true, false, false, "http://www.w3.org/ns/wsdl/in-only"),
    InOptionalOut ("http://www.w3.org/ns/wsdl/in-optional-out"),
    InOut ("http://www.w3.org/ns/wsdl/in-out"),
    OutIn ("http://www.w3.org/ns/wsdl/out-in"),
    OutOnly (false, true, false, "http://www.w3.org/ns/wsdl/out-only"),
    OutOptionalIn ("http://www.w3.org/ns/wsdl/out-optional_in"),
    RobustInOnly (true, false, "http://www.w3.org/ns/wsdl/robust-in-only"),
    RobustOutOnly (false, "http://www.w3.org/ns/wsdl/robust-out-only");

    private final boolean hasIn;
    private final boolean hasOut;
    private final boolean hasFault;
    private final String wsdlSpecUri;

    private ExchangePattern(String wsdlSpecUri) {
        this(true, wsdlSpecUri);
    }

    private ExchangePattern(boolean hasIn, String wsdlSpecUri) {
        this(hasIn, true, wsdlSpecUri);
    }

    private ExchangePattern(boolean hasIn, boolean hasOut, String wsdlSpecUri) {
        this(hasIn, hasOut, true, wsdlSpecUri);
    }

    private ExchangePattern(boolean hasIn, boolean hasOut, boolean hasFault, String wsdlSpecUri) {
        this.hasIn = hasIn;
        this.hasOut = hasOut;
        this.hasFault = hasFault;
        this.wsdlSpecUri = wsdlSpecUri;
    }

    public boolean hasIn() {
        return hasIn;
    }

    public boolean hasOut() {
        return hasOut;
    }

    public boolean hasFault() {
        return hasFault;
    }

    public String getWsdlSpecUri() {
        return wsdlSpecUri;
    }

}
