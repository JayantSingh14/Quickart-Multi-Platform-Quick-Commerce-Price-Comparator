package androidx.media3.exoplayer.source.ads;

import android.util.Pair;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.BaseMediaSource;
import androidx.media3.exoplayer.source.EmptySampleStream;
import androidx.media3.exoplayer.source.ForwardingTimeline;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@UnstableApi
/* loaded from: classes3.dex */
public final class ServerSideAdInsertionMediaSource extends BaseMediaSource implements MediaSource.MediaSourceCaller, MediaSourceEventListener, DrmSessionEventListener {

    /* renamed from: h, reason: collision with root package name */
    public SharedMediaPeriod f7791h;

    public interface AdPlaybackStateUpdater {
    }

    public static final class MediaPeriodImpl implements MediaPeriod {

        /* renamed from: a, reason: collision with root package name */
        public final SharedMediaPeriod f7792a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaSource.MediaPeriodId f7793b;

        /* renamed from: c, reason: collision with root package name */
        public final MediaSourceEventListener.EventDispatcher f7794c;

        /* renamed from: d, reason: collision with root package name */
        public final DrmSessionEventListener.EventDispatcher f7795d;

        /* renamed from: e, reason: collision with root package name */
        public MediaPeriod.Callback f7796e;

        /* renamed from: f, reason: collision with root package name */
        public long f7797f;

        /* renamed from: g, reason: collision with root package name */
        public boolean[] f7798g = new boolean[0];

        /* renamed from: h, reason: collision with root package name */
        public boolean f7799h;

        public MediaPeriodImpl(SharedMediaPeriod sharedMediaPeriod, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener.EventDispatcher eventDispatcher2) {
            this.f7792a = sharedMediaPeriod;
            this.f7793b = mediaPeriodId;
            this.f7794c = eventDispatcher;
            this.f7795d = eventDispatcher2;
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final boolean b() {
            SharedMediaPeriod sharedMediaPeriod = this.f7792a;
            return equals(sharedMediaPeriod.f7808f) && sharedMediaPeriod.f7803a.b();
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public final long d(long j2, SeekParameters seekParameters) {
            SharedMediaPeriod sharedMediaPeriod = this.f7792a;
            sharedMediaPeriod.getClass();
            AdPlaybackState adPlaybackState = sharedMediaPeriod.f7807e;
            MediaSource.MediaPeriodId mediaPeriodId = this.f7793b;
            return ServerSideAdInsertionUtil.b(sharedMediaPeriod.f7803a.d(ServerSideAdInsertionUtil.e(j2, mediaPeriodId, adPlaybackState), seekParameters), mediaPeriodId, sharedMediaPeriod.f7807e);
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final boolean e(LoadingInfo loadingInfo) {
            SharedMediaPeriod sharedMediaPeriod = this.f7792a;
            MediaPeriodImpl mediaPeriodImpl = sharedMediaPeriod.f7808f;
            if (mediaPeriodImpl != null && !equals(mediaPeriodImpl)) {
                for (Pair pair : sharedMediaPeriod.f7805c.values()) {
                    mediaPeriodImpl.f7794c.g((LoadEventInfo) pair.first, ServerSideAdInsertionMediaSource.m0(mediaPeriodImpl, (MediaLoadData) pair.second, sharedMediaPeriod.f7807e));
                    this.f7794c.l((LoadEventInfo) pair.first, ServerSideAdInsertionMediaSource.m0(this, (MediaLoadData) pair.second, sharedMediaPeriod.f7807e));
                }
            }
            sharedMediaPeriod.f7808f = this;
            long j2 = this.f7797f;
            long j3 = loadingInfo.f6261a;
            MediaSource.MediaPeriodId mediaPeriodId = this.f7793b;
            long jE = j3 < j2 ? ServerSideAdInsertionUtil.e(j2, mediaPeriodId, sharedMediaPeriod.f7807e) - (this.f7797f - j3) : ServerSideAdInsertionUtil.e(j3, mediaPeriodId, sharedMediaPeriod.f7807e);
            LoadingInfo.Builder builder = new LoadingInfo.Builder();
            builder.f6265b = loadingInfo.f6262b;
            builder.f6266c = loadingInfo.f6263c;
            builder.f6264a = jE;
            return sharedMediaPeriod.f7803a.e(new LoadingInfo(builder));
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final long f() {
            SharedMediaPeriod sharedMediaPeriod = this.f7792a;
            return sharedMediaPeriod.a(this, sharedMediaPeriod.f7803a.f());
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public final long g(long j2) {
            SharedMediaPeriod sharedMediaPeriod = this.f7792a;
            sharedMediaPeriod.getClass();
            AdPlaybackState adPlaybackState = sharedMediaPeriod.f7807e;
            MediaSource.MediaPeriodId mediaPeriodId = this.f7793b;
            return ServerSideAdInsertionUtil.b(sharedMediaPeriod.f7803a.g(ServerSideAdInsertionUtil.e(j2, mediaPeriodId, adPlaybackState)), mediaPeriodId, sharedMediaPeriod.f7807e);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public final long h(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
            if (this.f7798g.length == 0) {
                this.f7798g = new boolean[sampleStreamArr.length];
            }
            SharedMediaPeriod sharedMediaPeriod = this.f7792a;
            this.f7797f = j2;
            if (!equals(sharedMediaPeriod.f7804b.get(0))) {
                for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
                    ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i2];
                    boolean z = true;
                    if (exoTrackSelection != null) {
                        if (zArr[i2] && sampleStreamArr[i2] != null) {
                            z = false;
                        }
                        zArr2[i2] = z;
                        if (z) {
                            sampleStreamArr[i2] = Util.a(sharedMediaPeriod.f7811i[i2], exoTrackSelection) ? new SampleStreamImpl(this, i2) : new EmptySampleStream();
                        }
                    } else {
                        sampleStreamArr[i2] = null;
                        zArr2[i2] = true;
                    }
                }
                return j2;
            }
            sharedMediaPeriod.f7811i = (ExoTrackSelection[]) Arrays.copyOf(exoTrackSelectionArr, exoTrackSelectionArr.length);
            AdPlaybackState adPlaybackState = sharedMediaPeriod.f7807e;
            MediaSource.MediaPeriodId mediaPeriodId = this.f7793b;
            long jE = ServerSideAdInsertionUtil.e(j2, mediaPeriodId, adPlaybackState);
            SampleStream[] sampleStreamArr2 = sharedMediaPeriod.f7812j;
            SampleStream[] sampleStreamArr3 = sampleStreamArr2.length == 0 ? new SampleStream[exoTrackSelectionArr.length] : (SampleStream[]) Arrays.copyOf(sampleStreamArr2, sampleStreamArr2.length);
            long jH = sharedMediaPeriod.f7803a.h(exoTrackSelectionArr, zArr, sampleStreamArr3, zArr2, jE);
            sharedMediaPeriod.f7812j = (SampleStream[]) Arrays.copyOf(sampleStreamArr3, sampleStreamArr3.length);
            sharedMediaPeriod.f7813k = (MediaLoadData[]) Arrays.copyOf(sharedMediaPeriod.f7813k, sampleStreamArr3.length);
            for (int i3 = 0; i3 < sampleStreamArr3.length; i3++) {
                if (sampleStreamArr3[i3] == null) {
                    sampleStreamArr[i3] = null;
                    sharedMediaPeriod.f7813k[i3] = null;
                } else if (sampleStreamArr[i3] == null || zArr2[i3]) {
                    sampleStreamArr[i3] = new SampleStreamImpl(this, i3);
                    sharedMediaPeriod.f7813k[i3] = null;
                }
            }
            return ServerSideAdInsertionUtil.b(jH, mediaPeriodId, sharedMediaPeriod.f7807e);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public final long i() {
            SharedMediaPeriod sharedMediaPeriod = this.f7792a;
            if (equals(sharedMediaPeriod.f7804b.get(0))) {
                long jI = sharedMediaPeriod.f7803a.i();
                if (jI != -9223372036854775807L) {
                    return ServerSideAdInsertionUtil.b(jI, this.f7793b, sharedMediaPeriod.f7807e);
                }
            }
            return -9223372036854775807L;
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public final void l() {
            this.f7792a.f7803a.l();
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public final void o(MediaPeriod.Callback callback, long j2) {
            this.f7796e = callback;
            SharedMediaPeriod sharedMediaPeriod = this.f7792a;
            this.f7797f = j2;
            if (!sharedMediaPeriod.f7809g) {
                sharedMediaPeriod.f7809g = true;
                sharedMediaPeriod.f7803a.o(sharedMediaPeriod, ServerSideAdInsertionUtil.e(j2, this.f7793b, sharedMediaPeriod.f7807e));
            } else if (sharedMediaPeriod.f7810h) {
                if (callback != null) {
                    callback.j(this);
                }
                this.f7799h = true;
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public final TrackGroupArray p() {
            return this.f7792a.f7803a.p();
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final long q() {
            SharedMediaPeriod sharedMediaPeriod = this.f7792a;
            return sharedMediaPeriod.a(this, sharedMediaPeriod.f7803a.q());
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public final void r(long j2, boolean z) {
            SharedMediaPeriod sharedMediaPeriod = this.f7792a;
            sharedMediaPeriod.getClass();
            sharedMediaPeriod.f7803a.r(ServerSideAdInsertionUtil.e(j2, this.f7793b, sharedMediaPeriod.f7807e), z);
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final void s(long j2) {
            SharedMediaPeriod sharedMediaPeriod = this.f7792a;
            long j3 = this.f7797f;
            MediaSource.MediaPeriodId mediaPeriodId = this.f7793b;
            sharedMediaPeriod.f7803a.s(j2 < j3 ? ServerSideAdInsertionUtil.e(j3, mediaPeriodId, sharedMediaPeriod.f7807e) - (this.f7797f - j2) : ServerSideAdInsertionUtil.e(j2, mediaPeriodId, sharedMediaPeriod.f7807e));
        }
    }

    public static final class SampleStreamImpl implements SampleStream {

        /* renamed from: a, reason: collision with root package name */
        public final MediaPeriodImpl f7800a;

        /* renamed from: b, reason: collision with root package name */
        public final int f7801b;

        public SampleStreamImpl(MediaPeriodImpl mediaPeriodImpl, int i2) {
            this.f7800a = mediaPeriodImpl;
            this.f7801b = i2;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final boolean a() {
            SampleStream sampleStream = this.f7800a.f7792a.f7812j[this.f7801b];
            int i2 = Util.f5744a;
            return sampleStream.a();
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final void c() {
            SampleStream sampleStream = this.f7800a.f7792a.f7812j[this.f7801b];
            int i2 = Util.f5744a;
            sampleStream.c();
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final int m(long j2) {
            MediaPeriodImpl mediaPeriodImpl = this.f7800a;
            SharedMediaPeriod sharedMediaPeriod = mediaPeriodImpl.f7792a;
            sharedMediaPeriod.getClass();
            long jE = ServerSideAdInsertionUtil.e(j2, mediaPeriodImpl.f7793b, sharedMediaPeriod.f7807e);
            SampleStream sampleStream = sharedMediaPeriod.f7812j[this.f7801b];
            int i2 = Util.f5744a;
            return sampleStream.m(jE);
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final int n(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            MediaLoadData mediaLoadData;
            MediaLoadData mediaLoadData2;
            MediaPeriodImpl mediaPeriodImpl = this.f7800a;
            SharedMediaPeriod sharedMediaPeriod = mediaPeriodImpl.f7792a;
            long jA = sharedMediaPeriod.a(mediaPeriodImpl, sharedMediaPeriod.f7803a.q());
            SampleStream[] sampleStreamArr = sharedMediaPeriod.f7812j;
            int i3 = this.f7801b;
            SampleStream sampleStream = sampleStreamArr[i3];
            int i4 = Util.f5744a;
            int iN = sampleStream.n(formatHolder, decoderInputBuffer, i2 | 5);
            long jA2 = sharedMediaPeriod.a(mediaPeriodImpl, decoderInputBuffer.f6073f);
            MediaSourceEventListener.EventDispatcher eventDispatcher = mediaPeriodImpl.f7794c;
            if ((iN == -4 && jA2 == Long.MIN_VALUE) || (iN == -3 && jA == Long.MIN_VALUE && !decoderInputBuffer.f6072e)) {
                boolean[] zArr = mediaPeriodImpl.f7798g;
                if (!zArr[i3] && (mediaLoadData2 = sharedMediaPeriod.f7813k[i3]) != null) {
                    zArr[i3] = true;
                    eventDispatcher.b(ServerSideAdInsertionMediaSource.m0(mediaPeriodImpl, mediaLoadData2, sharedMediaPeriod.f7807e));
                }
                decoderInputBuffer.h();
                decoderInputBuffer.e(4);
                return -4;
            }
            if (iN == -4) {
                boolean[] zArr2 = mediaPeriodImpl.f7798g;
                if (!zArr2[i3] && (mediaLoadData = sharedMediaPeriod.f7813k[i3]) != null) {
                    zArr2[i3] = true;
                    eventDispatcher.b(ServerSideAdInsertionMediaSource.m0(mediaPeriodImpl, mediaLoadData, sharedMediaPeriod.f7807e));
                }
                sharedMediaPeriod.f7812j[i3].n(formatHolder, decoderInputBuffer, i2);
                decoderInputBuffer.f6073f = jA2;
            }
            return iN;
        }
    }

    public static final class ServerSideAdInsertionTimeline extends ForwardingTimeline {

        /* renamed from: f, reason: collision with root package name */
        public final ImmutableMap f7802f;

        public ServerSideAdInsertionTimeline(Timeline timeline, ImmutableMap immutableMap) {
            super(timeline);
            Assertions.g(timeline.o() == 1);
            Timeline.Period period = new Timeline.Period();
            for (int i2 = 0; i2 < timeline.h(); i2++) {
                timeline.f(i2, period, true);
                Object obj = period.f5476b;
                obj.getClass();
                Assertions.g(immutableMap.containsKey(obj));
            }
            this.f7802f = immutableMap;
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public final Timeline.Period f(int i2, Timeline.Period period, boolean z) {
            super.f(i2, period, true);
            Object obj = period.f5476b;
            ImmutableMap immutableMap = this.f7802f;
            AdPlaybackState adPlaybackState = (AdPlaybackState) immutableMap.get(obj);
            adPlaybackState.getClass();
            long j2 = period.f5478d;
            long jD = j2 == -9223372036854775807L ? adPlaybackState.f5127d : ServerSideAdInsertionUtil.d(j2, -1, adPlaybackState);
            Timeline.Period period2 = new Timeline.Period();
            long jD2 = 0;
            for (int i3 = 0; i3 < i2 + 1; i3++) {
                this.f7572e.f(i3, period2, true);
                AdPlaybackState adPlaybackState2 = (AdPlaybackState) immutableMap.get(period2.f5476b);
                adPlaybackState2.getClass();
                if (i3 == 0) {
                    jD2 = -ServerSideAdInsertionUtil.d(-period2.f5479e, -1, adPlaybackState2);
                }
                if (i3 != i2) {
                    jD2 = ServerSideAdInsertionUtil.d(period2.f5478d, -1, adPlaybackState2) + jD2;
                }
            }
            period.g(period.f5475a, period.f5476b, period.f5477c, jD, jD2, adPlaybackState, period.f5480f);
            return period;
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public final Timeline.Window m(int i2, Timeline.Window window, long j2) {
            super.m(i2, window, j2);
            Timeline.Period period = new Timeline.Period();
            f(window.n, period, true);
            Object obj = period.f5476b;
            obj.getClass();
            ImmutableMap immutableMap = this.f7802f;
            AdPlaybackState adPlaybackState = (AdPlaybackState) immutableMap.get(obj);
            adPlaybackState.getClass();
            long jD = ServerSideAdInsertionUtil.d(window.p, -1, adPlaybackState);
            if (window.f5498m == -9223372036854775807L) {
                long j3 = adPlaybackState.f5127d;
                if (j3 != -9223372036854775807L) {
                    window.f5498m = j3 - jD;
                }
            } else {
                Timeline.Period periodF = this.f7572e.f(window.o, period, true);
                long j4 = periodF.f5479e;
                AdPlaybackState adPlaybackState2 = (AdPlaybackState) immutableMap.get(periodF.f5476b);
                adPlaybackState2.getClass();
                f(window.o, period, false);
                window.f5498m = period.f5479e + ServerSideAdInsertionUtil.d(window.f5498m - j4, -1, adPlaybackState2);
            }
            window.p = jD;
            return window;
        }
    }

    public static final class SharedMediaPeriod implements MediaPeriod.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final MediaPeriod f7803a;

        /* renamed from: d, reason: collision with root package name */
        public final Object f7806d;

        /* renamed from: e, reason: collision with root package name */
        public final AdPlaybackState f7807e;

        /* renamed from: f, reason: collision with root package name */
        public MediaPeriodImpl f7808f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f7809g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f7810h;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f7804b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public final HashMap f7805c = new HashMap();

        /* renamed from: i, reason: collision with root package name */
        public ExoTrackSelection[] f7811i = new ExoTrackSelection[0];

        /* renamed from: j, reason: collision with root package name */
        public SampleStream[] f7812j = new SampleStream[0];

        /* renamed from: k, reason: collision with root package name */
        public MediaLoadData[] f7813k = new MediaLoadData[0];

        public SharedMediaPeriod(MediaPeriod mediaPeriod, Object obj, AdPlaybackState adPlaybackState) {
            this.f7803a = mediaPeriod;
            this.f7806d = obj;
            this.f7807e = adPlaybackState;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final long a(androidx.media3.exoplayer.source.ads.ServerSideAdInsertionMediaSource.MediaPeriodImpl r7, long r8) {
            /*
                r6 = this;
                r0 = -9223372036854775808
                int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r2 != 0) goto L7
                return r0
            L7:
                androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r2 = r7.f7793b
                androidx.media3.common.AdPlaybackState r3 = r6.f7807e
                long r8 = androidx.media3.exoplayer.source.ads.ServerSideAdInsertionUtil.b(r8, r2, r3)
                androidx.media3.common.AdPlaybackState r2 = r6.f7807e
                androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r7 = r7.f7793b
                boolean r3 = r7.b()
                r4 = -1
                if (r3 == 0) goto L2f
                int r3 = r7.f7610b
                androidx.media3.common.AdPlaybackState$AdGroup r2 = r2.a(r3)
                int r3 = r2.f5135b
                if (r3 != r4) goto L27
                r2 = 0
                goto L45
            L27:
                long[] r2 = r2.f5140g
                int r7 = r7.f7611c
                r3 = r2[r7]
                r2 = r3
                goto L45
            L2f:
                int r7 = r7.f7613e
                if (r7 != r4) goto L34
                goto L40
            L34:
                androidx.media3.common.AdPlaybackState$AdGroup r7 = r2.a(r7)
                long r2 = r7.f5134a
                r4 = -9223372036854775808
                int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r7 != 0) goto L45
            L40:
                r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            L45:
                int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r7 < 0) goto L4a
                return r0
            L4a:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.ads.ServerSideAdInsertionMediaSource.SharedMediaPeriod.a(androidx.media3.exoplayer.source.ads.ServerSideAdInsertionMediaSource$MediaPeriodImpl, long):long");
        }

        public final void b(MediaSource mediaSource) {
            mediaSource.J(this.f7803a);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
        public final void j(MediaPeriod mediaPeriod) {
            this.f7810h = true;
            int i2 = 0;
            while (true) {
                ArrayList arrayList = this.f7804b;
                if (i2 >= arrayList.size()) {
                    return;
                }
                MediaPeriodImpl mediaPeriodImpl = (MediaPeriodImpl) arrayList.get(i2);
                MediaPeriod.Callback callback = mediaPeriodImpl.f7796e;
                if (callback != null) {
                    callback.j(mediaPeriodImpl);
                }
                mediaPeriodImpl.f7799h = true;
                i2++;
            }
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
        public final void k(SequenceableLoader sequenceableLoader) {
            MediaPeriodImpl mediaPeriodImpl = this.f7808f;
            if (mediaPeriodImpl == null) {
                return;
            }
            MediaPeriod.Callback callback = mediaPeriodImpl.f7796e;
            callback.getClass();
            callback.k(this.f7808f);
        }
    }

    public static MediaLoadData m0(MediaPeriodImpl mediaPeriodImpl, MediaLoadData mediaLoadData, AdPlaybackState adPlaybackState) {
        int i2 = mediaLoadData.f7600a;
        long jN0 = n0(mediaLoadData.f7605f, mediaPeriodImpl, adPlaybackState);
        long jN02 = n0(mediaLoadData.f7606g, mediaPeriodImpl, adPlaybackState);
        return new MediaLoadData(i2, mediaLoadData.f7601b, mediaLoadData.f7602c, mediaLoadData.f7603d, mediaLoadData.f7604e, jN0, jN02);
    }

    public static long n0(long j2, MediaPeriodImpl mediaPeriodImpl, AdPlaybackState adPlaybackState) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long jT = Util.T(j2);
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodImpl.f7793b;
        return Util.j0(mediaPeriodId.b() ? ServerSideAdInsertionUtil.c(jT, mediaPeriodId.f7610b, mediaPeriodId.f7611c, adPlaybackState) : ServerSideAdInsertionUtil.d(jT, -1, adPlaybackState));
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public final void B(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        MediaPeriodImpl mediaPeriodImplO0 = o0(mediaPeriodId, mediaLoadData, true);
        mediaPeriodImplO0.getClass();
        mediaPeriodImplO0.f7792a.f7805c.put(Long.valueOf(loadEventInfo.f7579a), Pair.create(loadEventInfo, mediaLoadData));
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final MediaPeriod C(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        Long lValueOf = Long.valueOf(mediaPeriodId.f7612d);
        Object obj = mediaPeriodId.f7609a;
        new Pair(lValueOf, obj);
        SharedMediaPeriod sharedMediaPeriod = this.f7791h;
        Object obj2 = null;
        if (sharedMediaPeriod != null) {
            if (sharedMediaPeriod.f7806d.equals(obj)) {
                throw null;
            }
            this.f7791h.b(null);
            this.f7791h = null;
        }
        obj2.getClass();
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final MediaItem D() {
        throw null;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void E(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaPeriodImpl mediaPeriodImplO0 = o0(mediaPeriodId, null, false);
        mediaPeriodImplO0.getClass();
        mediaPeriodImplO0.f7795d.b();
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void G(int i2, MediaSource.MediaPeriodId mediaPeriodId, int i3) {
        MediaPeriodImpl mediaPeriodImplO0 = o0(mediaPeriodId, null, true);
        mediaPeriodImplO0.getClass();
        mediaPeriodImplO0.f7795d.d(i3);
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public final void H(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        MediaPeriodImpl mediaPeriodImplO0 = o0(mediaPeriodId, mediaLoadData, true);
        mediaPeriodImplO0.getClass();
        if (z) {
            mediaPeriodImplO0.f7792a.f7805c.remove(Long.valueOf(loadEventInfo.f7579a));
        }
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void J(MediaPeriod mediaPeriod) {
        MediaPeriodImpl mediaPeriodImpl = (MediaPeriodImpl) mediaPeriod;
        SharedMediaPeriod sharedMediaPeriod = mediaPeriodImpl.f7792a;
        if (mediaPeriodImpl.equals(sharedMediaPeriod.f7808f)) {
            sharedMediaPeriod.f7808f = null;
            sharedMediaPeriod.f7805c.clear();
        }
        sharedMediaPeriod.f7804b.remove(mediaPeriodImpl);
        if (mediaPeriodImpl.f7792a.f7804b.isEmpty()) {
            MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodImpl.f7793b;
            new Pair(Long.valueOf(mediaPeriodId.f7612d), mediaPeriodId.f7609a);
            throw null;
        }
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void K(int i2, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
        MediaPeriodImpl mediaPeriodImplO0 = o0(mediaPeriodId, null, false);
        mediaPeriodImplO0.getClass();
        mediaPeriodImplO0.f7795d.e(exc);
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public final void M(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        MediaPeriodImpl mediaPeriodImplO0 = o0(mediaPeriodId, mediaLoadData, true);
        mediaPeriodImplO0.getClass();
        mediaPeriodImplO0.f7792a.f7805c.remove(Long.valueOf(loadEventInfo.f7579a));
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void O(MediaItem mediaItem) {
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public final void Q(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        MediaPeriodImpl mediaPeriodImplO0 = o0(mediaPeriodId, mediaLoadData, true);
        mediaPeriodImplO0.getClass();
        mediaPeriodImplO0.f7792a.f7805c.remove(Long.valueOf(loadEventInfo.f7579a));
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public final void R(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        int i3;
        String str;
        MediaPeriodImpl mediaPeriodImplO0 = o0(mediaPeriodId, mediaLoadData, false);
        mediaPeriodImplO0.getClass();
        SharedMediaPeriod sharedMediaPeriod = mediaPeriodImplO0.f7792a;
        Format format = mediaLoadData.f7602c;
        if (format != null) {
            i3 = 0;
            loop0: while (true) {
                ExoTrackSelection[] exoTrackSelectionArr = sharedMediaPeriod.f7811i;
                if (i3 >= exoTrackSelectionArr.length) {
                    break;
                }
                ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i3];
                if (exoTrackSelection != null) {
                    TrackGroup trackGroupM = exoTrackSelection.m();
                    boolean z = mediaLoadData.f7601b == 0 && trackGroupM.equals(sharedMediaPeriod.f7803a.p().a(0));
                    for (int i4 = 0; i4 < trackGroupM.f5501a; i4++) {
                        Format format2 = trackGroupM.f5504d[i4];
                        if (format2.equals(format) || (z && (str = format2.f5213a) != null && str.equals(format.f5213a))) {
                            break loop0;
                        }
                    }
                }
                i3++;
            }
        } else {
            i3 = -1;
        }
        if (i3 != -1) {
            sharedMediaPeriod.f7813k[i3] = mediaLoadData;
            mediaPeriodImplO0.f7798g[i3] = true;
        }
        throw null;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void S(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaPeriodImpl mediaPeriodImplO0 = o0(mediaPeriodId, null, false);
        mediaPeriodImplO0.getClass();
        mediaPeriodImplO0.f7795d.c();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void V() {
        throw null;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void Z(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaPeriodImpl mediaPeriodImplO0 = o0(mediaPeriodId, null, false);
        mediaPeriodImplO0.getClass();
        mediaPeriodImplO0.f7795d.f();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource.MediaSourceCaller
    public final void b(BaseMediaSource baseMediaSource, Timeline timeline) {
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final boolean c0(MediaItem mediaItem) {
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void g0() {
        p0();
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public final void h(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        o0(mediaPeriodId, mediaLoadData, false).getClass();
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void h0() {
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void j0(TransferListener transferListener) {
        Util.o(null);
        synchronized (this) {
        }
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void l0() {
        p0();
        synchronized (this) {
        }
        throw null;
    }

    public final MediaPeriodImpl o0(MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData, boolean z) {
        if (mediaPeriodId == null) {
            return null;
        }
        new Pair(Long.valueOf(mediaPeriodId.f7612d), mediaPeriodId.f7609a);
        throw null;
    }

    public final void p0() {
        SharedMediaPeriod sharedMediaPeriod = this.f7791h;
        if (sharedMediaPeriod != null) {
            sharedMediaPeriod.b(null);
            this.f7791h = null;
        }
    }
}
