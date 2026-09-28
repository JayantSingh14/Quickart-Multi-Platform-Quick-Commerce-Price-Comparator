package com.google.android.gms.internal.ads;

import java.io.File;
import java.util.function.Function;

/* loaded from: classes4.dex */
public final class zzgkn implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f32796a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32797b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f32798c;

    public zzgkn(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3) {
        this.f32796a = zzijfVar;
        this.f32797b = zzijfVar2;
        this.f32798c = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        File file = (File) this.f32796a.zzb();
        zzgca zzgcaVar = (zzgca) this.f32797b.zzb();
        final zzgnc zzgncVar = (zzgnc) this.f32798c.zzb();
        return zzgcaVar.a(file, new byte[0], new Function() { // from class: com.google.android.gms.internal.ads.zzgkf
            @Override // java.util.function.Function
            public final /* synthetic */ Object apply(Object obj) {
                zzgncVar.d(15310, (Throwable) obj);
                return new byte[0];
            }
        });
    }
}
