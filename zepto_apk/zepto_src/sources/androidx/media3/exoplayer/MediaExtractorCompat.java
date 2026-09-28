package androidx.media3.exoplayer;

import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@UnstableApi
/* loaded from: classes3.dex */
public final class MediaExtractorCompat {

    public final class ExtractorOutputImpl implements ExtractorOutput {
        @Override // androidx.media3.extractor.ExtractorOutput
        public final void c(SeekMap seekMap) {
            throw null;
        }

        @Override // androidx.media3.extractor.ExtractorOutput
        public final void m() {
            throw null;
        }

        @Override // androidx.media3.extractor.ExtractorOutput
        public final TrackOutput n(int i2, int i3) {
            throw null;
        }
    }

    public final class MediaExtractorSampleQueue extends SampleQueue {
        @Override // androidx.media3.exoplayer.source.SampleQueue, androidx.media3.extractor.TrackOutput
        public final void f(long j2, int i2, int i3, int i4, TrackOutput.CryptoData cryptoData) {
            throw null;
        }

        @Override // androidx.media3.exoplayer.source.SampleQueue
        public final Format n(Format format) {
            if (s() != null) {
                return super.n(format);
            }
            throw null;
        }

        public final String toString() {
            return "trackId: 0, mainTrackIndex: 0, compatibilityTrackIndex: 0";
        }
    }

    public static final class MediaExtractorTrack {
        public final String toString() {
            throw null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SeekMode {
    }
}
