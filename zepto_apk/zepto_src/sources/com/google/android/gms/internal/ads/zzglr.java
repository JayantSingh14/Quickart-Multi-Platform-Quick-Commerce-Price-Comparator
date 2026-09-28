package com.google.android.gms.internal.ads;

import java.io.File;
import java.util.function.Function;

/* loaded from: classes4.dex */
public final class zzglr implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f32869a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32870b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f32871c;

    public zzglr(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3) {
        this.f32869a = zzijfVar;
        this.f32870b = zzijfVar2;
        this.f32871c = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        File file = (File) this.f32869a.zzb();
        zzgca zzgcaVar = (zzgca) this.f32870b.zzb();
        final zzgnc zzgncVar = (zzgnc) this.f32871c.zzb();
        return zzgcaVar.a(file, new byte[0], new Function() { // from class: com.google.android.gms.internal.ads.zzglk
            @Override // java.util.function.Function
            public final /* synthetic */ Object apply(Object obj) {
                zzgncVar.d(20309, (Throwable) obj);
                return new byte[0];
            }
        });
    }
}
