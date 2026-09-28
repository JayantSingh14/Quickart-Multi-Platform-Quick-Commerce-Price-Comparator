package com.google.android.gms.internal.pal;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzafj {

    /* renamed from: f, reason: collision with root package name */
    public static final zzafj f37488f = new zzafj(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f37489a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f37490b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f37491c;

    /* renamed from: d, reason: collision with root package name */
    public int f37492d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f37493e;

    public zzafj(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f37489a = i2;
        this.f37490b = iArr;
        this.f37491c = objArr;
        this.f37493e = z;
    }

    public static zzafj b() {
        return new zzafj(0, new int[8], new Object[8], true);
    }

    public final int a() {
        int iA;
        int iB;
        int i2 = this.f37492d;
        if (i2 != -1) {
            return i2;
        }
        int iD = 0;
        for (int i3 = 0; i3 < this.f37489a; i3++) {
            int i4 = this.f37490b[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 0) {
                if (i6 == 1) {
                    ((Long) this.f37491c[i3]).getClass();
                    iD = a.d(i5 << 3, 8, iD);
                } else if (i6 == 2) {
                    zzaby zzabyVar = (zzaby) this.f37491c[i3];
                    int iA2 = zzach.a(i5 << 3);
                    int iF = zzabyVar.f();
                    iD = a.e(iF, iF, iA2, iD);
                } else if (i6 == 3) {
                    int iU = zzach.u(i5);
                    iA = iU + iU;
                    iB = ((zzafj) this.f37491c[i3]).a();
                } else {
                    if (i6 != 5) {
                        throw new IllegalStateException(zzadi.a());
                    }
                    ((Integer) this.f37491c[i3]).getClass();
                    iD = a.d(i5 << 3, 4, iD);
                }
            } else {
                long jLongValue = ((Long) this.f37491c[i3]).longValue();
                iA = zzach.a(i5 << 3);
                iB = zzach.b(jLongValue);
            }
            iD = iB + iA + iD;
        }
        this.f37492d = iD;
        return iD;
    }

    public final void c(int i2, Object obj) {
        if (!this.f37493e) {
            throw new UnsupportedOperationException();
        }
        int i3 = this.f37489a;
        int[] iArr = this.f37490b;
        if (i3 == iArr.length) {
            int i4 = i3 + (i3 < 4 ? 8 : i3 >> 1);
            this.f37490b = Arrays.copyOf(iArr, i4);
            this.f37491c = Arrays.copyOf(this.f37491c, i4);
        }
        int[] iArr2 = this.f37490b;
        int i5 = this.f37489a;
        iArr2[i5] = i2;
        this.f37491c[i5] = obj;
        this.f37489a = i5 + 1;
    }

    public final void d(zzaga zzagaVar) {
        if (this.f37489a != 0) {
            for (int i2 = 0; i2 < this.f37489a; i2++) {
                int i3 = this.f37490b[i2];
                Object obj = this.f37491c[i2];
                int i4 = i3 >>> 3;
                int i5 = i3 & 7;
                if (i5 == 0) {
                    zzagaVar.zzt(i4, ((Long) obj).longValue());
                } else if (i5 == 1) {
                    zzagaVar.zzm(i4, ((Long) obj).longValue());
                } else if (i5 == 2) {
                    zzagaVar.m(i4, (zzaby) obj);
                } else if (i5 == 3) {
                    zzagaVar.Q(i4);
                    ((zzafj) obj).d(zzagaVar);
                    zzagaVar.zzh(i4);
                } else {
                    if (i5 != 5) {
                        throw new RuntimeException(zzadi.a());
                    }
                    zzagaVar.zzk(i4, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzafj)) {
            return false;
        }
        zzafj zzafjVar = (zzafj) obj;
        int i2 = this.f37489a;
        if (i2 == zzafjVar.f37489a) {
            int[] iArr = this.f37490b;
            int[] iArr2 = zzafjVar.f37490b;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    Object[] objArr = this.f37491c;
                    Object[] objArr2 = zzafjVar.f37491c;
                    int i4 = this.f37489a;
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
        int i2 = this.f37489a;
        int i3 = (i2 + 527) * 31;
        int[] iArr = this.f37490b;
        int iHashCode = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i2; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i3 + i4) * 31;
        Object[] objArr = this.f37491c;
        int i7 = this.f37489a;
        for (int i8 = 0; i8 < i7; i8++) {
            iHashCode = (iHashCode * 31) + objArr[i8].hashCode();
        }
        return i6 + iHashCode;
    }
}
