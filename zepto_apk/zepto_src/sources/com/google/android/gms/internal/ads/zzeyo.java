package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes4.dex */
public final class zzeyo implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f30592a;

    public zzeyo(Bundle bundle) {
        this.f30592a = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzczm zzczmVar = (zzczm) obj;
        Bundle bundle = this.f30592a;
        if (bundle != null) {
            zzczmVar.f27481a.putAll(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzczm zzczmVar = (zzczm) obj;
        Bundle bundle = this.f30592a;
        if (bundle != null) {
            zzczmVar.f27482b.putAll(bundle);
        }
    }
}
