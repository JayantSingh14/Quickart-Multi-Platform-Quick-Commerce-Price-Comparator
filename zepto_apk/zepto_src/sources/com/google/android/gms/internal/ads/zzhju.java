package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzhju {

    /* renamed from: a, reason: collision with root package name */
    public final Class f33903a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f33904b;

    public /* synthetic */ zzhju(Class cls, Class cls2) {
        this.f33903a = cls;
        this.f33904b = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhju)) {
            return false;
        }
        zzhju zzhjuVar = (zzhju) obj;
        return zzhjuVar.f33903a.equals(this.f33903a) && zzhjuVar.f33904b.equals(this.f33904b);
    }

    public final int hashCode() {
        return Objects.hash(this.f33903a, this.f33904b);
    }

    public final String toString() {
        String simpleName = this.f33903a.getSimpleName();
        String simpleName2 = this.f33904b.getSimpleName();
        return android.support.v4.media.b.s(new StringBuilder(simpleName.length() + 22 + simpleName2.length()), simpleName, " with primitive type: ", simpleName2);
    }
}
