package io.sentry.android.replay;

import android.os.Build;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
public final class WindowSpy$decorViewClass$2 extends Lambda implements Function0<Class<?>> {

    /* renamed from: c, reason: collision with root package name */
    public static final WindowSpy$decorViewClass$2 f52514c = new WindowSpy$decorViewClass$2(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        try {
            return Class.forName("com.android.internal.policy.DecorView");
        } catch (Throwable th) {
            Log.d("WindowSpy", "Unexpected exception loading DecorView on API " + Build.VERSION.SDK_INT, th);
            return null;
        }
    }
}
