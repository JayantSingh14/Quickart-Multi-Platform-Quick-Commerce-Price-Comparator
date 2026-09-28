package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* loaded from: classes4.dex */
public final class zzfc implements zzdn {
    @Override // com.google.android.gms.internal.ads.zzdn
    public final zzdx a(Looper looper, Handler.Callback callback) {
        return new zzfe(new Handler(looper, callback));
    }

    public final long b() {
        return System.currentTimeMillis();
    }

    @Override // com.google.android.gms.internal.ads.zzdn
    public final long zzb() {
        return SystemClock.elapsedRealtime();
    }
}
