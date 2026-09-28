package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes3.dex */
final class zzmg extends zzlp {
    final /* synthetic */ TaskCompletionSource zza;

    public zzmg(zzmh zzmhVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzlq
    public final void zzb(int i2) {
        this.zza.c(new zzmb(i2));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzlq
    public final void zzc(zzly zzlyVar) {
        this.zza.d(zzlyVar.zza());
    }
}
