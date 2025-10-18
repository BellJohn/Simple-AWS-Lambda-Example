package com.bellj.config;

import com.bellj.model.Request;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import dagger.Module;
import dagger.Provides;
import jakarta.inject.Singleton;

/**
 * MoshiConfig is a Dagger @Module that provides Moshi-related dependencies.
 * Moshi is a lightweight, modern JSON library for Java, ideal for serverless environments
 * due to its small footprint and compile-time safety.
 *
 * This module defines how to construct:
 *   - A singleton Moshi instance
 *   - A JsonAdapter<Request> for deserializing incoming Lambda payloads
 *
 * These @Provides methods allow Dagger to inject Moshi and its adapters wherever needed,
 * such as in your Handler class.
 */
@Module
public class MoshiConfig {

    /**
     * Provides a singleton Moshi instance.
     * This is the core JSON engine used to create adapters for your data models.
     * Singleton scope ensures it's reused across invocations within the same Lambda container.
     */
    @Provides
    @Singleton
    public Moshi moshi() {
        return new Moshi.Builder().build();
    }

    /**
     * Provides a JsonAdapter for the Request record.
     * This adapter is used to convert raw JSON strings into strongly typed Request objects.
     * Dagger will inject this wherever it's required—such as in your Handler constructor.
     */
    @Provides
    @Singleton
    public JsonAdapter<Request> requestJsonAdapter(Moshi moshi) {
        return moshi.adapter(Request.class);
    }
}