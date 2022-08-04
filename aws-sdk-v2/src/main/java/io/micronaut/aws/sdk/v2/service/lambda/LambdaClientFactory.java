package io.micronaut.aws.sdk.v2.service.lambda;

import io.micronaut.aws.sdk.v2.service.AwsClientFactory;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Requires;
import jakarta.inject.Singleton;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProviderChain;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.async.SdkAsyncHttpClient;
import software.amazon.awssdk.regions.providers.AwsRegionProviderChain;
import software.amazon.awssdk.services.lambda.*;

/**
 * Factory that creates a Lambda client.
 *
 * @since 4.0.0
 */
@Factory
public class LambdaClientFactory extends AwsClientFactory<LambdaClientBuilder, LambdaAsyncClientBuilder, LambdaClient, LambdaAsyncClient> {

    private final LambdaConfigurationProperties configuration;

    /**
     * Constructor.
     *
     * @param credentialsProvider The credentials provider
     * @param regionProvider      The region provider
     * @param configuration       Additional configuration
     */
    protected LambdaClientFactory(AwsCredentialsProviderChain credentialsProvider, AwsRegionProviderChain regionProvider,
                                  LambdaConfigurationProperties configuration) {
        super(credentialsProvider, regionProvider);
        this.configuration = configuration;
    }

    @Override
    protected LambdaClientBuilder createSyncBuilder() {
        return configureBuilder(LambdaClient.builder());
    }

    @Override
    protected LambdaAsyncClientBuilder createAsyncBuilder() {
        return configureBuilder(LambdaAsyncClient.builder());
    }

    private <T extends LambdaBaseClientBuilder<?, ?>> T configureBuilder(T builder) {
        if (configuration.getEndpointOverride() != null) {
            builder.endpointOverride(configuration.getEndpointOverride());
        }
        if (!configuration.getMetricsPublishers().isEmpty()) {
            ClientOverrideConfiguration.Builder overrideCfgBuilder = ClientOverrideConfiguration.builder();
            overrideCfgBuilder.metricPublishers(configuration.getMetricsPublishers());
            builder.overrideConfiguration(overrideCfgBuilder.build());
        }
        return builder;
    }

    @Override
    @Singleton
    public LambdaClientBuilder syncBuilder(SdkHttpClient httpClient) {
        return super.syncBuilder(httpClient);
    }

    @Override
    @Bean(preDestroy = "close")
    @Singleton
    public LambdaClient syncClient(LambdaClientBuilder builder) {
        return super.syncClient(builder);
    }

    @Override
    @Singleton
    @Requires(beans = SdkAsyncHttpClient.class)
    public LambdaAsyncClientBuilder asyncBuilder(SdkAsyncHttpClient httpClient) {
        return super.asyncBuilder(httpClient);
    }

    @Override
    @Bean(preDestroy = "close")
    @Singleton
    @Requires(beans = SdkAsyncHttpClient.class)
    public LambdaAsyncClient asyncClient(LambdaAsyncClientBuilder builder) {
        return super.asyncClient(builder);
    }

}
