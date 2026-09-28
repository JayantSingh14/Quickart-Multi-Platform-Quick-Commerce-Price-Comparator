package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes4.dex */
final class zzezr implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f30690a;

    public zzezr(Bundle bundle) {
        this.f30690a = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzczm zzczmVar = (zzczm) obj;
        Bundle bundle = this.f30690a;
        if (bundle.isEmpty()) {
            return;
        }
        zzczmVar.f27481a.putBundle("shared_pref", bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzczm zzczmVar = (zzczm) obj;
        Bundle bundle = this.f30690a;
        if (bundle.isEmpty()) {
            return;
        }
        zzczmVar.f27482b.putBundle("shared_pref", bundle);
    }
}
