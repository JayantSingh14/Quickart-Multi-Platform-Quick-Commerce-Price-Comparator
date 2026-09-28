package com.google.android.gms.internal.measurement;

import androidx.fragment.app.e;

/* loaded from: classes4.dex */
final class zzlb extends zzlf {

    /* renamed from: d, reason: collision with root package name */
    public final int f37071d;

    public zzlb(byte[] bArr, int i2) {
        super(bArr);
        zzlg.m(0, i2, bArr.length);
        this.f37071d = i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzlf, com.google.android.gms.internal.measurement.zzlg
    public final byte b(int i2) {
        int i3 = this.f37071d;
        if (((i3 - (i2 + 1)) | i2) >= 0) {
            return this.f37072c[i2];
        }
        if (i2 < 0) {
            throw new ArrayIndexOutOfBoundsException(e.r(new StringBuilder(String.valueOf(i2).length() + 11), i2, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(e.n(i2, i3, "Index > length: ", ", ", new StringBuilder(String.valueOf(i2).length() + 18 + String.valueOf(i3).length())));
    }

    @Override // com.google.android.gms.internal.measurement.zzlf, com.google.android.gms.internal.measurement.zzlg
    public final byte d(int i2) {
        return this.f37072c[i2];
    }

    @Override // com.google.android.gms.internal.measurement.zzlf, com.google.android.gms.internal.measurement.zzlg
    public final int f() {
        return this.f37071d;
    }
}
