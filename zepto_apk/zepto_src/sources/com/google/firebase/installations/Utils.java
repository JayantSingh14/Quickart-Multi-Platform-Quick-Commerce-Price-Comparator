package com.google.firebase.installations;

import android.text.TextUtils;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.time.SystemClock;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class Utils {

    /* renamed from: b, reason: collision with root package name */
    public static final long f44590b = TimeUnit.HOURS.toSeconds(1);

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f44591c = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* renamed from: d, reason: collision with root package name */
    public static Utils f44592d;

    /* renamed from: a, reason: collision with root package name */
    public final SystemClock f44593a;

    public Utils(SystemClock systemClock) {
        this.f44593a = systemClock;
    }

    public final boolean a(PersistedInstallationEntry persistedInstallationEntry) {
        if (TextUtils.isEmpty(persistedInstallationEntry.a())) {
            return true;
        }
        long jB = persistedInstallationEntry.b() + persistedInstallationEntry.g();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f44593a.getClass();
        return jB < timeUnit.toSeconds(System.currentTimeMillis()) + f44590b;
    }
}
