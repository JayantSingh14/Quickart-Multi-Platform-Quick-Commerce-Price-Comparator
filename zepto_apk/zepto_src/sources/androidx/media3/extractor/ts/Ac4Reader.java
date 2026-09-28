package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;

@UnstableApi
/* loaded from: classes3.dex */
public final class Ac4Reader implements ElementaryStreamReader {

    /* renamed from: a, reason: collision with root package name */
    public final ParsableBitArray f9503a;

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f9504b;

    /* renamed from: c, reason: collision with root package name */
    public final String f9505c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9506d;

    /* renamed from: e, reason: collision with root package name */
    public String f9507e;

    /* renamed from: f, reason: collision with root package name */
    public TrackOutput f9508f;

    /* renamed from: g, reason: collision with root package name */
    public int f9509g;

    /* renamed from: h, reason: collision with root package name */
    public int f9510h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f9511i;

    /* renamed from: j, reason: collision with root package name */
    public long f9512j;

    /* renamed from: k, reason: collision with root package name */
    public Format f9513k;

    /* renamed from: l, reason: collision with root package name */
    public int f9514l;

    /* renamed from: m, reason: collision with root package name */
    public long f9515m;

    public Ac4Reader() {
        this(null, 0);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void a(ParsableByteArray parsableByteArray) {
        Assertions.h(this.f9508f);
        while (parsableByteArray.a() > 0) {
            int i2 = this.f9509g;
            ParsableByteArray parsableByteArray2 = this.f9504b;
            if (i2 == 0) {
                while (parsableByteArray.a() > 0) {
                    if (this.f9511i) {
                        int iX = parsableByteArray.x();
                        this.f9511i = iX == 172;
                        if (iX == 64 || iX == 65) {
                            boolean z = iX == 65;
                            this.f9509g = 1;
                            byte[] bArr = parsableByteArray2.f5723a;
                            bArr[0] = -84;
                            bArr[1] = (byte) (z ? 65 : 64);
                            this.f9510h = 2;
                        }
                    } else {
                        this.f9511i = parsableByteArray.x() == 172;
                    }
                }
            } else if (i2 == 1) {
                byte[] bArr2 = parsableByteArray2.f5723a;
                int iMin = Math.min(parsableByteArray.a(), 16 - this.f9510h);
                parsableByteArray.h(this.f9510h, bArr2, iMin);
                int i3 = this.f9510h + iMin;
                this.f9510h = i3;
                if (i3 == 16) {
                    ParsableBitArray parsableBitArray = this.f9503a;
                    parsableBitArray.m(0);
                    Ac4Util.SyncFrameInfo syncFrameInfoB = Ac4Util.b(parsableBitArray);
                    Format format = this.f9513k;
                    int i4 = syncFrameInfoB.f8466a;
                    if (format == null || 2 != format.A || i4 != format.B || !"audio/ac4".equals(format.f5225m)) {
                        Format.Builder builder = new Format.Builder();
                        builder.f5226a = this.f9507e;
                        builder.f5237l = MimeTypes.p("audio/ac4");
                        builder.z = 2;
                        builder.A = i4;
                        builder.f5229d = this.f9505c;
                        builder.f5231f = this.f9506d;
                        Format format2 = new Format(builder);
                        this.f9513k = format2;
                        this.f9508f.b(format2);
                    }
                    this.f9514l = syncFrameInfoB.f8467b;
                    this.f9512j = (syncFrameInfoB.f8468c * 1000000) / this.f9513k.B;
                    parsableByteArray2.J(0);
                    this.f9508f.e(16, parsableByteArray2);
                    this.f9509g = 2;
                }
            } else if (i2 == 2) {
                int iMin2 = Math.min(parsableByteArray.a(), this.f9514l - this.f9510h);
                this.f9508f.e(iMin2, parsableByteArray);
                int i5 = this.f9510h + iMin2;
                this.f9510h = i5;
                if (i5 == this.f9514l) {
                    Assertions.g(this.f9515m != -9223372036854775807L);
                    this.f9508f.f(this.f9515m, 1, this.f9514l, 0, null);
                    this.f9515m += this.f9512j;
                    this.f9509g = 0;
                }
            }
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void c() {
        this.f9509g = 0;
        this.f9510h = 0;
        this.f9511i = false;
        this.f9515m = -9223372036854775807L;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void d(boolean z) {
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        trackIdGenerator.b();
        this.f9507e = trackIdGenerator.f9814e;
        trackIdGenerator.b();
        this.f9508f = extractorOutput.n(trackIdGenerator.f9813d, 1);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void f(int i2, long j2) {
        this.f9515m = j2;
    }

    public Ac4Reader(String str, int i2) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[16], 16);
        this.f9503a = parsableBitArray;
        this.f9504b = new ParsableByteArray(parsableBitArray.f5716a);
        this.f9509g = 0;
        this.f9510h = 0;
        this.f9511i = false;
        this.f9515m = -9223372036854775807L;
        this.f9505c = str;
        this.f9506d = i2;
    }
}
