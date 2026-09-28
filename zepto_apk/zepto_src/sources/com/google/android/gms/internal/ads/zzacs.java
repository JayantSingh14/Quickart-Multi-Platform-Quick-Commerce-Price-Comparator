package com.google.android.gms.internal.ads;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.view.Choreographer;
import android.view.Choreographer$VsyncCallback;
import androidx.annotation.RequiresApi;

@RequiresApi
/* loaded from: classes4.dex */
final class zzacs extends zzacp implements Choreographer$VsyncCallback {

    /* renamed from: e, reason: collision with root package name */
    public final Handler f22752e;

    public /* synthetic */ zzacs(Choreographer choreographer, DisplayManager displayManager) {
        super(choreographer, displayManager);
        this.f22752e = zzfj.n();
    }

    @Override // com.google.android.gms.internal.ads.zzacp
    public final void a() {
        super.a();
        this.f22747a.postVsyncCallback(this);
    }

    @Override // com.google.android.gms.internal.ads.zzacp
    public final void b() {
        this.f22748b.unregisterDisplayListener(this);
        this.f22752e.removeCallbacksAndMessages(null);
        this.f22747a.removeVsyncCallback(this);
        this.f22749c = -9223372036854775807L;
        this.f22750d = -9223372036854775807L;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i2) {
        if (i2 == 0) {
            this.f22747a.postVsyncCallback(this);
        }
    }

    public final void onVsync(Choreographer.FrameData frameData) {
        this.f22749c = frameData.getFrameTimeNanos();
        Choreographer.FrameTimeline[] frameTimelines = frameData.getFrameTimelines();
        if (frameTimelines.length >= 2) {
            long expectedPresentationTimeNanos = frameTimelines[1].getExpectedPresentationTimeNanos() - frameTimelines[0].getExpectedPresentationTimeNanos();
            this.f22750d = expectedPresentationTimeNanos != 0 ? expectedPresentationTimeNanos : -9223372036854775807L;
        } else {
            this.f22750d = -9223372036854775807L;
        }
        this.f22752e.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzacr
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzacs zzacsVar = this.f22751a;
                zzacsVar.f22747a.postVsyncCallback(zzacsVar);
            }
        }, 500L);
    }
}
