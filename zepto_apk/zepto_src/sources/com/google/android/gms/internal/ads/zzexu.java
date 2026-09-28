package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes4.dex */
public final class zzexu implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final zzfhq f30545a;

    public zzexu(zzfhq zzfhqVar) {
        this.f30545a = zzfhqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final void zza(Object obj) {
        boolean z;
        boolean z2;
        zzczm zzczmVar = (zzczm) obj;
        zzfhq zzfhqVar = this.f30545a;
        if (zzfhqVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.bd)).booleanValue()) {
                return;
            }
            Bundle bundle = zzczmVar.f27481a;
            synchronized (zzfhqVar.f31146c) {
                zzfhqVar.b();
                z = zzfhqVar.f31148e == 2;
            }
            bundle.putBoolean("render_in_browser", z);
            synchronized (zzfhqVar.f31146c) {
                zzfhqVar.b();
                z2 = zzfhqVar.f31148e == 3;
            }
            bundle.putBoolean("disable_ml", z2);
        }
    }
}
