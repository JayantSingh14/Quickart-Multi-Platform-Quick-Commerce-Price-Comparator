package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzfbs implements zzezx {
    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        final ListenableFuture listenableFuture = zzgyq.f33377b;
        ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.z6)).getClass();
        return new zzgyl(zzgtd.s(new ListenableFuture[]{listenableFuture, listenableFuture}), true).a(new Callable() { // from class: com.google.android.gms.internal.ads.zzfbr

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ListenableFuture f30819b = zzgyq.f33377b;

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzfbt((String) ((zzgyq) listenableFuture).f33379a, (String) ((zzgyq) zzgyq.f33377b).f33379a);
            }
        }, zzcdo.f25982a);
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 47;
    }
}
