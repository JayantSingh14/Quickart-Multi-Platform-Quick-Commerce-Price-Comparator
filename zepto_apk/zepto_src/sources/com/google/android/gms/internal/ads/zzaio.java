package com.google.android.gms.internal.ads;

import java.util.Locale;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzaio {

    /* renamed from: a, reason: collision with root package name */
    public final long f23205a;

    /* renamed from: b, reason: collision with root package name */
    public final long f23206b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23207c;

    public zzaio(long j2, long j3, int i2) {
        zzgqa.a(j2 < j3);
        this.f23205a = j2;
        this.f23206b = j3;
        this.f23207c = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaio.class == obj.getClass()) {
            zzaio zzaioVar = (zzaio) obj;
            if (this.f23205a == zzaioVar.f23205a && this.f23206b == zzaioVar.f23206b && this.f23207c == zzaioVar.f23207c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.f23205a), Long.valueOf(this.f23206b), Integer.valueOf(this.f23207c));
    }

    public final String toString() {
        String str = zzfj.f31254a;
        Locale locale = Locale.US;
        return "Segment: startTimeMs=" + this.f23205a + ", endTimeMs=" + this.f23206b + ", speedDivisor=" + this.f23207c;
    }
}
