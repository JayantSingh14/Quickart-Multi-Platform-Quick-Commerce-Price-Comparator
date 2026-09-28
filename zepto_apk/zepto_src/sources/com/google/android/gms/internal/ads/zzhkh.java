package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzhkh {

    /* renamed from: a, reason: collision with root package name */
    public final Class f33926a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f33927b;

    public /* synthetic */ zzhkh(Class cls, Class cls2) {
        this.f33926a = cls;
        this.f33927b = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhkh)) {
            return false;
        }
        zzhkh zzhkhVar = (zzhkh) obj;
        return zzhkhVar.f33926a.equals(this.f33926a) && zzhkhVar.f33927b.equals(this.f33927b);
    }

    public final int hashCode() {
        return Objects.hash(this.f33926a, this.f33927b);
    }

    public final String toString() {
        String simpleName = this.f33926a.getSimpleName();
        String simpleName2 = this.f33927b.getSimpleName();
        return android.support.v4.media.b.s(new StringBuilder(simpleName.length() + 26 + simpleName2.length()), simpleName, " with serialization type: ", simpleName2);
    }
}
