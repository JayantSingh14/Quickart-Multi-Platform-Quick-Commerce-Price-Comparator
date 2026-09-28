package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzfbc implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30798a;

    /* renamed from: b, reason: collision with root package name */
    public final String f30799b;

    public zzfbc(zzgyw zzgywVar, String str) {
        this.f30798a = zzgywVar;
        this.f30799b = str;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        ListenableFuture listenableFutureA = zzgym.a(this.f30799b);
        zzfbb zzfbbVar = zzfbb.f30797a;
        zzgyw zzgywVar = this.f30798a;
        return zzgym.f(zzgym.i(listenableFutureA, zzfbbVar, zzgywVar), Throwable.class, new zzgxu() { // from class: com.google.android.gms.internal.ads.zzfba
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return zzgym.a(new zzfbd(this.f30796a.f30799b));
            }
        }, zzgywVar);
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 41;
    }
}
