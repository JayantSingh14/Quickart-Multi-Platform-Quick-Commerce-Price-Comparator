package io.sentry.android.core.internal.util;

import android.content.Context;
import io.sentry.ILogger;
import io.sentry.android.core.BuildInfoProvider;
import io.sentry.util.Objects;
import java.nio.charset.Charset;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class RootChecker {

    /* renamed from: g, reason: collision with root package name */
    public static final Charset f52320g = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final Context f52321a;

    /* renamed from: b, reason: collision with root package name */
    public final BuildInfoProvider f52322b;

    /* renamed from: c, reason: collision with root package name */
    public final ILogger f52323c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f52324d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f52325e;

    /* renamed from: f, reason: collision with root package name */
    public final Runtime f52326f;

    public RootChecker(Context context, ILogger iLogger, BuildInfoProvider buildInfoProvider) {
        Runtime runtime = Runtime.getRuntime();
        this.f52321a = context;
        Objects.b(buildInfoProvider, "The BuildInfoProvider is required.");
        this.f52322b = buildInfoProvider;
        Objects.b(iLogger, "The Logger is required.");
        this.f52323c = iLogger;
        this.f52324d = new String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su", "/su/bin", "/system/xbin/daemonsu"};
        this.f52325e = new String[]{"com.devadvance.rootcloak", "com.devadvance.rootcloakplus", "com.koushikdutta.superuser", "com.thirdparty.superuser", "eu.chainfire.supersu", "com.noshufou.android.su"};
        Objects.b(runtime, "The Runtime is required.");
        this.f52326f = runtime;
    }
}
