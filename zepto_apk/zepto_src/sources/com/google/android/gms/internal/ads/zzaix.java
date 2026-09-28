package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzaix implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final long f23221a;

    /* renamed from: b, reason: collision with root package name */
    public final long f23222b;

    /* renamed from: c, reason: collision with root package name */
    public final long f23223c;

    public /* synthetic */ zzaix(long j2, long j3, long j4) {
        this.f23221a = j2;
        this.f23222b = j3;
        this.f23223c = j4;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Long.compare(this.f23221a, ((zzaix) obj).f23221a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaix)) {
            return false;
        }
        zzaix zzaixVar = (zzaix) obj;
        return this.f23221a == zzaixVar.f23221a && this.f23222b == zzaixVar.f23222b && this.f23223c == zzaixVar.f23223c;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.f23221a), Long.valueOf(this.f23222b), Long.valueOf(this.f23223c));
    }
}
