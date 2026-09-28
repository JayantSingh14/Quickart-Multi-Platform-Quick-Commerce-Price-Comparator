package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.TrackOutput;

@UnstableApi
/* loaded from: classes3.dex */
public final class BaseMediaChunkOutput implements ChunkExtractor.TrackOutputProvider {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f7834a;

    /* renamed from: b, reason: collision with root package name */
    public final SampleQueue[] f7835b;

    public BaseMediaChunkOutput(int[] iArr, SampleQueue[] sampleQueueArr) {
        this.f7834a = iArr;
        this.f7835b = sampleQueueArr;
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkExtractor.TrackOutputProvider
    public final TrackOutput a(int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = this.f7834a;
            if (i3 >= iArr.length) {
                Log.d("BaseMediaChunkOutput", "Unmatched track of type: " + i2);
                return new DiscardingTrackOutput();
            }
            if (i2 == iArr[i3]) {
                return this.f7835b[i3];
            }
            i3++;
        }
    }
}
