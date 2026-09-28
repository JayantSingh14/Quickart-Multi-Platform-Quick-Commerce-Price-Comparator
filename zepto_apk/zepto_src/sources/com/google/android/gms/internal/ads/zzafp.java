package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzafp {

    /* renamed from: a, reason: collision with root package name */
    public final zzafs f22955a;

    /* renamed from: b, reason: collision with root package name */
    public final zzafs f22956b;

    public zzafp(zzafs zzafsVar, zzafs zzafsVar2) {
        this.f22955a = zzafsVar;
        this.f22956b = zzafsVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzafp.class == obj.getClass()) {
            zzafp zzafpVar = (zzafp) obj;
            if (this.f22955a.equals(zzafpVar.f22955a) && this.f22956b.equals(zzafpVar.f22956b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f22956b.hashCode() + (this.f22955a.hashCode() * 31);
    }

    public final String toString() {
        zzafs zzafsVar = this.f22955a;
        String string = zzafsVar.toString();
        zzafs zzafsVar2 = this.f22956b;
        String strConcat = zzafsVar.equals(zzafsVar2) ? "" : ", ".concat(zzafsVar2.toString());
        return android.support.v4.media.a.n(new StringBuilder(androidx.fragment.app.e.C(string.length() + 1, 1, strConcat)), "[", string, strConcat, "]");
    }
}
