package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzeec implements zzeee {

    /* renamed from: a, reason: collision with root package name */
    public final Map f29171a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgyw f29172b;

    /* renamed from: c, reason: collision with root package name */
    public final zzddo f29173c;

    public zzeec(Map map, zzgyw zzgywVar, zzddo zzddoVar) {
        this.f29171a = map;
        this.f29172b = zzgywVar;
        this.f29173c = zzddoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeee
    public final ListenableFuture a(final zzbza zzbzaVar) {
        this.f29173c.R(zzbzaVar);
        ListenableFuture listenableFutureB = zzgym.b(new zzebr(3));
        for (String str : ((String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.j9)).split(",")) {
            final zzijv zzijvVar = (zzijv) this.f29171a.get(str.trim());
            if (zzijvVar != null) {
                listenableFutureB = zzgym.f(listenableFutureB, zzebr.class, new zzgxu() { // from class: com.google.android.gms.internal.ads.zzeeb
                    @Override // com.google.android.gms.internal.ads.zzgxu
                    public final /* synthetic */ ListenableFuture zza(Object obj) {
                        return ((zzeee) zzijvVar.zzb()).a(zzbzaVar);
                    }
                }, this.f29172b);
            }
        }
        listenableFutureB.q(new zzgyk(listenableFutureB, new zzeea(this)), zzcdo.f25988g);
        return listenableFutureB;
    }
}
