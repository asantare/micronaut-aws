/*
 * Copyright 2017-2021 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.aws.xray.strategy;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.order.Ordered;

import java.util.Optional;

/**
 * Resolves how to name the X-Ray segment for a given HTTP Request.
 * @author Sergio del Amo
 * @since 3.2.0
 * @param <T> Request
 */
@FunctionalInterface
public interface SegmentNamingStrategy<T> extends Ordered {

    @NonNull
    Optional<String> resolveName(@NonNull T request);
}
