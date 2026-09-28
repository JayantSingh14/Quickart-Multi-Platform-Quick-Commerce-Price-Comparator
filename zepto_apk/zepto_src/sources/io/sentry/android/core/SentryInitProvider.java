package io.sentry.android.core;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Bundle;
import io.sentry.Sentry;
import io.sentry.SentryIntegrationPackageStorage;
import io.sentry.SentryLevel;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class SentryInitProvider extends EmptySecureContentProvider {
    @Override // android.content.ContentProvider
    public final void attachInfo(Context context, ProviderInfo providerInfo) {
        if (SentryInitProvider.class.getName().equals(providerInfo.authority)) {
            throw new IllegalStateException("An applicationId is required to fulfill the manifest placeholder.");
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Bundle bundleA;
        AndroidLogger androidLogger = new AndroidLogger();
        Context context = getContext();
        if (context == null) {
            androidLogger.c(SentryLevel.FATAL, "App. Context from ContentProvider is null", new Object[0]);
            return false;
        }
        try {
            bundleA = ManifestMetadataReader.a(context, androidLogger, null);
        } catch (Throwable th) {
            androidLogger.b(SentryLevel.ERROR, "Failed to read auto-init from android manifest metadata.", th);
        }
        boolean zB = bundleA != null ? ManifestMetadataReader.b(bundleA, androidLogger, "io.sentry.auto-init", true) : true;
        if (zB) {
            SentryAndroid.b(context, androidLogger, new com.google.common.net.a(7));
            SentryIntegrationPackageStorage.c().a("AutoInit");
        }
        return true;
    }

    @Override // android.content.ContentProvider
    public final void shutdown() {
        Sentry.b();
    }
}
