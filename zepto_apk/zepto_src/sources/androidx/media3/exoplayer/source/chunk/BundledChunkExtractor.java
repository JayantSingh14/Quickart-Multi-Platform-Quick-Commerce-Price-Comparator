package androidx.media3.exoplayer.source.chunk;

import android.util.SparseArray;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;

@UnstableApi
/* loaded from: classes3.dex */
public final class BundledChunkExtractor implements ExtractorOutput, ChunkExtractor {

    /* renamed from: j, reason: collision with root package name */
    public static final Factory f7836j = new Factory();

    /* renamed from: k, reason: collision with root package name */
    public static final PositionHolder f7837k = new PositionHolder();

    /* renamed from: a, reason: collision with root package name */
    public final Extractor f7838a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7839b;

    /* renamed from: c, reason: collision with root package name */
    public final Format f7840c;

    /* renamed from: d, reason: collision with root package name */
    public final SparseArray f7841d = new SparseArray();

    /* renamed from: e, reason: collision with root package name */
    public boolean f7842e;

    /* renamed from: f, reason: collision with root package name */
    public ChunkExtractor.TrackOutputProvider f7843f;

    /* renamed from: g, reason: collision with root package name */
    public long f7844g;

    /* renamed from: h, reason: collision with root package name */
    public SeekMap f7845h;

    /* renamed from: i, reason: collision with root package name */
    public Format[] f7846i;

    public static final class BindingTrackOutput implements TrackOutput {

        /* renamed from: a, reason: collision with root package name */
        public final int f7847a;

        /* renamed from: b, reason: collision with root package name */
        public final Format f7848b;

        /* renamed from: c, reason: collision with root package name */
        public final DiscardingTrackOutput f7849c = new DiscardingTrackOutput();

        /* renamed from: d, reason: collision with root package name */
        public Format f7850d;

        /* renamed from: e, reason: collision with root package name */
        public TrackOutput f7851e;

        /* renamed from: f, reason: collision with root package name */
        public long f7852f;

        public BindingTrackOutput(int i2, int i3, Format format) {
            this.f7847a = i3;
            this.f7848b = format;
        }

        @Override // androidx.media3.extractor.TrackOutput
        public final void a(ParsableByteArray parsableByteArray, int i2, int i3) {
            TrackOutput trackOutput = this.f7851e;
            int i4 = Util.f5744a;
            trackOutput.e(i2, parsableByteArray);
        }

        @Override // androidx.media3.extractor.TrackOutput
        public final void b(Format format) {
            Format format2 = this.f7848b;
            if (format2 != null) {
                format = format.e(format2);
            }
            this.f7850d = format;
            TrackOutput trackOutput = this.f7851e;
            int i2 = Util.f5744a;
            trackOutput.b(format);
        }

        @Override // androidx.media3.extractor.TrackOutput
        public final int d(DataReader dataReader, int i2, boolean z) {
            TrackOutput trackOutput = this.f7851e;
            int i3 = Util.f5744a;
            return trackOutput.c(dataReader, i2, z);
        }

        @Override // androidx.media3.extractor.TrackOutput
        public final void f(long j2, int i2, int i3, int i4, TrackOutput.CryptoData cryptoData) {
            long j3 = this.f7852f;
            if (j3 != -9223372036854775807L && j2 >= j3) {
                this.f7851e = this.f7849c;
            }
            TrackOutput trackOutput = this.f7851e;
            int i5 = Util.f5744a;
            trackOutput.f(j2, i2, i3, i4, cryptoData);
        }
    }

    public static final class Factory implements ChunkExtractor.Factory {

        /* renamed from: a, reason: collision with root package name */
        public DefaultSubtitleParserFactory f7853a = new DefaultSubtitleParserFactory();

        /* renamed from: b, reason: collision with root package name */
        public boolean f7854b;
    }

    public BundledChunkExtractor(Extractor extractor, int i2, Format format) {
        this.f7838a = extractor;
        this.f7839b = i2;
        this.f7840c = format;
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkExtractor
    public final boolean a(DefaultExtractorInput defaultExtractorInput) {
        int iJ = this.f7838a.j(defaultExtractorInput, f7837k);
        Assertions.g(iJ != 1);
        return iJ == 0;
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkExtractor
    public final ChunkIndex b() {
        SeekMap seekMap = this.f7845h;
        if (seekMap instanceof ChunkIndex) {
            return (ChunkIndex) seekMap;
        }
        return null;
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public final void c(SeekMap seekMap) {
        this.f7845h = seekMap;
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkExtractor
    public final Format[] d() {
        return this.f7846i;
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkExtractor
    public final void e(ChunkExtractor.TrackOutputProvider trackOutputProvider, long j2, long j3) {
        this.f7843f = trackOutputProvider;
        this.f7844g = j3;
        boolean z = this.f7842e;
        Extractor extractor = this.f7838a;
        if (!z) {
            extractor.c(this);
            if (j2 != -9223372036854775807L) {
                extractor.a(0L, j2);
            }
            this.f7842e = true;
            return;
        }
        if (j2 == -9223372036854775807L) {
            j2 = 0;
        }
        extractor.a(0L, j2);
        int i2 = 0;
        while (true) {
            SparseArray sparseArray = this.f7841d;
            if (i2 >= sparseArray.size()) {
                return;
            }
            BindingTrackOutput bindingTrackOutput = (BindingTrackOutput) sparseArray.valueAt(i2);
            if (trackOutputProvider == null) {
                bindingTrackOutput.f7851e = bindingTrackOutput.f7849c;
            } else {
                bindingTrackOutput.f7852f = j3;
                TrackOutput trackOutputA = trackOutputProvider.a(bindingTrackOutput.f7847a);
                bindingTrackOutput.f7851e = trackOutputA;
                Format format = bindingTrackOutput.f7850d;
                if (format != null) {
                    trackOutputA.b(format);
                }
            }
            i2++;
        }
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public final void m() {
        SparseArray sparseArray = this.f7841d;
        Format[] formatArr = new Format[sparseArray.size()];
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            Format format = ((BindingTrackOutput) sparseArray.valueAt(i2)).f7850d;
            Assertions.h(format);
            formatArr[i2] = format;
        }
        this.f7846i = formatArr;
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public final TrackOutput n(int i2, int i3) {
        SparseArray sparseArray = this.f7841d;
        BindingTrackOutput bindingTrackOutput = (BindingTrackOutput) sparseArray.get(i2);
        if (bindingTrackOutput == null) {
            Assertions.g(this.f7846i == null);
            bindingTrackOutput = new BindingTrackOutput(i2, i3, i3 == this.f7839b ? this.f7840c : null);
            ChunkExtractor.TrackOutputProvider trackOutputProvider = this.f7843f;
            long j2 = this.f7844g;
            if (trackOutputProvider == null) {
                bindingTrackOutput.f7851e = bindingTrackOutput.f7849c;
            } else {
                bindingTrackOutput.f7852f = j2;
                TrackOutput trackOutputA = trackOutputProvider.a(i3);
                bindingTrackOutput.f7851e = trackOutputA;
                Format format = bindingTrackOutput.f7850d;
                if (format != null) {
                    trackOutputA.b(format);
                }
            }
            sparseArray.put(i2, bindingTrackOutput);
        }
        return bindingTrackOutput;
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkExtractor
    public final void release() {
        this.f7838a.release();
    }
}
