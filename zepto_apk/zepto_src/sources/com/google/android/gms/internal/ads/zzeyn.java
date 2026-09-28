package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzeyn implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f30591a;

    public zzeyn(Bundle bundle) {
        this.f30591a = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return zzgym.a(new zzeyo(this.f30591a));
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 30;
    }
}
