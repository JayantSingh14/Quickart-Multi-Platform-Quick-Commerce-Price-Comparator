package io.sentry.android.core.internal.debugmeta;

import android.content.Context;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.internal.debugmeta.IDebugMetaLoader;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class AssetsDebugMetaLoader implements IDebugMetaLoader {

    /* renamed from: a, reason: collision with root package name */
    public final Context f52260a;

    /* renamed from: b, reason: collision with root package name */
    public final ILogger f52261b;

    public AssetsDebugMetaLoader(Context context, ILogger iLogger) {
        Context applicationContext = context.getApplicationContext();
        this.f52260a = applicationContext != null ? applicationContext : context;
        this.f52261b = iLogger;
    }

    @Override // io.sentry.internal.debugmeta.IDebugMetaLoader
    public final List a() throws IOException {
        ILogger iLogger = this.f52261b;
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.f52260a.getAssets().open("sentry-debug-meta.properties"));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream);
                List listSingletonList = Collections.singletonList(properties);
                bufferedInputStream.close();
                return listSingletonList;
            } catch (Throwable th) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (FileNotFoundException e2) {
            iLogger.a(SentryLevel.INFO, e2, "%s file was not found.", "sentry-debug-meta.properties");
            return null;
        } catch (IOException e3) {
            iLogger.b(SentryLevel.ERROR, "Error getting Proguard UUIDs.", e3);
            return null;
        } catch (RuntimeException e4) {
            iLogger.a(SentryLevel.ERROR, e4, "%s file is malformed.", "sentry-debug-meta.properties");
            return null;
        }
    }
}
