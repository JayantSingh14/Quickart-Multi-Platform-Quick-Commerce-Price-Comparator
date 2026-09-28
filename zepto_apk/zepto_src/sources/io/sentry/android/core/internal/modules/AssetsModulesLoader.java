package io.sentry.android.core.internal.modules;

import android.content.Context;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.internal.modules.ModulesLoader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class AssetsModulesLoader extends ModulesLoader {

    /* renamed from: d, reason: collision with root package name */
    public final Context f52282d;

    public AssetsModulesLoader(Context context, ILogger iLogger) {
        super(iLogger);
        Context applicationContext = context.getApplicationContext();
        this.f52282d = applicationContext != null ? applicationContext : context;
    }

    @Override // io.sentry.internal.modules.ModulesLoader
    public final Map b() throws IOException {
        ILogger iLogger = this.f52764a;
        TreeMap treeMap = new TreeMap();
        try {
            InputStream inputStreamOpen = this.f52282d.getAssets().open("sentry-external-modules.txt");
            try {
                TreeMap treeMapC = c(inputStreamOpen);
                if (inputStreamOpen == null) {
                    return treeMapC;
                }
                inputStreamOpen.close();
                return treeMapC;
            } catch (Throwable th) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused) {
            iLogger.c(SentryLevel.INFO, "%s file was not found.", "sentry-external-modules.txt");
            return treeMap;
        } catch (IOException e2) {
            iLogger.b(SentryLevel.ERROR, "Error extracting modules.", e2);
            return treeMap;
        }
    }
}
