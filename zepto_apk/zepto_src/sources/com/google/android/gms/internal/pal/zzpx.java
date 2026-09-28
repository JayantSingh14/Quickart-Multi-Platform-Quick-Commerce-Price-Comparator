package com.google.android.gms.internal.pal;

import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzpx {

    /* renamed from: a, reason: collision with root package name */
    public final Class f38013a;

    /* renamed from: b, reason: collision with root package name */
    public final zzyv f38014b;

    public /* synthetic */ zzpx(Class cls, zzyv zzyvVar) {
        this.f38013a = cls;
        this.f38014b = zzyvVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzpx)) {
            return false;
        }
        zzpx zzpxVar = (zzpx) obj;
        return zzpxVar.f38013a.equals(this.f38013a) && zzpxVar.f38014b.equals(this.f38014b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f38013a, this.f38014b});
    }

    public final String toString() {
        return android.support.v4.media.b.l(this.f38013a.getSimpleName(), ", object identifier: ", String.valueOf(this.f38014b));
    }
}
