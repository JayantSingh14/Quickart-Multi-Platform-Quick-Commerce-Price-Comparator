package com.google.android.gms.internal.ads;

import java.io.File;
import java.util.function.Function;

/* loaded from: classes4.dex */
public final class zzgkp implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f32800a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32801b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f32802c;

    public zzgkp(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3) {
        this.f32800a = zzijfVar;
        this.f32801b = zzijfVar2;
        this.f32802c = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        File file = (File) this.f32800a.zzb();
        zzgca zzgcaVar = (zzgca) this.f32801b.zzb();
        final zzgnc zzgncVar = (zzgnc) this.f32802c.zzb();
        return zzgcaVar.a(file, new byte[0], new Function() { // from class: com.google.android.gms.internal.ads.zzgkh
            @Override // java.util.function.Function
            public final /* synthetic */ Object apply(Object obj) {
                zzgncVar.d(15309, (Throwable) obj);
                return new byte[0];
            }
        });
    }
}
