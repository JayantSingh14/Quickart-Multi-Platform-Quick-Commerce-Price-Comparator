package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzfml {

    /* renamed from: a, reason: collision with root package name */
    public final Object f31398a;

    /* renamed from: b, reason: collision with root package name */
    public final String f31399b;

    /* renamed from: c, reason: collision with root package name */
    public final ListenableFuture f31400c;

    /* renamed from: d, reason: collision with root package name */
    public final List f31401d;

    /* renamed from: e, reason: collision with root package name */
    public final ListenableFuture f31402e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzfmm f31403f;

    public zzfml(zzfmm zzfmmVar, Object obj, String str, ListenableFuture listenableFuture, List list, ListenableFuture listenableFuture2) {
        Objects.requireNonNull(zzfmmVar);
        this.f31403f = zzfmmVar;
        this.f31398a = obj;
        this.f31399b = str;
        this.f31400c = listenableFuture;
        this.f31401d = list;
        this.f31402e = listenableFuture2;
    }

    public final zzfml a(final zzflu zzfluVar) {
        return b(new zzgxu() { // from class: com.google.android.gms.internal.ads.zzfmk
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return zzgym.a(zzfluVar.zza(obj));
            }
        });
    }

    public final zzfml b(zzgxu zzgxuVar) {
        ListenableFuture listenableFutureH = zzgym.h(this.f31402e, zzgxuVar, this.f31403f.f31405a);
        return new zzfml(this.f31403f, this.f31398a, this.f31399b, this.f31400c, this.f31401d, listenableFutureH);
    }

    public final zzfml c(long j2) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        zzfmm zzfmmVar = this.f31403f;
        ListenableFuture listenableFutureG = zzgym.g(this.f31402e, j2, timeUnit, zzfmmVar.f31406b);
        return new zzfml(zzfmmVar, this.f31398a, this.f31399b, this.f31400c, this.f31401d, listenableFutureG);
    }

    public final zzfmb d() {
        zzfmm zzfmmVar = this.f31403f;
        Object obj = this.f31398a;
        String strB = this.f31399b;
        if (strB == null) {
            strB = zzfmmVar.b(obj);
        }
        final zzfmb zzfmbVar = new zzfmb(obj, strB, this.f31402e);
        ((zzfmt) zzfmmVar.f31407c).v0(new zzdgh() { // from class: com.google.android.gms.internal.ads.zzfms
            @Override // com.google.android.gms.internal.ads.zzdgh
            public final void zza(Object obj2) {
                zzfmb zzfmbVar2 = zzfmbVar;
                ((zzfmv) obj2).m(zzfmbVar2.f31385b);
            }
        });
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzfmj
            @Override // java.lang.Runnable
            public final void run() {
                zzfmn zzfmnVar = this.f31395a.f31403f.f31407c;
                final zzfmb zzfmbVar2 = zzfmbVar;
                ((zzfmt) zzfmnVar).v0(new zzdgh() { // from class: com.google.android.gms.internal.ads.zzfmp
                    @Override // com.google.android.gms.internal.ads.zzdgh
                    public final void zza(Object obj2) {
                        zzfmb zzfmbVar3 = zzfmbVar2;
                        ((zzfmv) obj2).c((zzfmo) zzfmbVar3.f31384a, zzfmbVar3.f31385b);
                    }
                });
            }
        };
        zzgyw zzgywVar = zzcdo.f25988g;
        this.f31400c.q(runnable, zzgywVar);
        zzfmbVar.q(new zzgyk(zzfmbVar, new zzfmg(this, zzfmbVar)), zzgywVar);
        return zzfmbVar;
    }
}
