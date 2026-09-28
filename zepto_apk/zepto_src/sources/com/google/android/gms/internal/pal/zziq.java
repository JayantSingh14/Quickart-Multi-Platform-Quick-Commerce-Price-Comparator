package com.google.android.gms.internal.pal;

import java.io.Serializable;

/* loaded from: classes4.dex */
final class zziq extends zzil {

    /* renamed from: a, reason: collision with root package name */
    public final Object f37813a;

    public zziq(Object obj) {
        this.f37813a = obj;
    }

    @Override // com.google.android.gms.internal.pal.zzil
    public final zzil a(zzii zziiVar) {
        return new zziq(zziiVar.zza(this.f37813a));
    }

    @Override // com.google.android.gms.internal.pal.zzil
    public final Object b() {
        return this.f37813a;
    }

    @Override // com.google.android.gms.internal.pal.zzil
    public final Object c(Serializable serializable) {
        return this.f37813a;
    }

    @Override // com.google.android.gms.internal.pal.zzil
    public final boolean d() {
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zziq) {
            return this.f37813a.equals(((zziq) obj).f37813a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f37813a.hashCode() + 1502476572;
    }

    public final String toString() {
        return android.support.v4.media.b.q(new StringBuilder("Optional.of("), this.f37813a, ")");
    }
}
