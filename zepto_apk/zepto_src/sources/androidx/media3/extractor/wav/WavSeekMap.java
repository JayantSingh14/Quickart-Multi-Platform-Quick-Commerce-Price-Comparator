package androidx.media3.extractor.wav;

import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import java.math.RoundingMode;

/* loaded from: classes3.dex */
final class WavSeekMap implements SeekMap {

    /* renamed from: a, reason: collision with root package name */
    public final WavFormat f9852a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9853b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9854c;

    /* renamed from: d, reason: collision with root package name */
    public final long f9855d;

    /* renamed from: e, reason: collision with root package name */
    public final long f9856e;

    public WavSeekMap(WavFormat wavFormat, int i2, long j2, long j3) {
        this.f9852a = wavFormat;
        this.f9853b = i2;
        this.f9854c = j2;
        long j4 = (j3 - j2) / wavFormat.f9847c;
        this.f9855d = j4;
        this.f9856e = a(j4);
    }

    public final long a(long j2) {
        long j3 = j2 * this.f9853b;
        long j4 = this.f9852a.f9846b;
        int i2 = Util.f5744a;
        return Util.b0(j3, 1000000L, j4, RoundingMode.FLOOR);
    }

    @Override // androidx.media3.extractor.SeekMap
    public final SeekMap.SeekPoints d(long j2) {
        WavFormat wavFormat = this.f9852a;
        long j3 = this.f9855d;
        long jL = Util.l((wavFormat.f9846b * j2) / (this.f9853b * 1000000), 0L, j3 - 1);
        long j4 = this.f9854c;
        long jA = a(jL);
        SeekPoint seekPoint = new SeekPoint(jA, (wavFormat.f9847c * jL) + j4);
        if (jA >= j2 || jL == j3 - 1) {
            return new SeekMap.SeekPoints(seekPoint, seekPoint);
        }
        long j5 = jL + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(a(j5), (wavFormat.f9847c * j5) + j4));
    }

    @Override // androidx.media3.extractor.SeekMap
    public final boolean g() {
        return true;
    }

    @Override // androidx.media3.extractor.SeekMap
    public final long l() {
        return this.f9856e;
    }
}
