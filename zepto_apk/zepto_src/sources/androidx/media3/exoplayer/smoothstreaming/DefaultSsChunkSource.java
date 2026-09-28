package androidx.media3.exoplayer.smoothstreaming;

import android.net.Uri;
import android.os.SystemClock;
import androidx.fragment.app.e;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.UriUtil;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.smoothstreaming.SsChunkSource;
import androidx.media3.exoplayer.smoothstreaming.manifest.SsManifest;
import androidx.media3.exoplayer.source.BehindLiveWindowException;
import androidx.media3.exoplayer.source.chunk.BaseMediaChunkIterator;
import androidx.media3.exoplayer.source.chunk.BundledChunkExtractor;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.exoplayer.source.chunk.ChunkHolder;
import androidx.media3.exoplayer.source.chunk.ContainerMediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelectionUtil;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoaderErrorThrower;
import androidx.media3.extractor.mp4.FragmentedMp4Extractor;
import androidx.media3.extractor.mp4.Track;
import androidx.media3.extractor.mp4.TrackEncryptionBox;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;
import com.google.common.collect.ImmutableList;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public class DefaultSsChunkSource implements SsChunkSource {

    /* renamed from: a, reason: collision with root package name */
    public final LoaderErrorThrower f7403a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7404b;

    /* renamed from: c, reason: collision with root package name */
    public final ChunkExtractor[] f7405c;

    /* renamed from: d, reason: collision with root package name */
    public final DataSource f7406d;

    /* renamed from: e, reason: collision with root package name */
    public final CmcdConfiguration f7407e;

    /* renamed from: f, reason: collision with root package name */
    public ExoTrackSelection f7408f;

    /* renamed from: g, reason: collision with root package name */
    public SsManifest f7409g;

    /* renamed from: h, reason: collision with root package name */
    public int f7410h;

    /* renamed from: i, reason: collision with root package name */
    public BehindLiveWindowException f7411i;

    /* renamed from: j, reason: collision with root package name */
    public long f7412j = -9223372036854775807L;

    public static final class Factory implements SsChunkSource.Factory {

        /* renamed from: a, reason: collision with root package name */
        public final DataSource.Factory f7413a;

        /* renamed from: b, reason: collision with root package name */
        public DefaultSubtitleParserFactory f7414b = new DefaultSubtitleParserFactory();

        /* renamed from: c, reason: collision with root package name */
        public boolean f7415c;

        public Factory(DataSource.Factory factory) {
            this.f7413a = factory;
        }
    }

    public static final class StreamElementIterator extends BaseMediaChunkIterator {

        /* renamed from: e, reason: collision with root package name */
        public final SsManifest.StreamElement f7416e;

        public StreamElementIterator(SsManifest.StreamElement streamElement, int i2) {
            super(i2, streamElement.f7465k - 1);
            this.f7416e = streamElement;
        }

        @Override // androidx.media3.exoplayer.source.chunk.MediaChunkIterator
        public final long a() {
            c();
            return this.f7416e.o[(int) this.f7833d];
        }

        @Override // androidx.media3.exoplayer.source.chunk.MediaChunkIterator
        public final long b() {
            return this.f7416e.c((int) this.f7833d) + a();
        }
    }

    public DefaultSsChunkSource(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i2, ExoTrackSelection exoTrackSelection, DataSource dataSource, CmcdConfiguration cmcdConfiguration, DefaultSubtitleParserFactory defaultSubtitleParserFactory, boolean z) {
        TrackEncryptionBox[] trackEncryptionBoxArr;
        this.f7403a = loaderErrorThrower;
        this.f7409g = ssManifest;
        this.f7404b = i2;
        this.f7408f = exoTrackSelection;
        this.f7406d = dataSource;
        this.f7407e = cmcdConfiguration;
        SsManifest.StreamElement streamElement = ssManifest.f7449f[i2];
        this.f7405c = new ChunkExtractor[exoTrackSelection.length()];
        for (int i3 = 0; i3 < this.f7405c.length; i3++) {
            int iF = exoTrackSelection.f(i3);
            Format format = streamElement.f7464j[iF];
            if (format.q != null) {
                SsManifest.ProtectionElement protectionElement = ssManifest.f7448e;
                protectionElement.getClass();
                trackEncryptionBoxArr = protectionElement.f7454c;
            } else {
                trackEncryptionBoxArr = null;
            }
            TrackEncryptionBox[] trackEncryptionBoxArr2 = trackEncryptionBoxArr;
            int i4 = streamElement.f7455a;
            this.f7405c[i3] = new BundledChunkExtractor(new FragmentedMp4Extractor(defaultSubtitleParserFactory, !z ? 35 : 3, null, new Track(iF, i4, streamElement.f7457c, -9223372036854775807L, ssManifest.f7450g, format, 0, trackEncryptionBoxArr2, i4 == 2 ? 4 : 0, null, null), ImmutableList.r(), null), streamElement.f7455a, format);
        }
    }

    @Override // androidx.media3.exoplayer.smoothstreaming.SsChunkSource
    public final void a(ExoTrackSelection exoTrackSelection) {
        this.f7408f = exoTrackSelection;
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkSource
    public final boolean b(Chunk chunk, boolean z, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        LoadErrorHandlingPolicy.FallbackSelection fallbackSelectionC = loadErrorHandlingPolicy.c(TrackSelectionUtil.a(this.f7408f), loadErrorInfo);
        if (!z || fallbackSelectionC == null || fallbackSelectionC.f8160a != 2) {
            return false;
        }
        ExoTrackSelection exoTrackSelection = this.f7408f;
        return exoTrackSelection.h(exoTrackSelection.c(chunk.f7858d), fallbackSelectionC.f8161b);
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkSource
    public final void c() throws BehindLiveWindowException {
        BehindLiveWindowException behindLiveWindowException = this.f7411i;
        if (behindLiveWindowException != null) {
            throw behindLiveWindowException;
        }
        this.f7403a.c();
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkSource
    public final long d(long j2, SeekParameters seekParameters) {
        SsManifest.StreamElement streamElement = this.f7409g.f7449f[this.f7404b];
        int iF = Util.f(streamElement.o, j2, true);
        long[] jArr = streamElement.o;
        long j3 = jArr[iF];
        return seekParameters.a(j2, j3, (j3 >= j2 || iF >= streamElement.f7465k - 1) ? j3 : jArr[iF + 1]);
    }

    @Override // androidx.media3.exoplayer.smoothstreaming.SsChunkSource
    public final void e(SsManifest ssManifest) {
        SsManifest.StreamElement[] streamElementArr = this.f7409g.f7449f;
        int i2 = this.f7404b;
        SsManifest.StreamElement streamElement = streamElementArr[i2];
        int i3 = streamElement.f7465k;
        SsManifest.StreamElement streamElement2 = ssManifest.f7449f[i2];
        if (i3 == 0 || streamElement2.f7465k == 0) {
            this.f7410h += i3;
        } else {
            int i4 = i3 - 1;
            long[] jArr = streamElement.o;
            long jC = streamElement.c(i4) + jArr[i4];
            long j2 = streamElement2.o[0];
            if (jC <= j2) {
                this.f7410h += i3;
            } else {
                this.f7410h = Util.f(jArr, j2, true) + this.f7410h;
            }
        }
        this.f7409g = ssManifest;
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkSource
    public final boolean g(long j2, Chunk chunk, List list) {
        if (this.f7411i != null) {
            return false;
        }
        return this.f7408f.n(j2, chunk, list);
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkSource
    public final void h(Chunk chunk) {
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkSource
    public final void i(LoadingInfo loadingInfo, long j2, List list, ChunkHolder chunkHolder) {
        List list2;
        int iC;
        long jC;
        CmcdData.Factory factory;
        if (this.f7411i != null) {
            return;
        }
        SsManifest.StreamElement[] streamElementArr = this.f7409g.f7449f;
        int i2 = this.f7404b;
        SsManifest.StreamElement streamElement = streamElementArr[i2];
        if (streamElement.f7465k == 0) {
            chunkHolder.f7865b = !r5.f7447d;
            return;
        }
        boolean zIsEmpty = list.isEmpty();
        long[] jArr = streamElement.o;
        if (zIsEmpty) {
            iC = Util.f(jArr, j2, true);
            list2 = list;
        } else {
            list2 = list;
            iC = (int) (((MediaChunk) e.k(1, list2)).c() - this.f7410h);
            if (iC < 0) {
                this.f7411i = new BehindLiveWindowException();
                return;
            }
        }
        int i3 = streamElement.f7465k;
        if (iC >= i3) {
            chunkHolder.f7865b = !this.f7409g.f7447d;
            return;
        }
        long j3 = loadingInfo.f6261a;
        long j4 = j2 - j3;
        SsManifest ssManifest = this.f7409g;
        if (ssManifest.f7447d) {
            SsManifest.StreamElement streamElement2 = ssManifest.f7449f[i2];
            int i4 = streamElement2.f7465k - 1;
            jC = (streamElement2.c(i4) + streamElement2.o[i4]) - j3;
        } else {
            jC = -9223372036854775807L;
        }
        int length = this.f7408f.length();
        MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[length];
        long j5 = jC;
        for (int i5 = 0; i5 < length; i5++) {
            this.f7408f.f(i5);
            mediaChunkIteratorArr[i5] = new StreamElementIterator(streamElement, iC);
        }
        int i6 = iC;
        this.f7408f.g(j3, j4, j5, list2, mediaChunkIteratorArr);
        long j6 = jArr[i6];
        long jC2 = streamElement.c(i6) + j6;
        long j7 = list.isEmpty() ? j2 : -9223372036854775807L;
        int i7 = i6 + this.f7410h;
        int iD = this.f7408f.d();
        ChunkExtractor chunkExtractor = this.f7405c[iD];
        int iF = this.f7408f.f(iD);
        Uri uriA = streamElement.a(iF, i6);
        if (this.f7407e != null) {
            CmcdData.Factory factory2 = new CmcdData.Factory(this.f7407e, this.f7408f, Math.max(0L, j4), loadingInfo.f6262b, "s", this.f7409g.f7447d, loadingInfo.a(this.f7412j), list.isEmpty());
            factory2.c(jC2 - j6);
            factory2.f8127j = CmcdData.Factory.b(this.f7408f);
            int i8 = i6 + 1;
            if (i8 < i3) {
                factory2.f8128k = UriUtil.a(uriA, streamElement.a(iF, i8));
            }
            factory = factory2;
        } else {
            factory = null;
        }
        this.f7412j = SystemClock.elapsedRealtime();
        Format formatR = this.f7408f.r();
        int iS = this.f7408f.s();
        Object objJ = this.f7408f.j();
        DataSpec.Builder builder = new DataSpec.Builder();
        builder.f5860a = uriA;
        DataSpec dataSpecA = builder.a();
        if (factory != null) {
            dataSpecA = factory.a().a(dataSpecA);
        }
        chunkHolder.f7864a = new ContainerMediaChunk(this.f7406d, dataSpecA, formatR, iS, objJ, j6, jC2, j7, -9223372036854775807L, i7, 1, j6, chunkExtractor);
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkSource
    public final int j(long j2, List list) {
        return (this.f7411i != null || this.f7408f.length() < 2) ? list.size() : this.f7408f.p(j2, list);
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkSource
    public final void release() {
        for (ChunkExtractor chunkExtractor : this.f7405c) {
            chunkExtractor.release();
        }
    }
}
