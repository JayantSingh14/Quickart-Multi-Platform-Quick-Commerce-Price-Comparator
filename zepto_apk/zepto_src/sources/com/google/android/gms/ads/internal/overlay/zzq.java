package com.google.android.gms.ads.internal.overlay;

import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
final class zzq implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final long f21382a;

    public zzq(long j2) {
        this.f21382a = j2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        if (AdOverlayInfoParcel.z.remove(Long.valueOf(this.f21382a)) == null) {
            return null;
        }
        com.google.android.gms.ads.internal.zzt.C.f21684h.d("AdOverlayObjectsCleanupTask", new Exception("Key was non-null in AdOverlayObjectsCleanupTask"));
        return null;
    }
}
