package com.google.android.gms.internal.ads;

import android.os.Handler;

/* loaded from: classes4.dex */
final class zzftm implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        Handler handler = zzftp.f31842i;
        if (handler != null) {
            handler.post(zzftp.f31843j);
            zzftp.f31842i.postDelayed(zzftp.f31844k, 200L);
        }
    }
}
