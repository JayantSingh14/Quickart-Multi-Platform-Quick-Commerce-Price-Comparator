package com.google.android.gms.internal.ads;

import java.io.File;
import java.util.function.Function;

/* loaded from: classes4.dex */
public final class zzgkx implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f32814a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32815b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f32816c;

    public zzgkx(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3) {
        this.f32814a = zzijfVar;
        this.f32815b = zzijfVar2;
        this.f32816c = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        File file = (File) this.f32814a.zzb();
        zzgca zzgcaVar = (zzgca) this.f32815b.zzb();
        final zzgnc zzgncVar = (zzgnc) this.f32816c.zzb();
        return zzgcaVar.a(file, new byte[0], new Function() { // from class: com.google.android.gms.internal.ads.zzgkg
            @Override // java.util.function.Function
            public final /* synthetic */ Object apply(Object obj) {
                zzgncVar.d(15309, (Throwable) obj);
                return new byte[0];
            }
        });
    }
}
