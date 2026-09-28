package androidx.media3.exoplayer.hls;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.UriUtil;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.hls.playlist.DefaultHlsPlaylistTracker;
import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import androidx.media3.exoplayer.source.BehindLiveWindowException;
import androidx.media3.exoplayer.source.chunk.BaseMediaChunkIterator;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.source.chunk.DataChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import androidx.media3.exoplayer.trackselection.BaseTrackSelection;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
class HlsChunkSource {

    /* renamed from: a, reason: collision with root package name */
    public final DefaultHlsExtractorFactory f6978a;

    /* renamed from: b, reason: collision with root package name */
    public final DataSource f6979b;

    /* renamed from: c, reason: collision with root package name */
    public final DataSource f6980c;

    /* renamed from: d, reason: collision with root package name */
    public final TimestampAdjusterProvider f6981d;

    /* renamed from: e, reason: collision with root package name */
    public final Uri[] f6982e;

    /* renamed from: f, reason: collision with root package name */
    public final Format[] f6983f;

    /* renamed from: g, reason: collision with root package name */
    public final DefaultHlsPlaylistTracker f6984g;

    /* renamed from: h, reason: collision with root package name */
    public final TrackGroup f6985h;

    /* renamed from: i, reason: collision with root package name */
    public final List f6986i;

    /* renamed from: k, reason: collision with root package name */
    public final PlayerId f6988k;

    /* renamed from: l, reason: collision with root package name */
    public final CmcdConfiguration f6989l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f6990m;
    public BehindLiveWindowException o;
    public Uri p;
    public boolean q;
    public ExoTrackSelection r;
    public boolean t;
    public long u = -9223372036854775807L;

    /* renamed from: j, reason: collision with root package name */
    public final FullSegmentEncryptionKeyCache f6987j = new FullSegmentEncryptionKeyCache();
    public byte[] n = Util.f5749f;
    public long s = -9223372036854775807L;

    public static final class EncryptionKeyChunk extends DataChunk {

        /* renamed from: l, reason: collision with root package name */
        public byte[] f6991l;

        @Override // androidx.media3.exoplayer.source.chunk.DataChunk
        public final void c(int i2, byte[] bArr) {
            this.f6991l = Arrays.copyOf(bArr, i2);
        }
    }

    public static final class HlsChunkHolder {

        /* renamed from: a, reason: collision with root package name */
        public Chunk f6992a = null;

        /* renamed from: b, reason: collision with root package name */
        public boolean f6993b = false;

        /* renamed from: c, reason: collision with root package name */
        public Uri f6994c = null;
    }

    @VisibleForTesting
    public static final class HlsMediaPlaylistSegmentIterator extends BaseMediaChunkIterator {

        /* renamed from: e, reason: collision with root package name */
        public final List f6995e;

        /* renamed from: f, reason: collision with root package name */
        public final long f6996f;

        public HlsMediaPlaylistSegmentIterator(long j2, List list) {
            super(0L, list.size() - 1);
            this.f6996f = j2;
            this.f6995e = list;
        }

        @Override // androidx.media3.exoplayer.source.chunk.MediaChunkIterator
        public final long a() {
            c();
            return this.f6996f + ((HlsMediaPlaylist.SegmentBase) this.f6995e.get((int) this.f7833d)).f7142e;
        }

        @Override // androidx.media3.exoplayer.source.chunk.MediaChunkIterator
        public final long b() {
            c();
            HlsMediaPlaylist.SegmentBase segmentBase = (HlsMediaPlaylist.SegmentBase) this.f6995e.get((int) this.f7833d);
            return this.f6996f + segmentBase.f7142e + segmentBase.f7140c;
        }
    }

    public static final class InitializationTrackSelection extends BaseTrackSelection {

        /* renamed from: g, reason: collision with root package name */
        public int f6997g;

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final int d() {
            return this.f6997g;
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final void g(long j2, long j3, long j4, List list, MediaChunkIterator[] mediaChunkIteratorArr) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (b(this.f6997g, jElapsedRealtime)) {
                for (int i2 = this.f7969b - 1; i2 >= 0; i2--) {
                    if (!b(i2, jElapsedRealtime)) {
                        this.f6997g = i2;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final Object j() {
            return null;
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final int s() {
            return 0;
        }
    }

    public static final class SegmentBaseHolder {

        /* renamed from: a, reason: collision with root package name */
        public final HlsMediaPlaylist.SegmentBase f6998a;

        /* renamed from: b, reason: collision with root package name */
        public final long f6999b;

        /* renamed from: c, reason: collision with root package name */
        public final int f7000c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f7001d;

        public SegmentBaseHolder(HlsMediaPlaylist.SegmentBase segmentBase, long j2, int i2) {
            this.f6998a = segmentBase;
            this.f6999b = j2;
            this.f7000c = i2;
            this.f7001d = (segmentBase instanceof HlsMediaPlaylist.Part) && ((HlsMediaPlaylist.Part) segmentBase).f7132m;
        }
    }

    public HlsChunkSource(DefaultHlsExtractorFactory defaultHlsExtractorFactory, DefaultHlsPlaylistTracker defaultHlsPlaylistTracker, Uri[] uriArr, Format[] formatArr, DefaultHlsDataSourceFactory defaultHlsDataSourceFactory, TransferListener transferListener, TimestampAdjusterProvider timestampAdjusterProvider, List list, PlayerId playerId, CmcdConfiguration cmcdConfiguration) {
        this.f6978a = defaultHlsExtractorFactory;
        this.f6984g = defaultHlsPlaylistTracker;
        this.f6982e = uriArr;
        this.f6983f = formatArr;
        this.f6981d = timestampAdjusterProvider;
        this.f6986i = list;
        this.f6988k = playerId;
        this.f6989l = cmcdConfiguration;
        DataSource dataSourceA = defaultHlsDataSourceFactory.f6973a.a();
        this.f6979b = dataSourceA;
        if (transferListener != null) {
            dataSourceA.a(transferListener);
        }
        this.f6980c = defaultHlsDataSourceFactory.f6973a.a();
        this.f6985h = new TrackGroup("", formatArr);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < uriArr.length; i2++) {
            if ((formatArr[i2].f5218f & 16384) == 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        TrackGroup trackGroup = this.f6985h;
        int[] iArrG = Ints.g(arrayList);
        InitializationTrackSelection initializationTrackSelection = new InitializationTrackSelection(trackGroup, iArrG);
        initializationTrackSelection.f6997g = initializationTrackSelection.c(trackGroup.f5504d[iArrG[0]]);
        this.r = initializationTrackSelection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static SegmentBaseHolder d(HlsMediaPlaylist hlsMediaPlaylist, long j2, int i2) {
        int i3 = (int) (j2 - hlsMediaPlaylist.f7128k);
        ImmutableList immutableList = hlsMediaPlaylist.r;
        int size = immutableList.size();
        ImmutableList immutableList2 = hlsMediaPlaylist.s;
        if (i3 == size) {
            if (i2 == -1) {
                i2 = 0;
            }
            if (i2 < immutableList2.size()) {
                return new SegmentBaseHolder((HlsMediaPlaylist.SegmentBase) immutableList2.get(i2), j2, i2);
            }
            return null;
        }
        HlsMediaPlaylist.Segment segment = (HlsMediaPlaylist.Segment) immutableList.get(i3);
        if (i2 == -1) {
            return new SegmentBaseHolder(segment, j2, -1);
        }
        if (i2 < segment.f7137m.size()) {
            return new SegmentBaseHolder((HlsMediaPlaylist.SegmentBase) segment.f7137m.get(i2), j2, i2);
        }
        int i4 = i3 + 1;
        if (i4 < immutableList.size()) {
            return new SegmentBaseHolder((HlsMediaPlaylist.SegmentBase) immutableList.get(i4), j2 + 1, -1);
        }
        if (immutableList2.isEmpty()) {
            return null;
        }
        return new SegmentBaseHolder((HlsMediaPlaylist.SegmentBase) immutableList2.get(0), j2 + 1, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.media3.exoplayer.source.chunk.MediaChunkIterator[] a(androidx.media3.exoplayer.hls.HlsMediaChunk r17, long r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r8 = -1
            if (r1 != 0) goto L9
            r9 = r8
            goto L12
        L9:
            androidx.media3.common.TrackGroup r2 = r0.f6985h
            androidx.media3.common.Format r3 = r1.f7858d
            int r2 = r2.c(r3)
            r9 = r2
        L12:
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r2 = r0.r
            int r10 = r2.length()
            androidx.media3.exoplayer.source.chunk.MediaChunkIterator[] r11 = new androidx.media3.exoplayer.source.chunk.MediaChunkIterator[r10]
            r12 = 0
            r13 = r12
        L1c:
            if (r13 >= r10) goto Le3
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r2 = r0.r
            int r2 = r2.f(r13)
            android.net.Uri[] r3 = r0.f6982e
            r3 = r3[r2]
            androidx.media3.exoplayer.hls.playlist.DefaultHlsPlaylistTracker r4 = r0.f6984g
            boolean r5 = r4.e(r3)
            if (r5 != 0) goto L36
            androidx.media3.exoplayer.source.chunk.MediaChunkIterator r2 = androidx.media3.exoplayer.source.chunk.MediaChunkIterator.f7891a
            r11[r13] = r2
            goto Ldb
        L36:
            androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist r3 = r4.c(r12, r3)
            r3.getClass()
            long r4 = r4.n
            long r6 = r3.f7125h
            long r4 = r6 - r4
            if (r2 == r9) goto L49
            r2 = 1
        L46:
            r6 = r18
            goto L4b
        L49:
            r2 = r12
            goto L46
        L4b:
            android.util.Pair r2 = r0.c(r1, r2, r3, r4, r6)
            java.lang.Object r0 = r2.first
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            java.lang.Object r2 = r2.second
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            androidx.media3.exoplayer.hls.HlsChunkSource$HlsMediaPlaylistSegmentIterator r6 = new androidx.media3.exoplayer.hls.HlsChunkSource$HlsMediaPlaylistSegmentIterator
            long r14 = r3.f7128k
            long r0 = r0 - r14
            int r0 = (int) r0
            if (r0 < 0) goto Ld2
            com.google.common.collect.ImmutableList r1 = r3.r
            int r7 = r1.size()
            if (r7 >= r0) goto L70
            goto Ld2
        L70:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            int r14 = r1.size()
            if (r0 >= r14) goto Lac
            if (r2 == r8) goto La0
            java.lang.Object r14 = r1.get(r0)
            androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$Segment r14 = (androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist.Segment) r14
            if (r2 != 0) goto L89
            r7.add(r14)
            goto L9e
        L89:
            com.google.common.collect.ImmutableList r15 = r14.f7137m
            int r15 = r15.size()
            if (r2 >= r15) goto L9e
            com.google.common.collect.ImmutableList r14 = r14.f7137m
            int r15 = r14.size()
            java.util.List r2 = r14.subList(r2, r15)
            r7.addAll(r2)
        L9e:
            int r0 = r0 + 1
        La0:
            int r2 = r1.size()
            java.util.List r0 = r1.subList(r0, r2)
            r7.addAll(r0)
            r2 = r12
        Lac:
            long r0 = r3.n
            r14 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r14 ? 1 : (r0 == r14 ? 0 : -1))
            if (r0 == 0) goto Lcd
            if (r2 != r8) goto Lba
            r2 = r12
        Lba:
            com.google.common.collect.ImmutableList r0 = r3.s
            int r1 = r0.size()
            if (r2 >= r1) goto Lcd
            int r1 = r0.size()
            java.util.List r0 = r0.subList(r2, r1)
            r7.addAll(r0)
        Lcd:
            java.util.List r0 = java.util.Collections.unmodifiableList(r7)
            goto Ld6
        Ld2:
            com.google.common.collect.ImmutableList r0 = com.google.common.collect.ImmutableList.r()
        Ld6:
            r6.<init>(r4, r0)
            r11[r13] = r6
        Ldb:
            int r13 = r13 + 1
            r0 = r16
            r1 = r17
            goto L1c
        Le3:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.HlsChunkSource.a(androidx.media3.exoplayer.hls.HlsMediaChunk, long):androidx.media3.exoplayer.source.chunk.MediaChunkIterator[]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int b(HlsMediaChunk hlsMediaChunk) {
        if (hlsMediaChunk.o == -1) {
            return 1;
        }
        HlsMediaPlaylist hlsMediaPlaylistC = this.f6984g.c(false, this.f6982e[this.f6985h.c(hlsMediaChunk.f7858d)]);
        hlsMediaPlaylistC.getClass();
        int i2 = (int) (hlsMediaChunk.f7890j - hlsMediaPlaylistC.f7128k);
        if (i2 < 0) {
            return 1;
        }
        ImmutableList immutableList = hlsMediaPlaylistC.r;
        ImmutableList immutableList2 = i2 < immutableList.size() ? ((HlsMediaPlaylist.Segment) immutableList.get(i2)).f7137m : hlsMediaPlaylistC.s;
        int size = immutableList2.size();
        int i3 = hlsMediaChunk.o;
        if (i3 >= size) {
            return 2;
        }
        HlsMediaPlaylist.Part part = (HlsMediaPlaylist.Part) immutableList2.get(i3);
        if (part.f7132m) {
            return 0;
        }
        return Util.a(Uri.parse(UriUtil.d(hlsMediaPlaylistC.f7173a, part.f7138a)), hlsMediaChunk.f7856b.f5851a) ? 1 : 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Pair c(HlsMediaChunk hlsMediaChunk, boolean z, HlsMediaPlaylist hlsMediaPlaylist, long j2, long j3) {
        if (hlsMediaChunk != null && !z) {
            boolean z2 = hlsMediaChunk.H;
            long jC = hlsMediaChunk.f7890j;
            int i2 = hlsMediaChunk.o;
            if (!z2) {
                return new Pair(Long.valueOf(jC), Integer.valueOf(i2));
            }
            if (i2 == -1) {
                jC = hlsMediaChunk.c();
            }
            return new Pair(Long.valueOf(jC), Integer.valueOf(i2 != -1 ? i2 + 1 : -1));
        }
        long j4 = hlsMediaPlaylist.u + j2;
        if (hlsMediaChunk != null && !this.q) {
            j3 = hlsMediaChunk.f7861g;
        }
        boolean z3 = hlsMediaPlaylist.o;
        long j5 = hlsMediaPlaylist.f7128k;
        ImmutableList immutableList = hlsMediaPlaylist.r;
        if (!z3 && j3 >= j4) {
            return new Pair(Long.valueOf(j5 + immutableList.size()), -1);
        }
        long j6 = j3 - j2;
        int i3 = 0;
        int iD = Util.d(immutableList, Long.valueOf(j6), true, !this.f6984g.f7105m || hlsMediaChunk == null);
        long j7 = iD + j5;
        if (iD >= 0) {
            HlsMediaPlaylist.Segment segment = (HlsMediaPlaylist.Segment) immutableList.get(iD);
            long j8 = segment.f7142e + segment.f7140c;
            ImmutableList immutableList2 = hlsMediaPlaylist.s;
            ImmutableList immutableList3 = j6 < j8 ? segment.f7137m : immutableList2;
            while (true) {
                if (i3 >= immutableList3.size()) {
                    break;
                }
                HlsMediaPlaylist.Part part = (HlsMediaPlaylist.Part) immutableList3.get(i3);
                if (j6 >= part.f7142e + part.f7140c) {
                    i3++;
                } else if (part.f7131l) {
                    j7 += immutableList3 == immutableList2 ? 1L : 0L;
                    i = i3;
                }
            }
        }
        return new Pair(Long.valueOf(j7), Integer.valueOf(i));
    }

    public final Chunk e(Uri uri, int i2, boolean z, CmcdData.Factory factory) {
        if (uri == null) {
            return null;
        }
        FullSegmentEncryptionKeyCache fullSegmentEncryptionKeyCache = this.f6987j;
        byte[] bArr = (byte[]) fullSegmentEncryptionKeyCache.f6977a.remove(uri);
        if (bArr != null) {
            return null;
        }
        DataSpec.Builder builder = new DataSpec.Builder();
        builder.f5860a = uri;
        builder.f5868i = 1;
        DataSpec dataSpecA = builder.a();
        if (factory != null) {
            if (z) {
                factory.f8127j = "i";
            }
            dataSpecA = factory.a().a(dataSpecA);
        }
        DataSpec dataSpec = dataSpecA;
        Format format = this.f6983f[i2];
        int iS = this.r.s();
        Object objJ = this.r.j();
        byte[] bArr2 = this.n;
        EncryptionKeyChunk encryptionKeyChunk = new EncryptionKeyChunk(this.f6980c, dataSpec, 3, format, iS, objJ, -9223372036854775807L, -9223372036854775807L);
        if (bArr2 == null) {
            bArr2 = Util.f5749f;
        }
        encryptionKeyChunk.f7884j = bArr2;
        return encryptionKeyChunk;
    }
}
