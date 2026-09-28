package androidx.media3.exoplayer.source;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;

@UnstableApi
/* loaded from: classes3.dex */
public interface MediaPeriod extends SequenceableLoader {

    public interface Callback extends SequenceableLoader.Callback<MediaPeriod> {
        void j(MediaPeriod mediaPeriod);
    }

    long d(long j2, SeekParameters seekParameters);

    long g(long j2);

    long h(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2);

    long i();

    void l();

    void o(Callback callback, long j2);

    TrackGroupArray p();

    void r(long j2, boolean z);
}
