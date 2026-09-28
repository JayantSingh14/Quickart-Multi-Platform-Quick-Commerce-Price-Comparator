package androidx.media3.exoplayer.hls;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.hls.HlsSampleStreamWrapper;
import androidx.media3.exoplayer.hls.playlist.DefaultHlsPlaylistTracker;
import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker;
import androidx.media3.exoplayer.source.DefaultCompositeSequenceableLoaderFactory;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
final class HlsMediaPeriod implements MediaPeriod, HlsPlaylistTracker.PlaylistEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final DefaultHlsExtractorFactory f7005a;

    /* renamed from: b, reason: collision with root package name */
    public final DefaultHlsPlaylistTracker f7006b;

    /* renamed from: c, reason: collision with root package name */
    public final DefaultHlsDataSourceFactory f7007c;

    /* renamed from: d, reason: collision with root package name */
    public final TransferListener f7008d;

    /* renamed from: e, reason: collision with root package name */
    public final CmcdConfiguration f7009e;

    /* renamed from: f, reason: collision with root package name */
    public final DrmSessionManager f7010f;

    /* renamed from: g, reason: collision with root package name */
    public final DrmSessionEventListener.EventDispatcher f7011g;

    /* renamed from: h, reason: collision with root package name */
    public final LoadErrorHandlingPolicy f7012h;

    /* renamed from: i, reason: collision with root package name */
    public final MediaSourceEventListener.EventDispatcher f7013i;

    /* renamed from: j, reason: collision with root package name */
    public final Allocator f7014j;

    /* renamed from: m, reason: collision with root package name */
    public final DefaultCompositeSequenceableLoaderFactory f7017m;
    public final boolean n;
    public final int o;
    public final PlayerId p;
    public MediaPeriod.Callback r;
    public int s;
    public TrackGroupArray t;
    public int w;
    public SequenceableLoader x;
    public final HlsSampleStreamWrapper.Callback q = new SampleStreamWrapperCallback();

    /* renamed from: k, reason: collision with root package name */
    public final IdentityHashMap f7015k = new IdentityHashMap();

    /* renamed from: l, reason: collision with root package name */
    public final TimestampAdjusterProvider f7016l = new TimestampAdjusterProvider();
    public HlsSampleStreamWrapper[] u = new HlsSampleStreamWrapper[0];
    public HlsSampleStreamWrapper[] v = new HlsSampleStreamWrapper[0];

    public class SampleStreamWrapperCallback implements HlsSampleStreamWrapper.Callback {
        public SampleStreamWrapperCallback() {
        }

        @Override // androidx.media3.exoplayer.hls.HlsSampleStreamWrapper.Callback
        public final void c() {
            HlsMediaPeriod hlsMediaPeriod = HlsMediaPeriod.this;
            int i2 = hlsMediaPeriod.s - 1;
            hlsMediaPeriod.s = i2;
            if (i2 > 0) {
                return;
            }
            int i3 = 0;
            for (HlsSampleStreamWrapper hlsSampleStreamWrapper : hlsMediaPeriod.u) {
                hlsSampleStreamWrapper.t();
                i3 += hlsSampleStreamWrapper.I.f7771a;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i3];
            int i4 = 0;
            for (HlsSampleStreamWrapper hlsSampleStreamWrapper2 : hlsMediaPeriod.u) {
                hlsSampleStreamWrapper2.t();
                int i5 = hlsSampleStreamWrapper2.I.f7771a;
                int i6 = 0;
                while (i6 < i5) {
                    hlsSampleStreamWrapper2.t();
                    trackGroupArr[i4] = hlsSampleStreamWrapper2.I.a(i6);
                    i6++;
                    i4++;
                }
            }
            hlsMediaPeriod.t = new TrackGroupArray(trackGroupArr);
            hlsMediaPeriod.r.j(hlsMediaPeriod);
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
        public final void k(SequenceableLoader sequenceableLoader) {
            HlsMediaPeriod hlsMediaPeriod = HlsMediaPeriod.this;
            hlsMediaPeriod.r.k(hlsMediaPeriod);
        }

        @Override // androidx.media3.exoplayer.hls.HlsSampleStreamWrapper.Callback
        public final void m(Uri uri) {
            HlsMediaPeriod.this.f7006b.g(uri);
        }
    }

    public HlsMediaPeriod(DefaultHlsExtractorFactory defaultHlsExtractorFactory, DefaultHlsPlaylistTracker defaultHlsPlaylistTracker, DefaultHlsDataSourceFactory defaultHlsDataSourceFactory, TransferListener transferListener, CmcdConfiguration cmcdConfiguration, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, Allocator allocator, DefaultCompositeSequenceableLoaderFactory defaultCompositeSequenceableLoaderFactory, boolean z, int i2, PlayerId playerId) {
        this.f7005a = defaultHlsExtractorFactory;
        this.f7006b = defaultHlsPlaylistTracker;
        this.f7007c = defaultHlsDataSourceFactory;
        this.f7008d = transferListener;
        this.f7009e = cmcdConfiguration;
        this.f7010f = drmSessionManager;
        this.f7011g = eventDispatcher;
        this.f7012h = loadErrorHandlingPolicy;
        this.f7013i = eventDispatcher2;
        this.f7014j = allocator;
        this.f7017m = defaultCompositeSequenceableLoaderFactory;
        this.n = z;
        this.o = i2;
        this.p = playerId;
        this.x = defaultCompositeSequenceableLoaderFactory.a();
    }

    public static Format k(Format format, Format format2, boolean z) {
        Metadata metadata;
        int i2;
        String str;
        String str2;
        ImmutableList immutableList;
        int i3;
        int i4;
        String str3;
        ImmutableList immutableListR = ImmutableList.r();
        if (format2 != null) {
            str2 = format2.f5222j;
            metadata = format2.f5223k;
            i3 = format2.A;
            i2 = format2.f5217e;
            i4 = format2.f5218f;
            str = format2.f5216d;
            str3 = format2.f5214b;
            immutableList = format2.f5215c;
        } else {
            String strU = Util.u(1, format.f5222j);
            metadata = format.f5223k;
            if (z) {
                i3 = format.A;
                i2 = format.f5217e;
                i4 = format.f5218f;
                str = format.f5216d;
                str3 = format.f5214b;
                str2 = strU;
                immutableList = format.f5215c;
            } else {
                i2 = 0;
                str = null;
                str2 = strU;
                immutableList = immutableListR;
                i3 = -1;
                i4 = 0;
                str3 = null;
            }
        }
        String strE = MimeTypes.e(str2);
        int i5 = z ? format.f5219g : -1;
        int i6 = z ? format.f5220h : -1;
        Format.Builder builder = new Format.Builder();
        builder.f5226a = format.f5213a;
        builder.f5227b = str3;
        builder.f5228c = ImmutableList.o(immutableList);
        builder.f5236k = MimeTypes.p(format.f5224l);
        builder.f5237l = MimeTypes.p(strE);
        builder.f5234i = str2;
        builder.f5235j = metadata;
        builder.f5232g = i5;
        builder.f5233h = i6;
        builder.z = i3;
        builder.f5230e = i2;
        builder.f5231f = i4;
        builder.f5229d = str;
        return new Format(builder);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0053 A[SYNTHETIC] */
    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(android.net.Uri r19, androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy.LoadErrorInfo r20, boolean r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            androidx.media3.exoplayer.hls.HlsSampleStreamWrapper[] r2 = r0.u
            int r3 = r2.length
            r6 = 0
            r7 = 1
        L9:
            if (r6 >= r3) goto L89
            r8 = r2[r6]
            androidx.media3.exoplayer.hls.HlsChunkSource r9 = r8.f7042d
            android.net.Uri[] r10 = r9.f6982e
            boolean r11 = androidx.media3.common.util.Util.m(r10, r1)
            if (r11 != 0) goto L1c
            r14 = r20
        L19:
            r4 = 1
            goto L85
        L1c:
            if (r21 != 0) goto L36
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r13 = r9.r
            androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy$FallbackOptions r13 = androidx.media3.exoplayer.trackselection.TrackSelectionUtil.a(r13)
            androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy r8 = r8.f7047i
            r14 = r20
            androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy$FallbackSelection r8 = r8.c(r13, r14)
            if (r8 == 0) goto L38
            int r13 = r8.f8160a
            r15 = 2
            if (r13 != r15) goto L38
            long r4 = r8.f8161b
            goto L3d
        L36:
            r14 = r20
        L38:
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L3d:
            r8 = 0
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L43:
            int r11 = r10.length
            r12 = -1
            if (r8 >= r11) goto L53
            r11 = r10[r8]
            boolean r11 = r11.equals(r1)
            if (r11 == 0) goto L50
            goto L54
        L50:
            int r8 = r8 + 1
            goto L43
        L53:
            r8 = r12
        L54:
            if (r8 != r12) goto L57
            goto L7f
        L57:
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r10 = r9.r
            int r8 = r10.l(r8)
            if (r8 != r12) goto L60
            goto L7f
        L60:
            boolean r10 = r9.t
            android.net.Uri r11 = r9.p
            boolean r11 = r1.equals(r11)
            r10 = r10 | r11
            r9.t = r10
            int r10 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r10 == 0) goto L7f
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r10 = r9.r
            boolean r8 = r10.h(r8, r4)
            if (r8 == 0) goto L84
            androidx.media3.exoplayer.hls.playlist.DefaultHlsPlaylistTracker r8 = r9.f6984g
            boolean r8 = r8.b(r4, r1)
            if (r8 == 0) goto L84
        L7f:
            int r4 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r4 == 0) goto L84
            goto L19
        L84:
            r4 = 0
        L85:
            r7 = r7 & r4
            int r6 = r6 + 1
            goto L9
        L89:
            androidx.media3.exoplayer.source.MediaPeriod$Callback r1 = r0.r
            r1.k(r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.HlsMediaPeriod.a(android.net.Uri, androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy$LoadErrorInfo, boolean):boolean");
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean b() {
        return this.x.b();
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
    public final void c() {
        for (final HlsSampleStreamWrapper hlsSampleStreamWrapper : this.u) {
            ArrayList arrayList = hlsSampleStreamWrapper.n;
            if (!arrayList.isEmpty()) {
                final HlsMediaChunk hlsMediaChunk = (HlsMediaChunk) Iterables.c(arrayList);
                int iB = hlsSampleStreamWrapper.f7042d.b(hlsMediaChunk);
                if (iB == 1) {
                    hlsMediaChunk.K = true;
                } else if (iB == 0) {
                    hlsSampleStreamWrapper.r.post(new Runnable() { // from class: androidx.media3.exoplayer.hls.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            hlsSampleStreamWrapper.f7041c.m(hlsMediaChunk.f7004m);
                        }
                    });
                } else if (iB == 2 && !hlsSampleStreamWrapper.C0) {
                    Loader loader = hlsSampleStreamWrapper.f7048j;
                    if (loader.d()) {
                        loader.a();
                    }
                }
            }
        }
        this.r.k(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long d(long j2, SeekParameters seekParameters) {
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.v;
        int length = hlsSampleStreamWrapperArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            HlsSampleStreamWrapper hlsSampleStreamWrapper = hlsSampleStreamWrapperArr[i2];
            if (hlsSampleStreamWrapper.A == 2) {
                HlsChunkSource hlsChunkSource = hlsSampleStreamWrapper.f7042d;
                int iD = hlsChunkSource.r.d();
                Uri[] uriArr = hlsChunkSource.f6982e;
                int length2 = uriArr.length;
                DefaultHlsPlaylistTracker defaultHlsPlaylistTracker = hlsChunkSource.f6984g;
                HlsMediaPlaylist hlsMediaPlaylistC = (iD >= length2 || iD == -1) ? null : defaultHlsPlaylistTracker.c(true, uriArr[hlsChunkSource.r.q()]);
                if (hlsMediaPlaylistC != null) {
                    ImmutableList immutableList = hlsMediaPlaylistC.r;
                    if (!immutableList.isEmpty() && hlsMediaPlaylistC.f7175c) {
                        long j3 = hlsMediaPlaylistC.f7125h - defaultHlsPlaylistTracker.n;
                        long j4 = j2 - j3;
                        int iD2 = Util.d(immutableList, Long.valueOf(j4), true, true);
                        long j5 = ((HlsMediaPlaylist.Segment) immutableList.get(iD2)).f7142e;
                        return seekParameters.a(j4, j5, iD2 != immutableList.size() - 1 ? ((HlsMediaPlaylist.Segment) immutableList.get(iD2 + 1)).f7142e : j5) + j3;
                    }
                }
            } else {
                i2++;
            }
        }
        return j2;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean e(LoadingInfo loadingInfo) {
        if (this.t != null) {
            return this.x.e(loadingInfo);
        }
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.u) {
            if (!hlsSampleStreamWrapper.D) {
                LoadingInfo.Builder builder = new LoadingInfo.Builder();
                builder.f6264a = hlsSampleStreamWrapper.Y;
                hlsSampleStreamWrapper.e(new LoadingInfo(builder));
            }
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long f() {
        return this.x.f();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long g(long j2) {
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.v;
        if (hlsSampleStreamWrapperArr.length > 0) {
            boolean zF = hlsSampleStreamWrapperArr[0].F(j2, false);
            int i2 = 1;
            while (true) {
                HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = this.v;
                if (i2 >= hlsSampleStreamWrapperArr2.length) {
                    break;
                }
                hlsSampleStreamWrapperArr2[i2].F(j2, zF);
                i2++;
            }
            if (zF) {
                this.f7016l.f7078a.clear();
            }
        }
        return j2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02e3  */
    /* JADX WARN: Type inference failed for: r27v1 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    @Override // androidx.media3.exoplayer.source.MediaPeriod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long h(androidx.media3.exoplayer.trackselection.ExoTrackSelection[] r39, boolean[] r40, androidx.media3.exoplayer.source.SampleStream[] r41, boolean[] r42, long r43) {
        /*
            Method dump skipped, instructions count: 828
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.HlsMediaPeriod.h(androidx.media3.exoplayer.trackselection.ExoTrackSelection[], boolean[], androidx.media3.exoplayer.source.SampleStream[], boolean[], long):long");
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long i() {
        return -9223372036854775807L;
    }

    public final HlsSampleStreamWrapper j(String str, int i2, Uri[] uriArr, Format[] formatArr, Format format, List list, Map map, long j2) {
        HlsChunkSource hlsChunkSource = new HlsChunkSource(this.f7005a, this.f7006b, uriArr, formatArr, this.f7007c, this.f7008d, this.f7016l, list, this.p, this.f7009e);
        HlsSampleStreamWrapper.Callback callback = this.q;
        MediaSourceEventListener.EventDispatcher eventDispatcher = this.f7013i;
        return new HlsSampleStreamWrapper(str, i2, callback, hlsChunkSource, map, this.f7014j, j2, format, this.f7010f, this.f7011g, this.f7012h, eventDispatcher, this.o);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void l() throws ParserException {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.u) {
            hlsSampleStreamWrapper.C();
            if (hlsSampleStreamWrapper.C0 && !hlsSampleStreamWrapper.D) {
                throw ParserException.a(null, "Loading finished before preparation is complete.");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0056  */
    @Override // androidx.media3.exoplayer.source.MediaPeriod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o(androidx.media3.exoplayer.source.MediaPeriod.Callback r24, long r25) {
        /*
            Method dump skipped, instructions count: 997
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.HlsMediaPeriod.o(androidx.media3.exoplayer.source.MediaPeriod$Callback, long):void");
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final TrackGroupArray p() {
        TrackGroupArray trackGroupArray = this.t;
        trackGroupArray.getClass();
        return trackGroupArray;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long q() {
        return this.x.q();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void r(long j2, boolean z) throws Throwable {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.v) {
            if (hlsSampleStreamWrapper.C && !hlsSampleStreamWrapper.A()) {
                int length = hlsSampleStreamWrapper.v.length;
                for (int i2 = 0; i2 < length; i2++) {
                    hlsSampleStreamWrapper.v[i2].h(j2, z, hlsSampleStreamWrapper.Q[i2]);
                }
            }
        }
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final void s(long j2) {
        this.x.s(j2);
    }
}
