package androidx.media3.extractor.ts;

import android.support.v4.media.a;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class AdtsReader implements ElementaryStreamReader {
    public static final byte[] w = {73, 68, 51};

    /* renamed from: a, reason: collision with root package name */
    public final boolean f9525a;

    /* renamed from: d, reason: collision with root package name */
    public final String f9528d;

    /* renamed from: e, reason: collision with root package name */
    public final int f9529e;

    /* renamed from: f, reason: collision with root package name */
    public String f9530f;

    /* renamed from: g, reason: collision with root package name */
    public TrackOutput f9531g;

    /* renamed from: h, reason: collision with root package name */
    public TrackOutput f9532h;

    /* renamed from: l, reason: collision with root package name */
    public boolean f9536l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9537m;
    public int p;
    public boolean q;
    public int s;
    public TrackOutput u;
    public long v;

    /* renamed from: b, reason: collision with root package name */
    public final ParsableBitArray f9526b = new ParsableBitArray(new byte[7], 7);

    /* renamed from: c, reason: collision with root package name */
    public final ParsableByteArray f9527c = new ParsableByteArray(Arrays.copyOf(w, 10));

    /* renamed from: i, reason: collision with root package name */
    public int f9533i = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f9534j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f9535k = 256;
    public int n = -1;
    public int o = -1;
    public long r = -9223372036854775807L;
    public long t = -9223372036854775807L;

    public AdtsReader(String str, int i2, boolean z) {
        this.f9525a = z;
        this.f9528d = str;
        this.f9529e = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x021d, code lost:
    
        r11 = -1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(androidx.media3.common.util.ParsableByteArray r24) throws androidx.media3.common.ParserException {
        /*
            Method dump skipped, instructions count: 823
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.AdtsReader.a(androidx.media3.common.util.ParsableByteArray):void");
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void c() {
        this.t = -9223372036854775807L;
        this.f9537m = false;
        this.f9533i = 0;
        this.f9534j = 0;
        this.f9535k = 256;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void d(boolean z) {
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        trackIdGenerator.b();
        this.f9530f = trackIdGenerator.f9814e;
        trackIdGenerator.b();
        TrackOutput trackOutputN = extractorOutput.n(trackIdGenerator.f9813d, 1);
        this.f9531g = trackOutputN;
        this.u = trackOutputN;
        if (!this.f9525a) {
            this.f9532h = new DiscardingTrackOutput();
            return;
        }
        trackIdGenerator.a();
        trackIdGenerator.b();
        TrackOutput trackOutputN2 = extractorOutput.n(trackIdGenerator.f9813d, 5);
        this.f9532h = trackOutputN2;
        Format.Builder builder = new Format.Builder();
        trackIdGenerator.b();
        builder.f5226a = trackIdGenerator.f9814e;
        builder.f5237l = MimeTypes.p("application/id3");
        a.s(builder, trackOutputN2);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void f(int i2, long j2) {
        this.t = j2;
    }
}
