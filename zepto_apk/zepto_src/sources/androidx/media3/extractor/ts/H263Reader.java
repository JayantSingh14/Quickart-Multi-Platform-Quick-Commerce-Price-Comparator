package androidx.media3.extractor.ts;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class H263Reader implements ElementaryStreamReader {

    /* renamed from: l, reason: collision with root package name */
    public static final float[] f9577l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    public final UserDataReader f9578a;

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f9579b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean[] f9580c;

    /* renamed from: d, reason: collision with root package name */
    public final CsdBuffer f9581d;

    /* renamed from: e, reason: collision with root package name */
    public final NalUnitTargetBuffer f9582e;

    /* renamed from: f, reason: collision with root package name */
    public SampleReader f9583f;

    /* renamed from: g, reason: collision with root package name */
    public long f9584g;

    /* renamed from: h, reason: collision with root package name */
    public String f9585h;

    /* renamed from: i, reason: collision with root package name */
    public TrackOutput f9586i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9587j;

    /* renamed from: k, reason: collision with root package name */
    public long f9588k;

    public static final class CsdBuffer {

        /* renamed from: f, reason: collision with root package name */
        public static final byte[] f9589f = {0, 0, 1};

        /* renamed from: a, reason: collision with root package name */
        public boolean f9590a;

        /* renamed from: b, reason: collision with root package name */
        public int f9591b;

        /* renamed from: c, reason: collision with root package name */
        public int f9592c;

        /* renamed from: d, reason: collision with root package name */
        public int f9593d;

        /* renamed from: e, reason: collision with root package name */
        public byte[] f9594e;

        public final void a(int i2, byte[] bArr, int i3) {
            if (this.f9590a) {
                int i4 = i3 - i2;
                byte[] bArr2 = this.f9594e;
                int length = bArr2.length;
                int i5 = this.f9592c + i4;
                if (length < i5) {
                    this.f9594e = Arrays.copyOf(bArr2, i5 * 2);
                }
                System.arraycopy(bArr, i2, this.f9594e, this.f9592c, i4);
                this.f9592c += i4;
            }
        }
    }

    public static final class SampleReader {

        /* renamed from: a, reason: collision with root package name */
        public final TrackOutput f9595a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f9596b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f9597c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f9598d;

        /* renamed from: e, reason: collision with root package name */
        public int f9599e;

        /* renamed from: f, reason: collision with root package name */
        public int f9600f;

        /* renamed from: g, reason: collision with root package name */
        public long f9601g;

        /* renamed from: h, reason: collision with root package name */
        public long f9602h;

        public SampleReader(TrackOutput trackOutput) {
            this.f9595a = trackOutput;
        }

        public final void a(int i2, byte[] bArr, int i3) {
            if (this.f9597c) {
                int i4 = this.f9600f;
                int i5 = (i2 + 1) - i4;
                if (i5 >= i3) {
                    this.f9600f = (i3 - i2) + i4;
                } else {
                    this.f9598d = ((bArr[i5] & 192) >> 6) == 0;
                    this.f9597c = false;
                }
            }
        }

        public final void b(int i2, long j2, boolean z) {
            Assertions.g(this.f9602h != -9223372036854775807L);
            if (this.f9599e == 182 && z && this.f9596b) {
                this.f9595a.f(this.f9602h, this.f9598d ? 1 : 0, (int) (j2 - this.f9601g), i2, null);
            }
            if (this.f9599e != 179) {
                this.f9601g = j2;
            }
        }
    }

    public H263Reader() {
        this(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x024b  */
    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(androidx.media3.common.util.ParsableByteArray r22) {
        /*
            Method dump skipped, instructions count: 616
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.H263Reader.a(androidx.media3.common.util.ParsableByteArray):void");
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void c() {
        NalUnitUtil.a(this.f9580c);
        CsdBuffer csdBuffer = this.f9581d;
        csdBuffer.f9590a = false;
        csdBuffer.f9592c = 0;
        csdBuffer.f9591b = 0;
        SampleReader sampleReader = this.f9583f;
        if (sampleReader != null) {
            sampleReader.f9596b = false;
            sampleReader.f9597c = false;
            sampleReader.f9598d = false;
            sampleReader.f9599e = -1;
        }
        NalUnitTargetBuffer nalUnitTargetBuffer = this.f9582e;
        if (nalUnitTargetBuffer != null) {
            nalUnitTargetBuffer.c();
        }
        this.f9584g = 0L;
        this.f9588k = -9223372036854775807L;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void d(boolean z) {
        Assertions.h(this.f9583f);
        if (z) {
            this.f9583f.b(0, this.f9584g, this.f9587j);
            SampleReader sampleReader = this.f9583f;
            sampleReader.f9596b = false;
            sampleReader.f9597c = false;
            sampleReader.f9598d = false;
            sampleReader.f9599e = -1;
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        trackIdGenerator.b();
        this.f9585h = trackIdGenerator.f9814e;
        trackIdGenerator.b();
        TrackOutput trackOutputN = extractorOutput.n(trackIdGenerator.f9813d, 2);
        this.f9586i = trackOutputN;
        this.f9583f = new SampleReader(trackOutputN);
        UserDataReader userDataReader = this.f9578a;
        if (userDataReader != null) {
            userDataReader.b(extractorOutput, trackIdGenerator);
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void f(int i2, long j2) {
        this.f9588k = j2;
    }

    public H263Reader(UserDataReader userDataReader) {
        this.f9578a = userDataReader;
        this.f9580c = new boolean[4];
        CsdBuffer csdBuffer = new CsdBuffer();
        csdBuffer.f9594e = new byte[128];
        this.f9581d = csdBuffer;
        this.f9588k = -9223372036854775807L;
        if (userDataReader != null) {
            this.f9582e = new NalUnitTargetBuffer(178);
            this.f9579b = new ParsableByteArray();
        } else {
            this.f9582e = null;
            this.f9579b = null;
        }
    }
}
