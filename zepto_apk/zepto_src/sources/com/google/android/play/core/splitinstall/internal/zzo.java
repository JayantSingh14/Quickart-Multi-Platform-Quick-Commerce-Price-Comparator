package com.google.android.play.core.splitinstall.internal;

import android.support.v4.media.b;

/* loaded from: classes4.dex */
final class zzo extends zzp {

    /* renamed from: a, reason: collision with root package name */
    public final int f41988a;

    /* renamed from: b, reason: collision with root package name */
    public final long f41989b;

    public zzo(int i2, long j2) {
        this.f41988a = i2;
        this.f41989b = j2;
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzp
    public final int a() {
        return this.f41988a;
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzp
    public final long b() {
        return this.f41989b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzp)) {
            return false;
        }
        zzp zzpVar = (zzp) obj;
        return this.f41988a == zzpVar.a() && this.f41989b == zzpVar.b();
    }

    public final int hashCode() {
        int i2 = this.f41988a ^ 1000003;
        long j2 = this.f41989b;
        return (i2 * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EventRecord{eventType=");
        sb.append(this.f41988a);
        sb.append(", eventTimestamp=");
        return b.p(sb, this.f41989b, "}");
    }
}
