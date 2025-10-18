package com.bellj.service;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class GreetingFormatter_Factory implements Factory<GreetingFormatter> {
  @Override
  public GreetingFormatter get() {
    return newInstance();
  }

  public static GreetingFormatter_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static GreetingFormatter newInstance() {
    return new GreetingFormatter();
  }

  private static final class InstanceHolder {
    static final GreetingFormatter_Factory INSTANCE = new GreetingFormatter_Factory();
  }
}
