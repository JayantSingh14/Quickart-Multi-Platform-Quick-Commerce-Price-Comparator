package com.google.android.gms.measurement.internal;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;

@VisibleForTesting
/* loaded from: classes4.dex */
final class zzpd {

    /* renamed from: a, reason: collision with root package name */
    public final zzpf f39590a;

    /* renamed from: b, reason: collision with root package name */
    public int f39591b = 1;

    /* renamed from: c, reason: collision with root package name */
    public long f39592c = b();

    public zzpd(zzpf zzpfVar) {
        this.f39590a = zzpfVar;
    }

    public final boolean a() {
        return this.f39590a.f().currentTimeMillis() >= this.f39592c;
    }

    public final long b() {
        zzpf zzpfVar = this.f39590a;
        Preconditions.checkNotNull(zzpfVar);
        long jLongValue = ((Long) zzfx.v.a(null)).longValue();
        long jLongValue2 = ((Long) zzfx.w.a(null)).longValue();
        for (int i2 = 1; i2 < this.f39591b; i2++) {
            jLongValue += jLongValue;
            if (jLongValue >= jLongValue2) {
                break;
            }
        }
        return Math.min(jLongValue, jLongValue2) + zzpfVar.f().currentTimeMillis();
    }
}
