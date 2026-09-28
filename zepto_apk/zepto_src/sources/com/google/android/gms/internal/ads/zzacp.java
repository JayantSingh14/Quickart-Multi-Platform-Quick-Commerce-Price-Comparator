package com.google.android.gms.internal.ads;

import android.hardware.display.DisplayManager;
import android.view.Choreographer;

/* loaded from: classes4.dex */
abstract class zzacp implements DisplayManager.DisplayListener {

    /* renamed from: a, reason: collision with root package name */
    public final Choreographer f22747a;

    /* renamed from: b, reason: collision with root package name */
    public final DisplayManager f22748b;

    /* renamed from: c, reason: collision with root package name */
    public volatile long f22749c = -9223372036854775807L;

    /* renamed from: d, reason: collision with root package name */
    public volatile long f22750d = -9223372036854775807L;

    public /* synthetic */ zzacp(Choreographer choreographer, DisplayManager displayManager) {
        this.f22747a = choreographer;
        this.f22748b = displayManager;
    }

    public void a() {
        this.f22748b.registerDisplayListener(this, zzfj.n());
    }

    public void b() {
        throw null;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i2) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i2) {
    }
}
