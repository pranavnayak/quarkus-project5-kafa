package org.popins.dev;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@Liveness
public class MyLivenessCheck implements HealthCheck {


    public HealthCheckResponse call() {
        return HealthCheckResponse.up("alive");
    }

}