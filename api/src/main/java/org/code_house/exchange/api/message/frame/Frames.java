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
package org.code_house.exchange.api.message.frame;

/**
 * Frames is an ordered set, where first frame is result of extraction from second.
 */
public interface Frames<T> {

    /**
     * Returns all frames where latest frame is first.
     * 
     * In this way when you receive HTTP frame the first frame will be HTTP, second will be TCP, third would be IP frame.
     * 
     * @return Frame in reverse order.
     */
    Iterable<Frame<T>> getFrames();

}
