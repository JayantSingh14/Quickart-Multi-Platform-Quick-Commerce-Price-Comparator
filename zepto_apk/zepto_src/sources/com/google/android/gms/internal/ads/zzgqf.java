package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzgqf extends zzgpy {

    /* renamed from: a, reason: collision with root package name */
    public final Object f33071a;

    public zzgqf(Object obj) {
        this.f33071a = obj;
    }

    @Override // com.google.android.gms.internal.ads.zzgpy
    public final Object a() {
        return this.f33071a;
    }

    @Override // com.google.android.gms.internal.ads.zzgpy
    public final zzgpy b(zzgpr zzgprVar) {
        Object objApply = zzgprVar.apply(this.f33071a);
        zzgqa.h(objApply, "the Function passed to Optional.transform() must not return null.");
        return new zzgqf(objApply);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzgqf) {
            return this.f33071a.equals(((zzgqf) obj).f33071a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f33071a.hashCode() + 1502476572;
    }

    public final String toString() {
        String string = this.f33071a.toString();
        return android.support.v4.media.b.s(new StringBuilder(string.length() + 13), "Optional.of(", string, ")");
    }
}
