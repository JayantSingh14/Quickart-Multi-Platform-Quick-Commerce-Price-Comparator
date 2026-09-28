package androidx.media3.extractor.avi;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.NoOpExtractorOutput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
/* loaded from: classes3.dex */
public final class AviExtractor implements Extractor {

    /* renamed from: a, reason: collision with root package name */
    public final ParsableByteArray f8651a;

    /* renamed from: b, reason: collision with root package name */
    public final ChunkHeaderHolder f8652b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f8653c;

    /* renamed from: d, reason: collision with root package name */
    public final SubtitleParser.Factory f8654d;

    /* renamed from: e, reason: collision with root package name */
    public int f8655e;

    /* renamed from: f, reason: collision with root package name */
    public ExtractorOutput f8656f;

    /* renamed from: g, reason: collision with root package name */
    public AviMainHeaderChunk f8657g;

    /* renamed from: h, reason: collision with root package name */
    public long f8658h;

    /* renamed from: i, reason: collision with root package name */
    public ChunkReader[] f8659i;

    /* renamed from: j, reason: collision with root package name */
    public long f8660j;

    /* renamed from: k, reason: collision with root package name */
    public ChunkReader f8661k;

    /* renamed from: l, reason: collision with root package name */
    public int f8662l;

    /* renamed from: m, reason: collision with root package name */
    public long f8663m;
    public long n;
    public int o;
    public boolean p;

    public class AviSeekMap implements SeekMap {

        /* renamed from: a, reason: collision with root package name */
        public final long f8664a;

        public AviSeekMap(long j2) {
            this.f8664a = j2;
        }

        @Override // androidx.media3.extractor.SeekMap
        public final SeekMap.SeekPoints d(long j2) {
            AviExtractor aviExtractor = AviExtractor.this;
            SeekMap.SeekPoints seekPointsB = aviExtractor.f8659i[0].b(j2);
            int i2 = 1;
            while (true) {
                ChunkReader[] chunkReaderArr = aviExtractor.f8659i;
                if (i2 >= chunkReaderArr.length) {
                    return seekPointsB;
                }
                SeekMap.SeekPoints seekPointsB2 = chunkReaderArr[i2].b(j2);
                if (seekPointsB2.f8600a.f8606b < seekPointsB.f8600a.f8606b) {
                    seekPointsB = seekPointsB2;
                }
                i2++;
            }
        }

        @Override // androidx.media3.extractor.SeekMap
        public final boolean g() {
            return true;
        }

        @Override // androidx.media3.extractor.SeekMap
        public final long l() {
            return this.f8664a;
        }
    }

    public static class ChunkHeaderHolder {

        /* renamed from: a, reason: collision with root package name */
        public int f8666a;

        /* renamed from: b, reason: collision with root package name */
        public int f8667b;

        /* renamed from: c, reason: collision with root package name */
        public int f8668c;
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @Deprecated
    public AviExtractor() {
        this(1, SubtitleParser.Factory.f9179a);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void a(long j2, long j3) {
        this.f8660j = -1L;
        this.f8661k = null;
        for (ChunkReader chunkReader : this.f8659i) {
            if (chunkReader.f8686j == 0) {
                chunkReader.f8684h = 0;
            } else {
                chunkReader.f8684h = chunkReader.f8688l[Util.f(chunkReader.f8687k, j2, true)];
            }
        }
        if (j2 != 0) {
            this.f8655e = 6;
        } else if (this.f8659i.length == 0) {
            this.f8655e = 0;
        } else {
            this.f8655e = 3;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final void c(ExtractorOutput extractorOutput) {
        this.f8655e = 0;
        if (this.f8653c) {
            extractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.f8654d);
        }
        this.f8656f = extractorOutput;
        this.f8660j = -1L;
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean h(ExtractorInput extractorInput) {
        ParsableByteArray parsableByteArray = this.f8651a;
        ((DefaultExtractorInput) extractorInput).b(parsableByteArray.f5723a, 0, 12, false);
        parsableByteArray.J(0);
        if (parsableByteArray.l() == 1179011410) {
            parsableByteArray.K(4);
            if (parsableByteArray.l() == 541677121) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:159:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0110  */
    @Override // androidx.media3.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int j(androidx.media3.extractor.ExtractorInput r30, androidx.media3.extractor.PositionHolder r31) throws androidx.media3.common.ParserException, java.io.EOFException, java.io.InterruptedIOException {
        /*
            Method dump skipped, instructions count: 1092
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.avi.AviExtractor.j(androidx.media3.extractor.ExtractorInput, androidx.media3.extractor.PositionHolder):int");
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }

    public AviExtractor(int i2, SubtitleParser.Factory factory) {
        this.f8654d = factory;
        this.f8653c = (i2 & 1) == 0;
        this.f8651a = new ParsableByteArray(12);
        this.f8652b = new ChunkHeaderHolder();
        this.f8656f = new NoOpExtractorOutput();
        this.f8659i = new ChunkReader[0];
        this.f8663m = -1L;
        this.n = -1L;
        this.f8662l = -1;
        this.f8658h = -9223372036854775807L;
    }
}
