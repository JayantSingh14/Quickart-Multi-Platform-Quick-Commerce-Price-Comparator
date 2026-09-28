package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzexb implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30514a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfik f30515b;

    public zzexb(zzgyw zzgywVar, zzfik zzfikVar) {
        this.f30514a = zzgywVar;
        this.f30515b = zzfikVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return ((zzgxi) this.f30514a).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzexa
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return new zzexc("requester_type_2".equals(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.b(this.f30513a.f30515b.f31216d)));
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 21;
    }
}
