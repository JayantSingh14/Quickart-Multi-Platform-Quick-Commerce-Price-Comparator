package androidx.media3.extractor.ts;

import android.support.v4.media.a;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public final class SeiReader {

    /* renamed from: a, reason: collision with root package name */
    public final List f9770a;

    /* renamed from: b, reason: collision with root package name */
    public final TrackOutput[] f9771b;

    public SeiReader(List list) {
        this.f9770a = list;
        this.f9771b = new TrackOutput[list.size()];
    }

    public final void a(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        int i2 = 0;
        while (true) {
            TrackOutput[] trackOutputArr = this.f9771b;
            if (i2 >= trackOutputArr.length) {
                return;
            }
            trackIdGenerator.a();
            trackIdGenerator.b();
            TrackOutput trackOutputN = extractorOutput.n(trackIdGenerator.f9813d, 3);
            Format format = (Format) this.f9770a.get(i2);
            String str = format.f5225m;
            Assertions.b("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption MIME type provided: " + str);
            String str2 = format.f5213a;
            if (str2 == null) {
                trackIdGenerator.b();
                str2 = trackIdGenerator.f9814e;
            }
            Format.Builder builder = new Format.Builder();
            builder.f5226a = str2;
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
