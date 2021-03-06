/*
 * Copyright 2016 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.linecorp.armeria.server.logging.structured;

import javax.annotation.Nullable;

import com.linecorp.armeria.common.RequestContext;
import com.linecorp.armeria.common.logging.ResponseLog;

/**
 * An interface that a structured log constructor should implement.
 *
 * @param <L> type of the structured log representation
 */
@FunctionalInterface
public interface StructuredLogBuilder<L> {
    /**
     * Builds a structured log instance based on given {@link RequestContext} and {@link ResponseLog}.
     *
     * @param reqCtx an instance of {@link RequestContext} which holds context information of the request
     * @param resLog an instance of {@link ResponseLog} which holds response and request information
     *
     * @return an instance of {@link L} which represents an entry of structured logs or null if a builder thinks
     *         the given information isn't eligible to issue a structured log entry
     */
    @Nullable
    L build(RequestContext reqCtx, ResponseLog resLog);
}
