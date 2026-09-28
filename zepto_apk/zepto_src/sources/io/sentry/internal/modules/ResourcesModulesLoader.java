package io.sentry.internal.modules;

import io.sentry.ILogger;
import io.sentry.SentryLevel;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class ResourcesModulesLoader extends ModulesLoader {

    /* renamed from: d, reason: collision with root package name */
    public final ClassLoader f52767d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResourcesModulesLoader(ILogger iLogger) {
        super(iLogger);
        ClassLoader classLoader = ResourcesModulesLoader.class.getClassLoader();
        this.f52767d = classLoader == null ? ClassLoader.getSystemClassLoader() : classLoader;
    }

    @Override // io.sentry.internal.modules.ModulesLoader
    public final Map b() throws IOException {
        InputStream resourceAsStream;
        ILogger iLogger = this.f52764a;
        TreeMap treeMap = new TreeMap();
        try {
            resourceAsStream = this.f52767d.getResourceAsStream("sentry-external-modules.txt");
            try {
            } catch (Throwable th) {
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e2) {
            iLogger.b(SentryLevel.INFO, "Access to resources failed.", e2);
        } catch (SecurityException e3) {
            iLogger.b(SentryLevel.INFO, "Access to resources denied.", e3);
        }
        if (resourceAsStream != null) {
            TreeMap treeMapC = c(resourceAsStream);
            resourceAsStream.close();
            return treeMapC;
        }
        iLogger.c(SentryLevel.INFO, "%s file was not found.", "sentry-external-modules.txt");
        if (resourceAsStream != null) {
            resourceAsStream.close();
            return treeMap;
        }
        return treeMap;
    }
}
