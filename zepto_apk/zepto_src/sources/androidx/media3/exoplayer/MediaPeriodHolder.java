package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.source.ClippingMediaPeriod;
import androidx.media3.exoplayer.source.EmptySampleStream;
import androidx.media3.exoplayer.source.MaskingMediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import androidx.media3.exoplayer.upstream.Allocator;

/* loaded from: classes3.dex */
final class MediaPeriodHolder {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6267a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6268b;

    /* renamed from: c, reason: collision with root package name */
    public final SampleStream[] f6269c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6270d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6271e;

    /* renamed from: f, reason: collision with root package name */
    public MediaPeriodInfo f6272f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f6273g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean[] f6274h;

    /* renamed from: i, reason: collision with root package name */
    public final RendererCapabilities[] f6275i;

    /* renamed from: j, reason: collision with root package name */
    public final TrackSelector f6276j;

    /* renamed from: k, reason: collision with root package name */
    public final MediaSourceList f6277k;

    /* renamed from: l, reason: collision with root package name */
    public MediaPeriodHolder f6278l;

    /* renamed from: m, reason: collision with root package name */
    public TrackGroupArray f6279m;
    public TrackSelectorResult n;
    public long o;

    public interface Factory {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6, types: [androidx.media3.exoplayer.source.ClippingMediaPeriod] */
    public MediaPeriodHolder(RendererCapabilities[] rendererCapabilitiesArr, long j2, TrackSelector trackSelector, Allocator allocator, MediaSourceList mediaSourceList, MediaPeriodInfo mediaPeriodInfo, TrackSelectorResult trackSelectorResult) {
        this.f6275i = rendererCapabilitiesArr;
        this.o = j2;
        this.f6276j = trackSelector;
        this.f6277k = mediaSourceList;
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.f6280a;
        this.f6268b = mediaPeriodId.f7609a;
        this.f6272f = mediaPeriodInfo;
        this.f6279m = TrackGroupArray.f7769d;
        this.n = trackSelectorResult;
        this.f6269c = new SampleStream[rendererCapabilitiesArr.length];
        this.f6274h = new boolean[rendererCapabilitiesArr.length];
        mediaSourceList.getClass();
        int i2 = AbstractConcatenatedTimeline.f6093g;
        Pair pair = (Pair) mediaPeriodId.f7609a;
        Object obj = pair.first;
        MediaSource.MediaPeriodId mediaPeriodIdA = mediaPeriodId.a(pair.second);
        MediaSourceList.MediaSourceHolder mediaSourceHolder = (MediaSourceList.MediaSourceHolder) mediaSourceList.f6305d.get(obj);
        mediaSourceHolder.getClass();
        mediaSourceList.f6308g.add(mediaSourceHolder);
        MediaSourceList.MediaSourceAndListener mediaSourceAndListener = (MediaSourceList.MediaSourceAndListener) mediaSourceList.f6307f.get(mediaSourceHolder);
        if (mediaSourceAndListener != null) {
            mediaSourceAndListener.f6316a.N(mediaSourceAndListener.f6317b);
        }
        mediaSourceHolder.f6321c.add(mediaPeriodIdA);
        MaskingMediaPeriod maskingMediaPeriodC = mediaSourceHolder.f6319a.C(mediaPeriodIdA, allocator, mediaPeriodInfo.f6281b);
        mediaSourceList.f6304c.put(maskingMediaPeriodC, mediaSourceHolder);
        mediaSourceList.c();
        long j3 = mediaPeriodInfo.f6283d;
        this.f6267a = j3 != -9223372036854775807L ? new ClippingMediaPeriod(maskingMediaPeriodC, true, 0L, j3) : maskingMediaPeriodC;
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [androidx.media3.exoplayer.source.MediaPeriod, java.lang.Object] */
    public final long a(TrackSelectorResult trackSelectorResult, long j2, boolean z, boolean[] zArr) {
        RendererCapabilities[] rendererCapabilitiesArr;
        SampleStream[] sampleStreamArr;
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= trackSelectorResult.f8039a) {
                break;
            }
            if (z || !trackSelectorResult.a(this.n, i2)) {
                z2 = false;
            }
            this.f6274h[i2] = z2;
            i2++;
        }
        int i3 = 0;
        while (true) {
            rendererCapabilitiesArr = this.f6275i;
            int length = rendererCapabilitiesArr.length;
            sampleStreamArr = this.f6269c;
            if (i3 >= length) {
                break;
            }
            if (rendererCapabilitiesArr[i3].g() == -2) {
                sampleStreamArr[i3] = null;
            }
            i3++;
        }
        b();
        this.n = trackSelectorResult;
        c();
        long jH = this.f6267a.h(trackSelectorResult.f8041c, this.f6274h, this.f6269c, zArr, j2);
        for (int i4 = 0; i4 < rendererCapabilitiesArr.length; i4++) {
            if (rendererCapabilitiesArr[i4].g() == -2 && this.n.b(i4)) {
                sampleStreamArr[i4] = new EmptySampleStream();
            }
        }
        this.f6271e = false;
        for (int i5 = 0; i5 < sampleStreamArr.length; i5++) {
            if (sampleStreamArr[i5] != null) {
                Assertions.g(trackSelectorResult.b(i5));
                if (rendererCapabilitiesArr[i5].g() != -2) {
                    this.f6271e = true;
                }
            } else {
                Assertions.g(trackSelectorResult.f8041c[i5] == null);
            }
        }
        return jH;
    }

    public final void b() {
        if (this.f6278l != null) {
            return;
        }
        int i2 = 0;
        while (true) {
            TrackSelectorResult trackSelectorResult = this.n;
            if (i2 >= trackSelectorResult.f8039a) {
                return;
            }
            boolean zB = trackSelectorResult.b(i2);
            ExoTrackSelection exoTrackSelection = this.n.f8041c[i2];
            if (zB && exoTrackSelection != null) {
                exoTrackSelection.disable();
            }
            i2++;
        }
    }

    public final void c() {
        if (this.f6278l != null) {
            return;
        }
        int i2 = 0;
        while (true) {
            TrackSelectorResult trackSelectorResult = this.n;
            if (i2 >= trackSelectorResult.f8039a) {
                return;
            }
            boolean zB = trackSelectorResult.b(i2);
            ExoTrackSelection exoTrackSelection = this.n.f8041c[i2];
            if (zB && exoTrackSelection != null) {
                exoTrackSelection.enable();
            }
            i2++;
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.media3.exoplayer.source.SequenceableLoader, java.lang.Object] */
    public final long d() {
        if (!this.f6270d) {
            return this.f6272f.f6281b;
        }
        long jQ = this.f6271e ? this.f6267a.q() : Long.MIN_VALUE;
        return jQ == Long.MIN_VALUE ? this.f6272f.f6284e : jQ;
    }

    public final long e() {
        return this.f6272f.f6281b + this.o;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.media3.exoplayer.source.SequenceableLoader, java.lang.Object] */
    public final boolean f() {
        if (this.f6270d) {
            return !this.f6271e || this.f6267a.q() == Long.MIN_VALUE;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.media3.exoplayer.source.MediaPeriod, java.lang.Object] */
    public final void g() {
        b();
        ?? r0 = this.f6267a;
        try {
            boolean z = r0 instanceof ClippingMediaPeriod;
            MediaSourceList mediaSourceList = this.f6277k;
            if (z) {
                mediaSourceList.f(((ClippingMediaPeriod) r0).f7505a);
            } else {
                mediaSourceList.f(r0);
            }
        } catch (RuntimeException e2) {
            Log.e("MediaPeriodHolder", "Period release failed.", e2);
        }
    }

    public final TrackSelectorResult h(float f2, Timeline timeline) {
        ExoTrackSelection[] exoTrackSelectionArr;
        TrackGroupArray trackGroupArray = this.f6279m;
        MediaPeriodInfo mediaPeriodInfo = this.f6272f;
        TrackSelector trackSelector = this.f6276j;
        RendererCapabilities[] rendererCapabilitiesArr = this.f6275i;
        TrackSelectorResult trackSelectorResultF = trackSelector.f(rendererCapabilitiesArr, trackGroupArray, mediaPeriodInfo.f6280a, timeline);
        int i2 = 0;
        while (true) {
            int i3 = trackSelectorResultF.f8039a;
            exoTrackSelectionArr = trackSelectorResultF.f8041c;
            if (i2 >= i3) {
                break;
            }
            if (trackSelectorResultF.b(i2)) {
                if (exoTrackSelectionArr[i2] == null && rendererCapabilitiesArr[i2].g() != -2) {
                    z = false;
                }
                Assertions.g(z);
            } else {
                Assertions.g(exoTrackSelectionArr[i2] == null);
            }
            i2++;
        }
        for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
            if (exoTrackSelection != null) {
                exoTrackSelection.i(f2);
            }
        }
        return trackSelectorResultF;
    }

    public final void i() {
        Object obj = this.f6267a;
        if (obj instanceof ClippingMediaPeriod) {
            long j2 = this.f6272f.f6283d;
            if (j2 == -9223372036854775807L) {
                j2 = Long.MIN_VALUE;
            }
            ClippingMediaPeriod clippingMediaPeriod = (ClippingMediaPeriod) obj;
            clippingMediaPeriod.f7509e = 0L;
            clippingMediaPeriod.f7510f = j2;
        }
    }
}
