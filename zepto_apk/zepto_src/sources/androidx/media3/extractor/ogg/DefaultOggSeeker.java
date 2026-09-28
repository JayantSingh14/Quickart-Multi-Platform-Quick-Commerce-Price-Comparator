package androidx.media3.extractor.ogg;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import java.math.BigInteger;

/* loaded from: classes3.dex */
final class DefaultOggSeeker implements OggSeeker {

    /* renamed from: a, reason: collision with root package name */
    public final OggPageHeader f9102a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9103b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9104c;

    /* renamed from: d, reason: collision with root package name */
    public final StreamReader f9105d;

    /* renamed from: e, reason: collision with root package name */
    public int f9106e;

    /* renamed from: f, reason: collision with root package name */
    public long f9107f;

    /* renamed from: g, reason: collision with root package name */
    public long f9108g;

    /* renamed from: h, reason: collision with root package name */
    public long f9109h;

    /* renamed from: i, reason: collision with root package name */
    public long f9110i;

    /* renamed from: j, reason: collision with root package name */
    public long f9111j;

    /* renamed from: k, reason: collision with root package name */
    public long f9112k;

    /* renamed from: l, reason: collision with root package name */
    public long f9113l;

    public final class OggSeekMap implements SeekMap {
        public OggSeekMap() {
        }

        @Override // androidx.media3.extractor.SeekMap
        public final SeekMap.SeekPoints d(long j2) {
            DefaultOggSeeker defaultOggSeeker = DefaultOggSeeker.this;
            BigInteger bigIntegerValueOf = BigInteger.valueOf((defaultOggSeeker.f9105d.f9142i * j2) / 1000000);
            long j3 = defaultOggSeeker.f9104c;
            long j4 = defaultOggSeeker.f9103b;
            SeekPoint seekPoint = new SeekPoint(j2, Util.l((bigIntegerValueOf.multiply(BigInteger.valueOf(j3 - j4)).divide(BigInteger.valueOf(defaultOggSeeker.f9107f)).longValue() + j4) - 30000, defaultOggSeeker.f9103b, j3 - 1));
            return new SeekMap.SeekPoints(seekPoint, seekPoint);
        }

        @Override // androidx.media3.extractor.SeekMap
        public final boolean g() {
            return true;
        }

        @Override // androidx.media3.extractor.SeekMap
        public final long l() {
            return (DefaultOggSeeker.this.f9107f * 1000000) / r0.f9105d.f9142i;
        }
    }

    public DefaultOggSeeker(StreamReader streamReader, long j2, long j3, long j4, long j5, boolean z) {
        Assertions.a(j2 >= 0 && j3 > j2);
        this.f9105d = streamReader;
        this.f9103b = j2;
        this.f9104c = j3;
        if (j4 == j3 - j2 || z) {
            this.f9107f = j5;
            this.f9106e = 4;
        } else {
            this.f9106e = 0;
        }
        this.f9102a = new OggPageHeader();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c4  */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v5 */
    @Override // androidx.media3.extractor.ogg.OggSeeker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long a(androidx.media3.extractor.DefaultExtractorInput r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ogg.DefaultOggSeeker.a(androidx.media3.extractor.DefaultExtractorInput):long");
    }

    @Override // androidx.media3.extractor.ogg.OggSeeker
    public final SeekMap b() {
        if (this.f9107f != 0) {
            return new OggSeekMap();
        }
        return null;
    }

    @Override // androidx.media3.extractor.ogg.OggSeeker
    public final void c(long j2) {
        this.f9109h = Util.l(j2, 0L, this.f9107f - 1);
        this.f9106e = 2;
        this.f9110i = this.f9103b;
        this.f9111j = this.f9104c;
        this.f9112k = 0L;
        this.f9113l = this.f9107f;
    }
}
