package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzhkg {

    /* renamed from: a, reason: collision with root package name */
    public final Class f33924a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhxc f33925b;

    public /* synthetic */ zzhkg(Class cls, zzhxc zzhxcVar) {
        this.f33924a = cls;
        this.f33925b = zzhxcVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhkg)) {
            return false;
        }
        zzhkg zzhkgVar = (zzhkg) obj;
        return zzhkgVar.f33924a.equals(this.f33924a) && zzhkgVar.f33925b.equals(this.f33925b);
    }

    public final int hashCode() {
        return Objects.hash(this.f33924a, this.f33925b);
    }

    public final String toString() {
        String simpleName = this.f33924a.getSimpleName();
        String strValueOf = String.valueOf(this.f33925b);
        return android.support.v4.media.b.s(new StringBuilder(simpleName.length() + 21 + strValueOf.length()), simpleName, ", object identifier: ", strValueOf);
    }
}
