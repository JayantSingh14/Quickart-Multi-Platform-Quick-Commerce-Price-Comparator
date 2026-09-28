package com.google.ads.interactivemedia.v3.internal;

import android.graphics.Bitmap;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes3.dex */
final class zzej implements zzsn {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ String zzb;

    public zzej(zzek zzekVar, TaskCompletionSource taskCompletionSource, String str) {
        this.zza = taskCompletionSource;
        this.zzb = str;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzsn
    public final void zza(Throwable th) {
        this.zza.a(new Exception("Failed to load image from: ".concat(String.valueOf(this.zzb)), th));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzsn
    public final /* synthetic */ void zzb(Object obj) {
        this.zza.d((Bitmap) obj);
    }
}
