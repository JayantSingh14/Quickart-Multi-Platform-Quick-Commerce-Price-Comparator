package androidx.media3.extractor;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class ChunkIndex implements SeekMap {

    /* renamed from: a, reason: collision with root package name */
    public final int f8503a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f8504b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f8505c;

    /* renamed from: d, reason: collision with root package name */
    public final long[] f8506d;

    /* renamed from: e, reason: collision with root package name */
    public final long[] f8507e;

    /* renamed from: f, reason: collision with root package name */
    public final long f8508f;

    public ChunkIndex(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f8504b = iArr;
        this.f8505c = jArr;
        this.f8506d = jArr2;
        this.f8507e = jArr3;
        int length = iArr.length;
        this.f8503a = length;
        if (length > 0) {
            this.f8508f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f8508f = 0L;
        }
    }

    @Override // androidx.media3.extractor.SeekMap
    public final SeekMap.SeekPoints d(long j2) {
        long[] jArr = this.f8507e;
        int iF = Util.f(jArr, j2, true);
        long j3 = jArr[iF];
        long[] jArr2 = this.f8505c;
        SeekPoint seekPoint = new SeekPoint(j3, jArr2[iF]);
        if (j3 >= j2 || iF == this.f8503a - 1) {
            return new SeekMap.SeekPoints(seekPoint, seekPoint);
        }
        int i2 = iF + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(jArr[i2], jArr2[i2]));
    }

    @Override // androidx.media3.extractor.SeekMap
    public final boolean g() {
        return true;
    }

    @Override // androidx.media3.extractor.SeekMap
    public final long l() {
        return this.f8508f;
    }

    public final String toString() {
        return "ChunkIndex(length=" + this.f8503a + ", sizes=" + Arrays.toString(this.f8504b) + ", offsets=" + Arrays.toString(this.f8505c) + ", timeUs=" + Arrays.toString(this.f8507e) + ", durationsUs=" + Arrays.toString(this.f8506d) + ")";
    }
}
