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
package io.micronaut.aws.xray.segmentlisteners;

import com.amazonaws.xray.slf4j.SLF4JSegmentListener;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Requires;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

/**
 * @author Sergio del Amo
 * @since 3.2.0
 */
@Requires(classes = SLF4JSegmentListener.class)
@Factory
public class SLF4JSegmentListenerFactory {

    /**
     *
     * @return A SLF4J Segement Listener
     */
    @Singleton
    @Named("slf4j")
    public SLF4JSegmentListener buildSegmentListener() {
        return new SLF4JSegmentListener();
    }
}
