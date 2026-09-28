package androidx.media3.extractor.ts;

import android.support.v4.media.a;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.Collections;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public final class DvbSubtitleReader implements ElementaryStreamReader {

    /* renamed from: a, reason: collision with root package name */
    public final List f9553a;

    /* renamed from: b, reason: collision with root package name */
    public final TrackOutput[] f9554b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9555c;

    /* renamed from: d, reason: collision with root package name */
    public int f9556d;

    /* renamed from: e, reason: collision with root package name */
    public int f9557e;

    /* renamed from: f, reason: collision with root package name */
    public long f9558f = -9223372036854775807L;

    public DvbSubtitleReader(List list) {
        this.f9553a = list;
        this.f9554b = new TrackOutput[list.size()];
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void a(ParsableByteArray parsableByteArray) {
        boolean z;
        boolean z2;
        if (this.f9555c) {
            if (this.f9556d == 2) {
                if (parsableByteArray.a() == 0) {
                    z2 = false;
                } else {
                    if (parsableByteArray.x() != 32) {
                        this.f9555c = false;
                    }
                    this.f9556d--;
                    z2 = this.f9555c;
                }
                if (!z2) {
                    return;
                }
            }
            if (this.f9556d == 1) {
                if (parsableByteArray.a() == 0) {
                    z = false;
                } else {
                    if (parsableByteArray.x() != 0) {
                        this.f9555c = false;
                    }
                    this.f9556d--;
                    z = this.f9555c;
                }
                if (!z) {
                    return;
                }
            }
            int i2 = parsableByteArray.f5724b;
            int iA = parsableByteArray.a();
            for (TrackOutput trackOutput : this.f9554b) {
                parsableByteArray.J(i2);
                trackOutput.e(iA, parsableByteArray);
            }
            this.f9557e += iA;
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void c() {
        this.f9555c = false;
        this.f9558f = -9223372036854775807L;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void d(boolean z) {
        if (this.f9555c) {
            Assertions.g(this.f9558f != -9223372036854775807L);
            for (TrackOutput trackOutput : this.f9554b) {
                trackOutput.f(this.f9558f, 1, this.f9557e, 0, null);
            }
            this.f9555c = false;
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        int i2 = 0;
        while (true) {
            TrackOutput[] trackOutputArr = this.f9554b;
            if (i2 >= trackOutputArr.length) {
                return;
            }
            TsPayloadReader.DvbSubtitleInfo dvbSubtitleInfo = (TsPayloadReader.DvbSubtitleInfo) this.f9553a.get(i2);
            trackIdGenerator.a();
            trackIdGenerator.b();
            TrackOutput trackOutputN = extractorOutput.n(trackIdGenerator.f9813d, 3);
            Format.Builder builder = new Format.Builder();
            trackIdGenerator.b();
            builder.f5226a = trackIdGenerator.f9814e;
            builder.f5237l = MimeTypes.p("application/dvbsubs");
            builder.o = Collections.singletonList(dvbSubtitleInfo.f9805b);
            builder.f5229d = dvbSubtitleInfo.f9804a;
            a.s(builder, trackOutputN);
            trackOutputArr[i2] = trackOutputN;
            i2++;
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void f(int i2, long j2) {
        if ((i2 & 4) == 0) {
            return;
        }
        this.f9555c = true;
        this.f9558f = j2;
        this.f9557e = 0;
        this.f9556d = 2;
    }
}
