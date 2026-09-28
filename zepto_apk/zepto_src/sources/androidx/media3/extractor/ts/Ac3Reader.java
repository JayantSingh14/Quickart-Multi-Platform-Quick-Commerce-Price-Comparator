package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;

@UnstableApi
/* loaded from: classes3.dex */
public final class Ac3Reader implements ElementaryStreamReader {

    /* renamed from: a, reason: collision with root package name */
    public final ParsableBitArray f9487a;

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f9488b;

    /* renamed from: c, reason: collision with root package name */
    public final String f9489c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9490d;

    /* renamed from: e, reason: collision with root package name */
    public String f9491e;

    /* renamed from: f, reason: collision with root package name */
    public TrackOutput f9492f;

    /* renamed from: g, reason: collision with root package name */
    public int f9493g;

    /* renamed from: h, reason: collision with root package name */
    public int f9494h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f9495i;

    /* renamed from: j, reason: collision with root package name */
    public long f9496j;

    /* renamed from: k, reason: collision with root package name */
    public Format f9497k;

    /* renamed from: l, reason: collision with root package name */
    public int f9498l;

    /* renamed from: m, reason: collision with root package name */
    public long f9499m;

    public Ac3Reader() {
        this(null, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x02bf  */
    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(androidx.media3.common.util.ParsableByteArray r23) {
        /*
            Method dump skipped, instructions count: 957
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.Ac3Reader.a(androidx.media3.common.util.ParsableByteArray):void");
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void c() {
        this.f9493g = 0;
        this.f9494h = 0;
        this.f9495i = false;
        this.f9499m = -9223372036854775807L;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void d(boolean z) {
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        trackIdGenerator.b();
        this.f9491e = trackIdGenerator.f9814e;
        trackIdGenerator.b();
        this.f9492f = extractorOutput.n(trackIdGenerator.f9813d, 1);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void f(int i2, long j2) {
        this.f9499m = j2;
    }

    public Ac3Reader(String str, int i2) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[128], 128);
        this.f9487a = parsableBitArray;
        this.f9488b = new ParsableByteArray(parsableBitArray.f5716a);
        this.f9493g = 0;
        this.f9499m = -9223372036854775807L;
        this.f9489c = str;
        this.f9490d = i2;
    }
}
