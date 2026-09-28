package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* loaded from: classes4.dex */
public final class zzdjp implements com.google.android.gms.ads.internal.overlay.zzr, com.google.android.gms.ads.internal.client.zza {

    /* renamed from: a, reason: collision with root package name */
    public final zzdum f27820a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfhu f27821b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f27822c = new AtomicBoolean(false);

    public zzdjp(zzdum zzdumVar, zzfhu zzfhuVar) {
        this.f27820a = zzdumVar;
        this.f27821b = zzfhuVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void A4() {
        if (this.f27822c.getAndSet(true)) {
            return;
        }
        zzdum zzdumVar = this.f27820a;
        if (zzdumVar.f28597b.getAndSet(false)) {
            zzfza zzfzaVar = zzdumVar.f28596a;
            zzfzaVar.getClass();
            BuildersKt.c(zzfzaVar.f32075a, null, new zzfyt(zzfzaVar, null), 3);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void R6(int i2) {
        if (this.f27822c.getAndSet(true)) {
            return;
        }
        zzdum zzdumVar = this.f27820a;
        if (zzdumVar.f28597b.getAndSet(false)) {
            zzfza zzfzaVar = zzdumVar.f28596a;
            zzfzaVar.getClass();
            BuildersKt.c(zzfzaVar.f32075a, null, new zzfyt(zzfzaVar, null), 3);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void T7() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void V2() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void d9() {
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void h() {
        zzdum zzdumVar = this.f27820a;
        if (zzdumVar.f28597b.get()) {
            zzfza zzfzaVar = zzdumVar.f28596a;
            zzfzaVar.getClass();
            BuildersKt.c(zzfzaVar.f32075a, null, new zzfyr(zzfzaVar, null), 3);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void i5() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void j7() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void w1() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void w8() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void y3() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzh() {
        String gwsQueryId = this.f27821b.f31167b;
        boolean zA = zzgpz.a(gwsQueryId);
        zzdum zzdumVar = this.f27820a;
        if (zA) {
            zzdumVar.getClass();
            return;
        }
        if (!zzdumVar.f28598c.get() || zzdumVar.f28597b.getAndSet(true)) {
            return;
        }
        zzfza zzfzaVar = zzdumVar.f28596a;
        zzfzaVar.getClass();
        Intrinsics.checkNotNullParameter(gwsQueryId, "gwsQueryId");
        BuildersKt.c(zzfzaVar.f32075a, null, new zzfyp(zzfzaVar, gwsQueryId, null), 3);
    }
}
