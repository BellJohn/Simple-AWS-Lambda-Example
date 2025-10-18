package com.bellj.config;

import com.bellj.handler.Handler;
import com.bellj.service.HelloWorldService;
import dagger.Component;
import jakarta.inject.Singleton;

/**
 * Config is the Dagger @Component interface that defines the root of your dependency graph.
 * It tells Dagger:
 *   - Which modules to use for providing dependencies
 *   - Which classes you want to expose for injection (entrypoints or externally accessible services)
 *
 * Dagger will generate a class named DaggerConfig at compile time,
 * which you can use to instantiate the graph via DaggerConfig.create().
 */
@Singleton
@Component(modules = {MoshiConfig.class, ServiceModule.class})
public interface Config {

    /**
     * Exposes HelloWorldService as an injectable dependency.
     * This allows you to retrieve it directly from the graph if needed—
     * for example, in tests or alternate entrypoints.
     */
    HelloWorldService helloWorldService();

    /**
     * Exposes Handler as the main orchestrator for Lambda logic.
     * This is the object returned by DaggerConfig.create().handler(),
     * and used by LambdaEntryPoint to process incoming requests.
     */
    Handler handler();
}