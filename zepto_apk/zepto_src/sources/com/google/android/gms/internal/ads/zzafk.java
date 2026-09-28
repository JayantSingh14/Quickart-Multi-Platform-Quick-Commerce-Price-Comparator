package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzafk {

    /* renamed from: a, reason: collision with root package name */
    public int f22940a;

    /* renamed from: b, reason: collision with root package name */
    public String f22941b;

    /* renamed from: c, reason: collision with root package name */
    public int f22942c;

    /* renamed from: d, reason: collision with root package name */
    public int f22943d;

    /* renamed from: e, reason: collision with root package name */
    public int f22944e;

    /* renamed from: f, reason: collision with root package name */
    public int f22945f;

    /* renamed from: g, reason: collision with root package name */
    public int f22946g;

    public final boolean a(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        if ((i2 & (-2097152)) != -2097152 || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
            return false;
        }
        int i7 = i5 - 1;
        this.f22940a = i3;
        this.f22941b = zzafl.f22947a[3 - i4];
        int i8 = zzafl.f22948b[i6];
        this.f22943d = i8;
        if (i3 == 2) {
            i8 /= 2;
            this.f22943d = i8;
        } else if (i3 == 0) {
            i8 /= 4;
            this.f22943d = i8;
        }
        int i9 = (i2 >>> 9) & 1;
        int i10 = 1152;
        if (i4 != 1) {
            if (i4 != 2) {
                i10 = 384;
            }
        } else if (i3 != 3) {
            i10 = 576;
        }
        this.f22946g = i10;
        if (i4 == 3) {
            int i11 = i3 == 3 ? zzafl.f22949c[i7] : zzafl.f22950d[i7];
            this.f22945f = i11;
            this.f22942c = (((i11 * 12) / i8) + i9) * 4;
        } else {
            if (i3 == 3) {
                int i12 = i4 == 2 ? zzafl.f22951e[i7] : zzafl.f22952f[i7];
                this.f22945f = i12;
                this.f22942c = android.support.v4.media.a.x(i12, 144, i8, i9);
            } else {
                int i13 = zzafl.f22953g[i7];
                this.f22945f = i13;
                this.f22942c = android.support.v4.media.a.x(i4 == 1 ? 72 : 144, i13, i8, i9);
            }
        }
        this.f22944e = ((i2 >> 6) & 3) == 3 ? 1 : 2;
        return true;
    }
}
