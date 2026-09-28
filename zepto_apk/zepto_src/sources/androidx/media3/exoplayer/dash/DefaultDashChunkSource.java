package androidx.media3.exoplayer.dash;

import android.os.SystemClock;
import android.util.Pair;
import androidx.fragment.app.e;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.UriUtil;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.dash.DashChunkSource;
import androidx.media3.exoplayer.dash.PlayerEmsgHandler;
import androidx.media3.exoplayer.dash.manifest.AdaptationSet;
import androidx.media3.exoplayer.dash.manifest.BaseUrl;
import androidx.media3.exoplayer.dash.manifest.DashManifest;
import androidx.media3.exoplayer.dash.manifest.RangedUri;
import androidx.media3.exoplayer.dash.manifest.Representation;
import androidx.media3.exoplayer.source.BehindLiveWindowException;
import androidx.media3.exoplayer.source.chunk.BaseMediaChunkIterator;
import androidx.media3.exoplayer.source.chunk.BundledChunkExtractor;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.exoplayer.source.chunk.ChunkHolder;
import androidx.media3.exoplayer.source.chunk.ContainerMediaChunk;
import androidx.media3.exoplayer.source.chunk.InitializationChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import androidx.media3.exoplayer.source.chunk.SingleSampleMediaChunk;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoaderErrorThrower;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.jpeg.JpegExtractor;
import androidx.media3.extractor.mkv.MatroskaExtractor;
import androidx.media3.extractor.mp4.FragmentedMp4Extractor;
import androidx.media3.extractor.png.PngExtractor;
import androidx.media3.extractor.text.SubtitleExtractor;
import androidx.media3.extractor.text.SubtitleTranscodingExtractor;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.reactnativecommunity.clipboard.ClipboardModule;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@UnstableApi
/* loaded from: classes3.dex */
public class DefaultDashChunkSource implements DashChunkSource {

    /* renamed from: a, reason: collision with root package name */
    public final LoaderErrorThrower f6730a;

    /* renamed from: b, reason: collision with root package name */
    public final BaseUrlExclusionList f6731b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f6732c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6733d;

    /* renamed from: e, reason: collision with root package name */
    public final DataSource f6734e;

    /* renamed from: f, reason: collision with root package name */
    public final long f6735f;

    /* renamed from: g, reason: collision with root package name */
    public final int f6736g;

    /* renamed from: h, reason: collision with root package name */
    public final PlayerEmsgHandler.PlayerTrackEmsgHandler f6737h;

    /* renamed from: i, reason: collision with root package name */
    public final CmcdConfiguration f6738i;

    /* renamed from: j, reason: collision with root package name */
    public final RepresentationHolder[] f6739j;

    /* renamed from: k, reason: collision with root package name */
    public ExoTrackSelection f6740k;

    /* renamed from: l, reason: collision with root package name */
    public DashManifest f6741l;

    /* renamed from: m, reason: collision with root package name */
    public int f6742m;
    public BehindLiveWindowException n;
    public boolean o;
    public long p;

    public static final class Factory implements DashChunkSource.Factory {

        /* renamed from: a, reason: collision with root package name */
        public final DataSource.Factory f6743a;

        /* renamed from: c, reason: collision with root package name */
        public final BundledChunkExtractor.Factory f6745c = BundledChunkExtractor.f7836j;

        /* renamed from: b, reason: collision with root package name */
        public final int f6744b = 1;

        public Factory(DataSource.Factory factory) {
            this.f6743a = factory;
        }
    }

    public static final class RepresentationHolder {

        /* renamed from: a, reason: collision with root package name */
        public final ChunkExtractor f6746a;

        /* renamed from: b, reason: collision with root package name */
        public final Representation f6747b;

        /* renamed from: c, reason: collision with root package name */
        public final BaseUrl f6748c;

        /* renamed from: d, reason: collision with root package name */
        public final DashSegmentIndex f6749d;

        /* renamed from: e, reason: collision with root package name */
        public final long f6750e;

        /* renamed from: f, reason: collision with root package name */
        public final long f6751f;

        public RepresentationHolder(long j2, Representation representation, BaseUrl baseUrl, ChunkExtractor chunkExtractor, long j3, DashSegmentIndex dashSegmentIndex) {
            this.f6750e = j2;
            this.f6747b = representation;
            this.f6748c = baseUrl;
            this.f6751f = j3;
            this.f6746a = chunkExtractor;
            this.f6749d = dashSegmentIndex;
        }

        public final RepresentationHolder a(long j2, Representation representation) throws BehindLiveWindowException {
            long jG;
            long jG2;
            DashSegmentIndex dashSegmentIndexL = this.f6747b.l();
            DashSegmentIndex dashSegmentIndexL2 = representation.l();
            if (dashSegmentIndexL == null) {
                return new RepresentationHolder(j2, representation, this.f6748c, this.f6746a, this.f6751f, dashSegmentIndexL);
            }
            if (!dashSegmentIndexL.i()) {
                return new RepresentationHolder(j2, representation, this.f6748c, this.f6746a, this.f6751f, dashSegmentIndexL2);
            }
            long jH = dashSegmentIndexL.h(j2);
            if (jH == 0) {
                return new RepresentationHolder(j2, representation, this.f6748c, this.f6746a, this.f6751f, dashSegmentIndexL2);
            }
            Assertions.h(dashSegmentIndexL2);
            long j3 = dashSegmentIndexL.j();
            long jB = dashSegmentIndexL.b(j3);
            long j4 = jH + j3;
            long j5 = j4 - 1;
            long jC = dashSegmentIndexL.c(j5, j2) + dashSegmentIndexL.b(j5);
            long j6 = dashSegmentIndexL2.j();
            long jB2 = dashSegmentIndexL2.b(j6);
            long j7 = this.f6751f;
            if (jC == jB2) {
                jG = j4 - j6;
            } else {
                if (jC < jB2) {
                    throw new BehindLiveWindowException();
                }
                if (jB2 < jB) {
                    jG2 = j7 - (dashSegmentIndexL2.g(jB, j2) - j3);
                    return new RepresentationHolder(j2, representation, this.f6748c, this.f6746a, jG2, dashSegmentIndexL2);
                }
                jG = dashSegmentIndexL.g(jB2, j2) - j6;
            }
            jG2 = jG + j7;
            return new RepresentationHolder(j2, representation, this.f6748c, this.f6746a, jG2, dashSegmentIndexL2);
        }

        public final long b(long j2) {
            DashSegmentIndex dashSegmentIndex = this.f6749d;
            Assertions.h(dashSegmentIndex);
            return dashSegmentIndex.d(this.f6750e, j2) + this.f6751f;
        }

        public final long c(long j2) {
            long jB = b(j2);
            DashSegmentIndex dashSegmentIndex = this.f6749d;
            Assertions.h(dashSegmentIndex);
            return (dashSegmentIndex.k(this.f6750e, j2) + jB) - 1;
        }

        public final long d() {
            DashSegmentIndex dashSegmentIndex = this.f6749d;
            Assertions.h(dashSegmentIndex);
            return dashSegmentIndex.h(this.f6750e);
        }

        public final long e(long j2) {
            long jF = f(j2);
            DashSegmentIndex dashSegmentIndex = this.f6749d;
            Assertions.h(dashSegmentIndex);
            return dashSegmentIndex.c(j2 - this.f6751f, this.f6750e) + jF;
        }

        public final long f(long j2) {
            DashSegmentIndex dashSegmentIndex = this.f6749d;
            Assertions.h(dashSegmentIndex);
            return dashSegmentIndex.b(j2 - this.f6751f);
        }

        public final boolean g(long j2, long j3) {
            DashSegmentIndex dashSegmentIndex = this.f6749d;
            Assertions.h(dashSegmentIndex);
            return dashSegmentIndex.i() || j3 == -9223372036854775807L || e(j2) <= j3;
        }
    }

    public static final class RepresentationSegmentIterator extends BaseMediaChunkIterator {

        /* renamed from: e, reason: collision with root package name */
        public final RepresentationHolder f6752e;

        public RepresentationSegmentIterator(RepresentationHolder representationHolder, long j2, long j3) {
            super(j2, j3);
            this.f6752e = representationHolder;
        }

        @Override // androidx.media3.exoplayer.source.chunk.MediaChunkIterator
        public final long a() {
            c();
            return this.f6752e.f(this.f7833d);
        }

        @Override // androidx.media3.exoplayer.source.chunk.MediaChunkIterator
        public final long b() {
            c();
            return this.f6752e.e(this.f7833d);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.media3.exoplayer.dash.DefaultDashChunkSource, java.lang.Object] */
    public DefaultDashChunkSource(BundledChunkExtractor.Factory factory, LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList, int i2, int[] iArr, ExoTrackSelection exoTrackSelection, int i3, DataSource dataSource, long j2, int i4, boolean z, ArrayList arrayList, PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, PlayerId playerId, CmcdConfiguration cmcdConfiguration) {
        int i5;
        RepresentationHolder[] representationHolderArr;
        String str;
        Format format;
        Representation representation;
        Extractor fragmentedMp4Extractor;
        BundledChunkExtractor bundledChunkExtractor;
        ?? obj = new Object();
        obj.f6730a = loaderErrorThrower;
        obj.f6741l = dashManifest;
        obj.f6731b = baseUrlExclusionList;
        obj.f6732c = iArr;
        obj.f6740k = exoTrackSelection;
        obj.f6733d = i3;
        obj.f6734e = dataSource;
        obj.f6742m = i2;
        obj.f6735f = j2;
        obj.f6736g = i4;
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2 = playerTrackEmsgHandler;
        obj.f6737h = playerTrackEmsgHandler2;
        obj.f6738i = cmcdConfiguration;
        obj.p = -9223372036854775807L;
        long jD = dashManifest.d(i2);
        ArrayList arrayListL = obj.l();
        obj.f6739j = new RepresentationHolder[exoTrackSelection.length()];
        int i6 = 0;
        int i7 = 0;
        DefaultDashChunkSource defaultDashChunkSource = obj;
        while (i7 < defaultDashChunkSource.f6739j.length) {
            Representation representation2 = (Representation) arrayListL.get(exoTrackSelection.f(i7));
            BaseUrl baseUrlC = baseUrlExclusionList.c(representation2.f6836b);
            RepresentationHolder[] representationHolderArr2 = defaultDashChunkSource.f6739j;
            BaseUrl baseUrl = baseUrlC == null ? (BaseUrl) representation2.f6836b.get(i6) : baseUrlC;
            factory.getClass();
            Format format2 = representation2.f6835a;
            String str2 = format2.f5224l;
            if (!MimeTypes.n(str2)) {
                boolean z2 = false;
                if (str2 != null && (str2.startsWith("video/webm") || str2.startsWith("audio/webm") || str2.startsWith("application/webm") || str2.startsWith("video/x-matroska") || str2.startsWith("audio/x-matroska") || str2.startsWith("application/x-matroska"))) {
                    z2 = true;
                }
                if (z2) {
                    fragmentedMp4Extractor = new MatroskaExtractor(factory.f7854b ? 1 : 3, factory.f7853a);
                } else if (Objects.equals(str2, "image/jpeg")) {
                    fragmentedMp4Extractor = new JpegExtractor(1);
                } else if (Objects.equals(str2, ClipboardModule.MIMETYPE_PNG)) {
                    fragmentedMp4Extractor = new PngExtractor();
                } else {
                    int i8 = z ? 4 : 0;
                    i5 = i7;
                    representationHolderArr = representationHolderArr2;
                    str = str2;
                    int i9 = factory.f7854b ? i8 : i8 | 32;
                    format = format2;
                    representation = representation2;
                    fragmentedMp4Extractor = new FragmentedMp4Extractor(factory.f7853a, i9, null, null, arrayList, playerTrackEmsgHandler2);
                    if (factory.f7854b && !MimeTypes.n(str) && !(fragmentedMp4Extractor.e() instanceof FragmentedMp4Extractor) && !(fragmentedMp4Extractor.e() instanceof MatroskaExtractor)) {
                        fragmentedMp4Extractor = new SubtitleTranscodingExtractor(fragmentedMp4Extractor, factory.f7853a);
                    }
                    bundledChunkExtractor = new BundledChunkExtractor(fragmentedMp4Extractor, i3, format);
                    long j3 = jD;
                    representationHolderArr[i5] = new RepresentationHolder(j3, representation, baseUrl, bundledChunkExtractor, 0L, representation.l());
                    i7 = i5 + 1;
                    defaultDashChunkSource = this;
                    playerTrackEmsgHandler2 = playerTrackEmsgHandler;
                    jD = j3;
                    i6 = 0;
                }
            } else if (factory.f7854b) {
                fragmentedMp4Extractor = new SubtitleExtractor(factory.f7853a.c(format2), format2);
            } else {
                bundledChunkExtractor = null;
                i5 = i7;
                representation = representation2;
                representationHolderArr = representationHolderArr2;
                long j32 = jD;
                representationHolderArr[i5] = new RepresentationHolder(j32, representation, baseUrl, bundledChunkExtractor, 0L, representation.l());
                i7 = i5 + 1;
                defaultDashChunkSource = this;
                playerTrackEmsgHandler2 = playerTrackEmsgHandler;
                jD = j32;
                i6 = 0;
            }
            i5 = i7;
            representation = representation2;
            format = format2;
            representationHolderArr = representationHolderArr2;
            str = str2;
            if (factory.f7854b) {
                fragmentedMp4Extractor = new SubtitleTranscodingExtractor(fragmentedMp4Extractor, factory.f7853a);
            }
            bundledChunkExtractor = new BundledChunkExtractor(fragmentedMp4Extractor, i3, format);
            long j322 = jD;
            representationHolderArr[i5] = new RepresentationHolder(j322, representation, baseUrl, bundledChunkExtractor, 0L, representation.l());
            i7 = i5 + 1;
            defaultDashChunkSource = this;
            playerTrackEmsgHandler2 = playerTrackEmsgHandler;
            jD = j322;
            i6 = 0;
        }
    }

    public static Pair k(long j2, RangedUri rangedUri, RepresentationHolder representationHolder) {
        long j3 = j2 + 1;
        if (j3 >= representationHolder.d()) {
            return null;
        }
        DashSegmentIndex dashSegmentIndex = representationHolder.f6749d;
        Assertions.h(dashSegmentIndex);
        RangedUri rangedUriF = dashSegmentIndex.f(j3 - representationHolder.f6751f);
        BaseUrl baseUrl = representationHolder.f6748c;
        String strA = UriUtil.a(UriUtil.e(baseUrl.f6785a, rangedUri.f6833c), UriUtil.e(baseUrl.f6785a, rangedUriF.f6833c));
        StringBuilder sb = new StringBuilder();
        long j4 = rangedUriF.f6831a;
        String strP = android.support.v4.media.b.p(sb, j4, "-");
        long j5 = rangedUriF.f6832b;
        if (j5 != -1) {
            StringBuilder sbW = android.support.v4.media.b.w(strP);
            sbW.append(j4 + j5);
            strP = sbW.toString();
        }
        return new Pair(strA, strP);
    }

    @Override // androidx.media3.exoplayer.dash.DashChunkSource
    public final void a(ExoTrackSelection exoTrackSelection) {
        this.f6740k = exoTrackSelection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.chunk.ChunkSource
    public final boolean b(Chunk chunk, boolean z, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        LoadErrorHandlingPolicy.FallbackSelection fallbackSelectionC;
        long jMax;
        if (z) {
            PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.f6737h;
            if (playerTrackEmsgHandler != null) {
                long j2 = playerTrackEmsgHandler.f6775d;
                boolean z2 = j2 != -9223372036854775807L && j2 < chunk.f7861g;
                PlayerEmsgHandler playerEmsgHandler = PlayerEmsgHandler.this;
                if (playerEmsgHandler.f6766f.f6792d) {
                    if (!playerEmsgHandler.f6768h) {
                        if (z2) {
                            if (playerEmsgHandler.f6767g) {
                                playerEmsgHandler.f6768h = true;
                                playerEmsgHandler.f6767g = false;
                                DashMediaSource dashMediaSource = DashMediaSource.this;
                                dashMediaSource.E.removeCallbacks(dashMediaSource.x);
                                dashMediaSource.q0();
                                return true;
                            }
                        }
                    }
                    return true;
                }
            }
            boolean z3 = this.f6741l.f6792d;
            RepresentationHolder[] representationHolderArr = this.f6739j;
            if (!z3 && (chunk instanceof MediaChunk)) {
                IOException iOException = loadErrorInfo.f8162a;
                if ((iOException instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) iOException).f5900d == 404) {
                    RepresentationHolder representationHolder = representationHolderArr[this.f6740k.c(chunk.f7858d)];
                    long jD = representationHolder.d();
                    if (jD != -1 && jD != 0) {
                        DashSegmentIndex dashSegmentIndex = representationHolder.f6749d;
                        Assertions.h(dashSegmentIndex);
                        if (((MediaChunk) chunk).c() > ((dashSegmentIndex.j() + representationHolder.f6751f) + jD) - 1) {
                            this.o = true;
                            return true;
                        }
                    }
                }
            }
            RepresentationHolder representationHolder2 = representationHolderArr[this.f6740k.c(chunk.f7858d)];
            ImmutableList immutableList = representationHolder2.f6747b.f6836b;
            BaseUrlExclusionList baseUrlExclusionList = this.f6731b;
            BaseUrl baseUrlC = baseUrlExclusionList.c(immutableList);
            BaseUrl baseUrl = representationHolder2.f6748c;
            if (baseUrlC == null || baseUrl.equals(baseUrlC)) {
                ExoTrackSelection exoTrackSelection = this.f6740k;
                ImmutableList immutableList2 = representationHolder2.f6747b.f6836b;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                int length = exoTrackSelection.length();
                int i2 = 0;
                for (int i3 = 0; i3 < length; i3++) {
                    if (exoTrackSelection.b(i3, jElapsedRealtime)) {
                        i2++;
                    }
                }
                HashSet hashSet = new HashSet();
                for (int i4 = 0; i4 < immutableList2.size(); i4++) {
                    hashSet.add(Integer.valueOf(((BaseUrl) immutableList2.get(i4)).f6787c));
                }
                int size = hashSet.size();
                HashSet hashSet2 = new HashSet();
                ArrayList arrayListA = baseUrlExclusionList.a(immutableList2);
                for (int i5 = 0; i5 < arrayListA.size(); i5++) {
                    hashSet2.add(Integer.valueOf(((BaseUrl) arrayListA.get(i5)).f6787c));
                }
                LoadErrorHandlingPolicy.FallbackOptions fallbackOptions = new LoadErrorHandlingPolicy.FallbackOptions(size, size - hashSet2.size(), length, i2);
                if ((fallbackOptions.a(2) || fallbackOptions.a(1)) && (fallbackSelectionC = loadErrorHandlingPolicy.c(fallbackOptions, loadErrorInfo)) != null) {
                    int i6 = fallbackSelectionC.f8160a;
                    if (fallbackOptions.a(i6)) {
                        long j3 = fallbackSelectionC.f8161b;
                        if (i6 == 2) {
                            ExoTrackSelection exoTrackSelection2 = this.f6740k;
                            return exoTrackSelection2.h(exoTrackSelection2.c(chunk.f7858d), j3);
                        }
                        if (i6 == 1) {
                            long jElapsedRealtime2 = SystemClock.elapsedRealtime() + j3;
                            String str = baseUrl.f6786b;
                            HashMap map = baseUrlExclusionList.f6673a;
                            if (map.containsKey(str)) {
                                Long l2 = (Long) map.get(str);
                                int i7 = Util.f5744a;
                                jMax = Math.max(jElapsedRealtime2, l2.longValue());
                            } else {
                                jMax = jElapsedRealtime2;
                            }
                            map.put(str, Long.valueOf(jMax));
                            int i8 = baseUrl.f6787c;
                            if (i8 != Integer.MIN_VALUE) {
                                Integer numValueOf = Integer.valueOf(i8);
                                HashMap map2 = baseUrlExclusionList.f6674b;
                                if (map2.containsKey(numValueOf)) {
                                    Long l3 = (Long) map2.get(numValueOf);
                                    int i9 = Util.f5744a;
                                    jElapsedRealtime2 = Math.max(jElapsedRealtime2, l3.longValue());
                                }
                                map2.put(numValueOf, Long.valueOf(jElapsedRealtime2));
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkSource
    public final void c() throws BehindLiveWindowException {
        BehindLiveWindowException behindLiveWindowException = this.n;
        if (behindLiveWindowException != null) {
            throw behindLiveWindowException;
        }
        this.f6730a.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    @Override // androidx.media3.exoplayer.source.chunk.ChunkSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long d(long r19, androidx.media3.exoplayer.SeekParameters r21) {
        /*
            r18 = this;
            r1 = r19
            r7 = r18
            androidx.media3.exoplayer.dash.DefaultDashChunkSource$RepresentationHolder[] r0 = r7.f6739j
            int r3 = r0.length
            r4 = 0
        L8:
            if (r4 >= r3) goto L60
            r5 = r0[r4]
            androidx.media3.exoplayer.dash.DashSegmentIndex r6 = r5.f6749d
            if (r6 == 0) goto L5b
            long r8 = r5.d()
            r10 = 0
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 != 0) goto L1b
            goto L5b
        L1b:
            androidx.media3.exoplayer.dash.DashSegmentIndex r0 = r5.f6749d
            androidx.media3.common.util.Assertions.h(r0)
            long r3 = r5.f6750e
            long r3 = r0.g(r1, r3)
            long r10 = r5.f6751f
            long r3 = r3 + r10
            r12 = r3
            long r3 = r5.f(r12)
            int r6 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r6 >= 0) goto L54
            r14 = -1
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            r14 = 1
            if (r6 == 0) goto L4b
            androidx.media3.common.util.Assertions.h(r0)
            long r16 = r0.j()
            long r16 = r16 + r10
            long r16 = r16 + r8
            long r16 = r16 - r14
            int r0 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r0 >= 0) goto L54
        L4b:
            long r8 = r12 + r14
            long r5 = r5.f(r8)
        L51:
            r0 = r21
            goto L56
        L54:
            r5 = r3
            goto L51
        L56:
            long r0 = r0.a(r1, r3, r5)
            return r0
        L5b:
            int r4 = r4 + 1
            r1 = r19
            goto L8
        L60:
            return r19
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.DefaultDashChunkSource.d(long, androidx.media3.exoplayer.SeekParameters):long");
    }

    @Override // androidx.media3.exoplayer.dash.DashChunkSource
    public final void f(DashManifest dashManifest, int i2) {
        RepresentationHolder[] representationHolderArr = this.f6739j;
        try {
            this.f6741l = dashManifest;
            this.f6742m = i2;
            long jD = dashManifest.d(i2);
            ArrayList arrayListL = l();
            for (int i3 = 0; i3 < representationHolderArr.length; i3++) {
                representationHolderArr[i3] = representationHolderArr[i3].a(jD, (Representation) arrayListL.get(this.f6740k.f(i3)));
            }
        } catch (BehindLiveWindowException e2) {
            this.n = e2;
        }
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkSource
    public final boolean g(long j2, Chunk chunk, List list) {
        if (this.n != null) {
            return false;
        }
        return this.f6740k.n(j2, chunk, list);
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkSource
    public final void h(Chunk chunk) {
        if (chunk instanceof InitializationChunk) {
            int iC = this.f6740k.c(((InitializationChunk) chunk).f7858d);
            RepresentationHolder[] representationHolderArr = this.f6739j;
            RepresentationHolder representationHolder = representationHolderArr[iC];
            if (representationHolder.f6749d == null) {
                ChunkExtractor chunkExtractor = representationHolder.f6746a;
                Assertions.h(chunkExtractor);
                ChunkIndex chunkIndexB = chunkExtractor.b();
                if (chunkIndexB != null) {
                    Representation representation = representationHolder.f6747b;
                    DashWrappingSegmentIndex dashWrappingSegmentIndex = new DashWrappingSegmentIndex(chunkIndexB, representation.f6837c);
                    representationHolderArr[iC] = new RepresentationHolder(representationHolder.f6750e, representation, representationHolder.f6748c, representationHolder.f6746a, representationHolder.f6751f, dashWrappingSegmentIndex);
                }
            }
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.f6737h;
        if (playerTrackEmsgHandler != null) {
            long j2 = playerTrackEmsgHandler.f6775d;
            if (j2 == -9223372036854775807L || chunk.f7862h > j2) {
                playerTrackEmsgHandler.f6775d = chunk.f7862h;
            }
            PlayerEmsgHandler.this.f6767g = true;
        }
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkSource
    public final void i(LoadingInfo loadingInfo, long j2, List list, ChunkHolder chunkHolder) {
        long j3;
        List list2;
        MediaChunk mediaChunk;
        RepresentationHolder[] representationHolderArr;
        long jMax;
        CmcdData.Factory factory;
        long j4;
        RepresentationHolder representationHolder;
        long jC;
        Chunk containerMediaChunk;
        long j5;
        MediaChunkIterator mediaChunkIterator;
        long jL;
        boolean z;
        ChunkHolder chunkHolder2 = chunkHolder;
        if (this.n != null) {
            return;
        }
        long j6 = loadingInfo.f6261a;
        long j7 = j2 - j6;
        long jT = Util.T(this.f6741l.b(this.f6742m).f6823b) + Util.T(this.f6741l.f6789a) + j2;
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.f6737h;
        if (playerTrackEmsgHandler != null) {
            PlayerEmsgHandler playerEmsgHandler = PlayerEmsgHandler.this;
            DashManifest dashManifest = playerEmsgHandler.f6766f;
            j3 = -9223372036854775807L;
            if (!dashManifest.f6792d) {
                z = false;
            } else if (playerEmsgHandler.f6768h) {
                z = true;
            } else {
                Map.Entry entryCeilingEntry = playerEmsgHandler.f6765e.ceilingEntry(Long.valueOf(dashManifest.f6796h));
                PlayerEmsgHandler.PlayerEmsgCallback playerEmsgCallback = playerEmsgHandler.f6762b;
                if (entryCeilingEntry == null || ((Long) entryCeilingEntry.getValue()).longValue() >= jT) {
                    z = false;
                } else {
                    long jLongValue = ((Long) entryCeilingEntry.getKey()).longValue();
                    DashMediaSource dashMediaSource = DashMediaSource.this;
                    long j8 = dashMediaSource.X;
                    if (j8 == -9223372036854775807L || j8 < jLongValue) {
                        dashMediaSource.X = jLongValue;
                    }
                    z = true;
                }
                if (z && playerEmsgHandler.f6767g) {
                    playerEmsgHandler.f6768h = true;
                    playerEmsgHandler.f6767g = false;
                    DashMediaSource dashMediaSource2 = DashMediaSource.this;
                    dashMediaSource2.E.removeCallbacks(dashMediaSource2.x);
                    dashMediaSource2.q0();
                }
            }
            if (z) {
                return;
            }
        } else {
            j3 = -9223372036854775807L;
        }
        long jT2 = Util.T(Util.A(this.f6735f));
        DashManifest dashManifest2 = this.f6741l;
        long j9 = dashManifest2.f6789a;
        long jT3 = j9 == j3 ? j3 : jT2 - Util.T(j9 + dashManifest2.b(this.f6742m).f6823b);
        if (list.isEmpty()) {
            list2 = list;
            mediaChunk = null;
        } else {
            list2 = list;
            mediaChunk = (MediaChunk) e.k(1, list2);
        }
        int length = this.f6740k.length();
        MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[length];
        int i2 = 0;
        while (true) {
            representationHolderArr = this.f6739j;
            if (i2 >= length) {
                break;
            }
            RepresentationHolder representationHolder2 = representationHolderArr[i2];
            long j10 = j7;
            DashSegmentIndex dashSegmentIndex = representationHolder2.f6749d;
            MediaChunkIterator mediaChunkIterator2 = MediaChunkIterator.f7891a;
            if (dashSegmentIndex == null) {
                mediaChunkIteratorArr[i2] = mediaChunkIterator2;
                j5 = jT3;
            } else {
                long jB = representationHolder2.b(jT2);
                long jC2 = representationHolder2.c(jT2);
                if (mediaChunk != null) {
                    jL = mediaChunk.c();
                    j5 = jT3;
                    mediaChunkIterator = mediaChunkIterator2;
                } else {
                    DashSegmentIndex dashSegmentIndex2 = representationHolder2.f6749d;
                    Assertions.h(dashSegmentIndex2);
                    j5 = jT3;
                    mediaChunkIterator = mediaChunkIterator2;
                    jL = Util.l(dashSegmentIndex2.g(j2, representationHolder2.f6750e) + representationHolder2.f6751f, jB, jC2);
                }
                long j11 = jL;
                if (j11 < jB) {
                    mediaChunkIteratorArr[i2] = mediaChunkIterator;
                } else {
                    mediaChunkIteratorArr[i2] = new RepresentationSegmentIterator(m(i2), j11, jC2);
                }
            }
            i2++;
            j7 = j10;
            jT3 = j5;
        }
        long j12 = j7;
        long j13 = jT3;
        long j14 = 0;
        if (!this.f6741l.f6792d || representationHolderArr[0].d() == 0) {
            jMax = j3;
        } else {
            long jE = representationHolderArr[0].e(representationHolderArr[0].c(jT2));
            DashManifest dashManifest3 = this.f6741l;
            long j15 = dashManifest3.f6789a;
            long jMin = Math.min(j15 == j3 ? j3 : jT2 - Util.T(j15 + dashManifest3.b(this.f6742m).f6823b), jE) - j6;
            j14 = 0;
            jMax = Math.max(0L, jMin);
        }
        long j16 = j14;
        this.f6740k.g(j6, j12, jMax, list2, mediaChunkIteratorArr);
        int iD = this.f6740k.d();
        if (this.f6738i == null) {
            factory = null;
        } else {
            factory = new CmcdData.Factory(this.f6738i, this.f6740k, Math.max(j16, j12), loadingInfo.f6262b, "d", this.f6741l.f6792d, loadingInfo.a(this.p), list.isEmpty());
        }
        this.p = SystemClock.elapsedRealtime();
        RepresentationHolder representationHolderM = m(iD);
        DashSegmentIndex dashSegmentIndex3 = representationHolderM.f6749d;
        BaseUrl baseUrl = representationHolderM.f6748c;
        ChunkExtractor chunkExtractor = representationHolderM.f6746a;
        Representation representation = representationHolderM.f6747b;
        if (chunkExtractor != null) {
            RangedUri rangedUri = chunkExtractor.d() == null ? representation.f6839e : null;
            RangedUri rangedUriM = dashSegmentIndex3 == null ? representation.m() : null;
            if (rangedUri != null || rangedUriM != null) {
                Format formatR = this.f6740k.r();
                int iS = this.f6740k.s();
                Object objJ = this.f6740k.j();
                if (rangedUri != null) {
                    RangedUri rangedUriA = rangedUri.a(rangedUriM, baseUrl.f6785a);
                    if (rangedUriA != null) {
                        rangedUri = rangedUriA;
                    }
                } else {
                    rangedUriM.getClass();
                    rangedUri = rangedUriM;
                }
                DataSpec dataSpecA = DashUtil.a(representation, baseUrl.f6785a, rangedUri, 0, ImmutableMap.j());
                if (factory != null) {
                    factory.f8127j = "i";
                    dataSpecA = factory.a().a(dataSpecA);
                }
                chunkHolder2.f7864a = new InitializationChunk(this.f6734e, dataSpecA, formatR, iS, objJ, representationHolderM.f6746a);
                return;
            }
        }
        DashManifest dashManifest4 = this.f6741l;
        boolean z2 = dashManifest4.f6792d && this.f6742m == dashManifest4.f6801m.size() - 1;
        long j17 = representationHolderM.f6750e;
        boolean z3 = (z2 && j17 == j3) ? false : true;
        if (representationHolderM.d() == j16) {
            chunkHolder2.f7865b = z3;
            return;
        }
        long jB2 = representationHolderM.b(jT2);
        long jC3 = representationHolderM.c(jT2);
        if (z2) {
            long jE2 = representationHolderM.e(jC3);
            z3 &= (jE2 - representationHolderM.f(jC3)) + jE2 >= j17;
        }
        long j18 = j17;
        long j19 = representationHolderM.f6751f;
        if (mediaChunk != null) {
            j4 = jC3;
            representationHolder = representationHolderM;
            jC = mediaChunk.c();
        } else {
            Assertions.h(dashSegmentIndex3);
            j4 = jC3;
            representationHolder = representationHolderM;
            long jL2 = Util.l(dashSegmentIndex3.g(j2, j18) + j19, jB2, j4);
            j18 = j18;
            jC = jL2;
        }
        if (jC < jB2) {
            this.n = new BehindLiveWindowException();
            return;
        }
        if (jC > j4 || (this.o && jC >= j4)) {
            chunkHolder2.f7865b = z3;
            return;
        }
        RepresentationHolder representationHolder3 = representationHolder;
        if (z3 && representationHolder3.f(jC) >= j18) {
            chunkHolder2.f7865b = true;
            return;
        }
        int iMin = (int) Math.min(this.f6736g, (j4 - jC) + 1);
        if (j18 != j3) {
            while (iMin > 1 && representationHolder3.f((iMin + jC) - 1) >= j18) {
                iMin--;
            }
        }
        long j20 = list.isEmpty() ? j2 : j3;
        Format formatR2 = this.f6740k.r();
        int iS2 = this.f6740k.s();
        Object objJ2 = this.f6740k.j();
        long jF = representationHolder3.f(jC);
        Assertions.h(dashSegmentIndex3);
        RangedUri rangedUriF = dashSegmentIndex3.f(jC - j19);
        DataSource dataSource = this.f6734e;
        if (chunkExtractor == null) {
            long jE3 = representationHolder3.e(jC);
            DataSpec dataSpecA2 = DashUtil.a(representation, baseUrl.f6785a, rangedUriF, representationHolder3.g(jC, j13) ? 0 : 8, ImmutableMap.j());
            if (factory != null) {
                factory.c(jE3 - jF);
                factory.f8127j = CmcdData.Factory.b(this.f6740k);
                Pair pairK = k(jC, rangedUriF, representationHolder3);
                if (pairK != null) {
                    factory.f8128k = (String) pairK.first;
                    factory.f8129l = (String) pairK.second;
                }
                dataSpecA2 = factory.a().a(dataSpecA2);
            }
            containerMediaChunk = new SingleSampleMediaChunk(dataSource, dataSpecA2, formatR2, iS2, objJ2, jF, jE3, jC, this.f6733d, formatR2);
        } else {
            long j21 = jC;
            RangedUri rangedUri2 = rangedUriF;
            int i3 = 1;
            int i4 = 1;
            while (i3 < iMin) {
                int i5 = iMin;
                Assertions.h(dashSegmentIndex3);
                RangedUri rangedUriA2 = rangedUri2.a(dashSegmentIndex3.f((i3 + j21) - j19), baseUrl.f6785a);
                if (rangedUriA2 == null) {
                    break;
                }
                i4++;
                i3++;
                rangedUri2 = rangedUriA2;
                iMin = i5;
            }
            long j22 = (i4 + j21) - 1;
            long jE4 = representationHolder3.e(j22);
            long j23 = (j18 == j3 || j18 > jE4) ? j3 : j18;
            DataSpec dataSpecA3 = DashUtil.a(representation, baseUrl.f6785a, rangedUri2, representationHolder3.g(j22, j13) ? 0 : 8, ImmutableMap.j());
            if (factory != null) {
                factory.c(jE4 - jF);
                factory.f8127j = CmcdData.Factory.b(this.f6740k);
                Pair pairK2 = k(j21, rangedUri2, representationHolder3);
                if (pairK2 != null) {
                    factory.f8128k = (String) pairK2.first;
                    factory.f8129l = (String) pairK2.second;
                }
                dataSpecA3 = factory.a().a(dataSpecA3);
            }
            DataSpec dataSpec = dataSpecA3;
            long j24 = -representation.f6837c;
            if (MimeTypes.m(formatR2.f5225m)) {
                j24 += jF;
            }
            containerMediaChunk = new ContainerMediaChunk(dataSource, dataSpec, formatR2, iS2, objJ2, jF, jE4, j20, j23, j21, i4, j24, representationHolder3.f6746a);
            chunkHolder2 = chunkHolder;
        }
        chunkHolder2.f7864a = containerMediaChunk;
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkSource
    public final int j(long j2, List list) {
        return (this.n != null || this.f6740k.length() < 2) ? list.size() : this.f6740k.p(j2, list);
    }

    public final ArrayList l() {
        List list = this.f6741l.b(this.f6742m).f6824c;
        ArrayList arrayList = new ArrayList();
        for (int i2 : this.f6732c) {
            arrayList.addAll(((AdaptationSet) list.get(i2)).f6781c);
        }
        return arrayList;
    }

    public final RepresentationHolder m(int i2) {
        RepresentationHolder[] representationHolderArr = this.f6739j;
        RepresentationHolder representationHolder = representationHolderArr[i2];
        BaseUrl baseUrlC = this.f6731b.c(representationHolder.f6747b.f6836b);
        if (baseUrlC == null || baseUrlC.equals(representationHolder.f6748c)) {
            return representationHolder;
        }
        RepresentationHolder representationHolder2 = new RepresentationHolder(representationHolder.f6750e, representationHolder.f6747b, baseUrlC, representationHolder.f6746a, representationHolder.f6751f, representationHolder.f6749d);
        representationHolderArr[i2] = representationHolder2;
        return representationHolder2;
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkSource
    public final void release() {
        for (RepresentationHolder representationHolder : this.f6739j) {
            ChunkExtractor chunkExtractor = representationHolder.f6746a;
            if (chunkExtractor != null) {
                chunkExtractor.release();
            }
        }
    }
}
