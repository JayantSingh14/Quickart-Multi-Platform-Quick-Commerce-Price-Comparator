package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.PowerManager;

/* loaded from: classes4.dex */
final class zzfn {

    /* renamed from: a, reason: collision with root package name */
    public final Context f31432a;

    /* renamed from: b, reason: collision with root package name */
    public PowerManager.WakeLock f31433b;

    public zzfn(Context context) {
        this.f31432a = context;
    }

    public final void a(boolean z, boolean z2) {
        synchronized (this) {
            boolean z3 = false;
            if (z) {
                if (this.f31433b == null) {
                    Context context = this.f31432a;
                    if (context.checkSelfPermission("android.permission.WAKE_LOCK") != 0) {
                        zzee.c("WakeLockManager", "WAKE_LOCK permission not granted, can't acquire wake lock for playback");
                        return;
                    }
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    if (powerManager == null) {
                        zzee.c("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                        return;
                    } else {
                        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
                        this.f31433b = wakeLockNewWakeLock;
                        wakeLockNewWakeLock.setReferenceCounted(false);
                    }
                }
            }
            PowerManager.WakeLock wakeLock = this.f31433b;
            if (wakeLock == null) {
                return;
            }
            if (z && z2) {
                z3 = true;
            }
            if (z3) {
                wakeLock.acquire();
            } else {
                wakeLock.release();
            }
        }
    }
}
