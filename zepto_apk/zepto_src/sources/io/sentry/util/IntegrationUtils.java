package io.sentry.util;

import io.sentry.SentryIntegrationPackageStorage;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class IntegrationUtils {
    public static void a(String str) {
        SentryIntegrationPackageStorage.c().a(str);
    }
}
