package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzwa extends zzbf {

    /* renamed from: b, reason: collision with root package name */
    public final zzak f35751b;

    public zzwa(zzak zzakVar) {
        this.f35751b = zzakVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int a() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final zzbe b(int i2, zzbe zzbeVar, long j2) {
        Object obj = zzbe.f24822m;
        zzbeVar.a(this.f35751b, false, true, null, -9223372036854775807L);
        zzbeVar.f24831i = true;
        return zzbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int c() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final zzbd d(int i2, zzbd zzbdVar, boolean z) {
        Integer num = z ? 0 : null;
        Object obj = z ? zzvz.f35748e : null;
        zzc zzcVar = zzc.f25783b;
        zzbdVar.a(num, obj, 0, -9223372036854775807L, true);
        return zzbdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int e(Object obj) {
        return obj == zzvz.f35748e ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final Object f(int i2) {
        return zzvz.f35748e;
    }
}
