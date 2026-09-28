package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzhev extends zzhbf {

    /* renamed from: a, reason: collision with root package name */
    public final zzheu f33685a;

    public zzhev(zzheu zzheuVar) {
        this.f33685a = zzheuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhan
    public final boolean a() {
        return this.f33685a != zzheu.f33683d;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzhev) && ((zzhev) obj).f33685a == this.f33685a;
    }

    public final int hashCode() {
        return Objects.hash(zzhev.class, this.f33685a);
    }

    public final String toString() {
        String string = this.f33685a.toString();
        return android.support.v4.media.b.s(new StringBuilder(string.length() + 40), "XChaCha20Poly1305 Parameters (variant: ", string, ")");
    }
}
