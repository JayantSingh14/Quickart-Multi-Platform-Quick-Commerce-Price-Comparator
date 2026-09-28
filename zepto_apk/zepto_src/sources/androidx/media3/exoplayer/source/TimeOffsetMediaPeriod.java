package androidx.media3.exoplayer.source;

import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;

/* loaded from: classes3.dex */
final class TimeOffsetMediaPeriod implements MediaPeriod, MediaPeriod.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final MediaPeriod f7763a;

    /* renamed from: b, reason: collision with root package name */
    public final long f7764b;

    /* renamed from: c, reason: collision with root package name */
    public MediaPeriod.Callback f7765c;

    public static final class TimeOffsetSampleStream implements SampleStream {

        /* renamed from: a, reason: collision with root package name */
        public final SampleStream f7766a;

        /* renamed from: b, reason: collision with root package name */
        public final long f7767b;

        public TimeOffsetSampleStream(SampleStream sampleStream, long j2) {
            this.f7766a = sampleStream;
            this.f7767b = j2;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final boolean a() {
            return this.f7766a.a();
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final void c() {
            this.f7766a.c();
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final int m(long j2) {
            return this.f7766a.m(j2 - this.f7767b);
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final int n(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            int iN = this.f7766a.n(formatHolder, decoderInputBuffer, i2);
            if (iN == -4) {
                decoderInputBuffer.f6073f += this.f7767b;
            }
            return iN;
        }
    }

    public TimeOffsetMediaPeriod(MediaPeriod mediaPeriod, long j2) {
        this.f7763a = mediaPeriod;
        this.f7764b = j2;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean b() {
        return this.f7763a.b();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long d(long j2, SeekParameters seekParameters) {
        long j3 = this.f7764b;
        return this.f7763a.d(j2 - j3, seekParameters) + j3;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean e(LoadingInfo loadingInfo) {
        LoadingInfo.Builder builder = new LoadingInfo.Builder();
        builder.f6265b = loadingInfo.f6262b;
        builder.f6266c = loadingInfo.f6263c;
        builder.f6264a = loadingInfo.f6261a - this.f7764b;
        return this.f7763a.e(new LoadingInfo(builder));
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long f() {
        long jF = this.f7763a.f();
        if (jF == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jF + this.f7764b;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long g(long j2) {
        long j3 = this.f7764b;
        return this.f7763a.g(j2 - j3) + j3;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long h(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        SampleStream[] sampleStreamArr2 = new SampleStream[sampleStreamArr.length];
        int i2 = 0;
        while (true) {
            SampleStream sampleStream = null;
            if (i2 >= sampleStreamArr.length) {
                break;
            }
            TimeOffsetSampleStream timeOffsetSampleStream = (TimeOffsetSampleStream) sampleStreamArr[i2];
            if (timeOffsetSampleStream != null) {
                sampleStream = timeOffsetSampleStream.f7766a;
            }
            sampleStreamArr2[i2] = sampleStream;
            i2++;
        }
        long j3 = this.f7764b;
        long jH = this.f7763a.h(exoTrackSelectionArr, zArr, sampleStreamArr2, zArr2, j2 - j3);
        for (int i3 = 0; i3 < sampleStreamArr.length; i3++) {
            SampleStream sampleStream2 = sampleStreamArr2[i3];
            if (sampleStream2 == null) {
                sampleStreamArr[i3] = null;
            } else {
                SampleStream sampleStream3 = sampleStreamArr[i3];
                if (sampleStream3 == null || ((TimeOffsetSampleStream) sampleStream3).f7766a != sampleStream2) {
                    sampleStreamArr[i3] = new TimeOffsetSampleStream(sampleStream2, j3);
                }
            }
        }
        return jH + j3;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long i() {
        long jI = this.f7763a.i();
        if (jI == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return jI + this.f7764b;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
    public final void j(MediaPeriod mediaPeriod) {
        MediaPeriod.Callback callback = this.f7765c;
        callback.getClass();
        callback.j(this);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
    public final void k(SequenceableLoader sequenceableLoader) {
        MediaPeriod.Callback callback = this.f7765c;
        callback.getClass();
        callback.k(this);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void l() {
        this.f7763a.l();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void o(MediaPeriod.Callback callback, long j2) {
        this.f7765c = callback;
        this.f7763a.o(this, j2 - this.f7764b);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final TrackGroupArray p() {
        return this.f7763a.p();
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long q() {
        long jQ = this.f7763a.q();
        if (jQ == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jQ + this.f7764b;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void r(long j2, boolean z) {
        this.f7763a.r(j2 - this.f7764b, z);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final void s(long j2) {
        this.f7763a.s(j2 - this.f7764b);
    }
}
