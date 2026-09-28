package androidx.media3.exoplayer.source.chunk;

import android.net.Uri;
import android.support.v4.media.b;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.source.chunk.ChunkSource;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public class ChunkSampleStream<T extends ChunkSource> implements SampleStream, SequenceableLoader, Loader.Callback<Chunk>, Loader.ReleaseCallback {

    /* renamed from: a, reason: collision with root package name */
    public final int f7866a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f7867b;

    /* renamed from: c, reason: collision with root package name */
    public final Format[] f7868c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean[] f7869d;

    /* renamed from: e, reason: collision with root package name */
    public final ChunkSource f7870e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f7871f;

    /* renamed from: g, reason: collision with root package name */
    public final MediaSourceEventListener.EventDispatcher f7872g;

    /* renamed from: h, reason: collision with root package name */
    public final LoadErrorHandlingPolicy f7873h;

    /* renamed from: i, reason: collision with root package name */
    public final Loader f7874i;

    /* renamed from: j, reason: collision with root package name */
    public final ChunkHolder f7875j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f7876k;

    /* renamed from: l, reason: collision with root package name */
    public final List f7877l;

    /* renamed from: m, reason: collision with root package name */
    public final SampleQueue f7878m;
    public final SampleQueue[] n;
    public final BaseMediaChunkOutput o;
    public Chunk p;
    public Format q;
    public ReleaseCallback r;
    public long s;
    public long t;
    public int u;
    public BaseMediaChunk v;
    public boolean w;

    public final class EmbeddedSampleStream implements SampleStream {

        /* renamed from: a, reason: collision with root package name */
        public final ChunkSampleStream f7879a;

        /* renamed from: b, reason: collision with root package name */
        public final SampleQueue f7880b;

        /* renamed from: c, reason: collision with root package name */
        public final int f7881c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f7882d;

        public EmbeddedSampleStream(ChunkSampleStream chunkSampleStream, SampleQueue sampleQueue, int i2) {
            this.f7879a = chunkSampleStream;
            this.f7880b = sampleQueue;
            this.f7881c = i2;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final boolean a() {
            ChunkSampleStream chunkSampleStream = ChunkSampleStream.this;
            return !chunkSampleStream.w() && this.f7880b.t(chunkSampleStream.w);
        }

        public final void b() {
            if (this.f7882d) {
                return;
            }
            ChunkSampleStream chunkSampleStream = ChunkSampleStream.this;
            MediaSourceEventListener.EventDispatcher eventDispatcher = chunkSampleStream.f7872g;
            int[] iArr = chunkSampleStream.f7867b;
            int i2 = this.f7881c;
            eventDispatcher.a(iArr[i2], chunkSampleStream.f7868c[i2], 0, null, chunkSampleStream.t);
            this.f7882d = true;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final void c() {
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final int m(long j2) throws Throwable {
            ChunkSampleStream chunkSampleStream = ChunkSampleStream.this;
            if (chunkSampleStream.w()) {
                return 0;
            }
            boolean z = chunkSampleStream.w;
            SampleQueue sampleQueue = this.f7880b;
            int iR = sampleQueue.r(j2, z);
            BaseMediaChunk baseMediaChunk = chunkSampleStream.v;
            if (baseMediaChunk != null) {
                iR = Math.min(iR, baseMediaChunk.e(this.f7881c + 1) - sampleQueue.p());
            }
            sampleQueue.C(iR);
            if (iR > 0) {
                b();
            }
            return iR;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final int n(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            ChunkSampleStream chunkSampleStream = ChunkSampleStream.this;
            if (chunkSampleStream.w()) {
                return -3;
            }
            BaseMediaChunk baseMediaChunk = chunkSampleStream.v;
            SampleQueue sampleQueue = this.f7880b;
            if (baseMediaChunk != null && baseMediaChunk.e(this.f7881c + 1) <= sampleQueue.p()) {
                return -3;
            }
            b();
            return sampleQueue.y(formatHolder, decoderInputBuffer, i2, chunkSampleStream.w);
        }
    }

    public interface ReleaseCallback<T extends ChunkSource> {
        void a(ChunkSampleStream chunkSampleStream);
    }

    public ChunkSampleStream(int i2, int[] iArr, Format[] formatArr, ChunkSource chunkSource, SequenceableLoader.Callback callback, Allocator allocator, long j2, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2) {
        this.f7866a = i2;
        int i3 = 0;
        iArr = iArr == null ? new int[0] : iArr;
        this.f7867b = iArr;
        this.f7868c = formatArr == null ? new Format[0] : formatArr;
        this.f7870e = chunkSource;
        this.f7871f = callback;
        this.f7872g = eventDispatcher2;
        this.f7873h = loadErrorHandlingPolicy;
        this.f7874i = new Loader("ChunkSampleStream");
        this.f7875j = new ChunkHolder();
        ArrayList arrayList = new ArrayList();
        this.f7876k = arrayList;
        this.f7877l = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.n = new SampleQueue[length];
        this.f7869d = new boolean[length];
        int i4 = length + 1;
        int[] iArr2 = new int[i4];
        SampleQueue[] sampleQueueArr = new SampleQueue[i4];
        drmSessionManager.getClass();
        SampleQueue sampleQueue = new SampleQueue(allocator, drmSessionManager, eventDispatcher);
        this.f7878m = sampleQueue;
        iArr2[0] = i2;
        sampleQueueArr[0] = sampleQueue;
        while (i3 < length) {
            SampleQueue sampleQueue2 = new SampleQueue(allocator, null, null);
            this.n[i3] = sampleQueue2;
            int i5 = i3 + 1;
            sampleQueueArr[i5] = sampleQueue2;
            iArr2[i5] = this.f7867b[i3];
            i3 = i5;
        }
        this.o = new BaseMediaChunkOutput(iArr2, sampleQueueArr);
        this.s = j2;
        this.t = j2;
    }

    public final void A(long j2) throws Throwable {
        ArrayList arrayList;
        BaseMediaChunk baseMediaChunk;
        this.t = j2;
        if (w()) {
            this.s = j2;
            return;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            arrayList = this.f7876k;
            if (i3 >= arrayList.size()) {
                break;
            }
            baseMediaChunk = (BaseMediaChunk) arrayList.get(i3);
            long j3 = baseMediaChunk.f7861g;
            if (j3 == j2 && baseMediaChunk.f7828k == -9223372036854775807L) {
                break;
            } else if (j3 > j2) {
                break;
            } else {
                i3++;
            }
        }
        baseMediaChunk = null;
        SampleQueue sampleQueue = this.f7878m;
        boolean zA = baseMediaChunk != null ? sampleQueue.A(baseMediaChunk.e(0)) : sampleQueue.B(j2, j2 < f());
        SampleQueue[] sampleQueueArr = this.n;
        if (zA) {
            this.u = y(sampleQueue.p(), 0);
            int length = sampleQueueArr.length;
            while (i2 < length) {
                sampleQueueArr[i2].B(j2, true);
                i2++;
            }
            return;
        }
        this.s = j2;
        this.w = false;
        arrayList.clear();
        this.u = 0;
        Loader loader = this.f7874i;
        if (loader.d()) {
            sampleQueue.i();
            int length2 = sampleQueueArr.length;
            while (i2 < length2) {
                sampleQueueArr[i2].i();
                i2++;
            }
            loader.a();
            return;
        }
        loader.f8169c = null;
        sampleQueue.z(false);
        for (SampleQueue sampleQueue2 : sampleQueueArr) {
            sampleQueue2.z(false);
        }
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public final boolean a() {
        return !w() && this.f7878m.t(this.w);
    }

    /* JADX WARN: Type inference failed for: r13v2, types: [androidx.media3.exoplayer.source.SequenceableLoader$Callback, java.lang.Object] */
    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final void a0(Loader.Loadable loadable, long j2, long j3) {
        Chunk chunk = (Chunk) loadable;
        this.p = null;
        this.f7870e.h(chunk);
        long j4 = chunk.f7855a;
        StatsDataSource statsDataSource = chunk.f7863i;
        Uri uri = statsDataSource.f5931c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(j4, statsDataSource.f5932d, j3);
        this.f7873h.getClass();
        this.f7872g.f(loadEventInfo, chunk.f7857c, this.f7866a, chunk.f7858d, chunk.f7859e, chunk.f7860f, chunk.f7861g, chunk.f7862h);
        this.f7871f.k(this);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean b() {
        return this.f7874i.d();
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public final void c() throws IOException {
        Loader loader = this.f7874i;
        loader.c();
        this.f7878m.v();
        if (loader.d()) {
            return;
        }
        this.f7870e.c();
    }

    /* JADX WARN: Type inference failed for: r13v5, types: [androidx.media3.exoplayer.source.SequenceableLoader$Callback, java.lang.Object] */
    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final void d0(Loader.Loadable loadable, long j2, long j3, boolean z) {
        Chunk chunk = (Chunk) loadable;
        this.p = null;
        this.v = null;
        long j4 = chunk.f7855a;
        StatsDataSource statsDataSource = chunk.f7863i;
        Uri uri = statsDataSource.f5931c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(j4, statsDataSource.f5932d, j3);
        this.f7873h.getClass();
        this.f7872g.c(loadEventInfo, chunk.f7857c, this.f7866a, chunk.f7858d, chunk.f7859e, chunk.f7860f, chunk.f7861g, chunk.f7862h);
        if (z) {
            return;
        }
        if (w()) {
            this.f7878m.z(false);
            for (SampleQueue sampleQueue : this.n) {
                sampleQueue.z(false);
            }
        } else if (chunk instanceof BaseMediaChunk) {
            ArrayList arrayList = this.f7876k;
            t(arrayList.size() - 1);
            if (arrayList.isEmpty()) {
                this.s = this.t;
            }
        }
        this.f7871f.k(this);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean e(LoadingInfo loadingInfo) {
        long j2;
        List list;
        if (!this.w) {
            Loader loader = this.f7874i;
            if (!loader.d() && !loader.b()) {
                boolean zW = w();
                if (zW) {
                    list = Collections.EMPTY_LIST;
                    j2 = this.s;
                } else {
                    j2 = u().f7862h;
                    list = this.f7877l;
                }
                this.f7870e.i(loadingInfo, j2, list, this.f7875j);
                ChunkHolder chunkHolder = this.f7875j;
                boolean z = chunkHolder.f7865b;
                Chunk chunk = chunkHolder.f7864a;
                chunkHolder.f7864a = null;
                chunkHolder.f7865b = false;
                if (z) {
                    this.s = -9223372036854775807L;
                    this.w = true;
                    return true;
                }
                if (chunk != null) {
                    this.p = chunk;
                    boolean z2 = chunk instanceof BaseMediaChunk;
                    BaseMediaChunkOutput baseMediaChunkOutput = this.o;
                    if (z2) {
                        BaseMediaChunk baseMediaChunk = (BaseMediaChunk) chunk;
                        if (zW) {
                            long j3 = this.s;
                            if (baseMediaChunk.f7861g != j3) {
                                this.f7878m.t = j3;
                                for (SampleQueue sampleQueue : this.n) {
                                    sampleQueue.t = this.s;
                                }
                            }
                            this.s = -9223372036854775807L;
                        }
                        baseMediaChunk.f7830m = baseMediaChunkOutput;
                        SampleQueue[] sampleQueueArr = baseMediaChunkOutput.f7835b;
                        int[] iArr = new int[sampleQueueArr.length];
                        for (int i2 = 0; i2 < sampleQueueArr.length; i2++) {
                            SampleQueue sampleQueue2 = sampleQueueArr[i2];
                            iArr[i2] = sampleQueue2.q + sampleQueue2.p;
                        }
                        baseMediaChunk.n = iArr;
                        this.f7876k.add(baseMediaChunk);
                    } else if (chunk instanceof InitializationChunk) {
                        ((InitializationChunk) chunk).f7887k = baseMediaChunkOutput;
                    }
                    loader.g(chunk, this, this.f7873h.b(chunk.f7857c));
                    this.f7872g.k(new LoadEventInfo(chunk.f7855a, chunk.f7856b), chunk.f7857c, this.f7866a, chunk.f7858d, chunk.f7859e, chunk.f7860f, chunk.f7861g, chunk.f7862h);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long f() {
        if (w()) {
            return this.s;
        }
        if (this.w) {
            return Long.MIN_VALUE;
        }
        return u().f7862h;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.ReleaseCallback
    public final void j() {
        SampleQueue sampleQueue = this.f7878m;
        sampleQueue.z(true);
        DrmSession drmSession = sampleQueue.f7699h;
        if (drmSession != null) {
            drmSession.f(sampleQueue.f7696e);
            sampleQueue.f7699h = null;
            sampleQueue.f7698g = null;
        }
        for (SampleQueue sampleQueue2 : this.n) {
            sampleQueue2.z(true);
            DrmSession drmSession2 = sampleQueue2.f7699h;
            if (drmSession2 != null) {
                drmSession2.f(sampleQueue2.f7696e);
                sampleQueue2.f7699h = null;
                sampleQueue2.f7698g = null;
            }
        }
        this.f7870e.release();
        ReleaseCallback releaseCallback = this.r;
        if (releaseCallback != null) {
            releaseCallback.a(this);
        }
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.media3.exoplayer.source.SequenceableLoader$Callback, java.lang.Object] */
    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final Loader.LoadErrorAction k(Loader.Loadable loadable, long j2, long j3, IOException iOException, int i2) {
        Loader.LoadErrorAction loadErrorAction;
        Chunk chunk = (Chunk) loadable;
        long j4 = chunk.f7863i.f5930b;
        boolean z = chunk instanceof BaseMediaChunk;
        ArrayList arrayList = this.f7876k;
        int size = arrayList.size() - 1;
        boolean z2 = (j4 != 0 && z && v(size)) ? false : true;
        StatsDataSource statsDataSource = chunk.f7863i;
        Uri uri = statsDataSource.f5931c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.f7855a, statsDataSource.f5932d, j3);
        Util.j0(chunk.f7861g);
        Util.j0(chunk.f7862h);
        LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(iOException, i2);
        ChunkSource chunkSource = this.f7870e;
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f7873h;
        if (!chunkSource.b(chunk, z2, loadErrorInfo, loadErrorHandlingPolicy)) {
            loadErrorAction = null;
        } else if (z2) {
            if (z) {
                Assertions.g(t(size) == chunk);
                if (arrayList.isEmpty()) {
                    this.s = this.t;
                }
            }
            loadErrorAction = Loader.f8165e;
        } else {
            Log.h("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
            loadErrorAction = null;
        }
        if (loadErrorAction == null) {
            long jA = loadErrorHandlingPolicy.a(loadErrorInfo);
            loadErrorAction = jA != -9223372036854775807L ? new Loader.LoadErrorAction(0, jA) : Loader.f8166f;
        }
        boolean zA = loadErrorAction.a();
        this.f7872g.h(loadEventInfo, chunk.f7857c, this.f7866a, chunk.f7858d, chunk.f7859e, chunk.f7860f, chunk.f7861g, chunk.f7862h, iOException, !zA);
        if (!zA) {
            this.p = null;
            loadErrorHandlingPolicy.getClass();
            this.f7871f.k(this);
        }
        return loadErrorAction;
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public final int m(long j2) throws Throwable {
        if (w()) {
            return 0;
        }
        SampleQueue sampleQueue = this.f7878m;
        int iR = sampleQueue.r(j2, this.w);
        BaseMediaChunk baseMediaChunk = this.v;
        if (baseMediaChunk != null) {
            iR = Math.min(iR, baseMediaChunk.e(0) - sampleQueue.p());
        }
        sampleQueue.C(iR);
        x();
        return iR;
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public final int n(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
        if (w()) {
            return -3;
        }
        BaseMediaChunk baseMediaChunk = this.v;
        SampleQueue sampleQueue = this.f7878m;
        if (baseMediaChunk != null && baseMediaChunk.e(0) <= sampleQueue.p()) {
            return -3;
        }
        x();
        return sampleQueue.y(formatHolder, decoderInputBuffer, i2, this.w);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long q() {
        long j2;
        if (this.w) {
            return Long.MIN_VALUE;
        }
        if (w()) {
            return this.s;
        }
        long jMax = this.t;
        BaseMediaChunk baseMediaChunkU = u();
        if (!baseMediaChunkU.d()) {
            ArrayList arrayList = this.f7876k;
            baseMediaChunkU = arrayList.size() > 1 ? (BaseMediaChunk) b.c(2, arrayList) : null;
        }
        if (baseMediaChunkU != null) {
            jMax = Math.max(jMax, baseMediaChunkU.f7862h);
        }
        SampleQueue sampleQueue = this.f7878m;
        synchronized (sampleQueue) {
            j2 = sampleQueue.v;
        }
        return Math.max(jMax, j2);
    }

    public final void r(long j2, boolean z) throws Throwable {
        long j3;
        if (w()) {
            return;
        }
        SampleQueue sampleQueue = this.f7878m;
        int i2 = sampleQueue.q;
        sampleQueue.h(j2, z, true);
        SampleQueue sampleQueue2 = this.f7878m;
        int i3 = sampleQueue2.q;
        if (i3 > i2) {
            synchronized (sampleQueue2) {
                j3 = sampleQueue2.p == 0 ? Long.MIN_VALUE : sampleQueue2.n[sampleQueue2.r];
            }
            int i4 = 0;
            while (true) {
                SampleQueue[] sampleQueueArr = this.n;
                if (i4 >= sampleQueueArr.length) {
                    break;
                }
                sampleQueueArr[i4].h(j3, z, this.f7869d[i4]);
                i4++;
            }
        }
        int iMin = Math.min(y(i3, 0), this.u);
        if (iMin > 0) {
            Util.Y(0, iMin, this.f7876k);
            this.u -= iMin;
        }
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final void s(long j2) {
        Loader loader = this.f7874i;
        if (loader.b() || w()) {
            return;
        }
        boolean zD = loader.d();
        ArrayList arrayList = this.f7876k;
        List list = this.f7877l;
        ChunkSource chunkSource = this.f7870e;
        if (zD) {
            Chunk chunk = this.p;
            chunk.getClass();
            boolean z = chunk instanceof BaseMediaChunk;
            if (!(z && v(arrayList.size() - 1)) && chunkSource.g(j2, chunk, list)) {
                loader.a();
                if (z) {
                    this.v = (BaseMediaChunk) chunk;
                    return;
                }
                return;
            }
            return;
        }
        int iJ = chunkSource.j(j2, list);
        if (iJ < arrayList.size()) {
            Assertions.g(!loader.d());
            int size = arrayList.size();
            while (true) {
                if (iJ >= size) {
                    iJ = -1;
                    break;
                } else if (!v(iJ)) {
                    break;
                } else {
                    iJ++;
                }
            }
            if (iJ == -1) {
                return;
            }
            long j3 = u().f7862h;
            BaseMediaChunk baseMediaChunkT = t(iJ);
            if (arrayList.isEmpty()) {
                this.s = this.t;
            }
            this.w = false;
            this.f7872g.m(new MediaLoadData(1, this.f7866a, null, 3, null, Util.j0(baseMediaChunkT.f7861g), Util.j0(j3)));
        }
    }

    public final BaseMediaChunk t(int i2) {
        ArrayList arrayList = this.f7876k;
        BaseMediaChunk baseMediaChunk = (BaseMediaChunk) arrayList.get(i2);
        Util.Y(i2, arrayList.size(), arrayList);
        this.u = Math.max(this.u, arrayList.size());
        int i3 = 0;
        this.f7878m.l(baseMediaChunk.e(0));
        while (true) {
            SampleQueue[] sampleQueueArr = this.n;
            if (i3 >= sampleQueueArr.length) {
                return baseMediaChunk;
            }
            SampleQueue sampleQueue = sampleQueueArr[i3];
            i3++;
            sampleQueue.l(baseMediaChunk.e(i3));
        }
    }

    public final BaseMediaChunk u() {
        return (BaseMediaChunk) b.c(1, this.f7876k);
    }

    public final boolean v(int i2) {
        int iP;
        BaseMediaChunk baseMediaChunk = (BaseMediaChunk) this.f7876k.get(i2);
        if (this.f7878m.p() > baseMediaChunk.e(0)) {
            return true;
        }
        int i3 = 0;
        do {
            SampleQueue[] sampleQueueArr = this.n;
            if (i3 >= sampleQueueArr.length) {
                return false;
            }
            iP = sampleQueueArr[i3].p();
            i3++;
        } while (iP <= baseMediaChunk.e(i3));
        return true;
    }

    public final boolean w() {
        return this.s != -9223372036854775807L;
    }

    public final void x() {
        int iY = y(this.f7878m.p(), this.u - 1);
        while (true) {
            int i2 = this.u;
            if (i2 > iY) {
                return;
            }
            this.u = i2 + 1;
            BaseMediaChunk baseMediaChunk = (BaseMediaChunk) this.f7876k.get(i2);
            Format format = baseMediaChunk.f7858d;
            if (!format.equals(this.q)) {
                this.f7872g.a(this.f7866a, format, baseMediaChunk.f7859e, baseMediaChunk.f7860f, baseMediaChunk.f7861g);
            }
            this.q = format;
        }
    }

    public final int y(int i2, int i3) {
        ArrayList arrayList;
        do {
            i3++;
            arrayList = this.f7876k;
            if (i3 >= arrayList.size()) {
                return arrayList.size() - 1;
            }
        } while (((BaseMediaChunk) arrayList.get(i3)).e(0) <= i2);
        return i3 - 1;
    }

    public final void z(ReleaseCallback releaseCallback) {
        this.r = releaseCallback;
        SampleQueue sampleQueue = this.f7878m;
        sampleQueue.i();
        DrmSession drmSession = sampleQueue.f7699h;
        if (drmSession != null) {
            drmSession.f(sampleQueue.f7696e);
            sampleQueue.f7699h = null;
            sampleQueue.f7698g = null;
        }
        for (SampleQueue sampleQueue2 : this.n) {
            sampleQueue2.i();
            DrmSession drmSession2 = sampleQueue2.f7699h;
            if (drmSession2 != null) {
                drmSession2.f(sampleQueue2.f7696e);
                sampleQueue2.f7699h = null;
                sampleQueue2.f7698g = null;
            }
        }
        this.f7874i.f(this);
    }
}
