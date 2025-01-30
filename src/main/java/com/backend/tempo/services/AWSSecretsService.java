package com.backend.tempo.services;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

public class AWSSecretsService {
    public static String getSecret(String secretName) {
        try (SecretsManagerClient client = SecretsManagerClient.builder()
                .region(Region.of("us-east-1"))
                .build()) {

            GetSecretValueRequest request = GetSecretValueRequest.builder()
                    .secretId(secretName)
                    .build();

            GetSecretValueResponse response = client.getSecretValue(request);
            return response.secretString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch secret: " + secretName, e);
        }
    }
}
