package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzaky {

    /* renamed from: a, reason: collision with root package name */
    public final zzakv f23439a;

    /* renamed from: b, reason: collision with root package name */
    public final int f23440b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f23441c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f23442d;

    /* renamed from: e, reason: collision with root package name */
    public final int f23443e;

    /* renamed from: f, reason: collision with root package name */
    public final long[] f23444f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f23445g;

    /* renamed from: h, reason: collision with root package name */
    public final int[] f23446h;

    /* renamed from: i, reason: collision with root package name */
    public final long f23447i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f23448j;

    public zzaky(zzakv zzakvVar, long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2, int[] iArr3, boolean z, long j2, int i3) {
        int length = iArr.length;
        int length2 = jArr2.length;
        zzgqa.a(length == length2);
        zzgqa.a(jArr.length == length2);
        int length3 = iArr2.length;
        zzgqa.a(length3 == length2);
        this.f23439a = zzakvVar;
        this.f23441c = jArr;
        this.f23442d = iArr;
        this.f23443e = i2;
        this.f23444f = jArr2;
        this.f23445g = iArr2;
        this.f23446h = iArr3;
        this.f23448j = z;
        this.f23447i = j2;
        this.f23440b = i3;
        if (length3 > 0) {
            int i4 = length3 - 1;
            iArr2[i4] = iArr2[i4] | 536870912;
        }
    }

    public final int a(long j2) {
        boolean z = this.f23448j;
        int i2 = 0;
        long[] jArr = this.f23444f;
        if (z) {
            return zzfj.q(jArr, j2, false);
        }
        int[] iArr = this.f23446h;
        int length = iArr.length - 1;
        int i3 = -1;
        while (i2 <= length) {
            int i4 = ((length - i2) / 2) + i2;
            if (jArr[iArr[i4]] <= j2) {
                i2 = i4 + 1;
                i3 = i4;
            } else {
                length = i4 - 1;
            }
        }
        if (i3 == -1) {
            return -1;
        }
        long j3 = jArr[iArr[i3]];
        if (j3 == j2) {
            while (i3 > 0) {
                int i5 = i3 - 1;
                if (jArr[iArr[i5]] != j3) {
                    break;
                }
                i3 = i5;
            }
        }
        return iArr[i3];
    }

    public final int b(long j2) {
        boolean z = this.f23448j;
        long[] jArr = this.f23444f;
        if (z) {
            String str = zzfj.f31254a;
            int iBinarySearch = Arrays.binarySearch(jArr, j2);
            if (iBinarySearch < 0) {
                return ~iBinarySearch;
            }
            while (true) {
                int i2 = iBinarySearch + 1;
                if (i2 >= jArr.length || jArr[i2] != j2) {
                    break;
                }
                iBinarySearch = i2;
            }
            return iBinarySearch;
        }
        int[] iArr = this.f23446h;
        int length = iArr.length - 1;
        int i3 = 0;
        int i4 = -1;
        while (i3 <= length) {
            int i5 = ((length - i3) / 2) + i3;
            if (jArr[iArr[i5]] >= j2) {
                length = i5 - 1;
                i4 = i5;
            } else {
                i3 = i5 + 1;
            }
        }
        if (i4 == -1) {
            return -1;
        }
        long j3 = jArr[iArr[i4]];
        if (j3 == j2) {
            while (i4 < iArr.length - 1) {
                int i6 = i4 + 1;
                if (jArr[iArr[i6]] != j3) {
                    break;
                }
                i4 = i6;
            }
        }
        return iArr[i4];
    }
}
