package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes4.dex */
public final class zzetb implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzx f30265a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f30266b;

    public zzetb(com.google.android.gms.ads.internal.client.zzx zzxVar, boolean z) {
        this.f30265a = zzxVar;
        this.f30266b = z;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final void zza(Object obj) {
        Bundle bundle = ((zzczm) obj).f27481a;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.f6)).booleanValue()) {
            bundle.putBoolean("app_switched", this.f30266b);
        }
        com.google.android.gms.ads.internal.client.zzx zzxVar = this.f30265a;
        if (zzxVar != null) {
            int i2 = zzxVar.f21306a;
            if (i2 == 1) {
                bundle.putString("avo", "p");
            } else if (i2 == 2) {
                bundle.putString("avo", "l");
            }
        }
    }
}
