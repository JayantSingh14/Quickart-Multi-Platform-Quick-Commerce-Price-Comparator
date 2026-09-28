package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* loaded from: classes4.dex */
public final class zzeer {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f29190a;

    /* renamed from: b, reason: collision with root package name */
    public final zzedw f29191b;

    /* renamed from: c, reason: collision with root package name */
    public final zzija f29192c;

    public zzeer(zzgyw zzgywVar, zzedw zzedwVar, zzija zzijaVar) {
        this.f29190a = zzgywVar;
        this.f29191b = zzedwVar;
        this.f29192c = zzijaVar;
    }

    public final zzgye a(final zzbza zzbzaVar, zzeeh zzeehVar, final zzeeh zzeehVar2, final zzgxu zzgxuVar) {
        String str = zzbzaVar.f25723d;
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        boolean zE = com.google.android.gms.ads.internal.util.zzs.e(str);
        zzgyw zzgywVar = this.f29190a;
        return (zzgye) zzgym.f((zzgye) zzgym.h((zzgye) zzgym.h(zzgye.s(zE ? zzgym.b(new zzeef(1)) : zzgym.f(zzeehVar.a(zzbzaVar), ExecutionException.class, zzeeq.f29189a, zzgywVar)), zzeej.f29179a, zzgywVar), zzgxuVar, zzgywVar), zzeef.class, new zzgxu() { // from class: com.google.android.gms.internal.ads.zzeek
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return zzgym.h(zzeehVar2.a(zzbzaVar), zzgxuVar, this.f29180a.f29190a);
            }
        }, zzgywVar);
    }
}
