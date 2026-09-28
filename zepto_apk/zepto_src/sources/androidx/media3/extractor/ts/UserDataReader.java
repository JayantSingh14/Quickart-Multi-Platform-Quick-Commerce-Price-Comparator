package androidx.media3.extractor.ts;

import android.support.v4.media.a;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.CeaUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.List;

/* loaded from: classes3.dex */
final class UserDataReader {

    /* renamed from: a, reason: collision with root package name */
    public final List f9815a;

    /* renamed from: b, reason: collision with root package name */
    public final TrackOutput[] f9816b;

    public UserDataReader(List list) {
        this.f9815a = list;
        this.f9816b = new TrackOutput[list.size()];
    }

    public final void a(long j2, ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() < 9) {
            return;
        }
        int iJ = parsableByteArray.j();
        int iJ2 = parsableByteArray.j();
        int iX = parsableByteArray.x();
        if (iJ == 434 && iJ2 == 1195456820 && iX == 3) {
            CeaUtil.b(j2, parsableByteArray, this.f9816b);
        }
    }

    public final void b(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        int i2 = 0;
        while (true) {
            TrackOutput[] trackOutputArr = this.f9816b;
            if (i2 >= trackOutputArr.length) {
                return;
            }
            trackIdGenerator.a();
            trackIdGenerator.b();
            TrackOutput trackOutputN = extractorOutput.n(trackIdGenerator.f9813d, 3);
            Format format = (Format) this.f9815a.get(i2);
            String str = format.f5225m;
            Assertions.b("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption MIME type provided: " + str);
            Format.Builder builder = new Format.Builder();
            trackIdGenerator.b();
            builder.f5226a = trackIdGenerator.f9814e;
            builder.f5237l = MimeTypes.p(str);
            builder.f5230e = format.f5217e;
            builder.f5229d = format.f5216d;
            builder.E = format.F;
            builder.o = format.p;
            a.s(builder, trackOutputN);
            trackOutputArr[i2] = trackOutputN;
            i2++;
        }
    }
}
