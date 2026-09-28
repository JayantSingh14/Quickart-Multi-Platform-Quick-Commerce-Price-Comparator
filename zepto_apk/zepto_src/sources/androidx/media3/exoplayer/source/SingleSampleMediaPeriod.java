package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class SingleSampleMediaPeriod implements MediaPeriod, Loader.Callback<SourceLoadable> {

    /* renamed from: a, reason: collision with root package name */
    public final DataSpec f7731a;

    /* renamed from: b, reason: collision with root package name */
    public final DataSource.Factory f7732b;

    /* renamed from: c, reason: collision with root package name */
    public final TransferListener f7733c;

    /* renamed from: d, reason: collision with root package name */
    public final LoadErrorHandlingPolicy f7734d;

    /* renamed from: e, reason: collision with root package name */
    public final MediaSourceEventListener.EventDispatcher f7735e;

    /* renamed from: f, reason: collision with root package name */
    public final TrackGroupArray f7736f;

    /* renamed from: h, reason: collision with root package name */
    public final long f7738h;

    /* renamed from: j, reason: collision with root package name */
    public final Format f7740j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f7741k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f7742l;

    /* renamed from: m, reason: collision with root package name */
    public byte[] f7743m;
    public int n;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f7737g = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final Loader f7739i = new Loader("SingleSampleMediaPeriod");

    public final class SampleStreamImpl implements SampleStream {

        /* renamed from: a, reason: collision with root package name */
        public int f7744a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f7745b;

        public SampleStreamImpl() {
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final boolean a() {
            return SingleSampleMediaPeriod.this.f7742l;
        }

        public final void b() {
            if (this.f7745b) {
                return;
            }
            SingleSampleMediaPeriod singleSampleMediaPeriod = SingleSampleMediaPeriod.this;
            singleSampleMediaPeriod.f7735e.a(MimeTypes.i(singleSampleMediaPeriod.f7740j.f5225m), singleSampleMediaPeriod.f7740j, 0, null, 0L);
            this.f7745b = true;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final void c() throws IOException {
            SingleSampleMediaPeriod singleSampleMediaPeriod = SingleSampleMediaPeriod.this;
            if (singleSampleMediaPeriod.f7741k) {
                return;
            }
            singleSampleMediaPeriod.f7739i.c();
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final int m(long j2) {
            b();
            if (j2 <= 0 || this.f7744a == 2) {
                return 0;
            }
            this.f7744a = 2;
            return 1;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final int n(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            b();
            SingleSampleMediaPeriod singleSampleMediaPeriod = SingleSampleMediaPeriod.this;
            boolean z = singleSampleMediaPeriod.f7742l;
            if (z && singleSampleMediaPeriod.f7743m == null) {
                this.f7744a = 2;
            }
            int i3 = this.f7744a;
            if (i3 == 2) {
                decoderInputBuffer.e(4);
                return -4;
            }
            if ((i2 & 2) != 0 || i3 == 0) {
                formatHolder.f6254b = singleSampleMediaPeriod.f7740j;
                this.f7744a = 1;
                return -5;
            }
            if (!z) {
                return -3;
            }
            singleSampleMediaPeriod.f7743m.getClass();
            decoderInputBuffer.e(1);
            decoderInputBuffer.f6073f = 0L;
            if ((i2 & 4) == 0) {
                decoderInputBuffer.l(singleSampleMediaPeriod.n);
                decoderInputBuffer.f6071d.put(singleSampleMediaPeriod.f7743m, 0, singleSampleMediaPeriod.n);
            }
            if ((i2 & 1) == 0) {
                this.f7744a = 2;
            }
            return -4;
        }
    }

    public static final class SourceLoadable implements Loader.Loadable {

        /* renamed from: a, reason: collision with root package name */
        public final long f7747a = LoadEventInfo.f7578d.getAndIncrement();

        /* renamed from: b, reason: collision with root package name */
        public final DataSpec f7748b;

        /* renamed from: c, reason: collision with root package name */
        public final StatsDataSource f7749c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f7750d;

        public SourceLoadable(DataSource dataSource, DataSpec dataSpec) {
            this.f7748b = dataSpec;
            this.f7749c = new StatsDataSource(dataSource);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
        public final void a() {
            StatsDataSource statsDataSource = this.f7749c;
            statsDataSource.f5930b = 0L;
            try {
                statsDataSource.j(this.f7748b);
                int i2 = 0;
                while (i2 != -1) {
                    int i3 = (int) statsDataSource.f5930b;
                    byte[] bArr = this.f7750d;
                    if (bArr == null) {
                        this.f7750d = new byte[1024];
                    } else if (i3 == bArr.length) {
                        this.f7750d = Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    byte[] bArr2 = this.f7750d;
                    i2 = statsDataSource.read(bArr2, i3, bArr2.length - i3);
                }
                DataSourceUtil.a(statsDataSource);
            } catch (Throwable th) {
                DataSourceUtil.a(statsDataSource);
                throw th;
            }
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
        public final void b() {
        }
    }

    public SingleSampleMediaPeriod(DataSpec dataSpec, DataSource.Factory factory, TransferListener transferListener, Format format, long j2, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher, boolean z) {
        this.f7731a = dataSpec;
        this.f7732b = factory;
        this.f7733c = transferListener;
        this.f7740j = format;
        this.f7738h = j2;
        this.f7734d = loadErrorHandlingPolicy;
        this.f7735e = eventDispatcher;
        this.f7741k = z;
        this.f7736f = new TrackGroupArray(new TrackGroup("", format));
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final void a0(Loader.Loadable loadable, long j2, long j3) {
        SourceLoadable sourceLoadable = (SourceLoadable) loadable;
        this.n = (int) sourceLoadable.f7749c.f5930b;
        byte[] bArr = sourceLoadable.f7750d;
        bArr.getClass();
        this.f7743m = bArr;
        this.f7742l = true;
        StatsDataSource statsDataSource = sourceLoadable.f7749c;
        Uri uri = statsDataSource.f5931c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable.f7747a, statsDataSource.f5932d, j3);
        this.f7734d.getClass();
        this.f7735e.f(loadEventInfo, 1, -1, this.f7740j, 0, null, 0L, this.f7738h);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean b() {
        return this.f7739i.d();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long d(long j2, SeekParameters seekParameters) {
        return j2;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final void d0(Loader.Loadable loadable, long j2, long j3, boolean z) {
        SourceLoadable sourceLoadable = (SourceLoadable) loadable;
        StatsDataSource statsDataSource = sourceLoadable.f7749c;
        Uri uri = statsDataSource.f5931c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable.f7747a, statsDataSource.f5932d, j3);
        this.f7734d.getClass();
        this.f7735e.c(loadEventInfo, 1, -1, null, 0, null, 0L, this.f7738h);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean e(LoadingInfo loadingInfo) {
        if (this.f7742l) {
            return false;
        }
        Loader loader = this.f7739i;
        if (loader.d() || loader.b()) {
            return false;
        }
        DataSource dataSourceA = this.f7732b.a();
        TransferListener transferListener = this.f7733c;
        if (transferListener != null) {
            dataSourceA.a(transferListener);
        }
        DataSpec dataSpec = this.f7731a;
        SourceLoadable sourceLoadable = new SourceLoadable(dataSourceA, dataSpec);
        loader.g(sourceLoadable, this, this.f7734d.b(1));
        this.f7735e.k(new LoadEventInfo(sourceLoadable.f7747a, dataSpec), 1, -1, this.f7740j, 0, null, 0L, this.f7738h);
        return true;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long f() {
        return (this.f7742l || this.f7739i.d()) ? Long.MIN_VALUE : 0L;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long g(long j2) {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f7737g;
            if (i2 >= arrayList.size()) {
                return j2;
            }
            SampleStreamImpl sampleStreamImpl = (SampleStreamImpl) arrayList.get(i2);
            if (sampleStreamImpl.f7744a == 2) {
                sampleStreamImpl.f7744a = 1;
            }
            i2++;
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long h(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            SampleStream sampleStream = sampleStreamArr[i2];
            ArrayList arrayList = this.f7737g;
            if (sampleStream != null && (exoTrackSelectionArr[i2] == null || !zArr[i2])) {
                arrayList.remove(sampleStream);
                sampleStreamArr[i2] = null;
            }
            if (sampleStreamArr[i2] == null && exoTrackSelectionArr[i2] != null) {
                SampleStreamImpl sampleStreamImpl = new SampleStreamImpl();
                arrayList.add(sampleStreamImpl);
                sampleStreamArr[i2] = sampleStreamImpl;
                zArr2[i2] = true;
            }
        }
        return j2;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long i() {
        return -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final Loader.LoadErrorAction k(Loader.Loadable loadable, long j2, long j3, IOException iOException, int i2) {
        Loader.LoadErrorAction loadErrorAction;
        SourceLoadable sourceLoadable = (SourceLoadable) loadable;
        StatsDataSource statsDataSource = sourceLoadable.f7749c;
        Uri uri = statsDataSource.f5931c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable.f7747a, statsDataSource.f5932d, j3);
        Util.j0(this.f7738h);
        LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(iOException, i2);
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f7734d;
        long jA = loadErrorHandlingPolicy.a(loadErrorInfo);
        boolean z = jA == -9223372036854775807L || i2 >= loadErrorHandlingPolicy.b(1);
        if (this.f7741k && z) {
            Log.i("SingleSampleMediaPeriod", "Loading failed, treating as end-of-stream.", iOException);
            this.f7742l = true;
            loadErrorAction = Loader.f8165e;
        } else {
            loadErrorAction = jA != -9223372036854775807L ? new Loader.LoadErrorAction(0, jA) : Loader.f8166f;
        }
        this.f7735e.h(loadEventInfo, 1, -1, this.f7740j, 0, null, 0L, this.f7738h, iOException, !loadErrorAction.a());
        return loadErrorAction;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void l() {
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void o(MediaPeriod.Callback callback, long j2) {
        callback.j(this);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final TrackGroupArray p() {
        return this.f7736f;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long q() {
        return this.f7742l ? Long.MIN_VALUE : 0L;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void r(long j2, boolean z) {
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final void s(long j2) {
    }
}
