package com.bellj.config;

import com.bellj.handler.Handler;
import com.bellj.model.Request;
import com.bellj.service.GreetingFormatter;
import com.bellj.service.HelloWorldService;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import javax.annotation.processing.Generated;

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
public final class DaggerConfig {
  private DaggerConfig() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Config create() {
    return new Builder().build();
  }

  public static final class Builder {
    private MoshiConfig moshiConfig;

    private ServiceModule serviceModule;

    private Builder() {
    }

    public Builder moshiConfig(MoshiConfig moshiConfig) {
      this.moshiConfig = Preconditions.checkNotNull(moshiConfig);
      return this;
    }

    public Builder serviceModule(ServiceModule serviceModule) {
      this.serviceModule = Preconditions.checkNotNull(serviceModule);
      return this;
    }

    public Config build() {
      if (moshiConfig == null) {
        this.moshiConfig = new MoshiConfig();
      }
      if (serviceModule == null) {
        this.serviceModule = new ServiceModule();
      }
      return new ConfigImpl(moshiConfig, serviceModule);
    }
  }

  private static final class ConfigImpl implements Config {
    private final ServiceModule serviceModule;

    private final ConfigImpl configImpl = this;

    Provider<Moshi> moshiProvider;

    Provider<JsonAdapter<Request>> requestJsonAdapterProvider;

    ConfigImpl(MoshiConfig moshiConfigParam, ServiceModule serviceModuleParam) {
      this.serviceModule = serviceModuleParam;
      initialize(moshiConfigParam, serviceModuleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final MoshiConfig moshiConfigParam,
        final ServiceModule serviceModuleParam) {
      this.moshiProvider = DoubleCheck.provider(MoshiConfig_MoshiFactory.create(moshiConfigParam));
      this.requestJsonAdapterProvider = DoubleCheck.provider(MoshiConfig_RequestJsonAdapterFactory.create(moshiConfigParam, moshiProvider));
    }

    @Override
    public HelloWorldService helloWorldService() {
      return new HelloWorldService(new GreetingFormatter());
    }

    @Override
    public Handler handler() {
      return ServiceModule_HandlerFactory.handler(serviceModule, requestJsonAdapterProvider.get(), helloWorldService());
    }
  }
}
