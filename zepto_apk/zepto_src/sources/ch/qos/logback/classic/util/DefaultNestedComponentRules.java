package ch.qos.logback.classic.util;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.boolex.JaninoEventEvaluator;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import ch.qos.logback.core.filter.EvaluatorFilter;
import ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
import ch.qos.logback.core.net.ssl.KeyManagerFactoryFactoryBean;
import ch.qos.logback.core.net.ssl.KeyStoreFactoryBean;
import ch.qos.logback.core.net.ssl.SSLComponent;
import ch.qos.logback.core.net.ssl.SSLConfiguration;
import ch.qos.logback.core.net.ssl.SSLParametersConfiguration;
import ch.qos.logback.core.net.ssl.SecureRandomFactoryBean;
import ch.qos.logback.core.net.ssl.TrustManagerFactoryFactoryBean;

/* loaded from: classes3.dex */
public class DefaultNestedComponentRules {
    public static void a(DefaultNestedComponentRegistry defaultNestedComponentRegistry) {
        defaultNestedComponentRegistry.a(AppenderBase.class, "layout", PatternLayout.class);
        defaultNestedComponentRegistry.a(UnsynchronizedAppenderBase.class, "layout", PatternLayout.class);
        defaultNestedComponentRegistry.a(AppenderBase.class, "encoder", PatternLayoutEncoder.class);
        defaultNestedComponentRegistry.a(UnsynchronizedAppenderBase.class, "encoder", PatternLayoutEncoder.class);
        defaultNestedComponentRegistry.a(EvaluatorFilter.class, "evaluator", JaninoEventEvaluator.class);
        defaultNestedComponentRegistry.a(SSLComponent.class, "ssl", SSLConfiguration.class);
        defaultNestedComponentRegistry.a(SSLConfiguration.class, "parameters", SSLParametersConfiguration.class);
        defaultNestedComponentRegistry.a(SSLConfiguration.class, "keyStore", KeyStoreFactoryBean.class);
        defaultNestedComponentRegistry.a(SSLConfiguration.class, "trustStore", KeyStoreFactoryBean.class);
        defaultNestedComponentRegistry.a(SSLConfiguration.class, "keyManagerFactory", KeyManagerFactoryFactoryBean.class);
        defaultNestedComponentRegistry.a(SSLConfiguration.class, "trustManagerFactory", TrustManagerFactoryFactoryBean.class);
        defaultNestedComponentRegistry.a(SSLConfiguration.class, "secureRandom", SecureRandomFactoryBean.class);
    }
}
