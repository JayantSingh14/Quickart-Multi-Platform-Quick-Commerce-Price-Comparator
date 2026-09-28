package androidx.media3.exoplayer.source;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;

@UnstableApi
/* loaded from: classes3.dex */
public final class EmptySampleStream implements SampleStream {
    @Override // androidx.media3.exoplayer.source.SampleStream
    public final boolean a() {
        return true;
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public final void c() {
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public final int m(long j2) {
        return 0;
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public final int n(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
        decoderInputBuffer.f6056a = 4;
        return -4;
    }
}
