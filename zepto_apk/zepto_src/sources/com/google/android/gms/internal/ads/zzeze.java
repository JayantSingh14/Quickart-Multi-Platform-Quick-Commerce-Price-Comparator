package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes4.dex */
public final class zzeze implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final String f30648a;

    /* renamed from: b, reason: collision with root package name */
    public final Bundle f30649b;

    /* renamed from: c, reason: collision with root package name */
    public final String f30650c;

    public zzeze(String str, String str2, Bundle bundle) {
        this.f30648a = str;
        this.f30649b = bundle;
        this.f30650c = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final void zza(Object obj) {
        Bundle bundle = ((zzczm) obj).f27481a;
        bundle.putString("rtb", this.f30648a);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.R4)).booleanValue()) {
            String str = this.f30650c;
            if (!str.isEmpty()) {
                bundle.putString("cld_status", str);
            }
        }
        Bundle bundle2 = this.f30649b;
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("adapter_initialization_status", bundle2);
    }
}
