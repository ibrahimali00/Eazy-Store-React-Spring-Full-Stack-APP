package com.eazybytes.eazybytes.constansts;

public class ApplicationConstant {

    public static final String JWT_SECRET_KEY = "JWT_SECRET";
    public static final String JWT_SECRET_DEFAULT_VALUE = "V8mQ2xR7kL9pN4wT6yH1aF3dJ8sB5cZ0uE7iG2oK9rX4mP6v";
    public static final String JWT_HEADER = "Authorization";

    private ApplicationConstant() {
        throw new AssertionError("Utility class cannot be instantiated.");
    }

}
