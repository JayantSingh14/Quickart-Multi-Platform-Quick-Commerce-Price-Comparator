package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;

/* loaded from: classes4.dex */
public final class zzdfq implements zzddq {

    /* renamed from: a, reason: collision with root package name */
    public int f27707a;

    /* renamed from: b, reason: collision with root package name */
    public int f27708b;

    @VisibleForTesting
    public zzdfq() {
        zzbgb zzbgbVar = zzbgk.C1;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        this.f27707a = ((Integer) zzbdVar.f21153c.a(zzbgbVar)).intValue();
        this.f27708b = ((Integer) zzbdVar.f21153c.a(zzbgk.Zd)).intValue();
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final synchronized void F(zzfic zzficVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.D1)).booleanValue()) {
            try {
                zzfhu zzfhuVar = zzficVar.f31194b.f31190b;
                this.f27707a = zzfhuVar.f31168c;
                this.f27708b = zzfhuVar.f31169d;
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final void R(zzbza zzbzaVar) {
    }
}
