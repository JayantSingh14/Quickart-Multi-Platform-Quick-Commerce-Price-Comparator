package com.google.android.gms.internal.ads;

import android.media.AudioManager;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
final class zzfsa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfsb f31766a;

    public zzfsa(zzfsb zzfsbVar) {
        Objects.requireNonNull(zzfsbVar);
        this.f31766a = zzfsbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfsb zzfsbVar = this.f31766a;
        AtomicBoolean atomicBoolean = zzfsbVar.f31771e;
        AudioManager audioManager = zzfsbVar.f31769c;
        int streamVolume = audioManager.getStreamVolume(3);
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        float f2 = 0.0f;
        if (streamMaxVolume > 0 && streamVolume > 0) {
            f2 = streamVolume / streamMaxVolume;
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
        }
        atomicBoolean.set(false);
        if (((Float) zzfsbVar.f31770d.getAndSet(Float.valueOf(f2))).floatValue() != f2) {
            zzfsbVar.f31767a.post(new zzfrz(this, f2));
        }
    }
}
