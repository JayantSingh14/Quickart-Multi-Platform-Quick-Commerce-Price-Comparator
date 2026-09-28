package androidx.media3.extractor.ts;

import android.util.SparseArray;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.container.ParsableNalUnitBitArray;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;

@UnstableApi
/* loaded from: classes3.dex */
public final class H264Reader implements ElementaryStreamReader {

    /* renamed from: a, reason: collision with root package name */
    public final SeiReader f9603a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f9604b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f9605c;

    /* renamed from: g, reason: collision with root package name */
    public long f9609g;

    /* renamed from: i, reason: collision with root package name */
    public String f9611i;

    /* renamed from: j, reason: collision with root package name */
    public TrackOutput f9612j;

    /* renamed from: k, reason: collision with root package name */
    public SampleReader f9613k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f9614l;
    public boolean n;

    /* renamed from: h, reason: collision with root package name */
    public final boolean[] f9610h = new boolean[3];

    /* renamed from: d, reason: collision with root package name */
    public final NalUnitTargetBuffer f9606d = new NalUnitTargetBuffer(7);

    /* renamed from: e, reason: collision with root package name */
    public final NalUnitTargetBuffer f9607e = new NalUnitTargetBuffer(8);

    /* renamed from: f, reason: collision with root package name */
    public final NalUnitTargetBuffer f9608f = new NalUnitTargetBuffer(6);

    /* renamed from: m, reason: collision with root package name */
    public long f9615m = -9223372036854775807L;
    public final ParsableByteArray o = new ParsableByteArray();

    public static final class SampleReader {

        /* renamed from: a, reason: collision with root package name */
        public final TrackOutput f9616a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f9617b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f9618c;

        /* renamed from: f, reason: collision with root package name */
        public final ParsableNalUnitBitArray f9621f;

        /* renamed from: g, reason: collision with root package name */
        public byte[] f9622g;

        /* renamed from: h, reason: collision with root package name */
        public int f9623h;

        /* renamed from: i, reason: collision with root package name */
        public int f9624i;

        /* renamed from: j, reason: collision with root package name */
        public long f9625j;

        /* renamed from: l, reason: collision with root package name */
        public long f9627l;
        public long p;
        public long q;
        public boolean r;
        public boolean s;

        /* renamed from: d, reason: collision with root package name */
        public final SparseArray f9619d = new SparseArray();

        /* renamed from: e, reason: collision with root package name */
        public final SparseArray f9620e = new SparseArray();

        /* renamed from: m, reason: collision with root package name */
        public SliceHeaderData f9628m = new SliceHeaderData();
        public SliceHeaderData n = new SliceHeaderData();

        /* renamed from: k, reason: collision with root package name */
        public boolean f9626k = false;
        public boolean o = false;

        public static final class SliceHeaderData {

            /* renamed from: a, reason: collision with root package name */
            public boolean f9629a;

            /* renamed from: b, reason: collision with root package name */
            public boolean f9630b;

            /* renamed from: c, reason: collision with root package name */
            public NalUnitUtil.SpsData f9631c;

            /* renamed from: d, reason: collision with root package name */
            public int f9632d;

            /* renamed from: e, reason: collision with root package name */
            public int f9633e;

            /* renamed from: f, reason: collision with root package name */
            public int f9634f;

            /* renamed from: g, reason: collision with root package name */
            public int f9635g;

            /* renamed from: h, reason: collision with root package name */
            public boolean f9636h;

            /* renamed from: i, reason: collision with root package name */
            public boolean f9637i;

            /* renamed from: j, reason: collision with root package name */
            public boolean f9638j;

            /* renamed from: k, reason: collision with root package name */
            public boolean f9639k;

            /* renamed from: l, reason: collision with root package name */
            public int f9640l;

            /* renamed from: m, reason: collision with root package name */
            public int f9641m;
            public int n;
            public int o;
            public int p;
        }

        public SampleReader(TrackOutput trackOutput, boolean z, boolean z2) {
            this.f9616a = trackOutput;
            this.f9617b = z;
            this.f9618c = z2;
            byte[] bArr = new byte[128];
            this.f9622g = bArr;
            this.f9621f = new ParsableNalUnitBitArray(bArr, 0, 0);
            SliceHeaderData sliceHeaderData = this.n;
            sliceHeaderData.f9630b = false;
            sliceHeaderData.f9629a = false;
        }

        public final void a() {
            boolean z;
            int i2;
            boolean z2 = false;
            if (this.f9617b) {
                SliceHeaderData sliceHeaderData = this.n;
                z = sliceHeaderData.f9630b && ((i2 = sliceHeaderData.f9633e) == 7 || i2 == 2);
            } else {
                z = this.s;
            }
            boolean z3 = this.r;
            int i3 = this.f9624i;
            if (i3 == 5 || (z && i3 == 1)) {
                z2 = true;
            }
            this.r = z3 | z2;
        }
    }

    public H264Reader(SeiReader seiReader, boolean z, boolean z2) {
        this.f9603a = seiReader;
        this.f9604b = z;
        this.f9605c = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x025d  */
    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(androidx.media3.common.util.ParsableByteArray r30) {
        /*
            Method dump skipped, instructions count: 730
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.H264Reader.a(androidx.media3.common.util.ParsableByteArray):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(int r18, byte[] r19, int r20) {
        /*
            Method dump skipped, instructions count: 395
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.H264Reader.b(int, byte[], int):void");
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void c() {
        this.f9609g = 0L;
        this.n = false;
        this.f9615m = -9223372036854775807L;
        NalUnitUtil.a(this.f9610h);
        this.f9606d.c();
        this.f9607e.c();
        this.f9608f.c();
        SampleReader sampleReader = this.f9613k;
        if (sampleReader != null) {
            sampleReader.f9626k = false;
            sampleReader.o = false;
            SampleReader.SliceHeaderData sliceHeaderData = sampleReader.n;
            sliceHeaderData.f9630b = false;
            sliceHeaderData.f9629a = false;
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void d(boolean z) {
        Assertions.h(this.f9612j);
        int i2 = Util.f5744a;
        if (z) {
            SampleReader sampleReader = this.f9613k;
            long j2 = this.f9609g;
            sampleReader.a();
            sampleReader.f9625j = j2;
            long j3 = sampleReader.q;
            if (j3 != -9223372036854775807L) {
                boolean z2 = sampleReader.r;
                sampleReader.f9616a.f(j3, z2 ? 1 : 0, (int) (j2 - sampleReader.p), 0, null);
            }
            sampleReader.o = false;
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        trackIdGenerator.b();
        this.f9611i = trackIdGenerator.f9814e;
        trackIdGenerator.b();
        TrackOutput trackOutputN = extractorOutput.n(trackIdGenerator.f9813d, 2);
        this.f9612j = trackOutputN;
        this.f9613k = new SampleReader(trackOutputN, this.f9604b, this.f9605c);
        this.f9603a.a(extractorOutput, trackIdGenerator);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void f(int i2, long j2) {
        this.f9615m = j2;
        this.n = ((i2 & 2) != 0) | this.n;
    }
}
