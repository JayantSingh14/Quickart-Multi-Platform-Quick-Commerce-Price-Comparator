package androidx.media3.exoplayer.source;

import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;

@UnstableApi
/* loaded from: classes3.dex */
public class FilteringMediaSource extends WrappingMediaSource {

    public static final class FilteringMediaPeriod implements MediaPeriod, MediaPeriod.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final MediaPeriod f7569a;

        /* renamed from: b, reason: collision with root package name */
        public MediaPeriod.Callback f7570b;

        /* renamed from: c, reason: collision with root package name */
        public TrackGroupArray f7571c;

        public FilteringMediaPeriod(MediaPeriod mediaPeriod) {
            this.f7569a = mediaPeriod;
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final boolean b() {
            return this.f7569a.b();
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public final long d(long j2, SeekParameters seekParameters) {
            return this.f7569a.d(j2, seekParameters);
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final boolean e(LoadingInfo loadingInfo) {
            return this.f7569a.e(loadingInfo);
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final long f() {
            return this.f7569a.f();
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public final long g(long j2) {
            return this.f7569a.g(j2);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public final long h(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
            return this.f7569a.h(exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j2);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public final long i() {
            return this.f7569a.i();
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
        public final void j(MediaPeriod mediaPeriod) {
            TrackGroupArray trackGroupArrayP = mediaPeriod.p();
            UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
            ImmutableList.Builder builder = new ImmutableList.Builder();
            if (trackGroupArrayP.f7771a > 0) {
                int i2 = trackGroupArrayP.a(0).f5503c;
                throw null;
            }
            this.f7571c = new TrackGroupArray((TrackGroup[]) builder.j().toArray(new TrackGroup[0]));
            MediaPeriod.Callback callback = this.f7570b;
            callback.getClass();
            callback.j(this);
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
        public final void k(SequenceableLoader sequenceableLoader) {
            MediaPeriod.Callback callback = this.f7570b;
            callback.getClass();
            callback.k(this);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public final void l() {
            this.f7569a.l();
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public final void o(MediaPeriod.Callback callback, long j2) {
            this.f7570b = callback;
            this.f7569a.o(this, j2);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public final TrackGroupArray p() {
            TrackGroupArray trackGroupArray = this.f7571c;
            trackGroupArray.getClass();
            return trackGroupArray;
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final long q() {
            return this.f7569a.q();
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public final void r(long j2, boolean z) {
            this.f7569a.r(j2, z);
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final void s(long j2) {
            this.f7569a.s(j2);
        }
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public final MediaPeriod C(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        return new FilteringMediaPeriod(this.f7774k.C(mediaPeriodId, allocator, j2));
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.MediaSource
    public final void J(MediaPeriod mediaPeriod) {
        super.J(((FilteringMediaPeriod) mediaPeriod).f7569a);
    }
}
