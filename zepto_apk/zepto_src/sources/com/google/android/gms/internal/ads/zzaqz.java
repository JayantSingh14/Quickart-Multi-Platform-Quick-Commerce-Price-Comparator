package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
final class zzaqz implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Handler f24192a;

    public zzaqz(zzarb zzarbVar, Handler handler) {
        this.f24192a = handler;
        Objects.requireNonNull(zzarbVar);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f24192a.post(runnable);
    }
}
