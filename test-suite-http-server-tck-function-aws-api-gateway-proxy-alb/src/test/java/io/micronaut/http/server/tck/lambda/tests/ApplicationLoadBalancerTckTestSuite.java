package io.micronaut.http.server.tck.lambda.tests;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SelectPackages({
    "io.micronaut.http.server.tck.tests",
    "io.micronaut.http.server.tck.lambda.tests"
})
@SuiteDisplayName("HTTP Server TCK for Function AWS API Gateway Proxy Application Load Balancer Event")
public class ApplicationLoadBalancerTckTestSuite {
}
