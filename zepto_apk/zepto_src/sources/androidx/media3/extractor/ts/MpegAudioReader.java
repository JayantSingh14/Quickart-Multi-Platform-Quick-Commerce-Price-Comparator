package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;

@UnstableApi
/* loaded from: classes3.dex */
public final class MpegAudioReader implements ElementaryStreamReader {

    /* renamed from: a, reason: collision with root package name */
    public final ParsableByteArray f9687a;

    /* renamed from: b, reason: collision with root package name */
    public final MpegAudioUtil.Header f9688b;

    /* renamed from: c, reason: collision with root package name */
    public final String f9689c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9690d;

    /* renamed from: e, reason: collision with root package name */
    public TrackOutput f9691e;

    /* renamed from: f, reason: collision with root package name */
    public String f9692f;

    /* renamed from: g, reason: collision with root package name */
    public int f9693g;

    /* renamed from: h, reason: collision with root package name */
    public int f9694h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f9695i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9696j;

    /* renamed from: k, reason: collision with root package name */
    public long f9697k;

    /* renamed from: l, reason: collision with root package name */
    public int f9698l;

    /* renamed from: m, reason: collision with root package name */
    public long f9699m;

    public MpegAudioReader() {
        this(null, 0);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void a(ParsableByteArray parsableByteArray) {
        Assertions.h(this.f9691e);
        while (parsableByteArray.a() > 0) {
            int i2 = this.f9693g;
            ParsableByteArray parsableByteArray2 = this.f9687a;
            if (i2 == 0) {
                byte[] bArr = parsableByteArray.f5723a;
                int i3 = parsableByteArray.f5724b;
                int i4 = parsableByteArray.f5725c;
                while (true) {
                    if (i3 >= i4) {
                        parsableByteArray.J(i4);
                        break;
                    }
                    byte b2 = bArr[i3];
                    boolean z = (b2 & 255) == 255;
                    boolean z2 = this.f9696j && (b2 & 224) == 224;
                    this.f9696j = z;
                    if (z2) {
                        parsableByteArray.J(i3 + 1);
                        this.f9696j = false;
                        parsableByteArray2.f5723a[1] = bArr[i3];
                        this.f9694h = 2;
                        this.f9693g = 1;
                        break;
                    }
                    i3++;
                }
            } else if (i2 == 1) {
                int iMin = Math.min(parsableByteArray.a(), 4 - this.f9694h);
                parsableByteArray.h(this.f9694h, parsableByteArray2.f5723a, iMin);
                int i5 = this.f9694h + iMin;
                this.f9694h = i5;
                if (i5 >= 4) {
                    parsableByteArray2.J(0);
                    int iJ = parsableByteArray2.j();
                    MpegAudioUtil.Header header = this.f9688b;
                    if (header.a(iJ)) {
                        this.f9698l = header.f8594c;
                        if (!this.f9695i) {
                            this.f9697k = (header.f8598g * 1000000) / header.f8595d;
                            Format.Builder builder = new Format.Builder();
                            builder.f5226a = this.f9692f;
                            builder.f5237l = MimeTypes.p(header.f8593b);
                            builder.f5238m = 4096;
                            builder.z = header.f8596e;
                            builder.A = header.f8595d;
                            builder.f5229d = this.f9689c;
                            builder.f5231f = this.f9690d;
                            this.f9691e.b(new Format(builder));
                            this.f9695i = true;
                        }
                        parsableByteArray2.J(0);
                        this.f9691e.e(4, parsableByteArray2);
                        this.f9693g = 2;
                    } else {
                        this.f9694h = 0;
                        this.f9693g = 1;
                    }
                }
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException();
                }
                int iMin2 = Math.min(parsableByteArray.a(), this.f9698l - this.f9694h);
                this.f9691e.e(iMin2, parsableByteArray);
                int i6 = this.f9694h + iMin2;
                this.f9694h = i6;
                if (i6 >= this.f9698l) {
                    Assertions.g(this.f9699m != -9223372036854775807L);
                    this.f9691e.f(this.f9699m, 1, this.f9698l, 0, null);
                    this.f9699m += this.f9697k;
                    this.f9694h = 0;
                    this.f9693g = 0;
                }
            }
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void c() {
        this.f9693g = 0;
        this.f9694h = 0;
        this.f9696j = false;
        this.f9699m = -9223372036854775807L;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void d(boolean z) {
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        trackIdGenerator.b();
        this.f9692f = trackIdGenerator.f9814e;
        trackIdGenerator.b();
        this.f9691e = extractorOutput.n(trackIdGenerator.f9813d, 1);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void f(int i2, long j2) {
        this.f9699m = j2;
    }

    public MpegAudioReader(String str, int i2) {
        this.f9693g = 0;
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        this.f9687a = parsableByteArray;
        parsableByteArray.f5723a[0] = -1;
        this.f9688b = new MpegAudioUtil.Header();
        this.f9699m = -9223372036854775807L;
        this.f9689c = str;
        this.f9690d = i2;
    }
}
