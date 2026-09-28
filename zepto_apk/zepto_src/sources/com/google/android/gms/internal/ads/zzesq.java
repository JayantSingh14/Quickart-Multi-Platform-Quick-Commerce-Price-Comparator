package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes4.dex */
public final class zzesq implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f30247a;

    public zzesq(Bundle bundle) {
        this.f30247a = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzczm zzczmVar = (zzczm) obj;
        Bundle bundle = this.f30247a;
        if (bundle.isEmpty()) {
            return;
        }
        zzczmVar.f27481a.putBundle("installed_adapter_data", bundle);
    }
}
