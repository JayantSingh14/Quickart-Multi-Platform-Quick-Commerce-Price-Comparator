package androidx.work.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RestrictTo;
import androidx.core.os.HandlerCompat;
import androidx.work.RunnableScheduler;

@RestrictTo
/* loaded from: classes.dex */
public class DefaultRunnableScheduler implements RunnableScheduler {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f12602a = HandlerCompat.a(Looper.getMainLooper());

    public final void a(Runnable runnable) {
        this.f12602a.removeCallbacks(runnable);
    }

    public final void b(long j2, Runnable runnable) {
        this.f12602a.postDelayed(runnable, j2);
    }
}
