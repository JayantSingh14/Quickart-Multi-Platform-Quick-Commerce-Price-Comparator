package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzidg {

    /* renamed from: f, reason: collision with root package name */
    public static final zzidg f34760f = new zzidg(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f34761a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f34762b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f34763c;

    /* renamed from: d, reason: collision with root package name */
    public int f34764d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f34765e;

    public zzidg(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f34761a = i2;
        this.f34762b = iArr;
        this.f34763c = objArr;
        this.f34765e = z;
    }

    public static zzidg a() {
        return new zzidg(0, new int[8], new Object[8], true);
    }

    public final void b(zzhzx zzhzxVar) {
        if (this.f34761a != 0) {
            for (int i2 = 0; i2 < this.f34761a; i2++) {
                int i3 = this.f34762b[i2];
                Object obj = this.f34763c[i2];
                int i4 = i3 & 7;
                int i5 = i3 >>> 3;
                if (i4 == 0) {
                    zzhzxVar.b(i5, ((Long) obj).longValue());
                } else if (i4 == 1) {
                    zzhzxVar.i(i5, ((Long) obj).longValue());
                } else if (i4 == 2) {
                    zzhzxVar.l(i5, (zzhzl) obj);
                } else if (i4 == 3) {
                    zzhzw zzhzwVar = zzhzxVar.f34606a;
                    zzhzwVar.g(i5, 3);
                    ((zzidg) obj).b(zzhzxVar);
                    zzhzwVar.g(i5, 4);
                } else {
                    if (i4 != 5) {
                        throw new RuntimeException(new zzibf());
                    }
                    zzhzxVar.j(i5, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final int c() {
        int iB;
        int iC;
        int iB2;
        int i2 = this.f34764d;
        if (i2 != -1) {
            return i2;
        }
        int iB3 = 0;
        for (int i3 = 0; i3 < this.f34761a; i3++) {
            int i4 = this.f34762b[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 0) {
                if (i6 == 1) {
                    ((Long) this.f34763c[i3]).getClass();
                    iB2 = zzhzw.b(i5 << 3) + 8;
                } else if (i6 == 2) {
                    int i7 = i5 << 3;
                    zzhzl zzhzlVar = (zzhzl) this.f34763c[i3];
                    int iB4 = zzhzw.b(i7);
                    int i8 = zzhzlVar.i();
                    iB3 = b.b(i8, i8, iB4, iB3);
                } else if (i6 == 3) {
                    int iB5 = zzhzw.b(i5 << 3);
                    iB = iB5 + iB5;
                    iC = ((zzidg) this.f34763c[i3]).c();
                } else {
                    if (i6 != 5) {
                        throw new IllegalStateException(new zzibf());
                    }
                    ((Integer) this.f34763c[i3]).getClass();
                    iB2 = zzhzw.b(i5 << 3) + 4;
                }
                iB3 = iB2 + iB3;
            } else {
                int i9 = i5 << 3;
                long jLongValue = ((Long) this.f34763c[i3]).longValue();
                iB = zzhzw.b(i9);
                iC = zzhzw.c(jLongValue);
            }
            iB3 = iC + iB + iB3;
        }
        this.f34764d = iB3;
        return iB3;
    }

    public final void d(int i2, Object obj) {
        if (!this.f34765e) {
            throw new UnsupportedOperationException();
        }
        e(this.f34761a + 1);
        int[] iArr = this.f34762b;
        int i3 = this.f34761a;
        iArr[i3] = i2;
        this.f34763c[i3] = obj;
        this.f34761a = i3 + 1;
    }

    public final void e(int i2) {
        int[] iArr = this.f34762b;
        if (i2 > iArr.length) {
            int i3 = this.f34761a;
            int i4 = (i3 / 2) + i3;
            if (i4 >= i2) {
                i2 = i4;
            }
            if (i2 < 8) {
                i2 = 8;
            }
            this.f34762b = Arrays.copyOf(iArr, i2);
            this.f34763c = Arrays.copyOf(this.f34763c, i2);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzidg)) {
            return false;
        }
        zzidg zzidgVar = (zzidg) obj;
        int i2 = this.f34761a;
        if (i2 == zzidgVar.f34761a) {
            int[] iArr = this.f34762b;
            int[] iArr2 = zzidgVar.f34762b;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    Object[] objArr = this.f34763c;
                    Object[] objArr2 = zzidgVar.f34763c;
                    int i4 = this.f34761a;
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
        int i2 = this.f34761a;
        int i3 = i2 + 527;
        int[] iArr = this.f34762b;
        int iHashCode = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i2; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = ((i3 * 31) + i4) * 31;
        Object[] objArr = this.f34763c;
        int i7 = this.f34761a;
        for (int i8 = 0; i8 < i7; i8++) {
            iHashCode = (iHashCode * 31) + objArr[i8].hashCode();
        }
        return i6 + iHashCode;
    }
}
