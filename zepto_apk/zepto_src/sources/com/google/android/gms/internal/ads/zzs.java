package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;

/* loaded from: classes4.dex */
public final class zzs {

    /* renamed from: a, reason: collision with root package name */
    public final SparseBooleanArray f35478a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzs) {
            return this.f35478a.equals(((zzs) obj).f35478a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f35478a.hashCode();
    }
}
