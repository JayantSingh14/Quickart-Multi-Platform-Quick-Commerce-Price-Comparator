package androidx.media3.extractor;

import android.support.v4.media.a;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public final class SingleSampleExtractor implements Extractor {

    /* renamed from: a, reason: collision with root package name */
    public final int f8607a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8608b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8609c;

    /* renamed from: d, reason: collision with root package name */
    public int f8610d;

    /* renamed from: e, reason: collision with root package name */
    public int f8611e;

    /* renamed from: f, reason: collision with root package name */
    public ExtractorOutput f8612f;

    /* renamed from: g, reason: collision with root package name */
    public TrackOutput f8613g;

    public SingleSampleExtractor(int i2, int i3, String str) {
        this.f8607a = i2;
        this.f8608b = i3;
        this.f8609c = str;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void a(long j2, long j3) {
        if (j2 == 0 || this.f8611e == 1) {
            this.f8611e = 1;
            this.f8610d = 0;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final void c(ExtractorOutput extractorOutput) {
        this.f8612f = extractorOutput;
        TrackOutput trackOutputN = extractorOutput.n(1024, 4);
        this.f8613g = trackOutputN;
        Format.Builder builder = new Format.Builder();
        builder.f5237l = MimeTypes.p(this.f8609c);
        a.s(builder, trackOutputN);
        this.f8612f.m();
        this.f8612f.c(new SingleSampleSeekMap());
        this.f8611e = 1;
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean h(ExtractorInput extractorInput) {
        int i2 = this.f8608b;
        int i3 = this.f8607a;
        Assertions.g((i3 == -1 || i2 == -1) ? false : true);
        ParsableByteArray parsableByteArray = new ParsableByteArray(i2);
        ((DefaultExtractorInput) extractorInput).b(parsableByteArray.f5723a, 0, i2, false);
        return parsableByteArray.D() == i3;
    }

    @Override // androidx.media3.extractor.Extractor
    public final int j(ExtractorInput extractorInput, PositionHolder positionHolder) {
        int i2 = this.f8611e;
        if (i2 != 1) {
            if (i2 == 2) {
                return -1;
            }
            throw new IllegalStateException();
        }
        TrackOutput trackOutput = this.f8613g;
        trackOutput.getClass();
        int iC = trackOutput.c(extractorInput, 1024, true);
        if (iC != -1) {
            this.f8610d += iC;
            return 0;
        }
        this.f8611e = 2;
        this.f8613g.f(0L, 1, this.f8610d, 0, null);
        this.f8610d = 0;
        return 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
