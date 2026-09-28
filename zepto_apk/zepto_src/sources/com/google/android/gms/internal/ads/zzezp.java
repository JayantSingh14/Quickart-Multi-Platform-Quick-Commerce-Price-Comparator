package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzezp implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f30688a;

    public zzezp(zzffn zzffnVar) {
        this.f30688a = zzffnVar != null;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return zzgym.a(new zzezo(this.f30688a));
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 36;
    }
}
