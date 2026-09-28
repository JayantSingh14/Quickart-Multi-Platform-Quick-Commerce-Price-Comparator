package com.google.android.gms.internal.ads;

import java.io.File;
import java.util.function.Function;

/* loaded from: classes4.dex */
public final class zzgku implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f32809a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32810b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f32811c;

    public zzgku(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3) {
        this.f32809a = zzijfVar;
        this.f32810b = zzijfVar2;
        this.f32811c = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        File file = (File) this.f32809a.zzb();
        zzgca zzgcaVar = (zzgca) this.f32810b.zzb();
        final zzgnc zzgncVar = (zzgnc) this.f32811c.zzb();
        return zzgcaVar.a(file, new byte[0], new Function() { // from class: com.google.android.gms.internal.ads.zzgke
            @Override // java.util.function.Function
            public final /* synthetic */ Object apply(Object obj) {
                zzgncVar.d(15310, (Throwable) obj);
                return new byte[0];
            }
        });
    }
}
