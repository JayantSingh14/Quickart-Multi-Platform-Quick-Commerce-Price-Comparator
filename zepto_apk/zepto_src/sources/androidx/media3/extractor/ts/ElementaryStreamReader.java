package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ts.TsPayloadReader;

@UnstableApi
/* loaded from: classes3.dex */
public interface ElementaryStreamReader {
    void a(ParsableByteArray parsableByteArray);

    void c();

    void d(boolean z);

    void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator);

    void f(int i2, long j2);
}
