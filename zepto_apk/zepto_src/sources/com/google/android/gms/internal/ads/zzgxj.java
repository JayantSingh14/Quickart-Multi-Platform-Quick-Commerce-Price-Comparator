package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
final class zzgxj extends zzgxl {
    @Override // com.google.android.gms.internal.ads.zzgxl
    public final /* synthetic */ void t(Object obj) {
        m((ListenableFuture) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgxl
    public final Object u(Object obj, Object obj2) {
        zzgxu zzgxuVar = (zzgxu) obj;
        ListenableFuture listenableFutureZza = zzgxuVar.zza(obj2);
        if (listenableFutureZza != null) {
            return listenableFutureZza;
        }
        throw new NullPointerException(zzgqr.b("AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgxuVar));
    }
}
