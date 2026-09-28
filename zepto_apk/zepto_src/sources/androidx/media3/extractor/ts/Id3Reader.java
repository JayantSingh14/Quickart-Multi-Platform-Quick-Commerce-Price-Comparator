package androidx.media3.extractor.ts;

import android.support.v4.media.a;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;

@UnstableApi
/* loaded from: classes3.dex */
public final class Id3Reader implements ElementaryStreamReader {

    /* renamed from: b, reason: collision with root package name */
    public TrackOutput f9669b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9670c;

    /* renamed from: e, reason: collision with root package name */
    public int f9672e;

    /* renamed from: f, reason: collision with root package name */
    public int f9673f;

    /* renamed from: a, reason: collision with root package name */
    public final ParsableByteArray f9668a = new ParsableByteArray(10);

    /* renamed from: d, reason: collision with root package name */
    public long f9671d = -9223372036854775807L;

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void a(ParsableByteArray parsableByteArray) {
        Assertions.h(this.f9669b);
        if (this.f9670c) {
            int iA = parsableByteArray.a();
            int i2 = this.f9673f;
            if (i2 < 10) {
                int iMin = Math.min(iA, 10 - i2);
                byte[] bArr = parsableByteArray.f5723a;
                int i3 = parsableByteArray.f5724b;
                ParsableByteArray parsableByteArray2 = this.f9668a;
                System.arraycopy(bArr, i3, parsableByteArray2.f5723a, this.f9673f, iMin);
                if (this.f9673f + iMin == 10) {
                    parsableByteArray2.J(0);
                    if (73 != parsableByteArray2.x() || 68 != parsableByteArray2.x() || 51 != parsableByteArray2.x()) {
                        Log.h("Id3Reader", "Discarding invalid ID3 tag");
                        this.f9670c = false;
                        return;
                    } else {
                        parsableByteArray2.K(3);
                        this.f9672e = parsableByteArray2.w() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iA, this.f9672e - this.f9673f);
            this.f9669b.e(iMin2, parsableByteArray);
            this.f9673f += iMin2;
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void c() {
        this.f9670c = false;
        this.f9671d = -9223372036854775807L;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void d(boolean z) {
        int i2;
        Assertions.h(this.f9669b);
        if (this.f9670c && (i2 = this.f9672e) != 0 && this.f9673f == i2) {
            Assertions.g(this.f9671d != -9223372036854775807L);
            this.f9669b.f(this.f9671d, 1, this.f9672e, 0, null);
            this.f9670c = false;
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        trackIdGenerator.b();
        TrackOutput trackOutputN = extractorOutput.n(trackIdGenerator.f9813d, 5);
        this.f9669b = trackOutputN;
        Format.Builder builder = new Format.Builder();
        trackIdGenerator.b();
        builder.f5226a = trackIdGenerator.f9814e;
        builder.f5237l = MimeTypes.p("application/id3");
        a.s(builder, trackOutputN);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void f(int i2, long j2) {
        if ((i2 & 4) == 0) {
            return;
        }
        this.f9670c = true;
        this.f9671d = j2;
        this.f9672e = 0;
        this.f9673f = 0;
    }
}
