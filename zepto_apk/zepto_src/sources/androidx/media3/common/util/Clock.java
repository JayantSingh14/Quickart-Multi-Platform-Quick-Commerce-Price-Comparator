package androidx.media3.common.util;

import android.os.Handler;
import android.os.Looper;

@UnstableApi
/* loaded from: classes.dex */
public interface Clock {

    /* renamed from: a, reason: collision with root package name */
    public static final SystemClock f5662a = new SystemClock();

    HandlerWrapper a(Looper looper, Handler.Callback callback);

    long elapsedRealtime();
}
