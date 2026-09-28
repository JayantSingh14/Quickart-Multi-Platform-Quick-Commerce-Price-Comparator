package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzabr implements zzadi {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzabw f22673b;

    public zzabr(zzabw zzabwVar) {
        Objects.requireNonNull(zzabwVar);
        this.f22673b = zzabwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final void zza() {
        zzmh zzmhVar = this.f22673b.H;
        if (zzmhVar != null) {
            zzmhVar.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final void zzb() {
        zzabw zzabwVar = this.f22673b;
        Surface surface = zzabwVar.y1;
        if (surface != null) {
            zzadf zzadfVar = zzabwVar.l1;
            Handler handler = zzadfVar.f22796a;
            if (handler != null) {
                handler.post(new zzada(zzadfVar, surface, SystemClock.elapsedRealtime()));
            }
            zzabwVar.B1 = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final void zzc() {
        zzabw zzabwVar = this.f22673b;
        if (zzabwVar.y1 != null) {
            zzabwVar.z0(0, 1);
        }
    }
}
