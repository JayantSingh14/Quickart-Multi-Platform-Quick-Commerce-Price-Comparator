package androidx.media3.exoplayer.source.preload;

import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;

/* loaded from: classes3.dex */
final class PreloadMediaPeriod implements MediaPeriod {

    /* renamed from: a, reason: collision with root package name */
    public final MediaPeriod f7940a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7941b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7942c;

    /* renamed from: d, reason: collision with root package name */
    public MediaPeriod.Callback f7943d;

    /* renamed from: e, reason: collision with root package name */
    public PreloadTrackSelectionHolder f7944e;

    public static class PreloadTrackSelectionHolder {
    }

    public PreloadMediaPeriod(MediaPeriod mediaPeriod) {
        this.f7940a = mediaPeriod;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean b() {
        return this.f7940a.b();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long d(long j2, SeekParameters seekParameters) {
        return this.f7940a.d(j2, seekParameters);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean e(LoadingInfo loadingInfo) {
        return this.f7940a.e(loadingInfo);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long f() {
        return this.f7940a.f();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long g(long j2) {
        return this.f7940a.g(j2);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long h(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        if (this.f7944e == null) {
            return this.f7940a.h(exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j2);
        }
        int length = sampleStreamArr.length;
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long i() {
        return this.f7940a.i();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void l() {
        this.f7940a.l();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void o(MediaPeriod.Callback callback, long j2) {
        this.f7943d = callback;
        if (this.f7942c) {
            callback.j(this);
        } else {
            if (this.f7941b) {
                return;
            }
            this.f7941b = true;
            this.f7940a.o(new MediaPeriod.Callback() { // from class: androidx.media3.exoplayer.source.preload.PreloadMediaPeriod.1
                @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
                public final void j(MediaPeriod mediaPeriod) {
                    PreloadMediaPeriod preloadMediaPeriod = PreloadMediaPeriod.this;
                    preloadMediaPeriod.f7942c = true;
                    MediaPeriod.Callback callback2 = preloadMediaPeriod.f7943d;
                    callback2.getClass();
                    callback2.j(preloadMediaPeriod);
                }

                @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
                public final void k(SequenceableLoader sequenceableLoader) {
                    PreloadMediaPeriod preloadMediaPeriod = PreloadMediaPeriod.this;
                    MediaPeriod.Callback callback2 = preloadMediaPeriod.f7943d;
                    callback2.getClass();
                    callback2.k(preloadMediaPeriod);
                }
            }, j2);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final TrackGroupArray p() {
        return this.f7940a.p();
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long q() {
        return this.f7940a.q();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void r(long j2, boolean z) {
        this.f7940a.r(j2, z);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final void s(long j2) {
        this.f7940a.s(j2);
    }
}
