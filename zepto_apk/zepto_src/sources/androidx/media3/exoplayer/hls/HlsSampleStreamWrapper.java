package androidx.media3.exoplayer.hls;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import androidx.media3.common.DataReader;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.hls.HlsChunkSource;
import androidx.media3.exoplayer.hls.HlsMediaPeriod;
import androidx.media3.exoplayer.source.BehindLiveWindowException;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelectionUtil;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.metadata.emsg.EventMessage;
import androidx.media3.extractor.metadata.emsg.EventMessageDecoder;
import androidx.media3.extractor.metadata.id3.PrivFrame;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
final class HlsSampleStreamWrapper implements Loader.Callback<Chunk>, Loader.ReleaseCallback, SequenceableLoader, ExtractorOutput, SampleQueue.UpstreamFormatChangedListener {
    public static final Set H0 = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 5)));
    public int A;
    public boolean A0;
    public int B;
    public boolean B0;
    public boolean C;
    public boolean C0;
    public boolean D;
    public boolean D0;
    public int E;
    public long E0;
    public Format F;
    public DrmInitData F0;
    public Format G;
    public HlsMediaChunk G0;
    public boolean H;
    public TrackGroupArray I;
    public Set J;
    public int[] K;
    public int L;
    public boolean M;
    public boolean[] Q;
    public boolean[] X;
    public long Y;
    public long Z;

    /* renamed from: a, reason: collision with root package name */
    public final String f7039a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7040b;

    /* renamed from: c, reason: collision with root package name */
    public final Callback f7041c;

    /* renamed from: d, reason: collision with root package name */
    public final HlsChunkSource f7042d;

    /* renamed from: e, reason: collision with root package name */
    public final Allocator f7043e;

    /* renamed from: f, reason: collision with root package name */
    public final Format f7044f;

    /* renamed from: g, reason: collision with root package name */
    public final DrmSessionManager f7045g;

    /* renamed from: h, reason: collision with root package name */
    public final DrmSessionEventListener.EventDispatcher f7046h;

    /* renamed from: i, reason: collision with root package name */
    public final LoadErrorHandlingPolicy f7047i;

    /* renamed from: k, reason: collision with root package name */
    public final MediaSourceEventListener.EventDispatcher f7049k;

    /* renamed from: l, reason: collision with root package name */
    public final int f7050l;
    public final ArrayList n;
    public final List o;
    public final c p;
    public final c q;
    public final Handler r;
    public final ArrayList s;
    public final Map t;
    public Chunk u;
    public HlsSampleQueue[] v;
    public final HashSet x;
    public final SparseIntArray y;
    public TrackOutput z;

    /* renamed from: j, reason: collision with root package name */
    public final Loader f7048j = new Loader("Loader:HlsSampleStreamWrapper");

    /* renamed from: m, reason: collision with root package name */
    public final HlsChunkSource.HlsChunkHolder f7051m = new HlsChunkSource.HlsChunkHolder();
    public int[] w = new int[0];

    public interface Callback extends SequenceableLoader.Callback<HlsSampleStreamWrapper> {
        void c();

        void m(Uri uri);
    }

    public static class EmsgUnwrappingTrackOutput implements TrackOutput {

        /* renamed from: g, reason: collision with root package name */
        public static final Format f7052g;

        /* renamed from: h, reason: collision with root package name */
        public static final Format f7053h;

        /* renamed from: a, reason: collision with root package name */
        public final EventMessageDecoder f7054a = new EventMessageDecoder();

        /* renamed from: b, reason: collision with root package name */
        public final TrackOutput f7055b;

        /* renamed from: c, reason: collision with root package name */
        public final Format f7056c;

        /* renamed from: d, reason: collision with root package name */
        public Format f7057d;

        /* renamed from: e, reason: collision with root package name */
        public byte[] f7058e;

        /* renamed from: f, reason: collision with root package name */
        public int f7059f;

        static {
            Format.Builder builder = new Format.Builder();
            builder.f5237l = MimeTypes.p("application/id3");
            f7052g = new Format(builder);
            Format.Builder builder2 = new Format.Builder();
            builder2.f5237l = MimeTypes.p("application/x-emsg");
            f7053h = new Format(builder2);
        }

        public EmsgUnwrappingTrackOutput(TrackOutput trackOutput, int i2) {
            this.f7055b = trackOutput;
            if (i2 == 1) {
                this.f7056c = f7052g;
            } else {
                if (i2 != 3) {
                    throw new IllegalArgumentException(android.support.v4.media.b.f(i2, "Unknown metadataType: "));
                }
                this.f7056c = f7053h;
            }
            this.f7058e = new byte[0];
            this.f7059f = 0;
        }

        @Override // androidx.media3.extractor.TrackOutput
        public final void a(ParsableByteArray parsableByteArray, int i2, int i3) {
            int i4 = this.f7059f + i2;
            byte[] bArr = this.f7058e;
            if (bArr.length < i4) {
                this.f7058e = Arrays.copyOf(bArr, (i4 / 2) + i4);
            }
            parsableByteArray.h(this.f7059f, this.f7058e, i2);
            this.f7059f += i2;
        }

        @Override // androidx.media3.extractor.TrackOutput
        public final void b(Format format) {
            this.f7057d = format;
            this.f7055b.b(this.f7056c);
        }

        @Override // androidx.media3.extractor.TrackOutput
        public final int d(DataReader dataReader, int i2, boolean z) throws EOFException {
            int i3 = this.f7059f + i2;
            byte[] bArr = this.f7058e;
            if (bArr.length < i3) {
                this.f7058e = Arrays.copyOf(bArr, (i3 / 2) + i3);
            }
            int i4 = dataReader.read(this.f7058e, this.f7059f, i2);
            if (i4 != -1) {
                this.f7059f += i4;
                return i4;
            }
            if (z) {
                return -1;
            }
            throw new EOFException();
        }

        @Override // androidx.media3.extractor.TrackOutput
        public final void f(long j2, int i2, int i3, int i4, TrackOutput.CryptoData cryptoData) {
            this.f7057d.getClass();
            int i5 = this.f7059f - i4;
            ParsableByteArray parsableByteArray = new ParsableByteArray(Arrays.copyOfRange(this.f7058e, i5 - i3, i5));
            byte[] bArr = this.f7058e;
            System.arraycopy(bArr, i5, bArr, 0, i4);
            this.f7059f = i4;
            String str = this.f7057d.f5225m;
            Format format = this.f7056c;
            if (!Util.a(str, format.f5225m)) {
                if (!"application/x-emsg".equals(this.f7057d.f5225m)) {
                    Log.h("HlsSampleStreamWrapper", "Ignoring sample for unsupported format: " + this.f7057d.f5225m);
                    return;
                }
                this.f7054a.getClass();
                EventMessage eventMessageC = EventMessageDecoder.c(parsableByteArray);
                Format formatZ0 = eventMessageC.z0();
                String str2 = format.f5225m;
                if (formatZ0 == null || !Util.a(str2, formatZ0.f5225m)) {
                    Log.h("HlsSampleStreamWrapper", "Ignoring EMSG. Expected it to contain wrapped " + str2 + " but actual wrapped format: " + eventMessageC.z0());
                    return;
                }
                byte[] bArrT7 = eventMessageC.T7();
                bArrT7.getClass();
                parsableByteArray = new ParsableByteArray(bArrT7);
            }
            int iA = parsableByteArray.a();
            this.f7055b.e(iA, parsableByteArray);
            this.f7055b.f(j2, i2, iA, 0, cryptoData);
        }
    }

    public static final class HlsSampleQueue extends SampleQueue {
        public final Map H;
        public DrmInitData I;

        public HlsSampleQueue(Allocator allocator, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, Map map) {
            super(allocator, drmSessionManager, eventDispatcher);
            this.H = map;
        }

        @Override // androidx.media3.exoplayer.source.SampleQueue
        public final Format n(Format format) {
            DrmInitData drmInitData;
            DrmInitData drmInitData2 = this.I;
            if (drmInitData2 == null) {
                drmInitData2 = format.q;
            }
            if (drmInitData2 != null && (drmInitData = (DrmInitData) this.H.get(drmInitData2.f5203c)) != null) {
                drmInitData2 = drmInitData;
            }
            Metadata metadata = format.f5223k;
            Metadata metadata2 = null;
            if (metadata == null) {
                metadata = metadata2;
            } else {
                Metadata.Entry[] entryArr = metadata.f5405a;
                int length = entryArr.length;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        i3 = -1;
                        break;
                    }
                    Metadata.Entry entry = entryArr[i3];
                    if ((entry instanceof PrivFrame) && "com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame) entry).f8838b)) {
                        break;
                    }
                    i3++;
                }
                if (i3 != -1) {
                    if (length != 1) {
                        Metadata.Entry[] entryArr2 = new Metadata.Entry[length - 1];
                        while (i2 < length) {
                            if (i2 != i3) {
                                entryArr2[i2 < i3 ? i2 : i2 - 1] = entryArr[i2];
                            }
                            i2++;
                        }
                        metadata2 = new Metadata(entryArr2);
                    }
                    metadata = metadata2;
                }
            }
            if (drmInitData2 != format.q || metadata != format.f5223k) {
                Format.Builder builderA = format.a();
                builderA.p = drmInitData2;
                builderA.f5235j = metadata;
                format = new Format(builderA);
            }
            return super.n(format);
        }
    }

    public HlsSampleStreamWrapper(String str, int i2, Callback callback, HlsChunkSource hlsChunkSource, Map map, Allocator allocator, long j2, Format format, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, int i3) {
        this.f7039a = str;
        this.f7040b = i2;
        this.f7041c = callback;
        this.f7042d = hlsChunkSource;
        this.t = map;
        this.f7043e = allocator;
        this.f7044f = format;
        this.f7045g = drmSessionManager;
        this.f7046h = eventDispatcher;
        this.f7047i = loadErrorHandlingPolicy;
        this.f7049k = eventDispatcher2;
        this.f7050l = i3;
        Set set = H0;
        this.x = new HashSet(set.size());
        this.y = new SparseIntArray(set.size());
        this.v = new HlsSampleQueue[0];
        this.X = new boolean[0];
        this.Q = new boolean[0];
        ArrayList arrayList = new ArrayList();
        this.n = arrayList;
        this.o = Collections.unmodifiableList(arrayList);
        this.s = new ArrayList();
        this.p = new c(this, 0);
        this.q = new c(this, 1);
        this.r = Util.o(null);
        this.Y = j2;
        this.Z = j2;
    }

    public static DiscardingTrackOutput u(int i2, int i3) {
        Log.h("HlsSampleStreamWrapper", "Unmapped track with id " + i2 + " of type " + i3);
        return new DiscardingTrackOutput();
    }

    public static Format w(Format format, Format format2, boolean z) {
        String strE;
        String strU;
        if (format == null) {
            return format2;
        }
        String str = format2.f5225m;
        int i2 = MimeTypes.i(str);
        String str2 = format.f5222j;
        if (Util.t(i2, str2) == 1) {
            strU = Util.u(i2, str2);
            strE = MimeTypes.e(strU);
        } else {
            String strC = MimeTypes.c(str2, str);
            strE = str;
            strU = strC;
        }
        Format.Builder builderA = format2.a();
        builderA.f5226a = format.f5213a;
        builderA.f5227b = format.f5214b;
        builderA.f5228c = ImmutableList.o(format.f5215c);
        builderA.f5229d = format.f5216d;
        builderA.f5230e = format.f5217e;
        builderA.f5231f = format.f5218f;
        builderA.f5232g = z ? format.f5219g : -1;
        builderA.f5233h = z ? format.f5220h : -1;
        builderA.f5234i = strU;
        if (i2 == 2) {
            builderA.r = format.s;
            builderA.s = format.t;
            builderA.t = format.u;
        }
        if (strE != null) {
            builderA.d(strE);
        }
        int i3 = format.A;
        if (i3 != -1 && i2 == 1) {
            builderA.z = i3;
        }
        Metadata metadataB = format.f5223k;
        if (metadataB != null) {
            Metadata metadata = format2.f5223k;
            if (metadata != null) {
                metadataB = metadata.b(metadataB);
            }
            builderA.f5235j = metadataB;
        }
        return new Format(builderA);
    }

    public static int z(int i2) {
        if (i2 == 1) {
            return 2;
        }
        if (i2 != 2) {
            return i2 != 3 ? 0 : 1;
        }
        return 3;
    }

    public final boolean A() {
        return this.Z != -9223372036854775807L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B() {
        int i2;
        if (!this.H && this.K == null && this.C) {
            int i3 = 0;
            for (HlsSampleQueue hlsSampleQueue : this.v) {
                if (hlsSampleQueue.s() == null) {
                    return;
                }
            }
            TrackGroupArray trackGroupArray = this.I;
            if (trackGroupArray != null) {
                int i4 = trackGroupArray.f7771a;
                int[] iArr = new int[i4];
                this.K = iArr;
                Arrays.fill(iArr, -1);
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = 0;
                    while (true) {
                        HlsSampleQueue[] hlsSampleQueueArr = this.v;
                        if (i6 < hlsSampleQueueArr.length) {
                            Format formatS = hlsSampleQueueArr[i6].s();
                            Assertions.h(formatS);
                            Format format = this.I.a(i5).f5504d[0];
                            String str = format.f5225m;
                            String str2 = formatS.f5225m;
                            int i7 = MimeTypes.i(str2);
                            if (i7 != 3) {
                                if (i7 == MimeTypes.i(str)) {
                                    break;
                                } else {
                                    i6++;
                                }
                            } else if (Util.a(str2, str) && (!("application/cea-608".equals(str2) || "application/cea-708".equals(str2)) || formatS.F == format.F)) {
                                break;
                            } else {
                                i6++;
                            }
                        }
                    }
                    this.K[i5] = i6;
                }
                Iterator it = this.s.iterator();
                while (it.hasNext()) {
                    ((HlsSampleStream) it.next()).b();
                }
                return;
            }
            int length = this.v.length;
            int i8 = 0;
            int i9 = -1;
            int i10 = -2;
            while (true) {
                int i11 = 1;
                if (i8 >= length) {
                    break;
                }
                Format formatS2 = this.v[i8].s();
                Assertions.h(formatS2);
                String str3 = formatS2.f5225m;
                if (MimeTypes.o(str3)) {
                    i11 = 2;
                } else if (!MimeTypes.l(str3)) {
                    i11 = MimeTypes.n(str3) ? 3 : -2;
                }
                if (z(i11) > z(i10)) {
                    i9 = i8;
                    i10 = i11;
                } else if (i11 == i10 && i9 != -1) {
                    i9 = -1;
                }
                i8++;
            }
            TrackGroup trackGroup = this.f7042d.f6985h;
            int i12 = trackGroup.f5501a;
            this.L = -1;
            this.K = new int[length];
            for (int i13 = 0; i13 < length; i13++) {
                this.K[i13] = i13;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[length];
            int i14 = 0;
            while (i14 < length) {
                Format formatS3 = this.v[i14].s();
                Assertions.h(formatS3);
                String str4 = this.f7039a;
                Format format2 = this.f7044f;
                if (i14 == i9) {
                    Format[] formatArr = new Format[i12];
                    for (int i15 = i3; i15 < i12; i15++) {
                        Format formatE = trackGroup.f5504d[i15];
                        if (i10 == 1 && format2 != null) {
                            formatE = formatE.e(format2);
                        }
                        formatArr[i15] = i12 == 1 ? formatS3.e(formatE) : w(formatE, formatS3, true);
                    }
                    trackGroupArr[i14] = new TrackGroup(str4, formatArr);
                    this.L = i14;
                    i2 = 0;
                } else {
                    if (i10 != 2 || !MimeTypes.l(formatS3.f5225m)) {
                        format2 = null;
                    }
                    StringBuilder sbX = android.support.v4.media.b.x(str4, ":muxed:");
                    sbX.append(i14 < i9 ? i14 : i14 - 1);
                    i2 = 0;
                    trackGroupArr[i14] = new TrackGroup(sbX.toString(), w(format2, formatS3, false));
                }
                i14++;
                i3 = i2;
            }
            int i16 = i3;
            this.I = v(trackGroupArr);
            Assertions.g(this.J == null ? 1 : i16);
            this.J = Collections.EMPTY_SET;
            this.D = true;
            ((HlsMediaPeriod.SampleStreamWrapperCallback) this.f7041c).c();
        }
    }

    public final void C() {
        this.f7048j.c();
        HlsChunkSource hlsChunkSource = this.f7042d;
        BehindLiveWindowException behindLiveWindowException = hlsChunkSource.o;
        if (behindLiveWindowException != null) {
            throw behindLiveWindowException;
        }
        Uri uri = hlsChunkSource.p;
        if (uri == null || !hlsChunkSource.t) {
            return;
        }
        hlsChunkSource.f6984g.f(uri);
    }

    public final void D(TrackGroup[] trackGroupArr, int... iArr) {
        this.I = v(trackGroupArr);
        this.J = new HashSet();
        for (int i2 : iArr) {
            this.J.add(this.I.a(i2));
        }
        this.L = 0;
        this.r.post(new c(this.f7041c, 2));
        this.D = true;
    }

    public final void E() {
        for (HlsSampleQueue hlsSampleQueue : this.v) {
            hlsSampleQueue.z(this.A0);
        }
        this.A0 = false;
    }

    public final boolean F(long j2, boolean z) {
        HlsMediaChunk hlsMediaChunk;
        boolean z2;
        this.Y = j2;
        if (A()) {
            this.Z = j2;
            return true;
        }
        boolean z3 = this.f7042d.q;
        ArrayList arrayList = this.n;
        if (z3) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                hlsMediaChunk = (HlsMediaChunk) arrayList.get(i2);
                if (hlsMediaChunk.f7861g == j2) {
                    break;
                }
            }
            hlsMediaChunk = null;
        } else {
            hlsMediaChunk = null;
        }
        if (this.C && !z) {
            int length = this.v.length;
            for (int i3 = 0; i3 < length; i3++) {
                HlsSampleQueue hlsSampleQueue = this.v[i3];
                if (!(hlsMediaChunk != null ? hlsSampleQueue.A(hlsMediaChunk.g(i3)) : hlsSampleQueue.B(j2, false)) && (this.X[i3] || !this.M)) {
                    z2 = false;
                    break;
                }
            }
            z2 = true;
            if (z2) {
                return false;
            }
        }
        this.Z = j2;
        this.C0 = false;
        arrayList.clear();
        Loader loader = this.f7048j;
        if (!loader.d()) {
            loader.f8169c = null;
            E();
            return true;
        }
        if (this.C) {
            for (HlsSampleQueue hlsSampleQueue2 : this.v) {
                hlsSampleQueue2.i();
            }
        }
        loader.a();
        return true;
    }

    @Override // androidx.media3.exoplayer.source.SampleQueue.UpstreamFormatChangedListener
    public final void a() {
        this.r.post(this.p);
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final void a0(Loader.Loadable loadable, long j2, long j3) {
        Chunk chunk = (Chunk) loadable;
        this.u = null;
        HlsChunkSource hlsChunkSource = this.f7042d;
        if (chunk instanceof HlsChunkSource.EncryptionKeyChunk) {
            HlsChunkSource.EncryptionKeyChunk encryptionKeyChunk = (HlsChunkSource.EncryptionKeyChunk) chunk;
            hlsChunkSource.n = encryptionKeyChunk.f7884j;
            Uri uri = encryptionKeyChunk.f7856b.f5851a;
            byte[] bArr = encryptionKeyChunk.f6991l;
            bArr.getClass();
            LinkedHashMap linkedHashMap = hlsChunkSource.f6987j.f6977a;
            uri.getClass();
        }
        long j4 = chunk.f7855a;
        StatsDataSource statsDataSource = chunk.f7863i;
        Uri uri2 = statsDataSource.f5931c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(j4, statsDataSource.f5932d, j3);
        this.f7047i.getClass();
        this.f7049k.f(loadEventInfo, chunk.f7857c, this.f7040b, chunk.f7858d, chunk.f7859e, chunk.f7860f, chunk.f7861g, chunk.f7862h);
        if (this.D) {
            ((HlsMediaPeriod.SampleStreamWrapperCallback) this.f7041c).k(this);
            return;
        }
        LoadingInfo.Builder builder = new LoadingInfo.Builder();
        builder.f6264a = this.Y;
        e(new LoadingInfo(builder));
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean b() {
        return this.f7048j.d();
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public final void c(SeekMap seekMap) {
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final void d0(Loader.Loadable loadable, long j2, long j3, boolean z) {
        Chunk chunk = (Chunk) loadable;
        this.u = null;
        long j4 = chunk.f7855a;
        StatsDataSource statsDataSource = chunk.f7863i;
        Uri uri = statsDataSource.f5931c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(j4, statsDataSource.f5932d, j3);
        this.f7047i.getClass();
        this.f7049k.c(loadEventInfo, chunk.f7857c, this.f7040b, chunk.f7858d, chunk.f7859e, chunk.f7860f, chunk.f7861g, chunk.f7862h);
        if (z) {
            return;
        }
        if (A() || this.E == 0) {
            E();
        }
        if (this.E > 0) {
            ((HlsMediaPeriod.SampleStreamWrapperCallback) this.f7041c).k(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x04a8  */
    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(androidx.media3.exoplayer.LoadingInfo r63) {
        /*
            Method dump skipped, instructions count: 1427
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.HlsSampleStreamWrapper.e(androidx.media3.exoplayer.LoadingInfo):boolean");
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long f() {
        if (A()) {
            return this.Z;
        }
        if (this.C0) {
            return Long.MIN_VALUE;
        }
        return y().f7862h;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.ReleaseCallback
    public final void j() {
        for (HlsSampleQueue hlsSampleQueue : this.v) {
            hlsSampleQueue.z(true);
            DrmSession drmSession = hlsSampleQueue.f7699h;
            if (drmSession != null) {
                drmSession.f(hlsSampleQueue.f7696e);
                hlsSampleQueue.f7699h = null;
                hlsSampleQueue.f7698g = null;
            }
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final Loader.LoadErrorAction k(Loader.Loadable loadable, long j2, long j3, IOException iOException, int i2) {
        boolean zH;
        Loader.LoadErrorAction loadErrorAction;
        int i3;
        Chunk chunk = (Chunk) loadable;
        boolean z = chunk instanceof HlsMediaChunk;
        if (z && !((HlsMediaChunk) chunk).K && (iOException instanceof HttpDataSource.InvalidResponseCodeException) && ((i3 = ((HttpDataSource.InvalidResponseCodeException) iOException).f5900d) == 410 || i3 == 404)) {
            return Loader.f8164d;
        }
        long j4 = chunk.f7863i.f5930b;
        StatsDataSource statsDataSource = chunk.f7863i;
        Uri uri = statsDataSource.f5931c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.f7855a, statsDataSource.f5932d, j3);
        Util.j0(chunk.f7861g);
        Util.j0(chunk.f7862h);
        LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(iOException, i2);
        HlsChunkSource hlsChunkSource = this.f7042d;
        LoadErrorHandlingPolicy.FallbackOptions fallbackOptionsA = TrackSelectionUtil.a(hlsChunkSource.r);
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f7047i;
        LoadErrorHandlingPolicy.FallbackSelection fallbackSelectionC = loadErrorHandlingPolicy.c(fallbackOptionsA, loadErrorInfo);
        if (fallbackSelectionC == null || fallbackSelectionC.f8160a != 2) {
            zH = false;
        } else {
            ExoTrackSelection exoTrackSelection = hlsChunkSource.r;
            zH = exoTrackSelection.h(exoTrackSelection.l(hlsChunkSource.f6985h.c(chunk.f7858d)), fallbackSelectionC.f8161b);
        }
        if (zH) {
            if (z && j4 == 0) {
                ArrayList arrayList = this.n;
                Assertions.g(((HlsMediaChunk) arrayList.remove(arrayList.size() - 1)) == chunk);
                if (arrayList.isEmpty()) {
                    this.Z = this.Y;
                } else {
                    ((HlsMediaChunk) Iterables.c(arrayList)).J = true;
                }
            }
            loadErrorAction = Loader.f8165e;
        } else {
            long jA = loadErrorHandlingPolicy.a(loadErrorInfo);
            loadErrorAction = jA != -9223372036854775807L ? new Loader.LoadErrorAction(0, jA) : Loader.f8166f;
        }
        Loader.LoadErrorAction loadErrorAction2 = loadErrorAction;
        boolean zA = loadErrorAction2.a();
        this.f7049k.h(loadEventInfo, chunk.f7857c, this.f7040b, chunk.f7858d, chunk.f7859e, chunk.f7860f, chunk.f7861g, chunk.f7862h, iOException, !zA);
        if (!zA) {
            this.u = null;
        }
        if (zH) {
            if (!this.D) {
                LoadingInfo.Builder builder = new LoadingInfo.Builder();
                builder.f6264a = this.Y;
                e(new LoadingInfo(builder));
                return loadErrorAction2;
            }
            ((HlsMediaPeriod.SampleStreamWrapperCallback) this.f7041c).k(this);
        }
        return loadErrorAction2;
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public final void m() {
        this.D0 = true;
        this.r.post(this.q);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r1v15, types: [androidx.media3.exoplayer.hls.HlsSampleStreamWrapper$HlsSampleQueue[]] */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.media3.exoplayer.hls.HlsSampleStreamWrapper$HlsSampleQueue[]] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.media3.extractor.TrackOutput] */
    /* JADX WARN: Type inference failed for: r6v4, types: [androidx.media3.exoplayer.hls.HlsSampleStreamWrapper$HlsSampleQueue, androidx.media3.exoplayer.source.SampleQueue] */
    /* JADX WARN: Type inference failed for: r6v5, types: [androidx.media3.extractor.DiscardingTrackOutput] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    @Override // androidx.media3.extractor.ExtractorOutput
    public final TrackOutput n(int i2, int i3) {
        Integer numValueOf = Integer.valueOf(i3);
        Set set = H0;
        boolean zContains = set.contains(numValueOf);
        HashSet hashSet = this.x;
        SparseIntArray sparseIntArray = this.y;
        ?? hlsSampleQueue = 0;
        hlsSampleQueue = 0;
        if (zContains) {
            Assertions.a(set.contains(Integer.valueOf(i3)));
            int i4 = sparseIntArray.get(i3, -1);
            if (i4 != -1) {
                if (hashSet.add(Integer.valueOf(i3))) {
                    this.w[i4] = i2;
                }
                hlsSampleQueue = this.w[i4] == i2 ? this.v[i4] : u(i2, i3);
            }
        } else {
            int i5 = 0;
            while (true) {
                ?? r2 = this.v;
                if (i5 >= r2.length) {
                    break;
                }
                if (this.w[i5] == i2) {
                    hlsSampleQueue = r2[i5];
                    break;
                }
                i5++;
            }
        }
        if (hlsSampleQueue == 0) {
            if (this.D0) {
                return u(i2, i3);
            }
            int length = this.v.length;
            boolean z = i3 == 1 || i3 == 2;
            hlsSampleQueue = new HlsSampleQueue(this.f7043e, this.f7045g, this.f7046h, this.t);
            hlsSampleQueue.t = this.Y;
            if (z) {
                hlsSampleQueue.I = this.F0;
                hlsSampleQueue.z = true;
            }
            long j2 = this.E0;
            if (hlsSampleQueue.F != j2) {
                hlsSampleQueue.F = j2;
                hlsSampleQueue.z = true;
            }
            if (this.G0 != null) {
                hlsSampleQueue.C = r2.f7002k;
            }
            hlsSampleQueue.f7697f = this;
            int i6 = length + 1;
            int[] iArrCopyOf = Arrays.copyOf(this.w, i6);
            this.w = iArrCopyOf;
            iArrCopyOf[length] = i2;
            HlsSampleQueue[] hlsSampleQueueArr = this.v;
            int i7 = Util.f5744a;
            ?? CopyOf = Arrays.copyOf(hlsSampleQueueArr, hlsSampleQueueArr.length + 1);
            CopyOf[hlsSampleQueueArr.length] = hlsSampleQueue;
            this.v = (HlsSampleQueue[]) CopyOf;
            boolean[] zArrCopyOf = Arrays.copyOf(this.X, i6);
            this.X = zArrCopyOf;
            zArrCopyOf[length] = z;
            this.M |= z;
            hashSet.add(Integer.valueOf(i3));
            sparseIntArray.append(i3, length);
            if (z(i3) > z(this.A)) {
                this.B = length;
                this.A = i3;
            }
            this.Q = Arrays.copyOf(this.Q, i6);
        }
        if (i3 != 5) {
            return hlsSampleQueue;
        }
        if (this.z == null) {
            this.z = new EmsgUnwrappingTrackOutput(hlsSampleQueue, this.f7050l);
        }
        return this.z;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long q() {
        long j2;
        if (this.C0) {
            return Long.MIN_VALUE;
        }
        if (A()) {
            return this.Z;
        }
        long jMax = this.Y;
        HlsMediaChunk hlsMediaChunkY = y();
        if (!hlsMediaChunkY.H) {
            ArrayList arrayList = this.n;
            hlsMediaChunkY = arrayList.size() > 1 ? (HlsMediaChunk) android.support.v4.media.b.c(2, arrayList) : null;
        }
        if (hlsMediaChunkY != null) {
            jMax = Math.max(jMax, hlsMediaChunkY.f7862h);
        }
        if (this.C) {
            for (HlsSampleQueue hlsSampleQueue : this.v) {
                synchronized (hlsSampleQueue) {
                    j2 = hlsSampleQueue.v;
                }
                jMax = Math.max(jMax, j2);
            }
        }
        return jMax;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final void s(long j2) {
        Loader loader = this.f7048j;
        if (loader.b() || A()) {
            return;
        }
        boolean zD = loader.d();
        HlsChunkSource hlsChunkSource = this.f7042d;
        List list = this.o;
        if (zD) {
            this.u.getClass();
            if (hlsChunkSource.o != null ? false : hlsChunkSource.r.n(j2, this.u, list)) {
                loader.a();
                return;
            }
            return;
        }
        int size = list.size();
        while (size > 0 && hlsChunkSource.b((HlsMediaChunk) list.get(size - 1)) == 2) {
            size--;
        }
        if (size < list.size()) {
            x(size);
        }
        int size2 = (hlsChunkSource.o != null || hlsChunkSource.r.length() < 2) ? list.size() : hlsChunkSource.r.p(j2, list);
        if (size2 < this.n.size()) {
            x(size2);
        }
    }

    public final void t() {
        Assertions.g(this.D);
        this.I.getClass();
        this.J.getClass();
    }

    public final TrackGroupArray v(TrackGroup[] trackGroupArr) {
        for (int i2 = 0; i2 < trackGroupArr.length; i2++) {
            TrackGroup trackGroup = trackGroupArr[i2];
            Format[] formatArr = new Format[trackGroup.f5501a];
            for (int i3 = 0; i3 < trackGroup.f5501a; i3++) {
                Format format = trackGroup.f5504d[i3];
                int iC = this.f7045g.c(format);
                Format.Builder builderA = format.a();
                builderA.I = iC;
                formatArr[i3] = new Format(builderA);
            }
            trackGroupArr[i2] = new TrackGroup(trackGroup.f5502b, formatArr);
        }
        return new TrackGroupArray(trackGroupArr);
    }

    public final void x(int i2) {
        ArrayList arrayList;
        Assertions.g(!this.f7048j.d());
        int i3 = i2;
        loop0: while (true) {
            arrayList = this.n;
            if (i3 >= arrayList.size()) {
                i3 = -1;
                break;
            }
            int i4 = i3;
            while (true) {
                if (i4 >= arrayList.size()) {
                    HlsMediaChunk hlsMediaChunk = (HlsMediaChunk) arrayList.get(i3);
                    for (int i5 = 0; i5 < this.v.length; i5++) {
                        if (this.v[i5].p() > hlsMediaChunk.g(i5)) {
                            break;
                        }
                    }
                    break loop0;
                }
                if (((HlsMediaChunk) arrayList.get(i4)).n) {
                    break;
                } else {
                    i4++;
                }
            }
            i3++;
        }
        if (i3 == -1) {
            return;
        }
        long j2 = y().f7862h;
        HlsMediaChunk hlsMediaChunk2 = (HlsMediaChunk) arrayList.get(i3);
        Util.Y(i3, arrayList.size(), arrayList);
        for (int i6 = 0; i6 < this.v.length; i6++) {
            this.v[i6].l(hlsMediaChunk2.g(i6));
        }
        if (arrayList.isEmpty()) {
            this.Z = this.Y;
        } else {
            ((HlsMediaChunk) Iterables.c(arrayList)).J = true;
        }
        this.C0 = false;
        this.f7049k.m(new MediaLoadData(1, this.A, null, 3, null, Util.j0(hlsMediaChunk2.f7861g), Util.j0(j2)));
    }

    public final HlsMediaChunk y() {
        return (HlsMediaChunk) android.support.v4.media.b.c(1, this.n);
    }
}
