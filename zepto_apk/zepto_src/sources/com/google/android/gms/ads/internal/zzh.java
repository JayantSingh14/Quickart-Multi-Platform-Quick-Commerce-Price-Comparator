package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzfvd;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzh implements zzfvd {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzk f21635a;

    public zzh(zzk zzkVar) {
        Objects.requireNonNull(zzkVar);
        this.f21635a = zzkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvd
    public final void zza(int i2, long j2) {
        this.f21635a.f21647h.b(i2, System.currentTimeMillis() - j2);
    }

    @Override // com.google.android.gms.internal.ads.zzfvd
    public final void zzb(int i2, long j2, String str) {
        this.f21635a.f21647h.e(i2, System.currentTimeMillis() - j2, null, null, str);
    }
}
