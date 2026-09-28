package io.sentry.config;

import io.sentry.SystemOutLogger;

/* loaded from: classes3.dex */
final class ClasspathPropertiesLoader implements PropertiesLoader {

    /* renamed from: a, reason: collision with root package name */
    public final String f52725a;

    /* renamed from: b, reason: collision with root package name */
    public final ClassLoader f52726b;

    /* renamed from: c, reason: collision with root package name */
    public final SystemOutLogger f52727c;

    public ClasspathPropertiesLoader(SystemOutLogger systemOutLogger) {
        ClassLoader classLoader = ClasspathPropertiesLoader.class.getClassLoader();
        this.f52725a = "sentry.properties";
        this.f52726b = classLoader == null ? ClassLoader.getSystemClassLoader() : classLoader;
        this.f52727c = systemOutLogger;
    }
}
