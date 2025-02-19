/*
 * Copyright 2017-2023 original authors
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
package io.micronaut.aws.lambda.events.serde;

import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.lambda.runtime.events.models.s3.S3EventNotification;
import io.micronaut.serde.annotation.SerdeImport;

/**
 * {@link SerdeImport} for {@link S3Event}.
 *
 * @author Dan Hollingsworth
 * @since 4.0.0
 */
@SerdeImport(S3EventNotification.S3EventNotificationRecord.class)
@SerdeImport(S3EventNotification.class)
@SerdeImport(S3EventNotification.S3Entity.class)
@SerdeImport(S3Event.class)
public class S3EventSerde {

}
