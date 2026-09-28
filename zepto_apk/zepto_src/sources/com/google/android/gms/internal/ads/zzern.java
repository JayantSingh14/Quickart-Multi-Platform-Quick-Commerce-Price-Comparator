package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzern implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final Context f30172a;

    public zzern(Context context) {
        this.f30172a = context;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return zzgym.a(new zzero(ContextCompat.a(this.f30172a, "com.google.android.gms.permission.AD_ID") == 0));
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 2;
    }
}
