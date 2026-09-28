package com.google.android.gms.internal.ads;

import java.io.File;
import java.util.function.Function;

/* loaded from: classes4.dex */
public final class zzglp implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f32865a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32866b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f32867c;

    public zzglp(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3) {
        this.f32865a = zzijfVar;
        this.f32866b = zzijfVar2;
        this.f32867c = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        File file = (File) this.f32865a.zzb();
        zzgca zzgcaVar = (zzgca) this.f32866b.zzb();
        final zzgnc zzgncVar = (zzgnc) this.f32867c.zzb();
        return zzgcaVar.a(file, new byte[0], new Function() { // from class: com.google.android.gms.internal.ads.zzglj
            @Override // java.util.function.Function
            public final /* synthetic */ Object apply(Object obj) {
                zzgncVar.d(20310, (Throwable) obj);
                return new byte[0];
            }
        });
    }
}
