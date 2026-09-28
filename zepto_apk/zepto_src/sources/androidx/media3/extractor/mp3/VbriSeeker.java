package androidx.media3.extractor.mp3;

import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;

/* loaded from: classes3.dex */
final class VbriSeeker implements Seeker {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f8955a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f8956b;

    /* renamed from: c, reason: collision with root package name */
    public final long f8957c;

    /* renamed from: d, reason: collision with root package name */
    public final long f8958d;

    /* renamed from: e, reason: collision with root package name */
    public final int f8959e;

    public VbriSeeker(long[] jArr, long[] jArr2, long j2, long j3, int i2) {
        this.f8955a = jArr;
        this.f8956b = jArr2;
        this.f8957c = j2;
        this.f8958d = j3;
        this.f8959e = i2;
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public final long b(long j2) {
        return this.f8955a[Util.f(this.f8956b, j2, true)];
    }

    @Override // androidx.media3.extractor.SeekMap
    public final SeekMap.SeekPoints d(long j2) {
        long[] jArr = this.f8955a;
        int iF = Util.f(jArr, j2, true);
        long j3 = jArr[iF];
        long[] jArr2 = this.f8956b;
        SeekPoint seekPoint = new SeekPoint(j3, jArr2[iF]);
        if (j3 >= j2 || iF == jArr.length - 1) {
            return new SeekMap.SeekPoints(seekPoint, seekPoint);
        }
        int i2 = iF + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(jArr[i2], jArr2[i2]));
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public final long f() {
        return this.f8958d;
    }

    @Override // androidx.media3.extractor.SeekMap
    public final boolean g() {
        return true;
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public final int k() {
        return this.f8959e;
    }

    @Override // androidx.media3.extractor.SeekMap
    public final long l() {
        return this.f8957c;
    }
}
