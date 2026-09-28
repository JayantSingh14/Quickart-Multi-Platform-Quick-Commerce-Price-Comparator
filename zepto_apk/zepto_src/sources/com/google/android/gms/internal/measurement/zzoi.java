package com.google.android.gms.internal.measurement;

import androidx.fragment.app.e;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzoi {

    /* renamed from: f, reason: collision with root package name */
    public static final zzoi f37187f = new zzoi(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f37188a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f37189b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f37190c;

    /* renamed from: d, reason: collision with root package name */
    public int f37191d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f37192e;

    public zzoi(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f37188a = i2;
        this.f37189b = iArr;
        this.f37190c = objArr;
        this.f37192e = z;
    }

    public static zzoi a() {
        return new zzoi(0, new int[8], new Object[8], true);
    }

    public final void b(zzou zzouVar) {
        if (this.f37188a != 0) {
            for (int i2 = 0; i2 < this.f37188a; i2++) {
                int i3 = this.f37189b[i2];
                Object obj = this.f37190c[i2];
                int i4 = i3 & 7;
                int i5 = i3 >>> 3;
                if (i4 == 0) {
                    zzouVar.b(i5, ((Long) obj).longValue());
                } else if (i4 == 1) {
                    zzouVar.s(i5, ((Long) obj).longValue());
                } else if (i4 == 2) {
                    zzouVar.t(i5, (zzlg) obj);
                } else if (i4 == 3) {
                    zzouVar.o(i5);
                    ((zzoi) obj).b(zzouVar);
                    zzouVar.y0(i5);
                } else {
                    if (i4 != 5) {
                        throw new RuntimeException(new zzmp());
                    }
                    zzouVar.zzk(i5, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final int c() {
        int iW;
        int iA;
        int iW2;
        int i2 = this.f37191d;
        if (i2 != -1) {
            return i2;
        }
        int iC = 0;
        for (int i3 = 0; i3 < this.f37188a; i3++) {
            int i4 = this.f37189b[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 0) {
                if (i6 == 1) {
                    ((Long) this.f37190c[i3]).getClass();
                    iW2 = zzll.w(i5 << 3) + 8;
                } else if (i6 == 2) {
                    int i7 = i5 << 3;
                    zzlg zzlgVar = (zzlg) this.f37190c[i3];
                    int iW3 = zzll.w(i7);
                    int iF = zzlgVar.f();
                    iC = e.c(iF, iF, iW3, iC);
                } else if (i6 == 3) {
                    int iW4 = zzll.w(i5 << 3);
                    iW = iW4 + iW4;
                    iA = ((zzoi) this.f37190c[i3]).c();
                } else {
                    if (i6 != 5) {
                        throw new IllegalStateException(new zzmp());
                    }
                    ((Integer) this.f37190c[i3]).getClass();
                    iW2 = zzll.w(i5 << 3) + 4;
                }
                iC = iW2 + iC;
            } else {
                int i8 = i5 << 3;
                long jLongValue = ((Long) this.f37190c[i3]).longValue();
                iW = zzll.w(i8);
                iA = zzll.a(jLongValue);
            }
            iC = iA + iW + iC;
        }
        this.f37191d = iC;
        return iC;
    }

    public final void d(int i2, Object obj) {
        if (!this.f37192e) {
            throw new UnsupportedOperationException();
        }
        e(this.f37188a + 1);
        int[] iArr = this.f37189b;
        int i3 = this.f37188a;
        iArr[i3] = i2;
        this.f37190c[i3] = obj;
        this.f37188a = i3 + 1;
    }

    public final void e(int i2) {
        int[] iArr = this.f37189b;
        if (i2 > iArr.length) {
            int i3 = this.f37188a;
            int i4 = (i3 / 2) + i3;
            if (i4 >= i2) {
                i2 = i4;
            }
            if (i2 < 8) {
                i2 = 8;
            }
            this.f37189b = Arrays.copyOf(iArr, i2);
            this.f37190c = Arrays.copyOf(this.f37190c, i2);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzoi)) {
            return false;
        }
        zzoi zzoiVar = (zzoi) obj;
        int i2 = this.f37188a;
        if (i2 == zzoiVar.f37188a) {
            int[] iArr = this.f37189b;
            int[] iArr2 = zzoiVar.f37189b;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    Object[] objArr = this.f37190c;
                    Object[] objArr2 = zzoiVar.f37190c;
                    int i4 = this.f37188a;
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
        int i2 = this.f37188a;
        int i3 = i2 + 527;
        int[] iArr = this.f37189b;
        int iHashCode = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i2; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = ((i3 * 31) + i4) * 31;
        Object[] objArr = this.f37190c;
        int i7 = this.f37188a;
        for (int i8 = 0; i8 < i7; i8++) {
            iHashCode = (iHashCode * 31) + objArr[i8].hashCode();
        }
        return i6 + iHashCode;
    }
}
