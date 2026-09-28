package com.google.android.gms.internal.ads;

import android.view.Choreographer;

/* loaded from: classes4.dex */
final class zzacq extends zzacp implements Choreographer.FrameCallback {
    @Override // com.google.android.gms.internal.ads.zzacp
    public final void a() {
        long refreshRate;
        super.a();
        this.f22747a.postFrameCallback(this);
        if (this.f22748b.getDisplay(0) != null) {
            refreshRate = (long) (1.0E9d / r0.getRefreshRate());
        } else {
            zzee.c("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            refreshRate = -9223372036854775807L;
        }
        this.f22750d = refreshRate;
    }

    @Override // com.google.android.gms.internal.ads.zzacp
    public final void b() {
        this.f22748b.unregisterDisplayListener(this);
        this.f22747a.removeFrameCallback(this);
        this.f22749c = -9223372036854775807L;
        this.f22750d = -9223372036854775807L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j2) {
        this.f22749c = j2;
        this.f22747a.postFrameCallbackDelayed(this, 500L);
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i2) {
        long refreshRate;
        if (i2 == 0) {
            this.f22747a.postFrameCallback(this);
            if (this.f22748b.getDisplay(0) != null) {
                refreshRate = (long) (1.0E9d / r5.getRefreshRate());
            } else {
                zzee.c("VideoFrameReleaseHelper", "Unable to query display refresh rate");
                refreshRate = -9223372036854775807L;
            }
            this.f22750d = refreshRate;
        }
    }
}
