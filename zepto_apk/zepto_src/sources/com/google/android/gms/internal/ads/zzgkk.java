package com.google.android.gms.internal.ads;

import java.io.File;
import java.util.function.Function;

/* loaded from: classes4.dex */
public final class zzgkk implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f32791a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32792b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f32793c;

    public zzgkk(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3) {
        this.f32791a = zzijfVar;
        this.f32792b = zzijfVar2;
        this.f32793c = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        File file = (File) this.f32791a.zzb();
        zzgca zzgcaVar = (zzgca) this.f32792b.zzb();
        final zzgnc zzgncVar = (zzgnc) this.f32793c.zzb();
        zzgcs zzgcsVarH = zzgcs.H();
        Function function = new Function() { // from class: com.google.android.gms.internal.ads.zzgkd
            @Override // java.util.function.Function
            public final /* synthetic */ Object apply(Object obj) {
                zzgncVar.d(15308, (Throwable) obj);
                return zzgcs.H();
            }
        };
        zzgcaVar.getClass();
        return new zzgbz(file, zzgcaVar.f32243a, new zzgbx(zzgcsVarH), function);
    }
}
