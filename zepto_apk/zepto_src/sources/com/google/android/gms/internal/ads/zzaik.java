package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzaik extends zzaig {

    /* renamed from: b, reason: collision with root package name */
    public final String f23194b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f23195c;

    public zzaik(String str, byte[] bArr) {
        super("PRIV");
        this.f23194b = str;
        this.f23195c = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaik.class == obj.getClass()) {
            zzaik zzaikVar = (zzaik) obj;
            if (Objects.equals(this.f23194b, zzaikVar.f23194b) && Arrays.equals(this.f23195c, zzaikVar.f23195c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f23195c) + ((this.f23194b.hashCode() + 527) * 31);
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final String toString() {
        String str = this.f23184a;
        int length = String.valueOf(str).length() + 8;
        String str2 = this.f23194b;
        return android.support.v4.media.b.s(new StringBuilder(str2.length() + length), str, ": owner=", str2);
    }
}
