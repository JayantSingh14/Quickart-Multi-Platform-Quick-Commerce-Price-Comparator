package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzauj {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f24394a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public int f24395b = 0;

    public final int a(long j2) throws zzauh {
        long j3;
        int[] iArr = {2001100545, 2130723407, 140753313, -149863858, -2003236720, 202391198, 23353437, 1141616124, 84353895};
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = iArr[7];
        int iA = android.support.v4.media.a.A(((~i2) & i3) | i4, (i2 & i5) | i6, i7, i8);
        int i10 = i9 % 84353895;
        long[] jArr = {269441500, 1994078854, 158128940, -158130045, -1992289935, 556430036, 8936987, 2147469841, 438792350};
        long j4 = jArr[0];
        long j5 = jArr[1];
        long j6 = jArr[2];
        long j7 = jArr[3];
        long j8 = jArr[4];
        long j9 = jArr[5];
        long j10 = jArr[6];
        long j11 = jArr[7];
        long j12 = (((((~j4) & j5) | j6) + ((j4 & j7) | j8)) - j9) + j10;
        long j13 = j11 % 438792350;
        if (j2 >= 0) {
            j3 = (this.f24395b + (iA ^ i10)) - j2;
        } else {
            j3 = (j12 ^ j13) + (-j2);
        }
        if (j3 < 0 || j3 >= this.f24395b) {
            throw new zzauh();
        }
        return (int) j3;
    }

    public final void b(zzaus zzausVar) {
        int[] iArr = {524133589, 740889625, 408955079, 621796408, 24562149, 1207357565, 297783268, 1066077375, 937558955};
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = iArr[7];
        int iA = android.support.v4.media.a.A((i3 & (~i2)) | i4, (i2 & i5) | i6, i7, i8);
        int i10 = this.f24395b;
        if (i10 >= ((i9 % 937558955) ^ iA)) {
            throw new zzaui();
        }
        ArrayList arrayList = this.f24394a;
        if (i10 == arrayList.size()) {
            arrayList.add(zzausVar);
        } else {
            arrayList.set(this.f24395b, zzausVar);
        }
        this.f24395b++;
    }

    public final zzaus c() {
        int[] iArr = {91119157, 1459677288, 586253619, -183145911, -1567288443, 919325394, 146725508, 787086305, 459541652};
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = iArr[7];
        int iA = android.support.v4.media.a.A((i3 & (~i2)) | i4, (i2 & i5) | i6, i7, i8);
        int i10 = i9 % 459541652;
        int i11 = this.f24395b;
        if (i11 <= 0) {
            throw new zzauh();
        }
        int i12 = i10 ^ iA;
        ArrayList arrayList = this.f24394a;
        zzaus zzausVar = (zzaus) arrayList.get(i11 + i12);
        arrayList.set(this.f24395b + i12, null);
        this.f24395b += i12;
        return zzausVar;
    }

    public final zzaus d(long j2) {
        return (zzaus) this.f24394a.get(a(j2));
    }
}
