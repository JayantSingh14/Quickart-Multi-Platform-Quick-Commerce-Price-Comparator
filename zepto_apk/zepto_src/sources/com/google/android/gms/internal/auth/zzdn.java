package com.google.android.gms.internal.auth;

import android.support.v4.media.b;
import java.io.Serializable;
import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzdn implements Serializable, zzdj {

    /* renamed from: a, reason: collision with root package name */
    public final Object f36323a;

    public zzdn(Object obj) {
        this.f36323a = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdn)) {
            return false;
        }
        Object obj2 = ((zzdn) obj).f36323a;
        Object obj3 = this.f36323a;
        return obj3 == obj2 || obj3.equals(obj2);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f36323a});
    }

    public final String toString() {
        return b.D("Suppliers.ofInstance(", this.f36323a.toString(), ")");
    }
}
