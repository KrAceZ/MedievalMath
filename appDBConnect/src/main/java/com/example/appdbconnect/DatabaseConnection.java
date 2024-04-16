package com.example.appdbconnect;

import java.sql.Connection;
import java.sql.DriverManager;

// Make sure to import the following packages in your code
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import java.lang.reflect.Field;

public class DatabaseConnection {
    String secretName = "rds!db-24c500b1-9646-4c12-abb8-d2a80d8b26c0";
    Region region = Region.of("us-east-2");

    // Set AWS credentials statically
    AwsBasicCredentials awsCredentials = AwsBasicCredentials.create(
            "AKIATCKAQLABELAO73G6",
            "adiv601aaPSpbtymnTdZD2iTDBU8fhYXvX7/Y0+3"
    );
    StaticCredentialsProvider credentialsProvider = StaticCredentialsProvider.create(awsCredentials);

    // Create a Secrets Manager client
    SecretsManagerClient client = SecretsManagerClient.builder()
            .region(region)
            .credentialsProvider(credentialsProvider)
            .build();

    GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
            .secretId(secretName)
            .build();

    GetSecretValueResponse getSecretValueResponse = client.getSecretValue(getSecretValueRequest);

    String secret = getSecretValueResponse.secretString();

    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "medivalmath";
        String databaseUserName = "admin";
        String databasePassword = secret; //Add the password of your choice here
        String url = "jdbc:mysql://medivalmath.c3eqia6i2cfi.us-east-2.rds.amazonaws.com/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUserName, databasePassword);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return databaseLink;
    }

    private static void setEnv(String key, String value) {
        try {
            // Get the env map field of the process environment class
            Class<?> processEnvironmentClass = Class.forName("java.lang.ProcessEnvironment");
            Field theEnvironmentField = processEnvironmentClass.getDeclaredField("theEnvironment");
            theEnvironmentField.setAccessible(true);

            // Get the environment map
            Object env = theEnvironmentField.get(null);
            // Cast it to a map
            Class<?> variableClass = env.getClass();
            Field mapField = variableClass.getDeclaredField("m");
            mapField.setAccessible(true);

            // Set the new environment variable value
            ((java.util.Map<String, String>) mapField.get(env)).put(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
