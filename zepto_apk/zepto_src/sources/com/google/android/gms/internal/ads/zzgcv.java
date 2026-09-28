package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzgcv implements zzgxu {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzgda f32279a;

    public zzgcv(zzgda zzgdaVar) {
        Objects.requireNonNull(zzgdaVar);
        this.f32279a = zzgdaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxu
    public final ListenableFuture zza(Object obj) {
        zzgct zzgctVar = (zzgct) obj;
        if (zzgctVar != null) {
            return zzgym.a(zzgctVar);
        }
        zzgda zzgdaVar = this.f32279a;
        zzgdaVar.f32294e.b(51);
        return (zzgye) zzgym.h(zzgye.s(zzgym.c(new zzgcw(zzgdaVar, 2), zzgdaVar.f32293d)), zzgcx.f32282a, zzgyb.f33369a);
    }
}
