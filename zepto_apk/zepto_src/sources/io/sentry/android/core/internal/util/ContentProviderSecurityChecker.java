package io.sentry.android.core.internal.util;

import android.content.ContentProvider;
import android.os.Build;
import io.sentry.NoOpLogger;
import io.sentry.android.core.BuildInfoProvider;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class ContentProviderSecurityChecker {

    /* renamed from: a, reason: collision with root package name */
    public final BuildInfoProvider f52308a = new BuildInfoProvider(NoOpLogger.f51707a);

    public final void a(ContentProvider contentProvider) {
        this.f52308a.getClass();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26 || i2 > 28) {
            return;
        }
        String callingPackage = contentProvider.getCallingPackage();
        String packageName = contentProvider.getContext().getPackageName();
        if (callingPackage == null || !callingPackage.equals(packageName)) {
            throw new SecurityException("Provider does not allow for granting of Uri permissions");
        }
    }
}
