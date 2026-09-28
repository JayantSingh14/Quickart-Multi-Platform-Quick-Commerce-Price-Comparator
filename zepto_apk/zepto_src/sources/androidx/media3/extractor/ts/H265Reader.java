package androidx.media3.extractor.ts;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;

@UnstableApi
/* loaded from: classes3.dex */
public final class H265Reader implements ElementaryStreamReader {

    /* renamed from: a, reason: collision with root package name */
    public final SeiReader f9642a;

    /* renamed from: b, reason: collision with root package name */
    public String f9643b;

    /* renamed from: c, reason: collision with root package name */
    public TrackOutput f9644c;

    /* renamed from: d, reason: collision with root package name */
    public SampleReader f9645d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9646e;

    /* renamed from: l, reason: collision with root package name */
    public long f9653l;

    /* renamed from: f, reason: collision with root package name */
    public final boolean[] f9647f = new boolean[3];

    /* renamed from: g, reason: collision with root package name */
    public final NalUnitTargetBuffer f9648g = new NalUnitTargetBuffer(32);

    /* renamed from: h, reason: collision with root package name */
    public final NalUnitTargetBuffer f9649h = new NalUnitTargetBuffer(33);

    /* renamed from: i, reason: collision with root package name */
    public final NalUnitTargetBuffer f9650i = new NalUnitTargetBuffer(34);

    /* renamed from: j, reason: collision with root package name */
    public final NalUnitTargetBuffer f9651j = new NalUnitTargetBuffer(39);

    /* renamed from: k, reason: collision with root package name */
    public final NalUnitTargetBuffer f9652k = new NalUnitTargetBuffer(40);

    /* renamed from: m, reason: collision with root package name */
    public long f9654m = -9223372036854775807L;
    public final ParsableByteArray n = new ParsableByteArray();

    public static final class SampleReader {

        /* renamed from: a, reason: collision with root package name */
        public final TrackOutput f9655a;

        /* renamed from: b, reason: collision with root package name */
        public long f9656b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f9657c;

        /* renamed from: d, reason: collision with root package name */
        public int f9658d;

        /* renamed from: e, reason: collision with root package name */
        public long f9659e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f9660f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f9661g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f9662h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f9663i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f9664j;

        /* renamed from: k, reason: collision with root package name */
        public long f9665k;

        /* renamed from: l, reason: collision with root package name */
        public long f9666l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f9667m;

        public SampleReader(TrackOutput trackOutput) {
            this.f9655a = trackOutput;
        }

        public final void a(int i2) {
            long j2 = this.f9666l;
            if (j2 == -9223372036854775807L) {
                return;
            }
            boolean z = this.f9667m;
            this.f9655a.f(j2, z ? 1 : 0, (int) (this.f9656b - this.f9665k), i2, null);
        }
    }

    public H265Reader(SeiReader seiReader) {
        this.f9642a = seiReader;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x020d A[SYNTHETIC] */
    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(androidx.media3.common.util.ParsableByteArray r28) {
        /*
            Method dump skipped, instructions count: 547
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.H265Reader.a(androidx.media3.common.util.ParsableByteArray):void");
    }

    public final void b(int i2, byte[] bArr, int i3) {
        SampleReader sampleReader = this.f9645d;
        if (sampleReader.f9660f) {
            int i4 = sampleReader.f9658d;
            int i5 = (i2 + 2) - i4;
            if (i5 < i3) {
                sampleReader.f9661g = (bArr[i5] & 128) != 0;
                sampleReader.f9660f = false;
            } else {
                sampleReader.f9658d = (i3 - i2) + i4;
            }
        }
        if (!this.f9646e) {
            this.f9648g.a(i2, bArr, i3);
            this.f9649h.a(i2, bArr, i3);
            this.f9650i.a(i2, bArr, i3);
        }
        this.f9651j.a(i2, bArr, i3);
        this.f9652k.a(i2, bArr, i3);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void c() {
        this.f9653l = 0L;
        this.f9654m = -9223372036854775807L;
        NalUnitUtil.a(this.f9647f);
        this.f9648g.c();
        this.f9649h.c();
        this.f9650i.c();
        this.f9651j.c();
        this.f9652k.c();
        SampleReader sampleReader = this.f9645d;
        if (sampleReader != null) {
            sampleReader.f9660f = false;
            sampleReader.f9661g = false;
            sampleReader.f9662h = false;
            sampleReader.f9663i = false;
            sampleReader.f9664j = false;
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void d(boolean z) {
        Assertions.h(this.f9644c);
        int i2 = Util.f5744a;
        if (z) {
            SampleReader sampleReader = this.f9645d;
            long j2 = this.f9653l;
            sampleReader.f9667m = sampleReader.f9657c;
            sampleReader.a((int) (j2 - sampleReader.f9656b));
            sampleReader.f9665k = sampleReader.f9656b;
            sampleReader.f9656b = j2;
            sampleReader.a(0);
            sampleReader.f9663i = false;
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        trackIdGenerator.b();
        this.f9643b = trackIdGenerator.f9814e;
        trackIdGenerator.b();
        TrackOutput trackOutputN = extractorOutput.n(trackIdGenerator.f9813d, 2);
        this.f9644c = trackOutputN;
        this.f9645d = new SampleReader(trackOutputN);
        this.f9642a.a(extractorOutput, trackIdGenerator);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void f(int i2, long j2) {
        this.f9654m = j2;
    }
}
