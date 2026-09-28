package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzahx extends zzaig {

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f23159b;

    public zzahx(String str, byte[] bArr) {
        super(str);
        this.f23159b = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzahx.class == obj.getClass()) {
            zzahx zzahxVar = (zzahx) obj;
            if (this.f23184a.equals(zzahxVar.f23184a) && Arrays.equals(this.f23159b, zzahxVar.f23159b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f23159b) + ((this.f23184a.hashCode() + 527) * 31);
    }
}
