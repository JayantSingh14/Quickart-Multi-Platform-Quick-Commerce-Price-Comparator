package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ts.TsPayloadReader;

@UnstableApi
/* loaded from: classes3.dex */
public final class SectionReader implements TsPayloadReader {

    /* renamed from: a, reason: collision with root package name */
    public final SectionPayloadReader f9764a;

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f9765b = new ParsableByteArray(32);

    /* renamed from: c, reason: collision with root package name */
    public int f9766c;

    /* renamed from: d, reason: collision with root package name */
    public int f9767d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9768e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f9769f;

    public SectionReader(SectionPayloadReader sectionPayloadReader) {
        this.f9764a = sectionPayloadReader;
    }

    @Override // androidx.media3.extractor.ts.TsPayloadReader
    public final void a(int i2, ParsableByteArray parsableByteArray) {
        boolean z = (i2 & 1) != 0;
        int iX = z ? parsableByteArray.f5724b + parsableByteArray.x() : -1;
        if (this.f9769f) {
            if (!z) {
                return;
            }
            this.f9769f = false;
            parsableByteArray.J(iX);
            this.f9767d = 0;
        }
        while (parsableByteArray.a() > 0) {
            int i3 = this.f9767d;
            ParsableByteArray parsableByteArray2 = this.f9765b;
            if (i3 < 3) {
                if (i3 == 0) {
                    int iX2 = parsableByteArray.x();
                    parsableByteArray.J(parsableByteArray.f5724b - 1);
                    if (iX2 == 255) {
                        this.f9769f = true;
                        return;
                    }
                }
                int iMin = Math.min(parsableByteArray.a(), 3 - this.f9767d);
                parsableByteArray.h(this.f9767d, parsableByteArray2.f5723a, iMin);
                int i4 = this.f9767d + iMin;
                this.f9767d = i4;
                if (i4 == 3) {
                    parsableByteArray2.J(0);
                    parsableByteArray2.I(3);
                    parsableByteArray2.K(1);
                    int iX3 = parsableByteArray2.x();
                    int iX4 = parsableByteArray2.x();
                    this.f9768e = (iX3 & 128) != 0;
                    int i5 = (((iX3 & 15) << 8) | iX4) + 3;
                    this.f9766c = i5;
                    byte[] bArr = parsableByteArray2.f5723a;
                    if (bArr.length < i5) {
                        parsableByteArray2.c(Math.min(4098, Math.max(i5, bArr.length * 2)));
                    }
                }
            } else {
                int iMin2 = Math.min(parsableByteArray.a(), this.f9766c - this.f9767d);
                parsableByteArray.h(this.f9767d, parsableByteArray2.f5723a, iMin2);
                int i6 = this.f9767d + iMin2;
                this.f9767d = i6;
                int i7 = this.f9766c;
                if (i6 != i7) {
                    continue;
                } else {
                    if (!this.f9768e) {
                        parsableByteArray2.I(i7);
                    } else {
                        if (Util.n(0, i7, parsableByteArray2.f5723a, -1) != 0) {
                            this.f9769f = true;
                            return;
                        }
                        parsableByteArray2.I(this.f9766c - 4);
                    }
                    parsableByteArray2.J(0);
                    this.f9764a.a(parsableByteArray2);
                    this.f9767d = 0;
                }
            }
        }
    }

    @Override // androidx.media3.extractor.ts.TsPayloadReader
    public final void b(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.f9764a.b(timestampAdjuster, extractorOutput, trackIdGenerator);
        this.f9769f = true;
    }

    @Override // androidx.media3.extractor.ts.TsPayloadReader
    public final void c() {
        this.f9769f = true;
    }
}
