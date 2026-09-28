package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzhdj extends zzhbf {

    /* renamed from: a, reason: collision with root package name */
    public final String f33594a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhdi f33595b;

    public zzhdj(String str, zzhdi zzhdiVar) {
        this.f33594a = str;
        this.f33595b = zzhdiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhan
    public final boolean a() {
        return this.f33595b != zzhdi.f33592c;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhdj)) {
            return false;
        }
        zzhdj zzhdjVar = (zzhdj) obj;
        return zzhdjVar.f33594a.equals(this.f33594a) && zzhdjVar.f33595b.equals(this.f33595b);
    }

    public final int hashCode() {
        return Objects.hash(zzhdj.class, this.f33594a, this.f33595b);
    }

    public final String toString() {
        String string = this.f33595b.toString();
        String str = this.f33594a;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 45 + string.length() + 1);
        android.support.v4.media.b.B(sb, "LegacyKmsAead Parameters (keyUri: ", str, ", variant: ", string);
        sb.append(")");
        return sb.toString();
    }
}
