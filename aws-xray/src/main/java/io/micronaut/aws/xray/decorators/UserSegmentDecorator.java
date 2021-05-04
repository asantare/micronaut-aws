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
package io.micronaut.aws.xray.decorators;

import com.amazonaws.xray.entities.Segment;
import io.micronaut.aws.xray.configuration.XRayConfigurationProperties;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.util.StringUtils;
import io.micronaut.http.HttpRequest;

import javax.inject.Singleton;
import java.security.Principal;

/**
 * Sets {@link Segment#setUser(String)} with the principal.
 * @author Sergio del Amo
 * @since 2.7.0
 */
@Requires(property = XRayConfigurationProperties.PREFIX + ".user-segment-decorator", notEquals = StringUtils.FALSE,  defaultValue = StringUtils.TRUE)
@Singleton
public class UserSegmentDecorator implements SegmentDecorator {

    @Override
    public void decorate(@NonNull Segment segment, @NonNull HttpRequest<?> request) {
        request.getUserPrincipal().map(Principal::getName).ifPresent(segment::setUser);
    }
}
