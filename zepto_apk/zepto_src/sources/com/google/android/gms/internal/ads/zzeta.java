package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzeta implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30262a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfik f30263b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcdf f30264c;

    public zzeta(zzgyw zzgywVar, zzfik zzfikVar, zzcdf zzcdfVar) {
        this.f30262a = zzgywVar;
        this.f30263b = zzfikVar;
        this.f30264c = zzcdfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return ((zzgxi) this.f30262a).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzesz
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzeta zzetaVar = this.f30260a;
                zzfik zzfikVar = zzetaVar.f30263b;
                return new zzetb(zzfikVar.f31223k, zzetaVar.f30264c.f25968g);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 9;
    }
}
