package com.google.android.gms.internal.pal;

import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzpz {

    /* renamed from: a, reason: collision with root package name */
    public final Class f38015a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f38016b;

    public /* synthetic */ zzpz(Class cls, Class cls2) {
        this.f38015a = cls;
        this.f38016b = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzpz)) {
            return false;
        }
        zzpz zzpzVar = (zzpz) obj;
        return zzpzVar.f38015a.equals(this.f38015a) && zzpzVar.f38016b.equals(this.f38016b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f38015a, this.f38016b});
    }

    public final String toString() {
        return android.support.v4.media.b.l(this.f38015a.getSimpleName(), " with serialization type: ", this.f38016b.getSimpleName());
    }
}
