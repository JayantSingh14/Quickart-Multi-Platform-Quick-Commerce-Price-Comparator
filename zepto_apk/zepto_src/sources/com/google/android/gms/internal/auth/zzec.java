package com.google.android.gms.internal.auth;

import android.support.v4.media.b;
import java.nio.charset.Charset;

/* loaded from: classes4.dex */
class zzec extends zzeb {

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f36335c;

    public zzec(byte[] bArr) {
        this.f36337a = 0;
        bArr.getClass();
        this.f36335c = bArr;
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public byte b(int i2) {
        return this.f36335c[i2];
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public byte d(int i2) {
        return this.f36335c[i2];
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzef) && f() == ((zzef) obj).f()) {
            if (f() == 0) {
                return true;
            }
            if (!(obj instanceof zzec)) {
                return obj.equals(this);
            }
            zzec zzecVar = (zzec) obj;
            int i2 = this.f36337a;
            int i3 = zzecVar.f36337a;
            if (i2 == 0 || i3 == 0 || i2 == i3) {
                int iF = f();
                if (iF > zzecVar.f()) {
                    throw new IllegalArgumentException("Length too large: " + iF + f());
                }
                if (iF > zzecVar.f()) {
                    throw new IllegalArgumentException(b.d(iF, zzecVar.f(), "Ran off end of other: 0, ", ", "));
                }
                int i4 = 0;
                int i5 = 0;
                while (i4 < iF) {
                    if (this.f36335c[i4] == zzecVar.f36335c[i5]) {
                        i4++;
                        i5++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public int f() {
        return this.f36335c.length;
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public final int g(int i2, int i3) {
        Charset charset = zzfa.f36355a;
        for (int i4 = 0; i4 < i3; i4++) {
            i2 = (i2 * 31) + this.f36335c[i4];
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public final zzef i() {
        int iM = zzef.m(0, 47, f());
        return iM == 0 ? zzef.f36336b : new zzdz(this.f36335c, iM);
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public final String j(Charset charset) {
        return new String(this.f36335c, 0, f(), charset);
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public final boolean k() {
        return zzhn.f36430a.b(this.f36335c, 0, f());
    }
}
