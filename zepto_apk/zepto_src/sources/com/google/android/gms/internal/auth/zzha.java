package com.google.android.gms.internal.auth;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzha {

    /* renamed from: e, reason: collision with root package name */
    public static final zzha f36415e = new zzha(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f36416a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f36417b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f36418c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f36419d;

    public zzha(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f36416a = i2;
        this.f36417b = iArr;
        this.f36418c = objArr;
        this.f36419d = z;
    }

    public static zzha a() {
        return new zzha(0, new int[8], new Object[8], true);
    }

    public final void b(int i2, Object obj) {
        if (!this.f36419d) {
            throw new UnsupportedOperationException();
        }
        c(this.f36416a + 1);
        int[] iArr = this.f36417b;
        int i3 = this.f36416a;
        iArr[i3] = i2;
        this.f36418c[i3] = obj;
        this.f36416a = i3 + 1;
    }

    public final void c(int i2) {
        int[] iArr = this.f36417b;
        if (i2 > iArr.length) {
            int i3 = this.f36416a;
            int i4 = (i3 / 2) + i3;
            if (i4 >= i2) {
                i2 = i4;
            }
            if (i2 < 8) {
                i2 = 8;
            }
            this.f36417b = Arrays.copyOf(iArr, i2);
            this.f36418c = Arrays.copyOf(this.f36418c, i2);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzha)) {
            return false;
        }
        zzha zzhaVar = (zzha) obj;
        int i2 = this.f36416a;
        if (i2 == zzhaVar.f36416a) {
            int[] iArr = this.f36417b;
            int[] iArr2 = zzhaVar.f36417b;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    Object[] objArr = this.f36418c;
                    Object[] objArr2 = zzhaVar.f36418c;
                    int i4 = this.f36416a;
                    for (int i5 = 0; i5 < i4; i5++) {
                        if (objArr[i5].equals(objArr2[i5])) {
                        }
                    }
                    return true;
                }
                if (iArr[i3] != iArr2[i3]) {
                    break;
                }
                i3++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.f36416a;
        int i3 = i2 + 527;
        int[] iArr = this.f36417b;
        int iHashCode = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i2; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i3 * 31) + i4;
        Object[] objArr = this.f36418c;
        int i7 = this.f36416a;
        for (int i8 = 0; i8 < i7; i8++) {
            iHashCode = (iHashCode * 31) + objArr[i8].hashCode();
        }
        return (i6 * 31) + iHashCode;
    }
}
