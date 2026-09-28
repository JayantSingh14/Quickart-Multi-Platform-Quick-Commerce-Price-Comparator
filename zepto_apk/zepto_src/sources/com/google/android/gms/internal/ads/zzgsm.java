package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes4.dex */
final class zzgsm extends zzgux implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Comparator f33165a = zzza.f35946a;

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.f33165a.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzgsm) {
            return this.f33165a.equals(((zzgsm) obj).f33165a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f33165a.hashCode();
    }

    public final String toString() {
        return this.f33165a.toString();
    }
}
