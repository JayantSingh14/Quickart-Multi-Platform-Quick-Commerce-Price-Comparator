package androidx.media3.exoplayer.hls;

import android.net.Uri;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.metadata.id3.Id3Decoder;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import java.io.EOFException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
final class HlsMediaChunk extends MediaChunk {
    public static final AtomicInteger L = new AtomicInteger();
    public final boolean A;
    public final boolean B;
    public HlsMediaChunkExtractor C;
    public HlsSampleStreamWrapper D;
    public int E;
    public boolean F;
    public volatile boolean G;
    public boolean H;
    public ImmutableList I;
    public boolean J;
    public boolean K;

    /* renamed from: k, reason: collision with root package name */
    public final int f7002k;

    /* renamed from: l, reason: collision with root package name */
    public final int f7003l;

    /* renamed from: m, reason: collision with root package name */
    public final Uri f7004m;
    public final boolean n;
    public final int o;
    public final DataSource p;
    public final DataSpec q;
    public final HlsMediaChunkExtractor r;
    public final boolean s;
    public final boolean t;
    public final TimestampAdjuster u;
    public final DefaultHlsExtractorFactory v;
    public final List w;
    public final DrmInitData x;
    public final Id3Decoder y;
    public final ParsableByteArray z;

    public HlsMediaChunk(DefaultHlsExtractorFactory defaultHlsExtractorFactory, DataSource dataSource, DataSpec dataSpec, Format format, boolean z, DataSource dataSource2, DataSpec dataSpec2, boolean z2, Uri uri, List list, int i2, Object obj, long j2, long j3, long j4, int i3, boolean z3, int i4, boolean z4, boolean z5, TimestampAdjuster timestampAdjuster, DrmInitData drmInitData, HlsMediaChunkExtractor hlsMediaChunkExtractor, Id3Decoder id3Decoder, ParsableByteArray parsableByteArray, boolean z6, PlayerId playerId) {
        super(dataSource, dataSpec, format, i2, obj, j2, j3, j4);
        this.A = z;
        this.o = i3;
        this.K = z3;
        this.f7003l = i4;
        this.q = dataSpec2;
        this.p = dataSource2;
        this.F = dataSpec2 != null;
        this.B = z2;
        this.f7004m = uri;
        this.s = z5;
        this.u = timestampAdjuster;
        this.t = z4;
        this.v = defaultHlsExtractorFactory;
        this.w = list;
        this.x = drmInitData;
        this.r = hlsMediaChunkExtractor;
        this.y = id3Decoder;
        this.z = parsableByteArray;
        this.n = z6;
        this.I = ImmutableList.r();
        this.f7002k = L.getAndIncrement();
    }

    public static byte[] f(String str) {
        if (Ascii.b(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
    public final void a() {
        HlsMediaChunkExtractor hlsMediaChunkExtractor;
        this.D.getClass();
        if (this.C == null && (hlsMediaChunkExtractor = this.r) != null && hlsMediaChunkExtractor.e()) {
            this.C = this.r;
            this.F = false;
        }
        if (this.F) {
            DataSource dataSource = this.p;
            dataSource.getClass();
            DataSpec dataSpec = this.q;
            dataSpec.getClass();
            e(dataSource, dataSpec, this.B, false);
            this.E = 0;
            this.F = false;
        }
        if (this.G) {
            return;
        }
        if (!this.t) {
            e(this.f7863i, this.f7856b, this.A, true);
        }
        this.H = !this.G;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
    public final void b() {
        this.G = true;
    }

    @Override // androidx.media3.exoplayer.source.chunk.MediaChunk
    public final boolean d() {
        throw null;
    }

    public final void e(DataSource dataSource, DataSpec dataSpec, boolean z, boolean z2) {
        DataSpec dataSpecD;
        long j2;
        long j3;
        if (z) {
            z = this.E != 0;
            dataSpecD = dataSpec;
        } else {
            dataSpecD = dataSpec.d(this.E);
        }
        try {
            DefaultExtractorInput defaultExtractorInputH = h(dataSource, dataSpecD, z2);
            if (z) {
                defaultExtractorInputH.i(this.E);
            }
            while (!this.G && this.C.a(defaultExtractorInputH)) {
                try {
                    try {
                    } catch (EOFException e2) {
                        if ((this.f7858d.f5218f & 16384) == 0) {
                            throw e2;
                        }
                        this.C.d();
                        j2 = defaultExtractorInputH.f8519d;
                        j3 = dataSpec.f5856f;
                    }
                } catch (Throwable th) {
                    this.E = (int) (defaultExtractorInputH.f8519d - dataSpec.f5856f);
                    throw th;
                }
            }
            j2 = defaultExtractorInputH.f8519d;
            j3 = dataSpec.f5856f;
            this.E = (int) (j2 - j3);
        } finally {
            DataSourceUtil.a(dataSource);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int g(int i2) {
        Assertions.g(!this.n);
        if (i2 >= this.I.size()) {
            return 0;
        }
        return ((Integer) this.I.get(i2)).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0208  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.media3.extractor.DefaultExtractorInput h(androidx.media3.datasource.DataSource r35, androidx.media3.datasource.DataSpec r36, boolean r37) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 844
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.HlsMediaChunk.h(androidx.media3.datasource.DataSource, androidx.media3.datasource.DataSpec, boolean):androidx.media3.extractor.DefaultExtractorInput");
    }
}
