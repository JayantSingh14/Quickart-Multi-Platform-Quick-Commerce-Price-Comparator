package androidx.media3.exoplayer.hls;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.mp3.Mp3Extractor;
import androidx.media3.extractor.mp4.FragmentedMp4Extractor;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.ts.Ac3Extractor;
import androidx.media3.extractor.ts.Ac4Extractor;
import androidx.media3.extractor.ts.AdtsExtractor;
import androidx.media3.extractor.ts.TsExtractor;

@UnstableApi
/* loaded from: classes3.dex */
public final class BundledHlsMediaChunkExtractor implements HlsMediaChunkExtractor {

    /* renamed from: f, reason: collision with root package name */
    public static final PositionHolder f6967f = new PositionHolder();

    /* renamed from: a, reason: collision with root package name */
    public final Extractor f6968a;

    /* renamed from: b, reason: collision with root package name */
    public final Format f6969b;

    /* renamed from: c, reason: collision with root package name */
    public final TimestampAdjuster f6970c;

    /* renamed from: d, reason: collision with root package name */
    public final SubtitleParser.Factory f6971d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f6972e;

    public BundledHlsMediaChunkExtractor(Extractor extractor, Format format, TimestampAdjuster timestampAdjuster, SubtitleParser.Factory factory, boolean z) {
        this.f6968a = extractor;
        this.f6969b = format;
        this.f6970c = timestampAdjuster;
        this.f6971d = factory;
        this.f6972e = z;
    }

    @Override // androidx.media3.exoplayer.hls.HlsMediaChunkExtractor
    public final boolean a(DefaultExtractorInput defaultExtractorInput) {
        return this.f6968a.j(defaultExtractorInput, f6967f) == 0;
    }

    @Override // androidx.media3.exoplayer.hls.HlsMediaChunkExtractor
    public final void c(ExtractorOutput extractorOutput) {
        this.f6968a.c(extractorOutput);
    }

    @Override // androidx.media3.exoplayer.hls.HlsMediaChunkExtractor
    public final void d() {
        this.f6968a.a(0L, 0L);
    }

    @Override // androidx.media3.exoplayer.hls.HlsMediaChunkExtractor
    public final boolean e() {
        Extractor extractorE = this.f6968a.e();
        return (extractorE instanceof TsExtractor) || (extractorE instanceof FragmentedMp4Extractor);
    }

    @Override // androidx.media3.exoplayer.hls.HlsMediaChunkExtractor
    public final boolean f() {
        Extractor extractorE = this.f6968a.e();
        return (extractorE instanceof AdtsExtractor) || (extractorE instanceof Ac3Extractor) || (extractorE instanceof Ac4Extractor) || (extractorE instanceof Mp3Extractor);
    }

    @Override // androidx.media3.exoplayer.hls.HlsMediaChunkExtractor
    public final HlsMediaChunkExtractor g() {
        Extractor mp3Extractor;
        Assertions.g(!e());
        Extractor extractor = this.f6968a;
        Assertions.f("Can't recreate wrapped extractors. Outer type: " + extractor.getClass(), extractor.e() == extractor);
        if (extractor instanceof WebvttExtractor) {
            mp3Extractor = new WebvttExtractor(this.f6969b.f5216d, this.f6970c, this.f6971d, this.f6972e);
        } else if (extractor instanceof AdtsExtractor) {
            mp3Extractor = new AdtsExtractor();
        } else if (extractor instanceof Ac3Extractor) {
            mp3Extractor = new Ac3Extractor();
        } else if (extractor instanceof Ac4Extractor) {
            mp3Extractor = new Ac4Extractor();
        } else {
            if (!(extractor instanceof Mp3Extractor)) {
                throw new IllegalStateException("Unexpected extractor type for recreation: ".concat(extractor.getClass().getSimpleName()));
            }
            mp3Extractor = new Mp3Extractor();
        }
        return new BundledHlsMediaChunkExtractor(mp3Extractor, this.f6969b, this.f6970c, this.f6971d, this.f6972e);
    }
}
