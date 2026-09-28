package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzezt implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30692a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f30693b;

    public zzezt(Context context, zzgyw zzgywVar) {
        this.f30692a = zzgywVar;
        this.f30693b = context;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return ((zzgxi) this.f30692a).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzezs
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzezt zzeztVar = this.f30691a;
                zzeztVar.getClass();
                return new zzezr(com.google.android.gms.ads.internal.util.zzac.b(zzeztVar.f30693b, (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.N6)));
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 37;
    }
}
