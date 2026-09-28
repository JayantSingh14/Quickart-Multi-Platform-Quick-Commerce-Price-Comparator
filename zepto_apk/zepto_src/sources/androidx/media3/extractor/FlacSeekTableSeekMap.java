package androidx.media3.extractor;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.FlacStreamMetadata;
import androidx.media3.extractor.SeekMap;

@UnstableApi
/* loaded from: classes3.dex */
public final class FlacSeekTableSeekMap implements SeekMap {

    /* renamed from: a, reason: collision with root package name */
    public final FlacStreamMetadata f8549a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8550b;

    public FlacSeekTableSeekMap(FlacStreamMetadata flacStreamMetadata, long j2) {
        this.f8549a = flacStreamMetadata;
        this.f8550b = j2;
    }

    @Override // androidx.media3.extractor.SeekMap
    public final SeekMap.SeekPoints d(long j2) {
        FlacStreamMetadata flacStreamMetadata = this.f8549a;
        Assertions.h(flacStreamMetadata.f8561k);
        FlacStreamMetadata.SeekTable seekTable = flacStreamMetadata.f8561k;
        long[] jArr = seekTable.f8563a;
        int iF = Util.f(jArr, Util.l((flacStreamMetadata.f8555e * j2) / 1000000, 0L, flacStreamMetadata.f8560j - 1), false);
        long j3 = iF == -1 ? 0L : jArr[iF];
        long[] jArr2 = seekTable.f8564b;
        long j4 = iF != -1 ? jArr2[iF] : 0L;
        int i2 = flacStreamMetadata.f8555e;
        long j5 = (j3 * 1000000) / i2;
        long j6 = this.f8550b;
        SeekPoint seekPoint = new SeekPoint(j5, j4 + j6);
        if (j5 == j2 || iF == jArr.length - 1) {
            return new SeekMap.SeekPoints(seekPoint, seekPoint);
        }
        int i3 = iF + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint((jArr[i3] * 1000000) / i2, j6 + jArr2[i3]));
    }

    @Override // androidx.media3.extractor.SeekMap
    public final boolean g() {
        return true;
    }

    @Override // androidx.media3.extractor.SeekMap
    public final long l() {
        return this.f8549a.b();
    }
}
