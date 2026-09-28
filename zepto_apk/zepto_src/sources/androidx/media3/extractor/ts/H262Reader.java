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
public final class H262Reader implements ElementaryStreamReader {
    public static final double[] q = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a, reason: collision with root package name */
    public String f9559a;

    /* renamed from: b, reason: collision with root package name */
    public TrackOutput f9560b;

    /* renamed from: c, reason: collision with root package name */
    public final UserDataReader f9561c;

    /* renamed from: d, reason: collision with root package name */
    public final ParsableByteArray f9562d;

    /* renamed from: e, reason: collision with root package name */
    public final NalUnitTargetBuffer f9563e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean[] f9564f;

    /* renamed from: g, reason: collision with root package name */
    public final CsdBuffer f9565g;

    /* renamed from: h, reason: collision with root package name */
    public long f9566h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f9567i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9568j;

    /* renamed from: k, reason: collision with root package name */
    public long f9569k;

    /* renamed from: l, reason: collision with root package name */
    public long f9570l;

    /* renamed from: m, reason: collision with root package name */
    public long f9571m;
    public long n;
    public boolean o;
    public boolean p;

    public static final class CsdBuffer {

        /* renamed from: e, reason: collision with root package name */
        public static final byte[] f9572e = {0, 0, 1};

        /* renamed from: a, reason: collision with root package name */
        public boolean f9573a;

        /* renamed from: b, reason: collision with root package name */
        public int f9574b;

        /* renamed from: c, reason: collision with root package name */
        public int f9575c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f9576d;

        public final void a(int i2, byte[] bArr, int i3) {
            if (this.f9573a) {
                int i4 = i3 - i2;
                byte[] bArr2 = this.f9576d;
                int length = bArr2.length;
                int i5 = this.f9574b + i4;
                if (length < i5) {
                    this.f9576d = Arrays.copyOf(bArr2, i5 * 2);
                }
                System.arraycopy(bArr, i2, this.f9576d, this.f9574b, i4);
                this.f9574b += i4;
            }
        }
    }

    public H262Reader() {
        this(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0197  */
    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(androidx.media3.common.util.ParsableByteArray r29) {
        /*
            Method dump skipped, instructions count: 526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.H262Reader.a(androidx.media3.common.util.ParsableByteArray):void");
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void c() {
        NalUnitUtil.a(this.f9564f);
        CsdBuffer csdBuffer = this.f9565g;
        csdBuffer.f9573a = false;
        csdBuffer.f9574b = 0;
        csdBuffer.f9575c = 0;
        NalUnitTargetBuffer nalUnitTargetBuffer = this.f9563e;
        if (nalUnitTargetBuffer != null) {
            nalUnitTargetBuffer.c();
        }
        this.f9566h = 0L;
        this.f9567i = false;
        this.f9570l = -9223372036854775807L;
        this.n = -9223372036854775807L;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void d(boolean z) {
        Assertions.h(this.f9560b);
        if (z) {
            boolean z2 = this.o;
            this.f9560b.f(this.n, z2 ? 1 : 0, (int) (this.f9566h - this.f9571m), 0, null);
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        trackIdGenerator.b();
        this.f9559a = trackIdGenerator.f9814e;
        trackIdGenerator.b();
        this.f9560b = extractorOutput.n(trackIdGenerator.f9813d, 2);
        UserDataReader userDataReader = this.f9561c;
        if (userDataReader != null) {
            userDataReader.b(extractorOutput, trackIdGenerator);
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void f(int i2, long j2) {
        this.f9570l = j2;
    }

    public H262Reader(UserDataReader userDataReader) {
        this.f9561c = userDataReader;
        this.f9564f = new boolean[4];
        CsdBuffer csdBuffer = new CsdBuffer();
        csdBuffer.f9576d = new byte[128];
        this.f9565g = csdBuffer;
        if (userDataReader != null) {
            this.f9563e = new NalUnitTargetBuffer(178);
            this.f9562d = new ParsableByteArray();
        } else {
            this.f9563e = null;
            this.f9562d = null;
        }
        this.f9570l = -9223372036854775807L;
        this.n = -9223372036854775807L;
    }
}
