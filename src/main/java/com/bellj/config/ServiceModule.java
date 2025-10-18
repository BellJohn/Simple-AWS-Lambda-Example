package com.bellj.config;

import com.bellj.handler.Handler;
import com.bellj.model.Request;
import com.bellj.service.HelloWorldService;
import com.squareup.moshi.JsonAdapter;
import dagger.Module;
import dagger.Provides;

/**
 * ServiceModule is a Dagger @Module that provides custom bindings for objects
 * that require manual construction logic or cannot be injected via @Inject constructors.
 *
 * In this case, we use it to provide a Handler instance, which requires two dependencies:
 *   - JsonAdapter<Request>: used to deserialize incoming JSON
 *   - HelloWorldService: contains the business logic for generating greetings
 *
 * Although Handler could be made injectable via an @Inject constructor,
 * using a @Provides method here gives you more control over instantiation—
 * useful for future customization, conditional logic, or testing.
 */
@Module
public class ServiceModule {

    /**
     * This @Provides method tells Dagger how to construct a Handler.
     * Dagger will automatically resolve and inject the required parameters:
     *   - JsonAdapter<Request> is provided via MoshiConfig
     *   - HelloWorldService is injectable via its @Inject constructor
     *
     * This method is invoked when Dagger needs a Handler instance in your component.
     */
    @Provides
    public Handler handler(JsonAdapter<Request> requestJsonAdapter, HelloWorldService helloWorldService) {
        return new Handler(requestJsonAdapter, helloWorldService);
    }
}