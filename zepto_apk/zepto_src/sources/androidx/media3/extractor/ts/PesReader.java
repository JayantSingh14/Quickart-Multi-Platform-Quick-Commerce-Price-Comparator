package androidx.media3.extractor.ts;

import android.support.v4.media.a;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ts.TsPayloadReader;

@UnstableApi
/* loaded from: classes3.dex */
public final class PesReader implements TsPayloadReader {

    /* renamed from: a, reason: collision with root package name */
    public final ElementaryStreamReader f9724a;

    /* renamed from: b, reason: collision with root package name */
    public final ParsableBitArray f9725b = new ParsableBitArray(new byte[10], 10);

    /* renamed from: c, reason: collision with root package name */
    public int f9726c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f9727d;

    /* renamed from: e, reason: collision with root package name */
    public TimestampAdjuster f9728e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f9729f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f9730g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f9731h;

    /* renamed from: i, reason: collision with root package name */
    public int f9732i;

    /* renamed from: j, reason: collision with root package name */
    public int f9733j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f9734k;

    /* renamed from: l, reason: collision with root package name */
    public long f9735l;

    public PesReader(ElementaryStreamReader elementaryStreamReader) {
        this.f9724a = elementaryStreamReader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [androidx.media3.common.util.ParsableBitArray] */
    /* JADX WARN: Type inference failed for: r3v0, types: [androidx.media3.extractor.ts.ElementaryStreamReader] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    @Override // androidx.media3.extractor.ts.TsPayloadReader
    public final void a(int i2, ParsableByteArray parsableByteArray) {
        int i3;
        int i4;
        int i5;
        Assertions.h(this.f9728e);
        int i6 = i2 & 1;
        ?? r3 = this.f9724a;
        int i7 = 2;
        ?? r9 = 0;
        if (i6 != 0) {
            int i8 = this.f9726c;
            if (i8 != 0 && i8 != 1) {
                if (i8 == 2) {
                    Log.h("PesReader", "Unexpected start indicator reading extended header");
                } else {
                    if (i8 != 3) {
                        throw new IllegalStateException();
                    }
                    if (this.f9733j != -1) {
                        Log.h("PesReader", "Unexpected start indicator: expected " + this.f9733j + " more bytes");
                    }
                    r3.d(parsableByteArray.f5725c == 0);
                }
            }
            this.f9726c = 1;
            this.f9727d = 0;
        }
        int i9 = i2;
        while (parsableByteArray.a() > 0) {
            int i10 = this.f9726c;
            if (i10 != 0) {
                ?? r11 = this.f9725b;
                if (i10 != 1) {
                    if (i10 == i7) {
                        if (d(parsableByteArray, r11.f5716a, Math.min(10, this.f9732i)) && d(parsableByteArray, null, this.f9732i)) {
                            r11.m(r9);
                            this.f9735l = -9223372036854775807L;
                            if (this.f9729f) {
                                r11.o(4);
                                r11.o(1);
                                r11.o(1);
                                long jG = (r11.g(15) << 15) | (r11.g(3) << 30) | r11.g(15);
                                r11.o(1);
                                if (!this.f9731h && this.f9730g) {
                                    r11.o(4);
                                    r11.o(1);
                                    r11.o(1);
                                    r11.o(1);
                                    this.f9728e.b((r11.g(3) << 30) | (r11.g(15) << 15) | r11.g(15));
                                    this.f9731h = true;
                                }
                                this.f9735l = this.f9728e.b(jG);
                            }
                            i9 |= this.f9734k ? 4 : 0;
                            r3.f(i9, this.f9735l);
                            this.f9726c = 3;
                            this.f9727d = 0;
                            r9 = 0;
                            i7 = 2;
                        }
                    } else {
                        if (i10 != 3) {
                            throw new IllegalStateException();
                        }
                        int iA = parsableByteArray.a();
                        int i11 = this.f9733j;
                        int i12 = i11 == -1 ? r9 : iA - i11;
                        if (i12 > 0) {
                            iA -= i12;
                            parsableByteArray.I(parsableByteArray.f5724b + iA);
                        }
                        r3.a(parsableByteArray);
                        int i13 = this.f9733j;
                        if (i13 != -1) {
                            int i14 = i13 - iA;
                            this.f9733j = i14;
                            if (i14 == 0) {
                                r3.d(r9);
                                this.f9726c = 1;
                                this.f9727d = r9;
                            }
                        }
                    }
                    i3 = i7;
                    i4 = r9;
                } else {
                    i4 = r9;
                    if (d(parsableByteArray, r11.f5716a, 9)) {
                        r11.m(i4);
                        int iG = r11.g(24);
                        if (iG != 1) {
                            a.r(iG, "Unexpected start code prefix: ", "PesReader");
                            this.f9733j = -1;
                            i5 = 0;
                            i3 = 2;
                        } else {
                            r11.o(8);
                            int iG2 = r11.g(16);
                            r11.o(5);
                            this.f9734k = r11.f();
                            i3 = 2;
                            r11.o(2);
                            this.f9729f = r11.f();
                            this.f9730g = r11.f();
                            r11.o(6);
                            int iG3 = r11.g(8);
                            this.f9732i = iG3;
                            if (iG2 == 0) {
                                this.f9733j = -1;
                            } else {
                                int i15 = (iG2 - 3) - iG3;
                                this.f9733j = i15;
                                if (i15 < 0) {
                                    Log.h("PesReader", "Found negative packet payload size: " + this.f9733j);
                                    this.f9733j = -1;
                                }
                            }
                            i5 = 2;
                        }
                        this.f9726c = i5;
                        i4 = 0;
                        this.f9727d = 0;
                    } else {
                        i3 = 2;
                    }
                }
            } else {
                i3 = i7;
                i4 = r9;
                parsableByteArray.K(parsableByteArray.a());
            }
            r9 = i4;
            i7 = i3;
        }
    }

    @Override // androidx.media3.extractor.ts.TsPayloadReader
    public final void b(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.f9728e = timestampAdjuster;
        this.f9724a.e(extractorOutput, trackIdGenerator);
    }

    @Override // androidx.media3.extractor.ts.TsPayloadReader
    public final void c() {
        this.f9726c = 0;
        this.f9727d = 0;
        this.f9731h = false;
        this.f9724a.c();
    }

    public final boolean d(ParsableByteArray parsableByteArray, byte[] bArr, int i2) {
        int iMin = Math.min(parsableByteArray.a(), i2 - this.f9727d);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            parsableByteArray.K(iMin);
        } else {
            parsableByteArray.h(this.f9727d, bArr, iMin);
        }
        int i3 = this.f9727d + iMin;
        this.f9727d = i3;
        return i3 == i2;
    }
}
