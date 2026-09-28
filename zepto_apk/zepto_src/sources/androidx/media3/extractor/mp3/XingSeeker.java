package androidx.media3.extractor.mp3;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;

/* loaded from: classes3.dex */
final class XingSeeker implements Seeker {

    /* renamed from: a, reason: collision with root package name */
    public final long f8962a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8963b;

    /* renamed from: c, reason: collision with root package name */
    public final long f8964c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8965d;

    /* renamed from: e, reason: collision with root package name */
    public final long f8966e;

    /* renamed from: f, reason: collision with root package name */
    public final long f8967f;

    /* renamed from: g, reason: collision with root package name */
    public final long[] f8968g;

    public XingSeeker(long j2, int i2, long j3, int i3, long j4, long[] jArr) {
        this.f8962a = j2;
        this.f8963b = i2;
        this.f8964c = j3;
        this.f8965d = i3;
        this.f8966e = j4;
        this.f8968g = jArr;
        this.f8967f = j4 != -1 ? j2 + j4 : -1L;
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public final long b(long j2) {
        long j3 = j2 - this.f8962a;
        if (!g() || j3 <= this.f8963b) {
            return 0L;
        }
        long[] jArr = this.f8968g;
        Assertions.h(jArr);
        double d2 = (j3 * 256.0d) / this.f8966e;
        int iF = Util.f(jArr, (long) d2, true);
        long j4 = this.f8964c;
        long j5 = (iF * j4) / 100;
        long j6 = jArr[iF];
        int i2 = iF + 1;
        long j7 = (j4 * i2) / 100;
        return Math.round((j6 == (iF == 99 ? 256L : jArr[i2]) ? 0.0d : (d2 - j6) / (r0 - j6)) * (j7 - j5)) + j5;
    }

    @Override // androidx.media3.extractor.SeekMap
    public final SeekMap.SeekPoints d(long j2) {
        double d2;
        double d3;
        boolean zG = g();
        int i2 = this.f8963b;
        long j3 = this.f8962a;
        if (!zG) {
            SeekPoint seekPoint = new SeekPoint(0L, j3 + i2);
            return new SeekMap.SeekPoints(seekPoint, seekPoint);
        }
        long jL = Util.l(j2, 0L, this.f8964c);
        double d4 = (jL * 100.0d) / this.f8964c;
        double d5 = 0.0d;
        if (d4 <= 0.0d) {
            d2 = 256.0d;
        } else if (d4 >= 100.0d) {
            d2 = 256.0d;
            d5 = 256.0d;
        } else {
            int i3 = (int) d4;
            long[] jArr = this.f8968g;
            Assertions.h(jArr);
            double d6 = jArr[i3];
            if (i3 == 99) {
                d2 = 256.0d;
                d3 = 256.0d;
            } else {
                d2 = 256.0d;
                d3 = jArr[i3 + 1];
            }
            d5 = ((d3 - d6) * (d4 - i3)) + d6;
        }
        long j4 = this.f8966e;
        SeekPoint seekPoint2 = new SeekPoint(jL, j3 + Util.l(Math.round((d5 / d2) * j4), i2, j4 - 1));
        return new SeekMap.SeekPoints(seekPoint2, seekPoint2);
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public final long f() {
        return this.f8967f;
    }

    @Override // androidx.media3.extractor.SeekMap
    public final boolean g() {
        return this.f8968g != null;
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public final int k() {
        return this.f8965d;
    }

    @Override // androidx.media3.extractor.SeekMap
    public final long l() {
        return this.f8964c;
    }
}
