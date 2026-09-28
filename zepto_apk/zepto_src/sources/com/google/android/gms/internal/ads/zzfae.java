package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes4.dex */
public final class zzfae implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final int f30728a;

    /* renamed from: b, reason: collision with root package name */
    public final int f30729b;

    public zzfae(int i2, int i3) {
        this.f30728a = i2;
        this.f30729b = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final void zza(Object obj) {
        int i2;
        Bundle bundle = ((zzczm) obj).f27481a;
        int i3 = this.f30728a;
        if (i3 == -1 || (i2 = this.f30729b) == -1) {
            return;
        }
        bundle.putInt("sessions_without_flags", i3);
        bundle.putInt("crashes_without_flags", i2);
        com.google.android.gms.ads.internal.client.zzbb zzbbVar = com.google.android.gms.ads.internal.client.zzbb.f21141g;
        if (com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.f25009j) {
            bundle.putBoolean("did_reset", true);
        }
    }
}
