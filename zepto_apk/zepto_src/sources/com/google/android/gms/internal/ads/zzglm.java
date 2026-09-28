package com.google.android.gms.internal.ads;

import java.io.File;
import java.util.function.Function;

/* loaded from: classes4.dex */
public final class zzglm implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f32860a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32861b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f32862c;

    public zzglm(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3) {
        this.f32860a = zzijfVar;
        this.f32861b = zzijfVar2;
        this.f32862c = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        File file = (File) this.f32860a.zzb();
        zzgca zzgcaVar = (zzgca) this.f32861b.zzb();
        final zzgnc zzgncVar = (zzgnc) this.f32862c.zzb();
        zzgcs zzgcsVarH = zzgcs.H();
        Function function = new Function() { // from class: com.google.android.gms.internal.ads.zzgll
            @Override // java.util.function.Function
            public final /* synthetic */ Object apply(Object obj) {
                zzgncVar.d(20308, (Throwable) obj);
                return zzgcs.H();
            }
        };
        zzgcaVar.getClass();
        return new zzgbz(file, zzgcaVar.f32243a, new zzgbx(zzgcsVarH), function);
    }
}
