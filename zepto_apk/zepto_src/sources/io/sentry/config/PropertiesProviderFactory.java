package io.sentry.config;

import io.sentry.SentryLevel;
import io.sentry.SystemOutLogger;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class PropertiesProviderFactory {
    public static PropertiesProvider a() throws IOException {
        Properties propertiesA;
        Properties propertiesA2;
        SystemOutLogger systemOutLogger = new SystemOutLogger();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SystemPropertyPropertiesProvider());
        arrayList.add(new EnvironmentVariablePropertiesProvider());
        String property = System.getProperty("sentry.properties.file");
        if (property != null && (propertiesA2 = new FilesystemPropertiesLoader(property, systemOutLogger).a()) != null) {
            arrayList.add(new SimplePropertiesProvider(propertiesA2));
        }
        String str = System.getenv("SENTRY_PROPERTIES_FILE");
        if (str != null && (propertiesA = new FilesystemPropertiesLoader(str, systemOutLogger).a()) != null) {
            arrayList.add(new SimplePropertiesProvider(propertiesA));
        }
        ClasspathPropertiesLoader classpathPropertiesLoader = new ClasspathPropertiesLoader(systemOutLogger);
        String str2 = classpathPropertiesLoader.f52725a;
        Properties properties = null;
        try {
            InputStream resourceAsStream = classpathPropertiesLoader.f52726b.getResourceAsStream(str2);
            if (resourceAsStream != null) {
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(resourceAsStream);
                    try {
                        Properties properties2 = new Properties();
                        properties2.load(bufferedInputStream);
                        bufferedInputStream.close();
                        resourceAsStream.close();
                        properties = properties2;
                    } finally {
                    }
                } finally {
                }
            } else if (resourceAsStream != null) {
                resourceAsStream.close();
            }
        } catch (IOException e2) {
            classpathPropertiesLoader.f52727c.a(SentryLevel.ERROR, e2, "Failed to load Sentry configuration from classpath resource: %s", str2);
        }
        if (properties != null) {
            arrayList.add(new SimplePropertiesProvider(properties));
        }
        Properties propertiesA3 = new FilesystemPropertiesLoader("sentry.properties", systemOutLogger).a();
        if (propertiesA3 != null) {
            arrayList.add(new SimplePropertiesProvider(propertiesA3));
        }
        return new CompositePropertiesProvider(arrayList);
    }
}
