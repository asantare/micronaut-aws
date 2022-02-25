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

import io.micronaut.aws.xray.configuration.XRayConfiguration;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;
import java.util.Optional;

/**
 * If the property tracing.xray.fixed-name is set its value is used as the segment name.
 * @since 3.2.0
 * @author Sergio del Amo
 * @param <T> Request
 */
@Singleton
public class FixedSegmentNamingStrategy<T> implements SegmentNamingStrategy<T> {
    public static final int ORDER = SystemPropertySegmentNamingStrategy.ORDER + 100;
    private final String fixedName;

    /**
     *
     * @param xRayConfiguration X-Ray Configuration
     */
    public FixedSegmentNamingStrategy(XRayConfiguration xRayConfiguration) {
        this.fixedName = xRayConfiguration.getFixedName().orElse(null);
    }

    @Override
    public int getOrder() {
        return ORDER;
    }

    @Override
    @NonNull
    public Optional<String> resolveName(@NonNull T request) {
        return Optional.ofNullable(fixedName);
    }
}
