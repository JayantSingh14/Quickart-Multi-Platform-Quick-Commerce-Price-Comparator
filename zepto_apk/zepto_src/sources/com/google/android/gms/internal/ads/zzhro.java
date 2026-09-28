package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzhro extends zzhts {

    /* renamed from: a, reason: collision with root package name */
    public final zzhrn f34124a;

    public zzhro(zzhrn zzhrnVar) {
        this.f34124a = zzhrnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhan
    public final boolean a() {
        return this.f34124a != zzhrn.f34122e;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzhro) && ((zzhro) obj).f34124a == this.f34124a;
    }

    public final int hashCode() {
        return Objects.hash(zzhro.class, this.f34124a);
    }

    public final String toString() {
        String string = this.f34124a.toString();
        return android.support.v4.media.b.s(new StringBuilder(string.length() + 30), "Ed25519 Parameters (variant: ", string, ")");
    }
}
