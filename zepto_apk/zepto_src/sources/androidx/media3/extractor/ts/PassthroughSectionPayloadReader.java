package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;

@UnstableApi
/* loaded from: classes3.dex */
public final class PassthroughSectionPayloadReader implements SectionPayloadReader {

    /* renamed from: a, reason: collision with root package name */
    public Format f9721a;

    /* renamed from: b, reason: collision with root package name */
    public TimestampAdjuster f9722b;

    /* renamed from: c, reason: collision with root package name */
    public TrackOutput f9723c;

    public PassthroughSectionPayloadReader(String str) {
        Format.Builder builder = new Format.Builder();
        builder.f5237l = MimeTypes.p(str);
        this.f9721a = new Format(builder);
    }

    @Override // androidx.media3.extractor.ts.SectionPayloadReader
    public final void a(ParsableByteArray parsableByteArray) {
        long jD;
        long j2;
        Assertions.h(this.f9722b);
        int i2 = Util.f5744a;
        TimestampAdjuster timestampAdjuster = this.f9722b;
        synchronized (timestampAdjuster) {
            try {
                long j3 = timestampAdjuster.f5742c;
                jD = j3 != -9223372036854775807L ? j3 + timestampAdjuster.f5741b : timestampAdjuster.d();
            } finally {
            }
        }
        TimestampAdjuster timestampAdjuster2 = this.f9722b;
        synchronized (timestampAdjuster2) {
            j2 = timestampAdjuster2.f5741b;
        }
        if (jD == -9223372036854775807L || j2 == -9223372036854775807L) {
            return;
        }
        Format format = this.f9721a;
        if (j2 != format.r) {
            Format.Builder builderA = format.a();
            builderA.q = j2;
            Format format2 = new Format(builderA);
            this.f9721a = format2;
            this.f9723c.b(format2);
        }
        int iA = parsableByteArray.a();
        this.f9723c.e(iA, parsableByteArray);
        this.f9723c.f(jD, 1, iA, 0, null);
    }

    @Override // androidx.media3.extractor.ts.SectionPayloadReader
    public final void b(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.f9722b = timestampAdjuster;
        trackIdGenerator.a();
        trackIdGenerator.b();
        TrackOutput trackOutputN = extractorOutput.n(trackIdGenerator.f9813d, 5);
        this.f9723c = trackOutputN;
        trackOutputN.b(this.f9721a);
    }
}
