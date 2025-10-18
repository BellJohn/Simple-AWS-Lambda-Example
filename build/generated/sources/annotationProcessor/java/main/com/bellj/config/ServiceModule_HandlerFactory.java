package com.bellj.config;

import com.bellj.handler.Handler;
import com.bellj.model.Request;
import com.bellj.service.HelloWorldService;
import com.squareup.moshi.JsonAdapter;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class ServiceModule_HandlerFactory implements Factory<Handler> {
  private final ServiceModule module;

  private final Provider<JsonAdapter<Request>> requestJsonAdapterProvider;

  private final Provider<HelloWorldService> helloWorldServiceProvider;

  private ServiceModule_HandlerFactory(ServiceModule module,
      Provider<JsonAdapter<Request>> requestJsonAdapterProvider,
      Provider<HelloWorldService> helloWorldServiceProvider) {
    this.module = module;
    this.requestJsonAdapterProvider = requestJsonAdapterProvider;
    this.helloWorldServiceProvider = helloWorldServiceProvider;
  }

  @Override
  public Handler get() {
    return handler(module, requestJsonAdapterProvider.get(), helloWorldServiceProvider.get());
  }

  public static ServiceModule_HandlerFactory create(ServiceModule module,
      Provider<JsonAdapter<Request>> requestJsonAdapterProvider,
      Provider<HelloWorldService> helloWorldServiceProvider) {
    return new ServiceModule_HandlerFactory(module, requestJsonAdapterProvider, helloWorldServiceProvider);
  }

  public static Handler handler(ServiceModule instance, JsonAdapter<Request> requestJsonAdapter,
      HelloWorldService helloWorldService) {
    return Preconditions.checkNotNullFromProvides(instance.handler(requestJsonAdapter, helloWorldService));
  }
}
