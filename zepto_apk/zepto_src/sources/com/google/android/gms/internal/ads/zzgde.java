package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class zzgde implements zzgcb {

    /* renamed from: a, reason: collision with root package name */
    public final zzgad f32302a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgda f32303b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgcu f32304c;

    /* renamed from: d, reason: collision with root package name */
    public final ExecutorService f32305d;

    /* renamed from: e, reason: collision with root package name */
    public final zzgnc f32306e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReference f32307f = new AtomicReference();

    public zzgde(zzgad zzgadVar, zzgda zzgdaVar, zzgcu zzgcuVar, ExecutorService executorService, zzgnc zzgncVar) {
        this.f32302a = zzgadVar;
        this.f32303b = zzgdaVar;
        this.f32304c = zzgcuVar;
        this.f32305d = executorService;
        this.f32306e = zzgncVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    public final ListenableFuture zza() {
        zzgad zzgadVar = this.f32302a;
        int iF = zzgadVar.F();
        boolean zH = zzgadVar.H();
        zzgda zzgdaVar = this.f32303b;
        zzgdaVar.getClass();
        zzgye zzgyeVarS = zzgye.s(zzgym.c(new zzgcw(zzgdaVar, iF), zzgdaVar.f32293d));
        zzgcx zzgcxVar = zzgcx.f32282a;
        zzgyb zzgybVar = zzgyb.f33369a;
        zzgye zzgyeVar = (zzgye) zzgym.h(zzgyeVarS, zzgcxVar, zzgybVar);
        if (zH && iF != 2) {
            zzgyeVar = (zzgye) zzgym.h((zzgye) zzgym.e(zzgye.s(zzgyeVar), Throwable.class, zzgcz.f32284a, zzgybVar), new zzgcv(zzgdaVar), zzgybVar);
        }
        zzgye zzgyeVar2 = (zzgye) zzgym.i(zzgye.s(zzgyeVar), new zzgpr() { // from class: com.google.android.gms.internal.ads.zzgdd
            @Override // com.google.android.gms.internal.ads.zzgpr
            public final /* synthetic */ Object apply(Object obj) {
                zzgct zzgctVar = (zzgct) obj;
                this.f32301a.f32307f.set(zzgctVar);
                return zzgctVar;
            }
        }, zzgybVar);
        zzgyeVar2.q(new zzgyk(zzgyeVar2, new zzgdc(this)), this.f32305d);
        return zzgyeVar2;
    }
}
