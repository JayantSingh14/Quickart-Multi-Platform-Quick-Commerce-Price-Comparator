package io.sentry.android.core;

import android.util.Log;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class AndroidLogger implements ILogger {

    /* renamed from: a, reason: collision with root package name */
    public final String f52028a;

    /* renamed from: io.sentry.android.core.AndroidLogger$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f52029a;

        static {
            int[] iArr = new int[SentryLevel.values().length];
            f52029a = iArr;
            try {
                iArr[SentryLevel.INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f52029a[SentryLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f52029a[SentryLevel.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f52029a[SentryLevel.FATAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f52029a[SentryLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public AndroidLogger() {
        this("Sentry");
    }

    @Override // io.sentry.ILogger
    public final void a(SentryLevel sentryLevel, Throwable th, String str, Object... objArr) {
        if (objArr.length == 0) {
            b(sentryLevel, str, th);
        } else {
            b(sentryLevel, String.format(str, objArr), th);
        }
    }

    @Override // io.sentry.ILogger
    public final void b(SentryLevel sentryLevel, String str, Throwable th) {
        int i2 = AnonymousClass1.f52029a[sentryLevel.ordinal()];
        String str2 = this.f52028a;
        if (i2 == 1) {
            Log.i(str2, str, th);
            return;
        }
        if (i2 == 2) {
            Log.w(str2, str, th);
            return;
        }
        if (i2 == 3) {
            Log.e(str2, str, th);
        } else if (i2 != 4) {
            Log.d(str2, str, th);
        } else {
            Log.wtf(str2, str, th);
        }
    }

    @Override // io.sentry.ILogger
    public final void c(SentryLevel sentryLevel, String str, Object... objArr) {
        int length = objArr.length;
        int i2 = 5;
        String str2 = this.f52028a;
        if (length == 0) {
            int i3 = AnonymousClass1.f52029a[sentryLevel.ordinal()];
            if (i3 == 1) {
                i2 = 4;
            } else if (i3 != 2) {
                i2 = i3 != 4 ? 3 : 7;
            }
            Log.println(i2, str2, str);
            return;
        }
        int i4 = AnonymousClass1.f52029a[sentryLevel.ordinal()];
        if (i4 == 1) {
            i2 = 4;
        } else if (i4 != 2) {
            i2 = i4 != 4 ? 3 : 7;
        }
        Log.println(i2, str2, String.format(str, objArr));
    }

    @Override // io.sentry.ILogger
    public final boolean d(SentryLevel sentryLevel) {
        return true;
    }

    public AndroidLogger(String str) {
        this.f52028a = str;
    }
}
