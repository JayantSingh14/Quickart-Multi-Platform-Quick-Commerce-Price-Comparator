package androidx.media3.common.util;

import android.os.Handler;
import android.os.Looper;

@UnstableApi
/* loaded from: classes.dex */
public class SystemClock implements Clock {
    @Override // androidx.media3.common.util.Clock
    public final HandlerWrapper a(Looper looper, Handler.Callback callback) {
        return new SystemHandlerWrapper(new Handler(looper, callback));
    }

    @Override // androidx.media3.common.util.Clock
    public final long elapsedRealtime() {
        return android.os.SystemClock.elapsedRealtime();
    }
}
