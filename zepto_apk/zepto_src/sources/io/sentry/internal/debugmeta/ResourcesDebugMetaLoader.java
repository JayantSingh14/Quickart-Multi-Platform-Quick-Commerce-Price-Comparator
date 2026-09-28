package io.sentry.internal.debugmeta;

import io.sentry.ILogger;
import io.sentry.SentryLevel;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class ResourcesDebugMetaLoader implements IDebugMetaLoader {

    /* renamed from: a, reason: collision with root package name */
    public final ILogger f52751a;

    /* renamed from: b, reason: collision with root package name */
    public final ClassLoader f52752b;

    public ResourcesDebugMetaLoader(ILogger iLogger) {
        ClassLoader classLoader = ResourcesDebugMetaLoader.class.getClassLoader();
        this.f52751a = iLogger;
        this.f52752b = classLoader == null ? ClassLoader.getSystemClassLoader() : classLoader;
    }

    @Override // io.sentry.internal.debugmeta.IDebugMetaLoader
    public final List a() throws IOException {
        InputStream inputStreamOpenStream;
        ILogger iLogger = this.f52751a;
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<URL> resources = this.f52752b.getResources("sentry-debug-meta.properties");
            while (resources.hasMoreElements()) {
                URL urlNextElement = resources.nextElement();
                try {
                    inputStreamOpenStream = urlNextElement.openStream();
                } catch (RuntimeException e2) {
                    iLogger.a(SentryLevel.ERROR, e2, "%s file is malformed.", urlNextElement);
                }
                try {
                    Properties properties = new Properties();
                    properties.load(inputStreamOpenStream);
                    arrayList.add(properties);
                    iLogger.c(SentryLevel.INFO, "Debug Meta Data Properties loaded from %s", urlNextElement);
                    if (inputStreamOpenStream != null) {
                        inputStreamOpenStream.close();
                    }
                } catch (Throwable th) {
                    if (inputStreamOpenStream != null) {
                        try {
                            inputStreamOpenStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e3) {
            iLogger.a(SentryLevel.ERROR, e3, "Failed to load %s", "sentry-debug-meta.properties");
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        iLogger.c(SentryLevel.INFO, "No %s file was found.", "sentry-debug-meta.properties");
        return null;
    }
}
