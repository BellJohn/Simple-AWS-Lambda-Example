package com.bellj.config;

import com.bellj.model.Request;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("jakarta.inject.Singleton")
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
public final class MoshiConfig_RequestJsonAdapterFactory implements Factory<JsonAdapter<Request>> {
  private final MoshiConfig module;

  private final Provider<Moshi> moshiProvider;

  private MoshiConfig_RequestJsonAdapterFactory(MoshiConfig module, Provider<Moshi> moshiProvider) {
    this.module = module;
    this.moshiProvider = moshiProvider;
  }

  @Override
  public JsonAdapter<Request> get() {
    return requestJsonAdapter(module, moshiProvider.get());
  }

  public static MoshiConfig_RequestJsonAdapterFactory create(MoshiConfig module,
      Provider<Moshi> moshiProvider) {
    return new MoshiConfig_RequestJsonAdapterFactory(module, moshiProvider);
  }

  public static JsonAdapter<Request> requestJsonAdapter(MoshiConfig instance, Moshi moshi) {
    return Preconditions.checkNotNullFromProvides(instance.requestJsonAdapter(moshi));
  }
}
