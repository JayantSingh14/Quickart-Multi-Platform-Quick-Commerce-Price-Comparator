package androidx.media3.extractor.jpeg;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ForwardingSeekMap;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.TrackOutput;

@UnstableApi
/* loaded from: classes3.dex */
public final class StartOffsetExtractorOutput implements ExtractorOutput {

    /* renamed from: a, reason: collision with root package name */
    public final long f8758a;

    /* renamed from: b, reason: collision with root package name */
    public final ExtractorOutput f8759b;

    public StartOffsetExtractorOutput(long j2, ExtractorOutput extractorOutput) {
        this.f8758a = j2;
        this.f8759b = extractorOutput;
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public final void c(final SeekMap seekMap) {
        this.f8759b.c(new ForwardingSeekMap(seekMap) { // from class: androidx.media3.extractor.jpeg.StartOffsetExtractorOutput.1
            @Override // androidx.media3.extractor.ForwardingSeekMap, androidx.media3.extractor.SeekMap
            public final SeekMap.SeekPoints d(long j2) {
                SeekMap.SeekPoints seekPointsD = seekMap.d(j2);
                SeekPoint seekPoint = seekPointsD.f8600a;
                long j3 = seekPoint.f8605a;
                long j4 = StartOffsetExtractorOutput.this.f8758a;
                SeekPoint seekPoint2 = new SeekPoint(j3, seekPoint.f8606b + j4);
                SeekPoint seekPoint3 = seekPointsD.f8601b;
                return new SeekMap.SeekPoints(seekPoint2, new SeekPoint(seekPoint3.f8605a, seekPoint3.f8606b + j4));
            }
        });
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public final void m() {
        this.f8759b.m();
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public final TrackOutput n(int i2, int i3) {
        return this.f8759b.n(i2, i3);
    }
}
