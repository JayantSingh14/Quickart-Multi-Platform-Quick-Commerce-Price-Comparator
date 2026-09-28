package androidx.media3.exoplayer.source;

import android.net.Uri;
import android.os.Handler;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.source.IcyDataSource;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ForwardingSeekMap;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
final class ProgressiveMediaPeriod implements MediaPeriod, ExtractorOutput, Loader.Callback<ExtractingLoadable>, Loader.ReleaseCallback, SampleQueue.UpstreamFormatChangedListener {
    public static final Map X;
    public static final Format Y;
    public SeekMap A;
    public long B;
    public boolean C;
    public boolean E;
    public boolean F;
    public int G;
    public boolean H;
    public long I;
    public boolean K;
    public int L;
    public boolean M;
    public boolean Q;

    /* renamed from: a, reason: collision with root package name */
    public final Uri f7634a;

    /* renamed from: b, reason: collision with root package name */
    public final DataSource f7635b;

    /* renamed from: c, reason: collision with root package name */
    public final DrmSessionManager f7636c;

    /* renamed from: d, reason: collision with root package name */
    public final LoadErrorHandlingPolicy f7637d;

    /* renamed from: e, reason: collision with root package name */
    public final MediaSourceEventListener.EventDispatcher f7638e;

    /* renamed from: f, reason: collision with root package name */
    public final DrmSessionEventListener.EventDispatcher f7639f;

    /* renamed from: g, reason: collision with root package name */
    public final ProgressiveMediaSource f7640g;

    /* renamed from: h, reason: collision with root package name */
    public final Allocator f7641h;

    /* renamed from: i, reason: collision with root package name */
    public final String f7642i;

    /* renamed from: j, reason: collision with root package name */
    public final long f7643j;

    /* renamed from: k, reason: collision with root package name */
    public final long f7644k;

    /* renamed from: m, reason: collision with root package name */
    public final ProgressiveMediaExtractor f7646m;
    public MediaPeriod.Callback r;
    public IcyHeaders s;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public TrackState z;

    /* renamed from: l, reason: collision with root package name */
    public final Loader f7645l = new Loader("ProgressiveMediaPeriod");
    public final ConditionVariable n = new ConditionVariable();
    public final i o = new i(this, 1);
    public final i p = new i(this, 2);
    public final Handler q = Util.o(null);
    public TrackId[] u = new TrackId[0];
    public SampleQueue[] t = new SampleQueue[0];
    public long J = -9223372036854775807L;
    public int D = 1;

    public final class ExtractingLoadable implements Loader.Loadable, IcyDataSource.Listener {

        /* renamed from: b, reason: collision with root package name */
        public final Uri f7649b;

        /* renamed from: c, reason: collision with root package name */
        public final StatsDataSource f7650c;

        /* renamed from: d, reason: collision with root package name */
        public final ProgressiveMediaExtractor f7651d;

        /* renamed from: e, reason: collision with root package name */
        public final ExtractorOutput f7652e;

        /* renamed from: f, reason: collision with root package name */
        public final ConditionVariable f7653f;

        /* renamed from: h, reason: collision with root package name */
        public volatile boolean f7655h;

        /* renamed from: j, reason: collision with root package name */
        public long f7657j;

        /* renamed from: l, reason: collision with root package name */
        public TrackOutput f7659l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f7660m;

        /* renamed from: g, reason: collision with root package name */
        public final PositionHolder f7654g = new PositionHolder();

        /* renamed from: i, reason: collision with root package name */
        public boolean f7656i = true;

        /* renamed from: a, reason: collision with root package name */
        public final long f7648a = LoadEventInfo.f7578d.getAndIncrement();

        /* renamed from: k, reason: collision with root package name */
        public DataSpec f7658k = c(0);

        public ExtractingLoadable(Uri uri, DataSource dataSource, ProgressiveMediaExtractor progressiveMediaExtractor, ExtractorOutput extractorOutput, ConditionVariable conditionVariable) {
            this.f7649b = uri;
            this.f7650c = new StatsDataSource(dataSource);
            this.f7651d = progressiveMediaExtractor;
            this.f7652e = extractorOutput;
            this.f7653f = conditionVariable;
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
        public final void a() {
            DataSource icyDataSource;
            int i2;
            int iD = 0;
            while (iD == 0 && !this.f7655h) {
                try {
                    long j2 = this.f7654g.f8599a;
                    DataSpec dataSpecC = c(j2);
                    this.f7658k = dataSpecC;
                    long j3 = this.f7650c.j(dataSpecC);
                    if (this.f7655h) {
                        if (iD != 1 && this.f7651d.c() != -1) {
                            this.f7654g.f8599a = this.f7651d.c();
                        }
                        DataSourceUtil.a(this.f7650c);
                        return;
                    }
                    if (j3 != -1) {
                        j3 += j2;
                        ProgressiveMediaPeriod progressiveMediaPeriod = ProgressiveMediaPeriod.this;
                        progressiveMediaPeriod.q.post(new i(progressiveMediaPeriod, 0));
                    }
                    long j4 = j3;
                    ProgressiveMediaPeriod.this.s = IcyHeaders.a(this.f7650c.f5929a.c());
                    StatsDataSource statsDataSource = this.f7650c;
                    IcyHeaders icyHeaders = ProgressiveMediaPeriod.this.s;
                    if (icyHeaders == null || (i2 = icyHeaders.f8796f) == -1) {
                        icyDataSource = statsDataSource;
                    } else {
                        icyDataSource = new IcyDataSource(statsDataSource, i2, this);
                        ProgressiveMediaPeriod progressiveMediaPeriod2 = ProgressiveMediaPeriod.this;
                        progressiveMediaPeriod2.getClass();
                        TrackOutput trackOutputA = progressiveMediaPeriod2.A(new TrackId(0, true));
                        this.f7659l = trackOutputA;
                        trackOutputA.b(ProgressiveMediaPeriod.Y);
                    }
                    this.f7651d.e(icyDataSource, this.f7649b, this.f7650c.f5929a.c(), j2, j4, this.f7652e);
                    if (ProgressiveMediaPeriod.this.s != null) {
                        this.f7651d.b();
                    }
                    if (this.f7656i) {
                        this.f7651d.a(j2, this.f7657j);
                        this.f7656i = false;
                    }
                    while (iD == 0 && !this.f7655h) {
                        try {
                            this.f7653f.a();
                            iD = this.f7651d.d(this.f7654g);
                            long jC = this.f7651d.c();
                            if (jC > ProgressiveMediaPeriod.this.f7643j + j2) {
                                this.f7653f.c();
                                ProgressiveMediaPeriod progressiveMediaPeriod3 = ProgressiveMediaPeriod.this;
                                progressiveMediaPeriod3.q.post(progressiveMediaPeriod3.p);
                                j2 = jC;
                            }
                        } catch (InterruptedException unused) {
                            throw new InterruptedIOException();
                        }
                    }
                    if (iD == 1) {
                        iD = 0;
                    } else if (this.f7651d.c() != -1) {
                        this.f7654g.f8599a = this.f7651d.c();
                    }
                    DataSourceUtil.a(this.f7650c);
                } catch (Throwable th) {
                    if (iD != 1 && this.f7651d.c() != -1) {
                        this.f7654g.f8599a = this.f7651d.c();
                    }
                    DataSourceUtil.a(this.f7650c);
                    throw th;
                }
            }
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
        public final void b() {
            this.f7655h = true;
        }

        public final DataSpec c(long j2) {
            DataSpec.Builder builder = new DataSpec.Builder();
            builder.f5860a = this.f7649b;
            builder.f5865f = j2;
            builder.f5867h = ProgressiveMediaPeriod.this.f7642i;
            builder.f5868i = 6;
            builder.f5864e = ProgressiveMediaPeriod.X;
            return builder.a();
        }
    }

    public interface Listener {
    }

    public final class SampleStreamImpl implements SampleStream {

        /* renamed from: a, reason: collision with root package name */
        public final int f7661a;

        public SampleStreamImpl(int i2) {
            this.f7661a = i2;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final boolean a() {
            ProgressiveMediaPeriod progressiveMediaPeriod = ProgressiveMediaPeriod.this;
            return !progressiveMediaPeriod.C() && progressiveMediaPeriod.t[this.f7661a].t(progressiveMediaPeriod.M);
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final void c() throws IOException {
            ProgressiveMediaPeriod progressiveMediaPeriod = ProgressiveMediaPeriod.this;
            progressiveMediaPeriod.t[this.f7661a].v();
            progressiveMediaPeriod.f7645l.e(progressiveMediaPeriod.f7637d.b(progressiveMediaPeriod.D));
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final int m(long j2) throws Throwable {
            ProgressiveMediaPeriod progressiveMediaPeriod = ProgressiveMediaPeriod.this;
            if (progressiveMediaPeriod.C()) {
                return 0;
            }
            int i2 = this.f7661a;
            progressiveMediaPeriod.y(i2);
            SampleQueue sampleQueue = progressiveMediaPeriod.t[i2];
            int iR = sampleQueue.r(j2, progressiveMediaPeriod.M);
            sampleQueue.C(iR);
            if (iR == 0) {
                progressiveMediaPeriod.z(i2);
            }
            return iR;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final int n(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            ProgressiveMediaPeriod progressiveMediaPeriod = ProgressiveMediaPeriod.this;
            if (progressiveMediaPeriod.C()) {
                return -3;
            }
            int i3 = this.f7661a;
            progressiveMediaPeriod.y(i3);
            int iY = progressiveMediaPeriod.t[i3].y(formatHolder, decoderInputBuffer, i2, progressiveMediaPeriod.M);
            if (iY == -3) {
                progressiveMediaPeriod.z(i3);
            }
            return iY;
        }
    }

    public static final class TrackId {

        /* renamed from: a, reason: collision with root package name */
        public final int f7663a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f7664b;

        public TrackId(int i2, boolean z) {
            this.f7663a = i2;
            this.f7664b = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || TrackId.class != obj.getClass()) {
                return false;
            }
            TrackId trackId = (TrackId) obj;
            return this.f7663a == trackId.f7663a && this.f7664b == trackId.f7664b;
        }

        public final int hashCode() {
            return (this.f7663a * 31) + (this.f7664b ? 1 : 0);
        }
    }

    public static final class TrackState {

        /* renamed from: a, reason: collision with root package name */
        public final TrackGroupArray f7665a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean[] f7666b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean[] f7667c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean[] f7668d;

        public TrackState(TrackGroupArray trackGroupArray, boolean[] zArr) {
            this.f7665a = trackGroupArray;
            this.f7666b = zArr;
            int i2 = trackGroupArray.f7771a;
            this.f7667c = new boolean[i2];
            this.f7668d = new boolean[i2];
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        X = Collections.unmodifiableMap(map);
        Format.Builder builder = new Format.Builder();
        builder.f5226a = "icy";
        builder.f5237l = MimeTypes.p("application/x-icy");
        Y = new Format(builder);
    }

    public ProgressiveMediaPeriod(Uri uri, DataSource dataSource, ProgressiveMediaExtractor progressiveMediaExtractor, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, ProgressiveMediaSource progressiveMediaSource, Allocator allocator, String str, int i2, long j2) {
        this.f7634a = uri;
        this.f7635b = dataSource;
        this.f7636c = drmSessionManager;
        this.f7639f = eventDispatcher;
        this.f7637d = loadErrorHandlingPolicy;
        this.f7638e = eventDispatcher2;
        this.f7640g = progressiveMediaSource;
        this.f7641h = allocator;
        this.f7642i = str;
        this.f7643j = i2;
        this.f7646m = progressiveMediaExtractor;
        this.f7644k = j2;
    }

    public final TrackOutput A(TrackId trackId) {
        int length = this.t.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (trackId.equals(this.u[i2])) {
                return this.t[i2];
            }
        }
        if (this.v) {
            Log.h("ProgressiveMediaPeriod", "Extractor added new track (id=" + trackId.f7663a + ") after finishing tracks.");
            return new DiscardingTrackOutput();
        }
        DrmSessionEventListener.EventDispatcher eventDispatcher = this.f7639f;
        DrmSessionManager drmSessionManager = this.f7636c;
        drmSessionManager.getClass();
        SampleQueue sampleQueue = new SampleQueue(this.f7641h, drmSessionManager, eventDispatcher);
        sampleQueue.f7697f = this;
        int i3 = length + 1;
        TrackId[] trackIdArr = (TrackId[]) Arrays.copyOf(this.u, i3);
        trackIdArr[length] = trackId;
        int i4 = Util.f5744a;
        this.u = trackIdArr;
        SampleQueue[] sampleQueueArr = (SampleQueue[]) Arrays.copyOf(this.t, i3);
        sampleQueueArr[length] = sampleQueue;
        this.t = sampleQueueArr;
        return sampleQueue;
    }

    public final void B() {
        ExtractingLoadable extractingLoadable = new ExtractingLoadable(this.f7634a, this.f7635b, this.f7646m, this, this.n);
        if (this.w) {
            Assertions.g(w());
            long j2 = this.B;
            if (j2 != -9223372036854775807L && this.J > j2) {
                this.M = true;
                this.J = -9223372036854775807L;
                return;
            }
            SeekMap seekMap = this.A;
            seekMap.getClass();
            long j3 = seekMap.d(this.J).f8600a.f8606b;
            long j4 = this.J;
            extractingLoadable.f7654g.f8599a = j3;
            extractingLoadable.f7657j = j4;
            extractingLoadable.f7656i = true;
            extractingLoadable.f7660m = false;
            for (SampleQueue sampleQueue : this.t) {
                sampleQueue.t = this.J;
            }
            this.J = -9223372036854775807L;
        }
        this.L = u();
        this.f7645l.g(extractingLoadable, this, this.f7637d.b(this.D));
        this.f7638e.k(new LoadEventInfo(extractingLoadable.f7648a, extractingLoadable.f7658k), 1, -1, null, 0, null, extractingLoadable.f7657j, this.B);
    }

    public final boolean C() {
        return this.F || w();
    }

    @Override // androidx.media3.exoplayer.source.SampleQueue.UpstreamFormatChangedListener
    public final void a() {
        this.q.post(this.o);
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final void a0(Loader.Loadable loadable, long j2, long j3) {
        SeekMap seekMap;
        ExtractingLoadable extractingLoadable = (ExtractingLoadable) loadable;
        if (this.B == -9223372036854775807L && (seekMap = this.A) != null) {
            boolean zG = seekMap.g();
            long jV = v(true);
            long j4 = jV == Long.MIN_VALUE ? 0L : jV + 10000;
            this.B = j4;
            this.f7640g.n0(j4, zG, this.C);
        }
        StatsDataSource statsDataSource = extractingLoadable.f7650c;
        Uri uri = statsDataSource.f5931c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.f7648a, statsDataSource.f5932d, j3);
        this.f7637d.getClass();
        this.f7638e.f(loadEventInfo, 1, -1, null, 0, null, extractingLoadable.f7657j, this.B);
        this.M = true;
        MediaPeriod.Callback callback = this.r;
        callback.getClass();
        callback.k(this);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean b() {
        return this.f7645l.d() && this.n.d();
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public final void c(final SeekMap seekMap) {
        this.q.post(new Runnable() { // from class: androidx.media3.exoplayer.source.j
            @Override // java.lang.Runnable
            public final void run() {
                ProgressiveMediaPeriod progressiveMediaPeriod = this.f7917a;
                IcyHeaders icyHeaders = progressiveMediaPeriod.s;
                SeekMap seekMap2 = seekMap;
                progressiveMediaPeriod.A = icyHeaders == null ? seekMap2 : new SeekMap.Unseekable(-9223372036854775807L);
                progressiveMediaPeriod.B = seekMap2.l();
                boolean z = !progressiveMediaPeriod.H && seekMap2.l() == -9223372036854775807L;
                progressiveMediaPeriod.C = z;
                progressiveMediaPeriod.D = z ? 7 : 1;
                if (progressiveMediaPeriod.w) {
                    progressiveMediaPeriod.f7640g.n0(progressiveMediaPeriod.B, seekMap2.g(), progressiveMediaPeriod.C);
                } else {
                    progressiveMediaPeriod.x();
                }
            }
        });
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long d(long j2, SeekParameters seekParameters) {
        t();
        if (!this.A.g()) {
            return 0L;
        }
        SeekMap.SeekPoints seekPointsD = this.A.d(j2);
        return seekParameters.a(j2, seekPointsD.f8600a.f8605a, seekPointsD.f8601b.f8605a);
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final void d0(Loader.Loadable loadable, long j2, long j3, boolean z) {
        ExtractingLoadable extractingLoadable = (ExtractingLoadable) loadable;
        StatsDataSource statsDataSource = extractingLoadable.f7650c;
        Uri uri = statsDataSource.f5931c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.f7648a, statsDataSource.f5932d, j3);
        this.f7637d.getClass();
        this.f7638e.c(loadEventInfo, 1, -1, null, 0, null, extractingLoadable.f7657j, this.B);
        if (z) {
            return;
        }
        for (SampleQueue sampleQueue : this.t) {
            sampleQueue.z(false);
        }
        if (this.G > 0) {
            MediaPeriod.Callback callback = this.r;
            callback.getClass();
            callback.k(this);
        }
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean e(LoadingInfo loadingInfo) {
        if (this.M) {
            return false;
        }
        Loader loader = this.f7645l;
        if (loader.b() || this.K) {
            return false;
        }
        if (this.w && this.G == 0) {
            return false;
        }
        boolean zE = this.n.e();
        if (loader.d()) {
            return zE;
        }
        B();
        return true;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long f() {
        return q();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005d  */
    @Override // androidx.media3.exoplayer.source.MediaPeriod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long g(long r8) {
        /*
            r7 = this;
            r7.t()
            androidx.media3.exoplayer.source.ProgressiveMediaPeriod$TrackState r0 = r7.z
            boolean[] r0 = r0.f7666b
            androidx.media3.extractor.SeekMap r1 = r7.A
            boolean r1 = r1.g()
            if (r1 == 0) goto L10
            goto L12
        L10:
            r8 = 0
        L12:
            r1 = 0
            r7.F = r1
            r7.I = r8
            boolean r2 = r7.w()
            if (r2 == 0) goto L20
            r7.J = r8
            return r8
        L20:
            int r2 = r7.D
            r3 = 7
            androidx.media3.exoplayer.upstream.Loader r4 = r7.f7645l
            if (r2 == r3) goto L5d
            boolean r2 = r7.M
            if (r2 != 0) goto L31
            boolean r2 = r4.d()
            if (r2 == 0) goto L5d
        L31:
            androidx.media3.exoplayer.source.SampleQueue[] r2 = r7.t
            int r2 = r2.length
            r3 = r1
        L35:
            if (r3 >= r2) goto L59
            androidx.media3.exoplayer.source.SampleQueue[] r5 = r7.t
            r5 = r5[r3]
            boolean r6 = r7.y
            if (r6 == 0) goto L46
            int r6 = r5.q
            boolean r5 = r5.A(r6)
            goto L4a
        L46:
            boolean r5 = r5.B(r8, r1)
        L4a:
            if (r5 != 0) goto L56
            boolean r5 = r0[r3]
            if (r5 != 0) goto L54
            boolean r5 = r7.x
            if (r5 != 0) goto L56
        L54:
            r0 = r1
            goto L5a
        L56:
            int r3 = r3 + 1
            goto L35
        L59:
            r0 = 1
        L5a:
            if (r0 == 0) goto L5d
            goto L8b
        L5d:
            r7.K = r1
            r7.J = r8
            r7.M = r1
            boolean r0 = r4.d()
            if (r0 == 0) goto L7a
            androidx.media3.exoplayer.source.SampleQueue[] r0 = r7.t
            int r2 = r0.length
        L6c:
            if (r1 >= r2) goto L76
            r3 = r0[r1]
            r3.i()
            int r1 = r1 + 1
            goto L6c
        L76:
            r4.a()
            return r8
        L7a:
            r0 = 0
            r4.f8169c = r0
            androidx.media3.exoplayer.source.SampleQueue[] r0 = r7.t
            int r2 = r0.length
            r3 = r1
        L81:
            if (r3 >= r2) goto L8b
            r4 = r0[r3]
            r4.z(r1)
            int r3 = r3 + 1
            goto L81
        L8b:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.ProgressiveMediaPeriod.g(long):long");
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long h(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        ExoTrackSelection exoTrackSelection;
        t();
        TrackState trackState = this.z;
        TrackGroupArray trackGroupArray = trackState.f7665a;
        boolean[] zArr3 = trackState.f7667c;
        int i2 = this.G;
        int i3 = 0;
        for (int i4 = 0; i4 < exoTrackSelectionArr.length; i4++) {
            SampleStream sampleStream = sampleStreamArr[i4];
            if (sampleStream != null && (exoTrackSelectionArr[i4] == null || !zArr[i4])) {
                int i5 = ((SampleStreamImpl) sampleStream).f7661a;
                Assertions.g(zArr3[i5]);
                this.G--;
                zArr3[i5] = false;
                sampleStreamArr[i4] = null;
            }
        }
        boolean z = !this.E ? j2 == 0 || this.y : i2 != 0;
        for (int i6 = 0; i6 < exoTrackSelectionArr.length; i6++) {
            if (sampleStreamArr[i6] == null && (exoTrackSelection = exoTrackSelectionArr[i6]) != null) {
                Assertions.g(exoTrackSelection.length() == 1);
                Assertions.g(exoTrackSelection.f(0) == 0);
                int iB = trackGroupArray.b(exoTrackSelection.m());
                Assertions.g(!zArr3[iB]);
                this.G++;
                zArr3[iB] = true;
                sampleStreamArr[i6] = new SampleStreamImpl(iB);
                zArr2[i6] = true;
                if (!z) {
                    SampleQueue sampleQueue = this.t[iB];
                    z = (sampleQueue.p() == 0 || sampleQueue.B(j2, true)) ? false : true;
                }
            }
        }
        if (this.G == 0) {
            this.K = false;
            this.F = false;
            Loader loader = this.f7645l;
            if (loader.d()) {
                SampleQueue[] sampleQueueArr = this.t;
                int length = sampleQueueArr.length;
                while (i3 < length) {
                    sampleQueueArr[i3].i();
                    i3++;
                }
                loader.a();
            } else {
                this.M = false;
                for (SampleQueue sampleQueue2 : this.t) {
                    sampleQueue2.z(false);
                }
            }
        } else if (z) {
            j2 = g(j2);
            while (i3 < sampleStreamArr.length) {
                if (sampleStreamArr[i3] != null) {
                    zArr2[i3] = true;
                }
                i3++;
            }
        }
        this.E = true;
        return j2;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long i() {
        if (!this.F) {
            return -9223372036854775807L;
        }
        if (!this.M && u() <= this.L) {
            return -9223372036854775807L;
        }
        this.F = false;
        return this.I;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.ReleaseCallback
    public final void j() {
        for (SampleQueue sampleQueue : this.t) {
            sampleQueue.z(true);
            DrmSession drmSession = sampleQueue.f7699h;
            if (drmSession != null) {
                drmSession.f(sampleQueue.f7696e);
                sampleQueue.f7699h = null;
                sampleQueue.f7698g = null;
            }
        }
        this.f7646m.release();
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final Loader.LoadErrorAction k(Loader.Loadable loadable, long j2, long j3, IOException iOException, int i2) {
        Loader.LoadErrorAction loadErrorAction;
        SeekMap seekMap;
        ExtractingLoadable extractingLoadable = (ExtractingLoadable) loadable;
        StatsDataSource statsDataSource = extractingLoadable.f7650c;
        Uri uri = statsDataSource.f5931c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.f7648a, statsDataSource.f5932d, j3);
        Util.j0(extractingLoadable.f7657j);
        Util.j0(this.B);
        long jA = this.f7637d.a(new LoadErrorHandlingPolicy.LoadErrorInfo(iOException, i2));
        if (jA == -9223372036854775807L) {
            loadErrorAction = Loader.f8166f;
        } else {
            int iU = u();
            int i3 = iU > this.L ? 1 : 0;
            if (this.H || !((seekMap = this.A) == null || seekMap.l() == -9223372036854775807L)) {
                this.L = iU;
            } else if (!this.w || C()) {
                this.F = this.w;
                this.I = 0L;
                this.L = 0;
                for (SampleQueue sampleQueue : this.t) {
                    sampleQueue.z(false);
                }
                extractingLoadable.f7654g.f8599a = 0L;
                extractingLoadable.f7657j = 0L;
                extractingLoadable.f7656i = true;
                extractingLoadable.f7660m = false;
            } else {
                this.K = true;
                loadErrorAction = Loader.f8165e;
            }
            loadErrorAction = new Loader.LoadErrorAction(i3, jA);
        }
        this.f7638e.h(loadEventInfo, 1, -1, null, 0, null, extractingLoadable.f7657j, this.B, iOException, !loadErrorAction.a());
        return loadErrorAction;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void l() throws IOException {
        this.f7645l.e(this.f7637d.b(this.D));
        if (this.M && !this.w) {
            throw ParserException.a(null, "Loading finished before preparation is complete.");
        }
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public final void m() {
        this.v = true;
        this.q.post(this.o);
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public final TrackOutput n(int i2, int i3) {
        return A(new TrackId(i2, false));
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void o(MediaPeriod.Callback callback, long j2) {
        this.r = callback;
        this.n.e();
        B();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final TrackGroupArray p() {
        t();
        return this.z.f7665a;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long q() {
        long jV;
        boolean z;
        long j2;
        t();
        if (this.M || this.G == 0) {
            return Long.MIN_VALUE;
        }
        if (w()) {
            return this.J;
        }
        if (this.x) {
            int length = this.t.length;
            jV = Long.MAX_VALUE;
            for (int i2 = 0; i2 < length; i2++) {
                TrackState trackState = this.z;
                if (trackState.f7666b[i2] && trackState.f7667c[i2]) {
                    SampleQueue sampleQueue = this.t[i2];
                    synchronized (sampleQueue) {
                        z = sampleQueue.w;
                    }
                    if (z) {
                        continue;
                    } else {
                        SampleQueue sampleQueue2 = this.t[i2];
                        synchronized (sampleQueue2) {
                            j2 = sampleQueue2.v;
                        }
                        jV = Math.min(jV, j2);
                    }
                }
            }
        } else {
            jV = Long.MAX_VALUE;
        }
        if (jV == Long.MAX_VALUE) {
            jV = v(false);
        }
        return jV == Long.MIN_VALUE ? this.I : jV;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void r(long j2, boolean z) throws Throwable {
        if (this.y) {
            return;
        }
        t();
        if (w()) {
            return;
        }
        boolean[] zArr = this.z.f7667c;
        int length = this.t.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.t[i2].h(j2, z, zArr[i2]);
        }
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final void s(long j2) {
    }

    public final void t() {
        Assertions.g(this.w);
        this.z.getClass();
        this.A.getClass();
    }

    public final int u() {
        int i2 = 0;
        for (SampleQueue sampleQueue : this.t) {
            i2 += sampleQueue.q + sampleQueue.p;
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long v(boolean r7) {
        /*
            r6 = this;
            r0 = -9223372036854775808
            r2 = 0
        L3:
            androidx.media3.exoplayer.source.SampleQueue[] r3 = r6.t
            int r3 = r3.length
            if (r2 >= r3) goto L27
            if (r7 != 0) goto L15
            androidx.media3.exoplayer.source.ProgressiveMediaPeriod$TrackState r3 = r6.z
            r3.getClass()
            boolean[] r3 = r3.f7667c
            boolean r3 = r3[r2]
            if (r3 == 0) goto L21
        L15:
            androidx.media3.exoplayer.source.SampleQueue[] r3 = r6.t
            r3 = r3[r2]
            monitor-enter(r3)
            long r4 = r3.v     // Catch: java.lang.Throwable -> L24
            monitor-exit(r3)
            long r0 = java.lang.Math.max(r0, r4)
        L21:
            int r2 = r2 + 1
            goto L3
        L24:
            r7 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L24
            throw r7
        L27:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.ProgressiveMediaPeriod.v(boolean):long");
    }

    public final boolean w() {
        return this.J != -9223372036854775807L;
    }

    public final void x() {
        long j2;
        int i2;
        if (this.Q || this.w || !this.v || this.A == null) {
            return;
        }
        for (SampleQueue sampleQueue : this.t) {
            if (sampleQueue.s() == null) {
                return;
            }
        }
        this.n.c();
        int length = this.t.length;
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        boolean[] zArr = new boolean[length];
        int i3 = 0;
        while (true) {
            j2 = this.f7644k;
            if (i3 >= length) {
                break;
            }
            Format formatS = this.t[i3].s();
            formatS.getClass();
            String str = formatS.f5225m;
            boolean zL = MimeTypes.l(str);
            boolean z = zL || MimeTypes.o(str);
            zArr[i3] = z;
            this.x = z | this.x;
            this.y = j2 != -9223372036854775807L && length == 1 && MimeTypes.m(str);
            IcyHeaders icyHeaders = this.s;
            if (icyHeaders != null) {
                if (zL || this.u[i3].f7664b) {
                    Metadata metadata = formatS.f5223k;
                    Metadata metadata2 = metadata == null ? new Metadata(icyHeaders) : metadata.a(icyHeaders);
                    Format.Builder builderA = formatS.a();
                    builderA.f5235j = metadata2;
                    formatS = new Format(builderA);
                }
                if (zL && formatS.f5219g == -1 && formatS.f5220h == -1 && (i2 = icyHeaders.f8791a) != -1) {
                    Format.Builder builderA2 = formatS.a();
                    builderA2.f5232g = i2;
                    formatS = new Format(builderA2);
                }
            }
            int iC = this.f7636c.c(formatS);
            Format.Builder builderA3 = formatS.a();
            builderA3.I = iC;
            trackGroupArr[i3] = new TrackGroup(Integer.toString(i3), new Format(builderA3));
            i3++;
        }
        this.z = new TrackState(new TrackGroupArray(trackGroupArr), zArr);
        if (this.y && this.B == -9223372036854775807L) {
            this.B = j2;
            this.A = new ForwardingSeekMap(this.A) { // from class: androidx.media3.exoplayer.source.ProgressiveMediaPeriod.1
                @Override // androidx.media3.extractor.ForwardingSeekMap, androidx.media3.extractor.SeekMap
                public final long l() {
                    return ProgressiveMediaPeriod.this.B;
                }
            };
        }
        this.f7640g.n0(this.B, this.A.g(), this.C);
        this.w = true;
        MediaPeriod.Callback callback = this.r;
        callback.getClass();
        callback.j(this);
    }

    public final void y(int i2) {
        t();
        TrackState trackState = this.z;
        boolean[] zArr = trackState.f7668d;
        if (zArr[i2]) {
            return;
        }
        Format format = trackState.f7665a.a(i2).f5504d[0];
        this.f7638e.a(MimeTypes.i(format.f5225m), format, 0, null, this.I);
        zArr[i2] = true;
    }

    public final void z(int i2) {
        t();
        boolean[] zArr = this.z.f7666b;
        if (this.K && zArr[i2] && !this.t[i2].t(false)) {
            this.J = 0L;
            this.K = false;
            this.F = true;
            this.I = 0L;
            this.L = 0;
            for (SampleQueue sampleQueue : this.t) {
                sampleQueue.z(false);
            }
            MediaPeriod.Callback callback = this.r;
            callback.getClass();
            callback.k(this);
        }
    }
}
