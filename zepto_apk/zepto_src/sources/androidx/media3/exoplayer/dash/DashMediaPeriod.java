package androidx.media3.exoplayer.dash;

import android.util.Pair;
import android.util.SparseArray;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.dash.DefaultDashChunkSource;
import androidx.media3.exoplayer.dash.PlayerEmsgHandler;
import androidx.media3.exoplayer.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler;
import androidx.media3.exoplayer.dash.manifest.AdaptationSet;
import androidx.media3.exoplayer.dash.manifest.DashManifest;
import androidx.media3.exoplayer.dash.manifest.Descriptor;
import androidx.media3.exoplayer.dash.manifest.EventStream;
import androidx.media3.exoplayer.dash.manifest.Period;
import androidx.media3.exoplayer.dash.manifest.Representation;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.source.CompositeSequenceableLoader;
import androidx.media3.exoplayer.source.DefaultCompositeSequenceableLoaderFactory;
import androidx.media3.exoplayer.source.EmptySampleStream;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.source.chunk.BundledChunkExtractor;
import androidx.media3.exoplayer.source.chunk.ChunkSampleStream;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoaderErrorThrower;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
final class DashMediaPeriod implements MediaPeriod, SequenceableLoader.Callback<ChunkSampleStream<DashChunkSource>>, ChunkSampleStream.ReleaseCallback<DashChunkSource> {

    /* renamed from: a, reason: collision with root package name */
    public final int f6677a;

    /* renamed from: b, reason: collision with root package name */
    public final DefaultDashChunkSource.Factory f6678b;

    /* renamed from: c, reason: collision with root package name */
    public final TransferListener f6679c;

    /* renamed from: d, reason: collision with root package name */
    public final CmcdConfiguration f6680d;

    /* renamed from: e, reason: collision with root package name */
    public final DrmSessionManager f6681e;

    /* renamed from: f, reason: collision with root package name */
    public final LoadErrorHandlingPolicy f6682f;

    /* renamed from: g, reason: collision with root package name */
    public final BaseUrlExclusionList f6683g;

    /* renamed from: h, reason: collision with root package name */
    public final long f6684h;

    /* renamed from: i, reason: collision with root package name */
    public final LoaderErrorThrower f6685i;

    /* renamed from: j, reason: collision with root package name */
    public final Allocator f6686j;

    /* renamed from: k, reason: collision with root package name */
    public final TrackGroupArray f6687k;

    /* renamed from: l, reason: collision with root package name */
    public final TrackGroupInfo[] f6688l;

    /* renamed from: m, reason: collision with root package name */
    public final DefaultCompositeSequenceableLoaderFactory f6689m;
    public final PlayerEmsgHandler n;
    public final MediaSourceEventListener.EventDispatcher p;
    public final DrmSessionEventListener.EventDispatcher q;
    public final PlayerId r;
    public MediaPeriod.Callback s;
    public SequenceableLoader v;
    public DashManifest w;
    public int x;
    public List y;
    public static final Pattern z = Pattern.compile("CC([1-4])=(.+)");
    public static final Pattern A = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");
    public ChunkSampleStream[] t = new ChunkSampleStream[0];
    public EventSampleStream[] u = new EventSampleStream[0];
    public final IdentityHashMap o = new IdentityHashMap();

    public static final class TrackGroupInfo {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f6690a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6691b;

        /* renamed from: c, reason: collision with root package name */
        public final int f6692c;

        /* renamed from: d, reason: collision with root package name */
        public final int f6693d;

        /* renamed from: e, reason: collision with root package name */
        public final int f6694e;

        /* renamed from: f, reason: collision with root package name */
        public final int f6695f;

        /* renamed from: g, reason: collision with root package name */
        public final int f6696g;

        /* renamed from: h, reason: collision with root package name */
        public final ImmutableList f6697h;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface TrackGroupCategory {
        }

        public TrackGroupInfo(int i2, int i3, int[] iArr, int i4, int i5, int i6, int i7, ImmutableList immutableList) {
            this.f6691b = i2;
            this.f6690a = iArr;
            this.f6692c = i3;
            this.f6694e = i4;
            this.f6695f = i5;
            this.f6696g = i6;
            this.f6693d = i7;
            this.f6697h = immutableList;
        }
    }

    public DashMediaPeriod(int i2, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList, int i3, DefaultDashChunkSource.Factory factory, TransferListener transferListener, CmcdConfiguration cmcdConfiguration, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, long j2, LoaderErrorThrower loaderErrorThrower, Allocator allocator, DefaultCompositeSequenceableLoaderFactory defaultCompositeSequenceableLoaderFactory, PlayerEmsgHandler.PlayerEmsgCallback playerEmsgCallback, PlayerId playerId) throws NumberFormatException {
        int i4;
        int i5;
        Format[] formatArr;
        int i6;
        int[][] iArr;
        boolean[] zArr;
        Format[] formatArrU;
        Descriptor descriptorN;
        Integer num;
        DefaultDashChunkSource.Factory factory2 = factory;
        DrmSessionManager drmSessionManager2 = drmSessionManager;
        boolean z2 = true;
        this.f6677a = i2;
        this.w = dashManifest;
        this.f6683g = baseUrlExclusionList;
        this.x = i3;
        this.f6678b = factory2;
        this.f6679c = transferListener;
        this.f6680d = cmcdConfiguration;
        this.f6681e = drmSessionManager2;
        this.q = eventDispatcher;
        this.f6682f = loadErrorHandlingPolicy;
        this.p = eventDispatcher2;
        this.f6684h = j2;
        this.f6685i = loaderErrorThrower;
        this.f6686j = allocator;
        this.f6689m = defaultCompositeSequenceableLoaderFactory;
        this.r = playerId;
        this.n = new PlayerEmsgHandler(dashManifest, playerEmsgCallback, allocator);
        int i7 = 0;
        this.v = defaultCompositeSequenceableLoaderFactory.a();
        Period periodB = dashManifest.b(i3);
        List list = periodB.f6825d;
        this.y = list;
        List list2 = periodB.f6824c;
        int size = list2.size();
        HashMap map = new HashMap(Maps.c(size));
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i8 = 0; i8 < size; i8++) {
            map.put(Long.valueOf(((AdaptationSet) list2.get(i8)).f6779a), Integer.valueOf(i8));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i8));
            arrayList.add(arrayList2);
            sparseArray.put(i8, arrayList2);
        }
        int i9 = 0;
        while (i9 < size) {
            AdaptationSet adaptationSet = (AdaptationSet) list2.get(i9);
            Descriptor descriptorN2 = n("http://dashif.org/guidelines/trickmode", adaptationSet.f6783e);
            List list3 = adaptationSet.f6784f;
            descriptorN2 = descriptorN2 == null ? n("http://dashif.org/guidelines/trickmode", list3) : descriptorN2;
            int iIntValue = (descriptorN2 == null || (num = (Integer) map.get(Long.valueOf(Long.parseLong(descriptorN2.f6816b)))) == null) ? i9 : num.intValue();
            if (iIntValue == i9 && (descriptorN = n("urn:mpeg:dash:adaptation-set-switching:2016", list3)) != null) {
                int i10 = Util.f5744a;
                String[] strArrSplit = descriptorN.f6816b.split(",", -1);
                int length = strArrSplit.length;
                int i11 = 0;
                while (i11 < length) {
                    boolean z3 = z2;
                    Integer num2 = (Integer) map.get(Long.valueOf(Long.parseLong(strArrSplit[i11])));
                    if (num2 != null) {
                        iIntValue = Math.min(iIntValue, num2.intValue());
                    }
                    i11++;
                    z2 = z3;
                }
            }
            boolean z4 = z2;
            if (iIntValue != i9) {
                List list4 = (List) sparseArray.get(i9);
                List list5 = (List) sparseArray.get(iIntValue);
                list5.addAll(list4);
                sparseArray.put(i9, list5);
                arrayList.remove(list4);
            }
            i9++;
            z2 = z4;
        }
        boolean z5 = z2;
        int size2 = arrayList.size();
        int[][] iArr2 = new int[size2][];
        for (int i12 = 0; i12 < size2; i12++) {
            int[] iArrG = Ints.g((Collection) arrayList.get(i12));
            iArr2[i12] = iArrG;
            Arrays.sort(iArrG);
        }
        boolean[] zArr2 = new boolean[size2];
        Format[][] formatArr2 = new Format[size2][];
        int i13 = 0;
        int i14 = 0;
        while (i13 < size2) {
            int[] iArr3 = iArr2[i13];
            int length2 = iArr3.length;
            int i15 = i7;
            while (true) {
                if (i15 >= length2) {
                    iArr = iArr2;
                    break;
                }
                List list6 = ((AdaptationSet) list2.get(iArr3[i15])).f6781c;
                iArr = iArr2;
                while (i7 < list6.size()) {
                    if (!((Representation) list6.get(i7)).f6838d.isEmpty()) {
                        zArr2[i13] = z5;
                        i14++;
                        break;
                    }
                    i7++;
                }
                i15++;
                iArr2 = iArr;
                i7 = 0;
            }
            int[] iArr4 = iArr[i13];
            int length3 = iArr4.length;
            int i16 = 0;
            while (true) {
                if (i16 >= length3) {
                    zArr = zArr2;
                    formatArrU = new Format[0];
                    break;
                }
                int i17 = iArr4[i16];
                AdaptationSet adaptationSet2 = (AdaptationSet) list2.get(i17);
                List list7 = ((AdaptationSet) list2.get(i17)).f6782d;
                int[] iArr5 = iArr4;
                int i18 = 0;
                while (i18 < list7.size()) {
                    Descriptor descriptor = (Descriptor) list7.get(i18);
                    int i19 = length3;
                    zArr = zArr2;
                    if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.f6815a)) {
                        Format.Builder builder = new Format.Builder();
                        builder.f5237l = MimeTypes.p("application/cea-608");
                        builder.f5226a = android.support.v4.media.b.p(new StringBuilder(), adaptationSet2.f6779a, ":cea608");
                        formatArrU = u(descriptor, z, new Format(builder));
                        break;
                    }
                    if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.f6815a)) {
                        Format.Builder builder2 = new Format.Builder();
                        builder2.f5237l = MimeTypes.p("application/cea-708");
                        builder2.f5226a = android.support.v4.media.b.p(new StringBuilder(), adaptationSet2.f6779a, ":cea708");
                        formatArrU = u(descriptor, A, new Format(builder2));
                        break;
                    }
                    i18++;
                    zArr2 = zArr;
                    length3 = i19;
                }
                i16++;
                iArr4 = iArr5;
            }
            formatArr2[i13] = formatArrU;
            if (formatArrU.length != 0) {
                i14++;
            }
            i13++;
            zArr2 = zArr;
            iArr2 = iArr;
            i7 = 0;
        }
        int[][] iArr6 = iArr2;
        boolean[] zArr3 = zArr2;
        int size3 = list.size() + i14 + size2;
        TrackGroup[] trackGroupArr = new TrackGroup[size3];
        TrackGroupInfo[] trackGroupInfoArr = new TrackGroupInfo[size3];
        int i20 = 0;
        int i21 = 0;
        while (i20 < size2) {
            int[] iArr7 = iArr6[i20];
            ArrayList arrayList3 = new ArrayList();
            int length4 = iArr7.length;
            int i22 = 0;
            while (i22 < length4) {
                arrayList3.addAll(((AdaptationSet) list2.get(iArr7[i22])).f6781c);
                i22++;
                size2 = size2;
            }
            int i23 = size2;
            int size4 = arrayList3.size();
            Format[] formatArr3 = new Format[size4];
            int i24 = 0;
            while (i24 < size4) {
                Format[][] formatArr4 = formatArr2;
                Format format = ((Representation) arrayList3.get(i24)).f6835a;
                int i25 = i21;
                Format.Builder builderA = format.a();
                builderA.I = drmSessionManager2.c(format);
                formatArr3[i24] = new Format(builderA);
                i24++;
                formatArr2 = formatArr4;
                i21 = i25;
            }
            Format[][] formatArr5 = formatArr2;
            int i26 = i21;
            AdaptationSet adaptationSet3 = (AdaptationSet) list2.get(iArr7[0]);
            long j3 = adaptationSet3.f6779a;
            String string = j3 != -1 ? Long.toString(j3) : android.support.v4.media.b.f(i20, "unset:");
            int i27 = i26 + 1;
            if (zArr3[i20]) {
                i4 = i26 + 2;
            } else {
                i4 = i27;
                i27 = -1;
            }
            if (formatArr5[i20].length != 0) {
                i5 = i4 + 1;
            } else {
                i5 = i4;
                i4 = -1;
            }
            List list8 = list2;
            int i28 = i27;
            int i29 = 0;
            while (true) {
                if (i29 >= size4) {
                    break;
                }
                int i30 = i29;
                Format format2 = formatArr3[i30];
                BundledChunkExtractor.Factory factory3 = factory2.f6745c;
                int i31 = size4;
                if (factory3.f7854b && factory3.f7853a.b(format2)) {
                    Format.Builder builderA2 = format2.a();
                    builderA2.f5237l = MimeTypes.p("application/x-media3-cues");
                    builderA2.F = factory3.f7853a.a(format2);
                    StringBuilder sb = new StringBuilder();
                    sb.append(format2.f5225m);
                    String str = format2.f5222j;
                    sb.append(str != null ? StringUtils.SPACE.concat(str) : "");
                    builderA2.f5234i = sb.toString();
                    builderA2.q = Long.MAX_VALUE;
                    format2 = new Format(builderA2);
                }
                formatArr3[i30] = format2;
                i29 = i30 + 1;
                size4 = i31;
            }
            trackGroupArr[i26] = new TrackGroup(string, formatArr3);
            int i32 = i26;
            trackGroupInfoArr[i32] = new TrackGroupInfo(adaptationSet3.f6780b, 0, iArr7, i26, i28, i4, -1, ImmutableList.r());
            int i33 = -1;
            if (i28 != -1) {
                String strK = android.support.v4.media.b.k(string, ":emsg");
                Format.Builder builder3 = new Format.Builder();
                builder3.f5226a = strK;
                builder3.f5237l = MimeTypes.p("application/x-emsg");
                trackGroupArr[i28] = new TrackGroup(strK, new Format(builder3));
                TrackGroupInfo trackGroupInfo = new TrackGroupInfo(5, 1, iArr7, i32, -1, -1, -1, ImmutableList.r());
                i32 = i32;
                trackGroupInfoArr[i28] = trackGroupInfo;
                i33 = -1;
            }
            if (i4 != i33) {
                String strK2 = android.support.v4.media.b.k(string, ":cc");
                trackGroupInfoArr[i4] = new TrackGroupInfo(3, 1, iArr7, i32, -1, -1, -1, ImmutableList.p(formatArr5[i20]));
                Format[] formatArr6 = formatArr5[i20];
                int i34 = 0;
                while (i34 < formatArr6.length) {
                    Format format3 = formatArr6[i34];
                    BundledChunkExtractor.Factory factory4 = factory2.f6745c;
                    if (factory4.f7854b && factory4.f7853a.b(format3)) {
                        Format.Builder builderA3 = format3.a();
                        formatArr = formatArr6;
                        builderA3.f5237l = MimeTypes.p("application/x-media3-cues");
                        builderA3.F = factory4.f7853a.a(format3);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(format3.f5225m);
                        String str2 = format3.f5222j;
                        sb2.append(str2 != null ? StringUtils.SPACE.concat(str2) : "");
                        builderA3.f5234i = sb2.toString();
                        i6 = i34;
                        builderA3.q = Long.MAX_VALUE;
                        format3 = new Format(builderA3);
                    } else {
                        formatArr = formatArr6;
                        i6 = i34;
                    }
                    formatArr[i6] = format3;
                    factory2 = factory;
                    i34 = i6 + 1;
                    formatArr6 = formatArr;
                }
                trackGroupArr[i4] = new TrackGroup(strK2, formatArr5[i20]);
            }
            i20++;
            size2 = i23;
            factory2 = factory;
            formatArr2 = formatArr5;
            drmSessionManager2 = drmSessionManager;
            i21 = i5;
            list2 = list8;
        }
        int i35 = 0;
        while (i35 < list.size()) {
            EventStream eventStream = (EventStream) list.get(i35);
            Format.Builder builder4 = new Format.Builder();
            builder4.f5226a = eventStream.a();
            builder4.f5237l = MimeTypes.p("application/x-emsg");
            trackGroupArr[i21] = new TrackGroup(eventStream.a() + ":" + i35, new Format(builder4));
            trackGroupInfoArr[i21] = new TrackGroupInfo(5, 2, new int[0], -1, -1, -1, i35, ImmutableList.r());
            i35++;
            i21++;
        }
        Pair pairCreate = Pair.create(new TrackGroupArray(trackGroupArr), trackGroupInfoArr);
        this.f6687k = (TrackGroupArray) pairCreate.first;
        this.f6688l = (TrackGroupInfo[]) pairCreate.second;
    }

    public static Descriptor n(String str, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Descriptor descriptor = (Descriptor) list.get(i2);
            if (str.equals(descriptor.f6815a)) {
                return descriptor;
            }
        }
        return null;
    }

    public static Format[] u(Descriptor descriptor, Pattern pattern, Format format) throws NumberFormatException {
        String str = descriptor.f6816b;
        if (str == null) {
            return new Format[]{format};
        }
        int i2 = Util.f5744a;
        String[] strArrSplit = str.split(";", -1);
        Format[] formatArr = new Format[strArrSplit.length];
        for (int i3 = 0; i3 < strArrSplit.length; i3++) {
            Matcher matcher = pattern.matcher(strArrSplit[i3]);
            if (!matcher.matches()) {
                return new Format[]{format};
            }
            int i4 = Integer.parseInt(matcher.group(1));
            Format.Builder builderA = format.a();
            builderA.f5226a = format.f5213a + ":" + i4;
            builderA.E = i4;
            builderA.f5229d = matcher.group(2);
            formatArr[i3] = new Format(builderA);
        }
        return formatArr;
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkSampleStream.ReleaseCallback
    public final synchronized void a(ChunkSampleStream chunkSampleStream) {
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = (PlayerEmsgHandler.PlayerTrackEmsgHandler) this.o.remove(chunkSampleStream);
        if (playerTrackEmsgHandler != null) {
            SampleQueue sampleQueue = playerTrackEmsgHandler.f6772a;
            sampleQueue.z(true);
            DrmSession drmSession = sampleQueue.f7699h;
            if (drmSession != null) {
                drmSession.f(sampleQueue.f7696e);
                sampleQueue.f7699h = null;
                sampleQueue.f7698g = null;
            }
        }
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean b() {
        return this.v.b();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long d(long j2, SeekParameters seekParameters) {
        for (ChunkSampleStream chunkSampleStream : this.t) {
            if (chunkSampleStream.f7866a == 2) {
                return chunkSampleStream.f7870e.d(j2, seekParameters);
            }
        }
        return j2;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean e(LoadingInfo loadingInfo) {
        return this.v.e(loadingInfo);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long f() {
        return this.v.f();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long g(long j2) throws Throwable {
        for (ChunkSampleStream chunkSampleStream : this.t) {
            chunkSampleStream.A(j2);
        }
        for (EventSampleStream eventSampleStream : this.u) {
            int iB = Util.b(eventSampleStream.f6755c, j2, true);
            eventSampleStream.f6759g = iB;
            eventSampleStream.f6760h = (eventSampleStream.f6756d && iB == eventSampleStream.f6755c.length) ? j2 : -9223372036854775807L;
        }
        return j2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [int] */
    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long h(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) throws Throwable {
        int i2;
        boolean z2;
        int i3;
        ?? r6;
        TrackGroup trackGroupA;
        int i4;
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler;
        boolean z3;
        int[] iArr = new int[exoTrackSelectionArr.length];
        int i5 = 0;
        while (true) {
            i2 = -1;
            if (i5 >= exoTrackSelectionArr.length) {
                break;
            }
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i5];
            if (exoTrackSelection != null) {
                iArr[i5] = this.f6687k.b(exoTrackSelection.m());
            } else {
                iArr[i5] = -1;
            }
            i5++;
        }
        for (int i6 = 0; i6 < exoTrackSelectionArr.length; i6++) {
            if (exoTrackSelectionArr[i6] == null || !zArr[i6]) {
                SampleStream sampleStream = sampleStreamArr[i6];
                if (sampleStream instanceof ChunkSampleStream) {
                    ((ChunkSampleStream) sampleStream).z(this);
                } else if (sampleStream instanceof ChunkSampleStream.EmbeddedSampleStream) {
                    ChunkSampleStream.EmbeddedSampleStream embeddedSampleStream = (ChunkSampleStream.EmbeddedSampleStream) sampleStream;
                    ChunkSampleStream chunkSampleStream = ChunkSampleStream.this;
                    boolean[] zArr3 = chunkSampleStream.f7869d;
                    int i7 = embeddedSampleStream.f7881c;
                    Assertions.g(zArr3[i7]);
                    chunkSampleStream.f7869d[i7] = false;
                }
                sampleStreamArr[i6] = null;
            }
        }
        int i8 = 0;
        while (true) {
            if (i8 >= exoTrackSelectionArr.length) {
                break;
            }
            SampleStream sampleStream2 = sampleStreamArr[i8];
            if ((sampleStream2 instanceof EmptySampleStream) || (sampleStream2 instanceof ChunkSampleStream.EmbeddedSampleStream)) {
                int iT = t(i8, iArr);
                if (iT == -1) {
                    z3 = sampleStreamArr[i8] instanceof EmptySampleStream;
                } else {
                    SampleStream sampleStream3 = sampleStreamArr[i8];
                    z3 = (sampleStream3 instanceof ChunkSampleStream.EmbeddedSampleStream) && ((ChunkSampleStream.EmbeddedSampleStream) sampleStream3).f7879a == sampleStreamArr[iT];
                }
                if (!z3) {
                    SampleStream sampleStream4 = sampleStreamArr[i8];
                    if (sampleStream4 instanceof ChunkSampleStream.EmbeddedSampleStream) {
                        ChunkSampleStream.EmbeddedSampleStream embeddedSampleStream2 = (ChunkSampleStream.EmbeddedSampleStream) sampleStream4;
                        ChunkSampleStream chunkSampleStream2 = ChunkSampleStream.this;
                        boolean[] zArr4 = chunkSampleStream2.f7869d;
                        int i9 = embeddedSampleStream2.f7881c;
                        Assertions.g(zArr4[i9]);
                        chunkSampleStream2.f7869d[i9] = false;
                    }
                    sampleStreamArr[i8] = null;
                }
            }
            i8++;
        }
        int i10 = 0;
        while (i10 < exoTrackSelectionArr.length) {
            ExoTrackSelection exoTrackSelection2 = exoTrackSelectionArr[i10];
            if (exoTrackSelection2 == null) {
                i3 = i10;
            } else {
                SampleStream sampleStream5 = sampleStreamArr[i10];
                if (sampleStream5 == null) {
                    zArr2[i10] = z2;
                    TrackGroupInfo trackGroupInfo = this.f6688l[iArr[i10]];
                    int i11 = trackGroupInfo.f6692c;
                    if (i11 == 0) {
                        int i12 = trackGroupInfo.f6695f;
                        boolean z4 = i12 != i2 ? z2 : false;
                        if (z4) {
                            trackGroupA = this.f6687k.a(i12);
                            r6 = z2;
                        } else {
                            r6 = 0;
                            trackGroupA = null;
                        }
                        int i13 = trackGroupInfo.f6696g;
                        ImmutableList immutableListR = i13 != i2 ? this.f6688l[i13].f6697h : ImmutableList.r();
                        int size = immutableListR.size() + r6;
                        boolean z5 = z2;
                        Format[] formatArr = new Format[size];
                        int[] iArr2 = new int[size];
                        if (z4) {
                            formatArr[0] = trackGroupA.f5504d[0];
                            iArr2[0] = 5;
                            i4 = z5 ? 1 : 0;
                        } else {
                            i4 = 0;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (int i14 = 0; i14 < immutableListR.size(); i14++) {
                            Format format = (Format) immutableListR.get(i14);
                            formatArr[i4] = format;
                            iArr2[i4] = 3;
                            arrayList.add(format);
                            i4 += z5 ? 1 : 0;
                        }
                        if (this.w.f6792d && z4) {
                            PlayerEmsgHandler playerEmsgHandler = this.n;
                            playerTrackEmsgHandler = playerEmsgHandler.new PlayerTrackEmsgHandler(playerEmsgHandler.f6761a);
                        } else {
                            playerTrackEmsgHandler = null;
                        }
                        DefaultDashChunkSource.Factory factory = this.f6678b;
                        LoaderErrorThrower loaderErrorThrower = this.f6685i;
                        DashManifest dashManifest = this.w;
                        BaseUrlExclusionList baseUrlExclusionList = this.f6683g;
                        int i15 = this.x;
                        int[] iArr3 = trackGroupInfo.f6690a;
                        int i16 = trackGroupInfo.f6691b;
                        long j3 = this.f6684h;
                        i3 = i10;
                        TransferListener transferListener = this.f6679c;
                        PlayerId playerId = this.r;
                        CmcdConfiguration cmcdConfiguration = this.f6680d;
                        DataSource dataSourceA = factory.f6743a.a();
                        if (transferListener != null) {
                            dataSourceA.a(transferListener);
                        }
                        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2 = playerTrackEmsgHandler;
                        ChunkSampleStream chunkSampleStream3 = new ChunkSampleStream(trackGroupInfo.f6691b, iArr2, formatArr, new DefaultDashChunkSource(factory.f6745c, loaderErrorThrower, dashManifest, baseUrlExclusionList, i15, iArr3, exoTrackSelection2, i16, dataSourceA, j3, factory.f6744b, z4, arrayList, playerTrackEmsgHandler, playerId, cmcdConfiguration), this, this.f6686j, j2, this.f6681e, this.q, this.f6682f, this.p);
                        synchronized (this) {
                            this.o.put(chunkSampleStream3, playerTrackEmsgHandler2);
                        }
                        sampleStreamArr[i3] = chunkSampleStream3;
                    } else {
                        i3 = i10;
                        if (i11 == 2) {
                            sampleStreamArr[i3] = new EventSampleStream((EventStream) this.y.get(trackGroupInfo.f6693d), exoTrackSelection2.m().f5504d[0], this.w.f6792d);
                        }
                    }
                } else {
                    i3 = i10;
                    if (sampleStream5 instanceof ChunkSampleStream) {
                        ((DashChunkSource) ((ChunkSampleStream) sampleStream5).f7870e).a(exoTrackSelection2);
                    }
                }
            }
            i10 = i3 + 1;
            i2 = -1;
            z2 = true;
        }
        for (int i17 = 0; i17 < exoTrackSelectionArr.length; i17++) {
            if (sampleStreamArr[i17] == null && exoTrackSelectionArr[i17] != null) {
                TrackGroupInfo trackGroupInfo2 = this.f6688l[iArr[i17]];
                if (trackGroupInfo2.f6692c == 1) {
                    int iT2 = t(i17, iArr);
                    if (iT2 == -1) {
                        sampleStreamArr[i17] = new EmptySampleStream();
                    } else {
                        ChunkSampleStream chunkSampleStream4 = (ChunkSampleStream) sampleStreamArr[iT2];
                        int i18 = trackGroupInfo2.f6691b;
                        int i19 = 0;
                        while (true) {
                            SampleQueue[] sampleQueueArr = chunkSampleStream4.n;
                            if (i19 >= sampleQueueArr.length) {
                                throw new IllegalStateException();
                            }
                            if (chunkSampleStream4.f7867b[i19] == i18) {
                                boolean[] zArr5 = chunkSampleStream4.f7869d;
                                Assertions.g(!zArr5[i19]);
                                zArr5[i19] = true;
                                sampleQueueArr[i19].B(j2, true);
                                sampleStreamArr[i17] = new ChunkSampleStream.EmbeddedSampleStream(chunkSampleStream4, sampleQueueArr[i19], i19);
                                break;
                            }
                            i19++;
                        }
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (SampleStream sampleStream6 : sampleStreamArr) {
            if (sampleStream6 instanceof ChunkSampleStream) {
                arrayList2.add((ChunkSampleStream) sampleStream6);
            } else if (sampleStream6 instanceof EventSampleStream) {
                arrayList3.add((EventSampleStream) sampleStream6);
            }
        }
        ChunkSampleStream[] chunkSampleStreamArr = new ChunkSampleStream[arrayList2.size()];
        this.t = chunkSampleStreamArr;
        arrayList2.toArray(chunkSampleStreamArr);
        EventSampleStream[] eventSampleStreamArr = new EventSampleStream[arrayList3.size()];
        this.u = eventSampleStreamArr;
        arrayList3.toArray(eventSampleStreamArr);
        DefaultCompositeSequenceableLoaderFactory defaultCompositeSequenceableLoaderFactory = this.f6689m;
        AbstractList abstractListD = Lists.d(new b(), arrayList2);
        defaultCompositeSequenceableLoaderFactory.getClass();
        this.v = new CompositeSequenceableLoader(arrayList2, abstractListD);
        return j2;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long i() {
        return -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
    public final void k(SequenceableLoader sequenceableLoader) {
        this.s.k(this);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void l() {
        this.f6685i.c();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void o(MediaPeriod.Callback callback, long j2) {
        this.s = callback;
        callback.j(this);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final TrackGroupArray p() {
        return this.f6687k;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long q() {
        return this.v.q();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void r(long j2, boolean z2) throws Throwable {
        for (ChunkSampleStream chunkSampleStream : this.t) {
            chunkSampleStream.r(j2, z2);
        }
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final void s(long j2) {
        this.v.s(j2);
    }

    public final int t(int i2, int[] iArr) {
        int i3 = iArr[i2];
        if (i3 != -1) {
            TrackGroupInfo[] trackGroupInfoArr = this.f6688l;
            int i4 = trackGroupInfoArr[i3].f6694e;
            for (int i5 = 0; i5 < iArr.length; i5++) {
                int i6 = iArr[i5];
                if (i6 == i4 && trackGroupInfoArr[i6].f6692c == 0) {
                    return i5;
                }
            }
        }
        return -1;
    }
}
