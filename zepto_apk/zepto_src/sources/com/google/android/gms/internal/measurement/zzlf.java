package com.google.android.gms.internal.measurement;

import androidx.fragment.app.e;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
class zzlf extends zzle {

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f37072c;

    public zzlf(byte[] bArr) {
        this.f37074a = 0;
        bArr.getClass();
        this.f37072c = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public byte b(int i2) {
        return this.f37072c[i2];
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public byte d(int i2) {
        return this.f37072c[i2];
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzlg) && f() == ((zzlg) obj).f()) {
            if (f() == 0) {
                return true;
            }
            if (!(obj instanceof zzlf)) {
                return obj.equals(this);
            }
            zzlf zzlfVar = (zzlf) obj;
            int i2 = this.f37074a;
            int i3 = zzlfVar.f37074a;
            if (i2 == 0 || i3 == 0 || i2 == i3) {
                int iF = f();
                if (iF > zzlfVar.f()) {
                    int iF2 = f();
                    StringBuilder sb = new StringBuilder(String.valueOf(iF).length() + 18 + String.valueOf(iF2).length());
                    sb.append("Length too large: ");
                    sb.append(iF);
                    sb.append(iF2);
                    throw new IllegalArgumentException(sb.toString());
                }
                if (iF > zzlfVar.f()) {
                    int iF3 = zzlfVar.f();
                    throw new IllegalArgumentException(e.n(iF, iF3, "Ran off end of other: 0, ", ", ", new StringBuilder(String.valueOf(iF).length() + 27 + String.valueOf(iF3).length())));
                }
                int i4 = 0;
                int i5 = 0;
                while (i4 < iF) {
                    if (this.f37072c[i4] == zzlfVar.f37072c[i5]) {
                        i4++;
                        i5++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public int f() {
        return this.f37072c.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final zzlg g() {
        int iM = zzlg.m(0, 47, f());
        return iM == 0 ? zzlg.f37073b : new zzlb(this.f37072c, iM);
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final void i(zzky zzkyVar) {
        ((zzlj) zzkyVar).x(f(), this.f37072c);
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final int j(int i2, int i3) {
        Charset charset = zzmo.f37112a;
        for (int i4 = 0; i4 < i3; i4++) {
            i2 = (i2 * 31) + this.f37072c[i4];
        }
        return i2;
    }
}
