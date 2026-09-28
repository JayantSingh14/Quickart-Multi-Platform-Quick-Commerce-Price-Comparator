package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzhcz extends zzhbf {

    /* renamed from: a, reason: collision with root package name */
    public final zzhcy f33573a;

    public zzhcz(zzhcy zzhcyVar) {
        this.f33573a = zzhcyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhan
    public final boolean a() {
        return this.f33573a != zzhcy.f33571d;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzhcz) && ((zzhcz) obj).f33573a == this.f33573a;
    }

    public final int hashCode() {
        return Objects.hash(zzhcz.class, this.f33573a);
    }

    public final String toString() {
        String string = this.f33573a.toString();
        return android.support.v4.media.b.s(new StringBuilder(string.length() + 39), "ChaCha20Poly1305 Parameters (variant: ", string, ")");
    }
}
