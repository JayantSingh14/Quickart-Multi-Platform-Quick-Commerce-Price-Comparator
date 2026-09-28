package com.google.android.gms.internal.ads;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class zzclr implements zzijg {
    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzgyw executorService = zzcdo.f25982a;
        zzijo.a(executorService);
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        return new zzfzd(executorService);
    }
}
