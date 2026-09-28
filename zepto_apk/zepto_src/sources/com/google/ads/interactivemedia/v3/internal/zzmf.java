package com.google.ads.interactivemedia.v3.internal;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes3.dex */
final class zzmf extends zzlr {
    final /* synthetic */ TaskCompletionSource zza;

    public zzmf(zzmh zzmhVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzls
    public final void zzb(int i2) {
        this.zza.c(new zzmb(i2));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzls
    public final void zzc(Bundle bundle) {
        this.zza.d(bundle.getString("newToken"));
    }
}
