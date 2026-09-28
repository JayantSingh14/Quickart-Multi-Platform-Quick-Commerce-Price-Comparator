package io.sentry.android.replay;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
public final class WindowManagerSpy$windowManagerClass$2 extends Lambda implements Function0<Class<?>> {

    /* renamed from: c, reason: collision with root package name */
    public static final WindowManagerSpy$windowManagerClass$2 f52497c = new WindowManagerSpy$windowManagerClass$2(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        try {
            return Class.forName("android.view.WindowManagerGlobal");
        } catch (Throwable th) {
            Log.w("WindowManagerSpy", th);
            return null;
        }
    }
}
