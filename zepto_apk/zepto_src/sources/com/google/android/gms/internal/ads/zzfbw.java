package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzfbw implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30824a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f30825b;

    public zzfbw(zzgyw zzgywVar, ArrayList arrayList) {
        this.f30824a = zzgywVar;
        this.f30825b = arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return ((zzgxi) this.f30824a).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzfbv
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return new zzfbx(this.f30823a.f30825b);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 48;
    }
}
