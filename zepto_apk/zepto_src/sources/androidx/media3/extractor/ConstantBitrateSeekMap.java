package androidx.media3.extractor;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.SeekMap;

@UnstableApi
/* loaded from: classes3.dex */
public class ConstantBitrateSeekMap implements SeekMap {

    /* renamed from: a, reason: collision with root package name */
    public final long f8509a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8510b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8511c;

    /* renamed from: d, reason: collision with root package name */
    public final long f8512d;

    /* renamed from: e, reason: collision with root package name */
    public final int f8513e;

    /* renamed from: f, reason: collision with root package name */
    public final long f8514f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f8515g;

    public ConstantBitrateSeekMap(long j2, long j3, int i2, int i3, boolean z) {
        this.f8509a = j2;
        this.f8510b = j3;
        this.f8511c = i3 == -1 ? 1 : i3;
        this.f8513e = i2;
        this.f8515g = z;
        if (j2 == -1) {
            this.f8512d = -1L;
            this.f8514f = -9223372036854775807L;
        } else {
            long j4 = j2 - j3;
            this.f8512d = j4;
            this.f8514f = (Math.max(0L, j4) * 8000000) / i2;
        }
    }

    @Override // androidx.media3.extractor.SeekMap
    public final SeekMap.SeekPoints d(long j2) {
        long j3 = this.f8512d;
        long j4 = this.f8510b;
        if (j3 == -1 && !this.f8515g) {
            SeekPoint seekPoint = new SeekPoint(0L, j4);
            return new SeekMap.SeekPoints(seekPoint, seekPoint);
        }
        int i2 = this.f8513e;
        long j5 = this.f8511c;
        long jMin = (((i2 * j2) / 8000000) / j5) * j5;
        if (j3 != -1) {
            jMin = Math.min(jMin, j3 - j5);
        }
        long jMax = Math.max(jMin, 0L) + j4;
        long jMax2 = (Math.max(0L, jMax - j4) * 8000000) / i2;
        SeekPoint seekPoint2 = new SeekPoint(jMax2, jMax);
        if (j3 != -1 && jMax2 < j2) {
            long j6 = jMax + j5;
            if (j6 < this.f8509a) {
                return new SeekMap.SeekPoints(seekPoint2, new SeekPoint((Math.max(0L, j6 - j4) * 8000000) / i2, j6));
            }
        }
        return new SeekMap.SeekPoints(seekPoint2, seekPoint2);
    }

    @Override // androidx.media3.extractor.SeekMap
    public final boolean g() {
        return this.f8512d != -1 || this.f8515g;
    }

    @Override // androidx.media3.extractor.SeekMap
    public final long l() {
        return this.f8514f;
    }
}
