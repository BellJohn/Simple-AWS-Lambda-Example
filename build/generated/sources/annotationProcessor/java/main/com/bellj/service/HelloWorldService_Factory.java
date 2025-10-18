package com.bellj.service;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class HelloWorldService_Factory implements Factory<HelloWorldService> {
  private final Provider<GreetingFormatter> formatterProvider;

  private HelloWorldService_Factory(Provider<GreetingFormatter> formatterProvider) {
    this.formatterProvider = formatterProvider;
  }

  @Override
  public HelloWorldService get() {
    return newInstance(formatterProvider.get());
  }

  public static HelloWorldService_Factory create(Provider<GreetingFormatter> formatterProvider) {
    return new HelloWorldService_Factory(formatterProvider);
  }

  public static HelloWorldService newInstance(GreetingFormatter formatter) {
    return new HelloWorldService(formatter);
  }
}
