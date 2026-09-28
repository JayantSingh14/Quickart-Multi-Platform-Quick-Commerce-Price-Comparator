package com.google.android.gms.internal.pal;

import java.nio.charset.Charset;

/* loaded from: classes4.dex */
class zzabv extends zzabu {

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f37362c;

    public zzabv(byte[] bArr) {
        this.f37364a = 0;
        bArr.getClass();
        this.f37362c = bArr;
    }

    @Override // com.google.android.gms.internal.pal.zzaby
    public byte b(int i2) {
        return this.f37362c[i2];
    }

    @Override // com.google.android.gms.internal.pal.zzaby
    public byte d(int i2) {
        return this.f37362c[i2];
    }

    @Override // com.google.android.gms.internal.pal.zzaby
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzaby) && f() == ((zzaby) obj).f()) {
            if (f() == 0) {
                return true;
            }
            if (!(obj instanceof zzabv)) {
                return obj.equals(this);
            }
            zzabv zzabvVar = (zzabv) obj;
            int i2 = this.f37364a;
            int i3 = zzabvVar.f37364a;
            if (i2 == 0 || i3 == 0 || i2 == i3) {
                int iF = f();
                if (iF > zzabvVar.f()) {
                    throw new IllegalArgumentException("Length too large: " + iF + f());
                }
                if (iF > zzabvVar.f()) {
                    throw new IllegalArgumentException(android.support.v4.media.b.d(iF, zzabvVar.f(), "Ran off end of other: 0, ", ", "));
                }
                int i4 = 0;
                int i5 = 0;
                while (i4 < iF) {
                    if (this.f37362c[i4] == zzabvVar.f37362c[i5]) {
                        i4++;
                        i5++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.pal.zzaby
    public int f() {
        return this.f37362c.length;
    }

    @Override // com.google.android.gms.internal.pal.zzaby
    public void g(int i2, byte[] bArr) {
        System.arraycopy(this.f37362c, 0, bArr, 0, i2);
    }

    @Override // com.google.android.gms.internal.pal.zzaby
    public final int i(int i2, int i3) {
        Charset charset = zzadg.f37410a;
        for (int i4 = 0; i4 < i3; i4++) {
            i2 = (i2 * 31) + this.f37362c[i4];
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.pal.zzaby
    public final zzaby j() {
        int iP = zzaby.p(0, 47, f());
        return iP == 0 ? zzaby.f37363b : new zzabs(this.f37362c, iP);
    }

    @Override // com.google.android.gms.internal.pal.zzaby
    public final zzacc k() {
        int iF = f();
        zzaca zzacaVar = new zzaca(this.f37362c, iF);
        try {
            zzacaVar.b(iF);
            return zzacaVar;
        } catch (zzadi e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaby
    public final String m(Charset charset) {
        return new String(this.f37362c, 0, f(), charset);
    }

    @Override // com.google.android.gms.internal.pal.zzaby
    public final void n(zzabo zzaboVar) {
        ((zzace) zzaboVar).v(f(), this.f37362c);
    }

    @Override // com.google.android.gms.internal.pal.zzaby
    public final boolean o() {
        return zzafx.f37505a.b(this.f37362c, 0, f());
    }
}
