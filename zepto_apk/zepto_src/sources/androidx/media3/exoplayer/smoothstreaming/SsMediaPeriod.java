package androidx.media3.exoplayer.smoothstreaming;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.TrackGroup;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.analytics.p;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.smoothstreaming.DefaultSsChunkSource;
import androidx.media3.exoplayer.smoothstreaming.manifest.SsManifest;
import androidx.media3.exoplayer.source.CompositeSequenceableLoader;
import androidx.media3.exoplayer.source.DefaultCompositeSequenceableLoaderFactory;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.source.chunk.ChunkSampleStream;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoaderErrorThrower;
import com.google.common.collect.Lists;
import java.util.AbstractList;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
final class SsMediaPeriod implements MediaPeriod, SequenceableLoader.Callback<ChunkSampleStream<SsChunkSource>> {

    /* renamed from: a, reason: collision with root package name */
    public final DefaultSsChunkSource.Factory f7417a;

    /* renamed from: b, reason: collision with root package name */
    public final TransferListener f7418b;

    /* renamed from: c, reason: collision with root package name */
    public final LoaderErrorThrower f7419c;

    /* renamed from: d, reason: collision with root package name */
    public final DrmSessionManager f7420d;

    /* renamed from: e, reason: collision with root package name */
    public final CmcdConfiguration f7421e;

    /* renamed from: f, reason: collision with root package name */
    public final DrmSessionEventListener.EventDispatcher f7422f;

    /* renamed from: g, reason: collision with root package name */
    public final LoadErrorHandlingPolicy f7423g;

    /* renamed from: h, reason: collision with root package name */
    public final MediaSourceEventListener.EventDispatcher f7424h;

    /* renamed from: i, reason: collision with root package name */
    public final Allocator f7425i;

    /* renamed from: j, reason: collision with root package name */
    public final TrackGroupArray f7426j;

    /* renamed from: k, reason: collision with root package name */
    public final DefaultCompositeSequenceableLoaderFactory f7427k;

    /* renamed from: l, reason: collision with root package name */
    public MediaPeriod.Callback f7428l;

    /* renamed from: m, reason: collision with root package name */
    public SsManifest f7429m;
    public ChunkSampleStream[] n;
    public SequenceableLoader o;

    public SsMediaPeriod(SsManifest ssManifest, DefaultSsChunkSource.Factory factory, TransferListener transferListener, DefaultCompositeSequenceableLoaderFactory defaultCompositeSequenceableLoaderFactory, CmcdConfiguration cmcdConfiguration, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, LoaderErrorThrower loaderErrorThrower, Allocator allocator) {
        this.f7429m = ssManifest;
        this.f7417a = factory;
        this.f7418b = transferListener;
        this.f7419c = loaderErrorThrower;
        this.f7421e = cmcdConfiguration;
        this.f7420d = drmSessionManager;
        this.f7422f = eventDispatcher;
        this.f7423g = loadErrorHandlingPolicy;
        this.f7424h = eventDispatcher2;
        this.f7425i = allocator;
        this.f7427k = defaultCompositeSequenceableLoaderFactory;
        TrackGroup[] trackGroupArr = new TrackGroup[ssManifest.f7449f.length];
        int i2 = 0;
        while (true) {
            SsManifest.StreamElement[] streamElementArr = ssManifest.f7449f;
            if (i2 >= streamElementArr.length) {
                this.f7426j = new TrackGroupArray(trackGroupArr);
                this.n = new ChunkSampleStream[0];
                this.o = defaultCompositeSequenceableLoaderFactory.a();
                return;
            }
            Format[] formatArr = streamElementArr[i2].f7464j;
            Format[] formatArr2 = new Format[formatArr.length];
            for (int i3 = 0; i3 < formatArr.length; i3++) {
                Format format = formatArr[i3];
                Format.Builder builderA = format.a();
                builderA.I = drmSessionManager.c(format);
                Format format2 = new Format(builderA);
                if (factory.f7415c && factory.f7414b.b(format2)) {
                    Format.Builder builderA2 = format2.a();
                    builderA2.f5237l = MimeTypes.p("application/x-media3-cues");
                    builderA2.F = factory.f7414b.a(format2);
                    StringBuilder sb = new StringBuilder();
                    sb.append(format2.f5225m);
                    String str = format2.f5222j;
                    sb.append(str != null ? StringUtils.SPACE.concat(str) : "");
                    builderA2.f5234i = sb.toString();
                    builderA2.q = Long.MAX_VALUE;
                    format2 = new Format(builderA2);
                }
                formatArr2[i3] = format2;
            }
            trackGroupArr[i2] = new TrackGroup(Integer.toString(i2), formatArr2);
            i2++;
        }
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean b() {
        return this.o.b();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long d(long j2, SeekParameters seekParameters) {
        for (ChunkSampleStream chunkSampleStream : this.n) {
            if (chunkSampleStream.f7866a == 2) {
                return chunkSampleStream.f7870e.d(j2, seekParameters);
            }
        }
        return j2;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean e(LoadingInfo loadingInfo) {
        return this.o.e(loadingInfo);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long f() {
        return this.o.f();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long g(long j2) throws Throwable {
        for (ChunkSampleStream chunkSampleStream : this.n) {
            chunkSampleStream.A(j2);
        }
        return j2;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long h(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        ExoTrackSelection exoTrackSelection;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            SampleStream sampleStream = sampleStreamArr[i2];
            if (sampleStream != null) {
                ChunkSampleStream chunkSampleStream = (ChunkSampleStream) sampleStream;
                ExoTrackSelection exoTrackSelection2 = exoTrackSelectionArr[i2];
                if (exoTrackSelection2 == null || !zArr[i2]) {
                    chunkSampleStream.z(null);
                    sampleStreamArr[i2] = null;
                } else {
                    ((SsChunkSource) chunkSampleStream.f7870e).a(exoTrackSelection2);
                    arrayList.add(chunkSampleStream);
                }
            }
            if (sampleStreamArr[i2] == null && (exoTrackSelection = exoTrackSelectionArr[i2]) != null) {
                int iB = this.f7426j.b(exoTrackSelection.m());
                SsManifest ssManifest = this.f7429m;
                DefaultSsChunkSource.Factory factory = this.f7417a;
                DataSource dataSourceA = factory.f7413a.a();
                TransferListener transferListener = this.f7418b;
                if (transferListener != null) {
                    dataSourceA.a(transferListener);
                }
                ChunkSampleStream chunkSampleStream2 = new ChunkSampleStream(this.f7429m.f7449f[iB].f7455a, null, null, new DefaultSsChunkSource(this.f7419c, ssManifest, iB, exoTrackSelection, dataSourceA, this.f7421e, factory.f7414b, factory.f7415c), this, this.f7425i, j2, this.f7420d, this.f7422f, this.f7423g, this.f7424h);
                arrayList.add(chunkSampleStream2);
                sampleStreamArr[i2] = chunkSampleStream2;
                zArr2[i2] = true;
            }
        }
        ChunkSampleStream[] chunkSampleStreamArr = new ChunkSampleStream[arrayList.size()];
        this.n = chunkSampleStreamArr;
        arrayList.toArray(chunkSampleStreamArr);
        AbstractList abstractListD = Lists.d(new p(7), arrayList);
        this.f7427k.getClass();
        this.o = new CompositeSequenceableLoader(arrayList, abstractListD);
        return j2;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long i() {
        return -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
    public final void k(SequenceableLoader sequenceableLoader) {
        MediaPeriod.Callback callback = this.f7428l;
        callback.getClass();
        callback.k(this);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void l() {
        this.f7419c.c();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void o(MediaPeriod.Callback callback, long j2) {
        this.f7428l = callback;
        callback.j(this);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final TrackGroupArray p() {
        return this.f7426j;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long q() {
        return this.o.q();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void r(long j2, boolean z) throws Throwable {
        for (ChunkSampleStream chunkSampleStream : this.n) {
            chunkSampleStream.r(j2, z);
        }
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final void s(long j2) {
        this.o.s(j2);
    }
}
