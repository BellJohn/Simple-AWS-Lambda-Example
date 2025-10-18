package com.bellj.config;

import com.squareup.moshi.Moshi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class MoshiConfig_MoshiFactory implements Factory<Moshi> {
  private final MoshiConfig module;

  private MoshiConfig_MoshiFactory(MoshiConfig module) {
    this.module = module;
  }

  @Override
  public Moshi get() {
    return moshi(module);
  }

  public static MoshiConfig_MoshiFactory create(MoshiConfig module) {
    return new MoshiConfig_MoshiFactory(module);
  }

  public static Moshi moshi(MoshiConfig instance) {
    return Preconditions.checkNotNullFromProvides(instance.moshi());
  }
}
