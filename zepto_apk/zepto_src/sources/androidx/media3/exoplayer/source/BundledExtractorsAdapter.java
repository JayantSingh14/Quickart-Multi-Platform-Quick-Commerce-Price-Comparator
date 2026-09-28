package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.mp3.Mp3Extractor;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.EOFException;
import java.util.Map;

@UnstableApi
/* loaded from: classes3.dex */
public final class BundledExtractorsAdapter implements ProgressiveMediaExtractor {

    /* renamed from: a, reason: collision with root package name */
    public final ExtractorsFactory f7502a;

    /* renamed from: b, reason: collision with root package name */
    public Extractor f7503b;

    /* renamed from: c, reason: collision with root package name */
    public DefaultExtractorInput f7504c;

    public BundledExtractorsAdapter(ExtractorsFactory extractorsFactory) {
        this.f7502a = extractorsFactory;
    }

    @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor
    public final void a(long j2, long j3) {
        Extractor extractor = this.f7503b;
        extractor.getClass();
        extractor.a(j2, j3);
    }

    @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor
    public final void b() {
        Extractor extractor = this.f7503b;
        if (extractor == null) {
            return;
        }
        Extractor extractorE = extractor.e();
        if (extractorE instanceof Mp3Extractor) {
            ((Mp3Extractor) extractorE).q = true;
        }
    }

    @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor
    public final long c() {
        DefaultExtractorInput defaultExtractorInput = this.f7504c;
        if (defaultExtractorInput != null) {
            return defaultExtractorInput.f8519d;
        }
        return -1L;
    }

    @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor
    public final int d(PositionHolder positionHolder) {
        Extractor extractor = this.f7503b;
        extractor.getClass();
        DefaultExtractorInput defaultExtractorInput = this.f7504c;
        defaultExtractorInput.getClass();
        return extractor.j(defaultExtractorInput, positionHolder);
    }

    @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor
    public final void e(DataSource dataSource, Uri uri, Map map, long j2, long j3, ExtractorOutput extractorOutput) throws UnrecognizedInputFormatException {
        boolean z;
        DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(dataSource, j2, j3);
        this.f7504c = defaultExtractorInput;
        if (this.f7503b != null) {
            return;
        }
        Extractor[] extractorArrD = this.f7502a.d(uri, map);
        ImmutableList.Builder builderN = ImmutableList.n(extractorArrD.length);
        boolean z2 = true;
        if (extractorArrD.length == 1) {
            this.f7503b = extractorArrD[0];
        } else {
            int length = extractorArrD.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Extractor extractor = extractorArrD[i2];
                try {
                } catch (EOFException unused) {
                    z = this.f7503b != null || defaultExtractorInput.f8519d == j2;
                } catch (Throwable th) {
                    if (this.f7503b == null && defaultExtractorInput.f8519d != j2) {
                        z2 = false;
                    }
                    Assertions.g(z2);
                    defaultExtractorInput.f8521f = 0;
                    throw th;
                }
                if (extractor.h(defaultExtractorInput)) {
                    this.f7503b = extractor;
                    defaultExtractorInput.f8521f = 0;
                    break;
                } else {
                    builderN.f(extractor.i());
                    z = this.f7503b != null || defaultExtractorInput.f8519d == j2;
                    Assertions.g(z);
                    defaultExtractorInput.f8521f = 0;
                    i2++;
                }
            }
            if (this.f7503b == null) {
                String str = "None of the available extractors (" + new Joiner(", ").c(Lists.d(new l(1), ImmutableList.p(extractorArrD))) + ") could read the stream.";
                uri.getClass();
                ImmutableList immutableListJ = builderN.j();
                UnrecognizedInputFormatException unrecognizedInputFormatException = new UnrecognizedInputFormatException(str, null, false, 1);
                ImmutableList.o(immutableListJ);
                throw unrecognizedInputFormatException;
            }
        }
        this.f7503b.c(extractorOutput);
    }

    @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor
    public final void release() {
        Extractor extractor = this.f7503b;
        if (extractor != null) {
            extractor.release();
            this.f7503b = null;
        }
        this.f7504c = null;
    }
}
