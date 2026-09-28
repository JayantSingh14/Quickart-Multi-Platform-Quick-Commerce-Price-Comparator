package com.google.android.gms.internal.pal;

import java.io.Serializable;

/* loaded from: classes4.dex */
final class zzif extends zzil {

    /* renamed from: a, reason: collision with root package name */
    public static final zzif f37811a = new zzif();

    @Override // com.google.android.gms.internal.pal.zzil
    public final zzil a(zzii zziiVar) {
        zziiVar.getClass();
        return f37811a;
    }

    @Override // com.google.android.gms.internal.pal.zzil
    public final Object b() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.android.gms.internal.pal.zzil
    public final boolean d() {
        return false;
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.android.gms.internal.pal.zzil
    public final Object c(Serializable serializable) {
        return serializable;
    }
}
