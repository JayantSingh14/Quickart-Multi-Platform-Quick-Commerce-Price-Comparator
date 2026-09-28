package androidx.media3.extractor;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;

@UnstableApi
/* loaded from: classes3.dex */
public final class IndexSeekMap implements SeekMap {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f8581a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f8582b;

    /* renamed from: c, reason: collision with root package name */
    public final long f8583c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f8584d;

    public IndexSeekMap(long j2, long[] jArr, long[] jArr2) {
        Assertions.a(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z = length > 0;
        this.f8584d = z;
        if (!z || jArr2[0] <= 0) {
            this.f8581a = jArr;
            this.f8582b = jArr2;
        } else {
            int i2 = length + 1;
            long[] jArr3 = new long[i2];
            this.f8581a = jArr3;
            long[] jArr4 = new long[i2];
            this.f8582b = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.f8583c = j2;
    }

    @Override // androidx.media3.extractor.SeekMap
    public final SeekMap.SeekPoints d(long j2) {
        if (!this.f8584d) {
            SeekPoint seekPoint = SeekPoint.f8604c;
            return new SeekMap.SeekPoints(seekPoint, seekPoint);
        }
        long[] jArr = this.f8582b;
        int iF = Util.f(jArr, j2, true);
        long j3 = jArr[iF];
        long[] jArr2 = this.f8581a;
        SeekPoint seekPoint2 = new SeekPoint(j3, jArr2[iF]);
        if (j3 == j2 || iF == jArr.length - 1) {
            return new SeekMap.SeekPoints(seekPoint2, seekPoint2);
        }
        int i2 = iF + 1;
        return new SeekMap.SeekPoints(seekPoint2, new SeekPoint(jArr[i2], jArr2[i2]));
    }

    @Override // androidx.media3.extractor.SeekMap
    public final boolean g() {
        return this.f8584d;
    }

    @Override // androidx.media3.extractor.SeekMap
    public final long l() {
        return this.f8583c;
    }
}
