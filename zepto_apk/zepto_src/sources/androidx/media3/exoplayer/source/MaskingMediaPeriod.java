package androidx.media3.exoplayer.source;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import java.io.IOException;

@UnstableApi
/* loaded from: classes3.dex */
public final class MaskingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final MediaSource.MediaPeriodId f7585a;

    /* renamed from: b, reason: collision with root package name */
    public final long f7586b;

    /* renamed from: c, reason: collision with root package name */
    public final Allocator f7587c;

    /* renamed from: d, reason: collision with root package name */
    public MediaSource f7588d;

    /* renamed from: e, reason: collision with root package name */
    public MediaPeriod f7589e;

    /* renamed from: f, reason: collision with root package name */
    public MediaPeriod.Callback f7590f;

    /* renamed from: g, reason: collision with root package name */
    public PrepareListener f7591g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f7592h;

    /* renamed from: i, reason: collision with root package name */
    public long f7593i = -9223372036854775807L;

    public interface PrepareListener {
        void a(MediaSource.MediaPeriodId mediaPeriodId, IOException iOException);

        void b(MediaSource.MediaPeriodId mediaPeriodId);
    }

    public MaskingMediaPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        this.f7585a = mediaPeriodId;
        this.f7587c = allocator;
        this.f7586b = j2;
    }

    public final void a(MediaSource.MediaPeriodId mediaPeriodId) {
        long j2 = this.f7593i;
        if (j2 == -9223372036854775807L) {
            j2 = this.f7586b;
        }
        MediaSource mediaSource = this.f7588d;
        mediaSource.getClass();
        MediaPeriod mediaPeriodC = mediaSource.C(mediaPeriodId, this.f7587c, j2);
        this.f7589e = mediaPeriodC;
        if (this.f7590f != null) {
            mediaPeriodC.o(this, j2);
        }
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean b() {
        MediaPeriod mediaPeriod = this.f7589e;
        return mediaPeriod != null && mediaPeriod.b();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long d(long j2, SeekParameters seekParameters) {
        MediaPeriod mediaPeriod = this.f7589e;
        int i2 = Util.f5744a;
        return mediaPeriod.d(j2, seekParameters);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean e(LoadingInfo loadingInfo) {
        MediaPeriod mediaPeriod = this.f7589e;
        return mediaPeriod != null && mediaPeriod.e(loadingInfo);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long f() {
        MediaPeriod mediaPeriod = this.f7589e;
        int i2 = Util.f5744a;
        return mediaPeriod.f();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long g(long j2) {
        MediaPeriod mediaPeriod = this.f7589e;
        int i2 = Util.f5744a;
        return mediaPeriod.g(j2);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long h(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        long j3 = this.f7593i;
        long j4 = (j3 == -9223372036854775807L || j2 != this.f7586b) ? j2 : j3;
        this.f7593i = -9223372036854775807L;
        MediaPeriod mediaPeriod = this.f7589e;
        int i2 = Util.f5744a;
        return mediaPeriod.h(exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j4);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long i() {
        MediaPeriod mediaPeriod = this.f7589e;
        int i2 = Util.f5744a;
        return mediaPeriod.i();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
    public final void j(MediaPeriod mediaPeriod) {
        MediaPeriod.Callback callback = this.f7590f;
        int i2 = Util.f5744a;
        callback.j(this);
        PrepareListener prepareListener = this.f7591g;
        if (prepareListener != null) {
            prepareListener.b(this.f7585a);
        }
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
    public final void k(SequenceableLoader sequenceableLoader) {
        MediaPeriod.Callback callback = this.f7590f;
        int i2 = Util.f5744a;
        callback.k(this);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void l() throws IOException {
        try {
            MediaPeriod mediaPeriod = this.f7589e;
            if (mediaPeriod != null) {
                mediaPeriod.l();
                return;
            }
            MediaSource mediaSource = this.f7588d;
            if (mediaSource != null) {
                mediaSource.V();
            }
        } catch (IOException e2) {
            PrepareListener prepareListener = this.f7591g;
            if (prepareListener == null) {
                throw e2;
            }
            if (this.f7592h) {
                return;
            }
            this.f7592h = true;
            prepareListener.a(this.f7585a, e2);
        }
    }

    public final void n() {
        if (this.f7589e != null) {
            MediaSource mediaSource = this.f7588d;
            mediaSource.getClass();
            mediaSource.J(this.f7589e);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void o(MediaPeriod.Callback callback, long j2) {
        this.f7590f = callback;
        MediaPeriod mediaPeriod = this.f7589e;
        if (mediaPeriod != null) {
            long j3 = this.f7593i;
            if (j3 == -9223372036854775807L) {
                j3 = this.f7586b;
            }
            mediaPeriod.o(this, j3);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final TrackGroupArray p() {
        MediaPeriod mediaPeriod = this.f7589e;
        int i2 = Util.f5744a;
        return mediaPeriod.p();
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long q() {
        MediaPeriod mediaPeriod = this.f7589e;
        int i2 = Util.f5744a;
        return mediaPeriod.q();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void r(long j2, boolean z) {
        MediaPeriod mediaPeriod = this.f7589e;
        int i2 = Util.f5744a;
        mediaPeriod.r(j2, z);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final void s(long j2) {
        MediaPeriod mediaPeriod = this.f7589e;
        int i2 = Util.f5744a;
        mediaPeriod.s(j2);
    }

    public final void t(MediaSource mediaSource) {
        Assertions.g(this.f7588d == null);
        this.f7588d = mediaSource;
    }
}
