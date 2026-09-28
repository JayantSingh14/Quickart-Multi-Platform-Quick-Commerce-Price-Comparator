package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.MpeghUtil;
import androidx.media3.extractor.ts.TsPayloadReader;

@UnstableApi
/* loaded from: classes3.dex */
public final class MpeghReader implements ElementaryStreamReader {

    /* renamed from: e, reason: collision with root package name */
    public String f9704e;

    /* renamed from: f, reason: collision with root package name */
    public TrackOutput f9705f;

    /* renamed from: i, reason: collision with root package name */
    public boolean f9708i;

    /* renamed from: k, reason: collision with root package name */
    public int f9710k;

    /* renamed from: l, reason: collision with root package name */
    public int f9711l;
    public int n;
    public int o;
    public int s;
    public boolean u;

    /* renamed from: d, reason: collision with root package name */
    public int f9703d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final ParsableByteArray f9700a = new ParsableByteArray(new byte[15], 2);

    /* renamed from: b, reason: collision with root package name */
    public final ParsableBitArray f9701b = new ParsableBitArray();

    /* renamed from: c, reason: collision with root package name */
    public final ParsableByteArray f9702c = new ParsableByteArray();
    public final MpeghUtil.MhasPacketHeader p = new MpeghUtil.MhasPacketHeader();
    public int q = -2147483647;
    public int r = -1;
    public long t = -1;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9709j = true;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9712m = true;

    /* renamed from: g, reason: collision with root package name */
    public double f9706g = -9.223372036854776E18d;

    /* renamed from: h, reason: collision with root package name */
    public double f9707h = -9.223372036854776E18d;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0414  */
    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(androidx.media3.common.util.ParsableByteArray r24) throws androidx.media3.common.ParserException {
        /*
            Method dump skipped, instructions count: 1362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.MpeghReader.a(androidx.media3.common.util.ParsableByteArray):void");
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void c() {
        this.f9703d = 0;
        this.f9711l = 0;
        this.f9700a.G(2);
        this.n = 0;
        this.o = 0;
        this.q = -2147483647;
        this.r = -1;
        this.s = 0;
        this.t = -1L;
        this.u = false;
        this.f9708i = false;
        this.f9712m = true;
        this.f9709j = true;
        this.f9706g = -9.223372036854776E18d;
        this.f9707h = -9.223372036854776E18d;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void d(boolean z) {
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        trackIdGenerator.b();
        this.f9704e = trackIdGenerator.f9814e;
        trackIdGenerator.b();
        this.f9705f = extractorOutput.n(trackIdGenerator.f9813d, 1);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void f(int i2, long j2) {
        this.f9710k = i2;
        if (!this.f9709j && (this.o != 0 || !this.f9712m)) {
            this.f9708i = true;
        }
        if (j2 != -9223372036854775807L) {
            if (this.f9708i) {
                this.f9707h = j2;
            } else {
                this.f9706g = j2;
            }
        }
    }
}
